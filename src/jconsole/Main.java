package jconsole;

import java.awt.event.KeyEvent;

class Main {
	public static void main(String[] args) {
		Console c = new Console();
		c.print("Ready");
		String str = "test";
		while (str.equals("test")) {
			c.printAt(str, 5, 4);
			str = c.input();
			
		}
		System.out.println();
		c.printAt(str, 5, 5);
	}
	

}

class Test implements keyEvents {
	Console c = new Console();
	public Test() {
		c.addListener(this);
	}
	
	public void test() {
		c.print("Ready");
		String str = c.input();
		c.print("done");
		c.print(str);
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
}
