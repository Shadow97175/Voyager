package classes;

import interfaces.Graph;

import java.util.*;

public class Towns implements Graph {

    Set<City> cities = new HashSet<>();
    HashSet<Road> roads = new HashSet<>();

    public void addTown(String townName) {
        this.cities.add(new City(townName));
    }

    public void addRoad(String firstTown, String secondTown, int roaddLength) {
        this.roads.add(new Road(firstTown, secondTown, roaddLength));
    }

    //Возвращает все города
    @Override
    public Set<Vertex> getVertices() {
        HashSet<Vertex> v = new HashSet<>();
        v.addAll(cities);
        return v;
    }

    //Возвращает всех соседей заданного города
    @Override
    public Set<Vertex> getNeighbors(Vertex v) {
        HashSet<Vertex> neighbors = new HashSet<>();
        for (Road road : roads) {
            String nextCityName = null;
            if (road.consistCity(v.getName())) nextCityName = road.nextCity(v.getName());
            for (City city : cities) {
                if (city.cityName.equals(nextCityName)) neighbors.add(city);
            }
        }
        return neighbors;
    }

    //Возвращает Map с вершиной и ребрами
    @Override
    public Map<Vertex, Edge> getConnections(Vertex v) {
        HashMap<Vertex, Edge> connections = new HashMap<>();
        for (Road road : roads) {
        }
        return connections;
    }

}
