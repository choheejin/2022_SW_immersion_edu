public class BeepPrintExample2 {
    public static void main(String[] args) {
        //how1
        Runnable beepTask = new BeepTask();
        Thread thread = new Thread(beepTask);


        //how2
        //how3  () ->

        thread.start(); // 쓰레드 시작 beep음 5번 울림

        for(int i =0; i<5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(500);
            }catch (Exception e){}
        }

        // 병렬적으로 일을 수행함.
    }
}
