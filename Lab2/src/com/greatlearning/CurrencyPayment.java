package com.greatlearning;

import java.util.*;

public class CurrencyPayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input of the size of currency denominations
        System.out.print("Enter the size of currency denominations: ");
        int size = scanner.nextInt();

        // Take input of the currency denominations
        System.out.println("Enter the currency denominations value:");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Take input of the amount you want to pay
        System.out.print("Enter the amount you want to pay: ");
        int amount = scanner.nextInt();

        Map<Integer, Integer> paymentApproach = getPaymentApproach(denominations, amount);
        if (paymentApproach.isEmpty()) {
            System.out.println("It's not possible to pay the exact amount.");
        } else {
            System.out.println("Your payment approach in order to give the minimum number of notes will be:");
            for (Map.Entry<Integer, Integer> entry : paymentApproach.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    public static Map<Integer, Integer> getPaymentApproach(int[] denominations, int amount) {
        Map<Integer, Integer> paymentApproach = new LinkedHashMap<>();
        Arrays.sort(denominations);

        for (int i = denominations.length - 1; i >= 0; i--) {
            int denomination = denominations[i];
            int count = amount / denomination;
            if (count > 0) {
                paymentApproach.put(denomination, count);
                amount %= denomination;
            }
        }

        if (amount == 0) {
            return paymentApproach;
        } else {
            return new HashMap<>();  // Return an empty map if it's not possible to pay the exact amount
        }
    }
}
