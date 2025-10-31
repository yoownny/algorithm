import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) { 
        visited = new boolean[n];
        
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                dfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int n, int[][] computers, int node) {
        visited[node] = true;
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]==false && computers[node][i] == 1){
                dfs(n, computers, i);
            }
        }
    }
}