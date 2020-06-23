import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

///
// Videojuego creado en 2d
///    <>
class Juego{
	public static void main(String[] args) {
		Portada menu = new Portada();
	}
	///Este sera el inicio
	public static class Portada extends JFrame implements ActionListener, KeyListener{

     JPanel panel;
     JLabel portada;
     BufferedImage bfimage;
     JButton btninicio;
     BufferedImage avatar;
     BufferedImage subavatar;
     BufferedImage enemigos;
     int indiceX = 0;
     int indiceX2 = 9;

     Avatar personajeP;
     Enemigo evil;
      //panel
      public Portada(){

      //acciones panel 1 y 2
      componentesPaneles();
 
      
      this.add(panel);
      this.setSize(1366,768);
      this.setVisible(true);
      this.setTitle("Thunder Game");
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.addKeyListener(this);
       
      btninicio.addActionListener(this);
    

    } 
     public void componentesPaneles(){

      panel = new JPanel();
      panel.setLayout(null);
      panel.setFocusable(true);
      panel.requestFocusInWindow();
      panel.setBackground(Color.BLACK);
      panel.setVisible(true);

      
      //boton de inicio
      try{


      bfimage = ImageIO.read(new File("./images/Favicon.png"));   
      portada = new JLabel(new ImageIcon(bfimage));   
      portada.setBounds(0,0,1300,763);
      btninicio= new JButton("Comenzar");
      btninicio.setBounds(544,400,200,50);
      btninicio.setForeground(Color.WHITE);
      btninicio.setOpaque(true);
      btninicio.setBackground(Color.RED);
      }catch(Exception e){
      	System.out.println("Error de boton o portada :(");
      }

      panel.add(btninicio);
      panel.add(portada);

     }
     //si presiona boton
     public void actionPerformed(ActionEvent event){
      if (event.getSource() == btninicio)
      {
      	
        
        panel.setVisible(false);
         remove(panel);
         
         evil = new Enemigo();

        try{

         avatar = ImageIO.read(new File("./images/avatar.png"));


        }catch(Exception e){
           System.out.println("Ha ocurrido un error a la hora de cargar los jugadores. :(");
        } 
        subavatar = avatar.getSubimage(0,64 * 3, 64, 64);
        personajeP = new Avatar(subavatar);
        this.add(personajeP);

        /*Carga de enemigos */
        
      }

     }
     //si pone enter
     public void keyPressed(KeyEvent e){

     int t = e.getKeyCode();
     Point pos = personajeP.getLocation();

    int x = (int)pos.getX();
    int y = (int)pos.getY();

    if(t==68)
    {
      x = x+5;
      indiceX = indiceX + 1;
      personajeP.avatar = avatar.getSubimage(indiceX*64,64*11,64,64);
      if (indiceX == 8) {
      	indiceX = 0;
      }
      else if(x > 1180){
         x=0;
      }
    }

    else if(t==65)
    {
      x = x-5;
      indiceX2 =  indiceX2 - 1;
      personajeP.avatar = avatar.getSubimage(indiceX2*64,64*9,64,64);
      if (indiceX2 == 0) {
      	indiceX2 =9;
      }
      else if (x<0) {
      	x=0;
    
      }
    }
    /*
    else if(t==83)
    {
      y = y+5;
      indiceX = ((indiceX + 1) % 9) * 64;
      personajeP.avatar = avatar.getSubimage(indiceX,64*2,64,64);
    }
    else if(t==87)
    {
      y = y-5;
      indiceX = ((indiceX + 1) % 9) * 64;
      personajeP.avatar = avatar.getSubimage(indiceX,64*0,64,64);
    } */
      personajeP.setLocation(x,y);

     }
     public void keyReleased(KeyEvent e){

     }
     public void keyTyped(KeyEvent e){


     }
     
  }
}