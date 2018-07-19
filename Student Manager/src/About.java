import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.border.LineBorder;



import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
//Donart
public class About extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAds;
	private JLabel lblNukJaneNe;
	private JLabel lblBlog ;
	private JLabel lblPrivacyPolicy;
	private JLabel lblWwwblogspmsedu;
	private JLabel lblAplikacioniEshteI ;
	private JLabel lblOpen ;
	static Locale currentLang1;
	ResourceBundle lang1;
	private JLabel lblBackground;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		
		currentLang1=frmMain.currentLang;
		lang1=ResourceBundle.getBundle("Language", currentLang1);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOpen = new JLabel(lang1.getString("Open"));
		lblOpen.setForeground(Color.WHITE);
		lblOpen.setBounds(324, 274, 118, 26);
		contentPane.add(lblOpen);
		lblOpen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblNewLabel = new JLabel(lang1.getString("About"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(21, 10, 112, 26);
		contentPane.add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(50, 37, 350, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ads", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 350, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblAds = new JLabel(lang1.getString("Ads"));
		lblAds.setBounds(6, 15, 368, 26);
		panel_1.add(lblAds);
		lblAds.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblNukJaneNe = new JLabel(lang1.getString("NukAds"));
		lblNukJaneNe.setBounds(6, 51, 324, 26);
		panel_1.add(lblNukJaneNe);
		lblNukJaneNe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 84, 350, 68);
		panel.add(panel_2);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Blog", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		lblBlog = new JLabel(lang1.getString("Blog"));
		lblBlog.setBounds(6, 15, 368, 26);
		panel_2.add(lblBlog);
		lblBlog.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblWwwblogspmsedu = new JLabel("www.blogspms.edu\r\n");
		lblWwwblogspmsedu.setBounds(6, 33, 162, 26);
		panel_2.add(lblWwwblogspmsedu);
		lblWwwblogspmsedu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 153, 346, 83);
		panel.add(panel_3);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Privacy Poilcy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setLayout(null);
		
		lblPrivacyPolicy = new JLabel(lang1.getString("PrivacyPolicy"));
		lblPrivacyPolicy.setBounds(6, 15, 334, 26);
		panel_3.add(lblPrivacyPolicy);
		lblPrivacyPolicy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblAplikacioniEshteI = new JLabel(lang1.getString("ApliakcioniEshte"));
		lblAplikacioniEshteI.setBounds(6, 42, 334, 26);
		panel_3.add(lblAplikacioniEshteI);
		lblAplikacioniEshteI.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblMinimize = new JLabel("");
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
		lblMinimize.setIcon(new ImageIcon(About.class.getResource("/image/minimize.png")));
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setBounds(386, 0, 32, 27);
		contentPane.add(lblMinimize);
		
		JLabel lblExit = new JLabel("");
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
		lblExit.setIcon(new ImageIcon(About.class.getResource("/image/images.png")));
		lblExit.setVerifyInputWhenFocusTarget(false);
		lblExit.setOpaque(false);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(418, 0, 32, 27);
		contentPane.add(lblExit);
		
		lblBackground = new JLabel("background");
		
		lblBackground.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblBackground.setBounds(0, 0, 450, 300);
		contentPane.add(lblBackground);
		lblBackground.setBackground(SystemColor.activeCaption);
		lblBackground.setIcon(new ImageIcon(frmMain.class.getResource("image/background.jpg")));
		
		
		
		
		setUndecorated(true);
	}
	
	public void changeAboutLang() {
		currentLang1=frmMain.currentLang;
		lang1=ResourceBundle.getBundle("Language", currentLang1);
		lblNewLabel.setText(lang1.getString("About"));
		lblNukJaneNe.setText(lang1.getString("NukAds"));
		lblAds.setText(lang1.getString("Ads"));
		lblBlog.setText(lang1.getString("Blog"));
		lblOpen.setText(lang1.getString("Open"));
		lblPrivacyPolicy.setText(lang1.getString("PrivacyPolicy"));
		lblAplikacioniEshteI .setText(lang1.getString("ApliakcioniEshte"));
	}
}
//Donart