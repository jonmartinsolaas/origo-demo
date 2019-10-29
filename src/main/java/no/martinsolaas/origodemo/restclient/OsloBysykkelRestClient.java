package no.martinsolaas.origodemo.restclient;

import no.martinsolaas.origodemo.restclient.stationinformation.StationInformationResult;
import no.martinsolaas.origodemo.restclient.stationstatus.StationStatusResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bysykkel", url = "${oslobysykkel-rest.url}")
public interface OsloBysykkelRestClient {

    @RequestMapping(method = RequestMethod.GET
            , headers = {"Client-Identifier: IDENTIFIER"}
            , value = "/station_information.json"
            , consumes = MediaType.APPLICATION_JSON_VALUE
    )
    StationInformationResult getStationInformation();

    @RequestMapping(method = RequestMethod.GET
            , headers = {"Client-Identifier: IDENTIFIER"}
            , value = "/station_status.json"
            , consumes = MediaType.APPLICATION_JSON_VALUE
    )
    StationStatusResult getStationStatus();

}