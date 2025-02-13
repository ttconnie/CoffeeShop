package controller.porder;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField acoffee;
	private JTextField mcoffee;
	private JTextField ccoffee;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblacoffee = new JLabel("美式咖啡");
		lblacoffee.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblacoffee.setBounds(100, 109, 74, 23);
		contentPane.add(lblacoffee);
		
		JLabel lblmcoffee = new JLabel("摩卡");
		lblmcoffee.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblmcoffee.setBounds(117, 152, 57, 23);
		contentPane.add(lblmcoffee);
		
		JLabel lblccoffee = new JLabel("卡布奇諾");
		lblccoffee.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblccoffee.setBounds(100, 198, 74, 23);
		contentPane.add(lblccoffee);
		
		acoffee = new JTextField();
		acoffee.setColumns(10);
		acoffee.setBounds(186, 111, 96, 21);
		contentPane.add(acoffee);
		
		mcoffee = new JTextField();
		mcoffee.setColumns(10);
		mcoffee.setBounds(184, 154, 96, 21);
		contentPane.add(mcoffee);
		
		ccoffee = new JTextField();
		ccoffee.setColumns(10);
		ccoffee.setBounds(186, 200, 96, 21);
		contentPane.add(ccoffee);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				int Acoffee=Integer.parseInt(acoffee.getText());
				int Mcoffee=Integer.parseInt(mcoffee.getText());
				int Ccoffee=Integer.parseInt(ccoffee.getText());
				
				Porder p=new Porder(Ccoffee, Name,Acoffee,Mcoffee,Ccoffee);
				  
				
				
				porderserviceimpl.addPorder(p);
			}
			
		});
		btnNewButton.setBounds(100, 247, 99, 36);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 191, 128));
		panel.setBounds(49, 10, 347, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增訂單");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblNewLabel.setBounds(178, 10, 107, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("i COFFEE");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(32, 10, 155, 52);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("回訂單主頁");
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(235, 247, 131, 36);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(29, 0, 386, 293);
		contentPane.add(panel_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
	}
}



