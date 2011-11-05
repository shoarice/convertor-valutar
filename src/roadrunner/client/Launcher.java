package roadrunner.client;

public class Launcher {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		StressTestClientsQueue.testQueue();
		StressTestClientsTopics.testTopics();

	}

}
