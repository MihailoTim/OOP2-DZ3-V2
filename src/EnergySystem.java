import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergySystem extends Frame{
	
	private int column, row;
	private Lot lot;
	private Button button = new Button("Dodaj");
	private Panel buttonPanel = new Panel();
	private Battery battery;
	
	public EnergySystem(int c, int r, int cap){
		this.column = c;
		this.row = r;
		lot = new Lot(c, r);
		battery = new Battery(cap);
		
		
		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(false);
		setTitle("Energetski sistem");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		button.addActionListener((ae) -> {
			lot.addProducer(new Hydroplant(this.battery));
		});
		
		buttonPanel.add(button);
		add(buttonPanel, BorderLayout.NORTH);
		add(lot);
		
	}
	
	public static void main(String [] args) {
		new EnergySystem(10,10,100);
	}
}
