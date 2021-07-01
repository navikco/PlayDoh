package net.playdoh.algo;

//TC - Recursion - o(2^k)
//SC - Linear - o(n)
//Purpose - Push Zeros to the End
public class Memoizer {

    public static void main(String[] args) {

        int[] memoizer = new int[15];
        System.out.println("Fab[15] :>>> " + fib(15, memoizer));

        System.out.println("ClimbingStairs [4] :>>> " + climbStairs(4));
        System.out.println("CountWays [4] :>>> " + countWays(4));
        System.out.println("CountStairsCombinations [4] :>>> " + countStairsCombinations(4));
    }

    private static int fib(int num, int []memoizer) {

        System.out.println("Recursion ::: " + num);

        if (num <= 1)
            return num;

        if (memoizer[num - 1] == 0) {
//            System.out.println("Memoizer ::: " + (num - 1));
            memoizer[num - 1] = fib(num - 1, memoizer) + fib(num - 2, memoizer);
        }

        return memoizer[num - 1];
    }

    /**
     *
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
     */
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int countWays(int steps) {

        return fib(steps + 1, new int[steps + 1]);
    }

    public static int countStairsCombinations(int steps) {

        if (steps <= 1) {
            return steps;
        }

        int first = 1;
        int second = 1;
        int total = 0;

        for (int i = 2; i <= steps; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }
}
