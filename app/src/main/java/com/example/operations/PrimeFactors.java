package com.example.operations;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class PrimeFactors {

    PrimeCheckActivity primeCheck;

    public Map<Long, Integer> findPrimeFactors(long num) {
        Map<Long, Integer> factors = new LinkedHashMap<>();
        if (num >= 2) {
            while (num % 2 == 0) {
                if (factors.containsKey(2L)) {
                    factors.put(2L, factors.get(2L) + 1);
                } else {
                    factors.put(2L, 1);
                }
                num = num / 2;
            }
            while (num % 3 == 0) {
                if (factors.containsKey(3L)) {
                    factors.put(3L, factors.get(3L) + 1);
                } else {
                    factors.put(3L, 1);
                }
                num /= 3;
            }
            int n = 1;
            int i = 5;
            while (i <= num && num > 0) {
                i = n * 6 - 1;
                while (num % i == 0) {
                    if (factors.containsKey((long) i)) {
                        factors.put((long) i, factors.get((long) i) + 1);
                    } else {
                        factors.put((long) i, 1);
                    }
                    num /= i;
                }
                i = n * 6 + 1;
                while (num % i == 0) {
                    if (factors.containsKey((long) i)) {
                        factors.put((long) i, factors.get((long) i) + 1);
                    } else {
                        factors.put((long) i, 1);
                    }
                    num /= i;
                }
                n++;
                if (new PrimeCheckActivity().isPrime(num)){
                    if (factors.containsKey(num)) {
                        factors.put(num, factors.get(num) + 1);
                    } else {
                        factors.put(num, 1);
                    }
                    return factors;
                }
            }
            return factors;
        }
        return null;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        long n = Long.parseLong(br.readLine());
        Map<Long, Integer> factors;
        PrimeFactors obj = new PrimeFactors();
        factors = obj.findPrimeFactors(n);
        for (Map.Entry<Long, Integer> m : factors.entrySet()) {
            System.out.println(m.getKey()+" : "+m.getValue());
        }
    }
}
