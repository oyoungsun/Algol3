import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int num;
    int weight;
    Node(int num, int weight){
        this.num = num;
        this.weight = weight;
    }
}
public class Main {
    static int max=0,n;
    static int max_idx;
    static ArrayList<Node> [] list;
    static boolean visit[];

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        list = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            int s = scan.nextInt();
            while(true) {
                int e = scan.nextInt();
                if(e == -1) break;
                int cost = scan.nextInt();
                list[s].add(new Node(e, cost));
            }
        }

        dfs(1,0);
        max=0;
        visit = new boolean[n+1];
        dfs(max_idx, 0);

        System.out.println(max);
    }

    private static void dfs(int idx, int sum) {
        if(max<sum){
            max = sum;
            max_idx = idx;
        }
        for(Node node : list[idx]){
            if(!visit[node.num]){
                visit[node.num]=true;
                dfs(node.num, sum+node.weight);
            }
        }
    }
}