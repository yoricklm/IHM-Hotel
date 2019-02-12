import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Controleur implements ActionListener {
    private Modele m;
    private PSelection pselect;
    private PStatistique pstat;
    CardLayout ges;
    JPanel pan;
     public Controleur(PSelection pselect,PStatistique pstat,CardLayout g,JPanel p){
		this.pan=p;
		this.ges=g;
		this.pselect=pselect;
		this.pstat=pstat;
		m=new Modele();
    }
    public String setDate(String d){
		String jour = new String();
		String mois = new String();
		String an= new String();;
		if(d.length()==10){
		    jour = d.substring(0,2);
		    mois = d.substring(3,5);
		    an = d.substring(6,10);
		}else if(d.length()==9){
		    jour = d.substring(0,1);
		    mois = d.substring(2,4);
		    an = d.substring(5,9);
		}
		return(an+"-"+mois+"-"+jour);
    }
    @Override
    public void actionPerformed(ActionEvent e){
		String date;
		String debut;
		String fin;
		String txt;
		String res;
		

		txt=e.getActionCommand();
		if(txt.equals("Afficher le taux de non présentation")){
			pstat.resetStat();
			
			date=pselect.getDateP();
			date=setDate(date);
			res=m.getTauxNonPresentation(date);
		    pstat.setStat("taux de non presentation : ",date,res);
		    ges.next(pan);
		}
		else if(txt.equals("Afficher le taux d'occupation par date")){
			pstat.resetStat();
			date=pselect.getDateO();
			date=setDate(date);
			res=m.getTauxOccupationDate(date);
		   	pstat.setStat("taux occupation par date : ",date,res);
		    ges.next(pan);
		}
		else if(txt.equals("Afficher le taux d'occupation par periode")){
			pstat.resetStat();
			debut=pselect.getDateDebut();
			debut=setDate(debut);
			fin=pselect.getDateFin();
			fin=setDate(fin);
			res=m.getTauxOccupationPeriode(debut,fin);
		    pstat.setStat("taux occupation par periode : ",debut,res,fin);
		    ges.next(pan);
		}
    	else if(txt.equals("<--")){
	    	ges.show(pan,"CARD_SELECTION");
		}
    }
}
