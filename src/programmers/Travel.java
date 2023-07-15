package programmers;

import java.util.*;

class Travel {

    // 무인도 여행

    static boolean[][] visited;
    static char[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public Integer[] solution(String[] maps) {
        int[] answer = {};

        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i< maps.length; i++){
            for(int y = 0; y < maps[i].length(); y++){
                map[i][y] = maps[i].charAt(y);
            }
        }

        for(int i = 0; i < map.length; i++){
            for(int y = 0; y < map[0].length; y++){
                if(visited[i][y] == false && map[i][y] != 'X'){
                    list.add(bfs(new Pos(i, y)));
                }
            }
        }

        Collections.sort(list);

        if(list.size() == 0){
            list.add(-1);
        }

        return list.toArray(new Integer[0]);
    }

    public static int bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        int sum = 0;
        while(q.isEmpty() == false){
            Pos cur = q.poll();

            sum += map[cur.x][cur.y]-'0';
            for(int i = 0; i < dx.length; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(check(nx, ny) && map[nx][ny] != 'X'){
                    q.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }

    public static boolean check(int nx, int ny){
        if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && visited[nx][ny] == false){
            return true;
        }else return false;
    }
}

class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}