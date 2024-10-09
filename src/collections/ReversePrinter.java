package collections;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class ReversePrinter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("words.txt"));
        ArrayList<String> words = new ArrayList<>();

        //puts words from words.txt into an arrayList
        while(sc.hasNext()){
            words.add(sc.next());
        }

        for(int i = words.size()-1; i > 0; i--){
            System.out.print(words.get(i) + " ");
        }
        System.out.println(words.get(0));

    }

}
