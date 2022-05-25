import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lot extends Panel{
	
	private int column, row;
	private Parcel[] parcels;
	private GridLayout gridLayout;
	private Parcel selected = null;
	private int selectedId = -1;
	
	public Lot(int c, int r) {
		this.column = c;
		this.row = r;
		
		parcels = new Parcel[c*r];
		
		setLayout(new GridLayout(c, r, 3, 3));
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(selected != null)
					selected.incFont(-20);
				selected = (Parcel)e.getSource();
				selected.incFont(20);
			}
		});
		
		
		for(int i =0;i<c*r-1;i++)
		{
			double rand = Math.random();
			if(rand<=0.7)
				parcels[i] = new Grass();
			else
				parcels[i] = new Water();
					
			add(parcels[i]);
		}
		
		parcels[c*r-1] = new Hydroplant('H', Color.BLUE, 1500, null);
		
		add(parcels[c*r-1]);
	}
	
	public void addProducer() {
		int i;
//		for(i=0;i<column*row;i++)
//			if(parcels[i] == selected) {
//				parcels[i] = null;
//			}
//		
		int tmp = 3;
		
		for(i =0;i<column*row;i++)
		{
			remove(parcels[i]);
			if(i==tmp) {
				parcels[i] = new Hydroplant('H', Color.BLUE, 1500, null);
			}		
			add(parcels[i]);
		}
		revalidate();
	}
}
