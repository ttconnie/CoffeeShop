package controller.member;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class AddMemberSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberSuccessUI frame = new AddMemberSuccessUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddMemberSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(59, 54, 419, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("重新登入");
		btnNewButton.setBounds(143, 197, 118, 23);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("歡迎加入會員");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 26));
		lblNewLabel_1.setBounds(123, 59, 182, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("註冊成功");
		lblNewLabel.setBounds(158, 135, 139, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
	}

}
