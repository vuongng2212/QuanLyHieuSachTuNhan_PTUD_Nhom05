package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class panelProduct extends JPanel {

	public JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public panelProduct() {
		setBounds(0,0,1534,1017);
//		setSize(1534,1017);
		setLayout(null);
		
		lblNewLabel = new JLabel("Đây là Trang Product");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(304, 97, 575, 407);
		add(lblNewLabel);
	}

}