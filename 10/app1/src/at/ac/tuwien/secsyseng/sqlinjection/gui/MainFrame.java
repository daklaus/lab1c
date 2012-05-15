package at.ac.tuwien.secsyseng.sqlinjection.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import at.ac.tuwien.secsyseng.sqlinjection.exception.PasswordException;
import at.ac.tuwien.secsyseng.sqlinjection.service.Var1Service;

import net.miginfocom.swing.MigLayout;

public class MainFrame implements ActionListener {

	private JFrame frame;
	private JPanel var1;
	private JPanel var2;
	private JPanel var3;
	private JLabel descLbl;
	private JLabel secLbl;
	private JLabel userLbl;
	private JLabel passLbl;
	private JTextField userTf;
	private JPasswordField passTf;
	private JButton loginBtn;
	private JTextArea var1DataResponse;
	private JScrollPane var1DataResponseScPane;
	private JCheckBox secCheck;
	private Var1Service var1service;

	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("app1 - SQL-Injection");
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane app1Pane = new JTabbedPane();
		frame.getContentPane().add(app1Pane);

		var1 = new JPanel(new MigLayout("", "[][grow][][grow][]",
				"[][][][grow]"));
		var2 = new JPanel(new MigLayout("", "[]", "[]"));
		var3 = new JPanel(new MigLayout("", "[]", "[]"));

		app1Pane.addTab("Variante 1: Login-Fail", var1);
		app1Pane.addTab("Variante 2: ...", var2);
		app1Pane.addTab("Variante 2: ...", var3);

		descLbl = new JLabel(
				"Description: Login to display data. Default: User=wong Password=dong");
		secLbl = new JLabel("Security (on): ");
		userLbl = new JLabel("User:");
		passLbl = new JLabel("Password:");
		secCheck = new JCheckBox();
		userTf = new JTextField();
		passTf = new JPasswordField();
		var1DataResponse = new JTextArea();
		var1DataResponseScPane = new JScrollPane(var1DataResponse);

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(this);
		loginBtn.setActionCommand("login");

		var1.add(descLbl, "cell 0 0 5 1");
		var1.add(secLbl, "cell 0 1 5 1");
		var1.add(secCheck, "cell 0 1 5 1");
		var1.add(userLbl, "cell 0 2");
		var1.add(userTf, "cell 1 2,growx");
		var1.add(passLbl, "cell 2 2");
		var1.add(passTf, "cell 3 2,growx");
		var1.add(loginBtn, "cell 4 2");
		var1.add(var1DataResponseScPane, "cell 0 3 5 1,grow");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("login")) {
			var1service = new Var1Service();
			ResultSet rs = null;
			boolean nodata = true;

			try {
				rs = var1service.transferVar1Response(userTf.getText(),
						passTf.getText(), secCheck.isSelected());
			} catch (SQLException e2) {
				JOptionPane.showConfirmDialog(null, e2.getMessage(), "Error",
						JOptionPane.CLOSED_OPTION);
			} catch (PasswordException e2) {
				JOptionPane.showConfirmDialog(null, e2.getMessage(), "Error",
						JOptionPane.CLOSED_OPTION);
			}

			try {
				if (rs != null) {
					while (rs.next()) {
						nodata = false;
						var1DataResponse.append(rs.getInt("id") + "|"
								+ rs.getString("product") + "|"
								+ rs.getString("location") + "|"
								+ rs.getDouble("price") + "\n");
					}
					var1DataResponse.append("\n");

					if (nodata)
						JOptionPane.showConfirmDialog(null, "No data found",
								"Info", JOptionPane.CLOSED_OPTION);
				}
			} catch (SQLException e1) {
				JOptionPane.showConfirmDialog(null, e1.getMessage(), "Error",
						JOptionPane.CLOSED_OPTION);
			}
		}
	}
}