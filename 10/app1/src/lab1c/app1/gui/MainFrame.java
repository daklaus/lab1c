package lab1c.app1.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane app1Pane = new JTabbedPane();
		frame.getContentPane().add(app1Pane);
		
		JPanel var1 = new JPanel(new MigLayout("", "[][grow][][grow][]", "[][][grow]"));
		JPanel var2 = new JPanel(new MigLayout("", "[]", "[]"));
		JPanel var3 = new JPanel(new MigLayout("", "[]", "[]"));
		
		app1Pane.addTab("Variante 1: Login-Fail", var1);
		app1Pane.addTab("Variante 2: ...", var2);
		app1Pane.addTab("Variante 2: ...", var3);
		
		JLabel descLbl = new JLabel("Description: Login to display data. Default: User=Wong Password=Dong");		
		JLabel userLbl = new JLabel("User:");
		JLabel passLbl = new JLabel("Password:");
		JTextField userTf = new JTextField();
		JTextField passTf = new JTextField();
		JButton loginBtn = new JButton("Login");
		JTextPane var1DataResponse = new JTextPane();
		
		var1.add(descLbl, "cell 0 0 5 1");
		var1.add(userLbl, "cell 0 1");
		var1.add(userTf, "cell 1 1,growx");
		var1.add(passLbl, "cell 2 1");
		var1.add(passTf, "cell 3 1,growx");
		var1.add(loginBtn, "cell 4 1");
		var1.add(var1DataResponse, "cell 0 2 5 1,grow");
	}
}