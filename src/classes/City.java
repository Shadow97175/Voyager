package classes;

import interfaces.Graph;

public class City implements Graph.Vertex {
    String cityName;

    //Конструктор для города
    public City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String getName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }

    @Override
    protected Object clone() {
        return new City(cityName);
    }
}
