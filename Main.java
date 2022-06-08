import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker();
        double Distance = 75;
        double Calories = 50;
        int stepsGoal = 10000;

        int startStep = 0;

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {   // обработка разных случаев
                startStep = stepTracker.saveSteps(scanner, startStep);
            } else if (userInput == 2) {
                System.out.println("Что вы хотите сделать? ");
                System.out.println("1 - Количество пройденных шагов по дням");
                System.out.println("2 - Общее количество шагов за месяц");
                System.out.println("3 - Максимально пройденное количество шагов в месяце");
                System.out.println("4 - Среднее количество шагов");
                System.out.println("5 - Лучшая серия");
                System.out.println("6 - Пройденная дистанция");
                System.out.println("7 - Количество сожжённых килокалорий;");
                System.out.println("0 - вернуться в главное меню");
                int command = scanner.nextInt();

                if (command ==1) {
                    stepTracker.numberStepsPerDay();
                } else if (command == 2) {
                    System.out.println("Общее количество шагов за месяц: "  + startStep);
                }
                else if (command == 3) {
                    System.out.println("Самое большое количество шагов за этот месяц составило: " + stepTracker.findMaxStep());
                } else if  (command == 4) {
                    stepTracker.findAverage();
                } else if  (command == 5) {
                    System.out.println("Самая большая сумма расходов на этой неделе составила: " + stepTracker.findBestSeries(stepsGoal));
                } else if (command == 6) {
                    converter.findDistance( startStep, Distance);

                } else if (command == 7) {
                    converter.findCalories(startStep,Calories);

                } else if (command == 0) {
                    System.out.println(" ");

                } else {
                    System.out.println("Такой команды нет");
                  }

            } else if (userInput == 3) {

              stepsGoal = stepTracker.changeStepsGoal(stepsGoal, scanner);

            } else {
                System.out.println("Такой команды нет");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
    public static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}