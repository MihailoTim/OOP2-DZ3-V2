
public class Battery {
	private int currEnergy;
	private int cap;
	
	public Battery(int cap) {
		this.currEnergy = this.cap = cap;
	}
	
	public void dodaj(int delta) {
		currEnergy+=delta;
		currEnergy = Math.min(currEnergy, cap);
	}
	
	public void isprazni() {
		currEnergy = 0;
	}
	
	public boolean isFull() {
		return currEnergy == cap;
	}
}
