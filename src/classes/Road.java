package classes;

import interfaces.Graph.Edge;
import interfaces.Graph.Vertex;

public class Road implements Edge {
    Vertex fromCity;
    Vertex toCity;
    int length;

    public Road(Vertex fromCity, Vertex toCity, int length) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.length = length;
    }

    public boolean consistCity(Vertex s) {
        boolean result = false;
        if(s.equals(this.fromCity) || s.equals(this.toCity)) {
            result = true;
        }

        return result;
    }

    public Vertex nextCity(Vertex s) {
        Vertex result = null;
        if(s.equals(this.fromCity)) {
            result = this.toCity;
        }

        if(s.equals(this.toCity)) {
            result = this.fromCity;
        }

        return result;
    }

    public int getWeight() {
        return this.length;
    }
}
