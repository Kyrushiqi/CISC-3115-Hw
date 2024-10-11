package Hw7_Inheritance.basic.Vehicles;

// Related to Vehicle.TestVehicles, Vehicle.Car, and Vehicle.Truck
public class Vehicle {
    private int numSeats;
    private int numPassengers;

    public Vehicle(int numSeats){
        this.numSeats = numSeats;
        this.numPassengers = 0;
    }

    public int getNumSeats(){
        return numSeats;
    }

    public int getNumPassengers(){
        return numPassengers;
    }
    public boolean addPassenger(){
        if(numPassengers < numSeats){
            numPassengers++;
            return true;
        }
        return false;
    }

}
