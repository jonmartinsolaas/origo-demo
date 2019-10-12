package no.martinsolaas.origodemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import no.martinsolaas.origodemo.domain.Station;
import no.martinsolaas.origodemo.restclient.OsloBysykkelRestClient;
import no.martinsolaas.origodemo.restclient.stationinformation.StationInformationDto;
import no.martinsolaas.origodemo.restclient.stationstatus.StationStatusDto;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StationFacade {

    private final OsloBysykkelRestClient osloBysykkelRestClient;

    public StationFacade(@Autowired OsloBysykkelRestClient osloBysykkelRestClient) {
        this.osloBysykkelRestClient = osloBysykkelRestClient;
    }

    @HystrixCommand(fallbackMethod = "defaultStations")
    public List<Station> getStations() {
        List<Station> stationListResult = new ArrayList<>();

        Map<String, StationStatusDto> stationStatusMap = new HashMap<>();
        for (StationStatusDto status : osloBysykkelRestClient.getStationStatus().getStationStatusDtoList().getStationStatusDtos()) {
            stationStatusMap.put(status.getStationId(), status);
        }

        log.debug("Status for {} stations found.", stationStatusMap.size());

        List<StationInformationDto> informationDtoList
                = osloBysykkelRestClient.getStationInformation().getStationInformationDtoList().getStationInformationDtos();

        log.debug("{} stations found.", informationDtoList.size());

        for (StationInformationDto information : informationDtoList) {
            StationStatusDto status = stationStatusMap.get(information.getStationId());

            if (status != null) {
                stationListResult.add(new Station(Integer.parseInt(information.getStationId()), information.getName()
                        , status.getNumDocksAvailable(), status.getNumBikesAvailable()));
            } else {
                log.warn("Status not available for station {}.", information.getStationId());
            }
        }
        return stationListResult;
    }

    public List<Station> defaultStations(Throwable throwable) {
        log.error("Hystrix invoked defaultStations() because of {}.", ExceptionUtils.getRootCauseMessage(throwable));
        log.error(ExceptionUtils.getStackTrace(throwable));
        List<Station> stationListResult = new ArrayList<>();
        stationListResult.add(new Station(-1, "Stations not available.", -1, -1));
        return stationListResult;
    }
}
