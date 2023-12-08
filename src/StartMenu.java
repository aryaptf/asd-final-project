import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartMenu extends JFrame {
    public static void main(String[] args) {
        //frame startmenu
        JFrame frame = new JFrame("Game Sederhana");
        frame.setSize(900,600);
        //tombol tictactoe
        JButton tictactoe = new JButton("Tic Tac Toe");
        //tombol sudoku
        JButton sudoku = new JButton("Sudoku");

        //background
        ImageIcon background = new ImageIcon("assets/Lambang ITS.png");
        JLabel startMenu = new JLabel();
        startMenu.setIcon(background);

        //untuk ambil frame secara realtime, setiap kali diubah nanti bakal menyesuaikan
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                Dimension size = frame.getSize();
                int width = (int) ((Dimension) size).getWidth();
                int height = (int) size.getHeight();
                int buttonWidth = 150;
                int buttonHeight = 50;

                startMenu.setBounds((width / 2) - (background.getIconWidth() / 2), 5, background.getIconWidth(), background.getIconHeight());
                sudoku.setBounds((width * 3 / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
                tictactoe.setBounds((width / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
            }
        });

        //untuk mengambil informasi ukuran layar
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-frame.getWidth())/2, (Toolkit.getDefaultToolkit().getScreenSize().height-frame.getHeight())/2);

        //ketika startmenu di close, dia akan otomatis stop running
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add button tictactoe
        frame.add(tictactoe);

        //add button sudoku
        frame.add(sudoku);

        //untuk membuat framenya itu muncul
        frame.setVisible(true);

        //bisa bebas mengubah posisi dari framenya
        frame.setLayout(null);

        frame.add(startMenu);

        sudoku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new SudokuMain());
            }
        });

        tictactoe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new TTTGraphics());
            }
        });
    }
}
