import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lot extends Panel{
	
	private int column, row;
	private Parcel[][] parcels;
	private Parcel selected = null;
	private int selectedId = -1;
	
	public Lot(int c, int r) {
		this.column = c;
		this.row = r;
		
		parcels = new Parcel[r][c];
		
		setLayout(new GridLayout(c, r, 3, 3));
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() instanceof Parcel) {
					if(selected != null) {
						float size = selected.getFont().getSize()-20;
						selected.setFont(selected.getFont().deriveFont(size));
					}
					selected = (Parcel)e.getSource();
					float size = selected.getFont().getSize()+20;
					selected.setFont(selected.getFont().deriveFont(size));
					selected.repaint();
				}
			}
		});
		
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++) {
				double rand = Math.random();
				if(rand<=0.7)
					parcels[i][j] = new Grass();
				else
					parcels[i][j] = new Water();
						
				add(parcels[i][j]);
			}
	}
	
	public synchronized void addProducer(Producer p) {
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++)
				if(parcels[i][j] == selected) {
					parcels[i][j] = p;
					selected = null;
					remove(row*i+j);
					add(parcels[i][j],row*i+j);
					revalidate();
				}
		recalibrate();
	}
	
	private int isWater(int i,int j) {
		try {
			if (parcels[i][j] instanceof Water)
				return 1;
			else
				return 0;
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	public void recalibrate() {
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++)
				if(parcels[i][j] instanceof Hydroplant)
					((Hydroplant)parcels[i][j]).setFactor(isWater(i-1,j)+isWater(i+1,j)+isWater(i,j-1)+isWater(i,j+1));
	}
	
	public void stopAll() {
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++)
				if(parcels[i][j] instanceof Producer)
					((Producer)parcels[i][j]).stop();
	}
}
