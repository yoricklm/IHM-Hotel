import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame{

	public static final String VUE_RECHERCHE="vue recherche";
	public static final String VUE_INFORMATION="vue information";
	public static final String VUE_VALIDER_QUITTER="vue valider quitter";
	public static final String VUE_CHOIX_CHAMBRE="vue choix chambre";
	public static final String VUE_VALIDATION_CHAMBRE="vue validation chambre";

	public Fenetre(String date){
		this.setTitle("Allocation de chambre");
		this.setSize(800, 480);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panneau = new JPanel();

		CardLayout gestionnaire = new CardLayout();
		panneau.setLayout(gestionnaire);

		JPanel recherche = new Recherche(gestionnaire, panneau, date, this);
		panneau.add(recherche, VUE_RECHERCHE);

		this.add(panneau);

	}
}