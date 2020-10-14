import java.util.Scanner;
import java.lang.Math;
import java.lang.String;

public class ArraysProblems {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        byte[] numForBinarySearch = {2, 5, 11, 14, 21, 67, 78, 96, 100};
        byte[] numForRandom = {2, 11, 14, 19, 25, 28, 34, 46, 52};
        // byte[] numForRandom = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
        double[] numForAverage = new double[10];
        double[] numForMinimum = new double[10];

        System.out.println(BinarySearch(numForBinarySearch, (byte) 5));
        System.out.println("The random number is " + getRandom(numForRandom));

        System.out.print("Enter 10 numbers: ");

        for(int i = 0; i < numForAverage.length; i++) {
            numForAverage[i] = input.nextDouble();
        }

        System.out.println("The average is " + average(numForAverage));

        System.out.print("Enter 10 numbers: ");

        for(int i = 0; i < numForMinimum.length; i++) {
            numForMinimum[i] = input.nextDouble();
        }

        System.out.println("The minimum number is: " + min(numForMinimum));
    }

    public static String BinarySearch (byte[] numbers, byte target) {

        byte first = 0;
        byte last = (byte) (numbers.length - 1);
        byte middle;
        byte steps = 0;
        String output = "";

    
        while (first <= last) {
    
            steps += 1;

            middle = (byte) Math.floor((first + last)/2);
    
            if(target == numbers[middle]){
                output = target + " found at index " + middle + " after " + steps + " steps.";
                break;
            } else if(target > numbers[middle]) {
                first = (byte) (middle + 1); 
            } else if(target < numbers[middle]) {
                last = (byte) (middle - 1);
            }
           
        }

        return output;
    }

    public static byte getRandom (byte[] numbers) {

        byte counter = 0;

        while(true) {

            byte random = (byte) ((Math.random() * 55) + 1);

            for(byte i: numbers) {
                if(i == random) counter ++;
            }

            if(counter == 0) return random;
            else counter = 0;
        }

    }

    public static int average(int[] numbers) {

        int sum = 0;

        for(int i: numbers) sum += i;

        return sum/numbers.length;
    }

    public static double average(double[] numbers) {

        double sum = 0;

        for(double i: numbers) sum += i;

        return sum/numbers.length;
    }

    public static double min(double[] numbers) {

        double min = numbers[0];

        for(double e: numbers) if(min > e) min = e;

        return min;

    }
}