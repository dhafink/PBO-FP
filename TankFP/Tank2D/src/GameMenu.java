import java.awt.*; // Import library untuk manipulasi grafis
import java.awt.event.MouseEvent; // Import event untuk mouse
import java.awt.event.MouseListener; // Import interface MouseListener
import javax.swing.*; // Import library Swing untuk GUI

public class GameMenu implements MouseListener { // Kelas untuk menu utama game
    private JPanel panel; // Panel utama untuk menu
    private JFrame frame; // Frame utama untuk aplikasi

    private JLabel title; // Label untuk judul
    private JLabel start; // Label untuk tombol START
    private JLabel exit; // Label untuk tombol EXIT

    private ImageIcon backgroundImage; // Gambar untuk latar belakang

    public GameMenu() { // Konstruktor
        createMenu(); // Panggil metode untuk membuat menu
    }

    private void createMenu() { // Metode untuk membuat menu utama
        // Konfigurasi frame
        frame = new JFrame("Tank 2D Game"); // Judul frame
        frame.setSize(800, 630); // Ukuran frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tutup aplikasi saat frame ditutup
        frame.setResizable(false); // Tidak bisa diubah ukurannya
        
        // Muat gambar background
        backgroundImage = new ImageIcon("background.png"); // Tambahkan gambar latar belakang
        
        // Panel dengan layout null untuk posisi custom
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { // Override untuk menggambar background
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this); // Gambar background
            }
        };
        panel.setLayout(null); // Nonaktifkan layout manager

        // Ukuran dan posisi elemen
        int buttonWidth = 300; // Lebar tombol START
        int buttonHeight = 150; // Tinggi tombol START
        int exitWidth = 200; // Lebar tombol EXIT
        int exitHeight = 50; // Tinggi tombol EXIT
        int titleWidth = 500; // Lebar judul
        int titleHeight = 150; // Tinggi judul
        int centerX = (frame.getWidth() - buttonWidth) / 2; // Posisi X untuk elemen di tengah frame

        // Judul
        title = new JLabel(new ImageIcon(new ImageIcon("title.png")
                .getImage().getScaledInstance(titleWidth, titleHeight, Image.SCALE_SMOOTH))); // Gambar judul
        title.setBounds((frame.getWidth() - titleWidth) / 2, 30, titleWidth, titleHeight); // Posisi judul
        panel.add(title); // Tambahkan ke panel

        // Logo Tank
        JLabel tankLogo = new JLabel(new ImageIcon(new ImageIcon("tank.png")
                .getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH))); // Gambar logo tank
        tankLogo.setBounds((frame.getWidth() - 250) / 2, 200, 250, 150); // Posisi logo tank
        panel.add(tankLogo); // Tambahkan ke panel

        // Tombol Start
        start = new JLabel(new ImageIcon(new ImageIcon("start.png")
                .getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH))); // Gambar tombol START
        start.setBounds(centerX, 400, buttonWidth, buttonHeight); // Posisi tombol START
        start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Ubah cursor jadi tangan
        start.addMouseListener(this); // Tambahkan listener untuk klik
        panel.add(start); // Tambahkan ke panel

        // Tombol Exit
        exit = new JLabel(new ImageIcon(new ImageIcon("exit.png")
                .getImage().getScaledInstance(exitWidth, exitHeight, Image.SCALE_SMOOTH))); // Gambar tombol EXIT
        exit.setBounds((frame.getWidth() - exitWidth) / 2, 530, exitWidth, exitHeight); // Posisi tombol EXIT
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Ubah cursor jadi tangan
        exit.addMouseListener(this); // Tambahkan listener untuk klik
        panel.add(exit); // Tambahkan ke panel

        // Tambahkan panel ke frame
        frame.add(panel);
        frame.setVisible(true); // Tampilkan frame
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Method untuk menangani klik mouse
        if (e.getSource() == start) { // Jika tombol START diklik
            frame.dispose(); // Tutup menu utama
            JFrame gameFrame = new JFrame("Tank 2D"); // Buat frame untuk game
            Gameplay gamePlay = new Gameplay(); // Buat objek Gameplay

            gameFrame.setBounds(10, 10, 800, 630); // Ukuran frame game
            gameFrame.setTitle("Tank 2D"); // Judul frame game
            gameFrame.setResizable(false); // Tidak bisa diubah ukurannya
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tutup aplikasi saat frame game ditutup
            gameFrame.add(gamePlay); // Tambahkan gameplay ke frame
            gameFrame.setVisible(true); // Tampilkan frame game
        }

        if (e.getSource() == exit) { // Jika tombol EXIT diklik
            System.exit(0); // Keluar dari aplikasi
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {} 
    @Override
    public void mouseReleased(MouseEvent e) {} 
    @Override
    public void mouseEntered(MouseEvent e) {} 
    @Override
    public void mouseExited(MouseEvent e) {} 

    public static void main(String[] args) { // Metode utama
        new GameMenu(); // Buat dan tampilkan menu game
    }
}
