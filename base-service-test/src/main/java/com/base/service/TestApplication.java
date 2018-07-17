package com.base.service;

import java.util.Scanner;

/**
 * Hello world!
 */

public class TestApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = -1;
        while((data = scanner.nextInt()) != -1) {
            System.out.println(findNextPrime(data));
        }
    }

    static int findNextPrime(int i) {
        int nextPrime = i+1<=2?2:i+1;
        if(nextPrime == 2)
            return nextPrime;
        while(true) {
            if(isPrime(nextPrime, 2, nextPrime))
                nextPrime++;
            else
                break;
        }
        return nextPrime;
    }

    static Boolean isPrime(int data, int factor1, int factor2) {
        if(factor1 > factor2)
            return false;
        return data % factor1 == 0 || isPrime(data, factor1 + 1, data/factor1);
    }

}
