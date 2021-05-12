package com.company;

import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car.addCar(new Car("Audi", "Black", "GL 1113 PK", 2007, "Alex Predetskiy"));
        Car.addCar(new Car("BMW", "Red", "SL 6731 KN", 2018, "Antonina Vesetska"));
        Car.addCar(new Car("Audi", "Grey", "JB 0908 QS", 2010, "Donald Keapson"));
        Car.addCar(new Car("Mazda", "White", "NO 7777 PK", 2013, "Anna Podilska"));
        Car.addCar(new Car("Audi", "Black", "JL 0983 GZ", 2015, "Vladislav Popaev"));
        Car.addCar(new Car("BMW", "Brown", "LS 7867 AX", 2020, "Emily Walterson"));
        Car.addCar(new Car("Mazda", "White", "NO 7777 PK", 2013, "Anna Podilska"));
        Car.addCar(new Car("Mazda", "Red", "NO 7777 PK", 2013, "Anna Podilska"));
        Car.addCar(new Car("BMW", "Orange", "SL 6731 KN", 2021, "Antonina Vesetska"));
        Car.addCar(new Car("BMW", "Green", "SL 6731 KN", 2019, "Antonina Vesetska"));
        Car.addCar(new Car("Mazda", "Pink", "NO 7777 PK", 2013, "Anna Podilska"));
        Car.addCar(new Car("BMW", "Blue", "SL 6731 KN", 2017, "Antonina Vesetska"));
        Car.addCar(new Car("BMW", "White", "SL 6731 KN", 2009, "Antonina Vesetska"));
        Car.addCar(new Car("BMW", "Silver", "SL 6731 KN", 2000, "Antonina Vesetska"));


        Car.print();

        System.out.print("\nВсього автомобілів: ");
        Car.countCar();

    }

}

class CarCounts {
    int count;
    String name;


}

class Car {
    private static final List<Car> listCar = new LinkedList<Car>();
    private String brand;
    private String color;
    private String registrationNo;
    private int year;
    private String owner;
    private static ArrayList<CarCounts> tmpCounter = new ArrayList<CarCounts>();

    public Car(String brand, String color, String registrationNo, int year, String owner) {
        setBrand(brand);
        setColor(color);
        setRegistrationNo(registrationNo);
        setYear(year);
        setOwner(owner);
    }

    public static void countCar() {
        System.out.println(listCar.size());
        for (int i = 0; i < listCar.size(); i++) {
            if (!tmpCounter.isEmpty()) {
                for (int j = 0; j < tmpCounter.size(); j++) {
                    if (tmpCounter.get(j).name == listCar.get(i).brand) {
                        tmpCounter.get(j).count++;
                        break;
                    } else if (j == tmpCounter.size() - 1) {
                        CarCounts tmp = new CarCounts();
                        tmp.name = listCar.get(i).brand;
                        tmp.count = 1;
                        tmpCounter.add(tmp);
                        break;
                    }
                }
            } else {
                CarCounts tmp = new CarCounts();
                tmp.name = listCar.get(i).brand;
                tmp.count = 1;
                tmpCounter.add(tmp);
            }
        }
        for(int i = 0; i < tmpCounter.size()-1; i++)
        {
            for(int j = 1; j <tmpCounter.size()-i; j++)
            {
                if(tmpCounter.get(j-1).count < tmpCounter.get(j).count)
                {
                    Collections.swap(tmpCounter, j-1,j);
                }

            }
        }
        for (CarCounts tmp : tmpCounter)
        {
            System.out.println(tmp.name + " : " + tmp.count);
        }
    }

    public static void addCar(Car currentCar) {
        listCar.add(currentCar);
    }

    public static void print() {
        for (Car car : listCar) {
            System.out.println(car);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car {");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", year=").append(year);
        sb.append(", color='").append(color).append('\'');
        sb.append(", registrationNo='").append(registrationNo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}
