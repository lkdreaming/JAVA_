import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
public class TankClient extends Frame {
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final String TITLE = "̹�˴�սv1.7.1";
	Tank myTank = new Tank(50, 50, true, this);
	Tank enemyTank = new Tank(100, 100, false, this);
	Explode ex = new Explode(200,200);
	Image offScreenImage = null;
	Missile m = null;
	List<Missile> missiles = new ArrayList<Missile>();
	public void launchframe() {
		
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setLocation(300, 100);
		this.setBackground(Color.BLACK);
		this.setTitle(TITLE);
		this.setResizable(false);
		this.setVisible(true);
		//ע����̼���.
		this.addKeyListener(new KeyMonitor());
		//ע�ᴰ�ڼ���.
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
	
		new Thread(new PaintThread()).start();
		
	}
	public void paint(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("missiles counts:" + missiles.size(), 20, 40);
		g.setColor(c);
		if(m != null) {
			
			for(int i = 0 ; i < missiles.size(); i++) {
				
				m = this.missiles.get(i);
				m.draw(g);
				m.hitTank(enemyTank);
				
			}
			
		}	

		myTank.draw(g);
		enemyTank.draw(g);
		ex.draw(g);
		
	}
	//��Ļ˫����(����Ҫ)
	public void update(Graphics g) {
		if(offScreenImage == null) {
			
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
			
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TankClient tc = new TankClient();
		tc.launchframe();
	}
	
	public class PaintThread implements Runnable {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	private class KeyMonitor extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
		
	}
	
}
