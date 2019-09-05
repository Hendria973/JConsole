package jconsole;

class Main {

	public static void main(String[] args) {
		Console c = new Console();
		c.print("Test");
		c.print("Hello World!");
		c.print("JConsole");
		c.printAt("Print at", 30, 5);
	}

}
