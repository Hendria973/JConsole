package jconsole;

import java.awt.event.KeyEvent;

class Main {
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	

}

class Test implements keyEvents {
	Console c = new Console();
	public Test() {
		c.addListener(this);
	}
	
	public void test() {
		c.test();
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
}
