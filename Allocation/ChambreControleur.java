import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class ChambreControleur implements ActionListener {
	private int numero;
	private String reference;
	private JLabel phraseConfirme;
	private CardLayout gestionnaire;
	private JPanel panneau;
	private String date;
	private String type;
	private int nbrNuit;
	public ChambreControleur(int numero0, String reference0, JLabel phraseConfirme0,CardLayout gestionnaire0 , JPanel panneau0, String date0, String type0, String nbrNuit0){
		this.numero = numero0;
		this.reference = reference0;
		this.phraseConfirme = phraseConfirme0;
		this.gestionnaire = gestionnaire0;
		this.panneau = panneau0;
		this.date = date0;
		this.type = type0;
		this.nbrNuit = Integer.parseInt(nbrNuit0);
	}

	@Override
	public void actionPerformed(ActionEvent event){
		Boolean disponibilite = false;
		if(event.getActionCommand().equals("Valider la chambre")){

			try {
					Class.forName("org.mariadb.jdbc.Driver");
					try {
						Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
						try{
							
							PreparedStatement requete = cx.prepareStatement("UPDATE Chambre SET disponibilite = ?,reference = ?, date = ?, nbrNuit = ?  WHERE numero = ?;");
							requete.setBoolean(1,disponibilite);
							requete.setString(2,reference);
							requete.setString(3,date);
							requete.setInt(4,nbrNuit);
							requete.setInt(5,numero);
							
							requete.executeUpdate();
							requete.close();		
							cx.close();				

							ValidationAjoutChambre validationVue = new ValidationAjoutChambre(gestionnaire, panneau, numero, reference);
							gestionnaire.show(panneau, Fenetre.VUE_VALIDATION_CHAMBRE);

							System.out.println("Chambre numéro : "+numero+" mise à jour");					


						}catch(SQLException e){
							System.err.println("Probleme de statement "+e.getMessage());

							System.err.println("Probleme d'update de chambre: "+numero+" pour la réservation: "+reference);

							phraseConfirme.setForeground(new Color(255,0,0));
							this.phraseConfirme.setText("La chambre n'a pas été validée.");
						}
					}catch(SQLException e){
						System.err.println(e.getMessage());
					}
				}catch(ClassNotFoundException e){
					System.err.println("Probleme de classe");
				}

		}else{
			if(event.getActionCommand().equals("Choisir une autre chambre")){
	
				ChoixChambre choixChambre = new ChoixChambre(gestionnaire, panneau, reference, date, type, nbrNuit);

				System.out.println("**Affiche choix chambre**");	
				gestionnaire.show(panneau,Fenetre.VUE_CHOIX_CHAMBRE);
			
			}
			

		}
	}
}