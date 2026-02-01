package leetcodepractice;

public class SubtractPrdtSumDigits {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        String num = String.valueOf(n);

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            // num.charAt(i) returns a character (char), not a number.
            //                 '0' = 48
            // num.charAt(0) → '2' = 50
            // num.charAt(1) → '3' = 51
            // num.charAt(2) → '4' = 52
            // int digit = num.charAt(i) - '0';
            // 2 - 0 -> 50 - 48 = 2
            // 3 - 0 -> 51 - 48 = 3
            // 4 - 0 -> 52 - 48 = 4
            product *= digit;
            // product = 1 * 2
            // product = 2
            // product = 2 * 3
            // product = 6 * 4
            // product = 24
            sum += digit;
            // sum = sum + digit
            // sum = 0 + 2
            // sum = 2 + 3
            // sum = 5 + 4
            // sum = 9
        }

        return product - sum;
        // 24 - 9 = 15
    }

    public static void main(String[] args) {
        SubtractPrdtSumDigits sol = new SubtractPrdtSumDigits();
        System.out.println(sol.subtractProductAndSum(234));
    }
}
