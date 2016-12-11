/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go15;

/**
 *
 * @author diwakar
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Inst extends JMenuItem implements ActionListener {
    JFrame jf = new JFrame();
    public Inst(JFrame jf){
        this.jf = jf;
        addActionListener(this);
        this.setText("Instructions");
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e)
            {
                JPanel message = new JPanel();
                message.add(new JLabel("<html>Instructions:<br><br>1. Press the number button to swap "
                        + "the number to blank place<br><br>2. Move the buttons such that they are in "
                        + "correct order<br><br>3. Numbers in correct position are highlighted in "
                        + "green<br><br>4. When all numbers are kept in order the game is finished."
                        + "<br><br>5. You can reset the game if you find it difficult<br><br>6. You can "
                        + "run god mode to see the solution<br><br>7. You can even adjust the dimensions"
                        + " of the board at the start of the game.<br><br><br><br> Thank you <br>Happy Playing!!</html>", SwingConstants.CENTER));
                message.setBackground(Color.WHITE);
                message.setBackground(Color.CYAN);
                message.setPreferredSize(new Dimension(600, 400));
                JDialog dialog = new JDialog(jf, "Instructions");
                dialog.setModal(true);
                dialog.setContentPane(message);
                dialog.pack();
                dialog.setLocationRelativeTo(jf);
                dialog.setVisible(true);
            }
        
    
    
}
