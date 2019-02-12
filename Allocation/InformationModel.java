import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class InformationModel{
	private String reference;
	private String nom;
	private String prenom;
	private String nbrNuit;
	private String type;
	private String date;
	private String numeroChambre;

	public InformationModel(String reference0, String date0){
		this.reference = reference0;
		this.date = date0;

		String nombdd, prenombdd, nbrNuitbdd, typebdd, datebdd, numerobdd;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");	//Connexion base projetihm
				try{Statement declaration = cx.createStatement();

					ResultSet res = declaration.executeQuery("SELECT * FROM Client C NATURAL JOIN Reservation R WHERE R.reference = '"+reference+"';");
					res.first();

					nombdd = res.getString(3);
					nom=nombdd;

					prenombdd = res.getString(2);
					prenom=prenombdd;

					res.close();

					res = declaration.executeQuery("SELECT * FROM Reservation R WHERE R.reference = '"+reference+"';");
					res.first();
					nbrNuitbdd = res.getString(4);
					nbrNuit = nbrNuitbdd;

					typebdd = res.getString(5);
					type = typebdd;

					datebdd = res.getString(3);
					date = datebdd;

					res.close();
					cx.close();


					
					System.out.println("Nom: "+nombdd);
					System.out.println("Prenom: "+prenombdd);
					System.out.println("Référence: "+reference);
					System.out.println("Nombre de nuit(s): "+nbrNuit);
					System.out.println("Date début de réservation: "+date);
					System.out.println("Type de chambre: "+typebdd);



				}catch(SQLException e){
					System.err.println("Probleme de statement");
				}
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
			System.err.println("Probleme de classe");
		}

		//********** Recupère chambre dans bdd thiou *********//

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");	//Connexion base thiou
				try{Statement declaration = cx.createStatement();

					PreparedStatement requete = cx.prepareStatement("SELECT numero FROM Chambre C WHERE C.categorie = '"+type+"' AND disponibilite = '1';");

						ResultSet res = requete.executeQuery();
						res.first();
						numerobdd = res.getString(1);
					
					
					numeroChambre = numerobdd;

					requete.close();
					cx.close();

					System.out.println("Numero de la chambre: "+numeroChambre);


				}catch(SQLException e){
					System.err.println("Probleme de statement "+e.getMessage());
				}
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
			System.err.println("Probleme de classe");
		}
	}

		public String getNom(){
			return nom;
		}

		public String getPrenom(){
			return prenom;
		}

		public String getReference(){
			return reference;
		}

		public String getNbrNuit(){
			/*if(nbrNuit.equals("null")){
				return "Pas de nuit réservée pour aujourd'hui";
			}*/
			return nbrNuit;
		}

		public String getDebut(){
			return date;
		}

		public String getCategorie(){
			int typeint = Integer.parseInt(type);
			if(typeint == 1){
				return "Un lit simple";
			}
			
			if(typeint == 2){
				return "Un lit double";
			}

			if(typeint == 3){
				return "Deux lits simples";
			}
			return type;
		}

		public String getNumeroChambre(){
			return numeroChambre;
		}

}