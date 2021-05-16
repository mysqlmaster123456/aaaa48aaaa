
package pkg2048;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Hra {
    private static Hra hra_instance = null;
   
    
    public int x = 5;
    public int y = 5;
    public int vnitrni_pole[][];
    private int WhatSpaceX = 0;
    private int WhatSpaceY = 0;
    private int TwoFour = 0;
    public int Moves = 0;
    public boolean konec = false;
    final JFrame frame = new JFrame();
        JButton button = new JButton();
    
            
    Random r = new Random(); 
    public Hra(){
        CreateField(x,y);
        
    }
    
    public static Hra getInstance() 
    { 
        if (hra_instance == null) 
            hra_instance = new Hra(); 
  
        return hra_instance; 
    }
    
    public void WinLoose(){
        int Empty = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (vnitrni_pole[i][j]==2048) {
                    
                    konec = true;
                }
                if (vnitrni_pole[i][j]==0) {
                    Empty++;
                }
            }
        }
        if (Empty > 0) {
            NewNum();
        }else{
            
            konec = true;
            System.out.println(konec);
            JOptionPane.showMessageDialog(frame,
    "Zaplnil jsi veškerá políčka. Prohrál jsi.");
            
        }
    }
    
    public void Move(int direction){
        switch(direction) {
            case 1:
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        for (int k = j+1; k < x; k++) {
                            if (vnitrni_pole[j][i]==0 && vnitrni_pole[k][i]!=0) {
                               int temp = vnitrni_pole[j][i];
                               vnitrni_pole[j][i] = vnitrni_pole[k][i];
                               vnitrni_pole[k][i] = 0;
                            }else if (vnitrni_pole[j][i]!=0 && vnitrni_pole[k][i]==vnitrni_pole[j][i]) {
                               vnitrni_pole[j][i] = vnitrni_pole[j][i]*2;
                               vnitrni_pole[k][i] = 0;
                               break;
                            }else if(vnitrni_pole[j][i]!=0 && vnitrni_pole[k][i]!=vnitrni_pole[j][i] && vnitrni_pole[k][i]!=0){
                                break;
                            }
                        }
                    }
                }           
                break;
            case 2:
                for (int i = 0; i < y; i++) {
                    for (int j = x-1; j > 0; j--) {
                        for (int k = j-1; k >= 0; k--) {
                            if (vnitrni_pole[j][i]==0 && vnitrni_pole[k][i]!=0) {
                               int temp = vnitrni_pole[j][i];
                               vnitrni_pole[j][i] = vnitrni_pole[k][i];
                               vnitrni_pole[k][i] = 0;
                            }else if (vnitrni_pole[j][i]!=0 && vnitrni_pole[k][i]==vnitrni_pole[j][i]) {
                               vnitrni_pole[j][i] = vnitrni_pole[j][i]*2;
                               vnitrni_pole[k][i] = 0;
                               break;
                            }else if(vnitrni_pole[j][i]!=0 && vnitrni_pole[k][i]!=vnitrni_pole[j][i] && vnitrni_pole[k][i]!=0){
                                break;
                            }
                        }
                    }
                }  
                break;
            case 3:
                for (int i = 0; i < x; i++) {
                    for (int j = y-1; j > 0; j--) {
                        for (int k = j-1; k >= 0; k--) {
                            if (vnitrni_pole[i][j]==0 && vnitrni_pole[i][k]!=0) {
                               int temp = vnitrni_pole[i][j];
                               vnitrni_pole[i][j] = vnitrni_pole[i][k];
                               vnitrni_pole[i][k] = 0;
                            }else if (vnitrni_pole[i][j]!=0 && vnitrni_pole[i][k]==vnitrni_pole[i][j]) {
                               vnitrni_pole[i][j] = vnitrni_pole[i][j]*2;
                               vnitrni_pole[i][k] = 0;
                               break;
                            }else if(vnitrni_pole[i][j]!=0 && vnitrni_pole[i][k]!=vnitrni_pole[i][j] && vnitrni_pole[i][k]!=0){
                                break;
                            }
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        for (int k = j+1; k < y; k++) {
                            if (vnitrni_pole[i][j]==0 && vnitrni_pole[i][k]!=0) {
                               int temp = vnitrni_pole[i][j];
                               vnitrni_pole[i][j] = vnitrni_pole[i][k];
                               vnitrni_pole[i][k] = 0;
                            }else if (vnitrni_pole[i][j]!=0 && vnitrni_pole[i][k]==vnitrni_pole[i][j]) {
                               vnitrni_pole[i][j] = vnitrni_pole[i][j]*2;
                               vnitrni_pole[i][k] = 0;
                               break;
                            }else if(vnitrni_pole[i][j]!=0 && vnitrni_pole[i][k]!=vnitrni_pole[i][j] && vnitrni_pole[i][k]!=0){
                                break;
                            }
                        }
                    }//j
                }//i
                break;
            default:
        }
        
        Moves++;
        WinLoose();
    }
    
    public void NewNum(){
        WhatSpaceX = r.nextInt(x);
        WhatSpaceY = r.nextInt(y);
        if (vnitrni_pole[WhatSpaceX][WhatSpaceY]==0) {
           TwoFour = r.nextInt(100)+1;
            if (TwoFour>70) {
                vnitrni_pole[WhatSpaceX][WhatSpaceY] = 4;
            }else{
                vnitrni_pole[WhatSpaceX][WhatSpaceY] = 2;
            }
        }else{
            NewNum();
        }
        }
    
    public void CreateField(int x_in, int y_in){
        x=x_in;
        y=y_in;
        vnitrni_pole = new int[x][y];
        NewNum();
        NewNum();
    }

}
