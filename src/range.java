public class range {
    public static void main(String[]args){
        int from = 0;
        int to = 4;
        System.out.println("The call range(" + from + ", " + to + ") should return the array {"
                + range(from,to) + "}.");
        System.out.println(range(to));



    }
//Not allowed to use any loops/recursion. Use the existing range method below to write this new method.
    public static int[] range(int to){
        int[]array = new int[to];
        if(to > 0) {
            return range(0, to); //Originally, I forgot to put in the 'return' here. This causes nothing to happen and
            // it only returns an empty array.
        }else if(to == 0) {
            return array;
        }
        return array;
    }
    //codelab provided the following range method (part 1) below vv
    public static int[] range(int from, int to) {
        int[] ints = new int[to - from];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + from;
        }

        return ints;
    }

    /*
// Do not need to print out the range, just return an array from the method. Range part 1
    public static int[] range(int from, int to){
        int[]array = new int[(to-from)];
        int count = from;

        if(from < to) {
            array[0] = from;
            //System.out.println("Index: 0 " + array[0]);
            for (int i = 1; i < (to - from); i++) {
                count++;
                array[i] = count;
                //System.out.println("Index: " + i + " " + array[i]);
            }
        }else if(from == to){
            return array;
        }

        return array;
    }*/
}
