package backJoon;

import java.io.*;
import java.util.*;

public class Q1043_거짓말 {

    static int[] person;
    static int[] knowT;
    static ArrayList<Integer>[] party;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람 수
        int n = Integer.parseInt(st.nextToken());
        // 파티 수
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 진실을 아는 사람 수
        int t_count = Integer.parseInt(st.nextToken());
        // 진실을 아는 사람의 번호
        knowT = new int[t_count + 1];
        // 진실을 아는 사람 초기화
        for (int i = 1; i <= t_count; i++) {
            knowT[i] = Integer.parseInt(st.nextToken());
        }
        // 각 파티의 정보 초기화
        party = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            // 파티 참석 인원
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 각 사람 번호 초기화
        person = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            person[i] = i;
        }

        // 파티에 참가한 사람 하나로 묶기
        for (int i = 1; i <= m; i++) {
            int first = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean result = true;
            // 파티에 참가한 사람은 모두 한 집합으로 묶여있으므로
            // 파티에 참석한 사람중 하나를 선택
            int now = party[i].get(0);
            for (int j = 1; j < knowT.length; j++) {
                // 진실을 알고 있는 사람의 집합과
                // 파티에 참석한 사람의 집합이 하나라도 일치하면
                if (find(now) == find(knowT[j])) {
                    // 과장을 할 수 없다는 뜻이므로
                    // result를 false로 수정
                    result = false;
                    break;
                }
            }
            // 진실을 아는 사람이 없다면 cnt에 +1을 누적
            if (result) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            person[b] = a;
        }
    }

    public static int find(int a) {
        if (person[a] == a) {
            return a;
        } else {
            return person[a] = find(person[a]);
        }
    }
}
