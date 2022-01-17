import java.util.Scanner;

class Calculator {
    public int calculate (String op, int x, int y) {
        return switch (op) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "/" -> x / y;
            case "*" -> x * y;
            default -> -100000;
        };
    }
}

public class User {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫번째 수를 입력하세요: ");
            int x = scanner.nextInt();
            System.out.print("두번째 수를 입력하세요: ");
            int y = scanner.nextInt();
            System.out.print("선택할 연산자를 골라주세요(+,-,/,*): ");
            String op = scanner.next();
            Calculator cal = new Calculator();
            int result = cal.calculate(op, x, y);
            if (result != -100000) {
                System.out.print("계산결과: " + result);
                break;
            }
        }
    }
}