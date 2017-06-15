import classes.City;
import classes.Iskatel;
import classes.Towns;
import interfaces.Graph.Vertex;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Voyager {
    public Voyager() {
    }

    public static void main(String[] args) {
        System.out.println("Start of the Voyager program");
        Towns towns = new Towns();
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");
        City g = new City("G");
        towns.addTown(a);
        towns.addTown(b);
        towns.addTown(c);
        towns.addTown(d);
        towns.addTown(e);
        towns.addTown(f);
        towns.addTown(g);
        towns.addRoad(a, b, 100);
        towns.addRoad(b, d, 60);
        towns.addRoad(b, f, 150);
        towns.addRoad(d, f, 70);
        towns.addRoad(f, g, 120);
        towns.addRoad(a, g, 300);
        towns.addRoad(g, c, 280);
        towns.addRoad(g, e, 100);
        towns.addRoad(c, e, 100);
        towns.addRoad(c, a, 100);
        Set testCities = towns.getVertices();
        System.out.println("Введенные города:");
        Iterator path = testCities.iterator();

        while(path.hasNext()) {
            Vertex vertex = (Vertex)path.next();
            System.out.println(vertex.getName());
        }

        new ArrayList();
        ArrayList path1 = Iskatel.findShortestLoop(towns);
        towns.getLength(a, b);
        System.out.print("Path: ");
        Iterator vertex1 = path1.iterator();

        while(vertex1.hasNext()) {
            Vertex current = (Vertex)vertex1.next();
            System.out.print("" + current.getName());
        }

    }
}
