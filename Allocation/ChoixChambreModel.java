import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ChoixChambreModel{
	private String reference;
	private int[] numeroChambre = new int[50];
	private int type;
	private JLabel phraseConfirme;
	private static final int CHAMBRE_DISPONIBLE = 1;


	public ChoixChambreModel(String reference0, String type0, JLabel phraseConfirme0){
		this.reference = reference0;
		if(type0.equals("Un lit simple")){
			this.type=1;
		}
		
		if(type0.equals("Un lit double")){
			this.type=2;
		}

		if(type0.equals("Deux lits simples")){
			this.type=3;
		}
		this.phraseConfirme = phraseConfirme0;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				Connection cx=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
				try{Statement declaration = cx.createStatement();

					PreparedStatement requete = cx.prepareStatement("SELECT * FROM Chambre C WHERE C.categorie = ? AND disponibilite = ?;");
					requete.setInt(1,type);
					requete.setInt(2,CHAMBRE_DISPONIBLE);
					ResultSet res = requete.executeQuery();

					int[] numerobdd = new int[50];
					int i=0;

					while(res.next()){
						numerobdd[i] = res.getInt(1);
						numeroChambre[i] = numerobdd[i];
						i++;
					}

					requete.close();
					res.close();
					cx.close();


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

	public int[] getNumeroChambre(){
		return numeroChambre;
	}

}