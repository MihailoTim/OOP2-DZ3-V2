import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

public class Parcel extends Label{
	
	private char label;
	private Color color;
	
	public Parcel(char o, Color c) {
		this.label = o;
		this.color = c;
		setForeground(Color.WHITE);
		setBackground(this.color);
		setFont(new Font("Serif", Font.BOLD, 14));
		setAlignment(CENTER);
		setText(""+this.label);
		
		validate();
	}
	
	public void changeColor(Color c) {
		this.color = c;
		revalidate();
	}

}
