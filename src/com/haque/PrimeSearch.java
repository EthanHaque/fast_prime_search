package com.haque;

import java.util.ArrayList;

public class PrimeSearch {

    static int max = 10000000;
    static boolean[] isprime = new boolean[max];
    static ArrayList<Integer> prime = new ArrayList<>();
    static ArrayList<Integer> smallest_prime_factor = new ArrayList<>(max);

    static void find_primes(int N) {
        isprime[0] = false;
        isprime[1] = false;

        for (int i = 2; i < N; i++) {
            if (isprime[i]) {
                prime.add(i);
                smallest_prime_factor.set(i, i);
            }

            for (int j = 0; j < prime.size() && i * prime.get(j) < N && prime.get(j) <= smallest_prime_factor.get(i); j++) {
                isprime[i * prime.get(j)] = false;
                smallest_prime_factor.set(i * prime.get(j), prime.get(j));
            }
        }
    }

    public static void main(String args[]) {
        int N = 10000000;

        for (int i = 0; i < max; i++) {
            isprime[i] = true;
            smallest_prime_factor.add(2);
        }
        find_primes(N);

        for (int i = 0; i < prime.size() && prime.get(i) <= N; i++)
            System.out.print(prime.get(i) + " ");
    }
}