import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");
        } catch (IOException e){
            e.printStackTrace();
        }

        while(true){
            try{
                System.out.println(getTime()+"연결요청을 기다립니다.");
                // 서버 소캣은 클라이언트의 연결요청이 뜰 때까지 멈추고 계속 기다린다.
                // 클라이언트의 연결요청이 오면 클라이언트 소켓과의 연결을 ....?
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+ socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");

                System.out.println("getPort(): " + socket.getPort());
                System.out.println("getLocalPort(): "+socket.getLocalPort());

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
    }

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
