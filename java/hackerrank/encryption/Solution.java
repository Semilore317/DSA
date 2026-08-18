import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Result {
  private static ArrayList<ArrayList<Integer>> findMinGrid(String s, int lMin, int lMax){
    Map<Integer, ArrayList<ArrayList<Integer>>> gridMap = new HashMap<>();
    
    // find all combos and compare area of each grid setup
    /*
    for(int i = lMin + 1; i < lMax; i++){
      for(int j = lMin + 1; j < lMax; j++){

      }
    }
    */
    
    return 
  }

  public static String encryption(String s) {
    String cleanedInput = s.trim();

    int lMax = (int) Math.ceil(Math.sqrt(cleanedInput.length()));
    int lMin = (int) Math.ceil(Math.sqrt(cleanedInput.length()));

    // lMin < rows < cols < lMax
    // rows * column >= cleanedInput.length()
    // find all the possible grids and choose the one with the min area
    findMinGrid(s, lMin, lMax);
    return "S";
  }

  public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      String s = bufferedReader.readLine();
      String result = Result.encryption(s);

      bufferedWriter.write(result);
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }
}
