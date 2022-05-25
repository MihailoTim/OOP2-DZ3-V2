import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

public class Parcela extends Label{
	
	private char oznaka;
	private Color color;
	
	public Parcela(char o, Color c) {
		this.oznaka = o;
		this.color = c;
		setForeground(Color.WHITE);
		setBackground(this.color);
		setFont(new Font("Serif", Font.BOLD, 14));
		setAlignment(CENTER);
		setText(""+o);
		
		validate();
	}
	
	public void promeniBoju(Color c) {
		this.color = c;
		revalidate();
	}

}
