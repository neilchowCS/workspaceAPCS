import java.awt.*;
import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - A12.6 - ParallelLines

   Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
  // TODO Your Instance Variables Here
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();    
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     draws illusion to fill width height
     @param g graphics
     @param width width of screen
     @param height height of screen
     @param size dont know
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
    int offset = width/30;
    int count = 0;
    int offsetAmount = 0;
    boolean direction = true;
    
    while (count<height) {
        
        g.drawLine(0, count, width, count );
        count += height/8;
        int count2 = 0;
        
        while (count2 < width) {
            
            g.fillRect( count2+(offset*offsetAmount), count-height/8, height/8, height/8 );
            count2 += height/4;
        }
        
        if (direction) {
            offsetAmount++;
            if (offsetAmount == 3) {
                offsetAmount= 1;
                direction = false;
            }
        }else {
            offsetAmount--;
            if (offsetAmount == -1) {
                offsetAmount= 1;
                direction = true;
            }
        }
    }
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
