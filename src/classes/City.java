package classes;

import interfaces.Graph;

public class City implements Graph.Vertex {
    String cityName;
    //Конструктор для города
    City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String getName() {
        return cityName;
    }
}
