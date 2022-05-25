import java.awt.Color;

public abstract class Producer extends Parcel implements Runnable{

	private int baseTime;
	private Battery battery;
	private Thread thread;
	
	public Producer(char l, Color c, int time, Battery b) {
		super(l, c);
		this.baseTime = time;
		this.battery = b;
		thread = new Thread(this);
		thread.start();
	}

	public abstract int produce(); 
	
	@Override
	public void run() {
		int totalTime = baseTime + (int)(Math.random()*300);
		try {
			while(true) {
				thread.sleep(totalTime);
				int status = this.produce();
				if(status == 1)
					setForeground(Color.RED);
				thread.sleep(300);	
			}
		}
		catch(InterruptedException e) {}
	}
	
	public void stop() {
		thread.interrupt();
	}

}
