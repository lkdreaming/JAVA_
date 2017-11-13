import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetClient {
	public static int UDP_PORT = 2333;
	TankClient tc ;
	Socket s = null;
	NetClient(TankClient tc) {
		UDP_PORT++;
		this.tc = tc;
	}
	public boolean connect(String ip, int port) {
		try {
			s = new Socket(ip, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(UDP_PORT);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			tc.myTank.id = dis.readInt();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				s.close();
				s = null;
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
System.out.println("Connect to the Server successfully!");
		return true;
		
	}
}