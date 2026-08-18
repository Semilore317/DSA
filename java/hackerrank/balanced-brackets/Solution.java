import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
class Result{
    public static String isBalanced(String s){
        Map<String, String> pairs = new HashMap<>();
        pairs.put(")", "(");
        pairs.put("]", "[");
        pairs.put("}", "{");

        // 0 1 2 3 4 5
        char[] arr = s.toCharArray();

        String result = "YES";

        if(s.length() % 2 == 1)
            return "NO";
        for(int i = 0; i < s.length(); i++){
            String open = String.valueOf(s.charAt(i));
            int j = s.length() - i - 1;
            String close = String.valueOf(s.charAt(j));

            if(pairs.get(close).equals(open)){
                result = "YES";
            }else{
                result = "NO";
            }
        }
        return result;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}