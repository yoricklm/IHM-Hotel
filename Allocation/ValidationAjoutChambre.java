import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.lang.Integer;

class ValidationAjoutChambre extends JPanel{
	private static final int RETOUR_VUE_1 = 1;
	public ValidationAjoutChambre(CardLayout gestionnaire, JPanel panneau, int numChambre, String reference){
		setLayout(new GridBagLayout());
		this.setBackground(new Color( 212, 218, 252 )); //couleur bleu
		GridBagConstraints c = new GridBagConstraints();

		JLabel titre = new JLabel("La chambre numero "+numChambre+" a été allouée pour la réservation "+reference);
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

		JButton debut = new JButton("Revenir à l'écran de recherche");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(debut,c);

		RetourControleur retourControleur = new RetourControleur(gestionnaire, panneau, RETOUR_VUE_1);
		debut.addActionListener(retourControleur);

		JPanel choixChambre = this;
		panneau.add(choixChambre, Fenetre.VUE_VALIDATION_CHAMBRE);
	}
}