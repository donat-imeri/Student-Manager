import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class frmLoginAl extends JFrame {

	private JPanel contentPane;
	private JTextField txtPerdoruesi;
	private JPasswordField txtFjalekalimi;
	JLabel lblPError;
	JLabel lblFError;
	JCheckBox chBRememberMe;
	File rememberFile;
	int xx;
	int xy;
	ResourceBundle lang;
   public static int user;
   public static boolean open=false;
   static Locale currentLang = new Locale("AL");
	Connection conn=null;
	ResultSet res=null;
	PreparedStatement pst=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginAl frame = new frmLoginAl();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setSize(327,411);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public frmLoginAl() 
	{
		currentLang = frmLoginAl.currentLang;
		lang = ResourceBundle.getBundle("Language", currentLang);
		open=true;
		conn=DatabaseConnection.startConnection();
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 319, 386));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExit = new JLabel("");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setVerifyInputWhenFocusTarget(false);
		lblExit.setOpaque(false);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setBackground(Color.red);
				lblExit.setOpaque(true);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setBackground(Color.white);
				lblExit.setOpaque(false);
			}
		});
		
		JLabel lblMinimize = new JLabel("");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMinimize.setBackground(Color.white);
				lblMinimize.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMinimize.setBackground(null);
				lblMinimize.setOpaque(false);

				}
		});
				
				
			
				JLabel lblIconFjalekalimi = new JLabel("");
		lblIconFjalekalimi.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/imgpass.png")));
		lblIconFjalekalimi.setBounds(41, 200, 30, 30);
		contentPane.add(lblIconFjalekalimi);
		
		JLabel lblIconPerdoruesi = new JLabel("");
		lblIconPerdoruesi.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/userimg2.png")));
		lblIconPerdoruesi.setBounds(41, 147, 30, 30);
		contentPane.add(lblIconPerdoruesi);
		
		lblMinimize.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/minimize.png")));
		lblMinimize.setBounds(256, 0, 35, 25);
		contentPane.add(lblMinimize);
		
		lblExit.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/images.png")));
		lblExit.setBounds(292, 0, 35, 25);
		contentPane.add(lblExit);
		
		JLabel lblPerdoruesi = new JLabel(lang.getString("Perdoruesi"));
		lblPerdoruesi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPerdoruesi.setForeground(Color.GRAY);
		lblPerdoruesi.setBounds(77, 161, 73, 14);
		contentPane.add(lblPerdoruesi);
		
		JLabel lblFjalekalimi = new JLabel(lang.getString("Fjalekalimi"));
		lblFjalekalimi.setForeground(Color.GRAY);
		lblFjalekalimi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFjalekalimi.setBounds(77, 215, 73, 14);
		
		//Labels per shfaqjen e gabimeve
		 lblPError = new JLabel("");
		lblPError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPError.setForeground(Color.RED);
		lblPError.setBounds(294, 165, 30, 14);
		contentPane.add(lblPError);
		
		 lblFError = new JLabel("");
		lblFError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFError.setForeground(Color.RED);
		lblFError.setBounds(294, 216, 30, 14);
		contentPane.add(lblFError);
		
		//Krijimi i text box per perdorues dhe fjalekalim
		txtPerdoruesi = new JTextField();
		txtPerdoruesi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtPerdoruesi.getText().isEmpty()) {
					lblPerdoruesi.setText(lang.getString("Perdoruesi"));
				}
			}
		});
		txtPerdoruesi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				lblPError.setText("");
				lblPerdoruesi.setText("");
			}
		});
		

		contentPane.add(lblFjalekalimi);
		txtPerdoruesi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPerdoruesi.setForeground(Color.WHITE);
		txtPerdoruesi.setBorder(null);
		txtPerdoruesi.setOpaque(false);
		txtPerdoruesi.setBounds(74, 159, 215, 20);
		contentPane.add(txtPerdoruesi);
		txtPerdoruesi.setColumns(10);
		
		txtFjalekalimi = new JPasswordField();
		txtFjalekalimi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFjalekalimi.getText().isEmpty())
				lblFjalekalimi.setText(lang.getString("Fjalekalimi"));
			}
		});
		txtFjalekalimi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblFError.setText("");
				lblFjalekalimi.setText("");
				if(e.getKeyCode()==e.VK_ENTER) {
					login();
				}
			}
		
		});
		txtFjalekalimi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFjalekalimi.setBorder(null);
		txtFjalekalimi.setOpaque(false);
		txtFjalekalimi.setForeground(Color.WHITE);
		txtFjalekalimi.setBounds(74, 213, 215, 20);
		contentPane.add(txtFjalekalimi);		
		
		
	
		
		
	    chBRememberMe = new JCheckBox("");
		chBRememberMe.setOpaque(false);
		chBRememberMe.setBounds(35, 260, 21, 18);
		contentPane.add(chBRememberMe);
		
		 rememberFile=new File("app.txt");
		if(rememberFile.exists()) {
			String[] remember=readFile(rememberFile);
			txtPerdoruesi.setText(remember[0]);
			txtFjalekalimi.setText(remember[1]);
			chBRememberMe.setSelected(true);
			lblPerdoruesi.setText("");
			lblFjalekalimi.setText("");
		}
		
		JButton btnLogIn = new JButton(lang.getString("Kyqu"));
		btnLogIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					login();
				}
			}
		});
		btnLogIn.setFocusPainted(false);
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogIn.setBackground(new Color(15, 32, 73));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnLogIn.setBackground(new Color(51, 153, 204));

			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogIn.setBackground(new Color(51, 153, 204));
		btnLogIn.setBorder(null);
		btnLogIn.setBounds(96, 315, 139, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setBounds(121, 49, 87, 80);
		contentPane.add(lblLoginIcon);
		ImageIcon logo=new ImageIcon(frmLoginAl.class.getResource("/image/logo.png"));
		Image logoImg=logo.getImage();
		logoImg=logoImg.getScaledInstance(lblLoginIcon.getWidth(),lblLoginIcon.getHeight(), Image.SCALE_SMOOTH);
		lblLoginIcon.setIcon(new ImageIcon(logoImg));		
		
		
		JLabel lblForgotPassword = new JLabel(lang.getString("FjalekalimiH"));
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//nese eshte numer ktheje ne integer sbon me shku drejperdrejt se nese fusim string ka errore
			  for(int i = 0; i<txtPerdoruesi.getText().length(); i++) {     
		            char perdoruesiChar= txtPerdoruesi.getText().charAt(i);
		            if (Character.isDigit(perdoruesiChar)) { 
						 user=Integer.parseInt(txtPerdoruesi.getText());
		            }
		        }			
			  
				boolean userFound=false;
				try {
					// per me kqyr a ka perdorues me qaso id qe kemi jep
					String sql="Select * from perdoruesit  where pid="+user+"";
					pst=conn.prepareStatement(sql);
					res=pst.executeQuery();
					while(res.next()) {
						//nese ska false
						if(res.getString("pid").equals("")) {
							userFound=false;
						}
						//nese po true
						else {
							userFound=true;
						}
					}
					pst.close();

				}
				catch(Exception e) {
				}
				
				if(!txtPerdoruesi.getText().equals("")&&userFound==true) {
				dispose();
				ResetPassword obj=new ResetPassword();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				}
				else if(!txtPerdoruesi.getText().equals("")&&userFound==false) {
					JOptionPane.showMessageDialog(null, lang.getString("PnV"));
				}
				
				else {
					JOptionPane.showMessageDialog(null,lang.getString("ShkruaniP") );
				}
				
			}
		});
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblForgotPassword.setBounds(186, 262, 125, 14);
		contentPane.add(lblForgotPassword);
		
		
		
		JLabel lblRememberMe = new JLabel(lang.getString("Remember"));
		lblRememberMe.setForeground(Color.WHITE);
		lblRememberMe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRememberMe.setBounds(62, 262, 88, 14);
		contentPane.add(lblRememberMe);
		
		JSeparator pSeperator = new JSeparator();
		pSeperator.setBounds(41, 177, 248, 2);
		contentPane.add(pSeperator);
				
		JSeparator fSeperator = new JSeparator();
		fSeperator.setBounds(41, 231, 248, 2);
		contentPane.add(fSeperator);
				
		JLabel lblLogin = new JLabel("");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		lblLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xx,y-xy);
			}
		});
		//Gjuha
		JLabel lblAlb = new JLabel("");
		lblAlb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				currentLang=new Locale("AL");
				lang = ResourceBundle.getBundle("Language", currentLang);
				btnLogIn.setText(lang.getString("Kyqu"));
				lblRememberMe.setText(lang.getString("Remember"));
				lblForgotPassword.setText(lang.getString("Perdoruesi"));
				lblForgotPassword.setText(lang.getString("FjalekalimiH"));
				if(txtPerdoruesi.getText().isEmpty()) {
					lblPerdoruesi.setText(lang.getString("Perdoruesi"));
				}
				if(txtFjalekalimi.getText().isEmpty()) {
					lblFjalekalimi.setText(lang.getString("Fjalekalimi"));
				}

			}
		});
		lblAlb.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/albanian.png")));
		lblAlb.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlb.setForeground(Color.WHITE);
		lblAlb.setBounds(21, 21, 20, 20);
		contentPane.add(lblAlb);
		//Gjuha
				JLabel lblEng = new JLabel("");
				lblEng.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/britain.png")));
				lblEng.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						currentLang=new Locale("EN");
						lang = ResourceBundle.getBundle("Language", currentLang);
						btnLogIn.setText(lang.getString("Kyqu"));
						if(txtPerdoruesi.getText().isEmpty()) {
							lblPerdoruesi.setText(lang.getString("Perdoruesi"));
						}
						 if(txtFjalekalimi.getText().isEmpty()) {
							lblFjalekalimi.setText(lang.getString("Fjalekalimi"));
						}
						lblRememberMe.setText(lang.getString("Remember"));
						lblForgotPassword.setText(lang.getString("Perdoruesi"));
						lblForgotPassword.setText(lang.getString("FjalekalimiH"));
					}
					});
				lblEng.setForeground(Color.WHITE);
				lblEng.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblEng.setBounds(41, 21, 20, 20);
				contentPane.add(lblEng);
		lblLogin.setIcon(new ImageIcon(frmLoginAl.class.getResource("/image/bfoto.jpg")));
		lblLogin.setBounds(0, 0, 327, 411);
		contentPane.add(lblLogin);
				

	}
	public String[] readFile(File f) {		
		Scanner input;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, lang.getString("PwN"),lang.getString("Gabim"),JOptionPane.ERROR_MESSAGE);	
			return null;
		}
		String[] remember=new String[2];
		for(int i=0;i<remember.length;i++) {
			remember[i]=input.nextLine();
		}
		input.close();
		return remember;
	}
	
	
	private void login() {	
		String perdoruesi=txtPerdoruesi.getText();
		String fjalekalimi=txtFjalekalimi.getText();
		String zbrazet="";
		if(chBRememberMe.isSelected()) {							
			writeFile(new File("app.txt"), perdoruesi, fjalekalimi);
		}
		else {
			if(rememberFile.exists()) {
				rememberFile.delete();
			}
		}
		if(perdoruesi.equals(zbrazet) && fjalekalimi.equals(zbrazet)) {
			lblPError.setText(String.valueOf("*"));
			lblFError.setText(String.valueOf("*"));
			txtPerdoruesi.requestFocus();
		}
					
		else if(perdoruesi.equals(zbrazet) && !fjalekalimi.equals(zbrazet)) {
			lblPError.setText(String.valueOf("*"));
			txtPerdoruesi.requestFocus();
		}
		
		else if(!perdoruesi.equals(zbrazet) && fjalekalimi.equals(zbrazet)) {
			lblFError.setText(String.valueOf("*"));				
			txtFjalekalimi.requestFocus();
		}
		else {
			Hashing h=new Hashing();
			
			try {				
				String queryLogin="select * from perdoruesit where pid='"+perdoruesi+"'";
				pst=conn.prepareStatement(queryLogin);
				res=pst.executeQuery();	
				if(res.next()) {
				fjalekalimi=fjalekalimi+res.getString("psalt");
				fjalekalimi=h.hashString(fjalekalimi, "SHA-1");
				if(perdoruesi.equals(res.getString("pid")) && fjalekalimi.equals(res.getString("pfjalekalimi"))) {
					if(res.getString("ptipi").equals("s")) {
						frmMain fr=new frmMain();
						fr.setVisible(true);	
						fr.panelStudentet.setSize(260, 50);
						fr.panelSemestri.setSize(260, 50);
						fr.panelSemestri.setLocation(0, 228);
						fr.pnlRaportet.setLocation(0, 178);
						fr.clock();
						dispose();	
					}
					else if(res.getString("ptipi").equals("r")) {
						frmMain fr=new frmMain();
						fr.setVisible(true);
						fr.panelStudentet.setSize(260, 50);
						fr.panelSemestri.setSize(260, 50);
						fr.panelSemestri.setLocation(0, 228);
						fr.pnlRaportet.setLocation(0, 178);
						fr.clock();
						dispose();	
					}
				}
				else {
					JOptionPane.showMessageDialog(null,lang.getString("PFG") ,lang.getString("Info"),JOptionPane.ERROR_MESSAGE);
					}	
				}
				
				else {
					JOptionPane.showMessageDialog(null,lang.getString("PFG") ,lang.getString("Info"),JOptionPane.ERROR_MESSAGE);
				}
				pst.close();
				
			} 
			catch (SQLException e2) {
				System.out.println("Exception");
			}
			catch(Exception e) {						
			}
			
		}
		
	}
	public void writeFile(File f, String user, String pass) {
		try {
		PrintWriter pw=new PrintWriter(f);
		pw.println(user);
		pw.println(pass);
		pw.close();
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, lang.getString("PWS"),lang.getString("Gabim"),JOptionPane.ERROR_MESSAGE);
		}
	}
}
