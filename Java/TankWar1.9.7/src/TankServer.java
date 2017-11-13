import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class TankServer {
	public static final int TCP_PORT = 8888;
	int id = 100;
	public static final int UDP_PORT = 6666;
	ServerSocket ss = null;
	DataInputStream dis = null;
	List<Client> clients = new ArrayList<Client>();
	public void start() {
		new Thread(new UDPThread()).start();
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
	/**
	 * ����UDP���Ľ���.
	 * @author Administrator
	 *
	 */
	private class UDPThread implements Runnable {

		byte[] buf = new byte[1024];
		public void run() {
			DatagramSocket ds = null;
			try {
				ds = new DatagramSocket(UDP_PORT);
			} catch (SocketException e) {
				e.printStackTrace();
			}
System.out.println("A UDPThread start,port is:" + UDP_PORT);
			while(ds != null) {
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				try {
					ds.receive(dp);
					for(int i = 0; i < clients.size(); i++) {
						Client c = clients.get(i);
						dp.setSocketAddress(new InetSocketAddress(c.ip, c.udpPort));
						ds.send(dp);
					}
System.out.println("A packet received!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
