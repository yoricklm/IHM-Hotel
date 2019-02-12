import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class FermerFenetreControleur implements ActionListener {
	private JFrame fenetre;
	private CardLayout gestionnaire;
	private JPanel panneau;
	public FermerFenetreControleur(JFrame fenetre0, CardLayout gestionnaire0, JPanel panneau0){
		this.fenetre = fenetre0;
		this.gestionnaire = gestionnaire0;
		this.panneau = panneau0;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if(event.getActionCommand().equals("Quitter l'application")){
			ValiderQuitter validerQuitter = new ValiderQuitter(fenetre, gestionnaire, panneau);
			gestionnaire.show(panneau,Fenetre.VUE_VALIDER_QUITTER);
		}else{
			fenetre.dispose();
		}
	}
}