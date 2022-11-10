
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Edge implements Comparable<Edge>{
    int next, weight;

    public Edge(int next, int weight){
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

public class Main {
    static int root;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Edge>[] arr;
    static final int INF = 100000000;
    static int V;
    static int E;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(br.readLine());
        arr = new ArrayList[V+1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        for(int i=1; i<=V; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[start].add(new Edge(end, weight));

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


        PriorityQueue<Edge> q = new PriorityQueue<>();

        boolean visit[]= new boolean[V+1];
        q.add(new Edge(idx,0));
        dist[idx]=0;

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int temp = cur.next;

            if(visit[temp]==true) continue;
            visit[temp]=true;

            for(Edge i :arr[temp]){
                if(i.weight+dist[temp]<dist[i.next]) {
                    dist[i.next] = i.weight+dist[temp];
                    q.add(new Edge(i.next, dist[i.next]));
                }
            }
    }
    }

}
