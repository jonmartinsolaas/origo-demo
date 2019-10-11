package no.martinsolaas.origodemo.domain;

import java.util.Objects;

public class Station {

    private final Integer stationId;
    private final String name;
    private final Integer availableLocks;
    private final Integer availableBikes;

    public Station(Integer stationId, String name, Integer availableLocks, Integer availableBikes) {
        Objects.requireNonNull(stationId, "stationId is missing.");
        Objects.requireNonNull(name, "name is missing.");
        Objects.requireNonNull(availableLocks, "availableLocks is missing.");
        Objects.requireNonNull(availableBikes, "availableBikes is missing.");
        this.stationId = stationId;
        this.name = name;
        this.availableLocks = availableLocks;
        this.availableBikes = availableBikes;
    }

    public int getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailableLocks() {
        return availableLocks;
    }

    public Integer getAvailableBikes() {
        return availableBikes;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                ", availableLocks=" + availableLocks +
                ", availableBikes=" + availableBikes +
                '}';
    }
}
