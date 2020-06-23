import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
//Desarrollo del personaje principal
class Avatar extends JPanel{

	BufferedImage avatar;

	public Avatar(BufferedImage avatar){

       this.avatar = avatar;
	}
	@Override
	public void paintComponent(Graphics g){

      super.paintComponent(g);
      g.drawImage(avatar,0,200,64,64,null);
	}
	
}