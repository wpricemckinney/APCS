//This is a program that allows the user to input data about the high temperature over an
//unspecified number of days. The program then calculates the average of all the days and
//then it tells the user the number of days that have a high temperature above the average

//import Scanner
import java.util.Scanner;

public class PriceMcKinneyWeatherAnalysis {
    public static void main (String[] args) {

        //method with scanner to get the number of days to work with
        int numberOfDays = num();

        //define the array as a global variable
        int[] days = new int[numberOfDays];

        //this method is to print out the information for the different days, and to return the sum
        double sum = body(days, numberOfDays);

        //this method is is to find the average and the number of days above the average
        averageCalculations(sum, numberOfDays, days);

    }

    //define this method as an int so the return type works
    public static int num () {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days' temperatures? " );
        int numberOfDays = input.nextInt();
        return numberOfDays;
    }

    //define this method as a double to return sum
    //sum needs to be a double so that the average calculation works
    public static double body(int[] days, int numberOfDays) {
        Scanner input = new Scanner(System.in);
        double sum = 0.0;
        //updates the sum variable and plugs input.nexInt into the array at the correct place
        for (int i = 1; i <= numberOfDays; i++) {
            System.out.print("Day " + i + "'s high temp: ");
            int a = input.nextInt();
            sum += a;
            days [i -1] = a;
        }
        return sum;
    }

    //define this method as a void because there is nothing to return.
    //The math is self contained and just needs to be printed to the console
    public static void averageCalculations(double sum, int numberOfDays, int [] days) {
        double average = sum/numberOfDays;
        //this weird stuff for Math.round is to make it round to the nearest tenth
        System.out.println("Average temp = " + (Math.round(average * 10)/10.0));
        //make another sum variable and update its value so that the program knows how many are above average
        int nextsum = 0;
        for(int i = 0; i <= days.length-1; i++) {
            if (days [i] > average ) {
                nextsum ++;
            }
        }
        System.out.println(nextsum + " days were above average.");
    }

}