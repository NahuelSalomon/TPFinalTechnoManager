package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;

public class VentanaAltaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldLegajo;
	private JTextField textFieldConstraseña;

	/**
	 * Create the frame.
	 */
	public VentanaAltaEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 571);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setUndecorated(true);
		
			JLabel jLabelLegajo = new JLabel("Legajo");
			jLabelLegajo.setFont(new Font("Tahoma", Font.BOLD, 14));
			jLabelLegajo.setForeground(Color.WHITE);
			jLabelLegajo.setBounds(71, 328, 70, 23);
			getContentPane().add(jLabelLegajo);
		
				JLabel jLabelContraseña = new JLabel("Contrase\u00F1a");
				jLabelContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
				jLabelContraseña.setForeground(Color.WHITE);
				jLabelContraseña.setBounds(71, 396, 88, 14);
				getContentPane().add(jLabelContraseña);
		
				JLabel jLabelFechaNac = new JLabel("Fecha de nacimiento");
				jLabelFechaNac.setFont(new Font("Tahoma", Font.BOLD, 14));
				jLabelFechaNac.setForeground(Color.WHITE);
				jLabelFechaNac.setBounds(302, 334, 140, 14);
				getContentPane().add(jLabelFechaNac);
		
		JLabel jLabelDni = new JLabel("DNI");
		jLabelDni.setForeground(new Color(255, 255, 255));
		jLabelDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelDni.setBounds(71, 210, 46, 14);
		getContentPane().add(jLabelDni);
		JLabel jLabelNombre = new JLabel("Nombre");
		jLabelNombre.setForeground(new Color(255, 255, 255));
		jLabelNombre.setBackground(new Color(0, 0, 128));
		jLabelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelNombre.setBounds(71, 85, 70, 15);
		getContentPane().add(jLabelNombre);
		
		JLabel lblNewLabelDomicilio = new JLabel("Domicilio");
		lblNewLabelDomicilio.setForeground(Color.WHITE);
		lblNewLabelDomicilio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelDomicilio.setBounds(71, 272, 70, 14);
		getContentPane().add(lblNewLabelDomicilio);
		
		JLabel jLabelApellido = new JLabel("Apellido\r\n");
		jLabelApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelApellido.setForeground(new Color(255, 255, 255));
		jLabelApellido.setBounds(71, 139, 88, 23);
		getContentPane().add(jLabelApellido);
		
				JLabel jLabelSexo = new JLabel("Sexo");
				jLabelSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
				jLabelSexo.setForeground(Color.WHITE);
				jLabelSexo.setBounds(302, 397, 46, 14);
				getContentPane().add(jLabelSexo);
					
					
		JButton jButtonAltaUser = new JButton("Dar alta usuario");
		jButtonAltaUser.setBackground(new Color(0, 0, 128));
		jButtonAltaUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButtonAltaUser.setForeground(Color.WHITE);
		jButtonAltaUser.setBounds(429, 502, 176, 25);
		getContentPane().add(jButtonAltaUser);
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel jLabelAvatar = new JLabel();
		//jLabelAvatar.setIcon(new ImageIcon(VentanaAltaEmpleado.class.getResource("/Imagenes/add-icon-png-2487.png")));
		jLabelAvatar.setBounds(345, 11, 278, 263);
		getContentPane().add(jLabelAvatar);
		
		
		
		
		
		JRadioButton radioButtonPerzonalisado = new JRadioButton("Personalizado");
		radioButtonPerzonalisado.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonPerzonalisado.setForeground(new Color(255, 255, 255));
		radioButtonPerzonalisado.setBackground(new Color(0, 0, 128));
		radioButtonPerzonalisado.setBounds(475, 418, 130, 23);
		getContentPane().add(radioButtonPerzonalisado);
		
		JRadioButton radioButtonMujer = new JRadioButton("Mujer");
		radioButtonMujer.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonMujer.setForeground(new Color(255, 255, 255));
		radioButtonMujer.setBackground(new Color(0, 0, 128));
		radioButtonMujer.setBounds(302, 418, 80, 23);
		getContentPane().add(radioButtonMujer);
		
		JRadioButton radioButtonHombre = new JRadioButton("Hombre");
		radioButtonHombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonHombre.setBackground(new Color(0, 0, 128));
		radioButtonHombre.setForeground(new Color(255, 255, 255));
		radioButtonHombre.setBounds(384, 418, 89, 23);
		getContentPane().add(radioButtonHombre);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setForeground(Color.WHITE);
		comboBoxMes.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMes.setToolTipText("10");
		comboBoxMes.setBackground(new Color(0, 0, 128));
		comboBoxMes.setBounds(358, 359, 46, 20);
		getContentPane().add(comboBoxMes);
		
		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setForeground(Color.WHITE);
		comboBoxDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxDia.setBackground(new Color(0, 0, 128));
		comboBoxDia.setBounds(302, 359, 46, 20);
		getContentPane().add(comboBoxDia);
		
		JComboBox comboBoxAño = new JComboBox();
		comboBoxAño.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906"}));
		comboBoxAño.setForeground(Color.WHITE);
		comboBoxAño.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxAño.setToolTipText("2020");
		comboBoxAño.setBackground(new Color(0, 0, 128));
		comboBoxAño.setBounds(414, 359, 63, 20);
		getContentPane().add(comboBoxAño);
		
		textFieldConstraseña = new JTextField();
		textFieldConstraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldConstraseña.setForeground(Color.WHITE);
		textFieldConstraseña.setBackground(new Color(0, 0, 128));
		textFieldConstraseña.setBounds(66, 421, 176, 20);
		getContentPane().add(textFieldConstraseña);
		textFieldConstraseña.setColumns(10);
		
		textFieldLegajo = new JTextField();
		textFieldLegajo.setForeground(Color.WHITE);
		textFieldLegajo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldLegajo.setBackground(new Color(0, 0, 128));
		textFieldLegajo.setBounds(66, 359, 176, 20);
		getContentPane().add(textFieldLegajo);
		textFieldLegajo.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDNI.setBackground(new Color(0, 0, 128));
		textFieldDNI.setBounds(66, 235, 176, 20);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JTextField textFieldDomicilio = new JTextField();
		textFieldDomicilio.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDomicilio.setBackground(new Color(0, 0, 128));
		textFieldDomicilio.setBounds(66, 297, 176, 20);
		getContentPane().add(textFieldDomicilio);
		textFieldDomicilio.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setForeground(Color.WHITE);
		textFieldApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldApellido.setBackground(new Color(0, 0, 128));
		textFieldApellido.setBounds(66, 173, 176, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(new Color(255, 255, 255));
		textFieldNombre.setFont(new Font("Tahoma", Font.ITALIC, 14));
		textFieldNombre.setBackground(new Color(0, 0, 128));
		textFieldNombre.setBounds(66, 111, 176, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton jButtonAtras = new JButton("Atras");
		jButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		
		JLabel jLabelFondo = new JLabel("");
		jLabelFondo.setBackground(new Color(255, 255, 255));
		jLabelFondo.setBounds(0, 0, 650, 571);
		//jLabelFondo.setIcon(new ImageIcon(VentanaAltaEmpleado.class.getResource("/Imagenes/wallPaper blue3.jpg")));
		getContentPane().add(jLabelFondo);
		jButtonAtras.setBackground(new Color(0, 0, 128));
		jButtonAtras.setForeground(Color.WHITE);
		jButtonAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButtonAtras.setBounds(10, 11, 89, 23);
		getContentPane().add(jButtonAtras);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		iniciarEtiquetas();
		
	}
	
	
	public void iniciarEtiquetas() {

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
}
