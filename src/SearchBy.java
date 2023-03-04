import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

//class to shorten searchByIdDialog and searchBySurnameDialog as both classes are similar
public abstract class SearchBy extends JDialog  implements ActionListener {
	EmployeeDetails employeeDetails;
	JButton search, cancel;
	JTextField searchField;
	
	

	protected Container searchPane() {
		JPanel searchPanel = new JPanel(new GridLayout(3,1));
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel searchLabel;

		searchPanel.add(new JLabel("Search by ID"));
		searchPanel.add(new JLabel("Search by Surname"));

	
		textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		textPanel.add(searchLabel = new JLabel("Enter ID:"));
		textPanel.add(searchLabel = new JLabel("Enter Surname:"));
		searchLabel.setFont(this.employeeDetails.font1);
		textPanel.add(searchField = new JTextField(20));
		searchField.setFont(this.employeeDetails.font1);
		searchField.setDocument(new JTextFieldLimit(20));

		buttonPanel.add(search = new JButton("Search"));
		search.addActionListener(this);
		search.requestFocus();
		
		buttonPanel.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);
		
		searchPanel.add(textPanel);
		searchPanel.add(buttonPanel);

		return searchPanel;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// if option search, search for Employee
		if(e.getSource() == search){
			this.employeeDetails.searchBySurnameField.setText(searchField.getText());
			this.employeeDetails.searchByIdField.setText(searchField.getText());
			// search Employee by surname
			this.employeeDetails.searchEmployeeBySurname();
			this.employeeDetails.searchEmployeeById();
			dispose();// dispose dialog
		}// end if
		// else dispose dialog
		else if(e.getSource() == cancel)
			dispose();// dispose dialog
	}// end actionPerformed

}
