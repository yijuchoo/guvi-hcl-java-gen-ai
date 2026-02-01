package leetcodepractice;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/pascals-triangle/description/
118. Pascal's Triangle
*/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        // Step 1: Create a list to store all rows
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Step 2: Loop through each row
        for (int i = 0; i < numRows; i++) {
            // Step 3: Create a new row
            // store one row at a time
            List<Integer> row = new ArrayList<>();
            // Put 1 at the end of the list called row
            row.add(1);
            // Output: [1]

            // Add middle numbers
            // i = 0; j = 1; j < i = false. not executed
            // i = 1; j = 1; j < i = false. not executed
            // i = 2; j = 1; j < i = true. executed
            // triangle.get(2 - 1) = triangle.get(1) -> previous row [1, 1]
            // triangle.get(1).get(1 - 1) = triangle.get(1).get(0) -> get index 0 -> 1
            // 1 + 1 = sum -> 2
            for (int j = 1; j < i; j++) {
                int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i -1).get(j);
                // row = [1]
                // add 2 to row = [1, 2]
                row.add(sum);
            }
            // Last no. is also 1 (except first row)
            // i = 0; i > 0 = false. not executed
            // i = 1; i > 0 = true. [1] + row.add(1) = [1, 1]
            // i = 2; i > 0 = true. [1, 2] + row.add(1) = [1, 2, 1]
            if (i > 0) {
                // Put 1 at the end of the list called row
                // row = [1, 2]
                // add 1 to row = [1, 2, 1]
                row.add(1);
            }
            // Add the row to the triangle
            // when i = 2;
            // triangle = [1], [1, 1], [1, 2, 1]
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }
}
/*
numRows = 5
Row 1: [1] - index 0
Row 2: [1, 1] - index 1
Row 3: [1, 2, 1] - index 2 -> execute for loop of j
Row 4: [1, 3, 3, 1] - index 3
Row 5: [1, 4, 6, 4, 1] - index 4

Every row starts with 1
Every row ends with 1
Numbers in between are: above-left + above-right
*/
