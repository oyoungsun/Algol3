import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

class Node{
    int c;
    int w;
    Node(int c, int w){
        this.c=c;
        this.w=w;
    }
}

public class Main {

    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node> list[];
    static boolean visit[];
    static int max=0;
    static int max_idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[p].add(new Node(c,w));
            list[c].add(new Node(p,w));
        }
        visit[1]=true;
        dfs(1, 0);

        visit = new boolean[n+1];
        visit[max_idx] = true;

        dfs(max_idx,0);
        System.out.println(max);

    }

    private static void dfs(int root, int sum) {
        if(max<sum){
            max=sum; //더했을때 max가 나오는 구간을 찾음
            max_idx = root;
        }
        for(Node i : list[root]){
            if(!visit[i.c]){
                visit[i.c]=true;
                dfs(i.c, sum+i.w);
            }
        }
    }

}