import java.awt.BorderLayout;

//frmMain v8
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.Keymap;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Toolkit;
public class frmMain extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String imagePath;
	Hashing hash = new Hashing();

	Timer pnlStudentetOpen, pnlStudentetClose, pnlSemestriTimer, pnlMenuMinimizeTimer, pnlMenuMaxTimer,
			panelLanguageOpen, panelLanguageClose;
	int pnStudentetOpen = 50;
	int pnStudentetClose = 150;
	int pnSemestriOpen = 50;
	int pnMenuClose = 260;
	int pnMenuOpen = 60;
	int locked = 0;
	int pnLanguageOpen = 30;
	int pnLanguageClose = 90;
	int glassPaneRight = 260;
	int glassPaneLeft = 60;
	int xx;
	int xy;
	int l = 0;
	int r = 0;
	int shtesa = 260;
	static boolean threadStop=false;
	private JPanel contentPane;
	JPanel dragPanel;

	Help obj = new Help();
	About obj1 = new About();
	static Locale currentLang = new Locale("AL");
	public String user;
	static ResourceBundle lang;
	private int fontSize = 16;

	// Variablat per databaze
	Connection conn = null;
	ResultSet res = null;
	PreparedStatement pst = null;

	static Thread time;
	JPanel panelStudentet;
	JPanel panelSemestri;
	JPanel pnlRaportet;
	JPanel pnlLeftRegjistro;
	JPanel pnlLeftKerko;
	JPanel pnlLeftRaporte;
	JPanel pnlLeftRegjistroSemestrin;
	JPanel pnlLeftContact;
	JPanel pnlMainContact;
	JPanel pnlMainMessage;
	JPanel pnlLeftMessage;
	JPanel mainPanel;
	JPanel pnlMainHome;
	int homeActive = 1;

	JLabel lblUpDown;
	JLabel lblUpDown1;
	JLabel lblArrowLeft;
	JLabel lblArrowRight;
    JLabel lblIsRunning;
    JLabel lblSemestriFilterError;
	static JLabel lblStatusDate;
	static JLabel lblStatusTime;

	private JLabel lblHome;
	private JLabel lblLock;
	private JTextField txtID;
	private JTextField txtEmri;
	private JTextField txtMbiemri;
	private JDateChooser txtDitelindja;
	private JTextField txtAdresa;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtKerkoSemestrin;
	public JComboBox cmbQyteti;
	private JComboBox cmbShteti;
	private JRadioButton rdbtnMashkull;
	private JRadioButton rdbtnFemer;
	private JComboBox cmbDrejtimi;
	private JComboBox cmbFakulteti;
	private JComboBox cmbNiveli;
	private JPanel pnlStatusi;
	private JRadioButton rdbtnIRregullt;
	private JRadioButton rdbtnMeKorrospodence;
	private JLabel lblProfile;
	private JTable tblSemestri;
	private JLabel lblError;
	private JLabel iconError;
	JTableHeader TableHeader;
	JTableHeader Theader;
	JTextPane txtMessage1;
	private JTable table;
	private JTextField txtFilter;
	private JTextField txtPrindi;
	private JTextField txtPersonalNr;
	private JTextField txtNumriTotal;
	private JTextField txtViti1;
	private JTextField txtViti2;
	private JTextField txtViti4;
	private JTextField txtViti3;
	private JTextField txtElektronike;
	private JTextField txtTelekomunikacion;
	private JTextField txtKompjuterike;
	private JTextField txtAutomatike;
	private JTextField txtElektroenergjetike;
	private JTextField txtBujqesi;
	private JTextField txtFemra;
	private JTextField txtMeshkuj;
	private JComboBox cmbKerko;
	private JPanel pnlMainRegjistro;
	private JLabel lblTitulli;
	private JLabel lblTitle;
	private JPanel pnlMainKerko;
	private JPanel pnlMainSemestri;
	private JPanel pnlMainRaporte;
	private String ngjyra="", ngjyraSfondit="", boldAttr="", italicAttr="",underlineAttr="", align="",htmlFontSize="";
	

	private int id;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currentLang = frmLoginAl.currentLang;
					lang = ResourceBundle.getBundle("Language", currentLang);
					// qe te mos hapet nese ska provuar mu kyq
					if (!frmLoginAl.open == true) {
						frmMain frame = new frmMain();
						
						frame.setVisible(true);
						frame.panelStudentet.setSize(260, 50);
						frame.panelSemestri.setSize(260, 50);
						frame.panelSemestri.setLocation(0, 228);
						frame.pnlRaportet.setLocation(0, 178);
						clock();
					}
					else {
						int zgjedhja=JOptionPane.showConfirmDialog(null,lang.getString("TryToLogin"), lang.getString("MP"),JOptionPane.YES_NO_OPTION);
					if(zgjedhja==JOptionPane.YES_OPTION) {
						frmLoginAl obj=new frmLoginAl();
						obj.setUndecorated(true);
						obj.setVisible(true);
						obj.setLocationRelativeTo(null);
						obj.setSize(327,411);
						}
				 } 
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	

	public frmMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmMain.class.getResource("/image/logo.png")));
		setTitle("SPMS");
	
        clock();
		currentLang = frmLoginAl.currentLang;
		lang = ResourceBundle.getBundle("Language", currentLang);
		conn = DatabaseConnection.startConnection();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(true);
		

		helpWithF1(contentPane,KeyEvent.VK_F1,"help");
		changePanelsWithKeys(contentPane, KeyEvent.VK_PAGE_UP,KeyEvent.VK_PAGE_DOWN,"left","right");
		
		 mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(260, 27, 795, 600);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		dragPanel = new JPanel();
		dragPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX() + shtesa;
				xy = e.getY();
			}
		});
		dragPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xx, y - xy);
			}
		});
		dragPanel.setBounds(260, 0, 795, 27);
		contentPane.add(dragPanel);
		dragPanel.setBackground(new Color(255, 255, 255));
		dragPanel.setLayout(null);

		pnlMainHome = new JPanel();
		pnlMainHome.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainHome, "name_10138577380732");
		pnlMainHome.setLayout(null);


		JPanel pnlMainHomeCover = new JPanel();
		pnlMainHomeCover.setBackground(new Color(255, 255, 255));
		pnlMainHomeCover.setBounds(0, 0, 795, 623);
		pnlMainHome.add(pnlMainHomeCover);
		pnlMainHomeCover.setLayout(null);
		
		JLabel fotoStudentet = new JLabel("");
		fotoStudentet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (panelStudentet.getHeight() < 60) {
					pnlStudentetClose.stop();
					pnStudentetOpen = 50;
					pnlStudentetOpen.start();
					lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				}
				pnlLeftRegjistro.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainRegjistro);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RSt"));
				
				
				
			}
		});
		fotoStudentet.setIcon(new ImageIcon(frmMain.class.getResource("/image/person1.png")));
		fotoStudentet.setBounds(97, 174, 113, 119);
		pnlMainHomeCover.add(fotoStudentet);
		
		JLabel fotoKontakt = new JLabel("");
		fotoKontakt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftContact.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainContact);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("Kontakto"));
			}
		});
		fotoKontakt.setIcon(new ImageIcon(frmMain.class.getResource("/image/phone1.png")));
		fotoKontakt.setBounds(353, 174, 113, 119);
		pnlMainHomeCover.add(fotoKontakt);
		
		JLabel fotoKerko = new JLabel("");
		fotoKerko.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelStudentet.getHeight() < 60) {
					pnlStudentetClose.stop();
					pnStudentetOpen = 50;
					pnlStudentetOpen.start();
					lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				}
				
				pnlLeftKerko.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainKerko);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("KEStudentet"));
			}
		});
		fotoKerko.setIcon(new ImageIcon(frmMain.class.getResource("/image/search1.png")));
		fotoKerko.setBounds(97, 387, 113, 119);
		pnlMainHomeCover.add(fotoKerko);
		
		JLabel fotoRegjistro = new JLabel("");
		fotoRegjistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelSemestri.getHeight() < 60) {
					pnlSemestriTimer.start();
					lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));

				}
				pnlLeftRegjistroSemestrin.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				homeActive = 0;;
				mainPanel.removeAll();
				mainPanel.add(pnlMainSemestri);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RS"));
			
					
			}
		});
		fotoRegjistro.setIcon(new ImageIcon(frmMain.class.getResource("/image/semester1.png")));
		fotoRegjistro.setBounds(355, 387, 109, 119);
		pnlMainHomeCover.add(fotoRegjistro);
		
		JLabel fotoMesazhi = new JLabel("");
		fotoMesazhi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftMessage.setVisible(true);
				lblArrowRight.setEnabled(false);
				lblArrowLeft.setEnabled(true);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainMessage);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("DM"));
			}
		});
		fotoMesazhi.setIcon(new ImageIcon(frmMain.class.getResource("/image/message2.png")));
		fotoMesazhi.setBounds(598, 387, 113, 119);
		pnlMainHomeCover.add(fotoMesazhi);
		
		JLabel lblSistemiPerMenaxhimin = new JLabel(lang.getString("SPMS"));
		lblSistemiPerMenaxhimin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSistemiPerMenaxhimin.setBounds(203, 57, 582, 37);
		pnlMainHomeCover.add(lblSistemiPerMenaxhimin);
		
		JLabel lblRegjistroPerdorues = new JLabel(lang.getString("RSt"));
		lblRegjistroPerdorues.setBounds(107, 304, 175, 14);
		pnlMainHomeCover.add(lblRegjistroPerdorues);
		
		JLabel lblKontaktoSherbimin = new JLabel(lang.getString("Kontakto"));
		lblKontaktoSherbimin.setBounds(385, 304, 141, 14);
		pnlMainHomeCover.add(lblKontaktoSherbimin);
		
		JLabel lblRaporti = new JLabel(lang.getString("RaportSt"));
		lblRaporti.setBounds(600, 304, 155, 14);
		pnlMainHomeCover.add(lblRaporti);
		
		JLabel lblKerkoStudentet = new JLabel(lang.getString("KEStudentet"));
		lblKerkoStudentet.setBounds(90, 519, 163, 14);
		pnlMainHomeCover.add(lblKerkoStudentet);
		
		JLabel lblRegjistroSemestrin_1 = new JLabel(lang.getString("RS"));
		lblRegjistroSemestrin_1.setBounds(365, 519, 175, 14);
		pnlMainHomeCover.add(lblRegjistroSemestrin_1);
		
		JLabel lblDergoMesazh = new JLabel(lang.getString("DM"));
		lblDergoMesazh.setBounds(608, 517, 177, 14);
		pnlMainHomeCover.add(lblDergoMesazh);
		
		JLabel lblRaportetHome = new JLabel("");
		lblRaportetHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlLeftRaporte.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainRaporte);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RaportSt"));
			}
		});
		lblRaportetHome.setIcon(new ImageIcon(frmMain.class.getResource("/image/report.png")));
		lblRaportetHome.setBounds(598, 174, 113, 119);
		pnlMainHomeCover.add(lblRaportetHome);
		
		JLabel lblHomeIcon = new JLabel("");
		lblHomeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/logo1.png")));
		lblHomeIcon.setBounds(0, 0, 184, 163);
		pnlMainHomeCover.add(lblHomeIcon);

		
		lblTitle = new JLabel(lang.getString("Home"));
		lblTitle.setBounds(112, 0, 247, 27);
		dragPanel.add(lblTitle);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 19));

		pnlMainRegjistro = new JPanel();
		pnlMainRegjistro.setForeground(new Color(0, 0, 204));
		pnlMainRegjistro.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainRegjistro, "name_71415382035834");
		pnlMainRegjistro.setLayout(null);

		/**
		 * PANELI PER REGJISTRIM
		 */
		JPanel pnlMainRegjistroCover = new JPanel();
		pnlMainRegjistroCover.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
					if (e.getKeyCode() == e.VK_ENTER) {
						regjistroStudentet();
					}
				
			}
		});
		pnlMainRegjistroCover.setLayout(null);
		pnlMainRegjistroCover.setBackground(Color.WHITE);
		pnlMainRegjistroCover.setBounds(0, 0, 795, 623);
		pnlMainRegjistro.add(pnlMainRegjistroCover);

		JLabel iconBasic = new JLabel("");
		iconBasic.setIcon(new ImageIcon(frmMain.class.getResource("/image/Name_25px.png")));
		iconBasic.setBounds(329, 11, 25, 25);
		pnlMainRegjistroCover.add(iconBasic);

		JLabel iconContact = new JLabel("");
		iconContact.setIcon(new ImageIcon(frmMain.class.getResource("/image/City_25px.png")));
		iconContact.setBounds(310, 160, 25, 25);
		pnlMainRegjistroCover.add(iconContact);

		JLabel iconAdministrative = new JLabel("");
		iconAdministrative.setIcon(new ImageIcon(frmMain.class.getResource("/image/University_25px.png")));
		iconAdministrative.setBounds(305, 304, 25, 25);
		pnlMainRegjistroCover.add(iconAdministrative);

		JLabel lblEmri = new JLabel(lang.getString("name"));
		lblEmri.setForeground(Color.BLACK);
		lblEmri.setBounds(10, 52, 100, 14);
		pnlMainRegjistroCover.add(lblEmri);
		lblEmri.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmri.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtEmri = new JTextField();
		txtEmri.setBounds(120, 47, 243, 25);
		pnlMainRegjistroCover.add(txtEmri);
		txtEmri.setColumns(10);

		JLabel lblMbiemri = new JLabel(lang.getString("surname"));
		lblMbiemri.setForeground(Color.BLACK);
		lblMbiemri.setBounds(408, 52, 100, 14);
		pnlMainRegjistroCover.add(lblMbiemri);
		lblMbiemri.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMbiemri.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtMbiemri = new JTextField();
		txtMbiemri.setBounds(518, 47, 243, 25);
		pnlMainRegjistroCover.add(txtMbiemri);
		txtMbiemri.setColumns(10);

		JLabel lblDitelindja = new JLabel(lang.getString("birthday"));
		lblDitelindja.setForeground(Color.BLACK);
		lblDitelindja.setBounds(10, 125, 100, 14);
		pnlMainRegjistroCover.add(lblDitelindja);
		lblDitelindja.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDitelindja.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtDitelindja = new JDateChooser();
		txtDitelindja.getCalendarButton().setContentAreaFilled(false);
		txtDitelindja.getCalendarButton().setBorderPainted(false);
		txtDitelindja.getCalendarButton().setBackground(Color.WHITE);
		txtDitelindja.getCalendarButton().setBorder(null);
		txtDitelindja.getCalendarButton().setFocusPainted(false);
		txtDitelindja.getCalendarButton().setOpaque(false);
		txtDitelindja.getCalendarButton().setIcon(new ImageIcon(frmMain.class.getResource("/image/Date_25px.png")));
		txtDitelindja.setDateFormatString("YYYY-MM-dd");
		txtDitelindja.setBounds(120, 120, 243, 25);
		pnlMainRegjistroCover.add(txtDitelindja);

		JLabel lblQyteti = new JLabel(lang.getString("city"));
		lblQyteti.setForeground(Color.BLACK);
		lblQyteti.setBounds(408, 198, 100, 20);
		pnlMainRegjistroCover.add(lblQyteti);
		lblQyteti.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQyteti.setFont(new Font("Verdana", Font.PLAIN, 14));

		cmbQyteti = new JComboBox();
		cmbQyteti.setBackground(Color.WHITE);
		cmbQyteti.setModel(new DefaultComboBoxModel(new String[] { "" }));
		cmbQyteti.setFont(new Font("Verdana", Font.PLAIN, 13));
		cmbQyteti.setBounds(518, 196, 243, 25);
		pnlMainRegjistroCover.add(cmbQyteti);

		JLabel lblShteti = new JLabel(lang.getString("country"));
		lblShteti.setForeground(Color.BLACK);
		lblShteti.setBounds(10, 201, 100, 14);
		pnlMainRegjistroCover.add(lblShteti);
		lblShteti.setHorizontalAlignment(SwingConstants.TRAILING);
		lblShteti.setFont(new Font("Verdana", Font.PLAIN, 14));

		cmbShteti = new JComboBox();
		cmbShteti.setBackground(Color.WHITE);
		cmbShteti.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cmbQyteti.removeAllItems();
					// Mbushja e rubrikes qytetet
					try {
						String shteti = "'" + cmbShteti.getSelectedItem().toString() + "'";
						String selectQytetet = "select qid,qemri from qytetet where qshteti in"
								+ "(select shid from shtetet where shemri=" + shteti + ")";

						pst = conn.prepareStatement(selectQytetet);
						res = pst.executeQuery();
						while (res.next()) {
							cmbQyteti.addItem(res.getString("qemri"));
						}
						pst.close();
					} catch (Exception e2) {
					}
				}
			}
		});

		// Mbushja e rubrikes shtetet
		try {
			cmbShteti.addItem("");
			String selectShtetet = "select shid,shemri from shtetet";
			pst = conn.prepareStatement(selectShtetet);
			res = pst.executeQuery();
			while (res.next()) {
				cmbShteti.addItem(res.getString("shemri"));
			}
			pst.close();
		} catch (Exception e2) {
		}
		cmbShteti.setFont(new Font("Verdana", Font.PLAIN, 13));
		cmbShteti.setBounds(120, 196, 243, 25);
		pnlMainRegjistroCover.add(cmbShteti);

		JLabel lblAdresa = new JLabel(lang.getString("address"));
		lblAdresa.setForeground(Color.BLACK);
		lblAdresa.setBounds(10, 237, 100, 14);
		pnlMainRegjistroCover.add(lblAdresa);
		lblAdresa.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresa.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtAdresa = new JTextField();
		txtAdresa.setBounds(120, 232, 243, 25);
		pnlMainRegjistroCover.add(txtAdresa);
		txtAdresa.setColumns(10);

		JLabel lblNrtel = new JLabel(lang.getString("tel"));
		lblNrtel.setForeground(Color.BLACK);
		lblNrtel.setBounds(408, 237, 100, 14);
		pnlMainRegjistroCover.add(lblNrtel);
		lblNrtel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNrtel.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtTel = new JTextField();
		txtTel.setBounds(518, 232, 243, 25);
		pnlMainRegjistroCover.add(txtTel);
		txtTel.setColumns(10);

		JLabel lblEmail = new JLabel(lang.getString("email"));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(10, 273, 100, 14);
		pnlMainRegjistroCover.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 14));

		txtEmail = new JTextField();
		txtEmail.setBounds(120, 268, 243, 25);
		pnlMainRegjistroCover.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblGjinia = new JLabel(lang.getString("gender"));
		lblGjinia.setForeground(Color.BLACK);
		lblGjinia.setBounds(408, 125, 100, 14);
		pnlMainRegjistroCover.add(lblGjinia);
		lblGjinia.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGjinia.setFont(new Font("Verdana", Font.PLAIN, 14));

		JPanel pnlGjinia = new JPanel();
		pnlGjinia.setDoubleBuffered(false);
		pnlGjinia.setOpaque(false);
		pnlGjinia.setBounds(518, 120, 243, 29);
		pnlMainRegjistroCover.add(pnlGjinia);
		pnlGjinia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlGjinia.setBorder(null);
		pnlGjinia.setLayout(null);

		rdbtnMashkull = new JRadioButton(lang.getString("male"));
		rdbtnMashkull.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER) {
					rdbtnMashkull.setSelected(true);
				}
			}
		});
		rdbtnMashkull.setFocusCycleRoot(true);
		rdbtnMashkull.setContentAreaFilled(false);
		rdbtnMashkull.setBorder(null);
		rdbtnMashkull.setOpaque(false);
		rdbtnMashkull.setForeground(Color.BLACK);
		rdbtnMashkull.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnMashkull.setBounds(28, 3, 103, 23);
		pnlGjinia.add(rdbtnMashkull);
		buttonGroup.add(rdbtnMashkull);

		rdbtnFemer = new JRadioButton(lang.getString("female"));
		rdbtnFemer.setOpaque(false);
		rdbtnFemer.setForeground(Color.BLACK);
		rdbtnFemer.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnFemer.setBounds(133, 3, 109, 23);
		pnlGjinia.add(rdbtnFemer);
		buttonGroup.add(rdbtnFemer);

		JLabel lblDrejtimi = new JLabel(lang.getString("branch"));
		lblDrejtimi.setForeground(Color.BLACK);
		lblDrejtimi.setBounds(10, 389, 100, 14);
		pnlMainRegjistroCover.add(lblDrejtimi);
		lblDrejtimi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDrejtimi.setFont(new Font("Verdana", Font.PLAIN, 14));

		cmbDrejtimi = new JComboBox();
		cmbDrejtimi.setBackground(Color.WHITE);
		cmbDrejtimi.setModel(new DefaultComboBoxModel(new String[] { "" }));
		cmbDrejtimi.setBounds(120, 384, 388, 25);
		pnlMainRegjistroCover.add(cmbDrejtimi);
		cmbDrejtimi.setFont(new Font("Verdana", Font.PLAIN, 13));

		JLabel lblFakulteti = new JLabel(lang.getString("faculty"));
		lblFakulteti.setForeground(Color.BLACK);
		lblFakulteti.setBounds(10, 347, 100, 14);
		pnlMainRegjistroCover.add(lblFakulteti);
		lblFakulteti.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFakulteti.setFont(new Font("Verdana", Font.PLAIN, 14));

		cmbFakulteti = new JComboBox();
		cmbFakulteti.setBackground(Color.WHITE);
		cmbFakulteti.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					cmbDrejtimi.removeAllItems();
					// Mbushja e rubrikes qytetet
					try {
						String fakulteti = "'" + cmbFakulteti.getSelectedItem().toString() + "'";
						String selectDrejtimi = "select did,demri from drejtimet where dfakulteti in"
								+ "(select fid from fakultetet where femri=" + fakulteti + ")";

						pst = conn.prepareStatement(selectDrejtimi);
						res = pst.executeQuery();
						while (res.next()) {
							cmbDrejtimi.addItem(res.getString("demri"));
						}
						pst.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		// Mbushja e rubrikes fakultetet
		cmbFakulteti.addItem("");
		try {
			String selectFakultetet = "select femri from fakultetet";
			pst = conn.prepareStatement(selectFakultetet);
			res = pst.executeQuery();
			while (res.next()) {
				cmbFakulteti.addItem(res.getString("femri"));
			}
			pst.close();
		} catch (Exception e2) {
		}
		cmbFakulteti.setBounds(120, 341, 388, 25);
		pnlMainRegjistroCover.add(cmbFakulteti);
		cmbFakulteti.setFont(new Font("Verdana", Font.PLAIN, 13));

		JLabel lblStatusi = new JLabel(lang.getString("status"));
		lblStatusi.setForeground(Color.BLACK);
		lblStatusi.setBounds(10, 482, 100, 14);
		pnlMainRegjistroCover.add(lblStatusi);
		lblStatusi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStatusi.setFont(new Font("Verdana", Font.PLAIN, 14));

		cmbNiveli = new JComboBox();
		cmbNiveli.setModel(new DefaultComboBoxModel(new String[] { "Bachelor", "Master" }));
		cmbNiveli.setBackground(Color.WHITE);
		cmbNiveli.setFont(new Font("Verdana", Font.PLAIN, 13));
		cmbNiveli.setBounds(120, 430, 388, 25);
		pnlMainRegjistroCover.add(cmbNiveli);

		pnlStatusi = new JPanel();
		pnlStatusi.setOpaque(false);
		pnlStatusi.setBounds(120, 466, 337, 46);
		pnlMainRegjistroCover.add(pnlStatusi);
		pnlStatusi.setLayout(null);
		pnlStatusi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pnlStatusi.setBorder(null);

		rdbtnIRregullt = new JRadioButton(lang.getString("regular"));
		rdbtnIRregullt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER) {
					rdbtnIRregullt.setSelected(true);
				}
			}
		});
		buttonGroup_1.add(rdbtnIRregullt);
		rdbtnIRregullt.setOpaque(false);
		rdbtnIRregullt.setForeground(Color.BLACK);
		rdbtnIRregullt.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnIRregullt.setBounds(6, 11, 125, 23);
		pnlStatusi.add(rdbtnIRregullt);

		rdbtnMeKorrospodence = new JRadioButton(lang.getString("correspondence"));
		buttonGroup_1.add(rdbtnMeKorrospodence);
		rdbtnMeKorrospodence.setOpaque(false);
		rdbtnMeKorrospodence.setForeground(Color.BLACK);
		rdbtnMeKorrospodence.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnMeKorrospodence.setBounds(133, 11, 220, 23);
		pnlStatusi.add(rdbtnMeKorrospodence);

		JPanel pnlImage = new JPanel();
		pnlImage.setOpaque(false);
		pnlImage.setBounds(591, 341, 140, 140);
		pnlMainRegjistroCover.add(pnlImage);
		pnlImage.setBorder(null);
		pnlImage.setLayout(null);

		lblProfile = new JLabel("");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setIcon(new ImageIcon(frmMain.class.getResource("/image/Female_100px.png")));
		lblProfile.setBounds(0, 0, 140, 140);
		pnlImage.add(lblProfile);

		JButton btnZgjedh = new JButton(lang.getString("Zgjedh"));
		btnZgjedh.setFocusPainted(false);
		btnZgjedh.setBackground(Color.WHITE);
		btnZgjedh.setBounds(591, 487, 140, 25);
		pnlMainRegjistroCover.add(btnZgjedh);
		btnZgjedh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser chooser = new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Image file", "jpg", "jpeg", "png");
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.setFileFilter(filter);
					chooser.setDialogTitle("Choose image file");
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					imagePath = f.getAbsolutePath();
					ImageIcon icon = new ImageIcon(imagePath);					
					Image imageIcon = icon.getImage();
					imageIcon=imageIcon.getScaledInstance(pnlImage.getWidth(), pnlImage.getHeight(), Image.SCALE_DEFAULT);
					lblProfile.setIcon(new ImageIcon(imageIcon));
				} catch (Exception e) {
				}
			}
		});
		btnZgjedh.setFont(new Font("Verdana", Font.PLAIN, 13));

		iconError = new JLabel("");
		iconError.setBounds(255, 572, 25, 25);
		pnlMainRegjistroCover.add(iconError);

		lblError = new JLabel("");
		lblError.setHorizontalTextPosition(SwingConstants.CENTER);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Verdana", Font.BOLD, 12));
		lblError.setForeground(Color.RED);
		lblError.setBounds(241, 572, 347, 25);
		pnlMainRegjistroCover.add(lblError);

		JButton btnRegjistroStudentet = new JButton(lang.getString("Regjistro"));
		btnRegjistroStudentet.setBorder(null);
		btnRegjistroStudentet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regjistroStudentet();
			}
		});
		btnRegjistroStudentet.setFocusPainted(false);
		btnRegjistroStudentet.setForeground(new Color(255, 255, 255));
		btnRegjistroStudentet.setBackground(new Color(0, 0, 139));
		btnRegjistroStudentet.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRegjistroStudentet.setBounds(329, 522, 200, 46);
		pnlMainRegjistroCover.add(btnRegjistroStudentet);

		JLabel lblInfoBaze = new JLabel(lang.getString("InfoB"));
		lblInfoBaze.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoBaze.setOpaque(true);
		lblInfoBaze.setForeground(new Color(0, 191, 255));
		lblInfoBaze.setBackground(SystemColor.control);
		lblInfoBaze.setBounds(0, 11, 807, 25);
		pnlMainRegjistroCover.add(lblInfoBaze);

		JLabel lblInformatatKontaktuese = new JLabel(lang.getString("InfoK"));
		lblInformatatKontaktuese.setOpaque(true);
		lblInformatatKontaktuese.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformatatKontaktuese.setForeground(new Color(0, 191, 255));
		lblInformatatKontaktuese.setBackground(SystemColor.control);
		lblInformatatKontaktuese.setBounds(0, 160, 807, 25);
		pnlMainRegjistroCover.add(lblInformatatKontaktuese);

		JLabel lblInformatatAdministrative = new JLabel(lang.getString("InfoA"));
		lblInformatatAdministrative.setOpaque(true);
		lblInformatatAdministrative.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformatatAdministrative.setForeground(new Color(0, 191, 255));
		lblInformatatAdministrative.setBackground(SystemColor.control);
		lblInformatatAdministrative.setBounds(0, 305, 807, 25);
		pnlMainRegjistroCover.add(lblInformatatAdministrative);

		JLabel lblNiveli = new JLabel(lang.getString("nivel"));
		lblNiveli.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNiveli.setForeground(Color.BLACK);
		lblNiveli.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNiveli.setBounds(10, 435, 100, 14);
		pnlMainRegjistroCover.add(lblNiveli);

		JLabel lblPrindi = new JLabel(lang.getString("parent"));
		lblPrindi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrindi.setForeground(Color.BLACK);
		lblPrindi.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrindi.setBounds(10, 80, 100, 27);
		pnlMainRegjistroCover.add(lblPrindi);

		txtPrindi = new JTextField();
		txtPrindi.setColumns(10);
		txtPrindi.setBounds(120, 83, 243, 25);
		pnlMainRegjistroCover.add(txtPrindi);

		JLabel lblPersonalNr = new JLabel(lang.getString("personalNumber"));
		lblPersonalNr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPersonalNr.setForeground(Color.BLACK);
		lblPersonalNr.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPersonalNr.setBounds(373, 88, 135, 14);
		pnlMainRegjistroCover.add(lblPersonalNr);

		txtPersonalNr = new JTextField();
		txtPersonalNr.setColumns(10);
		txtPersonalNr.setBounds(518, 83, 243, 25);
		pnlMainRegjistroCover.add(txtPersonalNr);

		/**
		 * PANELI PER KERKIM/EDITIM
		 */
		pnlMainKerko = new JPanel();
		pnlMainKerko.setForeground(new Color(0, 0, 204));
		pnlMainKerko.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainKerko, "name_71473958723924");
		pnlMainKerko.setLayout(null);

		JPanel pnlMainKerkoCover = new JPanel();
		pnlMainKerkoCover.setBackground(Color.WHITE);
		pnlMainKerkoCover.setBounds(0, 0, 795, 623);
		pnlMainKerko.add(pnlMainKerkoCover);
		pnlMainKerkoCover.setLayout(null);

		JLabel lblFilterError = new JLabel("");
		lblFilterError.setForeground(new Color(255, 0, 0));
		lblFilterError.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		lblFilterError.setBounds(315, 122, 206, 18);
		pnlMainKerkoCover.add(lblFilterError);

		JPanel pnlFilter = new JPanel();
		pnlFilter.setBounds(315, 94, 180, 24);
		pnlMainKerkoCover.add(pnlFilter);
		pnlFilter.setLayout(null);

		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER) {
					editoStudentet();
				}
			}
		});
		txtFilter.setForeground(new Color(0, 0, 0));
		txtFilter.setBorder(new LineBorder(new Color(0, 0, 102)));
		txtFilter.setCaretColor(new Color(0, 0, 0));
		txtFilter.setBounds(0, 0, 156, 24);
		pnlFilter.add(txtFilter);
		txtFilter.setColumns(10);

		JLabel lblSearchDB = new JLabel("");
		lblSearchDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editoStudentet();
			}
			
			});
		lblSearchDB.setIcon(new ImageIcon(frmMain.class.getResource("/image/Search DB_24px.png")));
		lblSearchDB.setBounds(156, 0, 24, 24);
		pnlFilter.add(lblSearchDB);

		cmbKerko = new JComboBox();
		cmbKerko.setBounds(315, 44, 180, 24);
		pnlMainKerkoCover.add(cmbKerko);
		cmbKerko.setModel(new DefaultComboBoxModel(
				new String[] { "ID", "Emri", "Mbiemri", "Email", "Qyteti", "Ditelindja", "Fakulteti" }));
		cmbKerko.setFont(new Font("Verdana", Font.PLAIN, 14));

		JLabel lblKerkoSipas = new JLabel(lang.getString("Menyra"));
		lblKerkoSipas.setBounds(217, 47, 88, 18);
		pnlMainKerkoCover.add(lblKerkoSipas);
		lblKerkoSipas.setForeground(Color.BLACK);
		lblKerkoSipas.setFont(new Font("Verdana", Font.PLAIN, 14));

		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setBounds(217, 94, 88, 18);
		pnlMainKerkoCover.add(lblFilter);
		lblFilter.setForeground(Color.BLACK);
		lblFilter.setFont(new Font("Verdana", Font.PLAIN, 14));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 151, 745, 350);
		pnlMainKerkoCover.add(scrollPane_1);

		JTextField filterEmri = new JTextField();
		JTextField filterMbiemri = new JTextField();
		JTextField filterAdresa = new JTextField();
		JTextField filterTel = new JTextField();
		JTextField filterEmail = new JTextField();

		table = new javax.swing.JTable() {
			@Override
			public Component prepareRenderer(TableCellRenderer ren, int r, int c) {
				Component com = super.prepareRenderer(ren, r, c);
				if (r % 2 == 0 && !isRowSelected(r)) {
					com.setBackground(new Color(135, 175, 255));
					com.setForeground(Color.black);
				} else if (isRowSelected(r)) {
					com.setBackground(Color.blue);
					com.setForeground(Color.white);
				} else {
					com.setBackground(Color.white);
					com.setForeground(Color.black);
				}

				return com;
			}
		};
		TableHeader = table.getTableHeader();
		TableHeader.setBackground(new Color(4, 11, 66));
		TableHeader.setForeground(Color.WHITE);
		TableHeader.setFont(new Font("Tahome", Font.BOLD, 11));
		table.setFont(new Font("Tahome", Font.BOLD, 10));
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				id = (int) model.getValueAt(table.getSelectedRow(), 0);
					String sql = "select * from studentet where sid='" + id + "'";
					pst = conn.prepareStatement(sql);
					res = pst.executeQuery();
					while (res.next()) {
						filterEmri.setText(res.getString("semri"));
						filterMbiemri.setText(res.getString("smbiemri"));
						filterAdresa.setText(res.getString("sadresa"));
						filterTel.setText(res.getString("stel"));
						filterEmail.setText(res.getString("semail"));
					}
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, lang.getString("InsertError"));
				}
			}
		});
		scrollPane_1.setViewportView(table);
		table.setForeground(new Color(0, 0, 102));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
		}));
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table,popupMenu);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				table.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						id = (int) model.getValueAt(table.getSelectedRow(), 0);
						try {
							String sql = "select * from studentet where sid='" + id + "'";
							pst = conn.prepareStatement(sql);
							res = pst.executeQuery();
							while (res.next()) {
								filterEmri.setText(res.getString("semri"));
								filterMbiemri.setText(res.getString("smbiemri"));
								filterAdresa.setText(res.getString("sadresa"));
								filterTel.setText(res.getString("stel"));
								filterEmail.setText(res.getString("semail"));
							}
							pst.close();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, lang.getString("InsertError") + e.getMessage());
						}
					}
				});
				
				Object[] fields = { "Emri:", filterEmri, "Mbiemri:", filterMbiemri, "Adresa:", filterAdresa, "Tel:",
						filterTel, "Email:", filterEmail
				};
				int input = JOptionPane.showConfirmDialog(null, fields, lang.getString("editDB"), JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					try {
						String sql = "UPDATE studentet SET semri='" + filterEmri.getText() + "', " + "smbiemri='"
								+ filterMbiemri.getText() + "'," + "sadresa ='" + filterAdresa.getText() + "',"
								+ "stel ='" + filterTel.getText() + "'," + "semail ='" + filterEmail.getText()
								+ "' where sid='" + id + "'";
						pst = conn.prepareStatement(sql);
						pst.execute();
						updateTable();
						pst.close();

					} 
					catch (Exception ex) 
					{
						JOptionPane.showMessageDialog(null, lang.getString("InsertError"));
					}
				}

			}
			
		});
		popupMenu.add(mntmEdit);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(id>0) {
				try {
					String sql = "Delete from studentet where sid=" + id;
					pst = conn.prepareStatement(sql);
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, lang.getString("PerdoruesiError"));
					updateTable();
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(null, lang.getString("ErrorDelete"));
				}
				}
			}
		});
		popupMenu.add(mntmDelete);

		
		
		
		
		
		JButton btnEdit = new JButton(lang.getString("Edit"));
		btnEdit.setIcon(new ImageIcon(frmMain.class.getResource("/image/Edit_24px.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id>0) {
				try {
				Object[] fields = { "Emri:", filterEmri, "Mbiemri:", filterMbiemri, "Adresa:", filterAdresa, "Tel:",
						filterTel, "Email:", filterEmail };
				int input = JOptionPane.showConfirmDialog(null, fields, lang.getString("EditDB"), JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					
						String sql = "UPDATE studentet SET semri='" + filterEmri.getText() + "', " + "smbiemri='"
								+ filterMbiemri.getText() + "'," + "sadresa ='" + filterAdresa.getText() + "',"
								+ "stel ='" + filterTel.getText() + "'," + "semail ='" + filterEmail.getText()
								+ "' where sid='" + id + "'";
						pst = conn.prepareStatement(sql);
						pst.execute();
						updateTable();
						pst.close();

					}
				} 
				catch (Exception e) {
						JOptionPane.showMessageDialog(null, lang.getString("InsertError") + e.getMessage());
					}
				}
			}
		});
		btnEdit.setBounds(288, 534, 126, 24);
		pnlMainKerkoCover.add(btnEdit);

		JButton btnDelete = new JButton(lang.getString("Delete"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id>0) {
				try {
					String sql = "Delete from studentet where sid=" + id;
					pst = conn.prepareStatement(sql);
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, lang.getString("PerdoruesiError"));
					updateTable();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, lang.getString("DeleteError"));
				}
				}

			}
		});
		btnDelete.setIcon(new ImageIcon(frmMain.class.getResource("/image/Delete_24px.png")));
		btnDelete.setBounds(424, 534, 126, 23);
		pnlMainKerkoCover.add(btnDelete);

		/**
		 * PANELI PER RAPORT
		 */
		pnlMainRaporte = new JPanel();
		pnlMainRaporte.setForeground(new Color(0, 0, 204));
		pnlMainRaporte.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainRaporte, "name_71486204261011");
		pnlMainRaporte.setLayout(null);

		JPanel pnlMainRaporteCover = new JPanel();
		pnlMainRaporteCover.setBackground(new Color(255, 255, 255));
		pnlMainRaporte.add(pnlMainRaporteCover);
		pnlMainRaporteCover.setBounds(0, 0, 795, 623);
		pnlMainRaporteCover.setLayout(null);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		JPanel pnlRaporti = new JPanel();
		pnlRaporti.setBackground(Color.WHITE);
		pnlRaporti.setBounds(68, 0, 631, 526);
		pnlMainRaporteCover.add(pnlRaporti);
		pnlRaporti.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(521, 0, 110, 105);
		pnlRaporti.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(frmMain.class.getResource("/image/logo1.png")));

		JLabel lblUniversitetitIPrishtines = new JLabel(lang.getString("UP"));
		lblUniversitetitIPrishtines.setBounds(217, 11, 180, 20);
		pnlRaporti.add(lblUniversitetitIPrishtines);
		lblUniversitetitIPrishtines.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblRaport = new JLabel(lang.getString("Rap"));
		lblRaport.setBounds(250, 35, 73, 20);
		pnlRaporti.add(lblRaport);
		lblRaport.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNumriIStudenteve = new JLabel(lang.getString("NrStudenteve"));
		lblNumriIStudenteve.setBounds(53, 117, 268, 14);
		pnlRaporti.add(lblNumriIStudenteve);
		lblNumriIStudenteve.setHorizontalAlignment(SwingConstants.RIGHT);

		txtNumriTotal = new JTextField();
		txtNumriTotal.setBounds(331, 115, 86, 20);
		pnlRaporti.add(txtNumriTotal);
		txtNumriTotal.setColumns(10);

		JLabel lblVitiIPare = new JLabel(lang.getString("Viti1"));
		lblVitiIPare.setBounds(0, 178, 139, 14);
		pnlRaporti.add(lblVitiIPare);
		lblVitiIPare.setHorizontalAlignment(SwingConstants.LEFT);

		txtViti1 = new JTextField();
		txtViti1.setBounds(141, 178, 135, 20);
		pnlRaporti.add(txtViti1);
		txtViti1.setColumns(10);

		JLabel lblIDyti = new JLabel(lang.getString("Viti2"));
		lblIDyti.setBounds(331, 178, 140, 14);
		pnlRaporti.add(lblIDyti);
		lblIDyti.setHorizontalAlignment(SwingConstants.LEFT);

		txtViti2 = new JTextField();
		txtViti2.setBounds(474, 178, 135, 20);
		pnlRaporti.add(txtViti2);
		txtViti2.setColumns(10);

		JLabel lblIKaterti = new JLabel(lang.getString("Viti4"));
		lblIKaterti.setBounds(331, 209, 140, 14);
		pnlRaporti.add(lblIKaterti);
		lblIKaterti.setHorizontalAlignment(SwingConstants.LEFT);

		txtViti4 = new JTextField();
		txtViti4.setBounds(474, 209, 135, 20);
		pnlRaporti.add(txtViti4);
		txtViti4.setColumns(10);

		txtViti3 = new JTextField();
		txtViti3.setBounds(141, 204, 135, 20);
		pnlRaporti.add(txtViti3);
		txtViti3.setColumns(10);

		JLabel lblITreti = new JLabel(lang.getString("Viti3"));
		lblITreti.setBounds(0, 209, 139, 14);
		pnlRaporti.add(lblITreti);
		lblITreti.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblTelekomunikacion = new JLabel(lang.getString("Tele"));
		lblTelekomunikacion.setBounds(331, 284, 140, 14);
		pnlRaporti.add(lblTelekomunikacion);
		lblTelekomunikacion.setHorizontalAlignment(SwingConstants.LEFT);

		txtTelekomunikacion = new JTextField();
		txtTelekomunikacion.setBounds(474, 284, 135, 20);
		pnlRaporti.add(txtTelekomunikacion);
		txtTelekomunikacion.setColumns(10);

		txtKompjuterike = new JTextField();
		txtKompjuterike.setBounds(141, 285, 135, 20);
		pnlRaporti.add(txtKompjuterike);
		txtKompjuterike.setColumns(10);

		JLabel lblKompjuterike = new JLabel(lang.getString("Ik"));
		lblKompjuterike.setBounds(0, 288, 139, 14);
		pnlRaporti.add(lblKompjuterike);
		lblKompjuterike.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblElektroenergjetike = new JLabel(lang.getString("Ener"));
		lblElektroenergjetike.setBounds(331, 318, 140, 14);
		pnlRaporti.add(lblElektroenergjetike);
		lblElektroenergjetike.setHorizontalAlignment(SwingConstants.LEFT);

		txtElektroenergjetike = new JTextField();
		txtElektroenergjetike.setBounds(474, 318, 135, 20);
		pnlRaporti.add(txtElektroenergjetike);
		txtElektroenergjetike.setColumns(10);

		txtElektronike = new JTextField();
		txtElektronike.setBounds(141, 315, 135, 20);
		pnlRaporti.add(txtElektronike);
		txtElektronike.setColumns(10);

		JLabel lblElektronike = new JLabel(lang.getString("Ele"));
		lblElektronike.setBounds(0, 322, 139, 14);
		pnlRaporti.add(lblElektronike);
		lblElektronike.setHorizontalAlignment(SwingConstants.LEFT);

		txtAutomatike = new JTextField();
		txtAutomatike.setBounds(141, 353, 135, 20);
		pnlRaporti.add(txtAutomatike);
		txtAutomatike.setColumns(10);

		JLabel lblAutomatike = new JLabel(lang.getString("Aut"));
		lblAutomatike.setBounds(0, 356, 139, 14);
		pnlRaporti.add(lblAutomatike);
		lblAutomatike.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblFemra = new JLabel(lang.getString("Femera"));
		lblFemra.setBounds(331, 440, 140, 14);
		pnlRaporti.add(lblFemra);
		lblFemra.setHorizontalAlignment(SwingConstants.LEFT);

		txtFemra = new JTextField();
		txtFemra.setBounds(474, 440, 135, 20);
		pnlRaporti.add(txtFemra);
		txtFemra.setColumns(10);

		txtMeshkuj = new JTextField();
		txtMeshkuj.setBounds(141, 441, 135, 20);
		pnlRaporti.add(txtMeshkuj);
		txtMeshkuj.setColumns(10);

		JLabel lblMeshkuj = new JLabel(lang.getString("Meshkuj"));
		lblMeshkuj.setBounds(0, 444, 139, 14);
		pnlRaporti.add(lblMeshkuj);
		lblMeshkuj.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel lblData = new JLabel();
		lblData.setBounds(418, 512, 101, 14);
		pnlRaporti.add(lblData);
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		JButton btnRuajRaportin = new JButton(lang.getString("Ruaj"));
		btnRuajRaportin.setBounds(422, 548, 165, 35);
		pnlMainRaporteCover.add(btnRuajRaportin);
		btnRuajRaportin.setBackground(Color.WHITE);

		JButton btnGjenero = new JButton(lang.getString("Gjenero"));
		btnGjenero.setBounds(226, 549, 165, 35);
		pnlMainRaporteCover.add(btnGjenero);
		btnGjenero.setBackground(Color.WHITE);
		btnGjenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// numri total
				lblData.setText(formatter.format(date));
				//numri total
				try 
				{
					String query = "select count(*) as 'Totali' from studentet";
					pst=conn.prepareStatement(query);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtNumriTotal.setText(rez);
					}
				
				
				//Viti i pare
				
					String query1 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 1 or s.ssemestri = 2";
					pst=conn.prepareStatement(query1);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtViti1.setText(rez);
					}
					
				
				
				//Viti i dyte
				
					String query2 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 3 or s.ssemestri = 4";
					pst=conn.prepareStatement(query2);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtViti2.setText(rez);
					}
					
				
				
				//Viti i trete
					String query3 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 5 or s.ssemestri = 6";
					pst=conn.prepareStatement(query3);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtViti3.setText(rez);
					}
					
				
				
				//Viti i katert
					String query4 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 7 or s.ssemestri = 8";
					pst=conn.prepareStatement(query4);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtViti4.setText(rez);
					}
					
				
				
				//Inxhinieri Kompjuterike
					String query5 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 1";
					pst=conn.prepareStatement(query5);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtKompjuterike.setText(rez);
					}
					
				
				
				//Telekomunikacion
					
					String query6 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 3";
					pst=conn.prepareStatement(query6);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtTelekomunikacion.setText(rez);
					}
				
				//Elektroenergjetike
					String query7 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 2";
					pst=conn.prepareStatement(query7);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtElektroenergjetike.setText(rez);
					}
					
				
				//Elektronike
					String query8 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 4";
					pst=conn.prepareStatement(query8);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtElektronike.setText(rez);
					}
					
				
				//Automatike
					String query9 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 5";
					pst=conn.prepareStatement(query9);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtAutomatike.setText(rez);
					}
				
				
				//Gjithesejt meshkuj
					String query11 = "select count(*) as 'Totali' from studentet s where s.sgjinia = 'M'";
					pst=conn.prepareStatement(query11);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtMeshkuj.setText(rez);
					}
				
				//gjithesejt femra
					String query12 = "select count(*) as 'Totali' from studentet s where s.sgjinia = 'F'";
					pst=conn.prepareStatement(query12);
					res=pst.executeQuery();
					while(res.next())
					{
						String rez = res.getString("Totali");
						txtFemra.setText(rez);
					}
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Gabim gjate egzekutimit!!!");
				}

			}

		});
		btnRuajRaportin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				// print the panel to pdf
				Document document = new Document();
				try {
					JFileChooser chooser=new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("PDF file", "pdf");
					chooser.setDialogTitle("Save File");
					chooser.addChoosableFileFilter(filter);
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.setSelectedFile(new File("raporti.pdf"));
					int i=chooser.showSaveDialog(null);
					File f=chooser.getSelectedFile();
					String filename=f.getAbsolutePath();
					if(!filename.matches(".+[.]pdf$")) {
						f=new File(filename+".pdf");
					}
					if(i==JFileChooser.APPROVE_OPTION) {
						PdfWriter writer = PdfWriter.getInstance(document,
								new FileOutputStream(filename));
						document.open();
						PdfContentByte contentByte = writer.getDirectContent();
						PdfTemplate template = contentByte.createTemplate(795, 623);
						Graphics2D g2 = template.createGraphics(700, 550);
						pnlRaporti.print(g2);
						g2.dispose();
						contentByte.addTemplate(template, 8, 8);
						JOptionPane.showMessageDialog(null, lang.getString("RaportiPDF"));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, lang.getString("ErrorEkzekutim"));
				}

				finally {
					if (document.isOpen()) {
						document.close();
					}
				}
			}
		});

		/*
		 * PANELI I SEMESTER
		 */

		pnlMainSemestri = new JPanel();
		pnlMainSemestri.setForeground(new Color(0, 0, 204));
		pnlMainSemestri.setBackground(Color.WHITE);
		mainPanel.add(pnlMainSemestri, "name_71567668593893");
		pnlMainSemestri.setLayout(null);

		JPanel pnlMainSemestriCover = new JPanel();
		pnlMainSemestriCover.setBackground(Color.WHITE);
		pnlMainSemestriCover.setBounds(0, 0, 795, 623);
		pnlMainSemestri.add(pnlMainSemestriCover);
		pnlMainSemestriCover.setLayout(null);

		JLabel lblFilteriSemestri = new JLabel(lang.getString("kerkoE"));
		lblFilteriSemestri.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblFilteriSemestri.setBounds(209, 57, 121, 22);
		pnlMainSemestriCover.add(lblFilteriSemestri);

		txtKerkoSemestrin = new JTextField();
		txtKerkoSemestrin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					kerkoSemestrin();
				}
			}
		});
		txtKerkoSemestrin.setBorder(new LineBorder(new Color(0, 0, 204)));
		txtKerkoSemestrin.setBounds(327, 57, 150, 20);
		pnlMainSemestriCover.add(txtKerkoSemestrin);
		txtKerkoSemestrin.setColumns(10);

		 lblSemestriFilterError = new JLabel("");
		lblSemestriFilterError.setForeground(Color.RED);
		lblSemestriFilterError.setBounds(327, 80, 250, 20);
		pnlMainSemestriCover.add(lblSemestriFilterError);
		
				JButton btnKerkoSemestrin = new JButton(lang.getString("Search"));
				btnKerkoSemestrin.setBorder(null);
				btnKerkoSemestrin.setIcon(new ImageIcon(frmMain.class.getResource("/image/Search_24px.png")));
				btnKerkoSemestrin.setBackground(new Color(51, 153, 204));
				btnKerkoSemestrin.setForeground(new Color(255, 255, 255));
				btnKerkoSemestrin.setFont(new Font("Dialog", Font.BOLD, 13));
				btnKerkoSemestrin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnKerkoSemestrin.setBackground(new Color(15, 32, 73));
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						btnKerkoSemestrin.setBackground(new Color(51, 153, 204));

					}
					@Override
					public void mouseClicked(MouseEvent arg0) {
						kerkoSemestrin();
					}
				});
				btnKerkoSemestrin.setBounds(497, 56, 110, 24);
				pnlMainSemestriCover.add(btnKerkoSemestrin);
		
				JButton btnRegjistroSemestrin = new JButton(lang.getString("RegjistroS"));
				btnRegjistroSemestrin.setBorder(null);
				btnRegjistroSemestrin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnRegjistroSemestrin.setBackground(new Color(15, 32, 73));
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						btnRegjistroSemestrin.setBackground(new Color(51, 153, 204));

					}
					@Override
					public void mouseClicked(MouseEvent arg0) {
						regjistroSemestrin();
					}
				});
				btnRegjistroSemestrin.setBackground(new Color(51, 153, 204));
				btnRegjistroSemestrin.setForeground(Color.WHITE);
				btnRegjistroSemestrin.setFont(new Font("Dialog", Font.BOLD, 13));
				btnRegjistroSemestrin.setBounds(45, 527, 158, 23);
				pnlMainSemestriCover.add(btnRegjistroSemestrin);

		JScrollPane scrollSemestri = new JScrollPane();
		scrollSemestri.setBounds(20, 102, 745, 400);
		pnlMainSemestriCover.add(scrollSemestri);

		tblSemestri = new javax.swing.JTable() {
			public Component prepareRenderer(TableCellRenderer ren, int r, int c) {
				Component com = super.prepareRenderer(ren, r, c);
				if (r % 2 == 0 && !isRowSelected(r)) {
					com.setBackground(new Color(135, 175, 255));
					com.setForeground(Color.black);
				} else if (isRowSelected(r)) {
					com.setBackground(Color.blue);
					com.setForeground(Color.white);
				} else {
					com.setBackground(Color.white);
					com.setForeground(Color.black);
				}

				return com;
			}
		};
		Theader = tblSemestri.getTableHeader();
		Theader.setBackground(new Color(4, 11, 66));
		Theader.setForeground(Color.WHITE);
		Theader.setFont(new Font("Tahome", Font.BOLD, 11));
		tblSemestri.setFont(new Font("Tahome", Font.BOLD, 10));

		tblSemestri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				DefaultTableModel model = (DefaultTableModel) tblSemestri.getModel();
				id = (int) model.getValueAt(tblSemestri.getSelectedRow(), 0);
				}
				catch(Exception e) {					
				}

			}
		});
		scrollSemestri.setViewportView(tblSemestri);

		/*
		 * KONTAKT PANEL
		 */
		pnlMainContact = new JPanel();
		pnlMainContact.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainContact, "name_71631446812813");
		pnlMainContact.setLayout(null);

		JPanel pnlMainContactCover = new JPanel();
		pnlMainContactCover.setBackground(new Color(255, 255, 255));
		pnlMainContactCover.setBounds(0, 0, 795, 623);
		pnlMainContact.add(pnlMainContactCover);
		pnlMainContactCover.setLayout(null);

		JLabel lblSupport = new JLabel(lang.getString("WeAreNearYou"));
		lblSupport.setFont(new Font("Gisha", Font.PLAIN, 20));
		lblSupport.setBounds(282, 102, 292, 29);
		pnlMainContactCover.add(lblSupport);

		JLabel lblTel = new JLabel(lang.getString("tel"));
		lblTel.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblTel.setBounds(329, 194, 46, 29);
		pnlMainContactCover.add(lblTel);

		JLabel iconTel = new JLabel("");
		iconTel.setIcon(new ImageIcon(frmMain.class.getResource("/image/Phone_40px.png")));
		iconTel.setBounds(282, 188, 40, 40);
		pnlMainContactCover.add(iconTel);

		JLabel lblEmail_1 = new JLabel(lang.getString("email"));
		lblEmail_1.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblEmail_1.setBounds(329, 255, 46, 29);
		pnlMainContactCover.add(lblEmail_1);

		JLabel lblAdresaKontaktit = new JLabel(lang.getString("address"));
		lblAdresaKontaktit.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblAdresaKontaktit.setBounds(329, 321, 100, 29);
		pnlMainContactCover.add(lblAdresaKontaktit);

		JLabel lblEmailInfo = new JLabel("spms@contact.us");
		lblEmailInfo.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblEmailInfo.setBounds(407, 255, 199, 29);
		pnlMainContactCover.add(lblEmailInfo);

		JLabel lblTelInfo = new JLabel(" +38344100100");
		lblTelInfo.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblTelInfo.setBounds(407, 190, 199, 33);
		pnlMainContactCover.add(lblTelInfo);

		JLabel lblAdresaInfo = new JLabel("Bregu i Diellit, Prishtine 10000");
		lblAdresaInfo.setFont(new Font("Gisha", Font.PLAIN, 16));
		lblAdresaInfo.setBounds(407, 321, 263, 29);
		pnlMainContactCover.add(lblAdresaInfo);

		JLabel iconEmail = new JLabel("");
		iconEmail.setIcon(new ImageIcon(frmMain.class.getResource("/image/Gmail_40px.png")));
		iconEmail.setBounds(282, 249, 40, 40);
		pnlMainContactCover.add(iconEmail);

		JLabel iconAdresa = new JLabel("");
		iconAdresa.setIcon(new ImageIcon(frmMain.class.getResource("/image/Home_40px.png")));
		iconAdresa.setBounds(282, 315, 40, 40);
		pnlMainContactCover.add(iconAdresa);

		/*
		 * PANELI MESAZHI
		 */
		pnlMainMessage = new JPanel();
		pnlMainMessage.setBackground(new Color(255, 255, 255));
		mainPanel.add(pnlMainMessage, "name_71659085288491");
		pnlMainMessage.setLayout(null);

		JPanel pnlMainMessageCover = new JPanel();
		pnlMainMessageCover.setBackground(new Color(255, 255, 255));
		pnlMainMessageCover.setBounds(0, 0, 795, 623);
		pnlMainMessage.add(pnlMainMessageCover);
		pnlMainMessageCover.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 170, 660, 332);
		pnlMainMessageCover.add(scrollPane);

		txtMessage1 = new JTextPane();
		txtMessage1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER) {
					dergoMesazhin();
				}
			}
		});
		txtMessage1.setFont(new Font("Gisha", Font.PLAIN, 16));
		scrollPane.setViewportView(txtMessage1);

		JPanel pnlToolbox = new JPanel();
		pnlToolbox.setBounds(67, 50, 660, 101);
		pnlMainMessageCover.add(pnlToolbox);
		pnlToolbox.setLayout(null);

		JSlider slider = new JSlider();
		slider.setBounds(229, 52, 200, 38);
		pnlToolbox.add(slider);
		slider.setMinimum(50);
		slider.setMaximum(300);
		slider.setValue(100);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		JPanel pnlTextColor = new JPanel();
		pnlTextColor.setBackground(Color.WHITE);
		pnlTextColor.setBounds(145, 11, 155, 25);
		pnlToolbox.add(pnlTextColor);
		pnlTextColor.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(2, 0, 25, 25);
		pnlTextColor.add(label_1);
		label_1.setIcon(new ImageIcon(frmMain.class.getResource("/image/TextColor_25px.png")));

		JButton btnTextColor = new JButton(lang.getString("TextC"));
		btnTextColor.setBackground(SystemColor.textHighlight);
		btnTextColor.setFocusPainted(false);
		btnTextColor.setBounds(0, 0, 155, 25);
		pnlTextColor.add(btnTextColor);
		btnTextColor.setOpaque(false);
		btnTextColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Please select a color", Color.BLUE);
				int red=c.getRed();
				int blue=c.getBlue();
				int green=c.getGreen();
				ngjyra="color: rgb("+red+","+green+","+blue+");";
				txtMessage1.setForeground(c);
			}
		});

		JPanel pnlBackgroundColor = new JPanel();
		pnlBackgroundColor.setBackground(Color.WHITE);
		pnlBackgroundColor.setBounds(310, 11, 179, 25);
		pnlToolbox.add(pnlBackgroundColor);
		pnlBackgroundColor.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(6, 0, 25, 25);
		pnlBackgroundColor.add(label_2);
		label_2.setIcon(new ImageIcon(frmMain.class.getResource("/image/FillColor_25px.png")));

		JButton btnBackgroundColor = new JButton(lang.getString("BackgroundC"));
		btnBackgroundColor.setFocusPainted(false);
		btnBackgroundColor.setBackground(SystemColor.textHighlight);
		btnBackgroundColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Please select a color", Color.BLUE);
				int red=c.getRed();
				int blue=c.getBlue();
				int green=c.getGreen();
				ngjyraSfondit="background-color: rgb("+red+","+green+","+blue+");";
				txtMessage1.setBackground(c);
			}
		});
		btnBackgroundColor.setBounds(6, 0, 179, 25);
		pnlBackgroundColor.add(btnBackgroundColor);
		btnBackgroundColor.setOpaque(false);

		JLabel lblLeft = new JLabel("");
		lblLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet left = new SimpleAttributeSet();
				StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
				doc.setParagraphAttributes(0, doc.getLength(), left, false);
				align="text-align:left;";
			}
		});
		lblLeft.setIcon(new ImageIcon(frmMain.class.getResource("/image/Align Left_25px.png")));
		lblLeft.setBounds(523, 11, 25, 25);
		pnlToolbox.add(lblLeft);

		JLabel lblCenter = new JLabel("");
		lblCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);
				align="text-align:center;";
			}
		});
		lblCenter.setIcon(new ImageIcon(frmMain.class.getResource("/image/Align Center_25px.png")));
		lblCenter.setBounds(558, 11, 25, 25);
		pnlToolbox.add(lblCenter);

		JLabel lblRight = new JLabel("");
		lblRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet right = new SimpleAttributeSet();
				StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
				doc.setParagraphAttributes(0, doc.getLength(), right, false);
				align="text-align:right;";
			}
		});
		lblRight.setIcon(new ImageIcon(frmMain.class.getResource("/image/Align Right_25px.png")));
		lblRight.setBounds(593, 11, 25, 25);
		pnlToolbox.add(lblRight);

		JToggleButton btnBold = new JToggleButton("");
		btnBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet bold = new SimpleAttributeSet();
				if (btnBold.isSelected()) {
					StyleConstants.setBold(bold, true);
					doc.setParagraphAttributes(0, doc.getLength(), bold, false);
					boldAttr="font-weight:bold;";
				} else {
					StyleConstants.setBold(bold, false);
					doc.setParagraphAttributes(0, doc.getLength(), bold, false);
					boldAttr="font-weight:normal;";
				}
			}
		});
		btnBold.setFocusPainted(false);
		btnBold.setContentAreaFilled(false);
		btnBold.setBorderPainted(false);
		btnBold.setBorder(null);
		btnBold.setBackground(Color.WHITE);
		btnBold.setIcon(new ImageIcon(frmMain.class.getResource("/image/Bold_25px.png")));
		btnBold.setBounds(10, 11, 25, 25);
		pnlToolbox.add(btnBold);

		JToggleButton btnItalic = new JToggleButton("");
		btnItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet italic = new SimpleAttributeSet();
				if (btnItalic.isSelected()) {
					StyleConstants.setItalic(italic, true);
					doc.setParagraphAttributes(0, doc.getLength(), italic, false);
					italicAttr="font-style:italic;";
				} else {
					StyleConstants.setItalic(italic, false);
					doc.setParagraphAttributes(0, doc.getLength(), italic, false);
					italicAttr="font-style:plain;";
				}
			}
		});
		btnItalic.setIcon(new ImageIcon(frmMain.class.getResource("/image/Italic_25px.png")));
		btnItalic.setFocusPainted(false);
		btnItalic.setContentAreaFilled(false);
		btnItalic.setBorderPainted(false);
		btnItalic.setBorder(null);
		btnItalic.setBackground(Color.WHITE);
		btnItalic.setBounds(45, 11, 25, 25);
		pnlToolbox.add(btnItalic);

		JToggleButton btnUnderline = new JToggleButton("");
		btnUnderline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = txtMessage1.getStyledDocument();
				SimpleAttributeSet underline = new SimpleAttributeSet();
				if (btnUnderline.isSelected()) {
					StyleConstants.setUnderline(underline, true);
					doc.setParagraphAttributes(0, doc.getLength(), underline, false);
					underlineAttr="text-decoration: underline;";
				} else {
					StyleConstants.setUnderline(underline, false);
					doc.setParagraphAttributes(0, doc.getLength(), underline, false);
					underlineAttr="text-decoration: none;";
				}
			}
		});
		btnUnderline.setIcon(new ImageIcon(frmMain.class.getResource("/image/Underline_25px.png")));
		btnUnderline.setFocusPainted(false);
		btnUnderline.setContentAreaFilled(false);
		btnUnderline.setBorderPainted(false);
		btnUnderline.setBorder(null);
		btnUnderline.setBackground(Color.WHITE);
		btnUnderline.setBounds(80, 11, 25, 25);
		pnlToolbox.add(btnUnderline);

		JButton btnDergoMesazhin = new JButton(lang.getString("Dergo"));
		btnDergoMesazhin.setBorder(null);
		btnDergoMesazhin.setBounds(311, 537, 174, 39);
		pnlMainMessageCover.add(btnDergoMesazhin);
		btnDergoMesazhin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dergoMesazhin();
			}
		});
		btnDergoMesazhin.setFont(new Font("Gisha", Font.PLAIN, 16));
		btnDergoMesazhin.setFocusPainted(false);
		btnDergoMesazhin.setForeground(SystemColor.text);
		btnDergoMesazhin.setBackground(SystemColor.textHighlight);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				fontSize = 16 * slider.getValue() / 100;
				htmlFontSize="font-size:"+fontSize+"px;";
				txtMessage1.setFont(new Font("Gisha", Font.PLAIN, fontSize));
			}
		});

		JLabel lblExit = new JLabel("");
		lblExit.setBounds(763, 0, 32, 27);
		dragPanel.add(lblExit);
		int lblExitX = lblExit.getX();
		lblExit.setIcon(new ImageIcon(frmMain.class.getResource("/image/images.png")));
		lblExit.setVerifyInputWhenFocusTarget(false);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				threadStop=true;
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setBackground(Color.red);
				lblExit.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setBackground(null);
				lblExit.setOpaque(false);
			}
		});
		lblExit.setOpaque(false);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblMinimize = new JLabel("");
		lblMinimize.setBounds(731, 0, 32, 27);
		int lblMinimizeX = lblMinimize.getX();
		dragPanel.add(lblMinimize);
		lblMinimize.setIcon(new ImageIcon(frmMain.class.getResource("/image/minimize.png")));
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMinimize.setBackground(Color.LIGHT_GRAY);
				lblMinimize.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMinimize.setBackground(null);
				lblMinimize.setOpaque(false);

			}
		});
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 260, 650);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);

		/*
		 * Lock Fields
		 */
		lblLock = new JLabel("");
		lblLock.setToolTipText(lang.getString("LockMenus"));
		lblLock.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLock.setHorizontalAlignment(SwingConstants.LEFT);
		lblLock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (locked == 0) {
					locked++;
					lblLock.setIcon(new ImageIcon(frmMain.class.getResource("/image/Lock_24px.png")));

				} else {
					locked = 0;
					lblLock.setIcon(new ImageIcon(frmMain.class.getResource("/image/Padlock_24px.png")));
				}
			}
		});

		JSeparator sepMenu1 = new JSeparator();
		sepMenu1.setForeground(new Color(255, 255, 255));
		sepMenu1.setVisible(false);

		lblHome = new JLabel("");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				homeActive = 1;
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(false);
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(false);
				pnlLeftContact.setVisible(false);
				pnlLeftMessage.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainHome);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("Home"));
			}
		});
		lblHome.setIcon(new ImageIcon(frmMain.class.getResource("/image/Home_24px.png")));
		lblHome.setBounds(13, 11, 24, 24);
		lblHome.setVisible(true);

		JPanel pnlContact = new JPanel();
		pnlContact.setToolTipText(lang.getString("Kontakto"));
		pnlContact.setOpaque(false);
		pnlContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftContact.setVisible(true);
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(false);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				mainPanel.removeAll();
				mainPanel.add(pnlMainContact);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				lblTitle.setText(lang.getString("Kontakto"));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				pnlContact.setBackground(new Color(58, 88, 140));
				pnlContact.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlContact.setBackground(null);
				pnlContact.setOpaque(false);
			}
		});
		pnlContact.setBounds(0, 600, 50, 50);
		menuPanel.add(pnlContact);
		pnlContact.setLayout(null);

		pnlLeftContact = new JPanel();
		pnlLeftContact.setBounds(0, 0, 6, 50);
		pnlContact.add(pnlLeftContact);

		JLabel lblContactIcon = new JLabel("New label");
		lblContactIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Phone_24px.png")));
		lblContactIcon.setBounds(13, 0, 37, 50);
		pnlContact.add(lblContactIcon);
		pnlLeftContact.setVisible(false);

		JPanel pnlMessage = new JPanel();
		pnlMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(false);
				pnlLeftMessage.setVisible(true);
				homeActive = 0;
				pnlLeftContact.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainMessage);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblArrowRight.setEnabled(false);
				lblArrowLeft.setEnabled(true);
				lblTitle.setText(lang.getString("DM"));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlMessage.setBackground(new Color(58, 88, 140));
				pnlMessage.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlMessage.setBackground(null);
				pnlMessage.setOpaque(false);
			}
		});
		pnlMessage.setOpaque(false);
		pnlMessage.setBounds(50, 600, 50, 50);
		menuPanel.add(pnlMessage);
		pnlMessage.setLayout(null);

		pnlLeftMessage = new JPanel();
		pnlLeftMessage.setBounds(0, 0, 6, 50);
		pnlMessage.add(pnlLeftMessage);

		JLabel lblMessageIcon = new JLabel("");
		lblMessageIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Message_24px.png")));
		lblMessageIcon.setBounds(13, 0, 37, 50);
		pnlMessage.add(lblMessageIcon);
		pnlLeftMessage.setVisible(false);
		menuPanel.add(lblHome);
		sepMenu1.setOpaque(true);
		sepMenu1.setBackground(new Color(255, 255, 255));
		sepMenu1.setBounds(0, 125, 50, 3);
		menuPanel.add(sepMenu1);

		JSeparator sepMenu2 = new JSeparator();
		sepMenu2.setVisible(false);
		sepMenu2.setBackground(new Color(255, 255, 255));
		sepMenu2.setForeground(new Color(255, 255, 255));
		sepMenu2.setOpaque(true);
		sepMenu2.setBounds(0, 428, 50, 3);
		menuPanel.add(sepMenu2);
		lblLock.setIcon(new ImageIcon(frmMain.class.getResource("/image/Padlock_24px.png")));
		lblLock.setBounds(226, 60, 24, 24);
		menuPanel.add(lblLock);

		JLabel lblTitulli = new JLabel("SPMS");
		lblTitulli.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		lblTitulli.setForeground(Color.WHITE);
		lblTitulli.setBounds(53, 17, 173, 15);
		menuPanel.add(lblTitulli);

		panelStudentet = new JPanel();
		panelStudentet.setOpaque(false);
		panelStudentet.setBounds(0, 128, 260, 150);
		menuPanel.add(panelStudentet);
		panelStudentet.setLayout(null);

		JPanel pnlKerko = new JPanel();
		pnlKerko.setToolTipText(lang.getString("KEStudentet"));
		pnlKerko.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(true);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				pnlLeftContact.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainKerko);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("KEStudentet"));
				id=0;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlKerko.setBackground(new Color(58, 88, 140));
				pnlKerko.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlKerko.setBackground(null);
				pnlKerko.setOpaque(false);

			}
		});
		pnlKerko.setBounds(0, 100, 260, 50);
		panelStudentet.add(pnlKerko);
		pnlKerko.setLayout(null);
		pnlKerko.setOpaque(false);
		pnlKerko.setBorder(null);

		pnlLeftKerko = new JPanel();
		pnlLeftKerko.setVisible(false);
		pnlLeftKerko.setBounds(0, 0, 6, 50);
		pnlKerko.add(pnlLeftKerko);

		JLabel lblKerko = new JLabel(lang.getString("KE"));
		lblKerko.setHorizontalTextPosition(SwingConstants.CENTER);
		lblKerko.setForeground(Color.WHITE);
		lblKerko.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblKerko.setBounds(90, 9, 109, 32);
		pnlKerko.add(lblKerko);

		JLabel lblKerkoIcon = new JLabel("");
		lblKerkoIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Search_24px.png")));
		lblKerkoIcon.setBounds(45, 13, 24, 24);
		pnlKerko.add(lblKerkoIcon);

		JPanel pnlRegjistro = new JPanel();
		pnlRegjistro.setToolTipText(lang.getString("RSt"));
		pnlRegjistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftRegjistro.setVisible(true);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				pnlLeftContact.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainRegjistro);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RSt"));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlRegjistro.setBackground(new Color(58, 88, 140));
				pnlRegjistro.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlRegjistro.setBackground(null);
				pnlRegjistro.setOpaque(false);
			}
		});
		pnlRegjistro.setBounds(0, 50, 260, 50);
		panelStudentet.add(pnlRegjistro);
		pnlRegjistro.setLayout(null);
		pnlRegjistro.setOpaque(false);
		pnlRegjistro.setBorder(null);

		pnlLeftRegjistro = new JPanel();
		pnlLeftRegjistro.setVisible(false);
		pnlLeftRegjistro.setBounds(0, 0, 6, 50);
		pnlRegjistro.add(pnlLeftRegjistro);

		JLabel lblRegjistro = new JLabel(lang.getString("Regjistro"));
		lblRegjistro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegjistro.setForeground(Color.WHITE);
		lblRegjistro.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblRegjistro.setBounds(90, 9, 109, 32);
		pnlRegjistro.add(lblRegjistro);

		JLabel lblRegjistroIcon = new JLabel("");
		lblRegjistroIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Add User Male_24px.png")));
		lblRegjistroIcon.setBounds(45, 13, 24, 24);
		pnlRegjistro.add(lblRegjistroIcon);

		JPanel pnlStudentet = new JPanel();
		pnlStudentet.setToolTipText(lang.getString("MenaxhoSt"));
		pnlStudentet.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (panelStudentet.getHeight() < 60) {
					pnlStudentetClose.stop();
					pnStudentetOpen = 50;
					pnlStudentetOpen.start();
					lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				}
				if (panelStudentet.getHeight() >= 150) {
					if (locked == 0) {
						pnlStudentetOpen.stop();
						pnStudentetClose = 150;
						pnlStudentetClose.start();
						lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlStudentet.setBackground(new Color(58, 88, 140));
				pnlStudentet.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlStudentet.setBackground(null);
				pnlStudentet.setOpaque(false);
			}
		});

		pnlStudentet.setBounds(0, 0, 260, 50);
		panelStudentet.add(pnlStudentet);
		pnlStudentet.setBorder(null);
		pnlStudentet.setOpaque(false);
		pnlStudentet.setLayout(null);

		lblUpDown = new JLabel("");
		lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
		lblUpDown.setBounds(226, 13, 24, 24);
		pnlStudentet.add(lblUpDown);

		JLabel lblStudentetIcon = new JLabel("");
		lblStudentetIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/User_24px.png")));
		lblStudentetIcon.setBounds(13, 13, 24, 24);
		pnlStudentet.add(lblStudentetIcon);

		JLabel lblStudentet = new JLabel(lang.getString("Std"));
		lblStudentet.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblStudentet.setForeground(new Color(255, 255, 255));
		lblStudentet.setBounds(52, 9, 109, 32);
		pnlStudentet.add(lblStudentet);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 260, 2);
		menuPanel.add(separator);

		pnlRaportet = new JPanel();
		pnlRaportet.setToolTipText(lang.getString("RaportSt"));
		pnlRaportet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(true);
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				pnlLeftContact.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainRaporte);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RaportSt"));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlRaportet.setBackground(new Color(58, 88, 140));
				pnlRaportet.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlRaportet.setBackground(null);
				pnlRaportet.setOpaque(false);
			}
		});
		pnlRaportet.setBounds(0, 278, 260, 50);
		menuPanel.add(pnlRaportet);
		pnlRaportet.setLayout(null);
		pnlRaportet.setOpaque(false);
		pnlRaportet.setBorder(null);

		pnlLeftRaporte = new JPanel();
		pnlLeftRaporte.setVisible(false);
		pnlLeftRaporte.setBounds(0, 0, 6, 50);
		pnlRaportet.add(pnlLeftRaporte);

		JLabel lblRaporteIcon = new JLabel("");
		lblRaporteIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Document_24px.png")));
		lblRaporteIcon.setBounds(13, 13, 24, 24);
		pnlRaportet.add(lblRaporteIcon);

		JLabel lblRaporte = new JLabel(lang.getString("Raporte"));
		lblRaporte.setForeground(Color.WHITE);
		lblRaporte.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblRaporte.setBounds(52, 13, 109, 24);
		pnlRaportet.add(lblRaporte);

		JPanel settingsPanel = new JPanel();
		settingsPanel.setLayout(null);
		settingsPanel.setPreferredSize(new Dimension(180, 260));

		JLabel lblSettingsTitle = new JLabel(lang.getString("Settings"));
		lblSettingsTitle.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		lblSettingsTitle.setBounds(5, 8, 200, 35);
		settingsPanel.add(lblSettingsTitle);

		JSeparator settingsSep = new JSeparator();
		settingsSep.setForeground(Color.DARK_GRAY);
		settingsSep.setBounds(0, 48, 160, 2);
		settingsPanel.add(settingsSep);

		JPanel panelLanguage = new JPanel();
		panelLanguage.setBounds(0, 61, 200, 30);
		settingsPanel.add(panelLanguage);
		panelLanguage.setLayout(null);

		JPanel pnlLanguage = new JPanel();
		pnlLanguage.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlLanguage.setBackground(Color.LIGHT_GRAY);
				pnlLanguage.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlLanguage.setBackground(null);
				pnlLanguage.setOpaque(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (panelLanguage.getHeight() <= 30) {
					panelLanguageClose.stop();
					panelLanguageOpen.start();
					pnLanguageClose = 90;
				} else if (panelLanguage.getHeight() >= 90) {
					panelLanguageOpen.stop();
					panelLanguageClose.start();
					pnLanguageOpen = 30;

				}
			}
		});
		pnlLanguage.setBounds(0, 0, 200, 30);
		panelLanguage.add(pnlLanguage);
		pnlLanguage.setLayout(null);

		JLabel lblLanguageIcon = new JLabel("");
		lblLanguageIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Language_20px.png")));
		lblLanguageIcon.setBounds(5, 5, 20, 20);
		pnlLanguage.add(lblLanguageIcon);

		JLabel lblLanguage = new JLabel(lang.getString("ChooseLang"));
		lblLanguage.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblLanguage.setBounds(30, 0, 170, 30);
		pnlLanguage.add(lblLanguage);

		JPanel pnlAlbanian = new JPanel();
		pnlAlbanian.setBounds(0, 30, 200, 30);
		panelLanguage.add(pnlAlbanian);
		pnlAlbanian.setLayout(null);

		JLabel lblAlbIcon = new JLabel("");
		lblAlbIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/albanian.png")));
		lblAlbIcon.setBounds(20, 0, 30, 30);
		pnlAlbanian.add(lblAlbIcon);

		JLabel lblAlbanian = new JLabel(lang.getString("Albanian"));
		lblAlbanian.setBounds(50, 0, 150, 30);
		pnlAlbanian.add(lblAlbanian);

		JPanel pnlEnglish = new JPanel();

		pnlEnglish.setBounds(0, 60, 200, 30);
		panelLanguage.add(pnlEnglish);
		pnlEnglish.setLayout(null);

		JLabel lblEngIcon = new JLabel("");
		lblEngIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/britain.png")));
		lblEngIcon.setBounds(20, 0, 30, 30);
		pnlEnglish.add(lblEngIcon);
		JLabel lblEnglish = new JLabel(lang.getString("English"));
		lblEnglish.setBounds(50, 0, 150, 30);
		pnlEnglish.add(lblEnglish);

		JPanel pnlAboutUs = new JPanel();
		pnlAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlAboutUs.setBackground(Color.LIGHT_GRAY);
				pnlAboutUs.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlAboutUs.setBackground(null);
				pnlAboutUs.setOpaque(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				obj1 = new About();
				getGlassPane().setVisible(false);
				obj1.setVisible(true);
				obj1.setLocationRelativeTo(null);
			}
		});
		pnlAboutUs.setLayout(null);
		pnlAboutUs.setBounds(0, 91, 200, 30);
		settingsPanel.add(pnlAboutUs);
		pnlAboutUs.setBounds(0, 120, 200, 30);
		settingsPanel.add(pnlAboutUs);
		pnlAboutUs.setLayout(null);

		JLabel lblAboutIcon = new JLabel("");
		lblAboutIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/About_20px.png")));
		lblAboutIcon.setBounds(5, 5, 20, 20);
		pnlAboutUs.add(lblAboutIcon);

		JLabel lblAboutUs = new JLabel(lang.getString("About"));
		lblAboutUs.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblAboutUs.setBounds(35, 0, 165, 30);
		pnlAboutUs.add(lblAboutUs);

		JPanel pnlHelp = new JPanel();
		pnlHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlHelp.setBackground(Color.LIGHT_GRAY);
				pnlHelp.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlHelp.setBackground(null);
				pnlHelp.setOpaque(false);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				obj = new Help();
				getGlassPane().setVisible(false);
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		pnlHelp.setLayout(null);
		pnlHelp.setBounds(0, 91, 200, 30);
		settingsPanel.add(pnlHelp);

		JLabel lblHelpIcon = new JLabel("");
		lblHelpIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Help_20px.png")));
		lblHelpIcon.setBounds(5, 5, 20, 20);
		pnlHelp.add(lblHelpIcon);

		JLabel lblHelp = new JLabel(lang.getString("Help"));
		lblHelp.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblHelp.setBounds(35, 0, 165, 30);
		pnlHelp.add(lblHelp);

		((JComponent) getGlassPane()).setLayout(new FlowLayout(FlowLayout.LEFT, 260, 390));
		((JComponent) getGlassPane()).add(settingsPanel, BorderLayout.EAST);

		JLabel lblSettings = new JLabel("");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showHide();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblSettings.setBackground(new Color(58, 88, 140));
				lblSettings.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblSettings.setBackground(null);
				lblSettings.setOpaque(false);
			}
		});
		lblSettings.setToolTipText(lang.getString("Settings"));
		lblSettings.setIcon(new ImageIcon(frmMain.class.getResource("/image/Settings_24px.png")));
		lblSettings.setBounds(210, 600, 50, 50);
		menuPanel.add(lblSettings);

		getGlassPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component c = SwingUtilities.getDeepestComponentAt(getGlassPane(), e.getX(), e.getY());
				if (e.getComponent().equals(c)) {
					// metoda gjindet posht
					showHide();
				}
			}
		});
		panelSemestri = new JPanel();
		panelSemestri.setOpaque(false);
		panelSemestri.setBounds(0, 328, 260, 100);
		menuPanel.add(panelSemestri);
		panelSemestri.setLayout(null);

		JPanel pnlRegjistroSemestrin = new JPanel();
		pnlRegjistroSemestrin.setToolTipText("RS");
		pnlRegjistroSemestrin.setOpaque(false);
		pnlRegjistroSemestrin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlLeftRegjistro.setVisible(false);
				pnlLeftKerko.setVisible(false);
				pnlLeftRaporte.setVisible(false);
				pnlLeftRegjistroSemestrin.setVisible(true);
				lblArrowRight.setEnabled(true);
				lblArrowLeft.setEnabled(true);
				pnlLeftMessage.setVisible(false);
				homeActive = 0;
				pnlLeftContact.setVisible(false);
				mainPanel.removeAll();
				mainPanel.add(pnlMainSemestri);
				mainPanel.repaint();
				mainPanel.revalidate();
				lblTitle.setText(lang.getString("RS"));
				id=0;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlRegjistroSemestrin.setBackground(new Color(58, 88, 140));
				pnlRegjistroSemestrin.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlRegjistroSemestrin.setBackground(null);
				pnlRegjistroSemestrin.setOpaque(false);
			}
		});
		pnlRegjistroSemestrin.setBounds(0, 50, 260, 50);
		panelSemestri.add(pnlRegjistroSemestrin);
		pnlRegjistroSemestrin.setLayout(null);
		pnlRegjistroSemestrin.setBorder(null);

		pnlLeftRegjistroSemestrin = new JPanel();
		pnlLeftRegjistroSemestrin.setVisible(false);
		pnlLeftRegjistroSemestrin.setBounds(0, 0, 6, 50);
		pnlRegjistroSemestrin.add(pnlLeftRegjistroSemestrin);

		JLabel lblRegjistroSemestrinIcon = new JLabel("");
		lblRegjistroSemestrinIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Stripe_24px.png")));
		lblRegjistroSemestrinIcon.setBounds(45, 13, 24, 24);
		pnlRegjistroSemestrin.add(lblRegjistroSemestrinIcon);

		JLabel lblRegjistroSemestrin = new JLabel(lang.getString("RS"));
		lblRegjistroSemestrin.setForeground(Color.WHITE);
		lblRegjistroSemestrin.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblRegjistroSemestrin.setBounds(90, 13, 160, 24);
		pnlRegjistroSemestrin.add(lblRegjistroSemestrin);

		JPanel pnlSemestri = new JPanel();
		pnlSemestri.setToolTipText(lang.getString("S"));
		pnlSemestri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (panelSemestri.getHeight() < 60) {
					pnlSemestriTimer.start();
					lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));

				}

				else if (panelSemestri.getHeight() > 90) {
					if (locked == 0) {
						pnlSemestriTimer.stop();
						pnSemestriOpen = 50;
						lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
						panelSemestri.setSize(panelSemestri.getWidth(), pnSemestriOpen);

					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlSemestri.setBackground(new Color(58, 88, 140));
				pnlSemestri.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlSemestri.setBackground(null);
				pnlSemestri.setOpaque(false);
			}

		});

		pnlSemestri.setBounds(0, 0, 260, 50);
		panelSemestri.add(pnlSemestri);
		pnlSemestri.setLayout(null);
		pnlSemestri.setOpaque(false);
		pnlSemestri.setBorder(null);

		JLabel lblSemesterIcon = new JLabel("");
		lblSemesterIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/University_24px.png")));
		lblSemesterIcon.setBounds(13, 13, 24, 24);
		pnlSemestri.add(lblSemesterIcon);

		JLabel lblSemestri = new JLabel(lang.getString("S"));
		lblSemestri.setForeground(Color.WHITE);
		lblSemestri.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblSemestri.setBounds(52, 13, 180, 24);
		pnlSemestri.add(lblSemestri);

		lblUpDown1 = new JLabel("");
		lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
		lblUpDown1.setBounds(226, 13, 24, 24);
		pnlSemestri.add(lblUpDown1);

		JLabel lblMenuIcon = new JLabel("");
		lblMenuIcon.setToolTipText(lang.getString("SlideMenus"));
		lblMenuIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getGlassPane().setVisible(false);
				if (menuPanel.getWidth() >= 260) {
					pnlMenuMinimizeTimer.start();
					pnMenuClose = 260;
					((JComponent) getGlassPane()).setLayout(new FlowLayout(FlowLayout.LEFT, 50, 390));

				}
				if (menuPanel.getWidth() <= 60) {
					pnlMenuMaxTimer.start();
					pnMenuOpen = 60;
					((JComponent) getGlassPane()).setLayout(new FlowLayout(FlowLayout.LEFT, 260, 390));
				}
			}
		});
		lblMenuIcon.setIcon(new ImageIcon(frmMain.class.getResource("/image/Menu_24px.png")));
		lblMenuIcon.setBounds(13, 60, 24, 24);
		menuPanel.add(lblMenuIcon);

		JLabel lblBg = new JLabel("");
		lblBg.setOpaque(true);
		lblBg.setBackground(new Color(0, 0, 153));
		lblBg.setForeground(new Color(0, 0, 128));
		lblBg.setIcon(new ImageIcon(frmMain.class.getResource("/image/background.jpg")));
		lblBg.setBounds(0, 0, 260, 650);
		menuPanel.add(lblBg);

		lblArrowLeft = new JLabel("");
		lblArrowLeft.setEnabled(false);
		lblArrowLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			       changePanelsLeft();
				}

			
		});

		lblArrowLeft.setToolTipText(lang.getString("Previous"));
		lblArrowLeft.setIcon(new ImageIcon(frmMain.class.getResource("/image/Left Arrow_27px.png")));
		lblArrowLeft.setBounds(20, 0, 27, 27);
		dragPanel.add(lblArrowLeft);

		lblArrowRight = new JLabel("");
		lblArrowRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changePanelsRight();
				}

			
		});
		lblArrowRight.setToolTipText(lang.getString("Next"));
		lblArrowRight.setIcon(new ImageIcon(frmMain.class.getResource("/image/Right Arrow_27px.png")));
		lblArrowRight.setBounds(60, 0, 27, 27);
		dragPanel.add(lblArrowRight);

		JPanel pnlStatusBar = new JPanel();
		pnlStatusBar.setBounds(260, 627, 795, 23);
		contentPane.add(pnlStatusBar);
		pnlStatusBar.setLayout(null);

		lblIsRunning = new JLabel("");
		lblIsRunning.setText(lang.getString("AppStatus"));
		lblIsRunning.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsRunning.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIsRunning.setForeground(new Color(51, 153, 204));
		lblIsRunning.setBounds(0, 0, 250, 23);
		pnlStatusBar.add(lblIsRunning);

		lblStatusDate = new JLabel(lang.getString("Date"));
		lblStatusDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusDate.setForeground(new Color(51, 153, 204));
		lblStatusDate.setBounds(272, 0, 250, 23);
		pnlStatusBar.add(lblStatusDate);

		lblStatusTime = new JLabel(lang.getString("Time"));
		lblStatusTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusTime.setForeground(new Color(51, 153, 204));
		lblStatusTime.setBounds(545, 0, 250, 23);
		pnlStatusBar.add(lblStatusTime);

		pnlStudentetOpen = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 150 the maximum height
				if (pnStudentetOpen > 150) {
					pnlStudentetOpen.stop();
				} else {
					panelStudentet.setSize(panelStudentet.getWidth(), panelStudentet.getHeight() + 10);
					// me 10 nuk arrihet 328 apo 278 qe eshte largesia y e pnlSemestri dhe
					// onlRaportet respektivisht
					// andaj perdorim 9 qe te arrihen vlerat 328 apo 278
					panelSemestri.setLocation(0, panelSemestri.getY() + 9);
					pnlRaportet.setLocation(0, pnlRaportet.getY() + 9);
					pnStudentetOpen += 10;

				}

			}
		});
		pnlStudentetClose = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 150 the maximum height
				if (pnStudentetClose < 50) {
					pnlStudentetClose.stop();
				} else {
					panelStudentet.setSize(panelStudentet.getWidth(), pnStudentetClose);
					// me 10 nuk arrihet 328 apo 278 qe eshte largesia y e pnlSemestri dhe
					// pnlRaportet respektivisht
					// andaj perdorim 9 qe te arrihen vlerat 328 apo 278
					panelSemestri.setLocation(0, panelSemestri.getY() - 9);
					pnlRaportet.setLocation(0, pnlRaportet.getY() - 9);
					pnStudentetClose -= 10;

				}

			}
		});
		pnlSemestriTimer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 100 max height
				if (pnSemestriOpen > 100) {
					pnlSemestriTimer.stop();
				} else {
					pnSemestriOpen += 10;
					panelSemestri.setSize(panelSemestri.getWidth(), pnSemestriOpen);

				}

			}
		});
		int mainPanelWidth = mainPanel.getWidth();
		int dragPanelWidth = dragPanel.getWidth();
		pnlMenuMinimizeTimer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pnMenuClose < 60) {
					pnlMenuMinimizeTimer.stop();
				} else {
					lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
					lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Collapse Arrow_24px.png")));
					menuPanel.setSize(pnMenuClose, menuPanel.getHeight());
					lblBg.setSize(lblBg.getWidth() - 10, lblBg.getHeight());
					dragPanel.setLocation(dragPanel.getX() - 10, dragPanel.getY());
					pnlStatusBar.setLocation(pnlStatusBar.getX()-10,pnlStatusBar.getY());
					mainPanel.setLocation(mainPanel.getX() - 10, mainPanel.getY());
					if (mainPanel.getX() == 100) {
						pnlMainHomeCover.setLocation(100, pnlMainHomeCover.getY());
						pnlMainRegjistroCover.setLocation(100, pnlMainRegjistroCover.getY());
						pnlMainKerkoCover.setLocation(100, pnlMainKerkoCover.getY());
						pnlMainRaporteCover.setLocation(100, pnlMainRaporteCover.getY());
						pnlMainSemestriCover.setLocation(100, pnlMainSemestriCover.getY());
						pnlMainContactCover.setLocation(100, pnlMainContactCover.getY());
						pnlMainMessageCover.setLocation(100, pnlMainMessageCover.getY());
					}
					pnlStudentet.setSize(pnlStudentet.getWidth() - 10, pnlStudentet.getHeight());
					panelStudentet.setSize(panelStudentet.getWidth() - 10, panelStudentet.getHeight());
					pnlRaportet.setSize(pnlRaportet.getWidth() - 10, pnlRaportet.getHeight());
					panelSemestri.setSize(panelSemestri.getWidth() - 10, panelSemestri.getHeight());

					pnlKerko.setSize(pnlKerko.getWidth() - 10, pnlKerko.getHeight());
					pnlRegjistro.setSize(pnlRegjistro.getWidth() - 10, pnlRegjistro.getHeight());
					pnlSemestri.setSize(pnlSemestri.getWidth() - 10, pnlSemestri.getHeight());
					pnlRegjistroSemestrin.setSize(pnlRegjistroSemestrin.getWidth() - 10,
							pnlRegjistroSemestrin.getHeight());

					shtesa = 60;
					mainPanel.setSize(mainPanel.getWidth() + 10, mainPanel.getHeight());
					dragPanel.setSize(dragPanel.getWidth() + 10, dragPanel.getHeight());
					pnlStatusBar.setSize(pnlStatusBar.getWidth()+10,pnlStatusBar.getHeight());
					lblStatusTime.setLocation(lblStatusTime.getX()+10,lblStatusTime.getY());
					lblExit.setLocation(lblExit.getX() + 10, 0);
					lblMinimize.setLocation(lblMinimize.getX() + 10, 0);

					
					if(pnlStatusBar.getX()<155) {
						lblStatusDate.setLocation(lblStatusDate.getX()+10,lblStatusDate.getY());
					}
					
					if (lblSettings.getX() != 0) {
						lblSettings.setLocation(lblSettings.getX() - 10, lblSettings.getY());
					}

					if (lblSettings.getX() == 90) {
						lblSettings.setLocation(0, 600);
						pnlContact.setLocation(0, 500);
						pnlMessage.setLocation(0, 550);
						lblTitulli.setVisible(false);
					}

					if (lblBg.getWidth() == 50) {
						lblKerkoIcon.setLocation(13, lblKerkoIcon.getY());
						lblRegjistroIcon.setLocation(13, lblRegjistroIcon.getY());
						lblRegjistroSemestrinIcon.setLocation(13, lblRegjistroSemestrinIcon.getY());
						panelStudentet.setSize(260, 150);
						panelSemestri.setSize(260, 100);
						panelSemestri.setLocation(0, 328);
						pnlRaportet.setLocation(0, 278);
						// ktu tek 10 eshte dasht me qene 13 si tek ikonat tjera po ikona eshte ma
						// ndryshe per ata e vendosim 10
						lblLock.setLocation(10, 90);
						sepMenu1.setVisible(true);
						sepMenu2.setVisible(true);
					}
					if (lblLock.getX() != 10) {
						lblLock.setLocation(lblLock.getX() - 10, lblLock.getY());
					}
					pnMenuClose -= 10;

				}

			}
		});

		pnlMenuMaxTimer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pnMenuOpen > 260) {
					pnlMenuMaxTimer.stop();
				} else {
					lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
					lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
					menuPanel.setSize(pnMenuOpen, menuPanel.getHeight());
					lblBg.setSize(lblBg.getWidth() + 10, lblBg.getHeight());
					dragPanel.setLocation(dragPanel.getX() + 10, dragPanel.getY());
					pnlStatusBar.setLocation(pnlStatusBar.getX()+10,pnlStatusBar.getY());
					mainPanel.setLocation(mainPanel.getX() + 10, mainPanel.getY());
					if (mainPanel.getX() == 100) {
						pnlMainHomeCover.setLocation(0, pnlMainHomeCover.getY());
						pnlMainRegjistroCover.setLocation(0, pnlMainRegjistroCover.getY());
						pnlMainKerkoCover.setLocation(0, pnlMainKerkoCover.getY());
						pnlMainRaporteCover.setLocation(0, pnlMainRaporteCover.getY());
						pnlMainSemestriCover.setLocation(0, pnlMainSemestriCover.getY());
						pnlMainContactCover.setLocation(0, pnlMainContactCover.getY());
						pnlMainMessageCover.setLocation(0, pnlMainMessageCover.getY());

					}
					shtesa = 260;
					pnlStudentet.setSize(pnlStudentet.getWidth() + 10, pnlStudentet.getHeight());
					pnlRaportet.setSize(pnlRaportet.getWidth() + 10, pnlRaportet.getHeight());
					lblKerkoIcon.setLocation(45, lblKerkoIcon.getY());
					lblRegjistroIcon.setLocation(45, lblRegjistroIcon.getY());
					pnlKerko.setSize(pnlKerko.getWidth() + 10, pnlKerko.getHeight());
					pnlRegjistro.setSize(pnlRegjistro.getWidth() + 10, pnlRegjistro.getHeight());
					pnlSemestri.setSize(pnlSemestri.getWidth() + 10, pnlSemestri.getHeight());
					pnlRegjistroSemestrin.setSize(pnlRegjistroSemestrin.getWidth() + 10,
							pnlRegjistroSemestrin.getHeight());
					lblRegjistroSemestrinIcon.setLocation(43, lblRegjistroSemestrinIcon.getY());
					lblStatusTime.setLocation(lblStatusTime.getX()-10,lblStatusTime.getY());
					lblExit.setLocation(lblExit.getX() - 10, 0);
					lblMinimize.setLocation(lblMinimize.getX() - 10, 0);
					sepMenu1.setVisible(false);
					sepMenu2.setVisible(false);
					lblSettings.setLocation(lblSettings.getX() + 10, lblSettings.getY());
					pnlContact.setLocation(0, 600);
					pnlMessage.setLocation(50, 600);
					if(pnlStatusBar.getX()>155) {
						lblStatusDate.setLocation(lblStatusDate.getX()-10,lblStatusDate.getY());
					}
					
					if (lblBg.getWidth() == 50) {
						lblLock.setLocation(50, 90);
					} else {
						lblLock.setLocation(lblLock.getX() + 10, 60);
					}

					panelStudentet.setSize(260, 150);
					panelSemestri.setSize(260, 100);
					panelSemestri.setLocation(0, 328);
					pnlRaportet.setLocation(0, 278);
					lblTitulli.setVisible(true);
					pnMenuOpen += 10;

				}

			}

		});

		panelLanguageClose = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnLanguageClose < 30) {
					panelLanguageClose.stop();
				} else {
					panelLanguage.setSize(panelLanguage.getWidth(), pnLanguageClose);
					pnlHelp.setLocation(pnlHelp.getX(), pnlHelp.getY() - 9);
					pnlAboutUs.setLocation(pnlAboutUs.getX(), pnlAboutUs.getY() - 9);
					pnLanguageClose -= 10;
				}

			}

		});
		panelLanguageOpen = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnLanguageOpen > 90) {
					panelLanguageOpen.stop();
				} else {
					panelLanguage.setSize(panelLanguage.getWidth(), pnLanguageOpen);
					pnlHelp.setLocation(pnlHelp.getX(), pnlHelp.getY() + 9);
					pnlAboutUs.setLocation(pnlAboutUs.getX(), pnlAboutUs.getY() + 9);
					pnLanguageOpen += 10;
				}

			}

		});
		setUndecorated(true);
		// GJUHA
		// Ndryshimi i gjuhes

		pnlAlbanian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				currentLang = new Locale("AL");
				lang = ResourceBundle.getBundle("Language", currentLang);
				lblEmri.setText(lang.getString("name"));
				lblMbiemri.setText(lang.getString("surname"));
				lblDitelindja.setText(lang.getString("birthday"));
				lblPersonalNr.setText(lang.getString("personalNumber"));
				lblPrindi.setText(lang.getString("parent"));
				lblShteti.setText(lang.getString("country"));
				lblQyteti.setText(lang.getString("city"));
				lblAdresa.setText(lang.getString("address"));
				lblNrtel.setText(lang.getString("tel"));
				lblEmail.setText(lang.getString("email"));
				lblGjinia.setText(lang.getString("gender"));
				lblFakulteti.setText(lang.getString("faculty"));
				lblDrejtimi.setText(lang.getString("branch"));
				lblStatusi.setText(lang.getString("status"));
				rdbtnMashkull.setText(lang.getString("male"));
				rdbtnFemer.setText(lang.getString("female"));
				rdbtnIRregullt.setText(lang.getString("regular"));
				rdbtnMeKorrospodence.setText(lang.getString("correspondence"));
				lblNiveli.setText(lang.getString("nivel"));
				btnRegjistroStudentet.setText(lang.getString("Regjistro"));
				lblRegjistro.setText(lang.getString("Regjistro"));
				btnZgjedh.setText(lang.getString("Zgjedh"));
				lblInformatatKontaktuese.setText(lang.getString("InfoK"));
				lblInformatatAdministrative.setText(lang.getString("InfoA"));
				lblInfoBaze.setText(lang.getString("InfoB"));
				lblStudentet.setText(lang.getString("Std"));
				lblKerko.setText(lang.getString("KE"));
				lblRaporte.setText(lang.getString("Raporte"));
				lblSemestri.setText(lang.getString("S"));
				lblRegjistroSemestrin.setText(lang.getString("RS"));
				btnRegjistroStudentet.setText(lang.getString("RSt"));
				lblKerkoSipas.setText(lang.getString("Menyra"));
				btnEdit.setText(lang.getString("Edit"));
				btnDelete.setText(lang.getString("Delete"));
				lblUniversitetitIPrishtines.setText(lang.getString("UP"));
				btnRegjistroSemestrin.setText(lang.getString("RegjistroS"));
				lblNumriIStudenteve.setText(lang.getString("NrStudenteve"));
				lblITreti.setText(lang.getString("Viti3"));
				lblVitiIPare.setText(lang.getString("Viti1"));
				lblIDyti.setText(lang.getString("Viti2"));
				lblIKaterti.setText(lang.getString("Viti4"));
				/*ketu ndrysho*/
				lblTelekomunikacion.setText(lang.getString("Tele"));
				lblElektronike.setText(lang.getString("Ele"));
				lblAutomatike.setText(lang.getString("Aut"));
				lblKompjuterike.setText(lang.getString("Ik"));
				lblElektroenergjetike.setText(lang.getString("Ener"));
				lblFemra.setText(lang.getString("Femera"));
				lblMeshkuj.setText(lang.getString("Meshkuj"));
				btnRuajRaportin.setText(lang.getString("Ruaj"));
				btnGjenero.setText(lang.getString("Gjenero"));
				lblRaport.setText(lang.getString("Rap"));
				btnKerkoSemestrin.setText(lang.getString("Search"));
				lblFilteriSemestri.setText(lang.getString("kerkoE"));
				btnDergoMesazhin.setText(lang.getString("Dergo"));
				btnTextColor.setText(lang.getString("TextC"));
				btnBackgroundColor.setText(lang.getString("BackgroundC"));
				lblSupport.setText(lang.getString("WeAreNearYou"));
				lblAdresaKontaktit.setText(lang.getString("address"));
				lblRaporti.setText(lang.getString("RaportSt"));
				lblDergoMesazh.setText(lang.getString("DM"));
				lblKerkoStudentet.setText(lang.getString("KEStudentet"));
				lblRegjistroSemestrin_1.setText(lang.getString("RS"));
				lblRegjistroPerdorues.setText(lang.getString("RSt"));
				lblKontaktoSherbimin.setText(lang.getString("Kontakto"));
				lblHelp.setText(lang.getString("Help"));
				lblAlbanian.setText(lang.getString("Albanian"));
				lblEnglish.setText(lang.getString("English"));
				lblAboutUs.setText(lang.getString("About"));
				lblLanguage.setText(lang.getString("ChooseLang"));
				lblLock.setToolTipText(lang.getString("LockMenus"));		
				pnlContact.setToolTipText(lang.getString("Kontakto"));
				pnlKerko.setToolTipText(lang.getString("KEStudentet"));
				pnlRegjistro.setToolTipText(lang.getString("RSt"));
				pnlStudentet.setToolTipText(lang.getString("MenaxhoSt"));
				pnlRaportet.setToolTipText(lang.getString("RaportSt"));
				pnlRegjistroSemestrin.setToolTipText("RS");
				pnlSemestri.setToolTipText(lang.getString("S"));
				lblMenuIcon.setToolTipText(lang.getString("SlideMenus"));
				lblArrowLeft.setToolTipText(lang.getString("Previous"));
				lblArrowRight.setToolTipText(lang.getString("Next"));
				lblSistemiPerMenaxhimin.setText(lang.getString("SPMS"));
				lblSettingsTitle.setText(lang.getString("Settings"));
				if(!lblSemestriFilterError.getText().isEmpty()) {
					lblSemestriFilterError.setText(lang.getString("CheckData"));
				}
				if(homeActive==1) {
					lblTitle.setText(lang.getString("Home"));
				}
				else if(pnlLeftRegjistro.isVisible()) {
					lblTitle.setText(lang.getString("RSt"));
				}
				else if(pnlLeftKerko.isVisible()) {
					lblTitle.setText(lang.getString("KEStudentet"));
				}
				else if(pnlLeftRaporte.isVisible()) {
					lblTitle.setText(lang.getString("RaportSt"));
				}
				else if(pnlLeftRegjistroSemestrin.isVisible()) {
					lblTitle.setText(lang.getString("RS"));
					  }
				
				else if(pnlLeftContact.isVisible()) {
					lblTitle.setText(lang.getString("Kontakto"));
				}
				else if(pnlLeftMessage.isVisible()) {
					lblTitle.setText(lang.getString("DM"));
				}
				lblIsRunning.setText(lang.getString("AppStatus"));
				obj.changeHelpLang();
				obj1.changeAboutLang();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlAlbanian.setBackground(Color.LIGHT_GRAY);
				pnlAlbanian.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlAlbanian.setBackground(null);
				pnlAlbanian.setOpaque(false);

			}
		});
		// GJUHA
		pnlEnglish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				currentLang = new Locale("EN");
				lang = ResourceBundle.getBundle("Language", currentLang);
				lblEmri.setText(lang.getString("name"));
				lblMbiemri.setText(lang.getString("surname"));
				lblPersonalNr.setText(lang.getString("personalNumber"));
				lblDitelindja.setText(lang.getString("birthday"));
				lblPrindi.setText(lang.getString("parent"));
				lblShteti.setText(lang.getString("country"));
				lblQyteti.setText(lang.getString("city"));
				lblAdresa.setText(lang.getString("address"));
				lblNrtel.setText(lang.getString("tel"));
				lblEmail.setText(lang.getString("email"));
				lblGjinia.setText(lang.getString("gender"));
				lblFakulteti.setText(lang.getString("faculty"));
				lblDrejtimi.setText(lang.getString("branch"));
				lblStatusi.setText(lang.getString("status"));
				rdbtnMashkull.setText(lang.getString("male"));
				rdbtnFemer.setText(lang.getString("female"));
				rdbtnIRregullt.setText(lang.getString("regular"));
				rdbtnMeKorrospodence.setText(lang.getString("correspondence"));
				lblNiveli.setText(lang.getString("nivel"));
				btnRegjistroStudentet.setText(lang.getString("Regjistro"));
				lblRegjistro.setText(lang.getString("Regjistro"));
				btnZgjedh.setText(lang.getString("Zgjedh"));
				lblInformatatKontaktuese.setText(lang.getString("InfoK"));
				lblInformatatAdministrative.setText(lang.getString("InfoA"));
				lblInfoBaze.setText(lang.getString("InfoB"));
				lblStudentet.setText(lang.getString("Std"));
				lblKerko.setText(lang.getString("KE"));
				lblRaporte.setText(lang.getString("Raporte"));
				lblSemestri.setText(lang.getString("S"));
				lblRegjistroSemestrin.setText(lang.getString("RS"));
				btnRegjistroStudentet.setText(lang.getString("RSt"));
				lblKerkoSipas.setText(lang.getString("Menyra"));
				btnEdit.setText(lang.getString("Edit"));
				btnDelete.setText(lang.getString("Delete"));
				lblUniversitetitIPrishtines.setText(lang.getString("UP"));
				btnRegjistroSemestrin.setText(lang.getString("RegjistroS"));
				lblNumriIStudenteve.setText(lang.getString("NrStudenteve"));
				lblITreti.setText(lang.getString("Viti3"));
				lblVitiIPare.setText(lang.getString("Viti1"));
				lblIDyti.setText(lang.getString("Viti2"));
				lblIKaterti.setText(lang.getString("Viti4"));
				/*ketu ndrysho*/
				lblTelekomunikacion.setText(lang.getString("Tele"));
				lblElektroenergjetike.setText(lang.getString("Ener"));
				lblKompjuterike.setText(lang.getString("Ik"));
				lblAutomatike.setText(lang.getString("Aut"));
				lblElektronike.setText(lang.getString("Ele"));
				lblFemra.setText(lang.getString("Femera"));
				lblMeshkuj.setText(lang.getString("Meshkuj"));
				btnRuajRaportin.setText(lang.getString("Ruaj"));
				btnGjenero.setText(lang.getString("Gjenero"));
				lblRaport.setText(lang.getString("Rap"));
				btnKerkoSemestrin.setText(lang.getString("Search"));
				lblFilteriSemestri.setText(lang.getString("kerkoE"));
				btnDergoMesazhin.setText(lang.getString("Dergo"));
				btnTextColor.setText(lang.getString("TextC"));
				btnBackgroundColor.setText(lang.getString("BackgroundC"));
				lblSupport.setText(lang.getString("WeAreNearYou"));
				lblAdresaKontaktit.setText(lang.getString("address"));
				lblIsRunning.setText(lang.getString("AppStatus"));
				lblRegjistroPerdorues.setText(lang.getString("RSt"));
				lblKontaktoSherbimin.setText(lang.getString("Kontakto"));
				lblRaporti.setText(lang.getString("RaportSt"));
				lblDergoMesazh.setText(lang.getString("DM"));
				lblKerkoStudentet.setText(lang.getString("KEStudentet"));
				lblRegjistroSemestrin_1.setText(lang.getString("RS"));
				lblHelp.setText(lang.getString("Help"));
				lblAlbanian.setText(lang.getString("Albanian"));
				lblEnglish.setText(lang.getString("English"));
				lblAboutUs.setText(lang.getString("About"));
				lblLanguage.setText(lang.getString("ChooseLang"));
				lblLock.setToolTipText(lang.getString("LockMenus"));		
				pnlContact.setToolTipText(lang.getString("Kontakto"));
				pnlKerko.setToolTipText(lang.getString("KEStudentet"));
				pnlRegjistro.setToolTipText(lang.getString("RSt"));
				pnlStudentet.setToolTipText(lang.getString("MenaxhoSt"));
				pnlRaportet.setToolTipText(lang.getString("RaportSt"));
				lblSettings.setToolTipText(lang.getString("Settings"));
				pnlRegjistroSemestrin.setToolTipText("RS");
				pnlSemestri.setToolTipText(lang.getString("S"));
				lblMenuIcon.setToolTipText(lang.getString("SlideMenus"));
				lblArrowLeft.setToolTipText(lang.getString("Previous"));
				lblArrowRight.setToolTipText(lang.getString("Next"));
				lblSistemiPerMenaxhimin.setText(lang.getString("SPMS"));
				lblSettingsTitle.setText(lang.getString("Settings"));
				if(!lblSemestriFilterError.getText().isEmpty()) {
					lblSemestriFilterError.setText(lang.getString("CheckData"));
				}
				if(homeActive==1) {
					lblTitle.setText(lang.getString("Home"));
				}
				else if(pnlLeftRegjistro.isVisible()) {
					lblTitle.setText(lang.getString("RSt"));
				}
				else if(pnlLeftKerko.isVisible()) {
					lblTitle.setText(lang.getString("KEStudentet"));
				}
				else if(pnlLeftRaporte.isVisible()) {
					lblTitle.setText(lang.getString("RaportSt"));
				}
				else if(pnlLeftRegjistroSemestrin.isVisible()) {
					lblTitle.setText(lang.getString("RS"));
					  }
				
				else if(pnlLeftContact.isVisible()) {
					lblTitle.setText(lang.getString("Kontakto"));
				}
				else if(pnlLeftMessage.isVisible()) {
					lblTitle.setText(lang.getString("DM"));
				}
				obj.changeHelpLang();
				obj1.changeAboutLang();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlEnglish.setBackground(Color.LIGHT_GRAY);
				pnlEnglish.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				pnlEnglish.setBackground(null);
				pnlEnglish.setOpaque(false);

			}
		});

		/*
		 * Vendosja e dizajnit modern per dritare
		 */
		try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
	
	

	private void regjistroStudentet() {
		lblError.setText("");
		String emri = txtEmri.getText();
		String mbiemri = txtMbiemri.getText();
		String prindi = txtPrindi.getText();
		String nrPersonal = txtPersonalNr.getText();
		String ditelindja = ((JTextField) txtDitelindja.getDateEditor().getUiComponent()).getText();
		int shteti = cmbShteti.getSelectedIndex();
		int qyteti = cmbQyteti.getSelectedIndex() + 1;
		String adresa = txtAdresa.getText();
		String tel = txtTel.getText();
		String email = txtEmail.getText();
		int fakulteti = cmbFakulteti.getSelectedIndex();
		int drejtimi = cmbDrejtimi.getSelectedIndex() + 1;
		int niveli = cmbNiveli.getSelectedIndex();
		String foto = imagePath;
		if (emri.isEmpty() || mbiemri.isEmpty() || prindi.isEmpty() || nrPersonal.isEmpty() || ditelindja.isEmpty()
				|| shteti == 0 || adresa.isEmpty() || email.isEmpty() || fakulteti == 0) {
			lblError.setText(lang.getString("emptyError"));
		} else if (nrPersonal.length() > 10) {
			lblError.setText("Nr personal jo valid");
		} else if (!ditelindja.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			lblError.setText("Ditelindja eshte gabim");
			txtDitelindja.requestFocus();
		} else if (!tel.matches("^\\+\\d{11}$")) {
			lblError.setText("Nr.Telefonit eshte gabim!");
			txtTel.requestFocus();
		} else if (!email.matches("^[A-Za-z0-9._\\-]+@[A-Za-z]+.[A-Za-z]{2,3}$")) {
			lblError.setText("Emaili eshte gabim!");
			txtEmail.requestFocus();
		}
		char gjinia = 'N';
		if (rdbtnMashkull.isSelected())
			gjinia = 'M';
		else if (rdbtnFemer.isSelected())
			gjinia = 'F';
		else {
			lblError.setText(lang.getString("emptyError"));
		}
		int statusi = -1;
		if (rdbtnIRregullt.isSelected())
			statusi = 1;
		else if (rdbtnMeKorrospodence.isSelected())
			statusi = 0;
		else {
			lblError.setText(lang.getString("emptyError"));
		}

		if (lblError.getText().isEmpty()) {
			try {
				String insertStudents = "insert into studentet(semri,smbiemri,sprindi, snrpersonal,"
						+ " sditelindja,sshteti,sqyteti,sadresa,stel,semail,sgjinia,"
						+ "sfakulteti,sdrejtimi,sstatusi,sniveli,ssemestri,sfoto) values('" + emri + "','" + mbiemri
						+ "','" + prindi + "','" + nrPersonal + "','" + ditelindja + "'," + shteti + "," + qyteti + ",'"
						+ adresa + "','" + tel + "','" + email + "','" + gjinia + "'," + fakulteti + "," + drejtimi
						+ "," + statusi + "," + niveli + ",1,'" + foto + "')";

				pst = conn.prepareStatement(insertStudents);
				pst.execute();

				// Regjistrimi i studentit si perdorues i sistemit
				String queryId = "select max(sid) as id from studentet";
				pst = conn.prepareStatement(queryId);
				res = pst.executeQuery();
				res.next();
				String idGjeneruar = res.getString("id");

				String txtID = idGjeneruar;
				if (idGjeneruar == null) {
					String vleraFillestare = "11800000";
					txtID = vleraFillestare;
				}

				// Gjenerimi i salted hash
				String saltValue = hash.saltGenerator();
				String fjalekalimiHash = txtID + saltValue;
				fjalekalimiHash = hash.hashString(fjalekalimiHash, "SHA-1");
				String updatePerdoruesi = "update perdoruesit set pfjalekalimi='" + fjalekalimiHash + "', psalt='"
						+ saltValue + "'where pid='" + txtID + "'";

				pst = conn.prepareStatement(updatePerdoruesi);
				pst.execute();
				pst.close();

				JOptionPane.showMessageDialog(null, lang.getString("StSukses"), lang.getString("Info"),
						JOptionPane.INFORMATION_MESSAGE);

				txtEmri.setText("");
				txtMbiemri.setText("");
				txtPrindi.setText("");
				txtPersonalNr.setText("");
				((JTextField) txtDitelindja.getDateEditor().getUiComponent()).setText("");
				txtTel.setText("");
				txtEmail.setText("");
				txtAdresa.setText("");
				cmbShteti.setSelectedIndex(0);
				cmbFakulteti.setSelectedIndex(0);
				rdbtnMashkull.setSelected(false);
				rdbtnFemer.setSelected(false);
				rdbtnIRregullt.setSelected(false);
				rdbtnMeKorrospodence.setSelected(false);
				lblProfile.setIcon(null);
				iconError.setIcon(null);
				lblProfile.setIcon(new ImageIcon(frmMain.class.getResource("/image/Female_100px.png")));
			} catch (Exception e2) {
				lblError.setText(lang.getString("DbSukses"));
			}
		} else {
			iconError.setIcon(vendosIkonen("/image/Error_25px.png"));
		}
	}
	private void showHide() {
		getGlassPane().setVisible(!getGlassPane().isVisible());
	}
	
	private  void helpWithF1(JComponent comp, int keyCode, String id) {
	    InputMap im=comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap=comp.getActionMap();
		im.put(KeyStroke.getKeyStroke(keyCode, 0, false),id);
		ap.put(id, new AbstractAction() {
			 public void actionPerformed(ActionEvent e) {
			    	Help obj = new Help();
					obj.setLocationRelativeTo(null);
					obj.setVisible(true);	
					}
		});
	}
	
	private void changePanelsWithKeys(JComponent comp, int keyCodeUp,int KeyCodeDown,String left,String right) {
	    InputMap im=comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap=comp.getActionMap();
		im.put(KeyStroke.getKeyStroke(keyCodeUp, 0, false),left);
		im.put(KeyStroke.getKeyStroke(KeyCodeDown, 0, false),right);
		ap.put(left, new AbstractAction() {
			 public void actionPerformed(ActionEvent e) {
				   changePanelsLeft();
			 }
		});
		ap.put(right, new AbstractAction() {
			 public void actionPerformed(ActionEvent e) {
				   changePanelsRight();
			 }
		});
	}
		
	private void changePanelsLeft() {
		int pnStudentetOpen = 50;
		int pnStudentetClose = 150;
		int pnSemestriOpen = 50;


			JPanel[] panel = new JPanel[] { pnlMainHome, pnlMainRegjistro, pnlMainKerko, pnlMainRaporte,
					pnlMainSemestri, pnlMainContact, pnlMainMessage };

			if (pnlLeftRegjistro.isVisible()) {
				pnlLeftRegjistro.setVisible(false);
				lblTitle.setText(lang.getString("Home"));
				lblArrowLeft.setEnabled(false);
				homeActive = 1;
				l = 0;
			} else if (pnlLeftKerko.isVisible()) {
				pnlLeftKerko.setVisible(false);
				lblTitle.setText(lang.getString("RSt"));
				pnlLeftRegjistro.setVisible(true);
				l = 1;
			} else if (pnlLeftRaporte.isVisible()) {
				if (panelStudentet.getHeight() < 60) {
					panelStudentet.setSize(panelStudentet.getWidth(), 150);
					pnlRaportet.setLocation(0, 278);
					panelSemestri.setLocation(0, 328);
				}
				lblTitle.setText(lang.getString("KEStudentet"));
				lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				pnlLeftRaporte.setVisible(false);
				pnlLeftKerko.setVisible(true);
				l = 2;
			} else if (pnlLeftRegjistroSemestrin.isVisible()) {
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblTitle.setText(lang.getString("RaportSt"));
				pnlLeftRaporte.setVisible(true);
				l = 3;
			} else if (pnlLeftContact.isVisible()) {
				pnlLeftRegjistroSemestrin.setVisible(true);
				if (panelSemestri.getHeight() < 60) {
					panelSemestri.setSize(panelSemestri.getWidth(), 100);
				}
				lblTitle.setText(lang.getString("RS"));
				lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				pnlLeftContact.setVisible(false);
				l = 4;
			} else if (pnlLeftMessage.isVisible()) {
				pnlLeftMessage.setVisible(false);
				lblTitle.setText(lang.getString("Kontakto"));
				pnlLeftContact.setVisible(true);
				l = 5;
			}
			if (!pnlLeftMessage.isVisible()) {
				lblArrowRight.setEnabled(true);
			}

			if (l < panel.length) {
				mainPanel.removeAll();
				mainPanel.add(panel[l]);
				mainPanel.repaint();
				mainPanel.revalidate();
			}

			if (homeActive == 0) {
				l--;
			}
	}
	private void changePanelsRight() {
		int pnStudentetOpen = 50;
		int pnStudentetClose = 150;
		int pnSemestriOpen = 50;
		

			JPanel[] panel = new JPanel[] { pnlMainRegjistro, pnlMainKerko, pnlMainRaporte, pnlMainSemestri,
					pnlMainContact, pnlMainMessage };
			if (homeActive == 1) {
				if (panelStudentet.getHeight() < 60) {
					panelStudentet.setSize(panelStudentet.getWidth(), 150);
					pnlRaportet.setLocation(0, 278);
					panelSemestri.setLocation(0, 328);
				}
				lblUpDown.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				lblTitle.setText(lang.getString("RSt"));
				pnlLeftRegjistro.setVisible(true);
				homeActive = 0;
				r = 0;
			} else if (pnlLeftRegjistro.isVisible()) {
				pnlLeftRegjistro.setVisible(false);
				lblTitle.setText(lang.getString("KEStudentet"));
				pnlLeftKerko.setVisible(true);
				r = 1;
			} else if (pnlLeftKerko.isVisible()) {
				pnlLeftKerko.setVisible(false);
				lblTitle.setText(lang.getString("RaportSt"));
				pnlLeftRaporte.setVisible(true);
				r = 2;
			} else if (pnlLeftRaporte.isVisible()) {

				pnlLeftRaporte.setVisible(false);
				if (panelSemestri.getHeight() < 60) {
					panelSemestri.setSize(panelSemestri.getWidth(), 100);
				}
				lblUpDown1.setIcon(new ImageIcon(frmMain.class.getResource("/image/Expand Arrow_24px.png")));
				lblTitle.setText(lang.getString("RS"));
				pnlLeftRegjistroSemestrin.setVisible(true);
				r = 3;
			} else if (pnlLeftRegjistroSemestrin.isVisible()) {
				pnlLeftRegjistroSemestrin.setVisible(false);
				lblTitle.setText(lang.getString("Kontakto"));
				pnlLeftContact.setVisible(true);
				r = 4;
			} else if (pnlLeftContact.isVisible()) {
				pnlLeftMessage.setVisible(true);
				lblTitle.setText(lang.getString("DM"));
				pnlLeftContact.setVisible(false);
				r = 5;
				lblArrowRight.setEnabled(false);
			}

			if (homeActive == 0) {
				lblArrowLeft.setEnabled(true);
			}

			if (r < panel.length) {
				mainPanel.removeAll();
				mainPanel.add(panel[r]);
				mainPanel.repaint();
				mainPanel.revalidate();
			}

			if (!pnlLeftMessage.isVisible()) {
				r++;
			}

	}
	
	private void kerkoSemestrin() {
	if (txtKerkoSemestrin.getText() != "") {
		try {
			String sql = "Select s.sid as 'ID',s.semri as 'EMRI',s.smbiemri as 'MBIEMRI',"
					+ "s.sditelindja as 'DATELINDJA',f.femri as 'FAKULTETI',s.ssemestri as 'SEMESTRI',s.sgjinia as 'GJINIA',"
					+ "fl.flloji as 'LLOJI',fl.fdata as 'DATA',fl.fpaguar as 'PAGUAR' from studentet s,fletpagesat fl,qytetet q,fakultetet f"
					+ " where s.sid=fl.fstudenti and s.sqyteti=q.qid and f.fid=s.sfakulteti "
					+ "and s.semri like '" + txtKerkoSemestrin.getText() + "%' ";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			tblSemestri.setModel(DbUtils.resultSetToTableModel(res));
			pst.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, lang.getString("UpdateError"));
		}
		if (tblSemestri.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, lang.getString("PaRezultat"));
			txtKerkoSemestrin.setBorder(BorderFactory.createLineBorder(Color.red));
			lblSemestriFilterError.setText(lang.getString("CheckData"));
		} else {
			txtKerkoSemestrin.setBorder(BorderFactory.createLineBorder(Color.blue));
			lblSemestriFilterError.setText("");
		}
	} else {
		UpdateTable();
		txtKerkoSemestrin.setBorder(BorderFactory.createLineBorder(Color.blue));
		lblSemestriFilterError.setText("");

	}
}
	private void regjistroSemestrin() {
	  if (id != 0) {
			String paguar = "";
			String perdorur="";
			String studenti = "";
			String semestri = "";
			int semestriint = 1;
			try {
				String sql = "Select * from studentet s,fletpagesat fl,qytetet q,fakultetet f "
						+ "where s.sid=fl.fstudenti and s.sqyteti=q.qid and f.fid=s.sfakulteti and s.sid='" + id
						+ "'";
				pst = conn.prepareStatement(sql);
				res = pst.executeQuery();
				while (res.next()) {
					paguar = res.getString("fpaguar");
					perdorur=res.getString("fperdorur");
					studenti = res.getString("semri") + " " + res.getString("smbiemri");
					semestri = res.getString("ssemestri");
					semestriint = Integer.parseInt(semestri);
					semestriint += 1;
					
				}
				pst.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, lang.getString("InsertError"));
			}

			if (semestriint != 1 && paguar.equals("PO") && perdorur.equals("0")) {
				try {
					String sql1 = "Update studentet set ssemestri='" + semestriint + "' where sid='" + id
							+ "' ";

					pst = conn.prepareStatement(sql1);
					pst.execute();
					UpdateTable();
					pst.close();
					
					String sql2 = "Update fletpagesat set fperdorur=" + 1 + " where fstudenti=" + id;
					pst = conn.prepareStatement(sql2);
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null,
					lang.getString("Student") + studenti +" "+lang.getString("Registers") + semestriint + lang.getString("AfterNumber"));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, lang.getString("InsertError"));
				}
			}
			else {
				JOptionPane.showMessageDialog(null, lang.getString("Student") + studenti + lang.getString("NotRegisters"));
			}
		}

  }
	private void editoStudentet() {
		String subquery = "select s.sid as 'Id',s.semri as 'Emri',s.sprindi as 'E.Prindit',s.smbiemri as 'Mbiemri',f.femri as 'Fakulteti' ,q.qemri as 'Qyteti',s.snrpersonal as 'Nr personal',"
				+ "s.sadresa as 'Adresa',s.stel as 'Tel',s.semail as 'Email',s.sgjinia as 'Gjinia' from studentet s,"
				+ "qytetet q,fakultetet f where s.sqyteti = q.qid and f.fid = s.sfakulteti ";
		try {
			txtFilter.setBorder(BorderFactory.createLineBorder(Color.blue));
			if (cmbKerko.getSelectedIndex() == 0) {
				String query;
				if(txtFilter.getText().isEmpty()) {
					query = subquery;
				}
				else {
					query = subquery +" and s.sid="+ Integer.parseInt(txtFilter.getText());
				}
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));
			} else if (cmbKerko.getSelectedIndex() == 1) {
				String query = subquery+" and s.semri like '%"
						+ String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));

			} else if (cmbKerko.getSelectedIndex() == 2) {
				String query = subquery + " and s.smbiemri like '%" + String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));

			} else if (cmbKerko.getSelectedIndex() == 3) {

				String query = subquery +" and s.semail like '%" + String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));

			} else if (cmbKerko.getSelectedIndex() == 4) {
				String query = subquery+" and q.qemri like '%" + String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));
			} else if (cmbKerko.getSelectedIndex() == 5) {
				String query = subquery + " and s.sditelindja like '%" + String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));
			} else if (cmbKerko.getSelectedIndex() == 6) {
				String query = subquery + " and f.femri like '%" + String.valueOf(txtFilter.getText()) + "%'";
				pst = conn.prepareStatement(query);
				res = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(res));
			} else {
				JOptionPane.showMessageDialog(null, "Nuk ka te dhena.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Gabim gjate kerkimit");
		}

	}
	private void dergoMesazhin() {
		String html="<div width='100%' style='padding: 5px; min-height:300px;"+ngjyra+align+boldAttr+italicAttr+htmlFontSize+underlineAttr+ngjyraSfondit+"'><p>"+txtMessage1.getText()+"</p></div>";
		Mailer.send("sems.noreply@gmail.com", "spms12345", "qlirimmurati@gmail.com", "", html);
		txtMessage1.setText("");
	}
	public void updateTable() {
		try {
			String query = "select s.sid as 'Id',s.semri as 'Emri',s.sprindi as 'E.Prindit',s.smbiemri as 'Mbiemri',"
					+ "f.femri as 'Fakulteti' ,q.qemri as 'Qyteti',s.snrpersonal as 'Nr personal',"
					+ "s.sditelindja as 'Ditelindja',s.stel as 'Tel',s.semail as 'Email',"
					+ "s.sgjinia as 'Gjinia' from studentet s,"
					+ "qytetet q,fakultetet f where s.sqyteti = q.qid and f.fid = s.sfakulteti";
			pst = conn.prepareStatement(query);
			res = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res));
			pst.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, lang.getString("UpdateError") + e.getMessage());
		}
	}
	public void UpdateTable() {
		try {
			String sql = "Select s.sid as 'ID',s.semri as 'EMRI',s.smbiemri as 'MBIEMRI',"
					+ "s.sditelindja as 'DATELINDJA',f.femri as 'FAKULTETI',s.ssemestri as 'SEMESTRI',s.sgjinia as 'GJINIA',"
					+ "fl.flloji as 'LLOJI',fl.fdata as 'DATA',fl.fpaguar as 'PAGUAR' from studentet s,fletpagesat fl,qytetet q,fakultetet f"
					+ " where s.sid=fl.fstudenti and s.sqyteti=q.qid and f.fid=s.sfakulteti ";
			pst = conn.prepareStatement(sql);
			res = pst.executeQuery();
			tblSemestri.setModel(DbUtils.resultSetToTableModel(res));
			pst.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, lang.getString("UpdateError"));
		}
	}
	public static void clock() {
	
		time = new Thread() {
			public void run() {
				try {
					while (true) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
						Calendar currentCalendar = Calendar.getInstance();
						Date currentTime = currentCalendar.getTime();
						lblStatusTime.setText(lang.getString("Time")+"     "+timeFormat.format(currentTime));
						lblStatusDate.setText(lang.getString("Date")+"     "+dateFormat.format(currentTime));
						if(threadStop) {
							time.stop();
						}
						
						sleep(1000);
					}
				} catch (Exception e) {
				}
			}

		};
		
		time.start();
	}
	public ImageIcon vendosIkonen(String resource) {
		ImageIcon icon = new ImageIcon(frmMain.class.getResource(resource));
		Image imageIcon = icon.getImage();
		imageIcon=imageIcon.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(imageIcon);
	}
}