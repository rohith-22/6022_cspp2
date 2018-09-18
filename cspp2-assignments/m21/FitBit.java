import java.util.Scanner;
public class FitBit {
  protected FitBit() {

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ActivityMonitor objectMonitor = new ActivityMonitor();
    while (sc.hasNext()) {
    String line = sc.nextLine();
    String[] tokens = line.split(" ");
    switch(tokens[0]) {
      case "Food":
      String[] items = tokens[1].split(",");
      FoodLog f = new FoodLog(items[0], items[1], items[2], items[3]);
      objectMonitor.addFood(f); 
      break;
      case "Water":
      items = tokens[1].split(",");
      WaterLog water = new WaterLog(items[0], items[1], items[2]);
      objectMonitor.addWater(water); //quantity, time.
      break;
      case "PhysicalActivity":
      items = tokens[1].split(",");
      PhysicalActivitiesLog p = new PhysicalActivitiesLog(items[0], items[1], items[2], items[3], items[4]);
      objectMonitor.addPhysicalActivities(p);
      break;
      case "Weight":
      items = tokens[1].split(",");
      WeightLog weight = new WeightLog(items[0], items[1], items[2], items[3]);
      objectMonitor.addWeight(weight);
      break;
      case "Sleep":
      items = tokens[1].split(",");
      SleepLog sleep = new SleepLog(items[0], items[1], items[2]);
      objectMonitor.addSleep(sleep);
      break;
      case "Summary" :
      if (tokens.length == 1) {
        objectMonitor.summary();
      } else {
        objectMonitor.summary(tokens[1]);
      }
      break;
      case "Foodlog":
      objectMonitor.foodlog();
      break;
      case "Waterlog":
      objectMonitor.waterlog();
      break;
      case "PhysicalActivitylog":
      objectMonitor.physicalactivitylog();
      break;
      case "Weightlog":
      objectMonitor.weightlog();
      break;
      case "Sleeplog":
      objectMonitor.sleeplog();
      break;
      default:
      }     
    }

  }
}
