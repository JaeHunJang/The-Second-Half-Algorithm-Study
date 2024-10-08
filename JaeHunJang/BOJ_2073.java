import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수도배관공사
public class BOJ_2073 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int distance, town;
        int MAX = 33554432;

        StringTokenizer input = new StringTokenizer(br.readLine());

        distance = Integer.parseInt(input.nextToken());
        town = Integer.parseInt(input.nextToken());

        int[] dp = new int[distance + 1];

        dp[0] = MAX;

        for (int x = 0; x < town; x++) {
            int length, capacity;

            StringTokenizer pipe = new StringTokenizer(br.readLine());

            length = Integer.parseInt(pipe.nextToken());
            capacity = Integer.parseInt(pipe.nextToken());

            for (int y = distance; y >= length; y--) {
                dp[y] = Math.max(dp[y], Math.min(capacity, dp[y - length]));
            }

        }

        System.out.println(String.valueOf(dp[distance]) + "\n");

    }
}