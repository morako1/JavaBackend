package CampusTycoon.GameLogic;

public class SatisfactionMeter {

    private static int satisfactionScore = 0;
    private static int newscore = 0;

    public static int getSatisfactionScore() {
        return satisfactionScore;
    }

    public static void increaseSatisfactionScore(int value) {
        newscore = satisfactionScore + value;
        satisfactionScore = newscore;
    }

    public static void decreaseSatisfactionScore(int value) {
        newscore = satisfactionScore - value;
        satisfactionScore = newscore;
    }

}
