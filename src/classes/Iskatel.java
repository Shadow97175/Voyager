package classes;

import classes.Towns;
import classes.Way;
import interfaces.Graph.Vertex;
import java.util.ArrayList;
import java.util.Set;

public class Iskatel {
    private static final boolean FULL_DEBUG = true;
    public static final int NOT_FOUND = -3;
    private static Way currentOptimalWay = new Way(2147483647);

    public Iskatel() {
    }

    private static ArrayList<Vertex> findOptimalWay(Towns t, Vertex currentTown, Way way, Vertex start) {
        Set neighborsSet = t.getNeighbors(currentTown);
        Vertex[] neighbors = (Vertex[])neighborsSet.toArray(new Vertex[neighborsSet.size()]);
        ArrayList alreadyWas = way.getPath();
        System.out.println("Path = " + alreadyWas.toString());
        System.out.println("Current city = " + currentTown.getName());
        alreadyWas.add(currentTown);
        Vertex[] var7 = neighbors;
        int var8 = neighbors.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Vertex neighbor = var7[var9];
            System.out.println("Current neighbour " + neighbor.getName());
            if(!alreadyWas.contains(neighbor)) {
                System.out.println("Never was in " + neighbor.getName());
                System.out.println("Going to " + neighbor.getName());
                System.out.print("Path to = " + t.getLength(currentTown, neighbor));
                way.addLength(t.getLength(currentTown, neighbor));
                ArrayList path = findOptimalWay(t, neighbor, way, start);
                if(path != null) {
                    return path;
                }

                System.out.println("Removing from path " + neighbor.getName());
                if(alreadyWas.size() == t.getVertices().size() && t.getLength(neighbor, start) != -3) {
                    System.out.println(way.getPath());
                    way.addLength(t.getLength(neighbor, start));
                    System.out.println("Found one way, length = " + way.getLength() + " " + alreadyWas.toString());
                    if(currentOptimalWay.getLength() > way.getLength()) {
                        currentOptimalWay = (Way)way.clone();
                    }

                    way.removeLength(t.getLength(neighbor, start));
                }

                way.removeLength(t.getLength(currentTown, neighbor));
                alreadyWas.remove(neighbor);
            } else {
                System.out.println("Already was in " + neighbor.getName());
            }
        }

        System.out.println("Optimal way + " + currentOptimalWay.getPath().toString());
        return null;
    }

    public static ArrayList<Vertex> findShortestLoop(Towns t) {
        currentOptimalWay = new Way(2147483647);
        findOptimalWay(t, t.getTown(0), new Way(), t.getTown(0));
        return currentOptimalWay.getPath();
    }
}
