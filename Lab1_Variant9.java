import java.util.*;

public class Lab1_Variant9 {

    private static final String DEVELOPER = "Kozhemiako Dima";
  
    private static final int ROWS = 2;
    private static final int COLS = 3;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        System.out.println("Розробник: " + DEVELOPER);

        int[][] A = generateMatrix(ROWS, COLS, MIN_VALUE, MAX_VALUE);

        System.out.println("\nМатриця A (до обробки):");
        printMatrix(A);

        
        Set<Integer> duplicates = findDuplicates(A);

       
        System.out.println("\nМатриця A (після обробки):");
        printMatrix(A);

        System.out.println("\nЧисла, що зустрічаються в матриці більше одного разу:");
        if (duplicates.isEmpty()) {
            System.out.println("Немає");
        } else {
            for (int x : duplicates) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int rows, int cols, int min, int max) {
        Random rnd = new Random();
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = rnd.nextInt(max - min + 1) + min; // [min; max]
            }
        }
        return m;
    }

    private static Set<Integer> findDuplicates(int[][] m) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] row : m) {
            for (int val : row) {
                counts.put(val, counts.getOrDefault(val, 0) + 1);
            }
        }

       
        Set<Integer> dup = new LinkedHashSet<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue() > 1) {
                dup.add(e.getKey());
            }
        }
        return dup;
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}