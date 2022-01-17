import java.util.Scanner;

class Product {
    private int FoodNum;
    private int Furniture;

    public void setFoodNum(int foodNum) {
        this.FoodNum = foodNum;
    }

    public void setFurniture(int furniture) {
        this.Furniture = furniture;
    }

    public int getFoodNum() {
        return FoodNum;
    }

    public int getFurniture() {
        return Furniture;
    }

    public void sale(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("구매하실 상품을 골라주세요 (음식/가구): ");
        String section = scanner.next();
        System.out.print("몇 개를 구매하실 건가요? ");
        int num = scanner.nextInt();
        if (section.equals("음식"))
            saleFood(num);
        else if (section.equals("가구"))
            saleFurniture(num);
        else{
            System.out.println("ERROR! 다시 입력하세요");
        }
    }

    public void saleFood(int num){
        if(getFoodNum()-num < 0)
            System.out.print("\n죄송합니다. 재고가 부족합니다.");
        else
            setFoodNum(getFoodNum() - num);
        print();
    }

    public void saleFurniture(int num){
        if(getFurniture()-num < 0)
            System.out.print("\n죄송합니다. 재고가 부족합니다.");
        else
            setFurniture(getFurniture() - num);
        print();
    }

    public void store(){
        System.out.print("저장하실 상품을 골라주세요 (음식/가구): ");
        Scanner scanner = new Scanner(System.in);
        String section = scanner.next();
        System.out.print("몇 개를 저장하실건가요? ");
        int num = scanner.nextInt();
        if (section.equals("음식"))
            storeFood(num);
        else if (section.equals("가구"))
            storeFurniture(num);
        else{
            System.out.println("ERROR! 다시 입력하세요");
        }
    }

    public void storeFood(int num){
       setFoodNum(getFoodNum() + num);
       print();
    }

    public void storeFurniture(int num){
        setFurniture(getFurniture() + num);
        print();
    }

    public void print(){
        System.out.println("\n ---현재 저장고 상태---");
        System.out.println("음식은 " + getFoodNum() + "개, " + "가구는 " + getFurniture() + "개 있습니다. \n");
    }
}

// product -> 상속:

class Food extends Product{

}

public class CVS {
    public static void main(String[] args) {
        System.out.println("***환영합니다***");
        Product product = new Product();
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
            if (MenuNum == 1)
                product.print();
            if (MenuNum == 2) {
                product.sale();
            }
            if(MenuNum == 3){
                product.store();
            }
            if (MenuNum == 4)
                flag = false;
        } while (flag);
    }
}
