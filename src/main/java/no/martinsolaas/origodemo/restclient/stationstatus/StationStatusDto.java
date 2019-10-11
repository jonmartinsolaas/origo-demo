package no.martinsolaas.origodemo.restclient.stationstatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_installed",
        "is_renting",
        "num_bikes_available",
        "num_docks_available",
        "last_reported",
        "is_returning",
        "station_id"
})
public class StationStatusDto {

    @JsonProperty("is_installed")
    private Integer isInstalled;
    @JsonProperty("is_renting")
    private Integer isRenting;
    @JsonProperty("num_bikes_available")
    private Integer numBikesAvailable;
    @JsonProperty("num_docks_available")
    private Integer numDocksAvailable;
    @JsonProperty("last_reported")
    private Integer lastReported;
    @JsonProperty("is_returning")
    private Integer isReturning;
    @JsonProperty("station_id")
    private String stationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_installed")
    public Integer getIsInstalled() {
        return isInstalled;
    }

    @JsonProperty("is_installed")
    public void setIsInstalled(Integer isInstalled) {
        this.isInstalled = isInstalled;
    }

    @JsonProperty("is_renting")
    public Integer getIsRenting() {
        return isRenting;
    }

    @JsonProperty("is_renting")
    public void setIsRenting(Integer isRenting) {
        this.isRenting = isRenting;
    }

    @JsonProperty("num_bikes_available")
    public Integer getNumBikesAvailable() {
        return numBikesAvailable;
    }

    @JsonProperty("num_bikes_available")
    public void setNumBikesAvailable(Integer numBikesAvailable) {
        this.numBikesAvailable = numBikesAvailable;
    }

    @JsonProperty("num_docks_available")
    public Integer getNumDocksAvailable() {
        return numDocksAvailable;
    }

    @JsonProperty("num_docks_available")
    public void setNumDocksAvailable(Integer numDocksAvailable) {
        this.numDocksAvailable = numDocksAvailable;
    }

    @JsonProperty("last_reported")
    public Integer getLastReported() {
        return lastReported;
    }

    @JsonProperty("last_reported")
    public void setLastReported(Integer lastReported) {
        this.lastReported = lastReported;
    }

    @JsonProperty("is_returning")
    public Integer getIsReturning() {
        return isReturning;
    }

    @JsonProperty("is_returning")
    public void setIsReturning(Integer isReturning) {
        this.isReturning = isReturning;
    }

    @JsonProperty("station_id")
    public String getStationId() {
        return stationId;
    }

    @JsonProperty("station_id")
    public void setStationId(String stationId) {
        this.stationId = stationId;
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