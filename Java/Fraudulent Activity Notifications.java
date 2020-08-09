import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notif = 0;
        int[] data = new int[201];

        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            double median = 0;
            if (d % 2 == 0) {
                Integer lm = null;
                Integer rm = null;
                int count = 0;
                for (int j = 0; j < data.length; j++) {
                    count += data[j];
                    if (lm == null && count >= d/2) {
                        lm = j;
                    } if (rm == null && count >= d/2 + 1) {
                        rm = j;
                        break;
                    } 
                }
                median = (lm + rm) / 2.0;
            } else {
                int count = 0;
                for (int j = 0; j < data.length; j++) {
                    count += data[j];
                    if (count > d/2) {
                        median = j;
                        break;
                    }
                }
            }

            if (expenditure[i] >= 2 * median) {
                notif++;
            }

            data[expenditure[i]]++;
            data[expenditure[i-d]]--;
        }

        return notif;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
