package test;

public class ThreadDumpAnalysis {

	public static void main(String[] args) throws InterruptedException {
		Object resourceA = new Object();
		Object resourceB = new Object();

		Thread threadLockingResourceAFirst = new Thread(new DeadLockRunnable(resourceA, resourceB));
		Thread threadLockingResourceBFirst = new Thread(new DeadLockRunnable(resourceB, resourceA));
		threadLockingResourceAFirst.start();
		Thread.sleep(500);
		threadLockingResourceBFirst.start();
	}

}

class DeadLockRunnable implements Runnable {
	private final Object resourceA;
	private final Object resourceB;

	public DeadLockRunnable(Object resourceA, Object resourceB) {
		this.resourceA = resourceA;
		this.resourceB = resourceB;
	}

	@Override
	public void run() {
		try {
			synchronized (resourceA) {
				printLockedResource(resourceA);
				Thread.sleep(1000);
				synchronized (resourceB) {
					printLockedResource(resourceB);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void printLockedResource(Object resource) {
		System.out.println(Thread.currentThread().getName() + " : Locked Resource ->" + resource);

	}
}
