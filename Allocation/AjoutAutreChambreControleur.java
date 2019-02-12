import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class AjoutAutreChambreControleur implements ActionListener {
	private JComboBox<String> numero;
	private String reference;
	private JLabel phraseConfirme;
	private CardLayout gestionnaire;
	private JPanel panneau;
	private String type;
	private String date;
	private int nbrNuit;
	public AjoutAutreChambreControleur(JComboBox<String> numero0, String reference0, JLabel phraseConfirme0,CardLayout gestionnaire0, JPanel panneau0, String type0, String date0, int nbrNuit0){
		this.numero = numero0;
		this.reference = reference0;
		this.phraseConfirme = phraseConfirme0;
		this.gestionnaire = gestionnaire0;
		this.panneau = panneau0;
		this.type = type0;
		this.date = date0;
		this.nbrNuit = nbrNuit0;
	}
	@Override
	public void actionPerformed(ActionEvent event){
		int numChambre =  Integer.valueOf((String)numero.getSelectedItem());
		Boolean disponibilite = false;
		try {
				Class.forName("org.mariadb.jdbc.Driver");
				try {
					Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
					try{
						
						PreparedStatement requete = cx.prepareStatement("UPDATE Chambre SET disponibilite = ?,reference = ?, date = ?, nbrNuit = ?  WHERE numero = ?;");
						requete.setBoolean(1,disponibilite);
						requete.setString(2,reference);
						requete.setString(3,date);
						requete.setInt(4, nbrNuit);
						requete.setInt(5,numChambre);
						
						requete.executeUpdate();
						requete.close();	
						cx.close();																					

						//phraseConfirme.setForeground(new Color(0,0,255)); //bleu
						//this.phraseConfirme.setText("La chambre a été validée.");
						ValidationAjoutChambre validationVue = new ValidationAjoutChambre(gestionnaire, panneau, numChambre, reference);
						gestionnaire.show(panneau, Fenetre.VUE_VALIDATION_CHAMBRE);

						System.out.println("Chambre numéro : "+numChambre+" mise à jour");					


					}catch(SQLException e){
						System.err.println("Probleme de statement "+e.getMessage());

						System.err.println("Probleme d'update de chambre: "+numChambre+" pour la réservation: "+reference);

						//phraseConfirme.setForeground(new Color(255,0,0)); //rouge
						//this.phraseConfirme.setText("La chambre n'a pas été validée.");
					}
				}catch(SQLException e){
					System.err.println(e.getMessage());
				}
			}catch(ClassNotFoundException e){
				System.err.println("Probleme de classe");
			}
	}
}