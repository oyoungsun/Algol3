import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int cap=2;
        int n=7;
        int [][] users = {{40,2900},{23,10000},{11,5200},{5,5900},{40, 3100},{27, 9200},{32, 6900}};

        int [] emoticons = {1300,1500,1600,4900};
        int[] answer =s.solution(users, emoticons);
        System.out.println(answer[0]+" "+answer[1]);
    }
}

class Solution {
    static int idealPlus=0;
    static int idealConsum=0;
    static boolean visit[][];
    static int sales[];
    public int[] solution(int[][] users, int[] emoticons) {
        visit = new boolean[emoticons.length][4];
        sales = new int [emoticons.length];
        combination(0, emoticons.length, users, emoticons);


        int[] answer = new int[]{idealPlus, idealConsum};
        return answer;
    }

    private void combination(int high, int n, int[][] users, int[] emoticons) {
        if(high==n){
            sale(users,emoticons);
            return;
        }
        for(int i=0; i<4; i++){
            if(!visit[high][i]){
                visit[high][i]=true;
                sales[high]=(i+1)*10; //4개중에 하나
                combination(high+1, n, users, emoticons);
                visit[high][i]=false;
            }
        }
    }

    private void sale(int[][] users, int[] emoticons) {
        int totalPlus=0;
        int totalConsum=0;

        for(int u=0; u<users.length; u++){
            int totalmoney=0;
            for(int i=0; i<sales.length; i++){//모든 이모티콘 할인적용 후 총 구매비용
                if(sales[i]>=users[u][0]){ //할인 기준에 만족한다면
                    int salemoney = emoticons[i]*(100-sales[i])/100;
                    totalmoney += salemoney; //할인가에 맞춰 구매한다.
                }
            }
            if(totalmoney>=users[u][1]){ //가격 기준 이상이면 구매를 취소한다.
                totalPlus +=1;
                totalmoney=0;
            }
            totalConsum+=totalmoney;
        }
        findIdeal(totalPlus, totalConsum); //이상값을 찾는다.
        return;
    }

    private void findIdeal(int totalPlus, int totalConsum) {
        if(idealPlus<totalPlus){
            idealPlus = totalPlus;
            idealConsum = totalConsum;
        }
        if(idealPlus==totalPlus){
            idealConsum = Math.max(idealConsum, totalConsum);
        }
        else{
            //플러스 수가 더 적다면 굳이 이번 방법을 채택하지 않는다.
        }
        return;
    }
}
