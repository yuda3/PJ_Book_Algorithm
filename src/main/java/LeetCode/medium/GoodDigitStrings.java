package LeetCode.medium;

public class GoodDigitStrings {
    public static int countGoodDigitStrings(long n) {
        // 모듈러 연산을 위한 값
        final int MOD = 1_000_000_007;

        // 짝수 인덱스에는 짝수 숫자(0,2,4,6,8)가 올 수 있음 - 5가지
        int evenDigits = 5;

        // 홀수 인덱스에는 소수(2,3,5,7)가 올 수 있음 - 4가지
        int primeDigits = 4;

        // n이 1인 특수 경우 처리
        if (n == 1) {
            return evenDigits;
        }

        // 짝수 위치의 개수 계산 (주의: n이 매우 클 수 있음)
        long evenPositions = (n + 1) / 2;

        // 홀수 위치의 개수 계산 (주의: n이 매우 클 수 있음)
        long oddPositions = n / 2;

        // 5^evenPositions 계산
        long evenResult = modPow(evenDigits, evenPositions, MOD);

        // 4^oddPositions 계산
        long oddResult = modPow(primeDigits, oddPositions, MOD);

        // 두 결과 곱하기
        return (int)((evenResult * oddResult) % MOD);
    }

    // 모듈러 지수 계산 함수 (a^b % MOD), b가 long 타입
    private static long modPow(long base, long exp, int mod) {
        if (exp == 0) return 1;

        // 기본 케이스 처리
        if (exp == 1) return base % mod;

        // 분할 정복 방식으로 계산
        long half = modPow(base, exp / 2, mod);

        // 지수가 짝수인 경우
        if (exp % 2 == 0) {
            return (half * half) % mod;
        }
        // 지수가 홀수인 경우
        else {
            // (half * half * base) % mod 계산 시 오버플로우 방지
            return (((half * half) % mod) * base) % mod;
        }
    }

    // 반복적인 방법으로 모듈러 지수 계산 (재귀 스택 오버플로우 방지)
    public static long modPowIterative(long base, long exp, int mod) {
        // 기본 케이스
        if (exp == 0) return 1;

        // 결과 초기화
        long result = 1;

        // base를 모듈로로 나눈 나머지로 초기화
        base = base % mod;

        while (exp > 0) {
            // 현재 지수가 홀수이면 결과에 base를 곱함
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }

            // 지수를 반으로 나누고
            exp = exp >> 1; // exp /= 2와 동일

            // base를 제곱하여 다음 반복에 사용
            base = (base * base) % mod;
        }

        return result;
    }

    // 반복적인 방법을 사용한 최적화된 계산
    public static int countGoodDigitStringsIterative(long n) {
        final int MOD = 1_000_000_007;

        // 짝수 인덱스에는 짝수 숫자가 올 수 있음 - 5가지
        int evenDigits = 5;

        // 홀수 인덱스에는 소수가 올 수 있음 - 4가지
        int primeDigits = 4;

        // 짝수 위치의 개수
        long evenPositions = (n + 1) / 2;

        // 홀수 위치의 개수
        long oddPositions = n / 2;

        // 5^evenPositions 계산 (반복적 방법 사용)
        long evenResult = modPowIterative(evenDigits, evenPositions, MOD);

        // 4^oddPositions 계산 (반복적 방법 사용)
        long oddResult = modPowIterative(primeDigits, oddPositions, MOD);

        // 두 결과 곱하기
        return (int)((evenResult * oddResult) % MOD);
    }

    public static void main(String[] args) {
        // 테스트 케이스 (작은 값)
        long[] smallTestCases = {1, 2, 3, 4, 5, 10, 20};

        System.out.println("작은 입력값 테스트:");
        for (long n : smallTestCases) {
            System.out.println("길이 " + n + "인 좋은 숫자 문자열의 개수: " + countGoodDigitStrings(n));
            System.out.println("반복적 방법으로 계산한 결과: " + countGoodDigitStringsIterative(n));
            System.out.println();
        }

        // 테스트 케이스 (큰 값)
        long[] largeTestCases = {50, 100, 1000, 10000, 100000, 1000000};

        System.out.println("큰 입력값 테스트:");
        for (long n : largeTestCases) {
            // 큰 값은 반복적 방법만 사용 (재귀 방법은 스택 오버플로우 가능성)
            System.out.println("길이 " + n + "인 좋은 숫자 문자열의 개수: " + countGoodDigitStringsIterative(n));
            System.out.println();
        }
    }
}