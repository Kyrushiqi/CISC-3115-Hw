package Hw8_Interfaces.Comparator;

import java.util.Arrays;
import java.util.Comparator;

/*
Objective: Create a Player[] array and sort it in various ways.
Comparator consists of using compare() method, any of the 3 methods mentioned in class for comparators --
a separate class, anonymous class, or lambda expression, and Arrays.sort(arrayName, comparator).

Here we used the separate class:
 */
public class Main {
    public static void main(String[] args) {
        Player[] players = getPlayersArray();

        // TODO 1 - sort the players by name in ascending order
        //Arrays.sort(players, Comparator.comparing(Player::getName)); -> Will learn in data structures class,
        // simplified version further than lambda expression
        /*Comparator<Player> byAscendingName = new PlayerNameComparatorAscending();
        Arrays.sort(players, byAscendingName);*/

        Comparator<Player> byName = new AscendingName();
        Arrays.sort(players, byName);

        System.out.println("players sorted by name in ascending order: " + Arrays.toString(players));

        // TODO 2 - sort the players by name in descending order
        //Arrays.sort(players, Comparator.comparing(Player::getName).reversed());
        /*Comparator<Player> byDescendingName = byAscendingName.reversed();
        Arrays.sort(players, byDescendingName);*/

        Comparator<Player> byReversedName = byName.reversed();
        Arrays.sort(players, byReversedName);

        System.out.println("players sorted by name in descending order: " + Arrays.toString(players));

        // TODO 3 - sort the players by score in ascending order
        //Arrays.sort(players, Comparator.comparingInt(Player::getScore));
        /*Comparator<Player> byAscendingScore = new PlayerScoreComparatorAscending();
        Arrays.sort(players, byAscendingScore);*/

        Comparator<Player> byScore = new AscendingScore();
        Arrays.sort(players, byScore);

        System.out.println("players sorted by score in ascending order: " + Arrays.toString(players));

        // TODO 4 - sort the players by score in descending order
        //Arrays.sort(players, Comparator.comparingInt(Player::getScore).reversed());
        /*Comparator<Player> byDescendingScore = byAscendingScore.reversed();
        Arrays.sort(players, byDescendingScore);*/

        System.out.println("players sorted by score in descending order: " + Arrays.toString(players));
    }

    static class AscendingName implements Comparator<Player>{
        @Override
        public int compare(Player p1, Player p2){
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class AscendingScore implements Comparator<Player>{
        @Override
        public int compare(Player p1, Player p2){
            return Integer.compare(p1.getScore(), p2.getScore());
        }
    }

    /* Why do they need to be static classes? vv
    * */
    /*static class PlayerNameComparatorAscending implements Comparator<Player>{
        @Override
        public int compare(Player p1, Player p2){
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class PlayerScoreComparatorAscending implements Comparator<Player>{
        @Override
        public int compare(Player p1, Player p2){
            return Integer.compare(p1.getScore(), p2.getScore());
        }
    }*/



    private static Player[] getPlayersArray() {
        return new Player[] {
                new Player("Jane", 56),
                new Player("John", 34),
                new Player("Olivia", 47),
                new Player("Kate", 67),
                new Player("Adam", 39),
                new Player("Josh", 60)
        };
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }

    /*
     * Compares two Players based on their scores. Natural ordering. Not needed here, only use compareTo with Comparable
     *

    public int compareTo(Player other){
        return Integer.compare(this.score, other.score);
    }*/
}

