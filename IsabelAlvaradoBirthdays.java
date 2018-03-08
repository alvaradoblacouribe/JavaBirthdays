import java.util.Scanner;
//Day and month is valid
//Print the zodiac sign 
public class IsabelAlvaradoBirthdays {
  public static void main (String[] args) {
    Scanner console= new Scanner(System.in);
    System.out.println("Without the / character, please type the month, day, and year in that order.");
    int month= Integer.parseInt(console.next());
    int day= Integer.parseInt(console.next());

    int year= Integer.parseInt(console.next());
    int dyear= findoutYear(year);
    int NumberDate=findoutNumber(day,month,dyear);
    introduction(day,month,year,NumberDate);
    String Person= "Person 1";
    double percentPerson1=Base(console,Person,dyear,NumberDate,year);
    Person= "Person 2";
    double percentPerson2=Base(console,Person,dyear,NumberDate,year);
    winner(percentPerson1,percentPerson2);
  }

  public static double Base(Scanner console, String Person, int dyear, int NumberDate, int year){
    System.out.println();
    System.out.print(Person+ ": \nWhat month and day were you born in?");
    int PersonMonth=Integer.parseInt(console.next());
    int PersonDay=Integer.parseInt(console.next());
    int NumberPerson=findoutNumber(PersonDay,PersonMonth,dyear);
    int NumberDistancePerson=findoutNumberDistance(NumberPerson,dyear,NumberDate);
    System.out.println(Person+ "'s birthday is "+ NumberDistancePerson +" days away from today");
    double percentPerson=findoutDistance(NumberDistancePerson,dyear);
    System.out.println(PersonMonth+"/"+PersonDay+"/"+year+" falls on day #"+NumberPerson+" out of "+dyear);
    if (PersonMonth==5&&PersonDay==3){
      System.out.println("That is also my Birthday! Fun Fact: May 3rd is a famous Spanish Painting about the Spanish Civil War");
    }
    return(percentPerson);
  }

  public static void introduction(int day, int month, int year, int number) {
    String date= month+"/"+day+"/"+year;
    System.out.println("This program compares two birthdays \nand displays which one is sooner \nToday is " +date+ ", day #" +number+ " of the year.");
  }

  public static int findoutNumber(int day, int month,int dyear) {
    System.out.println();
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

  public static int findoutYear(int year){
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

  public static double findoutDistance(int distance, int dyear){
    double distancepercent=((double)(distance/(double)dyear)*100);
    String distancepercentR= (distancepercent)+"";
    System.out.println("That is "+distancepercentR.substring(0,4)+" percent of a year away");
    if (distancepercent==0){
      System.out.println("Happy Birthday!");
    }
    return (distancepercent);
    }

  public static int findoutNumberDistance(int NumberPerson, int dyear, int NumberDate){
    int distance=0;
    if (NumberPerson<NumberDate){
      distance= dyear-(NumberDate-NumberPerson);
    }
    else {
      distance= NumberPerson-NumberDate;
    }
    return (distance);
  }

  public static void winner(double percentPerson1, double percentPerson2){
    System.out.println();
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
