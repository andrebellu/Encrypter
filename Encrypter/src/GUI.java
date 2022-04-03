import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) throws IOException {
        CaesarCipher cc = new CaesarCipher();

        JFrame frame = new JFrame("Encrypter");
        BufferedImage img = ImageIO.read(new URL("https://i.ibb.co/hyVkVW9/encrypter.png"));
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 350);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        
        JButton b = new JButton("ENCRYPT");
        b.setFont(new Font("Roboto", Font.BOLD, 20));
        b.setBackground(new Color(128, 128, 128));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.addActionListener(e -> {
            String message = (String) JOptionPane.showInputDialog(frame, "Enter message to encrypt", "Message", JOptionPane.WARNING_MESSAGE);
            int offset = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter offset", "Offset", JOptionPane.WARNING_MESSAGE));
            String encryptedMessage = cc.cipher(message, offset);
            JOptionPane.showMessageDialog(frame, encryptedMessage);
        });

        frame.add(label);
        frame.add(b);
        frame.setLayout(new FlowLayout());

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
