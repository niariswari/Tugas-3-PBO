import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageViewer extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton openButton;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        openButton = new JButton("Open Image");
        openButton.addActionListener(this);

        add(openButton, BorderLayout.NORTH);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

            Image image = imageIcon.getImage();

            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);

            int labelWidth = imageLabel.getWidth();
            int labelHeight = imageLabel.getHeight();

            double scaleFactor = Math.min((double) labelWidth / imageWidth, (double) labelHeight / imageHeight);

            Image scaledImage = image.getScaledInstance((int) (imageWidth * scaleFactor), (int) (imageHeight * scaleFactor), Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(scaledImage));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageViewer viewer = new ImageViewer();
            viewer.setVisible(true);
        });
    }
}
