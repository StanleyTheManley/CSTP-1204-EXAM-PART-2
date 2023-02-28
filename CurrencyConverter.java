import java.util.Scanner;
import java.util.ArrayList;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> currencies = new ArrayList<>();
        currencies.add("CAD");
        currencies.add("USD");
        currencies.add("EUR");

        ArrayList<Double> exchangeRates = new ArrayList<>();
        exchangeRates.add(1.0);
        exchangeRates.add(0.79);
        exchangeRates.add(0.67);

        while (true) {
            System.out.println("Enter a currency from the following list to convert to USD:");
            for (int i = 0; i < currencies.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, currencies.get(i));
            }
            System.out.println("Enter a number to select the currency (0 to quit):");

            int selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (selection < 1 || selection > currencies.size()) {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }

            String selectedCurrency = currencies.get(selection - 1);
            double exchangeRate = exchangeRates.get(selection - 1);

            System.out.printf("Enter an amount in %s to convert to USD:\n", selectedCurrency);
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.printf("You entered %s %s. How much do you want to convert?\n", selectedCurrency, amount);
            double amountToConvert = scanner.nextDouble();
            scanner.nextLine();

            double usdAmount = amountToConvert / exchangeRate;

            System.out.printf("%s %.2f is equivalent to USD %.2f\n", selectedCurrency, amountToConvert, usdAmount);
        }
    }
}
