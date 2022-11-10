import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(br.readLine(),0);
        } // String, 첫 횟수
        int count = 0;
        for(int i=0; i<m; i++){
            String input = br.readLine();
            if(map.containsKey(input)) {
                System.out.println(map.get(input));
                count++;
            }
        }
        System.out.println(count);
    }
}
