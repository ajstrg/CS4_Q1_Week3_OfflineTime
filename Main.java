import java.util.Scanner;
import java.util.HashMap;


class DailyLog{

  Scanner input = new Scanner(System.in);
  
  public DailyLog(){
    enter_ratio();
  }

  HashMap<String, Float> online_activity = new HashMap<String, Float>();
  HashMap<String, Float> input_online_activity = new HashMap<String, Float>();

  public void enter_ratio() {

    System.out.print("How many hours offline for each hour of KHub? ");
    float ratio = input.nextFloat();
    online_activity.put("KHub", ratio);

    System.out.print("How many hours offline for each hour of gaming? ");
    ratio = input.nextFloat();
    online_activity.put("gaming", ratio);

    System.out.print("How many hours offline for each hour of youtube? ");
    ratio = input.nextFloat();
    online_activity.put("youtube", ratio);

    System.out.print("How many hours offline for each hour of social media? ");
    ratio = input.nextFloat();
    input.nextLine();
    online_activity.put("social media", ratio);

    System.out.println("");

  }
  
  public void log_activities(){

    ////// ADD CODE BELOW TO SOLVE THE PROBLEM

    boolean log_activity = true;
    boolean restart_application = true;
    float total_hours = 0;
    float offline_time = 0;
    float hours = 0;

    do {
      do {
        
        System.out.print("What will you do (KHub, gaming, youtube, social media, end)? ");
        String action = input.nextLine();

        switch(action) {
          case "KHub":
            System.out.print("For how many hours? ");
            hours = input.nextFloat();
            total_hours += hours;
            offline_time += (online_activity.get("KHub") * hours);
            input.nextLine();
            break;
          case "gaming":
            System.out.print("For how many hours? ");
            hours = input.nextFloat();
            total_hours += hours;
            offline_time += (online_activity.get("gaming") * hours);
            input.nextLine();
            break;
          case "youtube":
            System.out.print("For how many hours? ");
            hours = input.nextFloat();
            total_hours += hours;
            offline_time += (online_activity.get("youtube") * hours);
            input.nextLine();
            break;
          case "social media":
            System.out.print("For how many hours? ");
            hours = input.nextFloat();
            total_hours += hours;
            offline_time += (online_activity.get("social media") * hours);
            input.nextLine();
            break;
          case "end":
            log_activity = false;
            break;
          default:
            System.out.print("Invalid Input");
            break;
        }

        System.out.println();
  
      } while (log_activity);
  
      System.out.println("Total hours online: " + total_hours);
      System.out.println("Total offline hours needed: " + offline_time);
  
      if (total_hours + offline_time > 24) {
        System.out.println("Notice: You spent too long online today!");
      }
  
      System.out.println("Will you continue the program (y/n)?");
      String ans = input.nextLine();
      
      boolean isNo = ans.equals("n");

      if (isNo)
      {
        restart_application = false;
      }

      else {
        total_hours = 0;
        offline_time = 0;
        log_activity = true;
      }
      
    } while (restart_application);
    
    ////// ADD CODE ABOVE TO SOLVE THE PROBLEM

  }
 
}


class Person {

  String name;
  DailyLog my_daily_log;

  public Person(String n) {

    name = n;
    my_daily_log = new DailyLog();

  }

}


class Main {

  public static void main(String[] args) {

    Person p = new Person("Mary");
    p.my_daily_log.log_activities();

  }

}
