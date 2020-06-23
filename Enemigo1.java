import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Enemigo1 extends JPanel
{

	BufferedImage enemigo1;

	public Enemigo1(BufferedImage enemigo1)
	{
		this.enemigo1 = enemigo1;
	}

	@Override
	public void paintComponent(Graphics s)
	{
		super.paintComponent(s);
		s.drawImage(enemigo1,100,70,64,64,null);
	}
}