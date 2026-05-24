// HackerRank - GridSearch

import java.util.List;

public class GridSearch {
    public static boolean containsSubarray(List<String> mainArray, List<String> subArray) {
        if (subArray.size() == 0) {
            return true; // An empty subarray is considered present in any array.
        }
        if (subArray.size() > mainArray.size()) {
            return false; // A subarray cannot be larger than the main array.
        }

        // Iterate through the mainArray to find potential starting points
        for (int i = 0; i <= mainArray.size() - subArray.size(); i++) {
            boolean match = true;
            // Compare the current segment of mainArray with subArray
            for (int j = 0; j < subArray.size(); j++) {
                if (mainArray.get(i + j) != subArray.get(j)) {
                    match = false;
                    break; // Mismatch found, move to the next potential starting point
                }
            }
            if (match) {
                return true; // Subarray found
            }
        }
        return false; // Subarray not found
    }
    public static String gridSearch(List<String> G, List<String> P){
        // for each row in the String list:
        //      search for the first row in the pattern array and make sure they're in the same indices
        for(int i = 0; i <= G.size() - P.size(); i++){
            String currentRow = G.get(i);
            String firstPatternRow = P.get(0);
            int index = currentRow.indexOf(firstPatternRow);
            while(index != -1){
                // found a match for the first row of the pattern
                boolean matchFound = true;
                for(int j = 1; j < P.size(); j++){
                    String patternRow = P.get(j);
                    String gridRow = G.get(i + j);
                    if(!gridRow.startsWith(patternRow, index)){
                        matchFound = false;
                        break;
                    }
                }
                if(matchFound){
                    return "YES";
                }
                // look for the next occurrence of the first pattern row in the current grid row
                index = currentRow.indexOf(firstPatternRow, index + 1);
            }
        }
        return "NO";
    }

}
