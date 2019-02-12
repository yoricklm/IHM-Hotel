import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ValiderQuitter extends JPanel{
	public ValiderQuitter(JFrame fenetre, CardLayout gestionnaire, JPanel panneau){
		setLayout(new GridBagLayout());
		this.setBackground(new Color( 212, 218, 252 ));
		GridBagConstraints c = new GridBagConstraints();

		JLabel titre = new JLabel("Etes-vous sûr de vouloir quitter l'application?");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(titre,c);

		JButton ouiButton = new JButton("Oui");

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(ouiButton,c);

		JButton nonButton = new JButton("Non");

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nonButton,c);

		FermerFenetreControleur fermerFenControleur = new FermerFenetreControleur(fenetre, gestionnaire, panneau);
		RetourControleur retourControleur = new RetourControleur(gestionnaire, panneau, 1);

		ouiButton.addActionListener(fermerFenControleur);
		nonButton.addActionListener(retourControleur);

		JPanel validerQuitter = this;
		panneau.add(validerQuitter, Fenetre.VUE_VALIDER_QUITTER);
	}
}