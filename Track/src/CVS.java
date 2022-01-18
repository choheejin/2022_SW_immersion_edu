import java.util.Scanner;

class Product {
    private int elemNumber = 0;
    private String elemName = "";

    protected String getElemName(){
        return elemName;
    }

    protected void setElemName(String name){
        this.elemName = name;
    }

    protected int getElemNumber() {
        return elemNumber;
    }

    protected void setElemNumber(int num){
        this.elemNumber = num;
    }

    public void print(){
        System.out.println("\n ---현재 저장고 상태---");
        System.out.println(getElemName() + ": " + getElemNumber());
    }
}


// product -> 상속:

class Food extends Product{
    private String name;
    private int foodNum;
    public void sale(int num){
        if(foodNum - num < 0)
            System.out.println("죄송합니다. 재고가 부족합니다.");
        else
            this.foodNum = foodNum - num;
    }

    public void store(int num){
        this.foodNum = foodNum + num;
    }

    @Override
    public void print() {
        System.out.println("음식: " + foodNum);
    }
}

class Furniture extends Product{
    private String name;
    private int furnitureNum;
    public void sale(int num){
        if(furnitureNum - num < 0)
            System.out.println("죄송합니다. 재고가 부족합니다.");
        else
            this.furnitureNum = furnitureNum - num;
    }

    public void store(int num){
        this.furnitureNum = furnitureNum + num;
    }

    @Override
    public void print() {
        System.out.println("가구: " + furnitureNum);
    }
}

public class CVS {
    public static void main(String[] args) {
        System.out.println("***환영합니다***");
        Food food = new Food();
        Furniture furniture = new Furniture();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("----메뉴----");
            System.out.println("1. 조회하기");
            System.out.println("2. 구매하기");
            System.out.println("3. 저장하기");
            System.out.println("4. 종료하기");
            System.out.print("메뉴를 골라주세요: ");
            int MenuNum = scanner.nextInt();
            if (MenuNum == 1){
                food.print();
                furniture.print();
            }

            if (MenuNum == 2) {
                System.out.print("구매하실 상품을 골라주세요 (음식/가구): ");
                String section = scanner.next();
                System.out.print("몇 개를 구매하실 건가요? ");
                int num = scanner.nextInt();
                if(section.equals("음식"))
                    food.sale(num);
                if(section.equals("가구"))
                    furniture.sale(num);
            }
            if(MenuNum == 3){
                System.out.print("저장하실 상품을 골라주세요 (음식/가구): ");
                String section = scanner.next();
                System.out.print("몇 개를 저장하실 건가요? ");
                int num = scanner.nextInt();
                if(section.equals("음식"))
                    food.store(num);
                if(section.equals("가구"))
                    furniture.store(num);
            }
            if (MenuNum == 4)
                flag = false;
        } while (flag);
    }
}
