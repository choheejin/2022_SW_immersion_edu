import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TcpIpServer5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");
            System.out.println(getTime()+"연결요청을 기다립니다.");
            Socket socket = serverSocket.accept();   //client socket을 받아들임

            System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    static String getTime() {
        SimpleDateFormat f= new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}

class Sender extends Thread{
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket){
        this.socket = socket;

        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";

        }catch (Exception e) {}
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(out!=null) {
            try {
                out.writeUTF(name+scanner.nextLine());
            }catch(IOException e) {}
        }
        scanner.close();
    }
}

class Receiver extends Thread{
    Socket socket;
    DataInputStream in;

    Receiver(Socket socket){
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        }catch(IOException e) {}
    }

    public void run() {
        while(in!=null) {
            try {
                System.out.println(in.readUTF());
            }catch(IOException e) {};
        }
    }
}