package no.martinsolaas.origodemo.restclient;

import no.martinsolaas.origodemo.FeignConfiguration;
import no.martinsolaas.origodemo.restclient.stationinformation.StationInformationResult;
import no.martinsolaas.origodemo.restclient.stationstatus.StationStatusResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
Hystrix: https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html

dto pojos created at http://www.jsonschema2pojo.org
 */


@FeignClient(value = "winter"
        , url = "${oslobysykkel-rest.url}"
        , configuration = FeignConfiguration.class)
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