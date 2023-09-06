
// Question 2-13-a

import java.awt.*;
import javax.swing.*;

/**
 * This program displays a red cross on a white background.
 */

public class Target extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int xCenter = getWidth();
		int yCenter = getHeight();
		g.setColor(Color.RED);
		g.fillOval((xCenter - 60) / 2, (yCenter - 60) / 2, 60, 60);
		g.setColor(Color.WHITE);
		g.fillOval((xCenter - 40) / 2, (yCenter - 40) / 2, 40, 40);
		g.setColor(Color.RED);
		g.fillOval((xCenter - 20) / 2, (yCenter - 20) / 2, 20, 20);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Target");
		window.setBounds(300, 300, 200, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Target panel = new Target();
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);
		window.setVisible(true);
	}
}
