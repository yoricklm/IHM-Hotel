import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Reessayer implements ActionListener {
	private JFrame fenetre;
	public Reessayer(JFrame fenetre0){
		this.fenetre = fenetre0;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		fenetre.dispose();
	}
}