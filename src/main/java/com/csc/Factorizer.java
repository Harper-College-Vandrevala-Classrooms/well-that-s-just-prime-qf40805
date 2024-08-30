package com.csc;

import java.util.ArrayList;
import java.util.List;

public class Factorizer {

    public List<Integer> getPrimeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        while (number % 2 == 0) { 
            primeFactors.add(2);
            number /= 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }
        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false; 
        }
        if (number <= 3) {
            return true; 
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; 
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeUsingFactors(int number) {
        List<Integer> primeFactors = getPrimeFactors(number);
        return primeFactors.size() == 1 && primeFactors.get(0) == number;
    }

    public String reduce(int numerator, int denominator) {
        if (denominator == 0) {
            return "Error: Denominator cannot be zero.";
        }
        int gcd = gcd(numerator, denominator);
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Factorizer factorizer = new Factorizer();
        
        // prime factors
        System.out.println("Prime factors of 9: " + factorizer.getPrimeFactors(9)); 
        System.out.println("Prime factors of 10: " + factorizer.getPrimeFactors(10)); 
        System.out.println("Prime factors of 11: " + factorizer.getPrimeFactors(11)); 


        // isPrime function
        System.out.println("Is 9 prime? " + factorizer.isPrime(9)); 
        System.out.println("Is 10 prime? " + factorizer.isPrime(10)); 
        System.out.println("Is 11 prime? " + factorizer.isPrime(11)); 

        // reduce function
        System.out.println("Reduced fraction of 6/12: " + factorizer.reduce(6, 12)); 
        System.out.println("Reduced fraction of 100/50: " + factorizer.reduce(100, 50)); 
        System.out.println("Reduced fraction of 10/0: " + factorizer.reduce(10, 0)); 
    }
}
