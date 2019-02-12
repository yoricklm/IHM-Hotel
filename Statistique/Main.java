import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main{
	public static void main(String[] args) {
	    Fenetre f = new Fenetre();
	    PSelection pselect  = new PSelection();
	    PStatistique pstats = new PStatistique();
	    Controleur c= new Controleur(pselect,pstats,f.getCardLayout(),f.getPanneau());
	    JButton bp=pselect.getBPresentation();
	    JButton bod=pselect.getBOccupationD();
	    JButton bop=pselect.getBOccupationP();
	    JButton bret=pstats.getBRetour();
	    ActionEvent presentation= new ActionEvent(bp,1,"p");
    	ActionEvent occupationD = new ActionEvent(bod,2,"od");
    	ActionEvent occupationP = new ActionEvent(bop,3,"op");
    	ActionEvent ret = new ActionEvent(bret,4,"r");
	    bp.addActionListener(c);
	    bod.addActionListener(c);
	    bop.addActionListener(c);
	    bret.addActionListener(c);
	    f.addPan(pselect, f.listContent[0]);
		f.addPan(pstats, f.listContent[1]);
	    f.setVisible(true);
	}
}
