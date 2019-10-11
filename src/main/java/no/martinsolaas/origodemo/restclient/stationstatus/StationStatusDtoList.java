package no.martinsolaas.origodemo.restclient.stationstatus;

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
public class StationStatusDtoList {

    @JsonProperty("stations")
    private List<StationStatusDto> stationStatusDtos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stations")
    public List<StationStatusDto> getStationStatusDtos() {
        return stationStatusDtos;
    }

    @JsonProperty("stations")
    public void setStationStatusDtos(List<StationStatusDto> stationStatusDtos) {
        this.stationStatusDtos = stationStatusDtos;
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
