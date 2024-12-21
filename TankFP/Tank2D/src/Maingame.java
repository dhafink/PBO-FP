import javax.swing.SwingUtilities;

public class Maingame {
    public static void main(String[] args) { // Metode utama (entry point program)
        SwingUtilities.invokeLater(() -> {  //Menjadwalkan tugas di Event Dispatch Thread untuk memastikan semua yang mempengaruhi interface itu aman di dalam thread
            
            new GameMenu();//Membuat dan memunculkan menu game sebelum dimainkan(composition)
        });
    }
}
