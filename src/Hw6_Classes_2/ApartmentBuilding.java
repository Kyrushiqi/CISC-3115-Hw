package Hw6_Classes_2;

public class ApartmentBuilding {
    private Apartment[]apartments;
    private int numApartments;

    public ApartmentBuilding(int maxApartments){
        this.apartments = new Apartment[maxApartments];
        this.numApartments = 0;
    }
    public int getNumApartments(){
        return numApartments;
    }
    public boolean addApartment(Apartment apartment){
        return false;
    }
}
