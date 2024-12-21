import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Player1Bullet {
	private double x, y; // enkapsulasi, akses hanya bisa oleh getX, getY
	
	public Player1Bullet(double x, double y) //konstruktor buat intitiate posisi x,y peluru
	{
		this.x = x;
		this.y = y;
	}
	
	public void move(String face)// data handling, posisi peluru diatur menggunakan variabel x dan y, dan dimodif oleh string face
	{
		if(face.equals("right"))
			x += 5;
		else if(face.equals("left"))
			x -= 5;
		else if(face.equals("up"))
			y -= 5;
		else // menghadap bawah
			y +=5;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.yellow); // polimorhpism dengan player2bullet 
		g.fillOval((int) x, (int) y, 10, 10); // Gambar peluru berbentuk lingkaran
	}
	
	public int getX()
	{
		return (int)x; // Mendapatkan posisi X peluru
	}
	public int getY()
	{
		return (int)y; // Mendapatkan posisi Y peluru
	}

}
