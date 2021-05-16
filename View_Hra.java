
package pkg2048;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class View_Hra extends javax.swing.JFrame implements PropertyChangeListener{

    private static View_Hra vh_instance = null;
    public View_Hra() {
        initComponents();
        this.setBounds(0, 0, 800, 850);
        this.setResizable(false);
        Vytvor_Pole();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    Hra hra = Hra.getInstance();
    
    public static View_Hra getInstance() 
    { 
        if (vh_instance == null) 
            vh_instance = new View_Hra(); 
  
        return vh_instance; 
    }//singleton bullshit 
    
    
    
    public JButton[][] buttons = new JButton[hra.x][hra.y];
    
    public void Vytvor_Pole(){
        int xin = 0;
        int yin = 0;
        
        buttons = new JButton[hra.x][hra.y];
        
        for (int i = 0; i < hra.x; i++) {
            for (int j = 0; j < hra.y; j++) {
                generateButton(xin, yin, i, j);
                if (hra.vnitrni_pole[i][j]==0) {
                    buttons[i][j].setText("");
                }else{
                    buttons[i][j].setText(""+hra.vnitrni_pole[i][j]);
                }
                xin++;
            }
            xin = 0;
                yin++;
        }
    }
    
    private void generateButton(int xGrid, int yGrid, int x, int y) {
        JButton btn = new JButton();
        btn.setText("");
        btn.setFont(new Font("MV Boli",Font.BOLD, 20));
        btn.setBounds(100 + (58 * xGrid), 100 + (58 * yGrid), 50, 50);
        btn.setBorder(new LineBorder(Color.black));
        btn.setEnabled(false);
        buttons[x][y]=btn;
        this.add(btn);
        revalidate();
        repaint();
    }
    
    public void SmazStary(){       
            for (int i = 0; i < hra.x; i++) {
                for (int j = 0; j < hra.y; j++) {  
                    this.remove(buttons[i][j]);
                }           
        }     
    }
    
    public void VykresliPole(){
        for (int i = 0; i < hra.x; i++) {
            for (int j = 0; j < hra.y; j++) {
                if (hra.vnitrni_pole[i][j]==0) {
                    buttons[i][j].setText("");
                }else{
                    buttons[i][j].setText(""+hra.vnitrni_pole[i][j]);
                }
                if (hra.vnitrni_pole[i][j]>256) {
                    buttons[i][j].setFont(new Font("MV Boli",Font.BOLD, 10));
                }//zmensi font pokud je cislo moc velke
            }
        }
        jLabel2.setText("Počet tahů: "+hra.Moves);
        
        if (hra.konec==true) {
            firePropertyChange("Konec Hry", false, true);
            //System.out.println("Konec: "+hra.konec);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 50)); // NOI18N
        jLabel1.setText("2048");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel2.setText("Pocet tahu:0 ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)))
                .addContainerGap(348, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        int key = evt.getKeyCode();
        //System.out.println("Im working");
        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                hra.Move(4);
                VykresliPole();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                hra.Move(3);
                VykresliPole();
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                hra.Move(1);
                VykresliPole();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                hra.Move(2);
                VykresliPole();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formKeyReleased

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Hra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
}
