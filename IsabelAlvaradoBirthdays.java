import java.util.Scanner;

public class IsabelAlvaradoBirthdays {
  //Main method
  public static void main (String[] args) {
    Scanner console= new Scanner(System.in);
    System.out.println("Without the / character, please type the month, day, and year in that order:");
    int month= Integer.parseInt(console.next());
    int day= Integer.parseInt(console.next());
    int year= Integer.parseInt(console.next());
    int dyear= findoutYear(year);
    month=checkingValidMonth(month,console);
    day= checkingValidDay(day,month,dyear,console);
    int NumberDate=findoutNumber(day,month,dyear);
    introduction(day,month,year,NumberDate);
    String Person= "Person 1";
    double percentPerson1=Base(console,Person,dyear,NumberDate,year);
    Person= "Person 2";
    double percentPerson2=Base(console,Person,dyear,NumberDate,year);
    winner(percentPerson1,percentPerson2);
  }
//Base is the information that will be gathered from the input provided by Person X
  public static double Base(Scanner console, String Person, int dyear, int NumberDate, int year){
    System.out.println();
    System.out.print(Person+ ": \nWhat month and day were you born in? ");
    int PersonMonth=Integer.parseInt(console.next());
    int PersonDay=Integer.parseInt(console.next());
    PersonMonth=checkingValidMonth(PersonMonth,console);
    PersonDay=checkingValidDay(PersonDay,PersonMonth,dyear,console);
    int NumberPerson=findoutNumber(PersonDay,PersonMonth,dyear);
    ZodiacSign(NumberPerson);
    int NumberDistancePerson=findoutNumberDistance(NumberPerson,dyear,NumberDate);
    System.out.println(Person+ "'s birthday is "+ NumberDistancePerson +" day(s) away from today");
    double percentPerson=findoutDistance(NumberDistancePerson,dyear);
    System.out.println(PersonMonth+"/"+PersonDay+"/"+year+" falls on day #"+NumberPerson+" out of "+dyear);
    if (PersonMonth==5&&PersonDay==3){
      System.out.println("That is also my Birthday! Fun Fact: May 3rd is a famous Spanish Painting about the Spanish Civil War");
    }
    return(percentPerson);
  }
  //Checks that month input is between 1 and 12
  public static int checkingValidMonth(int month, Scanner console){
    int valid=0;
     for (int i=0;valid==0;i++){
      if (month<1 || month>12){
        System.out.print("Please type a number between 1 and 12 for the month: ");
        month= console.nextInt();
      }
      else{
        valid++;
      }
    }
    return(month);
  }
//Checks that day input is between the range of the given month
  public static int checkingValidDay(int day, int month, int dyear,Scanner console){
    int valid=0;
    for (int i=0;valid==0;i++){
      if (month==1 || month==3 ||month==5 || month==7 ||month==8 || month==10 ||month==12){
        if (day<1||day>31){
          System.out.print("Please type a number between 1 and 31 for the day: ");
          day=console.nextInt();
        }
        else {
          valid++;
        }
      }
      else if (month==4|| month==6 || month==9 || month==11 ){
        if (day<1||day>30){
          System.out.print("Please type a number between 1 and 30 for the day: ");
          day=console.nextInt();
        }
        else {
          valid++;
        }
      }
      else if (month==2 && dyear==366){
        if (day<1||day>29){
          System.out.print("Please type a number between 1 and 29 for the day: ");
          day=console.nextInt();
        }
        else{
          valid++;
        }
      }
      else if (month==2 && dyear==365){
        if (day<1||day>28){
          System.out.print("Please type a number between 1 and 29 for the day: ");
          day=console.nextInt();
        }
        else {
          valid++;
        }
      }
    }
    return (day);
  }
//Provides the zodiac sign of the month and day provided with the number it represents
  public static void ZodiacSign(int number){
    System.out.print("Zodiac Sign: ");
    if (number>80&&number<109){
      System.out.println("Aries");
    }
    else if (number>=110&& number <=140){
      System.out.println("Taurus");
    }
    else if (number>=141&& number <=171){
      System.out.println("Gemini");
    }
    else if (number>=172&& number <=203){
      System.out.println("Cancer");
    }
    else if (number>=204&& number <=234){
      System.out.println("Leo");
    }
    else if (number>=235&& number <=265){
      System.out.println("Virgo");
    }
    else if (number>=266&& number <=295){
      System.out.println("Libra");
    }
    else if (number>=296&& number <=325){
      System.out.println("Scorpio");
    }
    else if (number>=326&& number <=355){
      System.out.println("Sagittarius");
    }
    else if (number>=356 || number <=19){
      System.out.println("Capricorn");
    }
    else if (number>=20&& number <=49){
      System.out.println("Aquarious");
    }
    else{
      System.out.println("Prisces");
    }

  }

//The introduction to the program
  public static void introduction(int day, int month, int year, int number) {
    String date= month+"/"+day+"/"+year;
    System.out.println("This program compares two birthdays \nand displays which one is sooner \nToday is " +date+ ", day #" +number+ " of the year.");
  }

//Returns the number of the given day and month
  public static int findoutNumber(int day, int month,int dyear) {
    System.out.println();
    int number=0;
    for (int i=0;i<=month-1;i++){
      if (i==0){
        number=0;
      }
      else if (i==1|| i==3 || i==5 || i==7|| i==8 || i==10 || i==12){
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

//It finds out if the year is a leap year or not
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

//Finds out the distance in percentage between the current date and the given birthday date
  public static double findoutDistance(int distance, int dyear){
    double distancepercent=((double)(distance/(double)dyear)*100);
    double distancepercentR=RoundNumber(distancepercent);
    System.out.println("That is "+distancepercentR+" percent of a year away");
    if (distancepercent==0){
      System.out.println("Happy Birthday!");
    }
    return (distancepercent);
    }

//Rounds the numbers
  public static double RoundNumber (double value) {
    int scale = (int) Math.pow(10, 1);
    double rounded= (double)Math.round(value * scale) / scale;
    return (rounded);
}
//Finds out the distance in numbers between the current date and the given birthday date
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

//Provides who's birthday is closer
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
