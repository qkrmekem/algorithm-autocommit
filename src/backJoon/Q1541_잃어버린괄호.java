package backJoon;

import java.util.*;

public class Q1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // 먼저 -기호가 붙은 부분을 나눔
        String[] arr = input.split("-");

        int result = 0;
        for (int i = 0; i < arr.length; i++) {

            // 나눠진 각 부분은 + 연산자만 남아있으므로 +연산자로 다시 나눔
            String[] tmp = arr[i].split("\\+");
            int sum = 0;

            // 각 수를 더해주고
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }

            // - 기호로 나뉜 배열의 첫 값은 무조건 양수이므로 결과값에 +로 누적
            if (i == 0) {
                result += sum;
            // 그 이후의 값들은 - 연산자로 시작되므로 결과값에 -로 누적
            }else{
                result -= sum;
            }

        }
        System.out.println(result);
    }
}
