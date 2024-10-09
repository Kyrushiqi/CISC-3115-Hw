// DO NOT MODIFY THIS FILE.
/*
public class ApartmentBuildingTest {
    public static void main(String[] args) {
        testConstructor();
        testNumApartments();
        testAddApartment();
        testToString();
        testGetArea();
        testFindApartmentInRange();
        testDefensiveCopying();
    }

    private static void testConstructor() {
        System.out.println("testing constructor");
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(3);
        System.out.println(apartmentBuilding.getNumApartments());  // expected: 0
        System.out.println();
    }

    private static void testNumApartments() {
        System.out.println("testing getNumApartments");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(2);
        System.out.println(apartmentBuilding.getNumApartments()); // expected: 0

        apartmentBuilding.addApartment(new Apartment("1A", 3));
        System.out.println(apartmentBuilding.getNumApartments()); // expected: 1

        apartmentBuilding.addApartment(new Apartment("1B", 4));
        System.out.println(apartmentBuilding.getNumApartments()); // expected: 2

        apartmentBuilding.addApartment(new Apartment("1C", 2));
        System.out.println(apartmentBuilding.getNumApartments()); // expected: 2

        System.out.println();
    }

    private static void testAddApartment() {
        System.out.println("testing addApartment");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(2);
        boolean added;

        added = apartmentBuilding.addApartment(new Apartment("1A", 2));
        System.out.println(added);  // expected: true

        added = apartmentBuilding.addApartment(new Apartment("1B", 2));
        System.out.println(added);  // expected: true

        added = apartmentBuilding.addApartment(new Apartment("1C", 2));
        System.out.println(added);  // expected: false

        System.out.println();
    }

    private static void testToString() {
        System.out.println("testing toString");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(3);

        Apartment apartment1 = new Apartment("1A", 2);
        apartment1.addRoom(new Room(10, 10));
        apartment1.addRoom(new Room(9, 9));
        apartmentBuilding.addApartment(apartment1);

        Apartment apartment2 = new Apartment("1B", 3);
        apartment2.addRoom(new Room(8, 8));
        apartment2.addRoom(new Room(7, 7));
        apartmentBuilding.addApartment(apartment2);

        System.out.println(apartmentBuilding.toString());
        // expected:
        // apartment 1A: [10.0 x 10.0 room, 9.0 x 9.0 room]
        // apartment 1B: [8.0 x 8.0 room, 7.0 x 7.0 room]

        System.out.println();
    }

    private static void testGetArea() {
        System.out.println("testing getArea");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(3);

        Apartment apartment1 = new Apartment("1A", 2);
        apartment1.addRoom(new Room(10, 10));
        apartment1.addRoom(new Room(9, 9));
        apartmentBuilding.addApartment(apartment1);

        Apartment apartment2 = new Apartment("1B", 3);
        apartment2.addRoom(new Room(8, 8));
        apartment2.addRoom(new Room(7, 7));
        apartmentBuilding.addApartment(apartment2);

        System.out.println(apartmentBuilding.getArea()); // expected: 294.0

        System.out.println();
    }

    private static void testFindApartmentInRange() {
        System.out.println("testing findApartmentInRange");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(4);

        Apartment apartment1 = new Apartment("1A", 2);
        apartment1.addRoom(new Room(10, 10));
        apartment1.addRoom(new Room(9, 9));
        System.out.println(apartment1.getArea());  // expected: 181.0
        apartmentBuilding.addApartment(apartment1);

        Apartment apartment2 = new Apartment("1B", 3);
        apartment2.addRoom(new Room(8, 8));
        apartment2.addRoom(new Room(7, 7));
        System.out.println(apartment2.getArea());  // expected: 113.0
        apartmentBuilding.addApartment(apartment2);

        Apartment apartment3 = new Apartment("1C", 3);
        apartment3.addRoom(new Room(6, 6));
        apartment3.addRoom(new Room(5, 5));
        System.out.println(apartment3.getArea());  // expected: 61.0
        apartmentBuilding.addApartment(apartment3);

        Apartment result = apartmentBuilding.findApartmentInRange(150, 200);
        System.out.println(result == null);    // expected: false
        System.out.println(result.toString()); // expected: apartment 1A: [10.0 x 10.0 room, 9.0 x 9.0 room]

        result = apartmentBuilding.findApartmentInRange(100, 150);
        System.out.println(result == null);    // expected: false
        System.out.println(result.toString()); // expected: apartment 1B: [8.0 x 8.0 room, 7.0 x 7.0 room]

        result = apartmentBuilding.findApartmentInRange(50, 100);
        System.out.println(result == null);    // expected: false
        System.out.println(result.toString()); // expected: apartment 1C: [6.0 x 6.0 room, 5.0 x 5.0 room]

        result = apartmentBuilding.findApartmentInRange(1, 50);
        System.out.println(result == null); // expected: true

        result = apartmentBuilding.findApartmentInRange(200, 300);
        System.out.println(result == null); // expected: true

        System.out.println();
    }

    private static void testDefensiveCopying() {
        System.out.println("Testing defensive copying");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(1);
        Apartment apartment = new Apartment("1A", 3);
        apartment.addRoom(new Room(10, 10));
        apartmentBuilding.addApartment(apartment);
        System.out.println(apartmentBuilding.toString()); // apartment 1A: [10.0 x 10.0 room]

        // addRoom should make a defensive copy
        apartment.addRoom(new Room(15, 15));
        System.out.println(apartment.toString()); // apartment 1A: [10.0 x 10.0 room, 15.0 x 15.0 room]
        System.out.println(apartmentBuilding.toString()); // apartment 1A: [10.0 x 10.0 room]

        // findApartmentInRange should make a defensive copy
        Apartment result = apartmentBuilding.findApartmentInRange(80, 120);
        result.addRoom(new Room(20, 20));
        System.out.println(result.toString()); // apartment 1A: [10.0 x 10.0 room, 20.0 x 20.0 room]
        System.out.println(apartmentBuilding.toString()); // apartment 1A: [10.0 x 10.0 room]
    }
}
*/
