public class User1 extends Thread{
    private Calculator calculator;
    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
        this.setName("User1");
    }

    public void run(){
        calculator.setMemory(100);
    }
}
