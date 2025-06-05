package com.cbfacademy.cars;

public class App {
    public static void main(String[] args) {
        // TODO: Display details of all cars in showroom
        for (Car car : new Showroom().getCars()) {
            System.out.println(car.getDetails());
        }
    }
}
