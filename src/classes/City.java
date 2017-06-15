package classes;

import interfaces.Graph.Vertex;

public class City implements Vertex {
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return this.cityName;
    }

    public String toString() {
        return this.cityName;
    }

    protected Object clone() {
        return new City(this.cityName);
    }

    public boolean equals(Object obj) {
        return obj instanceof City?((City)obj).cityName.equals(this.cityName):false;
    }
}
