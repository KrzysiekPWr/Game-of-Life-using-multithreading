package GUI;

import GoL.Cell;
import GoL.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private Cell[][] grid = Simulator.getGrid();
    private final BufferedImage image;

    public GamePanel() {
        image = new BufferedImage(grid[0].length, grid.length, BufferedImage.TYPE_INT_RGB);
        setBackground(new Color(8, 8, 8));
    }

    void updateImage() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++){
                if(grid[row][col].getState() == 1){
                    image.setRGB(col, row, 0x10F010);
                }
                else{
                    image.setRGB(col, row, 0x000000);
                }
            }
        }
        repaint();
    }
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Calculate the scale factors to fit the image in the panel
        double scaleX = (double) getWidth() / image.getWidth();
        double scaleY = (double) getHeight() / image.getHeight();
        double scale = Math.min(scaleX, scaleY); // Maintain aspect ratio

        int newWidth = (int) (image.getWidth() * scale);
        int newHeight = (int) (image.getHeight() * scale);

        // Center the image
        int x = (getWidth() - newWidth) / 2;
        int y = (getHeight() - newHeight) / 2;

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, newWidth, newHeight, this);
    }
}
