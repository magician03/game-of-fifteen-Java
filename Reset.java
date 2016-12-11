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

public class Reset extends JMenuItem implements ActionListener{
    JFrame jf = new JFrame();
    FifteenPuzzle2 local;
    public Reset(JFrame jf, FifteenPuzzle2 fp){
        this.jf = jf;
        addActionListener(this);
        this.setText("Reset");
        local = fp;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
            {
                local.init(false);
            }
    
}
