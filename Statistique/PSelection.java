import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PSelection extends JPanel{
    JButton bPresentation;
    JButton bOccupationD;
    JButton bOccupationP;
    JTextField dateP;
    JTextField dateO;
    JTextField debut;
    JTextField fin;
    JLabel info;
    JLabel info1;
    JLabel info2;
    GridBagConstraints c;
    JLabel titre;
    public PSelection(){
		c = new GridBagConstraints();
		bPresentation = new JButton("Afficher le taux de non présentation");
		bOccupationD = new JButton("Afficher le taux d'occupation par date");
		bOccupationP = new JButton("Afficher le taux d'occupation par periode");
		dateP = new JTextField("jj-mm-aaaa");
		dateO = new JTextField("jj-mm-aaaa");
		debut = new JTextField("date début");
		fin =  new JTextField("date fin");
		info = new JLabel("(indiquer une date)");
		info1 = new JLabel("(indiquer une date)");
    	info2=new JLabel("(indiquer une période)");
		titre = new JLabel("Statistique");
		setLayout(new GridBagLayout());

		/*titre*/
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(titre,c);
		/*bpresentation*/
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(bPresentation,c);
		/*dateP*/
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(dateP,c);
		/*info*/
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(info,c);
		/*bOccupationD*/
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(bOccupationD,c);
		/*dateO*/
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(dateO,c);
		/*info1*/
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(info1,c);
		/*bOccupationP*/
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(bOccupationP,c);
		/*debut*/
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(debut,c);
		/*fin*/
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(fin,c);
		/*info2*/
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(info2,c);
    }
    public JButton getBPresentation(){
    	return(bPresentation);
    }
    public JButton getBOccupationD(){
    	return(bOccupationD);
    }
    public JButton getBOccupationP(){
    	return(bOccupationP);
    }
    public String getDateP(){
    	return(dateP.getText());
    }
    public String getDateO(){
    	return(dateO.getText());
    }
    public String getDateDebut(){
    	return(debut.getText());
    }
    public String getDateFin(){
    	return(fin.getText());
    }
}
