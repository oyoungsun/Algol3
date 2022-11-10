
import java.io.IOException;
import java.util.*;


public class Main {
    static int arr[];
    static int n;
    static long last=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int need = sc.nextInt();
        arr = new int [n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            last = Math.max(last, arr[i]);
        }
        last++;

        long result = binarySearch(arr, need);
        System.out.println(result);
    }

    public static long binarySearch(int[] arr, int need) {
        long start = 0;

        long mid=0;
        while(start<last){
            long count=0;
            mid = (start+last)/2;
            for(int i=0; i<n; i++){
                count += arr[i]/mid;
            }
            if(count<need){ //넘친다.
                last=mid;

            }else{ //부족하면 start높인다.
                start = mid+1;
            }
        }
        return start -1;
    }
}
