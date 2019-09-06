package jconsole;

import java.awt.event.KeyEvent;

class Main {
	public static void main(String[] args) {
		Test t = new Test();
	}
	

}

class Test implements keyEvents {
	Console c = new Console();
	public Test() {
		c.addListener(this);
	}
	
	public void keyTyped(KeyEvent e) {
		c.printAt(""+e.getKeyChar(), 0, 0);
		System.out.println(e.getKeyChar());
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
}
