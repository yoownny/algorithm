import java.util.*;
import java.io.*;

class Solution {
    static int min;
    public int solution(int n, int[][] wires) {
        // 연결 리스트 그래프로 만들기
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        min = n;
        
        // 하나씩 끊어보면서 수 계산
        for(int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            // dfs 계산
            int num = dfs(list, visited, wire[0], wire[0], wire[1]);
            int diff = Math.abs(num - (n - num));
            min = Math.min(min, diff);
        }
        
        return min;
    }
    
    public static int dfs(ArrayList<Integer>[] list, boolean[] visited, int now, int start, int end) {
        visited[now] = true;
        int count = 1;
        
        for(int next : list[now]) {
            if((now==start && next == end)|| (now==end && next==start)) {
                continue;
            }
            
            if(!visited[next]) {
                count += dfs(list, visited, next, start, end);
            }
        }
        
        return count;
    }
  
}