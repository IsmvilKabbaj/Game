package Morpion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Morpion {

	private JFrame frame;
	private JTextField txtJoueurO; //Nom joueur O
	private JTextField txtJoueurX; //Nom joueur X
	private JTextField txtScoreX; //Score joueur X
	private JTextField txtScoreO; //Score joueur O
	
	// Declaration des boutons : 
	JButton Rejouer = new JButton("Rejouer");
	JButton Quitter = new JButton("Quitter");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	
	//Variables : 
	public String play = "X";

	//Création de joueurs à partir de la classe Joueur (nom,victoires,coups)
	private Joueur joueurX;
	private Joueur joueurO;
	

	//Create the application.
	public Morpion(Joueur joueurX2, Joueur joueurO2) {
		initialize();
		this.joueurX = joueurX2;
		this.joueurO = joueurO2;
		lancement();
		this.frame.setVisible(true); //Affiche la fenetre Morpion
		txtJoueurX.setText(joueurX.getNom());
		txtJoueurO.setText(joueurO.getNom());
		popUpQuiCommence();
	}
	
	//Methodes : 
	
	//Permet de reset tous les BTN et le nombre de coups
	public void lancement() {
		btn1.setText(null);
		btn2.setText(null);
		btn3.setText(null);		
		btn4.setText(null);	
		btn5.setText(null);	
		btn6.setText(null);	
		btn7.setText(null);	
		btn8.setText(null);	
		btn9.setText(null);	
		
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
		
		joueurX.setNbCoups(0);
		joueurO.setNbCoups(0);
		
	}
	
	//Permet de SWITCHER entre X et O et de tester si gagnant
	public void appuiBouton(JButton btn) { 
		btn.setText(play);
		
		if(play.equalsIgnoreCase("X")) {
			btn.setEnabled(false);
			play="O";
			joueurX.setNbCoups(joueurX.getNbCoups() +1);
		}
		else {
			btn.setEnabled(false);
			play="X";
			joueurO.setNbCoups(joueurX.getNbCoups() +1);
		}
		gagnant();
	}
	
	//Gagnant
	public void gagnant() {		
		String b1=(btn1.getText() != null) ? btn1.getText() : ""; //Permet d'instancier le btn à "" si son contenu est null
		String b2=(btn2.getText() != null) ? btn2.getText() : ""; //Sinon bug au niveau de equals.IgnoreCase 
		String b3=(btn3.getText() != null) ? btn3.getText() : "";
		String b4=(btn4.getText() != null) ? btn4.getText() : "";
		String b5=(btn5.getText() != null) ? btn5.getText() : "";
		String b6=(btn6.getText() != null) ? btn6.getText() : "";
		String b7=(btn7.getText() != null) ? btn7.getText() : "";
		String b8=(btn8.getText() != null) ? btn8.getText() : "";
		String b9=(btn9.getText() != null) ? btn9.getText() : "";
		int e=0;
		if(b1.equalsIgnoreCase("X")&& b2.equalsIgnoreCase("X")&& b3.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b4.equalsIgnoreCase("X")&& b5.equalsIgnoreCase("X")&& b6.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b7.equalsIgnoreCase("X")&& b8.equalsIgnoreCase("X")&& b9.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b1.equalsIgnoreCase("X")&& b4.equalsIgnoreCase("X")&& b7.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b2.equalsIgnoreCase("X")&& b5.equalsIgnoreCase("X")&& b8.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b3.equalsIgnoreCase("X")&& b6.equalsIgnoreCase("X")&& b9.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b1.equalsIgnoreCase("X")&& b5.equalsIgnoreCase("X")&& b9.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b3.equalsIgnoreCase("X")&& b5.equalsIgnoreCase("X")&& b7.equalsIgnoreCase("X")) {popUpGagnant(joueurX);e=1;}
		if(b1.equalsIgnoreCase("O")&& b2.equalsIgnoreCase("O")&& b3.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b4.equalsIgnoreCase("O")&& b5.equalsIgnoreCase("O")&& b6.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b7.equalsIgnoreCase("O")&& b8.equalsIgnoreCase("O")&& b9.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b1.equalsIgnoreCase("O")&& b4.equalsIgnoreCase("O")&& b7.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b2.equalsIgnoreCase("O")&& b5.equalsIgnoreCase("O")&& b8.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b3.equalsIgnoreCase("O")&& b6.equalsIgnoreCase("O")&& b9.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b1.equalsIgnoreCase("O")&& b5.equalsIgnoreCase("O")&& b9.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		if(b3.equalsIgnoreCase("O")&& b5.equalsIgnoreCase("O")&& b7.equalsIgnoreCase("O")) {popUpGagnant(joueurO);e=1;}
		else if((b1.equalsIgnoreCase("O")|| b1.equalsIgnoreCase("X")) && (b2.equalsIgnoreCase("O")|| b2.equalsIgnoreCase("X"))&& (b3.equalsIgnoreCase("O")|| b3.equalsIgnoreCase("X"))&& (b4.equalsIgnoreCase("O")|| b4.equalsIgnoreCase("X"))&& (b5.equalsIgnoreCase("O")|| b5.equalsIgnoreCase("X"))&& (b6.equalsIgnoreCase("O")|| b6.equalsIgnoreCase("X"))&& (b7.equalsIgnoreCase("O")|| b7.equalsIgnoreCase("X"))&& (b8.equalsIgnoreCase("O")|| b8.equalsIgnoreCase("X"))&& (b9.equalsIgnoreCase("O")|| b9.equalsIgnoreCase("X")) && e==0){popUpEgalite();} 
		
			
		
		
	}
	
	//PopUp lorsqu'il y a un gagnant
	public void popUpGagnant(Joueur joueur) {
		joueur.setNbVictoires(joueur.getNbVictoires() +1); //Augmente le compteur de victoires
		if(joueur == joueurX) txtScoreX.setText(String.valueOf(joueur.getNbVictoires()));
		else txtScoreO.setText(String.valueOf(joueur.getNbVictoires()));
		int option = JOptionPane.showConfirmDialog(null, joueur.getNom() + " gagne en " + joueur.getNbCoups() + " coups.\nVoulez-vous rejouer ?", "Morpion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);			
		if(option == JOptionPane.OK_OPTION){
			lancement();
		}
		else 
			System.exit(0);
	}

	//PopUp lorsque Egalite
		public void popUpEgalite() {
			int option = JOptionPane.showConfirmDialog(null,"Égalité.\nVoulez-vous rejouer ?", "Morpion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);			
			if(option == JOptionPane.OK_OPTION){
				lancement();
			}
			else 
				System.exit(0);	
		}
	
	//PopUp qui annonce qui commence
		public void popUpQuiCommence() {
			JOptionPane.showMessageDialog(null,"C'est "+joueurX.getNom()+" qui commence.", "Morpion", JOptionPane.INFORMATION_MESSAGE );
		}
	
	//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500); // Taille 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 5, 2, 2));

		frame.getContentPane().add(btn1);
		btn1.addActionListener(actionL);

		frame.getContentPane().add(btn2);
		btn2.addActionListener(actionL);

		frame.getContentPane().add(btn3);
		btn3.addActionListener(actionL);

		frame.getContentPane().add(Rejouer);
		Rejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lancement();
			}
		});

		frame.getContentPane().add(Quitter);
		Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(btn4);
		btn4.addActionListener(actionL);
		
		frame.getContentPane().add(btn5);
		btn5.addActionListener(actionL);
		
		frame.getContentPane().add(btn6);
		btn6.addActionListener(actionL);
		
		txtJoueurX = new JTextField();
		txtJoueurX.setHorizontalAlignment(SwingConstants.CENTER);
		txtJoueurX.setText("Joueur X");
		frame.getContentPane().add(txtJoueurX);
		txtJoueurX.setColumns(10);
		
		txtJoueurO = new JTextField();
		txtJoueurO.setHorizontalAlignment(SwingConstants.CENTER);
		txtJoueurO.setText("Joueur O");
		frame.getContentPane().add(txtJoueurO);
		txtJoueurO.setColumns(10);
		
		frame.getContentPane().add(btn7);
		btn7.addActionListener(actionL);
		
		frame.getContentPane().add(btn8);
		btn8.addActionListener(actionL);
		
		frame.getContentPane().add(btn9);
		btn9.addActionListener(actionL);
		
		txtScoreX = new JTextField();
		txtScoreX.setHorizontalAlignment(SwingConstants.CENTER);
		txtScoreX.setText("0");
		frame.getContentPane().add(txtScoreX);
		txtScoreX.setColumns(10);
		
		txtScoreO = new JTextField();
		txtScoreO.setHorizontalAlignment(SwingConstants.CENTER);
		txtScoreO.setText("0");
		frame.getContentPane().add(txtScoreO);
		txtScoreO.setColumns(10);
	}
	
	//Permet d'appeler la fonction appuiBouton à chaque appui
	ActionListener actionL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			appuiBouton((JButton)e.getSource());
		}
	};


}
