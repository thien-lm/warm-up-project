package mechanism;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandle implements KeyListener {
	


	public boolean up, down, left, right;

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W) up = true;
		if(keyCode == KeyEvent.VK_S) down = true;
		if(keyCode == KeyEvent.VK_A) left = true;
		if(keyCode == KeyEvent.VK_D) right = true;
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W) up = false;
		if(keyCode == KeyEvent.VK_S) down = false;
		if(keyCode == KeyEvent.VK_A) left = false;
		if(keyCode == KeyEvent.VK_D) right = false;
	}

}
