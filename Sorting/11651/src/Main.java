import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int [n][2];

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i][1] = x;
            arr[i][0] = y;
        }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] e1, int[] e2) {
                    if (e1[0] == e2[0]) {        // 첫번째 원소가 같다면 두 번째 원소끼리 비교
                        return e1[1] - e2[1];
                    } else {
                        return e1[0] - e2[0];
                    }
                }
            });

        for(int i=0; i<n; i++) {
            System.out.println(arr[i][1] +" "+arr[i][0]);
        }

    }
}
