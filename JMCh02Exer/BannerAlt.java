
// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BannerAlt extends JApplet implements ActionListener {
	private int xPos, yPos; // hold the coordinates of the banner
	private boolean direction;

	public void init() {
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		xPos = c.getWidth();
		yPos = c.getHeight() / 2;
		direction = true;

		Timer clock = new Timer(2000, this); // fires every 30 milliseconds
		clock.start();
	}

	// Called automatically after a repaint request
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		if (direction) {
			g.drawString("East or West", 60, 65);
		} else {
			g.drawString("Java is Best", 60, 65);
		}
	}

	// Called automatically when the timer fires
	public void actionPerformed(ActionEvent e) {
		Container c = getContentPane();

		// Set the vertical position of the banner:
		yPos = (c.getHeight() - 45) / 2;

		// Adjust the horizontal position of the banner:
		/*
		 * xPos--; if (xPos < -100) { xPos = c.getWidth(); }
		 */

		if (direction) {
			repaint();
			direction = false;
		} else {
			repaint();
			direction = true;
		}

	}
}
