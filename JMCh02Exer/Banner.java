
// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Banner extends JApplet implements ActionListener {
	private int xPos, yPos; // hold the coordinates of the banner
	private boolean direction;

	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		xPos = c.getWidth();
		yPos = c.getHeight() / 2;
		direction = true;

		Timer clock = new Timer(30, this); // fires every 30 milliseconds
		clock.start();
	}

	// Called automatically after a repaint request
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(xPos, yPos, 150, 45);
	}

	// Called automatically when the timer fires
	public void actionPerformed(ActionEvent e) {
		Container c = getContentPane();

		// Adjust the horizontal position of the banner:
		/*
		 * xPos--; if (xPos < -100) { xPos = c.getWidth(); }
		 */

		if (direction == true && xPos <= c.getWidth() - 150) {
			xPos += 1;
		} else if (direction == true && xPos > c.getWidth() - 150) {
			direction = false;

		} else if (direction == false && xPos >= 0) {
			xPos -= 1;
		} else if (direction == false && xPos < 0) {
			direction = true;

		}

		// Set the vertical position of the banner:
		yPos = (c.getHeight() - 45) / 2;

		repaint();
	}
}
