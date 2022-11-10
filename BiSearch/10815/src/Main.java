import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m  = sc.nextInt();        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            sb.append(findM(sc.nextInt(), arr, n)).append(" ");
        }
        System.out.println(sb);
    }

    private static int findM(int num, int[] arr, int n) {
        int min = 0;
        int max = n-1;
        while(min<=max){
            int mid = (min+max)/2;

            if(arr[mid]<num){
                min = mid+1;
            }else{
                max = mid-1;
            }
            if(arr[mid]==num) return 1;
        }
        return 0;
    }
}
