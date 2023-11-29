package guess_number;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guess_number extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtarea;
	static int randomNumber = (int)(Math.random()*10);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guess_number frame = new guess_number();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guess_number() {
		setTitle("Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 292);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 224, 237));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(75, 188, 84, 43);
		lblNewLabel.setBackground(new Color(58, 58, 58));
		contentPane.add(lblNewLabel);
		
		txtarea = new JTextField();
		txtarea.setForeground(new Color(0, 0, 0));
		txtarea.setBounds(31, 21, 183, 70);
		contentPane.add(txtarea);
		txtarea.setColumns(10);
		
		JButton btn = new JButton("guess");
		btn.setForeground(new Color(64, 0, 64));
		btn.setBounds(61, 111, 110, 37);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtarea.getText();
				int x=0;
				try {
				x = Integer.parseInt(text);
			}
				catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(null,"ERROR","error",JOptionPane.ERROR_MESSAGE);
				}
				
				if(x > randomNumber) {
					lblNewLabel.setText("High");
				}
				else if(x < randomNumber) {
					lblNewLabel.setText("Low");
				}
				else if(x == randomNumber) {
					lblNewLabel.setText("Correct!");
					txtarea.setText("");
					randomNumber = (int)(Math.random()*10); 
				}
			}
		});
		contentPane.add(btn);
	}
	}
