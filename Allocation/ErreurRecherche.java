import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ErreurRecherche extends JPanel{
	public ErreurRecherche(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel titre = new JLabel("Erreur de recherche");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(titre,c);


		JButton reessayerButton= new JButton("Réessayer");

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(reessayerButton,c);
	}
}