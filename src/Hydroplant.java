import java.awt.Color;

public class Hydroplant extends Producer implements Runnable{

	public Hydroplant(char l, Color c, int time, Battery b) {
		super(l, c, time, b);
	}

	@Override
	public int produce() {
		return 1;
	}

}
