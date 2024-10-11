package Hw7_Inheritance.basic.Vehicles;/* Do not modify this file. You may copy it, paste it elsewhere, and modify it there, but do not paste the modified code back here. */

public class TestVehicles {
    public static void main(String[] arg) {
        Vehicle v = new Vehicle(2);
        System.out.println(v.getNumSeats()); // 2
        System.out.println(v.getNumPassengers()); // 0
        System.out.println(v.addPassenger()); // true
        System.out.println(v.addPassenger()); // true
        System.out.println(v.addPassenger()); // false
        System.out.println(v.getNumPassengers()); // 2
        System.out.println();

        Car c1 = new Car();
        System.out.println(c1.getNumDoors()); // 4
        System.out.println(c1.getNumSeats()); // 5
        System.out.println(c1.getNumPassengers()); // 0
        System.out.println();

        Car c2 = new Car(3, 2);
        System.out.println(c2.getNumDoors()); // 2
        System.out.println(c2.getNumSeats()); // 3
        System.out.println(c2.getNumPassengers()); // 0
        System.out.println();

        Truck t1 = new Truck(20_000);
        System.out.println(t1.getMaxCargoWeight()); // 20000
        System.out.println(t1.getNumSeats()); // 2
        System.out.println(t1.getCargoWeight()); // 0
        System.out.println();

        Truck t2 = new Truck(4, 30_000);
        System.out.println(t2.getMaxCargoWeight()); // 30000
        System.out.println(t2.getNumSeats()); // 4
        System.out.println(t2.getCargoWeight()); // 0
        System.out.println();

        System.out.println(t2.addCargo(20_000)); // true
        System.out.println(t2.getCargoWeight()); // 20000
        System.out.println(t2.addCargo(20_000)); // false
        System.out.println(t2.getCargoWeight()); // 20000
        System.out.println();

        System.out.println(c1 instanceof Vehicle); // true
        System.out.println(t1 instanceof Vehicle); // true
        System.out.println();

        System.out.println(Car.class.getDeclaredFields().length); // expected: 1
        System.out.println(Truck.class.getDeclaredFields().length); // expected: 2
    }
}
