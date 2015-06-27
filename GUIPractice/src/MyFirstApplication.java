import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;


public class MyFirstApplication {

	private JFrame frmFirstGui;
	private JTextField nameField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JLabel YearUpLabel;
	private JButton buttonOne;
	private boolean hasBeenClicked = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstApplication window = new MyFirstApplication();
					window.frmFirstGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFirstApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFirstGui = new JFrame();
		frmFirstGui.setTitle("First GUI");
		frmFirstGui.setBounds(100, 100, 439, 322);
		frmFirstGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFirstGui.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("My name is:");
		nameLabel.setLabelFor(frmFirstGui);
		nameLabel.setBackground(Color.RED);
		nameLabel.setForeground(Color.BLUE);
		nameLabel.setFont(new Font("Teen Light", Font.BOLD, 18));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(40, 35, 130, 40);
		frmFirstGui.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setToolTipText("");
		nameField.setFont(new Font("Byington", Font.PLAIN, 13));
		nameField.setBounds(194, 35, 169, 35);
		frmFirstGui.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		ageLabel = new JLabel("I am:");
		ageLabel.setFont(new Font("Teen Light", Font.BOLD, 18));
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLUE);
		ageLabel.setBounds(40, 81, 130, 40);
		frmFirstGui.getContentPane().add(ageLabel);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Byington", Font.PLAIN, 13));
		ageField.setBounds(194, 86, 169, 35);
		frmFirstGui.getContentPane().add(ageField);
		ageField.setColumns(10);
		
		YearUpLabel = new JLabel("I am a student at Year Up!");
		YearUpLabel.setForeground(Color.BLUE);
		YearUpLabel.setBackground(new Color(240, 240, 240));
		YearUpLabel.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 14));
		YearUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		YearUpLabel.setBounds(77, 156, 265, 21);
		frmFirstGui.getContentPane().add(YearUpLabel);
		
		buttonOne = new JButton("Who are you?");
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if (!hasBeenClicked)
				{
					nameField.setText("Taha Sabra");
					ageField.setText("24 years old");
					buttonOne.setText("Clear Me!");
					hasBeenClicked = true;
				}
				else
				{
					nameField.setText("");
					ageField.setText("");
					buttonOne.setText("Who are you?");
					hasBeenClicked = false;
				}
			}
		});
		

		
		buttonOne.setForeground(Color.RED);
		buttonOne.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buttonOne.setBounds(97, 203, 223, 35);
		frmFirstGui.getContentPane().add(buttonOne);
		frmFirstGui.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmFirstGui.getContentPane(), nameLabel, nameField, ageLabel, ageField, YearUpLabel, buttonOne}));
	}
}
