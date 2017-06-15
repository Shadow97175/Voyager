import classes.City;
import classes.Towns;
import interfaces.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static classes.Iskatel.getShortestLoop;


public class Voyager {

    public static void main(String args[]) {
        System.out.println("Start of the Voyager program");

        //Создаю экземпляр класса города, в котором будут храниться данные о городах и расстояних между ними
        Towns towns = new Towns();

        //Добавляю данные, а именно все города
        towns.addTown("A");
        towns.addTown("B");
        towns.addTown("C");
        towns.addTown("D");
        towns.addTown("E");
        towns.addTown("F");
        towns.addTown("G");

        //Добавляю данные, а именно все дороги
        towns.addRoad("A", "B", 100);
        towns.addRoad("B", "D", 60);
        towns.addRoad("B", "F", 150);
        towns.addRoad("D", "F", 70);
        towns.addRoad("F", "G", 120);
        towns.addRoad("A", "G", 300);
        towns.addRoad("G", "C", 280);
        towns.addRoad("G", "E", 100);
        towns.addRoad("C", "E", 100);
        towns.addRoad("C", "A", 100);


        //Класс way будет содержать кратчайший путь
        ArrayList<City> path = new ArrayList<>();
        path = getShortestLoop(towns, "A", path);

        // Выводим кратчайший путь
        System.out.print("Path: ");
        for (City c : path) {
            System.out.print("" + c.getName());
        }

    }



}
