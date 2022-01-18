public class User2 extends Thread{
    private Calculator calculator;
    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
        this.setName("User2");
    }

    public void run(){
        calculator.setMemory(50);
    }
}
