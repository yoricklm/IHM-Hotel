import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PStatistique extends JPanel{
    JButton retour;
    JLabel titre;
    Font police;
    JLabel debut;
    JLabel fin;
    JLabel stat;
    JLabel sousTitre;
    GridBagConstraints c;
    public PStatistique() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		retour = new JButton("<--");
		debut = new JLabel("date");
		fin = new JLabel(" ");
		titre = new JLabel("Statistique");
		sousTitre = new JLabel("sous titre");
		stat= new JLabel("0");
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
		/*sous titre*/
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(sousTitre,c);
		/*debut*/
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(debut,c);
		/*fin*/
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(fin,c);
		/*stat*/
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(stat,c);
		/*bouton*/
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(retour,c);
    }
    public void setStat(String st,String d,String x,String f){
		this.sousTitre.setText(st);
		this.debut.setText(d+" au ");
		this.fin.setText(f+" : ");
		this.stat.setText(x+"%");
    }
    public void setStat(String st,String d,String x){
		
		this.sousTitre.setText(st);
		this.debut.setText(d+" : ");
		this.stat.setText(x+"%");
		this.repaint();
    }
    public void resetStat(){
		
		this.sousTitre.setText("sous titre");
		this.debut.setText("date");
		this.fin.setText(" ");
		this.stat.setText("taux");
		this.repaint();
    }
    public JButton getBRetour(){
    	return(retour);
    }
}
