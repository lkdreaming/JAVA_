import java.awt.*;
import java.awt.event.*;

public class Tank {
	private int x,y;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bL=false, bU=false, bR=false, bD = false;
	enum Direction{U,D,L,R,UL,DL,UR,DR,STOP};
	private Direction ptDir = Direction.D;
	private Direction dir = Direction.STOP;
	TankClient tc = null;
	Tank(int x, int y, TankClient tc) {
		
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		switch(ptDir) {
		
		case U:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y);
			break;
		case D:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT);
			break;
		case L:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x , y + HEIGHT / 2);
			break;
		case R:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y + HEIGHT / 2);
			break;
		case UL:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x , y);
			break;
		case DL:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x  , y + HEIGHT);
			break;
		case UR:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y);
			break;
		case DR:
			g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y + HEIGHT);
			break;
			
		}
		move();
		
	}
	
	public void move() {
		
		switch(dir) {
		
		case U:
			y -= YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case L:
			x -= XSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case UL:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case DL:
			x -= XSPEED;
			y += YSPEED;
			break;
		case UR:
			x += XSPEED;
			y -= YSPEED;
			break;
		case DR:
			x += XSPEED;
			y += YSPEED;
			break;
		case STOP:
			break;
		}
		
		if(dir != Direction.STOP) ptDir = dir;
		
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		switch(key) {
		
		case KeyEvent.VK_W:
			bU = true;
			break;
		case KeyEvent.VK_S:
			bD = true;
			break;
		case KeyEvent.VK_A:
			bL = true;
			break;
		case KeyEvent.VK_D:
			bR = true;
			break;
		case KeyEvent.VK_J:
			tc.m = fire();
			break;
		
		}
	
	locationDirection();	
	}
	
	private void locationDirection() {
		
		if(bU && !bD && !bL && !bR) {
			
			dir =Direction.U;
			
		}
		else if(!bU && bD && !bL && !bR) {
			
			dir =Direction.D;
			
		}	
		else if(!bU && !bD && bL && !bR) {
			
			dir =Direction.L;

		}	
		else if(!bU && !bD && !bL && bR) {
			
			dir =Direction.R;
			
		}	
		else if(!bU && !bD && !bL && !bR)	dir =Direction.STOP;
		else if(bU && !bD && bL && !bR) {
			
			dir =Direction.UL;
			
		}	
		else if(!bU && bD && bL && !bR)	{
			
			dir =Direction.DL;
			
		}
		else if(bU && !bD && !bL && bR)	{
			
			dir =Direction.UR;
			
		}
		else if(!bU && bD && !bL && bR)	{
			
			dir =Direction.DR;
			
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		switch(key) {
		
		case KeyEvent.VK_W:
			bU = false;
			break;
		case KeyEvent.VK_S:
			bD = false;
			break;
		case KeyEvent.VK_A:
			bL = false;
			break;
		case KeyEvent.VK_D:
			bR = false;
			break;
		
		}
		locationDirection();	
	}
	public Missile fire() {
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, ptDir);
		return m;
	}
}
