import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource res = new FileResource("hello_unicode.txt");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		HelloWorld hw = new HelloWorld();
		hw.runHello();
	}
}
