import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class Lot extends Panel{
	
	private int column, row;
	private Parcel[] parcels;
	private GridLayout gridLayout;
	
	public Lot(int c, int r) {
		this.column = c;
		this.row = r;
		
		parcels = new Parcel[c*r];
		
		setLayout(new GridLayout(c, r, 3, 3));
		
		
		for(int i =0;i<c*r;i++)
		{
			double rand = Math.random();
			if(rand<=0.7)
				parcels[i] = new Grass();
			else
				parcels[i] = new Water();
			add(parcels[i]);
		}
		
		
	}
}
