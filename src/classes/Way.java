package classes;

import interfaces.Graph.Vertex;
import java.util.ArrayList;

public class Way {
    ArrayList<Vertex> path;
    int length;

    public Way() {
        this.path = new ArrayList();
    }

    public Way(int length) {
        this.length = length;
        this.path = new ArrayList();
    }

    public Way(ArrayList<Vertex> cities, int length) {
        this.length = length;
        this.path = cities;
    }

    public ArrayList<Vertex> getPath() {
        return this.path;
    }

    public void setPath(ArrayList<Vertex> path) {
        this.path = path;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addLength(int distance) {
        this.length += distance;
    }

    public void removeLength(int distance) {
        this.length -= distance;
    }

    protected Object clone() {
        return new Way(new ArrayList(this.path), this.length);
    }
}
