import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RechercheControleurNumero implements ActionListener {
	private JTextField textNumero;
	private CardLayout gestionnaire;
	public RechercheControleurNumero(CardLayout gestionnaire0, JTextField numero0){
		this.textNumero = numero0;
		this.gestionnaire = gestionnaire0;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		String numerobdd;
		String numero = textNumero.getText();

		Fenetre fenetre = new Fenetre();

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");
				try{Statement declaration = cx.createStatement();

					ResultSet res = declaration.executeQuery("SELECT reference FROM Reservation R WHERE R.reference = '"+numero+"';");
					res.first();
					numerobdd = res.getString("reference");
					res.close();
					
					System.out.println(numero);

					if(numero.equals(numerobdd)){
						System.out.println("Numero dans bdd");

						//gestionnaire.show(fenetre,"vue information");


					}
				}catch(SQLException e){
					System.err.println("Probleme de statement");
					System.out.println("Numero pas dans bdd");

					//gestionnaire.show(fenetre,"vue erreur recherche"); // affiche page d'erreur
				}
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
			System.err.println("Probleme de classe");
		}
	}
}