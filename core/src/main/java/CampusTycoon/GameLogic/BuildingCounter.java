package CampusTycoon.GameLogic;

public class BuildingCounter {

    private static int buildingCount = 0;

    public static int getBuildingCounter() {
        return buildingCount;
    }

    public static void increaseBuildingCounter(int value) {
        buildingCount += 1;
    }

    public static void decreaseBuildingCounter(int value) {
        buildingCount -= 1;
    }

}
