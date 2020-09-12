import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long uniqueTripleCount = 0;

        int[] uniqueA = removeDuplicates(a);
        int[] uniqueB = removeDuplicates(b);
        int[] uniqueC = removeDuplicates(c);

        Arrays.sort(uniqueA);
        Arrays.sort(uniqueB);
        Arrays.sort(uniqueC);

        for (int x : uniqueB) {
            long c1 = getValidIndex(uniqueA, x) + 1;
            long c3 = getValidIndex(uniqueC, x) + 1;
            uniqueTripleCount += c1 * c3;
        }

        return uniqueTripleCount;
    }

    private static int[] removeDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int y : a) {
            set.add(y);
        }

        int len = set.size();

        int result[] = new int[len];
        int i = 0;
        for (int y : set) {
            result[i++] = y;
        }
        return result;
    }

    static int getValidIndex(int[] distinct, int key) {
        int low = 0;
        int high = distinct.length - 1;
        int count = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (distinct[mid] <= key) {
                count = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
