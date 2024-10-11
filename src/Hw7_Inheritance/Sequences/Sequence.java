package Hw7_Inheritance.Sequences;

/*
Objective: write an abstract class named Sequence.
- one protected field: int current // represents the current value of the sequence.
- 2 constructors
- abstract method: public abstract int next() // will be implemented by subclasses.
- concrete method: public void printNext(int n)
 */
public abstract class Sequence {
    protected int current; // represents the current value of the sequence.

    public Sequence(){
        this.current = 0;
    }
    public Sequence(int start){
        this.current = start;
    }

    /**
     * Abstract method:
    Goal: return the current value of the sequence and advance the current value to the next value of the sequence.
     This method will be implemented by subclasses.

     Abstract methods don't have bodies. The bodies will be implemented by subclasses.
     */
    public abstract int next();

    /**
     * Concrete method (aka non-abstract method):
     * Goal:
     * prints the next n values of this sequence by repeatedly invoking the next() method. A space should be
     * printed after each value, and the line should be terminated (i.e., a new line should be printed)
     * after the n values have been printed.
     *
     */
    public void printNext(int n){
        for (int i = 0; i < n; i ++){
            System.out.print(next() + " ");
        }
        System.out.println();
    }
}
