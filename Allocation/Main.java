import javax.swing.*;
import java.awt.*;

public class Main{
	public static void main(String[] args) {
		if(args.length!=1){
			System.err.println("Problème de syntaxe: java -cp \"/export/documents/mariadb-client.jar:.\" Main <date>");
			System.exit(0);
		}

		String date = args[0];
		JFrame fenetre = new Fenetre(date);
		fenetre.setVisible(true);

	}
}