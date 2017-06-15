package classes;

import classes.City;
import classes.Road;
import interfaces.Graph;
import interfaces.Graph.Edge;
import interfaces.Graph.Vertex;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Towns implements Graph {
    Set<City> cities = new HashSet();
    HashSet<Road> roads = new HashSet();

    public Towns() {
    }

    public void addTown(City townName) {
        this.cities.add(townName);
    }

    public void addRoad(Vertex firstTown, Vertex secondTown, int roaddLength) {
        this.roads.add(new Road(firstTown, secondTown, roaddLength));
    }

    public Vertex getTown(int i) {
        Vertex[] neighbors = (Vertex[])this.cities.toArray(new Vertex[this.cities.size()]);
        return neighbors[i];
    }

    public int getLength(Vertex a, Vertex b) {
        System.out.println("Near " + a.getName() + " near " + b.getName());
        Edge road = (Edge)this.getConnections(a).get(b);
        return road != null?road.getWeight():-3;
    }

    public Set<Vertex> getVertices() {
        HashSet v = new HashSet();
        v.addAll(this.cities);
        return v;
    }

    public Set<Vertex> getNeighbors(Vertex v) {
        HashSet neighbors = new HashSet();
        Iterator var3 = this.roads.iterator();

        while(var3.hasNext()) {
            Road road = (Road)var3.next();
            Vertex nextCityName = null;
            if(road.consistCity(v)) {
                nextCityName = road.nextCity(v);
            }

            Iterator var6 = this.cities.iterator();

            while(var6.hasNext()) {
                City city = (City)var6.next();
                if(city.equals(nextCityName)) {
                    neighbors.add(city);
                }
            }
        }

        return neighbors;
    }

    public Map<Vertex, Edge> getConnections(Vertex v) {
        HashMap connections = new HashMap();
        Iterator var3 = this.roads.iterator();

        while(var3.hasNext()) {
            Road road = (Road)var3.next();
            if(road.consistCity(v)) {
                connections.put(road.nextCity(v), road);
            }
        }

        return connections;
    }
}
