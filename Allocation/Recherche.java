import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Recherche extends JPanel{

	private static JLabel erreur = new JLabel("");

	public Recherche(CardLayout gestionnaire, JPanel panneau, String date, JFrame fenetre){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setBackground(new Color( 212, 218, 252 ));

		

		this.remove(erreur);

		JLabel titreNomPrenom = new JLabel("Rechercher par nom et prénom du client");

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(titreNomPrenom,c);


		JLabel nomClient = new JLabel("Nom du client: ");

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nomClient,c);


		JTextField nomClientField = new JTextField(20);

		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nomClientField,c);

		JLabel prenomClient = new JLabel("Prenom du client: ");

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(prenomClient,c);


		JTextField prenomClientField = new JTextField(20);

		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(prenomClientField,c);



		JButton nomPrenomClientButton= new JButton("Chercher par nom et prenom");

		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(nomPrenomClientButton,c);




		JLabel titreNumero = new JLabel("Rechercher par numero de client");

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(10,5,5,10);
		add(titreNumero,c);


		JLabel numeroClient = new JLabel("Numero de client: ");

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroClient,c);


		JTextField numeroClientField = new JTextField(20);

		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroClientField,c);


		JButton numeroClientButton= new JButton("Chercher par numéro");

		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(5,5,5,5);
		add(numeroClientButton,c);


		

		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(50,25,15,25);
		add(erreur,c);

		this.revalidate();


		JButton quitter = new JButton("Quitter l'application");

		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.insets = new Insets(50,25,15,25);
		add(quitter,c);

		FermerFenetreControleur fermerFenControleur = new FermerFenetreControleur(fenetre, gestionnaire, panneau);

		RechercheControleur rechercheControleur = new RechercheControleur(gestionnaire, nomClientField, prenomClientField, numeroClientField, panneau, date, erreur);

		quitter.addActionListener(fermerFenControleur);

		numeroClientButton.addActionListener(rechercheControleur);
		
		nomPrenomClientButton.addActionListener(rechercheControleur);
	}

	public static void resetJLabel(){
		erreur.setText("");
	}
}