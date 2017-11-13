import java.awt.*;
import java.awt.event.*;
public class TankClient extends Frame {
	public static final String TITLE = "̹�˴�սv0.4";
	Tank t = new Tank(50,50);
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TankClient tc = new TankClient();
		tc.launchframe();
	}
	public void launchframe() {
		
		this.setSize(800, 600);
		this.setLocation(300, 100);
		this.setBackground(Color.BLACK);
		this.setTitle(TITLE);
		this.setResizable(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
	
		new Thread(new PaintThread()).start();
		
	}
	public void paint(Graphics g) {
		
		t.draw(g);
	}
	
	public class PaintThread implements Runnable {
		
		public void run() {
			while(true) {
				
				try {
					repaint();
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

}
