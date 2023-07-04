package com.greatlearning;



import java.util.Scanner;

public class PayMoneyTransaction {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("PayMoney processes thousands of transactions daily, amounting to millions of Rupees.");
       System.out.println("They also have a daily target that they must achieve.");

       System.out.print("Enter the size of the transaction array: ");
       int transactionArraySize = scanner.nextInt();

       int[] transactionValues = new int[transactionArraySize];
       System.out.print("Enter the values of the array: ");
       for (int i = 0; i < transactionArraySize; i++) {
           transactionValues[i] = scanner.nextInt();
       }

       System.out.print("Enter the total number of targets that need to be achieved: ");
       int totalTargets = scanner.nextInt();

       for (int t = 0; t < totalTargets; t++) {
           System.out.print("Enter the value of the target: ");
           int targetValue = scanner.nextInt();

           int transactionIndex = findTransaction(targetValue, transactionValues);

           if (transactionIndex != -1) {
               System.out.println("Target achieved after " + transactionIndex + " transaction(s)");
           } else {
               System.out.println(" GIven target is not achieved");
           }
       }
   }

   public static int findTransaction(int target, int[] transactions) {
       int cumulativeSum = 0;
       for (int i = 0; i < transactions.length; i++) {
           cumulativeSum += transactions[i];
           if (cumulativeSum >= target) {
               return i + 1;  // Return the number of transactions needed to achieve the target
           }
       }
       return -1;  // Target not achieved
   }
}






