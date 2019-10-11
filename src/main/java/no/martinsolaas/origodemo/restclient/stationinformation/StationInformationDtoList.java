package no.martinsolaas.origodemo.restclient.stationinformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "stations"
})
public class StationInformationDtoList {

    @JsonProperty("stations")
    private List<StationInformationDto> stationInformationDtos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stations")
    public List<StationInformationDto> getStationInformationDtos() {
        return stationInformationDtos;
    }

    @JsonProperty("stations")
    public void setStationInformationDtos(List<StationInformationDto> stationInformationDtos) {
        this.stationInformationDtos = stationInformationDtos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
