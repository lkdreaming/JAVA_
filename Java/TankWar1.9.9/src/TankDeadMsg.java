import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class TankDeadMsg implements Msg {
	int msgType = Msg.TANK_DEAD_MSG;
	int id;
	Tank t;
	TankClient tc ;
	//���ڷ�����Ϣ�Ĺ��췽��
	public TankDeadMsg(Tank t) {
		this.t = t;
	}
	//���ڽ�����Ϣ�Ĺ��췽��
	public TankDeadMsg(TankClient tc) {
		this.tc = tc;
	}
	//������Ϣ
	public void send(DatagramSocket ds, String ip, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(t.id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(ip, udpPort));
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//������Ϣ
	public void parse(DataInputStream dis) {
		try {
			int id = dis.readInt();
			if(tc.myTank.id == id) return;
			for(int i = 0; i<tc.tanks.size(); i++) {
				Tank t = tc.tanks.get(i);
				if(t.id == id) {
					t.setLive(false);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
	}

}
