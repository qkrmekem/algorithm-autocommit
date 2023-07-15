package backJoon.bruteForce;

public class Q4673 {
    // 셀프 넘버
    public static void main(String[] args) {
        // 셀프 넘버인지 아닌지 구분하기 위한 배열
        boolean[]selfNum = new boolean[10001];


        for (int i = 1;i<=10000;i++){
            int cnt = d(i);

            // 10000이 넘는 수는 필요 없으므로
            if (cnt <= 10000){
                selfNum[cnt] = true;
            }
        }

        // 불린 배열 값이 false인 것의 인덱스를 출력
        for (int i = 1; i<10001; i++){
            if (selfNum[i] == false){
                System.out.println(i);
            }
        }
    }

    private static int d(int num) {
        // 자기 자신을 저장할 변수
        int cnt = num;

        // 1의 자리부터 한 자리씩 누적하기 위한 반복문
        while (num != 0){
            cnt += num % 10;
            num /= 10;
        }

        return cnt;
    }
}
