package qa;

import java.util.Scanner;

public class Airport {
    public static void main(String[] args) {

        // 1. Get information from the user
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount in GBP: ");
        double amountGBP = input.nextDouble();

        System.out.print("Choose a currency (1 = USD, 2 = EUR, 3 = JPY): ");
        int currencyChoice = input.nextInt();

        System.out.print("Enter customer type (R = Regular, V = VIP): ");
        char customerType = input.next().charAt(0);

        // 2. Select the exchange rate
        double exchangeRate;

        switch (currencyChoice) {
            case 1:
                exchangeRate = 1.25;
                break;

            case 2:
                exchangeRate = 1.15;
                break;

            case 3:
                exchangeRate = 180.50;
                break;

            default:
                System.out.println("Invalid currency choice");
                return;
        }

        // 3. Calculate the service fee
        double serviceFeeRate;

        if (amountGBP < 100) {
            serviceFeeRate = 0.05;
        } else {
            serviceFeeRate = 0.025;
        }

        double serviceFee = amountGBP * serviceFeeRate;
        double amountAfterFee = amountGBP - serviceFee;

        // 4. Calculate the airport tax
        double taxRate;

        if (customerType == 'R') {
            taxRate = 0.10;
        } else if (customerType == 'V') {
            taxRate = 0.05;
        } else {
            System.out.println("Invalid customer type");
            return;
        }

        double tax = amountAfterFee * taxRate;
        double amountAfterTax = amountAfterFee - tax;

        // 5. Convert the final amount to foreign currency
        double foreignAmount = amountAfterTax * exchangeRate;

        // 6. Cast the final amount to int
        int finalAmount = (int) foreignAmount;

        // 7. Display the results
        System.out.println("Amount after service fee: £" + amountAfterFee);
        System.out.println("Amount after tax: £" + amountAfterTax);
        System.out.println("Final amount in foreign currency: " + finalAmount);
    }
}