import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TankServer {
	public static final int TCP_PORT = 8888;
	int id = 100;
	ServerSocket ss = null;
	DataInputStream dis = null;
	List<Client> clients = new ArrayList<Client>();
	public void start() {
		try {
			ss = new ServerSocket(TCP_PORT);
			while(true) {
				Socket s = ss.accept();
System.out.println("A Client connect! IP:" + s.getInetAddress() + ":" + s.getPort());
				dis = new DataInputStream(s.getInputStream());
				int udpPort = dis.readInt();
				String ip = s.getInetAddress().getHostAddress();
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeInt(id++);
				Client c = new Client(ip,udpPort);
				clients.add(c);
				s.close();
			}
				
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 

	}
	public static void main(String[] args) {
		new TankServer().start();
	}
	private class Client {
		String ip;
		int udpPort;
		Client(String ip, int udpPort) {
			this.ip = ip;
			this.udpPort = udpPort;
		}
	}
}