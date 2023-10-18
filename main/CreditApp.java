package main;

import models.Credit;
import models.MortgageLoan;
import models.PersonalLoan;
import services.LoanManager;
import services.FileStorageManager;

import java.util.List;
import java.util.Scanner;

public class CreditApp {
    public static void main(String[] args) {
        LoanManager loanManager = new LoanManager();
        FileStorageManager fileStorageManager = new FileStorageManager();

        // Завантаження кредитів із файлу при запуску програми
        List<Credit> loadedCredits = fileStorageManager.loadCredits("credits.dat");
        if (loadedCredits != null) {
            loanManager.setAvailableCredits(loadedCredits);
            System.out.println("Кредити успішно завантажено із файлу.");
        }

        // Додамо деякі кредитні пропозиції для прикладу
        Credit personalLoan = new PersonalLoan("Bank A", 5.0, 5000, 24, "Особистi потреби");
        Credit mortgageLoan = new MortgageLoan("Bank B", 4.0, 10000, 36, "Бiзнес");


        loanManager.addCredit(personalLoan);
        loanManager.addCredit(mortgageLoan);

        // Створення об'єкту Scanner для зчитування введених даних користувачем
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Переглянути доступнi кредити");
            System.out.println("2. Пошук кредиту");
            System.out.println("3. Зберегти кредити у файл");
            System.out.println("4. Вихiд");

            System.out.print("Будь ласка, виберiть опцiю: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Перегляд доступних кредитів
                    List<Credit> availableCredits = loanManager.getAvailableCredits();
                    for (Credit credit : availableCredits) {
                        System.out.println(credit);
                        System.out.println("-----------");
                    }
                    break;

                case 2:
                    // Пошук кредиту
                    System.out.print("Введiть максимальну суму кредиту: $");
                    double maxLoanAmount = scanner.nextDouble();
                    System.out.print("Введiть максимальний строк погашення (у мiсяцях): ");
                    int maxLoanTermMonths = scanner.nextInt();

                    List<Credit> matchingCredits = loanManager.searchCredits(maxLoanAmount, maxLoanTermMonths);
                    if (matchingCredits.isEmpty()) {
                        System.out.println("Кредитiв не знайдено за вказаними параметрами.");
                    } else {
                        System.out.println("\nЗнайденi наступнi кредити:");
                        for (Credit credit : matchingCredits) {
                            System.out.println(credit);
                            System.out.println("-----------");
                        }
                    }
                    break;

                case 3:
                    // Збереження кредитів у файл
                    fileStorageManager.saveCredits(loanManager.getAvailableCredits(), "credits.dat");
                    System.out.println("Кредити успiшно збережено у файл.");
                    break;

                case 4:
                    // Вихід з програми
                    System.out.println("Дякуємо за використання додатку. До побачення!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Будь ласка, виберiть вiрну опцiю.");
                    break;
            }
        }
    }
}
