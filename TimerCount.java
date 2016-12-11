/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go15;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

/**
 *
 * @author diwakar
 */
public class TimerCount extends JMenuItem {
    JFrame jf = new JFrame();
    static int minute, second;
    //public static javax.swing.Timer time;
    String x;
    TimerCount(JFrame jf){
        this.jf = jf;
        this.setText("starting...");
    }
        
}
