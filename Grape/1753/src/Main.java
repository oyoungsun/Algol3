import org.w3c.dom.Node;

import java.util.*;

class Edge{
    int next;
    int weight;

    Edge(int n, int w){
        this.next = n;
        this.weight = w;
    }
}
public class Main {
    static int root;
    static ArrayList<Edge>[] arr;
    static final int INF = 100_000_000;
    static int V;
    static int E;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        V = sc.nextInt();
        E = sc.nextInt();
        root = sc.nextInt();
        Arrays.fill(dist, INF);
        arr = new ArrayList[V+1];
        dist = new int[V + 1];

        for(int i=1; i<=V; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new Edge(v,w));
        }
        dijkstra(root);
        for(int i=1; i<=V; i++) {
            if(dist[i]==INF) {
                sb.append("INF\n");
            }else sb.append(dist[i]+"\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int idx) {

        int temp = idx;
        for(edge i :arr[temp]){
            dist[i] = edge.
        }
    }

}
