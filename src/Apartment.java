public class Apartment {
    private String apartmentNumber;
    private Room[]rooms;
    private int numRooms;

    /**
     * Create an apartment with no rooms. It has the ability to hold up to maxRooms rooms.
     * You can assume apartmentNumber isn't null and that maxRooms is positive.
     */
    public Apartment(String apartmentNumber, int maxRooms){
        this.apartmentNumber = apartmentNumber;
        rooms = new Room[maxRooms];
        this.numRooms = 0;
    }

    /**
     * Copy constructor should make a deep copy of the original Apartment. Adding a new room to the
     * original apartment should not have an effect on the new apartment.
     * TODO: Redo Apartment copy constructor, Chat
     */
    public Apartment(Apartment original){
        this.apartmentNumber = original.apartmentNumber;
        this.rooms = new Room[original.rooms.length];
        this.numRooms = original.numRooms;

        // Deep copy of the rooms array
        for (int i = 0; i < original.numRooms; i++) {
            this.rooms[i] = original.rooms[i];
        }

        //new Apartment(apartmentNumber, numRooms); // not sure if needed
    }

    /**
     * Adds room to the apartment, only if there is space for it.
     * Ex: Apartment can have a maximum of 3 rooms, can add 1, 2, and 3 rooms but not 4 rooms.
     * If room is added, method should return true, otherwise false.
     * TODO: Redo addRoom(), not sure if I understood, hint from Chat
     */
    public boolean addRoom(Room room){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == null){
                rooms[i] = room;
                numRooms ++;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of rooms that the apartment currently has.
     */
    public int getNumRooms(){
        return numRooms;
    }

    /**
     * Returns the apartment's total area, that is the sum of the areas of all the rooms.
     * TODO: Redo getArea for understanding again
     */
    public double getArea(){
        double area = 0.0;
        for (int i = 0; i < rooms.length; i++){
            if(rooms[i] != null){
             area += rooms[i].getArea();}
        }
        return area;
    }

    /**
     * The toString method should return a string containing the word "apartment", the apartment number,
     * and a list of the rooms. For example:
     * apartment 10E: [10.0 x 12.0 room, 11.0 x 13.0 room, 12.0 x 14.0 room]
     * TODO: Redo toString, Chat
     */
    public String toString(){
        String roomList = "";
        for(int i = 0; i < numRooms; i++){
            roomList += rooms[i].toString();
            if(i< numRooms - 1){
                roomList += ", ";
            }
        }
        return "apartment " + apartmentNumber + ": [" + roomList + "]";
    }

    /*public String readRooms(Room[]rooms){
        for(int i = 0; i<rooms.length; i++){
            if(rooms[i] != null){
                return rooms[i] + ", ";
            }
        }
        return "";
    }*/

}
