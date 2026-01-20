// https://www.hackerrank.com/challenges/maximum-element/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (String op : operations) {
            String[] parts = op.split(" ");

            // Type 1: Push
            if (parts[0].equals("1")) {
                int val = Integer.parseInt(parts[1]);
                stack.push(val);

                if (maxStack.isEmpty()) {
                    maxStack.push(val);
                } else {
                    maxStack.push(Math.max(val, maxStack.peek()));
                }
            }

            // Type 2: Pop
            else if (parts[0].equals("2")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    maxStack.pop();
                }
            }

            // Type 3: Get Max
            else if (parts[0].equals("3")) {
                result.add(maxStack.peek());
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
