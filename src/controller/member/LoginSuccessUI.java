package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.AddPorderUI;
import model.Member;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LoginSuccessUI extends JFrame {
	private static Member member=(Member)Tool.read("member.txt");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private final JPanel panel = new JPanel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(38, 24, 357, 292);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("進入商場購物");
		btnNewButton.setBounds(115, 179, 137, 42);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("i COFFEE");
		lblNewLabel_4.setBounds(115, 36, 155, 52);
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		panel_1.add(lblNewLabel_4);
		
		JLabel showMember = new JLabel("New label");
		showMember.setBounds(115, 98, 156, 59);
		panel_1.add(showMember);
		showMember.setFont(new Font("新細明體", Font.BOLD, 30));
		
		showMember.setText("歡迎光臨");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporder=new AddPorderUI();
				addporder.setVisible(true);
				dispose();
			}
		});
	}

}
