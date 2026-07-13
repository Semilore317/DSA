import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static int[][] A;
  static int[][] B;
  static int H;
  static int W;

  // maps the image name to the actual image matrix
  static Map<String, int[][]> imageMap = new HashMap<>();

  public static void imageContructor(int h, int w) {
    A = new int[H][W];
    B = new int[H][W];
    H = h;
    W = w;
  }

  public static int d(int[][] A, int[][] B) {
    int d = 0;
    for (int r = 0; r < H; r++) {
      for (int c = 0; c < W; c++) {
        d += (int) Math.pow((A[r][c] - B[r][c]), 2);
      }
    }

    return d;
  }

  public static void printClosest(int[][] query, Map<String, int[][]> imageMap) {
    int distance = Integer.MAX_VALUE;
    String closestImage = null;

    for (Map.Entry<String, int[][]> entry : imageMap.entrySet()) {
      String imageName = entry.getKey();
      int[][] imageMatrix = entry.getValue();

      int currentDistance = d(query, imageMatrix);

      if (currentDistance < distance) {
        closestImage = imageName;
        distance = d(query, imageMatrix);
      }
    }

    System.out.println(closestImage);
  }

  public static String[] tokenize(String input) {
    String[] tokenArr = input.split("\s");
    return tokenArr;
  }

  public static int[][] readMatrix(Scanner scanner, int rows, int cols, String matrixType) {
    int[][] matrix = new int[rows][cols];
    String name = null;

    if (matrixType.equals("trainingImage")) {
      name = scanner.nextLine();

      for (int i = 0; i < rows; i++) {
        // Read the entire line and split by any whitespace
        String[] tokens = scanner.nextLine().trim().split("\\s+");

        for (int j = 0; j < cols; j++) {
          // Safeguard against short lines, defaults to 0 if missing
          if (j < tokens.length) {
            matrix[i][j] = Integer.parseInt(tokens[j]);
          } else {
            matrix[i][j] = 0;
          }
        }
      }
    } else if (matrixType.equals("queryImage")) {
      for (int i = 0; i < rows; i++) {
        // Read the entire line and split by any whitespace
        String[] tokens = scanner.nextLine().trim().split("\\s+");

        for (int j = 0; j < cols; j++) {
          // Safeguard against short lines, defaults to 0 if missing
          if (j < tokens.length) {
            matrix[i][j] = Integer.parseInt(tokens[j]);
          } else {
            matrix[i][j] = 0;
          }
        }
      }
      printClosest(matrix, imageMap);
    }
    imageMap.put(name, matrix);
    return matrix;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] initArr = tokenize(sc.nextLine());
    imageContructor(
        Integer.parseInt(initArr[0]),
        Integer.parseInt(initArr[1]));

    int N = Integer.parseInt(sc.nextLine());
    int imagesSeen = 0;
    while (imagesSeen < N) {
      readMatrix(sc, H, W, "trainingImage");
      imagesSeen++;
    }

    int Q = Integer.parseInt(sc.nextLine());
    int queriesSeen = 0;
    while (queriesSeen < Q) {
      // iterate through the entire hashmap... if the d is less than previous
      // assign it that value
      // return d
      readMatrix(sc, H, W, "queryImage");
      queriesSeen++;
    }
    sc.close();
  }
}
