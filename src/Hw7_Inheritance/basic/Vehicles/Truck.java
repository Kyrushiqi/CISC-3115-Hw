package Hw7_Inheritance.basic.Vehicles;

public class Truck extends Vehicle {
    private int maxCargoWeight;
    private int cargoWeight;

    public Truck(int maxCargoWeight){
        super(2);
        this.maxCargoWeight = maxCargoWeight;
        this.cargoWeight = 0;
    }

    public Truck(int numSeats, int maxCargoWeight){
        super(numSeats);
        this.maxCargoWeight = maxCargoWeight;
    }

    public int getMaxCargoWeight(){
        return this.maxCargoWeight;
    }

    public int getCargoWeight(){
        return this.cargoWeight;
    }

    public boolean addCargo(int weight){
        if(cargoWeight + weight < maxCargoWeight){
            cargoWeight += weight;
            return true;
        }
        return false;
    }
}
