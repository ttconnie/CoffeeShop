package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import service.impl.PorderServiceImpl;
import util.Tool;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PorderManagerUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField acoffee;
    private JTextField mcoffee;
    private JTextField ccoffee;
    private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
    private JTextField updateId;
    private JTextField deleteId;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PorderManagerUI frame = new PorderManagerUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PorderManagerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 767, 497);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(242, 121, 0));
        panel.setBounds(50, 100, 611, 159);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 47, 565, 102);
        panel.add(scrollPane_1);

        JTextArea output = new JTextArea();
        scrollPane_1.setViewportView(output);

        JButton btnNewButton_1 = new JButton("查詢");
        btnNewButton_1.setBackground(new Color(255, 255, 0));
        btnNewButton_1.setBounds(20, 14, 85, 23);
        btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                output.setText(porderserviceimpl.AllPorder());
            }
        });
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("列印");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
	                String combinedText = output.getText() + "\n" + output.getText();
	                output.setText(combinedText);  
	                output.print();  
	            } catch (PrinterException ex) {
	                System.out.println(ex.getMessage());
	            }
        	}
        });
        btnNewButton_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        btnNewButton_1_1.setBackground(Color.YELLOW);
        btnNewButton_1_1.setBounds(115, 14, 85, 23);
        panel.add(btnNewButton_1_1);
        
                JButton btnNewButton = new JButton("回訂單主頁");
                btnNewButton.setBounds(463, 14, 122, 26);
                panel.add(btnNewButton);
                btnNewButton.setBackground(new Color(255, 255, 0));
                btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
                
                        btnNewButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                Tool.gotoPorderMain();
                                dispose();
                            }
                        });

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 128));
        panel_3.setBounds(29, 10, 656, 450);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 168, 81));
        panel_4.setBounds(20, 10, 610, 72);
        panel_3.add(panel_4);
        panel_4.setLayout(null);

        JLabel Times = new JLabel("New label");
        Times.setFont(new Font("新細明體", Font.PLAIN, 12));
        Times.setBounds(492, 41, 108, 21);
        panel_4.add(Times);

        
        updateDateTime(Times);
        Timer timer = new Timer(1000, e -> updateDateTime(Times));
        
        JLabel lblNewLabel_4 = new JLabel("i COFFEE");
        lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
        lblNewLabel_4.setBounds(230, 10, 155, 52);
        panel_4.add(lblNewLabel_4);
        timer.start();

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(428, 262, 202, 123);
        panel_3.add(panel_2);
        panel_2.setBackground(new Color(170, 85, 0));
        panel_2.setLayout(null);

        JLabel lblId = new JLabel("訂單編號");
        lblId.setFont(new Font("新細明體", Font.BOLD, 16));
        lblId.setBounds(20, 28, 75, 43);
        panel_2.add(lblId);

        deleteId = new JTextField();
        deleteId.setBounds(96, 40, 96, 21);
        panel_2.add(deleteId);
        deleteId.setColumns(10);

        JButton btnNewButton_1_2 = new JButton("刪除");
        btnNewButton_1_2.setBackground(new Color(255, 255, 0));
        btnNewButton_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
        btnNewButton_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Id = Integer.parseInt(deleteId.getText());
                porderserviceimpl.deletePorderById(Id);
            }
        });
        btnNewButton_1_2.setBounds(56, 90, 96, 23);
        panel_2.add(btnNewButton_1_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(20, 262, 399, 172);
        panel_3.add(panel_1);
        panel_1.setBackground(new Color(170, 85, 0));
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("美式咖啡");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
        lblNewLabel.setBounds(25, 64, 78, 36);
        panel_1.add(lblNewLabel);

        JLabel lblMc = new JLabel("摩卡");
        lblMc.setFont(new Font("新細明體", Font.BOLD, 16));
        lblMc.setBounds(35, 112, 57, 27);
        panel_1.add(lblMc);

        JLabel lblCc = new JLabel("卡布奇諾");
        lblCc.setFont(new Font("新細明體", Font.BOLD, 16));
        lblCc.setBounds(208, 64, 85, 36);
        panel_1.add(lblCc);

        acoffee = new JTextField();
        acoffee.setBounds(102, 73, 96, 21);
        panel_1.add(acoffee);
        acoffee.setColumns(10);

        mcoffee = new JTextField();
        mcoffee.setBounds(102, 116, 96, 21);
        panel_1.add(mcoffee);
        mcoffee.setColumns(10);

        ccoffee = new JTextField();
        ccoffee.setBounds(282, 73, 96, 21);
        panel_1.add(ccoffee);
        ccoffee.setColumns(10);

        JLabel lblId_1 = new JLabel("訂單編號");
        lblId_1.setFont(new Font("新細明體", Font.BOLD, 16));
        lblId_1.setBounds(153, 16, 78, 36);
        panel_1.add(lblId_1);

        updateId = new JTextField();
        updateId.setBounds(241, 25, 96, 21);
        panel_1.add(updateId);
        updateId.setColumns(10);

        JButton modify = new JButton("修改");
        modify.setBackground(new Color(255, 255, 0));
        modify.setFont(new Font("新細明體", Font.PLAIN, 16));
        modify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Id = Integer.parseInt(updateId.getText());
                int Acoffee = Integer.parseInt(acoffee.getText());
                int Mcoffee = Integer.parseInt(mcoffee.getText());
                int Ccoffee = Integer.parseInt(ccoffee.getText());
                porderserviceimpl.updatePorder(Acoffee, Mcoffee, Ccoffee, Id);
            }
        });
        modify.setBounds(25, 24, 85, 23);
        panel_1.add(modify);
        
        JButton btnNewButton_2 = new JButton("離開");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        });
        btnNewButton_2.setBackground(new Color(255, 255, 0));
        btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 20));
        btnNewButton_2.setBounds(428, 391, 202, 43);
        panel_3.add(btnNewButton_2);
    }

    
    private void updateDateTime(JLabel label) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = sdf.format(new Date());
        label.setText(currentDateTime);
    }
}
