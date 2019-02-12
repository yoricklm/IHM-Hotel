import java.sql.*;

public class Modele{
    private int tPresentation;
    private int tOccupation;

    public Modele(){
	
    }
    public int getNbReservation(String date){
		String r=new String();
		try {
		    Class.forName("org.mariadb.jdbc.Driver");  
		    try {
				Connection con=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");
				try{
			   		PreparedStatement requete = con.prepareStatement("SELECT count(*) FROM Reservation WHERE debut = date('"+date+"')");
			   		//requete.setString(1,date);
			   		ResultSet res = requete.executeQuery();
					res.first();
					r= res.getString("count(*)");
				    res.close();
				    requete.close();
				    con.close();
				}catch(SQLException e){
			    	System.err.println("Probleme de statement");
				}
		    }catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
		    System.err.println("Probleme de classe");
		    
		}
		return(Integer.parseInt(r));
    }
    public String getNbClientDate(String date){
		String r=new String();
		int i;
	
		try {
		    Class.forName("org.mariadb.jdbc.Driver");  
		    try {
				Connection con=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
				try{
			   		PreparedStatement requete = con.prepareStatement("SELECT count(*) FROM Chambre WHERE (date <= date('"+date+"'))&& (DATE_ADD(date,INTERVAL nbrNuit DAY)>=date('"+date+"'))");
			   		ResultSet res = requete.executeQuery();
					res.first();
					r= res.getString("count(*)");
				    res.close();
				    requete.close();
				    con.close();
				}catch(SQLException e){
			    	System.err.println("Probleme de statement");
				}
		    }catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
		    System.err.println("Probleme de classe");
		}
		
		return(r);
    }
    public String getTauxOccupationPeriode(String date,String fin){
    	String r=new String();
    	Float t=new Float(0.0);
    	int i=0;

		try {
		    Class.forName("org.mariadb.jdbc.Driver");  
		    try {
				Connection con=DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/thiou","thiou","thiou");
				try{
			   		PreparedStatement requete = con.prepareStatement("SELECT count(*) FROM Chambre WHERE (date <= date('"+date+"'))&& (DATE_ADD(date,INTERVAL nbrNuit DAY)>=date('"+date+"'))");
			   		ResultSet res = requete.executeQuery();
			   		while(!date.equals(fin)){
			   			requete = con.prepareStatement("SELECT count(*) FROM Chambre WHERE (date <= date('"+date+"'))&& (DATE_ADD(date,INTERVAL nbrNuit DAY)>=date('"+date+"'))");
			   			
						res = requete.executeQuery();
						res.first();
						r= res.getString("count(*)");
			
						t=t+new Float(r);
						i++;
						
						date=this.nextDate(date);
					
					}
					t=(t/(100*i))*100;
				    res.close();
				    requete.close();
				    con.close();
				}catch(SQLException e){
			    	System.err.println("Probleme de statement");
				}
		    }catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}catch(ClassNotFoundException e){
		    System.err.println("Probleme de classe");
		}
		return(t.toString());
    }
	
    public String nextDate(String d){
		String jour = new String();
		String mois = new String();
		String an= new String();

		if(d.length()==10){
		    jour = d.substring(8,10);
		    mois = d.substring(5,7);
		    an = d.substring(0,4);
		}

		Integer j=new Integer(jour);
		Integer m=new Integer(mois);
		Integer a=new Integer(an);

		j++;
		if(j==31 && (m==2||m==4||m==6||m==9||m==11)){
			j=1;
			m++;
		}else if(j==32 && (m==1||m==3||m==5||m==7||m==8||m==10||m==12)){
			j=1;
			m++;
		}
		if(m==13){
			a++;
			m=1;
			j=1;
		}
		if(j<10&&m>=10){
			return(a+"-"+m+"-0"+j);
		}
		else if(j<10&&m<10){
			return(a+"-0"+m+"-0"+j);
		}
		else if(j>=10&&m<10){
			return(a+"-0"+m+"-"+j);
		}
		else
			return(a+"-"+m+"-"+j);
    }
    public String getTauxNonPresentation(String date){
   		Float res;
   		Float reservation;
   		Float client;
   		reservation=new Float(this.getNbReservation(date));
    	client= new Float(this.getNbClientDate(date));
    	res=(1-client/reservation)*100;

    	return(res.toString());
    }
    public String getTauxOccupationDate(String date){
   		Float res;
   		Float client;
    	client= new Float(this.getNbClientDate(date));
    	res=(client/100)*100;
    
    	return(res.toString());
    }
}
