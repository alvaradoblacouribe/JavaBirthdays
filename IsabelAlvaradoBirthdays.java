import java.util.Scanner;

// Round the percentages and create a method that gets the number from the percentage in order
// to print it
//Gather a fun fact for your birthday
public class IsabelAlvaradoBirthdays {
  public static void main (String[] args) {
    Scanner console= new Scanner(System.in);
    System.out.println("Without the / character, please type the month, day, and year in that order.");
    int month= Integer.parseInt(console.next());
    int day= Integer.parseInt(console.next());
    int year= Integer.parseInt(console.next());
    int dyear= findoutyear(year);
    int numberdate=findoutnumber(day,month,dyear);
    introduction(day,month,year,numberdate);

    System.out.println();
    System.out.println("Person 1: \nWhat month and day were you born in?");
    int Person1month=Integer.parseInt(console.next());
    int Person1day=Integer.parseInt(console.next());
    int numberPerson1=findoutnumber(Person1day,Person1month,dyear);
    double percentPerson1=findoutdistance(numberPerson1,dyear,numberdate);
    System.out.println(Person1month+"/"+Person1day+"/"+year+" falls on day #"+numberPerson1+" out of "+dyear);
    
    System.out.println();
    System.out.println("Person 2: \nWhat month and day were you born in?");
    int Person2month=Integer.parseInt(console.next());
    int Person2day=Integer.parseInt(console.next());
    int numberPerson2= findoutnumber(Person2day,Person2month,dyear);
    System.out.println(Person2month+"/"+Person2day+"/"+year+" falls on day #"+numberPerson2+" out of "+dyear);
    double percentPerson2= findoutdistance(numberPerson2,dyear,numberdate);
    winner(percentPerson1,percentPerson2);
  }

  public static void introduction(int day, int month, int year, int number) {
    String date= month+"/"+day+"/"+year;
    System.out.println("This program compares two birthdays \nand displays which one is sooner \nToday is " +date+ ", day #" +number+ " of the year.");
  }

  public static int findoutnumber(int day, int month,int dyear) {
    int number=0;
    for (int i=0;i<=month-1;i++){
      if (i==0){
        number=0;
      }
      if (i==1|| i==3 || i==5 || i==7|| i==8 || i==10 || i==12){
        number= number +31;
      }
      else if (i==4|| i==6|| i==9|| i==11){
        number=number+30;
      }
      else if (i==2 && dyear==366){
        number=number+29;
      }
      else if (i==2 && dyear==365){
        number=number+28;
      }
    }
    number=number+day;
    return(number);
  }

  public static int findoutyear(int year){
    if (year%4==0){
      if (year%100==0){
        if (year%400==0){
          return (366);
        }
        else{
          return (365);
        }
      }
      else{
        return(366);
      }
    }
    else{
      return (365);
    }
  }

  public static double findoutdistance(int numberperson, int dyear, int numberdate){
    int distance=0;
    if (numberperson<numberdate){
      distance= dyear-(numberdate-numberperson);
      System.out.println(distance);
    }
    else {
      distance= numberperson-numberdate;
    }
    double distancepercent=((double)(distance/(double)dyear)*100);
    double distancepercentround=
    System.out.println("That is "+distancepercentround+"percent of a year away");
    if (distancepercent==0){
      System.out.println("Happy Birthday!");
    }
    return (distancepercent);
    }

  public static void winner(double percentPerson1, double percentPerson2){
    if (percentPerson1<percentPerson2){
      System.out.println("Person 1's birthday is sooner");
    }
    else if (percentPerson2<percentPerson1){
      System.out.println("Person 2's birthday is sooner");
    }
    else {
      System.out.println("You share the same birthday");
    }
  }

}
