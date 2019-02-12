JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Fenetre.java \
		Controleur.java \
		PSelection.java \
		PStatistique.java \
		Modele.java \
		Main.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) -cp "/export/documents/mariadb-client.jar:." $(MAIN) 2018-01-07 # <-- Modifier la date du jour ici dans le makefile

clean:
		$(RM) *.class
