package no.martinsolaas.origodemo.restclient.stationinformation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "last_updated",
        "data"
})
public class StationInformationResult {

    @JsonProperty("last_updated")
    private Integer lastUpdated;
    @JsonProperty("data")
    private StationInformationDtoList stationInformationDtoList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("last_updated")
    public Integer getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("data")
    public StationInformationDtoList getStationInformationDtoList() {
        return stationInformationDtoList;
    }

    @JsonProperty("data")
    public void setStationInformationDtoList(StationInformationDtoList stationInformationDtoList) {
        this.stationInformationDtoList = stationInformationDtoList;
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
