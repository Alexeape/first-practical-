import java.util.Scanner;
public class StepTracker {
    int[] monthData;
    StepTracker() {
        monthData = new int[30];
    }
    void numberStepsPerDay () {

        for (int i = 0; i < monthData.length; i++) {
            System.out.println("День " + (i + 1) + ". Пройдено " + monthData[i] + " шагов");
        }
    }
    public static int changeStepsGoal(int stepsGoal, Scanner scanner) {
        System.out.println("Текущее значение: " + stepsGoal);
        System.out.println("Введите новое значение");
        int newGoal = scanner.nextInt();
            if (newGoal < 0) {
                System.out.println("Значение должно быть не меньше 0");
            } else {
                stepsGoal = newGoal;
                System.out.println("Изменена цель по количеству шагов. Теперь цель: " + stepsGoal + "шагов");
            }
            return stepsGoal;
    }
     int findBestSeries(int stepsGoal) {
        int bestSeries = 0;
        int bestSeriesMax = 0;
        for (int i = 0; i < monthData.length; i++) {
            if (monthData[i] > stepsGoal) {
                bestSeries = bestSeries + 1;
            } else {
                if (bestSeries > bestSeriesMax) {
                    bestSeriesMax = bestSeries;
                }
            }
        }
        return  bestSeries;
    }
     int saveSteps(Scanner scanner, int startStep) {
        System.out.println("За какой день вы хотите ввести количество шагов (от 1 до 30)?");
      int  day = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов:");
        int Step = scanner.nextInt();
        startStep = startStep + Step;
        monthData[day - 1] = monthData[day - 1] + Step;
        return startStep;
    }
    void findAverage() {
        int result = 0;
        for (int m : monthData) {
            result += m;
        }
        System.out.println("Среднее количество шагов " + result / monthData.length);
    }
     int findMaxStep() {
        int maxStep = 0;
        for (int i = 0; i < monthData.length; i++) {
            if (monthData[i] > maxStep) {
                maxStep = monthData[i];
            }
        }
        return maxStep;
    }
}