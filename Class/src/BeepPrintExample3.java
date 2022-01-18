public class BeepPrintExample3 {
    public static void main(String[] args) {
        Thread thread = new BeepThread();

        thread.start(); // 쓰레드 시작 beep음 5번 울림

        for(int i =0; i<5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
}
