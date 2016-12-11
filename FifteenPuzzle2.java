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
public class FifteenPuzzle2 extends JPanel {
    public static JMenuItem change;
    public static JMenuItem godMode;
    public static JMenuItem giveUp;
    public static javax.swing.Timer t;
    static int n ;
    public static Reset r;
    public static Scanner sc = new Scanner(System.in);
       
    JButton[][] jb = new JButton[n][n]; 
    static int minute, second;
    static JFrame jf;
    public FifteenPuzzle2() {
        //ButtonGrid grid = new ButtonGrid(jb, jf, n, minute, second);
        setLayout(new GridLayout(n, n));
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
       
        
        
        
        change.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JPanel message = new JPanel();
                message.add(new JLabel("Label:"));
                message.setBackground(Color.WHITE);
                message.setBackground(Color.CYAN);
                message.setPreferredSize(new Dimension(300, 300));
                JDialog dialog = new JDialog(jf, "Instructions");
                dialog.setModal(true);
                dialog.setContentPane(message);
                dialog.pack();
                dialog.setLocationRelativeTo(jf);
                dialog.setVisible(true);
            }
        });
        
        
        giveUp.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {
                String multiLineMsg[] = { "Do you really want to give up?" };
                JOptionPane pane = new JOptionPane();
                pane.setMessage(multiLineMsg);
                JDialog d = pane.createDialog(null, "Give Up");
                d.setVisible(true);
                int selection = getSelection(pane);
 
                switch (selection) {
                case JOptionPane.OK_OPTION:
                  init(false);
                  break;
                case JOptionPane.CANCEL_OPTION:
                 
                  break;
                default:
                 
                }
               
               
            }  
   public int getSelection(JOptionPane optionPane) {
    int returnValue = JOptionPane.CLOSED_OPTION;
 
    Object selectedValue = optionPane.getValue();
    if (selectedValue != null) {
      Object options[] = optionPane.getOptions();
      if (options == null) {
        if (selectedValue instanceof Integer) {
          returnValue = ((Integer) selectedValue).intValue();
        }
      } else {
        for (int i = 0, n = options.length; i < n; i++) {
          if (options[i].equals(selectedValue)) {
            returnValue = i;
            break; // out of for loop
          }
        }
      }
    }
    return returnValue;
}
        });
    }
   
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
    
    /*public void initCorrectRowsCols(int N){
    	correctRow = new int[N*N] ; 
        int z = 0 ; 
        for(int i = 0 ; i < N ; i++ ){
            for(int j = 0 ; j < N ; j++ ){
                correctRow[z++] = i ;
            }
        }
        z = 0 ; 
        correctCol = new int[N*N] ; 
        for(int i = 0 ; i < N ; i++ ){
            for(int j = 0 ; j < N ; j++ ){
                correctCol[z++] = j ; 
            }
        }
    }*/
    public static void main(String[] args) {
        n = sc.nextInt();
        jf = new JFrame();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        JMenuBar jmb = new JMenuBar();
        jf.setJMenuBar(jmb);
        godMode = new JMenuItem("God Mode");
        giveUp = new JMenuItem("giveUp");
        Inst newIns = new Inst(jf);
        change = new JMenuItem("Im Bored");
        TimerCount timer = new TimerCount(jf);
        
        FifteenPuzzle2 fp = new FifteenPuzzle2();
        r = new Reset(jf, fp);
        jmb.add(r);
        jmb.add(godMode);
        jmb.add(giveUp);
        jmb.add(newIns);
        jmb.add(change);
        jmb.add(timer);
        
        
        
        jf.setContentPane(fp);
        jf.setTitle("Game of Fifteen- Extended");
        final DecimalFormat dc = new DecimalFormat("00");
        t = new javax.swing.Timer(
        1000,
                
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.setText(dc.format(minute) + ":" + dc.format(second));
                second++;
                if (second >= 60) {
                    second %= 60;
                    minute++;
                }
            }
        }
        );
        jf.pack();
        jf.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int w=(int)d.getWidth();
        int h=(int)d.getHeight();
        jf.setLocation((int)(w/2-jf.getWidth()/2),(int)(h/2-jf.getHeight()/2));
        t.start();
    }
}