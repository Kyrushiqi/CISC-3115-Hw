package Hw8_Interfaces.Comparable;

// DO NOT MODIFY THIS FILE.

public class BookTest {
    public static void main(String[] args) {
        System.out.println(new Book("The Illiad", "Homer", -700, 15.99) instanceof Comparable); // expected: true
        System.out.println(new Book("The Illiad", "Homer", -700, 15.99).compareTo(new Book("A Tale of Two Cities", "Charles Dickens", 1859, 19.95)) < 0); // expected: true
        System.out.println(new Book("War and Peace", "Leo Tolstoy", 1869, 22.50).compareTo(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 17.99)) < 0); // expected: true
        System.out.println(new Book("The Alchemist", "Paulo Coelho", 1988, 11.99).compareTo(new Book("The Alchemist", "Paulo Coelho", 1988, 11.99)) == 0); // expected: true
        System.out.println(new Book("Becoming", "Michelle Obama", 2018, 32.99).compareTo(new Book("Educated", "Tara Westover", 2018, 17.99)) > 0); // expected: true
        System.out.println(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, 9.99).compareTo(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, 12.99)) < 0); // expected: true
        System.out.println(new Book("The Handmaid's Tale", "Margaret Atwood", 1985, 14.99).compareTo(new Book("The Handmaid's Tale", "Margaret Atwood", 1985, 14.99)) == 0); // expected: true
        System.out.println(new Book("A Brief History of Time", "Stephen Hawking", 1988, 18.99).compareTo(new Book("The Selfish Gene", "Richard Dawkins", 1976, 16.99)) > 0); // expected: true
        System.out.println(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.99).compareTo(new Book("Animal Farm", "George Orwell", 1960, 12.99)) > 0); // expected: true
        System.out.println(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 14.99).compareTo(new Book("The Grapes of Wrath", "John Steinbeck", 1939, 14.99)) < 0); // expected: true
    }
}
