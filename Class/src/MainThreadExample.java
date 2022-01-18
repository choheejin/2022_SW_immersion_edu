public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }
}

// synchronized 없을 때 실행결과 -> 동기화 되지 않음
// User1: 50
// User2: 50

// synchronized 붙였을 때 실행결과 -> memory 값이 잘 보존된다.
// User1: 100
// User2: 50