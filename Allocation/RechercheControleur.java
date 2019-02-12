import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RechercheControleur implements ActionListener {
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textNumero;
	private CardLayout gestionnaire;
	private JPanel panneau;
	private String date;
	private JLabel erreurLabel;
	public RechercheControleur(CardLayout gestionnaire0, JTextField nom0, JTextField prenom0, JTextField numero0, JPanel panneau0, String date0, JLabel erreurLabel0){
		this.textNom = nom0;
		this.textPrenom = prenom0;
		this.textNumero = numero0;
		this.gestionnaire = gestionnaire0;
		this.panneau = panneau0;
		this.date = date0;
		this.erreurLabel = erreurLabel0;
	}

	@Override
	public void actionPerformed(ActionEvent event){

		if(event.getActionCommand().equals("Chercher par nom et prenom")){
			String nom = textNom.getText();
			String prenom = textPrenom.getText();

			String ref, numero;
			int numChambre;

				try {
					Class.forName("org.mariadb.jdbc.Driver");
					try {
						Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");
						try{Statement declaration = cx.createStatement();

							ResultSet res = declaration.executeQuery("SELECT * FROM Client C NATURAL JOIN Reservation R WHERE C.prenom = '"+prenom+"' AND C.nom = '"+nom+"';");
							res.first();
							ref = res.getString("R.reference");
							res.close();
							cx.close();

							try {
								 cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
								try{declaration = cx.createStatement();

									res = declaration.executeQuery("SELECT * FROM Chambre C WHERE C.reference = '"+ref+"';");
									res.first();
									numero = res.getString("reference");
									numChambre = res.getInt("numero");
									res.close();
									cx.close();	

									if(numero.equals(ref)){

										erreurLabel.setForeground(new Color(255,0,0));
										this.erreurLabel.setText("La référence de la réservation a déjà une chambre allouée qui est la chambre: "+numChambre); //Si oui on affiche message

									}



								}catch(SQLException e){
									System.err.println("Probleme de statement");

									System.out.println("Nom et prenom presents dans bdd "+nom+" "+prenom+". Référence: "+ref);

									Information informationVue = new Information(gestionnaire, panneau, ref, date);

									gestionnaire.show(panneau, Fenetre.VUE_INFORMATION);
								}
							}catch(SQLException e){
								System.err.println(e.getMessage());
							}
						}catch(SQLException e){
							System.err.println("Probleme de statement");

							System.out.println("Nom et prenom non presents dans bdd");

							erreurLabel.setForeground(new Color(255,0,0));
							this.erreurLabel.setText("Le nom et/ou le prenom ne se trouve(nt) pas dans la base de données");	//Message erreur de recherche
						}
					}catch(SQLException e){
						System.err.println(e.getMessage());
					}
				}catch(ClassNotFoundException e){
					System.err.println("Probleme de classe");
				}
		}else{
			String ref;
			String numero = textNumero.getText();
			int numChambre;

			try {
				Class.forName("org.mariadb.jdbc.Driver");

				try {  //Test si numéro de reservation a déja une chambre
					Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
					try{Statement declaration = cx.createStatement();

						ResultSet res = declaration.executeQuery("SELECT * FROM Chambre C WHERE C.reference = '"+numero+"';");
						res.first();
						ref = res.getString("reference");
						numChambre = res.getInt("numero");
						res.close();
						cx.close();
						
						System.out.println(numero);

						if(numero.equals(ref)){

							erreurLabel.setForeground(new Color(255,0,0));
							this.erreurLabel.setText("La référence de la réservation a déjà une chambre allouée qui est la chambre: "+numChambre); //Si oui on affiche message

						}
					}catch(SQLException e){
						System.err.println("Probleme de statement"+e.getMessage());
						System.out.println("Numero pas dans bdd thiou");

						try {
								cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");
								try{Statement declaration = cx.createStatement();

									ResultSet res = declaration.executeQuery("SELECT reference FROM Reservation R WHERE R.reference = '"+numero+"';");
									res.first();
									ref = res.getString("reference");
									res.close();
									cx.close();
									
									System.out.println(numero);

									if(numero.equals(ref)){
										System.out.println("Numero de référence présent dans bdd: "+numero);

										Information informationVue = new Information(gestionnaire, panneau, ref, date);

										gestionnaire.show(panneau,Fenetre.VUE_INFORMATION);


									}
								}catch(SQLException e1){
									System.err.println("Probleme de statement"+e1.getMessage());
									System.out.println("Numero pas dans bdd");

									erreurLabel.setForeground(new Color(255,0,0));
									this.erreurLabel.setText("La référence de la réservation ne se trouve pas dans la base de données.");
								}
							}catch(SQLException e1){
								System.err.println(e1.getMessage());
							}
					}
				}catch(SQLException e){
					System.err.println(e.getMessage());
				}
			}catch(ClassNotFoundException e){
				System.err.println("Probleme de classe");
			}

		}
	}
}