/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pipboy3000;
import javax.swing.JFrame;

/**
 *
 * @author Stefan
 */
public class Pipboy3000 extends JFrame {

    public Pipboy3000() {
        add(new Board());
        setFocusable(true);
        setTitle("Pipboy3000");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Pipboy3000();
    }
    
}
