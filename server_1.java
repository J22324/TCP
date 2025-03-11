import java.io.*;
import java.net.*;
import java.util.*;

public class server_1 {
	public static void main(String[] args)throws Exception{
		ServerSocket hoge = new ServerSocket(5000);
		Socket sock;
		String s,stu,res;
		while(true){
			sock=hoge.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	
			System.out.println("Someone login from " + sock.getInetAddress() + ":" + sock.getPort());
			out.write("Hello. Type your student number and name\n");
			out.flush();

			stu=in.readLine();
			Date date = new Date();

			System.out.println(date + " " + sock.getInetAddress() + ":" +sock.getPort());
			System.out.println("written student number and name:" + stu);

			out.write("OK. Type something\n");
			out.flush();

			while((s=in.readLine())!=null){
				if(s.equals(".")) break;
				System.out.println(date + " " + sock.getInetAddress()  + ":" + sock.getPort());
				System.out.println("written message:" + s);
				System.out.println("---------------------");

				res = stu + "曰く「"+ s + "」\r\n";
				out.write(res);
				out.flush();	
			}
			System.out.println("connectin close");
			System.out.println(new Date());
			System.out.println("major's friend " + stu + " LOGOUT");

			in.close();
			out.close();
			sock.close();
		}
	}
}

