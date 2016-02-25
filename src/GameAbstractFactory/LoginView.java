package interfaceMenus;
//Code adpted from http://www.edu4java.com/en/swing/swing3.html

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {

	public static void main(String[] args) {
		JFrame frame = new JFrame("CardMaster 2020");
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(frame);
		frame.setVisible(true);
	}

	private static void placeComponents(JFrame frame) {
		frame.setLayout(null);

		//Username
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 20, 80, 25);
		frame.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 160, 25);
		frame.add(userText);

		//Password
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 60, 80, 25);
		frame.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 60, 160, 25);
		frame.add(passwordText);

		//Login Button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(180, 100, 80, 25);
		frame.add(loginButton);

		//Registry button
		JLabel registerLabel1 = new JLabel("New to CardMaster?");
		JLabel registerLabel2 = new JLabel("  Proceed with Registry");
		registerLabel1.setBounds(10, 160, 300, 25);
		registerLabel2.setBounds(10, 180, 300, 25);
		frame.add(registerLabel1);
		frame.add(registerLabel2);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(180, 230, 80, 25);
		frame.add(registerButton);

		//TODO TERRIBLE IMPLEMENTATION - THIS NEEDS ATTENTION
		JLabel informationLabel1 = new JLabel("This is a multi card game prototype");
		JLabel informationLabel2 = new JLabel( "Feel free to try the game without registry");
		JLabel informationLabel3 = new JLabel("your progress will not be saved");
		informationLabel1.setBounds(330, 20, 250, 25);
		informationLabel2.setBounds(330, 40, 300, 25);
		informationLabel3.setBounds(330, 60, 250, 25);
		frame.add(informationLabel1);
		frame.add(informationLabel2);
		frame.add(informationLabel3);
		
		JButton unregistedUser = new JButton("Log as Guest");
		unregistedUser.setBounds(450, 100, 130, 25);
		frame.add(unregistedUser);
		
		ActionListener loginButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JOptionPane.showMessageDialog(source, source.getText()
						+ " button has been pressed");
			}
		};
		loginButton.addActionListener(loginButtonListener);
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((Component) e.getSource(),
						"button has been pressed");
			}
		});
	}

}