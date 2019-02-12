JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		AjoutAutreChambreControleur.java \
		ChambreControleur.java \
		ChoixChambre.java \
		ChoixChambreModel.java \
		Fenetre.java \
		FermerFenetreControleur.java \
		Information.java \
		InformationModel.java \
		Main.java \
		Recherche.java \
		RechercheControleur.java \
		Reessayer.java \
		RetourControleur.java \
		ValidationAjoutChambre.java \
		ValiderQuitter.java 

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) -cp "/export/documents/mariadb-client.jar:." $(MAIN) 2018-01-07 # <-- Modifier la date du jour ici dans le makefile

clean:
		$(RM) *.class