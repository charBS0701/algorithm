import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = scanner.nextInt();
        }
        scanner.close();
        
        System.out.println(longestSubarrayWithTwoTypes(fruits));
    }

    public static int longestSubarrayWithTwoTypes(int[] fruits) {
        int n = fruits.length;
        if (n == 0) return 0;
        
        int maxLength = 0;
        int start = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        for (int end = 0; end < n; end++) {
            fruitCount.put(fruits[end], fruitCount.getOrDefault(fruits[end], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[start], fruitCount.get(fruits[start]) - 1);
                if (fruitCount.get(fruits[start]) == 0) {
                    fruitCount.remove(fruits[start]);
                }
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
