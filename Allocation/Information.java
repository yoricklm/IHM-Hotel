import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.lang.Integer;

class Information extends JPanel{

	private static final int RETOUR_VUE_1 = 1;

	public Information(CardLayout gestionnaire, JPanel panneau, String reference, String date){
		setLayout(new GridBagLayout());
		this.setBackground(new Color( 212, 218, 252 )); // couleur bleu
		GridBagConstraints c = new GridBagConstraints();

		InformationModel informationModel = new InformationModel(reference, date);

		JLabel titre = new JLabel("Informations de la réservation");

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(25,25,25,25);
		add(titre,c);


		JLabel prenomTitre = new JLabel("Prénom: ");

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(prenomTitre,c);

		String prenomBDD = informationModel.getPrenom();

		JLabel prenom = new JLabel(""+prenomBDD+"");

		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(prenom,c);


		JLabel nomTitre = new JLabel("Nom: ");

		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nomTitre,c);

		String nomBDD = informationModel.getNom();

		JLabel nom = new JLabel(""+nomBDD+"");

		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nom,c);


		JLabel numeroTitre = new JLabel("Numéro de référence: ");

		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroTitre,c);

		String referenceBDD = informationModel.getReference();
		
		JLabel numero = new JLabel(referenceBDD);

		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numero,c);


		JLabel nbrNuitTitre = new JLabel("Nombre de nuit(s): ");

		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nbrNuitTitre,c);


		String nbrNuitBDD = informationModel.getNbrNuit();

		JLabel nbrNuit = new JLabel(""+nbrNuitBDD+"");

		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nbrNuit,c);


		JLabel debutTitre = new JLabel("Date de début de la réservation: ");

		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(debutTitre,c);

		String debutbdd = informationModel.getDebut();

		JLabel debut = new JLabel(""+debutbdd+"");

		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(debut,c);


		JLabel typeChambreTitre = new JLabel("Type de chambre :");

		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(typeChambreTitre,c);


		String typebdd = informationModel.getCategorie();
		
		JLabel typeChambre = new JLabel(""+typebdd+"");


		c.gridx = 2;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(typeChambre,c);


		JLabel numeroChambreTitre = new JLabel("Numéro de chambre :");

		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroChambreTitre,c);

		String numeroChambrebdd = informationModel.getNumeroChambre();
		int numeroChambreint;
		numeroChambreint = Integer.parseInt(numeroChambrebdd);

		Font font = new Font("Arial",Font.BOLD,30);

		JLabel numeroChambre = new JLabel(""+numeroChambrebdd+"");

		numeroChambre.setFont(font);

		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroChambre,c);


		JButton retour = new JButton("Retour");

		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(retour,c);

		RetourControleur retourControleur = new RetourControleur(gestionnaire, panneau, RETOUR_VUE_1);

		retour.addActionListener(retourControleur);


		JButton choisirAutreChambre = new JButton("Choisir une autre chambre");

		c.gridx = 2;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(choisirAutreChambre,c);


		JButton valider = new JButton("Valider la chambre");

		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(valider,c);


		JLabel phraseConfirme = new JLabel("");

		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(phraseConfirme,c);

		ChambreControleur chambrecontroleur = new ChambreControleur(numeroChambreint, referenceBDD, phraseConfirme, gestionnaire, panneau, debutbdd, typebdd, nbrNuitBDD);

		choisirAutreChambre.addActionListener(chambrecontroleur);

		valider.addActionListener(chambrecontroleur);

		JPanel information = this;
		panneau.add(information, Fenetre.VUE_INFORMATION);

	}	
}