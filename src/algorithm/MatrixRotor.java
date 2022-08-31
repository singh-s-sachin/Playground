package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MatrixRotor {
    public static List<List<Integer>> rotate(List<List<Integer>> matrix) {
        List<List<Integer>> response = new ArrayList<>();
        if (matrix.size() == 0 || matrix.get(0).size() == 0) {
            return new ArrayList<>();
        }
        int row = matrix.size();
        int col = matrix.get(0).size();
        for(int j=col-1;j>=0;j--) {
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                newRow.add(matrix.get(i).get(j));
            }
            response.add(newRow);
        }
        return response;
    }
}
