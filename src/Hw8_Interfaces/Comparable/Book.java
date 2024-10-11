package Hw8_Interfaces.Comparable;

public class Book implements Comparable<Book>{
    private String title, author;
    private int publicationYear;
    private double price;

    public Book(String title, String author, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    /**
     * Objective:
     * Two books should be compared like this:
     * 1) Compare publication years numerically.
     * 2) If publication years are equal, the books should be compared numerically by PRICE.
     * 3) If price are equal, compare alphabetically by AUTHOR.
     * 4) If author are equal, compare alphabetically by TITLE.
     */
    @Override
    public int compareTo(Book other){
        int publicationYears = Integer.compare(this.publicationYear, other.publicationYear);
        if( publicationYears != 0 ){
            return publicationYears;
        }else{
            int price = Double.compare(this.price, other.price);
            if (price != 0){
                return price;
            }else{
                int author = this.author.compareTo(other.author);
                if(author != 0){
                    return author;
                }
            }
        }

        return this.title.compareTo(other.title);
    }
}

