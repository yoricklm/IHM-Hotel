import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RechercheControleurNomPrenom implements ActionListener {
	private JTextField textNom;
	private JTextField textPrenom;
	public RechercheControleurNomPrenom(JTextField nom0, JTextField prenom0){
		this.textNom = nom0;
		this.textPrenom = prenom0;
	}

	@Override
	public void actionPerformed(ActionEvent event){

		String nom = textNom.getText();
		String prenom = textPrenom.getText();

		int idbdd;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm","projetihm","mhitejorp");
				try{Statement declaration = cx.createStatement();

					ResultSet res = declaration.executeQuery("SELECT id FROM Client C WHERE C.prenom = '"+prenom+"' AND C.nom = '"+nom+"';");
					res.first();
					idbdd = res.getInt("id");
					res.close();
					
					System.out.println(nom+" "+prenom+" "+idbdd);

				}catch(SQLException e){
					System.err.println("Probleme de statement");
				}
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
			System.err.println("Probleme de classe");
		}

	}
}