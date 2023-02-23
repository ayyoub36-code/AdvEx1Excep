import java.util.ArrayList;
import java.util.Arrays;

public class TestRunnable implements Runnable {

	ArrayList<String> name;

	public TestRunnable(ArrayList<String> name) {
		this.name = name;
	}

	@Override
	public void run() {
		name.forEach(System.out::println);

	}

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<>(
				Arrays.asList("!*!", "\"**\"", "#***#", "$****$", "%*****%", "&******&", "'*******'"));
		// test.forEach(System.out::println);
		Thread thread = new Thread(new TestRunnable(test));
		thread.start();
	}

}
