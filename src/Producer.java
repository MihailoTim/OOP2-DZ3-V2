import java.awt.Color;

public abstract class Producer extends Parcel implements Runnable{

	private int baseTime;
	private Battery battery;
	private Thread thread = new Thread(this);;
	
	public Producer(char l, Color c, int time, Battery b) {
		super(l, c);
		this.baseTime = time;
		this.battery = b;
		thread.setDaemon(true);
		thread.start();
	}

	public abstract int produce(); 
	
	@Override
	public void run() {
		int totalTime = baseTime + (int)(Math.random()*300);
		try {
			while(!thread.interrupted()) {
				thread.sleep(totalTime);
				Color previous = this.getForeground();
				int status = this.produce();
				if(status >0) {
					synchronized(battery) {
						battery.add(status);
					}
					setForeground(Color.RED);
				}
				thread.sleep(300);	
				setForeground(previous);
			}
		}
		catch(InterruptedException e) {}
	}
	
	public void stop() {
		thread.interrupt();
	}

}
