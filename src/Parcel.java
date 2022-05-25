import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcel extends Label{
	
	private char label;
	private Color color;
	private static final String font = "Serif";
	private static final int style = Font.BOLD;
	private static int size = 14;
	
	public Parcel(char o, Color c) {
		this.label = o;
		this.color = c;
		setForeground(Color.WHITE);
		setBackground(this.color);
		setFont(new Font(font, style, size));
		setAlignment(CENTER);
		setText(""+this.label);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component source = (Component)e.getSource();
				source.getParent().dispatchEvent(e);
			}
		});
		
		validate();
	}
	
	public void changeColor(Color c) {
		this.color = c;
		revalidate();
	}
	
	public void incFont(int delta) {
		setFont(new Font(font, style, size+delta));
		size += delta;
	}

}
