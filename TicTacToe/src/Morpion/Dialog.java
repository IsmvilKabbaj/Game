package Morpion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Dialog {

	private JFrame frame;
	
	private JTextField nomJoueur1;
	private JTextField txtEntrerLeNom_1;
	private JTextField nomJoueur2;
	private JTextField txtEntrerLeNom;
	private JTextField txtAppuyerSurOk;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog window = new Dialog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});}

	//Create the application.
	public Dialog() {
		initialize();	
	}

	//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 2, 0, 0));
		
		txtEntrerLeNom = new JTextField();
		txtEntrerLeNom.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtEntrerLeNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntrerLeNom.setText("Entrez le nom du Joueur X : ");
		frame.getContentPane().add(txtEntrerLeNom);
		txtEntrerLeNom.setColumns(10);
		
		nomJoueur1 = new JTextField();
		nomJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(nomJoueur1);
		nomJoueur1.setColumns(10);
		
		txtEntrerLeNom_1 = new JTextField();
		txtEntrerLeNom_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtEntrerLeNom_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntrerLeNom_1.setText("Entrez le nom du Joueur O : ");
		frame.getContentPane().add(txtEntrerLeNom_1);
		txtEntrerLeNom_1.setColumns(10);
		
		nomJoueur2 = new JTextField();
		nomJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(nomJoueur2);
		nomJoueur2.setColumns(10);
		
		txtAppuyerSurOk = new JTextField();
		txtAppuyerSurOk.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		txtAppuyerSurOk.setHorizontalAlignment(SwingConstants.CENTER);
		txtAppuyerSurOk.setText("Appuyez sur OK pour confirmer : ");
		frame.getContentPane().add(txtAppuyerSurOk);
		txtAppuyerSurOk.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur joueurX = new Joueur(nomJoueur1.getText(), 0, 0);
				Joueur joueurO = new Joueur(nomJoueur2.getText(), 0, 0);
				
				
				frame.setVisible(false); // Desactive la visibilité de la fenetre
				Morpion window2 = new Morpion(joueurX, joueurO); // Lance la fenetre de JEU Morpion

			}
		});
		
		frame.getContentPane().add(btnOk);
	}
	
}
