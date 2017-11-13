import java.awt.*;
import java.awt.event.*;


public class Yard extends Frame {
	public static final int BLOCK_SIZE = 15;
	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final String TITLE = "̰������Ϸ";
	Snake snake = new Snake(this);
	Egg egg = new Egg(5, 3);
	private boolean flag = true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	Image offScreenImage = null;
	
	public void launch() {
		
		this.setSize(BLOCK_SIZE * COLS, BLOCK_SIZE * ROWS);
		this.setLocation(400, 150);
		this.setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		g.setColor(Color.DARK_GRAY);
		for (int i = 1; i < Yard.COLS; i++) {
			g.drawLine(Yard.BLOCK_SIZE * i, 0, Yard.BLOCK_SIZE * i,
					Yard.BLOCK_SIZE * Yard.ROWS);
		}
		for (int i = 1; i < Yard.ROWS; i++) {
			g.drawLine(0, Yard.BLOCK_SIZE * i, Yard.BLOCK_SIZE * Yard.COLS,
					Yard.BLOCK_SIZE * i);
		}
		g.setColor(c);
		snake.draw(g);
		egg.draw(g);
		snake.eat(egg);
	}
	
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0,  null);
	}
	
	private class PaintThread implements Runnable {

		public void run() {
			while(flag) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			snake.keyPressed(e);
		}
	}
	public static void main(String[] args) {
		new Yard().launch();
	}
}
