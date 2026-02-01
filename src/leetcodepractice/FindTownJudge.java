package leetcodepractice;
/*
https://leetcode.com/problems/find-the-town-judge/
997. Find the Town Judge
*/
public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        // The in & out degree counting approach.
        // Note: we don't create a Graph data structure here,
        // but simple use the adjacency matrix to simulate it.

        // Edge case: single person with no trust relationships is the judge
        if (n == 1) return 1;

        // need a to store in-degrees & out-degrees
        //    - an array
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        // iterate through the 2d array, trust
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            // Update in-degree & out-degree
            out[a]++;   // a trusts someone
            in[b]++;    // b is trusted by someone
        }

        // iterate from 1 to n:
        // which person had n-1 in-degrees and 0 out-degree?
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTownJudge solution = new FindTownJudge();

        // Case 1
        int n1 = 2;
        int[][] trust1 = {{1, 2}};
        System.out.println("Judge (Example 1): " + solution.findJudge(n1, trust1));
        // Output: 2

        // Case 2
        int n2 = 3;
        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println("Judge (Example 2): " + solution.findJudge(n2, trust2));
        // Output: 3

        // Case 3
        int n3 = 3;
        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Judge (Example 3): " + solution.findJudge(n3, trust3));
        // Output: -1
    }
}
/*
        Approach 1
        loop 1: take the ath character, and who do the trust?
        loop 2: take the bth character, search for who trusts them?

        which person trusts no one AND is trusted by everyone?
*/
/*
        Approach 2
        (a, b) -> a trusts b
            a => loses a value
            b => gains b value

        once the loop is completed, you know the person everyone trusts
*/
