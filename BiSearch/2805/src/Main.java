
import java.io.IOException;
import java.util.*;


public class Main {
    static int arr[];
    static int n;
    static int last=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int meter = sc.nextInt();
        arr = new int [n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            last = Math.max(last, arr[i]);
        }

        int result = binarySearch(arr, meter);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int meter) {
        int start = 0;

        int mid=0;
        while(start<last){
            mid = (start+last)/2;
            long sum=0;
            for(int i=0; i<n; i++){
                if(arr[i]>mid){
                    sum += arr[i]-mid; //자르려는 길이보다 크면 자른다.
                }
            }
            if(sum<meter){ //넘친다.
                last=mid;

            }else{ //적다 - > 최대를 줄여야함
                start = mid+1;
            }
        }
        return start-1;
    }
}
