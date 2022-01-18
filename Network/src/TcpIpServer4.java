import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();
    }

    public TcpIpServer4(int num){
        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");

            threadArr = new Thread[num];
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void start(){
        for(int i =0; i< threadArr.length; i++){
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    @Override
    public void run() {
        try{
            System.out.println(getTime()+"연결요청을 기다립니다.");
            // 서버 소캣은 클라이언트의 연결요청이 뜰 때까지 멈추고 계속 기다린다.
            // 클라이언트의 연결요청이 오면 클라이언트 소켓과의 연결을 ....?
            Socket socket = serverSocket.accept();
            System.out.println(getTime()+ socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");

            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeUTF("[Notice] Test Message1 from server.");
            System.out.println(getTime()+ "데이터를 전송합니다.");

            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date() + name);
    }
}
