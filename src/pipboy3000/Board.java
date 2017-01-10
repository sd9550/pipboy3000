/*
 * pipboy3000 application
 * My recreation of the pipboy 3000 from Fallout 3
 * I don't own the rights to either of those so please don't sue me
 */

package pipboy3000;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author Stefan
 */
public class Board extends JPanel implements ActionListener, MouseListener {
    
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Timer timer;
    private  Image cursor, pipboy, stats, stats2, leftBorder, bottomBorder, cnd, rad, eff, name;
    private boolean cndClick, radClick, effClick;
    private final Color bgColor;
    
    public Board() {
        //Point hotspot = new Point(0, 0);
        //cursor = toolkit.getImage("images/cursor2.png");
        //Cursor cur = toolkit.createCustomCursor(cursor, hotspot, "img");
        //setCursor(cur);
        
        ImageIcon pp = new ImageIcon(this.getClass().getResource("images/pipboy.png"));
        pipboy = pp.getImage();
        
        ImageIcon cn = new ImageIcon(this.getClass().getResource("images/cnd.png"));
        cnd = cn.getImage();
        
        ImageIcon ra = new ImageIcon(this.getClass().getResource("images/rad.png"));
        rad = ra.getImage();
        
        ImageIcon ef = new ImageIcon(this.getClass().getResource("images/eff.png"));
        eff = ef.getImage();
        
        ImageIcon sta = new ImageIcon(this.getClass().getResource("images/stats.png"));
        stats = sta.getImage();
        
        ImageIcon sta2 = new ImageIcon(this.getClass().getResource("images/stats2.png"));
        stats2 = sta2.getImage();
        
        ImageIcon left = new ImageIcon(this.getClass().getResource("images/leftBorder.png"));
        leftBorder = left.getImage();
        
        ImageIcon bottom = new ImageIcon(this.getClass().getResource("images/bottomBorder.png"));
        bottomBorder = bottom.getImage();
        
        ImageIcon na = new ImageIcon(this.getClass().getResource("images/name.png"));
        name = na.getImage();
        
        cndClick = true;
        radClick = false;
        effClick = false;
        bgColor = new Color(2, 26, 10); // dark green
        
        setBackground(bgColor);
        addMouseListener(this);
        timer = new Timer(5, this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.drawImage(pipboy, 240, 100, this);
        g.drawImage(stats, 15, 5, this);
        g.drawImage(stats2, 15, 512, this);
        g.drawImage(cnd, 40, 85, this);
        g.drawImage(rad, 40, 140, this);
        g.drawImage(eff, 40, 195, this);
        g.drawImage(name, 300, 485, this);
        
        if(cndClick) {
            g.drawImage(leftBorder, 28, 79, this);
        } else if(radClick) {
            g.drawImage(leftBorder, 28, 134, this);
        } else if(effClick) {
            g.drawImage(leftBorder, 28, 189, this);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle cndRect = new Rectangle(40, 85, 53, 28);
        Rectangle radRect = new Rectangle(40, 140, 53, 28);
        Rectangle effRect = new Rectangle(40, 195, 53, 28);
        
        if(cndRect.contains(e.getX(), e.getY())) {
            cndClick = true;
            radClick = false;
            effClick = false;
        } else if(radRect.contains(e.getX(), e.getY())) {
            radClick = true;
            cndClick = false;
            effClick = false;
        } else if(effRect.contains(e.getX(), e.getY())) {
            effClick = true;
            cndClick = false;
            radClick = false;
        } 
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
}
