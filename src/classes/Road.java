package classes;

import interfaces.Graph;

public class Road implements Graph.Edge {
    String fromCity;
    String toCity;
    int length;

    //Конструктор для ребра
    public Road(String fromCity, String toCity, int length) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.length = length;
    }

    //Метод определят принадлежит ли вершина к текущему ребру
    public boolean consistCity(String s) {
        boolean result = false;
        if (s.equals(this.fromCity) || s.equals(this.toCity)) result = true;
        return result;
    }

    //Метод возвращает вторую вершину, по заданной первой
    public String nextCity(String s) {
        String result = null;
        if (s.equals(this.fromCity)) result = this.toCity;
        if (s.equals(this.toCity)) result = this.fromCity;
        return result;
    }

    //Метод определяет вес ребре, или длинну пути в нашем случае
    @Override
    public int getWeight() {
        return this.length;
    }
}
