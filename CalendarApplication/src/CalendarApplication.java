import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.Clock;
import java.util.*;

import javax.swing.JTable;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class CalendarApplication {
	
	//These are all the instance variables used in the program
	private JFrame frmCalendar;
	private JTable daysTable;
	private DefaultTableModel m_defTblModel = new DefaultTableModel();
	private int m_realMonth = -1;
	private int m_realYear = -1;
	private int m_realDay = -1;
	private int m_currentMonth = -1;
	private int m_currentYear = -1;
	private JLabel monthLabel = null;
	private JButton btnPrev = null;
	private JButton btnNext = null;
	private JComboBox<String> comboBox = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarApplication window = new CalendarApplication();
					window.frmCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalendarApplication() {
		
		//This is the constructor which constructs the calendar and sets the values for the year, month, and day
		GregorianCalendar cal = new GregorianCalendar();
		m_realDay = cal.get(GregorianCalendar.DAY_OF_WEEK);
		m_realMonth = cal.get(GregorianCalendar.MONTH);
		m_realYear = cal.get(GregorianCalendar.YEAR);
		m_currentMonth = m_realMonth;
		m_currentYear = m_realYear;
		
		initialize();	//This method is called to start the program (open up and run the calendar)
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalendar = new JFrame();		//Main frame with all the components (panels, buttons, tables, etc.)
		frmCalendar.setResizable(false);
		frmCalendar.setTitle("Calendar Application");
		frmCalendar.setBounds(100, 100, 601, 362);
		frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalendar.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();	//Panel to lay all components on
		panel.setBounds(0, 0, 596, 335);
		frmCalendar.getContentPane().add(panel);
		panel.setLayout(null);
		
		monthLabel = new JLabel("New label");	//Label to display the month
		monthLabel.setBounds(121, 22, 72, 25);
		monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(monthLabel);
		
		btnPrev = new JButton("Previous");		//Button to navigate to the next month in the calendar
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (m_currentMonth == 0) {
					m_currentMonth = 11;
					m_currentYear -=1;
				}
				else {
					m_currentMonth -= 1;
				}
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		btnPrev.setBounds(22, 22, 89, 25);
		panel.add(btnPrev);
		
		btnNext = new JButton("Next");		//Button to navigate to the previous month in the calendar
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (m_currentMonth == 11) {
					m_currentMonth = 0;
					m_currentYear +=1;
				}
				else {
					m_currentMonth +=1;
				}
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		btnNext.setBounds(203, 22, 89, 25);
		panel.add(btnNext);
		
		JLabel lblChangeYear = new JLabel("Change Year:");		//Label that reads "change year" next to the comboBox (drop down menu)
		lblChangeYear.setBounds(349, 22, 78, 25);
		lblChangeYear.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChangeYear);
		
		comboBox = new JComboBox<String>();		//Drop down menu to select year

		for (int i = m_realYear-100; i <= m_realYear +100; i++) 	//This for loop populates the drop down menu with 
		{															//a 100 years past & a 100 years forward
			comboBox.addItem("" + i);
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				m_currentYear = Integer.parseInt(comboBox.getSelectedItem().toString());
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		
		comboBox.setBounds(437, 23, 138, 23);
		panel.add(comboBox);
		
		
		JScrollPane scrollPane = new JScrollPane();		//Pane that allows the user to scroll up and down which
		scrollPane.setBounds(22, 65, 553, 250);			//will be used to lay the table in for the days
		panel.add(scrollPane);
		
		daysTable = new JTable(m_defTblModel);		//Table containing all the days of the calendar
		daysTable.setSurrendersFocusOnKeystroke(true);
		daysTable.setCellSelectionEnabled(true);
		daysTable.setColumnSelectionAllowed(true);
		daysTable.setRowSelectionAllowed(true);
		daysTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(daysTable);
		daysTable.setBackground(Color.WHITE);
		daysTable.setEnabled(false);		//This is the method that makes the buttons un-clickable.
		daysTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		for (int i = 0; i < headers.length; i++) {	//This for loop takes the weekdays from the string array
			m_defTblModel.addColumn(headers[i]);	//and sets each day as the header of the column.
		}
		
		daysTable.setRowHeight(38);
		m_defTblModel.setColumnCount(7);
		m_defTblModel.setRowCount(6);
		
		daysTable.getParent().setBackground(daysTable.getBackground());		
		refreshCalendar(m_realMonth, m_realYear);
	}
	
	//The next method is used to refresh the calendar with the current day and time
	//whenever the calendar is opened up or the year from the comboBox is changed.
	public void refreshCalendar(int monthIndex, int year) {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		int numberOfDays = -1;
		int startOfMonth = -1;
		
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		
		if ((monthIndex == 0) && (year <= m_realYear - 100)) {
			btnPrev.setEnabled(false);
		}
		
		if ((monthIndex == 11) && (year >= m_realYear + 100)) {
			btnNext.setEnabled(false);
		}
		
		monthLabel.setText(months[monthIndex]);
		comboBox.setSelectedItem(String.valueOf(year));
		
		GregorianCalendar cal = new GregorianCalendar(year, monthIndex, 1);		//This builds a clendar using the given year and date variables given to the method
		numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				m_defTblModel.setValueAt(null, i, j);
			}
		}
		
		for (int i = 1; i <= numberOfDays; i++) {
			int row = new Integer((i+startOfMonth-2)/7);
			int column = (i+startOfMonth-2)%7;
			m_defTblModel.setValueAt(i, row, column);
		}
	}
}
