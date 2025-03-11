import java.io.*;
import java.net.*;

public class client_1 {
	public static void main(String[] args)throws Exception {

		Socket sock = new Socket(args[0], 5000);
		String s,t;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

		System.out.println(in.readLine());
		t = buf.readLine();
		out.write(t + "\r\n");
		out.flush();

		System.out.println(in.readLine());

		while((s=buf.readLine())!=null){
			if(s.equals(".")) break;
			out.write(s + "\r\n");
			out.flush();
			System.out.println(in.readLine());
		}
		sock.close();
		System.out.println("connection closed");
	}
}
