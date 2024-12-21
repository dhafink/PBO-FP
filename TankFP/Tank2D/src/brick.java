import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class brick {
	int bricksXPos[] = { //data handling dan array, digunakan untuk menyimpan dan mengatur posisi
			50,350,450,300,350,450,550,150,150,450,550,
			250,50,100,150,550,250,350,450,550,50,250,350,550,
			50,150,250,300,350,550,50,150,250,350,450,
			250,350,550
	    };
	    int bricksYPos[] = {
	    	50,50,50,50,100,100,100,100,100,150,200,200,200,250,
			300,300,300,300,350,350,350,350,400,400,400,400,450,
			450,450,450,450,450,500,500,500,500,500,500,550,550,
			550,550
	    };
	    int brickON[] = new int[bricksXPos.length]; //array untuk cek brick aktif atau tidak

	    // Solid Bricks Position
	    int solidBricksXPos[] = {
	    	150,350,150,500,450,300,600,400,350,250,0,200,500,350,450    
	    };
	    int solidBricksYPos[] = {
	    		0,0,50,100,150,200,200,250,300,350,400,400,450,550,550     
	    };
    private ImageIcon breakBrickImage;
    private ImageIcon solidBrickImage;

    public brick() {//konstruktor buat initiate gambar
        breakBrickImage = new ImageIcon("break_brick.jpg");
        solidBrickImage = new ImageIcon("solid_brick.jpg");

        for (int i = 0; i < brickON.length; i++) { //Menandakan bahwa semua brick pada posisi tertentu aktif
            brickON[i] = 1; //
        }
    }

 // Method untuk menggambar breakable dan solid bricks di layar
    public void draw(Component c, Graphics g) {
        // Menggambar breakable bricks
        for (int i = 0; i < brickON.length; i++) { // Iterasi untuk setiap brick
            if (brickON[i] == 1) { //array, Jika brick aktif (tidak hancur)
                breakBrickImage.paintIcon(c, g, bricksXPos[i], bricksYPos[i]); // Gambar brick di posisi tertentu
            }
        }

        // Menggambar solid bricks
        for (int i = 0; i < solidBricksXPos.length; i++) { // Iterasi untuk setiap solid brick
            solidBrickImage.paintIcon(c, g, solidBricksXPos[i], solidBricksYPos[i]); // Gambar solid brick di posisi tertentu
        }
    }

    // Method untuk mengecek apakah terjadi tabrakan peluru dengan breakable bricks
    public boolean checkCollision(int x, int y) { //enkapsulasi, brickON diatur oleh checkcollison
        for (int i = 0; i < brickON.length; i++) { // Iterasi untuk setiap brick
            if (brickON[i] == 1) { // Jika brick aktif
                // Membuat rectangle kecil untuk mendeteksi tabrakan
                if (new Rectangle(x, y, 10, 10).intersects(new Rectangle(bricksXPos[i], bricksYPos[i], 50, 50))) {
                    brickON[i] = 0; // Brick dihancurkan (status jadi tidak aktif)
                    return true; // Tabrakan terjadi
                }
            }
        }
        return false; // Tidak ada tabrakan
    }

    // Method untuk mengecek apakah terjadi peluru tabrakan dengan solid bricks
    public boolean checkSolidCollision(int x, int y) {
        for (int i = 0; i < solidBricksXPos.length; i++) { // Iterasi untuk setiap solid brick
            // Membuat rectangle kecil untuk mendeteksi tabrakan
            if (new Rectangle(x, y, 10, 10).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50))) {
                return true; // Tabrakan terjadi
            }
        }
        return false; // Tidak ada tabrakan
    }

    // Method untuk mengecek apakah pemain bertabrakan dengan breakable atau solid bricks
    public boolean isCollidingWithPlayer(int playerX, int playerY) {
        // Cek tabrakan dengan breakable bricks
        for (int i = 0; i < brickON.length; i++) { // Iterasi untuk setiap breakable brick
            if (brickON[i] == 1) { // Jika brick aktif
                // Membuat rectangle pemain dan brick untuk mendeteksi tabrakan
                if (new Rectangle(playerX, playerY, 50, 50).intersects(new Rectangle(bricksXPos[i], bricksYPos[i], 50, 50))) {
                    return true; // Tabrakan terjadi
                }
            }
        }
        // Cek tabrakan dengan solid bricks
        for (int i = 0; i < solidBricksXPos.length; i++) { // Iterasi untuk setiap solid brick
            // Membuat rectangle pemain dan brick untuk mendeteksi tabrakan
            if (new Rectangle(playerX, playerY, 50, 50).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50))) {
                return true; // Tabrakan terjadi
            }
        }
        return false; // Tidak ada tabrakan
    }
}
