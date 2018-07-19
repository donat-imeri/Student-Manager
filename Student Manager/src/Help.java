import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Help extends JFrame {
	private JPanel contentPane;
	private int xx;
	private int xy;
	JLabel lblHelpTitle;
	JLabel lblHomeBottomClose;
	JTextArea txtAreaHelpLanguage;
	JTextArea txtAreaInputInfos;
	JTextArea txtrAreaHelpClickforgotPassword;
	JTextArea txtAreaHelpClickrememberMe;
	JLabel lblHelpFirstTitle;
	JTextArea txtAreaHelpLock;
	JTextArea txtAreapnlChanger;
	JTextArea txtAreaHelpSettings;
	JTextArea txtAreaMenuResize;
	JLabel lblStudentsMenagamentSystem;
	JLabel helpArrowRight;
	JLabel helpArrowLeft;
	static Locale currentLang;
	ResourceBundle lang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		currentLang = frmMain.currentLang;
		lang = ResourceBundle.getBundle("Language", currentLang);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlHelpDrag = new JPanel();
		pnlHelpDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();
			}
		});
		pnlHelpDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xx, y - xy);
			}
		});
		pnlHelpDrag.setBackground(Color.WHITE);
		pnlHelpDrag.setBounds(0, 0, 860, 27);
		contentPane.add(pnlHelpDrag);
		pnlHelpDrag.setLayout(null);
		
		JLabel lblHelpIcon = new JLabel("");
		lblHelpIcon.setIcon(new ImageIcon(Help.class.getResource("/image/help loho.png")));
		lblHelpIcon.setBounds(0, 0, 27, 27);
		pnlHelpDrag.add(lblHelpIcon);
		
		lblHelpTitle = new JLabel(lang.getString("HelpTitle"));
		lblHelpTitle.setForeground(new Color(12, 108, 212));
		lblHelpTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHelpTitle.setBounds(48, 0, 99, 27);
		pnlHelpDrag.add(lblHelpTitle);
		
		JLabel lblHelpExit = new JLabel("");
		lblHelpExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelpExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHelpExit.setBackground(Color.red);
				lblHelpExit.setOpaque(true);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblHelpExit.setBackground(Color.white);
				lblHelpExit.setOpaque(false);
			}
		});;
		lblHelpExit.setIcon(new ImageIcon(Help.class.getResource("/image/images.png")));
		lblHelpExit.setBounds(828, 0, 32, 27);
		pnlHelpDrag.add(lblHelpExit);
		
		JLabel lblHelpMinimize = new JLabel("");
		lblHelpMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelpMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    setState(ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHelpMinimize.setBackground(Color.LIGHT_GRAY);
				lblHelpMinimize.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblHelpMinimize.setBackground(null);
				lblHelpMinimize.setOpaque(false);

				}
		});
		lblHelpMinimize.setIcon(new ImageIcon(Help.class.getResource("/image/minimize.png")));
		lblHelpMinimize.setBounds(798, 0, 32, 27);
		pnlHelpDrag.add(lblHelpMinimize);
		
		JPanel helpMainCardLayoutContainer = new JPanel();
		helpMainCardLayoutContainer.setBackground(new Color(12, 108, 212));
		helpMainCardLayoutContainer.setBounds(0, 562, 860, 48);
		contentPane.add(helpMainCardLayoutContainer);
		helpMainCardLayoutContainer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel.setOpaque(false);
		panel.setBounds(720, 4, 140, 40);
		helpMainCardLayoutContainer.add(panel);
		panel.setLayout(null);
		
		 lblHomeBottomClose = new JLabel(lang.getString("HelpClose"));
		lblHomeBottomClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeBottomClose.setForeground(Color.WHITE);
		lblHomeBottomClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHomeBottomClose.setBounds(0, 0, 80, 40);
		panel.add(lblHomeBottomClose);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setIcon(new ImageIcon(Help.class.getResource("/image/Close Help bottom_40px.png")));
		label.setBounds(80, 0, 40, 40);
		panel.add(label);
		
		JPanel helpCardLayout = new JPanel();
		helpCardLayout.setBackground(new Color(228, 244, 252));
		helpCardLayout.setBounds(0, 27, 860, 508);
		contentPane.add(helpCardLayout);
		helpCardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel pnlHelpFirst = new JPanel();
		pnlHelpFirst.setBackground(new Color(228, 244, 252));
		helpCardLayout.add(pnlHelpFirst, "name_3761964495832");
		pnlHelpFirst.setLayout(null);
		
		 txtAreaHelpLanguage = new JTextArea();
		txtAreaHelpLanguage.setOpaque(false);
		txtAreaHelpLanguage.setForeground(new Color(255, 255, 255));
		txtAreaHelpLanguage.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreaHelpLanguage.setText(lang.getString("HelpLanguageInfo"));
		txtAreaHelpLanguage.setBounds(310, 49, 151, 65);
		pnlHelpFirst.add(txtAreaHelpLanguage);
		
	     txtAreaInputInfos = new JTextArea();
		txtAreaInputInfos.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtAreaInputInfos.setForeground(new Color(255, 255, 255));
		txtAreaInputInfos.setOpaque(false);
		txtAreaInputInfos.setText(lang.getString("HelpInputInfos"));
		txtAreaInputInfos.setBounds(595, 304, 134, 77);
		pnlHelpFirst.add(txtAreaInputInfos);
		
		 txtrAreaHelpClickforgotPassword = new JTextArea();
		txtrAreaHelpClickforgotPassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrAreaHelpClickforgotPassword.setForeground(new Color(255, 255, 255));
		txtrAreaHelpClickforgotPassword.setLineWrap(true);
		txtrAreaHelpClickforgotPassword.setOpaque(false);
		txtrAreaHelpClickforgotPassword.setText(lang.getString("HelpForgotPasswordInfo"));
		txtrAreaHelpClickforgotPassword.setBounds(576, 392, 117, 105);
		pnlHelpFirst.add(txtrAreaHelpClickforgotPassword);
		
		 txtAreaHelpClickrememberMe = new JTextArea();
		txtAreaHelpClickrememberMe.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtAreaHelpClickrememberMe.setForeground(new Color(255, 255, 255));
		txtAreaHelpClickrememberMe.setOpaque(false);
		txtAreaHelpClickrememberMe.setText(lang.getString("HelpRememberMeInfo"));
		txtAreaHelpClickrememberMe.setBounds(174, 407, 123, 88);
		pnlHelpFirst.add(txtAreaHelpClickrememberMe);
		
		JLabel lblHelpFirstBg = new JLabel("");
		lblHelpFirstBg.setIcon(new ImageIcon(Help.class.getResource("/image/help bg.png")));
		lblHelpFirstBg.setBounds(0, 28, 860, 480);
		pnlHelpFirst.add(lblHelpFirstBg);
		
		 lblHelpFirstTitle = new JLabel(lang.getString("HelpFirstPageTitle"));
		lblHelpFirstTitle.setForeground(new Color(12, 108, 212));
		lblHelpFirstTitle.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblHelpFirstTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelpFirstTitle.setBounds(0, 0, 860, 28);
		pnlHelpFirst.add(lblHelpFirstTitle);
		
		JPanel pnlHelpSecond = new JPanel();
		pnlHelpSecond.setBackground(new Color(228, 244, 252));
		helpCardLayout.add(pnlHelpSecond, "name_3794035974339");
		pnlHelpSecond.setLayout(null);
		
		 txtAreaHelpLock = new JTextArea();
		txtAreaHelpLock.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreaHelpLock.setForeground(Color.WHITE);
		txtAreaHelpLock.setOpaque(false);
		txtAreaHelpLock.setText(lang.getString("HelpLockInfo"));
		txtAreaHelpLock.setBounds(301, 146, 85, 80);
		pnlHelpSecond.add(txtAreaHelpLock);
		
		 txtAreapnlChanger = new JTextArea();
		txtAreapnlChanger.setText(lang.getString("HelpMainPanelArrows"));
		txtAreapnlChanger.setForeground(Color.WHITE);
		txtAreapnlChanger.setOpaque(false);
		txtAreapnlChanger.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreapnlChanger.setBounds(305, 31, 144, 52);
		pnlHelpSecond.add(txtAreapnlChanger);
		
		 txtAreaHelpSettings = new JTextArea();
		txtAreaHelpSettings.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreaHelpSettings.setOpaque(false);
		txtAreaHelpSettings.setForeground(Color.WHITE);
		txtAreaHelpSettings.setText(lang.getString("HelpSettingsInfo"));
		txtAreaHelpSettings.setBounds(301, 460, 117, 37);
		pnlHelpSecond.add(txtAreaHelpSettings);
		
		JTextArea txtAreaMenus = new JTextArea();
		txtAreaMenus.setOpaque(false);
		txtAreaMenus.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtAreaMenus.setForeground(Color.WHITE);
		txtAreaMenus.setText(lang.getString("HelpMenusInfo"));
		txtAreaMenus.setBounds(29, 293, 108, 89);
		pnlHelpSecond.add(txtAreaMenus);
		
		 txtAreaMenuResize = new JTextArea();
		txtAreaMenuResize.setOpaque(false);
		txtAreaMenuResize.setForeground(Color.WHITE);
		txtAreaMenuResize.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtAreaMenuResize.setText(lang.getString("HelpMenuResizeInfo"));
		txtAreaMenuResize.setBounds(64, 156, 73, 44);
		pnlHelpSecond.add(txtAreaMenuResize);
		
		 lblStudentsMenagamentSystem = new JLabel(lang.getString("HelpSecondPageTitle"));
		lblStudentsMenagamentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsMenagamentSystem.setForeground(new Color(12, 108, 212));
		lblStudentsMenagamentSystem.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblStudentsMenagamentSystem.setBounds(0, 0, 860, 28);
		pnlHelpSecond.add(lblStudentsMenagamentSystem);
		
		JLabel lblHelpSecondImg = new JLabel("");
		lblHelpSecondImg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHelpSecondImg.setIcon(new ImageIcon(Help.class.getResource("/image/help sec Bg.png")));
		lblHelpSecondImg.setBounds(0, 28, 860, 480);
		pnlHelpSecond.add(lblHelpSecondImg);
		
		JPanel helpArrows = new JPanel();
		helpArrows.setBackground(new Color(228, 244, 252));
		helpArrows.setBounds(0, 534, 860, 29);
		contentPane.add(helpArrows);
		helpArrows.setLayout(null);
		
		 helpArrowRight = new JLabel("");
		helpArrowRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(helpCardLayout.getComponent(0).isVisible()) {
				CardLayout c=(CardLayout) helpCardLayout.getLayout();
				c.next(helpCardLayout);
				helpArrowLeft.setEnabled(true);
				helpArrowRight.setEnabled(false);
				}
			}
		});
		helpArrowRight.setIcon(new ImageIcon(Help.class.getResource("/image/Right curved_27px.png")));
		helpArrowRight.setBounds(443, 0, 27, 27);
		helpArrows.add(helpArrowRight);
		
		helpArrowLeft = new JLabel("");
		helpArrowLeft.setEnabled(false);
		helpArrowLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(helpCardLayout.getComponent(1).isVisible()) {
				CardLayout c=(CardLayout) helpCardLayout.getLayout();
				c.previous(helpCardLayout);
				helpArrowRight.setEnabled(true);
				helpArrowLeft.setEnabled(false);
				}
			}
		});
		helpArrowLeft.setIcon(new ImageIcon(Help.class.getResource("/image/Left curved_27px.png")));
		helpArrowLeft.setBounds(396, 0, 27, 27);
		helpArrows.add(helpArrowLeft);
		
		
		
		setUndecorated(true);
	}
	public void changeHelpLang() {
		 currentLang=frmMain.currentLang;
		 lang=ResourceBundle.getBundle("Language", currentLang);
		 lblHelpTitle.setText(lang.getString("HelpTitle"));
		 lblHomeBottomClose.setText(lang.getString("HelpClose"));
		 txtAreaHelpLanguage.setText(lang.getString("HelpLanguageInfo"));
		 txtAreaInputInfos.setText(lang.getString("HelpInputInfos"));
		 txtrAreaHelpClickforgotPassword.setText(lang.getString("HelpForgotPasswordInfo"));
		 txtAreaHelpClickrememberMe.setText(lang.getString("HelpRememberMeInfo"));
		 lblHelpFirstTitle.setText(lang.getString("HelpFirstPageTitle"));
		 txtAreaHelpLock.setText(lang.getString("HelpLockInfo"));
		 txtAreapnlChanger.setText(lang.getString("HelpMainPanelArrows"));
		 txtAreaHelpSettings.setText(lang.getString("HelpSettingsInfo"));
		 txtAreaMenuResize.setText(lang.getString("HelpMenuResizeInfo"));
		 lblStudentsMenagamentSystem.setText(lang.getString("HelpSecondPageTitle"));	
	}
}
