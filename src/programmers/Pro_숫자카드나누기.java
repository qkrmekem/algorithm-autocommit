package programmers;

public class Pro_숫자카드나누기 {

    // 주어진 숫자가 배열에서 전혀 나뉘지 않는 숫자인지
    public boolean notDivisible(int[] arr, int num){
        for(int n : arr)
            if(n % num == 0)
                return false;
        return true;
    }

    // 최대 공약수 구하기
    public int gcd(int a, int b){
        if(a % b == 0)return b;
        return gcd(b, a % b);
    }
    public int solution(int[] arrayA, int[] arrayB) {

        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열의 최대 공약수 구하기
        for(int i =1; i< arrayA.length;i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 각 배열의 최대 공약수가 서로 나눌 수 없는 숫자인지 확인
        // 만약 나눌 수 없다면(조건에 충족하면)
        // 그중 최대값을 반환값 answer에 저장
        if(notDivisible(arrayB, gcdA))
            if(answer < gcdA)
                answer = gcdA;

        if(notDivisible(arrayA, gcdB))
            if(answer < gcdB)
                answer = gcdB;

        // 3. 최댓값 반환
        return answer;
    }
}
