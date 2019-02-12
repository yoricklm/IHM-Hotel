import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.lang.Integer;

class ChoixChambre extends JPanel{

	private static final int RETOUR_VUE_2 = 2;

	public ChoixChambre(CardLayout gestionnaire, JPanel panneau, String reference, String date, String type, int nbrNuit){
		setLayout(new GridBagLayout());
		this.setBackground(new Color( 212, 218, 252 )); //couleur bleu
		GridBagConstraints c = new GridBagConstraints();

		JLabel phraseConfirme = new JLabel("");

		ChoixChambreModel choixChambreModel = new ChoixChambreModel(reference, type, phraseConfirme);
		RetourControleur retourControleur = new RetourControleur(gestionnaire, panneau, RETOUR_VUE_2);

		JLabel titre = new JLabel("Choisir une autre chambre");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(titre,c);

		JComboBox<String> chambreLibre = new JComboBox<String>();

		int[] numeroChambre = choixChambreModel.getNumeroChambre();
		for(int i=0; i<numeroChambre.length && numeroChambre[i]!=0; i++){
			//System.out.println(" Chambre disponible: "+numeroChambre[i]);
			chambreLibre.addItem(""+numeroChambre[i]);
		}

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(chambreLibre,c);

		JButton retour = new JButton("Retour");

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(retour,c);

		retour.addActionListener(retourControleur);


		JButton valider = new JButton("Valider");

		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(valider,c);


		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(phraseConfirme,c);

		AjoutAutreChambreControleur ajoutAutreChambreControleur = new AjoutAutreChambreControleur(chambreLibre, reference, phraseConfirme, gestionnaire, panneau, type, date, nbrNuit);

		valider.addActionListener(ajoutAutreChambreControleur);

		JPanel choixChambre = this;
		panneau.add(choixChambre, Fenetre.VUE_CHOIX_CHAMBRE);
	}
}