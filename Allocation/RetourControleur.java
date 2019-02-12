import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RetourControleur implements ActionListener {
	private CardLayout gestionnaire;
	private JPanel panneau;
	private int page;
	public RetourControleur(CardLayout gestionnaire0, JPanel panneau0, int page0){
		this.gestionnaire = gestionnaire0;
		this.panneau = panneau0;
		this.page = page0;
	}
	@Override
	public void actionPerformed(ActionEvent event){
		if(page==1){
			Recherche.resetJLabel();
			gestionnaire.first(panneau);
		}else{
			gestionnaire.show(panneau, Fenetre.VUE_INFORMATION);
		}
	}
}