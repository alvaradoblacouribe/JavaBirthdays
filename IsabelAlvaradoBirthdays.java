import java.util.Scanner;

public class IsabelAlvaradoBirthdays {
  public static void main (String[] args) {
    Scanner console= new Scanner(System.in);
    System.out.println("What day is it?");
    int day= console.nextInt();
    System.out.println("What month is it?");
    int month= console.nextInt();
    System.out.println("What year is it?");
    int year= console.nextInt();
    String date= month+"/"+day+"/"+year;
    number(day,month,year);
    introduction(date);
  }
  public static void introduction(String date) {
    System.out.println("This program compares two birthdays \nand displays
    which one is sooner \n Today is" +date+", day" +number+ "of the year.");
  }
  public static int number(int day, int month, int year) {
    int number=0;
    if /*year leap*/ {
      for (int i=1;i<=month;i++) {
        if (month=1 or 3 or 5 or)
      }
    }
    else {
    }
  }
}
