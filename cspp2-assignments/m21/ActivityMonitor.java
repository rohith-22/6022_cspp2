class ActivityMonitor {
  List<FoodLog> foodlist = new List<FoodLog>();
  List<WaterLog> waterlist = new List<WaterLog>();
  List<PhysicalActivitiesLog> physicalActivitieslist = new List<PhysicalActivitiesLog>();
  List<WeightLog> weightlist = new List<WeightLog>();
  List<SleepLog> sleeplist = new List<SleepLog>();
  ActivityMonitor() {

  }
  public void addFood(FoodLog foodparameters) {
    foodlist.add(foodparameters);
  }
  public void addWater(WaterLog waterparameters) {
    waterlist.add(waterparameters);
  }
  public void addPhysicalActivities(PhysicalActivitiesLog physicalActivities) {
    physicalActivitieslist.add(physicalActivities);
  }
  public void addWeight(WeightLog weightparameters) {
    weightlist.add(weightparameters);
  }
  public void addSleep(SleepLog sleepparameters) {
    sleeplist.add(sleepparameters);
  }
  public void foodlog() {
    if (foodlist.size() == 0) {
      System.out.println("None");
      System.out.println("\n");
    }
    for (int i = 0; i < foodlist.size(); i++) {
      System.out.println(foodlist.get(i).toString());
    }   
  }
  public void waterlog() {
    if (waterlist.size() == 0) {
      System.out.println("None");
      System.out.print("\n");

    }
    for (int i = 0; i < waterlist.size(); i++) {
      System.out.println(waterlist.get(i).toString());
    }   
  }
  public void physicalactivitylog() {
    if (physicalActivitieslist.size() == 0) {
      System.out.println("PhysicalActivity");
      System.out.println("None");
      System.out.print("\n");
    }
    for (int i = 0; i < physicalActivitieslist.size(); i++) {
      System.out.println(physicalActivitieslist.get(i).toString());
    }   
  }
  public void weightlog() {
    if (weightlist.size() == 0) {
      System.out.println("None");
      System.out.print("\n");
    }
    for (int i = 0; i < weightlist.size(); i++) {
      System.out.println(weightlist.get(i).toString());
    } 
  }
  public void sleeplog() {
    if (sleeplist.size() == 0) {
      System.out.println("None");
      System.out.print("\n");
    }
    for (int i = 0; i < sleeplist.size(); i++) {
      System.out.println(sleeplist.get(i).toString());
    }
  }
  public void summary() {
    foodlog();
    waterlog();
    physicalactivitylog();
    weightlog();
    sleeplog(); 
  }
  public void summary(String date) {
    for (int i = 0; i < foodlist.size(); i++) {
      if (date.equals(foodlist.get(i).getDate())){
        System.out.print(foodlist.get(i).toString());
      }
    }
    for (int i = 0; i < waterlist.size(); i++) {
      if (date.equals(waterlist.get(i).getDate())){
        System.out.print(waterlist.get(i).toString());
      }   
    }
    for (int i = 0; i < physicalActivitieslist.size(); i++) {
      if (date.equals(physicalActivitieslist.get(i).getDate())){
        System.out.print(physicalActivitieslist.get(i).toString());
      }   
    }
    for (int i = 0; i < weightlist.size(); i++) {
      if (date.equals(weightlist.get(i).getDate())){
        System.out.print(weightlist.get(i).toString());
      }   
    }
    for (int i = 0; i < sleeplist.size(); i++) {
      if (date.equals(sleeplist.get(i).getDate())){
        System.out.print(sleeplist.get(i).toString());
      }   
    }
  }
}