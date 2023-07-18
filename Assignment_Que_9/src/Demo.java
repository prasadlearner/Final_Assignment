import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;

public class Demo {

	boolean flag = false;
	int sum = 0;
	ArrayDeque<Integer> que = new ArrayDeque<Integer>();

	public synchronized void addRandomNumToQue(Queue q) {
		while (flag) {

			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		que.addAll(q);

		System.out.println(que);

		this.notify();

		flag = true;

	}

	public synchronized void getSum() {
		while (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		Iterator<Integer> iterator = que.iterator();

		while (iterator.hasNext()) {
			int i = iterator.next();
			sum += i;
		}
		System.out.println(sum);
	}

}

class Producer implements Runnable {
	Demo d;

	public Producer(Demo d) {
		this.d = d;
	}

	@Override
	public void run() {

		Queue<Integer> q = new ArrayDeque<Integer>();

		Random random = new Random();
		for (int i = 0; i <= 5; i++) {
			int num = random.nextInt(10);

			q.add(num);

		}

		d.addRandomNumToQue(q);

	}

}

class Consumer implements Runnable {
	Demo d;

	public Consumer(Demo d) {
		this.d = d;
	}

	@Override
	public void run() {

		d.getSum();
	}

}

class Test {
	public static void main(String[] args) {

		Demo d = new Demo();

		Producer p = new Producer(d);
		Consumer c = new Consumer(d);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);

		t1.start();
		t2.start();

	}
}