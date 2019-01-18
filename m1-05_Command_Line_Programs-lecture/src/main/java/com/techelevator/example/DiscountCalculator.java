package com.techelevator.example;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount price
        // The answer needs to be saved as a double
        System.out.print("Enter the discount price (w/out percentage): ");
        double discount = Double.parseDouble(scanner.nextLine()) / 100.0;

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String prices = scanner.nextLine();

        // Split the string up into separate values
        String[] priceArray = prices.split(" ");

        for(int i = 0; i < priceArray.length; i++) {
            // Read the individual value as a decimal
            double originalPrice = Double.parseDouble(priceArray[i]);

            // Cast the discount value to a decimal to allow the calculation
            double amountOff = originalPrice * (double)discount;

            // Calculate the sale price
            double salePrice = originalPrice - amountOff;

            System.out.println("Original Price:" + originalPrice + " Sale Price: " + salePrice);
        }

        scanner.close();
    }

}