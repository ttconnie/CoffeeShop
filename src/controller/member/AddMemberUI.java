package controller.member;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField username;
	private JTextField mobile;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(81, 24, 481, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		name = new JTextField();
		name.setBounds(116, 167, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(116, 266, 96, 21);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("名字");
		lblNewLabel.setBounds(60, 166, 46, 21);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(60, 265, 46, 21);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.setBounds(194, 331, 107, 38);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
String Username=username.getText();
				
				if(new MemberServiceImpl().isUsernameBeenUse(Username))
				{
					AddMemberErrorUI addmembererror=new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					String Mobile=mobile.getText();
					
					 if (Password.length() < 5 || !Password.matches(".*[a-zA-Z].*")) {
			                // Show error if password doesn't meet the criteria
			                JOptionPane.showMessageDialog(null, "密碼必需至少5個字,並且包含一個英文",
			                		"密碼錯誤", JOptionPane.ERROR_MESSAGE);
			            } else {
					
					Member member=new Member(Name,Username,Password,Address,Phone,Mobile);
					
					new MemberServiceImpl().addMember(member);
					
					AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
					addmembersuccess.setVisible(true);
					dispose();
				}
				}
			}
			
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("地址");
		lblNewLabel_1_1.setBounds(255, 168, 46, 21);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("電話");
		lblNewLabel_1_2.setBounds(255, 222, 46, 21);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_2);
		
		address = new JTextField();
		address.setBounds(311, 169, 96, 21);
		address.setColumns(10);
		panel.add(address);
		
		phone = new JTextField();
		phone.setBounds(311, 223, 96, 21);
		phone.setColumns(10);
		panel.add(phone);
		
		username = new JTextField();
		username.setBounds(116, 214, 96, 21);
		username.setColumns(10);
		panel.add(username);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setBounds(60, 213, 46, 21);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("會員註冊系統");
		lblNewLabel_3.setBounds(167, 91, 165, 38);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 25));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("手機");
		lblNewLabel_1_2_1.setBounds(255, 265, 46, 21);
		lblNewLabel_1_2_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_2_1);
		
		mobile = new JTextField();
		mobile.setBounds(311, 266, 96, 21);
		mobile.setColumns(10);
		panel.add(mobile);
		
		JLabel lblNewLabel_4 = new JLabel("i COFFEE");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(177, 29, 155, 52);
		panel.add(lblNewLabel_4);
	}
}
