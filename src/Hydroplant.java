import java.awt.Color;

public class Hydroplant extends Producer implements Runnable{
	
	private int producerFactor; 

	public Hydroplant(Battery b) {
		super('H', Color.BLUE, 1500, b);
		this.producerFactor = 0;
	}

	@Override
	public synchronized int produce() {
		return this.producerFactor;
	}
	
	public synchronized void setFactor(int f) {
		this.producerFactor = f;
	}
	
}
