import java.util.ArrayList;
import java.util.List;

public class LinesComparison {

    public static List<String> linesComparison(List<String[]> firstList, List<String[]> secondList) {
        List<String> result = new ArrayList<>();
        if (firstList.size() == 1 && secondList.size() == 1) {
            result.add(String.join(" ", firstList.get(0)) + ":" + String.join(" ", secondList.get(0)));
        } else {
            List<Integer> indexesUsedLinesSecondList = new ArrayList<>();
            for (String[] lineFromFirstList : firstList) {
                int[] maxMatches = new int[secondList.size()];
                int bestMatchIndex = -1;

                for (int j = 0; j < secondList.size(); j++) {
                    String[] lineFromSecondList = secondList.get(j);
                    int counter = findMatchesQuantity(lineFromFirstList, lineFromSecondList);
                    if (counter > 0) {
                        maxMatches[j] = counter;
                    }
                }

                int maxNum = maxMatches[0];
                for (int l = maxMatches.length - 1; l >= 0; l--) {
                    if (maxMatches[l] >= maxNum && maxMatches[l] > 0) {
                        bestMatchIndex = l;
                    }
                }
                result.add(String.join(" ", lineFromFirstList) + ":" + ((bestMatchIndex < 0) ? "?" : String.join(" ", secondList.get(bestMatchIndex))));
                if (bestMatchIndex != -1) {
                    indexesUsedLinesSecondList.add(bestMatchIndex);
                }
            }
            for (int j = 0; j < secondList.size(); j++) {
                if (!indexesUsedLinesSecondList.contains(j)) {
                    result.add(String.join(" ", secondList.get(j)) + ":?");
                }
            }
        }
        return result;
    }

    private static int findMatchesQuantity(String[] lineFromFirstList, String[] lineFromSecondList) {
        int counter = 0;
        for (String value : lineFromFirstList) {
            for (String s : lineFromSecondList) {
                if (value.toLowerCase().contains(s.toLowerCase()) && value.length() > 3 && s.length() > 3) {
                    counter++;
                } else if (s.toLowerCase().contains(value.toLowerCase()) && value.length() > 3 && s.length() > 3) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
