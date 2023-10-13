package programmers;

import java.util.*;

public class Pro_리코쳇로봇 {
    public int solution(String[] board) {
        int answer = 0;

        // 시작 지점과 끝 지점
        Node start = null;
        Node goal = null;

        // 현재 위치가 방문했는지 여부
        boolean[][] visited = new boolean[board.length][board[0].length()];

        // 상하좌우로 인덱스를 옮기기 위해 더해줄 숫자
        int[] px = {1,0,-1,0};
        int[] py = {0,1,0,-1};

        // 시작지점, 끝 지점 위치 파악
        for(int i = 0; i < board.length; i++){
            for(int y = 0; y < board[i].length(); y++){
                if(board[i].charAt(y) == 'R'){
                    start = new Node(i,y,0);
                }
                if(board[i].charAt(y) == 'G'){
                    goal = new Node(i,y,0);
                }
            }
        }


        // bfs
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.x][now.y] = true;

            // 만약 현재 위치가 목표 지점이라면 현재 이동횟수를 반환
            if(now.x == goal.x && now.y == goal.y){
                return now.depth;
            }

            // 상하좌우로 이동하며 목표지점으로 이동
            for(int i = 0; i < 4; i++){
                int nextX = now.x;
                int nextY = now.y;
                // 한칸씩 이동하는 bfs와 달리 벽을 만나거나, 장애물을 만날 때까지
                // 현재 방향으로 쭉 이동해야 하므로 while 이용
                while(true){
                    nextX += px[i];
                    nextY += py[i];
                    // 벽이나 장애물을 만나면
                    if(nextX < 0 || nextX >= board.length || nextY < 0
                            || nextY >= board[0].length() || board[nextX].charAt(nextY) == 'D'){
                        // 벽이나 장애물을 만나기 직전 위치로 수정 후 break
                        nextX -= px[i];
                        nextY -= py[i];
                        break;
                    }
                }

                // 이동한 위치를 방문한적이 없는 위치라면 탐색을 진행하고 이동횟수를 +1 해줌
                if(!visited[nextX][nextY]){
                    q.add(new Node(nextX,nextY,now.depth+1));
                }
            }
        }



        return -1;
    }


    class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
