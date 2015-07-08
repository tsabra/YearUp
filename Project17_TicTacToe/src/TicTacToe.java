import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;


public class TicTacToe {

	private JFrame frmTicTacToe;
	private String m_previousMove = null;
	private JButton[][] m_allButtons = new JButton[3][3];
	private static String s_x = "X";
	private static String s_o = "O";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setResizable(false);
		frmTicTacToe.setForeground(Color.LIGHT_GRAY);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 356, 349);
		frmTicTacToe.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("");
		btn1.setBounds(0, 0, 110, 100);
		frmTicTacToe.getContentPane().add(btn1);
		m_allButtons[0][0] = btn1;
		
		JButton btn2 = new JButton("");
		btn2.setBounds(120, 0, 110, 100);
		frmTicTacToe.getContentPane().add(btn2);
		m_allButtons[0][1] = btn2;
		
		JButton btn3 = new JButton("");
		btn3.setBounds(240, 0, 110, 100);
		frmTicTacToe.getContentPane().add(btn3);
		m_allButtons[0][2] = btn3;
				
		JButton btn4 = new JButton("");
		btn4.setBounds(0, 110, 110, 100);
		frmTicTacToe.getContentPane().add(btn4);
		m_allButtons[1][0] = btn4;
		
		JButton btn5 = new JButton("");
		btn5.setBounds(120, 110, 110, 100);
		frmTicTacToe.getContentPane().add(btn5);
		m_allButtons[1][1] = btn5;
		
		JButton btn6 = new JButton("");
		btn6.setBounds(240, 110, 110, 100);
		frmTicTacToe.getContentPane().add(btn6);
		m_allButtons[1][2] = btn6;
		
		JButton btn7 = new JButton("");
		btn7.setBounds(0, 221, 110, 100);
		frmTicTacToe.getContentPane().add(btn7);
		m_allButtons[2][0] = btn7;
		
		JButton btn8 = new JButton("");
		btn8.setBounds(120, 221, 110, 100);
		frmTicTacToe.getContentPane().add(btn8);
		m_allButtons[2][1] = btn8;
		
		JButton btn9 = new JButton("");
		btn9.setBounds(240, 221, 110, 100);
		frmTicTacToe.getContentPane().add(btn9);
		m_allButtons[2][2] = btn9;
		frmTicTacToe.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmTicTacToe.getContentPane(), btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9}));
		
		AddAllEventHandlers();
	}	
	
	private void ChangeButtonText(JButton button)
	{
		if (m_previousMove != null)
		{
			if (m_previousMove.equals(s_o))
			{
				button.setText(s_x);
				button.setEnabled(false);
				m_previousMove = s_x;
			}
			else if (m_previousMove.equals(s_x))
			{
				button.setText(s_o);
				button.setEnabled(false);
				m_previousMove = s_o;
			}
		}
		else
		{
			button.setText(s_x);
			button.setEnabled(false);
			m_previousMove = s_x;
		}
	}
	
	private void DisableAllButtons()
	{
		if (m_allButtons != null)
		{
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					m_allButtons[i][j].setEnabled(false);
				}
			}
		}
	}
	
	private void checkGameWinner()
	{
		if (m_allButtons != null)
		{
			for (int i = 0; i < 3; i++)
			{
				String One = m_allButtons[0][i].getText();
				String Two = m_allButtons[1][i].getText();
				String Three = m_allButtons[2][i].getText();
				
				boolean emptyColumns = One.isEmpty() || Two.isEmpty() || Three.isEmpty();
				
				if(! emptyColumns)
				{
					boolean same = (One == Two) && (Two == Three);
					
					if (same)
					{
						m_allButtons[0][i].setBackground(Color.WHITE);
						m_allButtons[1][i].setBackground(Color.WHITE);
						m_allButtons[2][i].setBackground(Color.WHITE);
						DisableAllButtons();
						JOptionPane.showMessageDialog(frmTicTacToe, "We have a winner!");
					}
				}
			}
			
			for (int i = 0; i < 3; i++)
			{
				String four = m_allButtons[i][0].getText();
				String five = m_allButtons[i][1].getText();
				String six = m_allButtons[i][2].getText();
				
				boolean emptyRows = four.isEmpty() || five.isEmpty() || six.isEmpty();
				
				if(! emptyRows)
				{
					boolean same = (four == five) && (five == six);
					
					if (same)
					{
						m_allButtons[i][0].setBackground(Color.WHITE);
						m_allButtons[i][1].setBackground(Color.WHITE);
						m_allButtons[i][2].setBackground(Color.WHITE);
						DisableAllButtons();
						JOptionPane.showMessageDialog(frmTicTacToe, "We have a winner!");
					}
				}
			}
			
			for (int i = 0; i < 3; i++)
			{
				String seven = m_allButtons[0][0].getText();
				String eight = m_allButtons[1][1].getText();
				String nine = m_allButtons[2][2].getText();
				
				boolean diagonal = seven.isEmpty() || eight.isEmpty() || nine.isEmpty();
				
				if (! diagonal)
				{
					boolean same = (seven == eight) && (eight == nine);
					
					if (same)
					{
						m_allButtons[0][0].setBackground(Color.WHITE);
						m_allButtons[1][1].setBackground(Color.WHITE);
						m_allButtons[2][2].setBackground(Color.WHITE);
						DisableAllButtons();
						JOptionPane.showMessageDialog(frmTicTacToe, "We have a winner!");
					}
				}
			}
		}
	}
	
	private void AddAllEventHandlers()
	{
		if (m_allButtons != null)
		{
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					JButton currentButton = m_allButtons[i][j];
					currentButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							ChangeButtonText(currentButton);
							checkGameWinner();
						}
					});
				}
			}
		}
	}
}
