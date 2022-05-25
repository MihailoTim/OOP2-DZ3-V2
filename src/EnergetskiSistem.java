import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame{
	
	private int column, row;
	private Plac plac;
	private Button button = new Button("Dodaj");
	private Panel buttonPanel = new Panel();
	
	public EnergetskiSistem(int c, int r){
		this.column = c;
		this.row = r;
		plac = new Plac(c, r);
		
		
		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(false);
		setTitle("Energetski sistem");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		buttonPanel.add(button);
		add(buttonPanel, BorderLayout.NORTH);
		add(plac);
		
	}
	
	public static void main(String [] args) {
		new EnergetskiSistem(5,5);
	}
}
