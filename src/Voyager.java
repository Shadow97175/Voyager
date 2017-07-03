import classes.City;
import classes.Towns;
import interfaces.Graph;

import java.util.ArrayList;

import static classes.Iskatel.findShortestLoop;
import static interfaces.Graph.*;


public class Voyager {

    public static void main(String args[]) {
        System.out.println("Start of the Voyager program");
        testOnFourCities();
        testOnNineCities();
    }

    static void testOnFourCities() {
        System.out.println("Testing on four predefined cities..");

        Towns towns = new Towns();
        System.out.println("Creating of cities..");

        City moscow = new City("Moscow");
        City newYork = new City("New York");
        City kyiv = new City("Kyiv");
        City madrid = new City("Madrid");

        System.out.println("Adding cities to town...");
        towns.addTown(moscow);
        towns.addTown(newYork);
        towns.addTown(kyiv);
        towns.addTown(madrid);

        System.out.println("Creating roads...");
        towns.addRoad(moscow, newYork, 55);//
        towns.addRoad(moscow, kyiv, 110);//
        towns.addRoad(moscow, madrid, 55);//
        towns.addRoad(newYork, kyiv, 55);//
        towns.addRoad(newYork, madrid, 100);//
        towns.addRoad(kyiv, madrid, 100);//
        System.out.println("Testing...");

        ArrayList<Graph.Vertex> way = findShortestLoop(towns);
        ArrayList<Graph.Vertex> corectway = new ArrayList<>();

        corectway.add(moscow);
        corectway.add(newYork);
        corectway.add(kyiv);
        corectway.add(madrid);
        if (isEqualPaths(way, corectway))
            System.out.println("Passed test");
        else
            System.out.println("Test wasn't passed");
    }


    static void testOnNineCities() {
        System.out.println("Testing on nine predefined cities..");

        Towns towns = new Towns();
        System.out.println("Creating the cities..");

        City moscow = new City("Moscow");
        City newYork = new City("New York");
        City kyiv = new City("Kyiv");
        City madrid = new City("Madrid");
        City bangkok = new City("Bangkok");
        City nairobi = new City("Nairobi");
        City beijing = new City("Beijing");
        City yokohama = new City("Yokohama");
        City casablanca = new City("Casablanca");


        System.out.println("Adding cities to town...");
        towns.addTown(moscow);
        towns.addTown(newYork);
        towns.addTown(kyiv);
        towns.addTown(madrid);
        towns.addTown(bangkok);
        towns.addTown(nairobi);
        towns.addTown(beijing);
        towns.addTown(yokohama);
        towns.addTown(casablanca);

        System.out.println("Creating roads...");

        towns.addRoad(moscow, newYork, 10);//
        towns.addRoad(moscow, kyiv, 65);//
        towns.addRoad(moscow, madrid, 98);//
        towns.addRoad(moscow, bangkok, 93);//
        towns.addRoad(moscow, nairobi, 94);//
        towns.addRoad(moscow, beijing, 70);//
        towns.addRoad(moscow, yokohama, 56);//
        towns.addRoad(moscow, casablanca, 55);//
        towns.addRoad(newYork, kyiv, 55);//
        towns.addRoad(newYork, madrid, 72);//
        towns.addRoad(newYork, bangkok, 58);//
        towns.addRoad(newYork, nairobi, 62);//
        towns.addRoad(newYork, beijing, 81);//
        towns.addRoad(newYork, yokohama, 66);//
        towns.addRoad(newYork, casablanca, 70);//
        towns.addRoad(madrid, bangkok, 67);//
        towns.addRoad(madrid, nairobi, 72);//
        towns.addRoad(madrid, beijing, 56);//
        towns.addRoad(madrid, yokohama, 90);//
        towns.addRoad(madrid, casablanca, 90);//
        towns.addRoad(bangkok, nairobi, 58);//
        towns.addRoad(bangkok, beijing, 60);//
        towns.addRoad(bangkok, yokohama, 67);//
        towns.addRoad(bangkok, casablanca, 84);//
        towns.addRoad(beijing, yokohama, 91);//
        towns.addRoad(beijing, casablanca, 57);//
        towns.addRoad(yokohama, casablanca, 92);//

        System.out.println("Testing...");

        ArrayList<Graph.Vertex> way = findShortestLoop(towns);
        ArrayList<Graph.Vertex> corectway = new ArrayList<>();
// [New York, Kyiv, Moscow, Casablanca, Beijing, Madrid, Nairobi, Bangkok, Yokohama]
        corectway.add(kyiv);
        corectway.add(moscow);
        corectway.add(casablanca);
        corectway.add(beijing);
        corectway.add(madrid);
        corectway.add(nairobi);
        corectway.add(bangkok);
        corectway.add(yokohama);
        corectway.add(newYork);

        if (isEqualPaths(way, corectway))
            System.out.println("Passed test");
        else
            System.out.println("Test wasn't passed");
    }


    static boolean test(Towns town, ArrayList<Graph.Vertex> correctWay) {
        ArrayList<Graph.Vertex> way = findShortestLoop(town);

        return isEqualPaths(way, correctWay);
    }

    private static boolean isEqualPaths(ArrayList<Graph.Vertex> first, ArrayList<Graph.Vertex> second) {
        if (!(first.size() == second.size()) || !first.containsAll(second))
            return false;

        Vertex firstCity = first.get(0);
        int offset = second.indexOf(firstCity);

        for (int i = 0; i < first.size(); i++) {
            Vertex correct = first.get(i);

            int comparePosition = i + offset;
            if (comparePosition >= first.size())
                comparePosition -= first.size();

            int anotherComparePosition = offset - i;
            if (anotherComparePosition < 0) {
                anotherComparePosition = first.size() + anotherComparePosition;
            }

            Vertex compare = second.get(comparePosition);
            Vertex anotherCompare = second.get(anotherComparePosition);

            if (!(correct.equals(compare) || correct.equals(anotherCompare))) {
                return false;
            }
        }

        return true;
    }
}
