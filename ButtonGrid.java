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
public class ButtonGrid extends JPanel {
    JButton[][] jb;
    JFrame jf;
    int n;
    int minute;
    int second;
    public ButtonGrid(JButton[][] jb, JFrame jf, int n, int minute, int second){
        this.jb = jb;
        this.n = n;
        this.jf = jf;
        System.out.println(n);
        setLayout(new GridLayout(n, n));
        System.out.println("Grid set");
        int i, j, k;
        init(true);
        
        for (i = 0; i < jb.length; i++)
        for (j = 0; j < jb[i].length; j++)
        jb[i][j].addActionListener((ActionEvent e) -> {
            String command = e.getActionCommand();
            String[] indices = command.split(" ");
            int i1 = Integer.parseInt(indices[0]);
            int j1 = Integer.parseInt(indices[1]);
            int[] r = {i1 - 1, i1, i1 + 1, i1};
            int[] c = {j1, j1 + 1, j1, j1 - 1};
            for (int k1 = 0; k1 < 4; k1++) {
                System.out.println("" + r[k1] + " " + c[k1]);
                if (r[k1] >= 0 && r[k1] < n && c[k1] >= 0 && c[k1] < n) {
                    JButton button = jb[r[k1]][c[k1]];
                    if (button.getText().equals("")) {
                        button.setText(jb[i1][j1].getText());
                        jb[i1][j1].setText("");
                        jb[i1][j1].setBackground(null);
                    }
                }
            }
            boolean flag = true;
            while (flag) {
                for (int x1 = 0; x1 < n; x1++) {
                    for (int y1 = 0; y1 < n; y1++) {
                        if (jb[x1][y1].getText() == "") {
                            if (x1 != n-1 && y1 != n-1) {
                                flag = false;
                            }
                        } else {
                            int butVal = Integer.parseInt(jb[x1][y1].getText());
                            if (butVal != (x1) * n + y1 + 1) {
                                jb[x1][y1].setBackground(null);
                                flag = false;
                            } else {
                                jb[x1][y1].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
                if(flag){
                    JPanel messageS = new JPanel();
                    messageS.add(new JLabel("Congrats you are one of 0.1% on this planet who could solve this individually."));
                    messageS.setBackground(Color.WHITE);
                    messageS.setBackground(Color.CYAN);
                    messageS.setPreferredSize(new Dimension(300, 300));
                    JDialog dialogS = new JDialog(jf, "Party Time !!");
                    dialogS.setModal(true);
                    dialogS.setContentPane(messageS);
                    dialogS.pack();
                    dialogS.setLocationRelativeTo(jf);
                    dialogS.setVisible(true);
                    flag = false;
                }
            }
         
    });
       

        
        
    }
    
        /**
     *
     * @param a
     * @return
     */
    public int getInvCount(ArrayList a){
        int N = 4;
        int inv_count = 0;
        int i;
        int j;
            for ( i = 0; i < N * N - 2; i++)
            {
                for ( j = i + 1; j < N * N - 1 ; j++)
                    {
            // count pairs(i, j) such that i appears
            // before j, but i > j.
                   
                        if((Integer)a.get(j) != 0)
                        {
                            if((Integer)a.get(i) != 0){
                                if((Integer)a.get(i) > (Integer)a.get(j)){
                                     inv_count++;
                                }
                            }
                        }
                       
                           
                    }
             }
        return inv_count;
    }
    
    
       
   
   
   
    public void init(boolean firstTime) {
        ArrayList a = new ArrayList();
        int i, j, k;
        for (i = 1; i <= (n*n) -1; i++)
        a.add(i);
        Collections.shuffle(a);
       
         int invC = getInvCount(a);
       
        while (invC % 2 != 0){
            System.out.println("inv Count:"+ invC);
            Collections.shuffle(a);
            invC = getInvCount(a);
        }
       
       
        a.add(0);
       
       
        System.out.println("passed inv Count:"+ invC);
       
        k = 0;
        for (i = 0; i < jb.length; i++)
        for (j = 0; j < jb[i].length; j++) {
            Integer val = (Integer)a.get(k++);
            if (firstTime) {
                
                jb[i][j] = new JButton(val + "");
                jb[i][j].setActionCommand(i + " " + j);
                jb[i][j].setPreferredSize(new Dimension(60, 60));
                add(jb[i][j]);
                System.out.println("added button to grid");
                jb[i][j].setBackground(null);
            }
            else{
                jb[i][j].setText(val + "");
                
                jb[i][j].setBackground(null);
            }
            
        }
        jb[n-1][n-1].setText("");
        minute = 0;
        second = 0;
        /*initCorrectRowsCols(n);
        Board initial = new Board(blocks);
      
        solver = new Solver(initial);*/
    }


    
}
