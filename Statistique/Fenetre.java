import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame{
    public String[] listContent = {"CARD_SELECTION", "CARD_STAT"};
    public JPanel pan;
    public CardLayout ges;
    public Fenetre(){
        this.setTitle("Statistique");
        this.setSize(720, 480);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan = new JPanel();
    	ges = new CardLayout();
	    pan.setLayout(ges);	
     	this.add(pan);
    }
    void addPan(JPanel p,String s){
    	this.pan.add(p,s);
    }
    JPanel getPanneau(){
    	return(this.pan);
    }
    CardLayout getCardLayout(){
    	return(this.ges);
    }
}
