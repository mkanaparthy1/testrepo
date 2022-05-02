import java.util.ArrayList;

public class Recursion {


    public static String binaryString(int n) {
        String binary = " ";
        while (n > 0) {
            binary = (n % 2) + binary;
            n /= 2;
        }
        return binary;
    }

    public static boolean isSubsetSum(ArrayList<Integer> set, int targetNumber) {
        if (set.size() == 0) {
            return true;
        }

        if (set.size() == 1) {
            return (set.get(0) == targetNumber);
        }
        //
        int endElement = set.get(set.size() - 1);
        if (endElement == targetNumber) {
            return true;
        }
        ArrayList<Integer> setTwo = new ArrayList<>(set.size() - 1);
        for (int i = 0; i < setTwo.size(); i++) {
            setTwo.add(set.get(i));
        }
        return (isSubsetSum(setTwo, targetNumber) || isSubsetSum(setTwo, targetNumber - endElement));


    }

    public static void main(String args[]) {
        System.out.println("binaryString(6) returns " + binaryString(6));
        System.out.println("binaryString(17) returns " + binaryString(17));
        System.out.println("binaryString(123) returns " + binaryString(123));
        System.out.println("binaryString(158338) returns " + binaryString(158338));

        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(3);
        set.add(7);
        set.add(1);
        set.add(8);
        set.add(-3);

        int targetNumber = 12;



        if (isSubsetSum(set, targetNumber) == true) {
            System.out.println();
            System.out.println("There is a subset of those integers that sum to that targetNumber");
        } else {
            System.out.println();
            System.out.println("There is not a subset of those integers that sum to that targetNumber");
        }


    }
}
