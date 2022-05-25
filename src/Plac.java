import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class Plac extends Panel{
	
	private int column, row;
	private Parcela[] parcele;
	private GridLayout gridLayout;
	
	public Plac(int c, int r) {
		this.column = c;
		this.row = r;
		
		parcele = new Parcela[c*r];
		
		setLayout(new GridLayout(c, r, 3, 3));
		
		
		for(int i =0;i<c*r;i++)
		{
			double rand = Math.random();
			if(rand<=0.7)
				parcele[i] = new Trava();
			else
				parcele[i] = new Voda();
			add(parcele[i]);
		}
		
		
	}
}
