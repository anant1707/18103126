import java.util.*;
public class Solution1 {
    public static void main(String[] args) {

        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        String[] crops = new String[n];
        for (int i = 0; i < n; i++) {
            crops[i] = in.nextLine().trim();
        }

        System.out.print(replant(crops));
    }

    public static int replant(String[] crops) {
        int len = crops.length;
        String duplicate_crop[] = new String[len];
        for (int i = 0; i < len; ++i) {
            StringBuilder copy_crop = new StringBuilder(crops[i]);
            duplicate_crop[i] = copy_crop.reverse().toString();
        }
        int first_var = fun(crops);
        int second_var = fun(duplicate_crop);
        return (first_var > second_var) ? second_var : first_var;
    }

    public static int fun(String[] crops) {
        int dimension_x = crops.length;
        int dimension_y = crops[0].length();
        int crop_copy[][] = new int[dimension_x][dimension_y];
        for (int i = 0; i < dimension_x; ++i)
            Arrays.fill(crop_copy[i], 0);
        crop_copy[0][0] = 0;
        for (int i = 1; i < dimension_x; ++i) {
            crop_copy[i][0] = crop_copy[i - 1][0];
            if (crops[i].charAt(0) != ' ' && crops[i].charAt(0) == crops[i - 1].charAt(0)) {
                crop_copy[i][0] = 1 + crop_copy[i][0];
                String abc = crops[i];
                abc = ' ' + abc.substring(1);
                crops[i] = abc;
            }
        }
        for (int i = 1; i < dimension_y; ++i) {
            crop_copy[0][i] = crop_copy[0][i - 1];
            if (crops[0].charAt(i) != ' ' && crops[0].charAt(i) == crops[0].charAt(i - 1)) {
                crop_copy[0][i] = 1 + crop_copy[0][i];
                String abc = crops[0];
                abc = abc.substring(0, i) + ' ' + abc.substring(i + 1);
                crops[0] = abc;
            }
        }
        for (int i = 1; i < dimension_x; ++i) {
            for (int j = 1; j < dimension_y; ++j) {
                crop_copy[i][j] = crop_copy[i - 1][j] + crop_copy[i][j - 1] - crop_copy[i - 1][j - 1];
                if ((crops[i].charAt(j) == crops[i].charAt(j - 1)) || (crops[i].charAt(j) == crops[i - 1].charAt(j))) {
                    crop_copy[i][j] = 1 + crop_copy[i][j];
                    String abc = crops[i];
                    abc = abc.substring(0, j) + ' ' + abc.substring(j + 1);
                    crops[i] = abc;
                }
            }
        }
        return crop_copy[dimension_x - 1][dimension_y - 1];
    }
}