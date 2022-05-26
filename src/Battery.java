
public class Battery {
	private int currEnergy;
	private int cap;
	
	public Battery(int cap) {
		this.currEnergy = this.cap = cap;
		this.currEnergy = 0;
	}
	
	public synchronized void add(int delta) {
		currEnergy+=delta;
		currEnergy = Math.min(currEnergy, cap);
	}
	
	public synchronized void drain() {
		currEnergy = 0;
	}
	
	public boolean isFull() {
		return currEnergy == cap;
	}
	
	public int getBattery() {
		return currEnergy;
	}
}
