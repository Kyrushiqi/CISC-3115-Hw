package Hw7_Inheritance.basic.Vehicles;

public class Car extends Vehicle {
    private int numDoors;

    public Car(){
        super(5);
        this.numDoors = 4;
    }

    public Car(int numSeats, int numDoors){
        super(numSeats);
        this.numDoors = numDoors;
    }

    public int getNumDoors(){
        return numDoors;
    }
}
