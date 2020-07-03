package VentanasGraficas;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ClasesPersona.Gerente;
import ClasesPersona.Vendedor;
import Excepciones.LimiteExedidoDeGerenteExcepcion;
import TiendaDeRopa.TiendaDeRopa;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


/**
 * Esta es una clase para formar la ventana de alta de empleado con sus respectivas acciones
 * @author Nahuel
 *
 */
public class VentanaAltaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldLegajo;
	private JTextField textFieldConstraseña;
	private JComboBox comboBoxMes;
	private JTextField jtextFieldTelefono;
	private JButton jButtonAltaUser;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxAño;
	private JComboBox comboBoxEstadoCivil;
	private JRadioButton radioButtonVendedor; 
	private JRadioButton radioButtonGerente;
	private JRadioButton radioButtonHombre;
	private JRadioButton radioButtonMujer;
	private JRadioButton radioButtonPerzonalisado;
	private JButton botonAtras;
	
	/**
	 * Constructor de la ventana para el alta de un empleado
	 * @param tiendaDeRopa a trabajar
	 */
	public VentanaAltaEmpleado(TiendaDeRopa tiendaDeRopa) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 571);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setUndecorated(true);
			
		/*
		 * JLABEL
		 */
		JLabel jLabelFondo = new JLabel("");
		jLabelFondo.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelFondo.setIcon(new ImageIcon(VentanaAltaEmpleado.class.getResource("/Imagenes/wallPaper blue3.jpg")));
		jLabelFondo.setBackground(new Color(255, 255, 255));
		jLabelFondo.setBounds(0, 0, 650, 571);
		
		JLabel jLabellTipoDeEmpleado = new JLabel("Tipo de empleado");
		jLabellTipoDeEmpleado.setForeground(Color.WHITE);
		jLabellTipoDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabellTipoDeEmpleado.setBounds(70, 439, 130, 23);
		getContentPane().add(jLabellTipoDeEmpleado);
		
		JLabel jLabelLegajo = new JLabel("Legajo");
		jLabelLegajo.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelLegajo.setForeground(Color.WHITE);
		jLabelLegajo.setBounds(70, 303, 70, 23);
		getContentPane().add(jLabelLegajo);
	
		JLabel jLabelContraseña = new JLabel("Contrase\u00F1a");
		jLabelContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelContraseña.setForeground(Color.WHITE);
		jLabelContraseña.setBounds(70, 371, 88, 14);
		getContentPane().add(jLabelContraseña);
		
		JLabel jLabelFechaNac = new JLabel("Fecha de nacimiento");
		jLabelFechaNac.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelFechaNac.setForeground(Color.WHITE);
		jLabelFechaNac.setBounds(320, 309, 140, 14);
		getContentPane().add(jLabelFechaNac);
		
		JLabel jLabelDni = new JLabel("DNI");
		jLabelDni.setForeground(new Color(255, 255, 255));
		jLabelDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelDni.setBounds(70, 185, 46, 14);
		getContentPane().add(jLabelDni);
		
		JLabel jLabelNombre = new JLabel("Nombre");
		jLabelNombre.setForeground(new Color(255, 255, 255));
		jLabelNombre.setBackground(new Color(0, 0, 128));
		jLabelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelNombre.setBounds(70, 60, 70, 15);
		getContentPane().add(jLabelNombre);
		
		JLabel jLabelEstadoCivil = new JLabel("Estado civil");
		jLabelEstadoCivil.setForeground(Color.WHITE);
		jLabelEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelEstadoCivil.setBounds(70, 247, 88, 14);
		getContentPane().add(jLabelEstadoCivil);
		
		JLabel jLabelApellido = new JLabel("Apellido\r\n");
		jLabelApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelApellido.setForeground(new Color(255, 255, 255));
		jLabelApellido.setBounds(70, 114, 88, 23);
		getContentPane().add(jLabelApellido);
		
		JLabel jLabelSexo = new JLabel("Sexo");
		jLabelSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelSexo.setForeground(Color.WHITE);
		jLabelSexo.setBounds(320, 372, 46, 14);
		getContentPane().add(jLabelSexo);
		
		JLabel jLabelTelefono = new JLabel("Telefono");
		jLabelTelefono.setForeground(Color.WHITE);
		jLabelTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelTelefono.setBounds(320, 439, 130, 23);
		getContentPane().add(jLabelTelefono);
		
		JLabel jLabelAvatar = new JLabel();
		jLabelAvatar.setIcon(new ImageIcon(VentanaAltaEmpleado.class.getResource("/Imagenes/add-icon-png-2487.png")));
		jLabelAvatar.setBounds(345, 11, 278, 263);
		getContentPane().add(jLabelAvatar);
		
		
		/**
		 * JBUTTON
		 */
		botonAtras = new JButton("Atr\u00E1s");	
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonAtras.setForeground(new Color(255, 255, 255));
		botonAtras.setBackground(new Color(0, 0, 128));
		botonAtras.setBounds(10, 11, 107, 23);
		getContentPane().add(botonAtras);
		
		jButtonAltaUser = new JButton("Dar alta usuario");
		jButtonAltaUser.setBackground(new Color(0, 0, 128));
		jButtonAltaUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButtonAltaUser.setForeground(Color.WHITE);
		jButtonAltaUser.setBounds(447, 535, 176, 25);
		getContentPane().add(jButtonAltaUser);
		
		
		/**
		 * JRADIOBUTTON
		 */
		radioButtonPerzonalisado = new JRadioButton("Personalizado");
		radioButtonPerzonalisado.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonPerzonalisado.setForeground(new Color(255, 255, 255));
		radioButtonPerzonalisado.setBackground(new Color(0, 0, 128));
		radioButtonPerzonalisado.setBounds(493, 393, 130, 23);
		getContentPane().add(radioButtonPerzonalisado);
		
		radioButtonHombre = new JRadioButton("Hombre");
		radioButtonHombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonHombre.setBackground(new Color(0, 0, 128));
		radioButtonHombre.setForeground(new Color(255, 255, 255));
		radioButtonHombre.setBounds(402, 393, 89, 23);
		getContentPane().add(radioButtonHombre);
		
		radioButtonMujer = new JRadioButton("Mujer");
		radioButtonMujer.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonMujer.setForeground(new Color(255, 255, 255));
		radioButtonMujer.setBackground(new Color(0, 0, 128));
		radioButtonMujer.setBounds(320, 393, 80, 23);
		getContentPane().add(radioButtonMujer);
		
		radioButtonGerente = new JRadioButton("Gerente");
		radioButtonGerente.setForeground(Color.WHITE);
		radioButtonGerente.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonGerente.setBackground(new Color(0, 0, 128));
		radioButtonGerente.setBounds(172, 469, 100, 23);
		getContentPane().add(radioButtonGerente);
		
		radioButtonVendedor = new JRadioButton("Vendedor\r\n");
		radioButtonVendedor.setForeground(Color.WHITE);
		radioButtonVendedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonVendedor.setBackground(new Color(0, 0, 128));
		radioButtonVendedor.setBounds(70, 469, 100, 23);
		getContentPane().add(radioButtonVendedor);
		
		
		/**
		 * JCOMBOBOX
		 */
		comboBoxMes = new JComboBox();
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMes.setForeground(Color.WHITE);
		comboBoxMes.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMes.setToolTipText("10");
		comboBoxMes.setBackground(new Color(0, 0, 128));
		comboBoxMes.setBounds(376, 334, 39, 20);
		getContentPane().add(comboBoxMes);
		
		comboBoxDia = new JComboBox();
		comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDia.setForeground(Color.WHITE);
		comboBoxDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxDia.setBackground(new Color(0, 0, 128));
		comboBoxDia.setBounds(320, 334, 46, 20);
		getContentPane().add(comboBoxDia);
		
		comboBoxAño = new JComboBox();
		comboBoxAño.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906"}));
		comboBoxAño.setForeground(Color.WHITE);
		comboBoxAño.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxAño.setToolTipText("2020");
		comboBoxAño.setBackground(new Color(0, 0, 128));
		comboBoxAño.setBounds(425, 334, 63, 20);
		getContentPane().add(comboBoxAño);
		
		comboBoxEstadoCivil = new JComboBox();
		comboBoxEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Soltero/a", "Comprometido/a", "Noviazgo", "Relacion", "Casado/a", "Union Libre", "Separado/a", "Divorciado/a", "Viudo/a"}));
		comboBoxEstadoCivil.setForeground(new Color(255, 255, 255));
		comboBoxEstadoCivil.setBackground(new Color(0, 0, 128));
		comboBoxEstadoCivil.setBounds(65, 272, 176, 20);
		getContentPane().add(comboBoxEstadoCivil);	
		
		
		/**
		 * JTEXTFIELD
		 */
		textFieldConstraseña = new JTextField();
		textFieldConstraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldConstraseña.setForeground(Color.WHITE);
		textFieldConstraseña.setBackground(new Color(0, 0, 128));
		textFieldConstraseña.setBounds(65, 396, 176, 20);
		getContentPane().add(textFieldConstraseña);
		textFieldConstraseña.setColumns(10);
		
		textFieldLegajo = new JTextField();
		textFieldLegajo.setForeground(Color.WHITE);
		textFieldLegajo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldLegajo.setBackground(new Color(0, 0, 128));
		textFieldLegajo.setBounds(65, 334, 176, 20);
		getContentPane().add(textFieldLegajo);
		textFieldLegajo.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setForeground(new Color(255, 255, 255));
		textFieldDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDNI.setBackground(new Color(0, 0, 128));
		textFieldDNI.setBounds(65, 210, 176, 20);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setForeground(Color.WHITE);
		textFieldApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldApellido.setBackground(new Color(0, 0, 128));
		textFieldApellido.setBounds(65, 148, 176, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(new Color(255, 255, 255));
		textFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNombre.setBackground(new Color(0, 0, 128));
		textFieldNombre.setBounds(65, 86, 176, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setForeground(Color.WHITE);
		jtextFieldTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		jtextFieldTelefono.setColumns(10);
		jtextFieldTelefono.setBackground(new Color(0, 0, 128));
		jtextFieldTelefono.setBounds(320, 472, 176, 20);
		jtextFieldTelefono.setEnabled(false);
		getContentPane().add(jtextFieldTelefono);
		
		
		getContentPane().add(jLabelFondo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

	
		accionesRadioButton(radioButtonHombre, radioButtonMujer, radioButtonPerzonalisado);
		accionesRadioButton(radioButtonMujer, radioButtonHombre, radioButtonPerzonalisado);
		accionesRadioButton(radioButtonPerzonalisado, radioButtonHombre,radioButtonMujer);
		
		accionesRadioButton(radioButtonVendedor, radioButtonGerente);
		accionesRadioButton(radioButtonGerente, radioButtonVendedor);
		
		accionesJRadioButtonSeleccionarSoloUno();
		
		accionDarEmpleadoDeAlta(tiendaDeRopa);
	
		accionBotonAtras(tiendaDeRopa);
	}
	
	
	/**
	 * Metodo para bloquiar un radio button mientras otro se pueda seleccionar
	 * @param radioButton a selccionar
	 * @param radioButtonAux a bloquiar
	 */
	public void accionesRadioButton(JRadioButton radioButton,JRadioButton radioButtonAux) {
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioButtonAux.setSelected(false);
			}
		});
	}
	
	
	/**
	 * Metodo para bloquiar dos radioButton mientras que un tercero si se pueda seleccionar
	 * @param radioButton que se va a seleccionar
	 * @param radioButtonAux primero en bloquiarse
	 * @param radioButtonAux2 segundo en bloquiarse
	 */
	public void accionesRadioButton(JRadioButton radioButton,JRadioButton radioButtonAux,JRadioButton radioButtonAux2) {
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				radioButtonAux.setSelected(false);
				radioButtonAux2.setSelected(false);
			}
		});	
		
	}
	
	
	/**
	 * 	
	 * @param component
	 * @param popup
	 */
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

	
	/**
	 * Metodo que cita hace la accion para dar de alta a un empleado, lo crea y lo agrega a la tienda de ropa
	 * @param tiendaDeRopa a agregar empleado.
	 */
	public void accionDarEmpleadoDeAlta(TiendaDeRopa tiendaDeRopa) {
		
			jButtonAltaUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean altaEmpleado = false;
				
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				String dni = textFieldDNI.getText();
				int genero = devolverTipoDeGeneroRadioButton();
				String fechaNac = (String) comboBoxDia.getSelectedItem()+"/"+comboBoxMes.getSelectedItem()+"/"+comboBoxAño.getSelectedItem();
				int estadoCivil = comboBoxEstadoCivil.getSelectedIndex();
				String telefono = jtextFieldTelefono.getText();
				String legajo = textFieldLegajo.getText();
				String contraseña = textFieldConstraseña.getText();
			
				
				if(comprobacionDeCampos(tiendaDeRopa)) {
					
					if(radioButtonVendedor.isSelected()) {
						if(!jtextFieldTelefono.getText().isEmpty()) {
							Vendedor vendedor = new Vendedor(nombre, apellido, dni, genero, fechaNac, estadoCivil, telefono, legajo, contraseña);
							try {
							tiendaDeRopa.agregarEmpleado(legajo, vendedor);
							}
							catch(LimiteExedidoDeGerenteExcepcion ex) {
								ex.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "El empleado se ha dado de alta con exito");
							altaEmpleado = true;
						}
						else {
							JOptionPane.showMessageDialog(null, "Falta agregar un telefono");
						}
					}
					else {
						if(radioButtonGerente.isSelected()) {
						Gerente gerente = new Gerente(nombre, apellido, dni, genero, fechaNac, estadoCivil, legajo, contraseña);
						
						try {
							tiendaDeRopa.agregarEmpleado(legajo, gerente);
							JOptionPane.showMessageDialog(null, "El empleado se ha dado de alta con exito");
							altaEmpleado = true;
							}
						catch(LimiteExedidoDeGerenteExcepcion ee) {
							JOptionPane.showMessageDialog(null, "Ya existe un gerente");
						}
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de empleado");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al ingresar los datos, reintente");
				}
			
				if(altaEmpleado) {
					tiendaDeRopa.guardarTiendaDeRopa();
					volverAtras(tiendaDeRopa);
				}
			}
		});
	}

	
	/**
	 * Metodo para devolver el tipo de genero que se selecciono en los JRadioButton
	 * @return 1 si es hombre, 2 si es mujer, 3 si es perzonalizado, 0 si no esta seleccionado nada.
	 */
	public int devolverTipoDeGeneroRadioButton() {
		int genero = 0;
		
		if(radioButtonHombre.isSelected()) {
			genero = 1;
		}
		else {
			if(radioButtonMujer.isSelected()) {
				genero = 2;
			}
			else {
				if(radioButtonPerzonalisado.isSelected())
				genero = 3;
			}
		}
	return genero;
	}
  
	
	/**
	 * Metodo para comprobar que los campos de texto no esten vacios a la hora de dar de alta a un empleado
	 * @param tiendaDeRopa con la cual se va a trabajar
	 * @return true si los campos de texto estan correctamente llenados, false en caso contrario
	 */
	public boolean comprobacionDeCampos(TiendaDeRopa tiendaDeRopa){
		boolean validacion = false;
		
		if(!tiendaDeRopa.existeEmpleado(textFieldLegajo.getText())) {
			if(!textFieldNombre.getText().isEmpty()) {
				if(!textFieldApellido.getText().isEmpty()) {
					if(!textFieldDNI.getText().isEmpty()) {
						if(!textFieldConstraseña.getText().isEmpty()) {
							validacion = true;
						}
					}
				}
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "LEGAJO YA EXISTENTE");
		}
		return validacion;
	}
	
	
	/**
	 * Metodo para volver a atrás a una ventana de entrada
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void volverAtras(TiendaDeRopa tiendaDeRopa) {
		dispose();
		VentanaDeEntrada ventanaDeEntrada = new VentanaDeEntrada(tiendaDeRopa);
		ventanaDeEntrada.setVisible(true);
	}

	
	/**
	 * Metodo para ejecutar la accion del boton de volver atras
	 */
	public void accionBotonAtras(TiendaDeRopa tiendaDeRopa) {
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volverAtras(tiendaDeRopa);
			}
			
		});
	}
	
	
	/**
	 * Metodo para que se pueda seleccionar solo un radio button del conjunto de radio button de genero
	 */
	public void accionesJRadioButtonSeleccionarSoloUno() {
		radioButtonMujer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				radioButtonPerzonalisado.setSelected(false);
				radioButtonHombre.setSelected(false);
			}
		});	
	
	
		radioButtonVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtextFieldTelefono.setEnabled(true);
			}
			
		});
		
		radioButtonGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtextFieldTelefono.setText("");
				jtextFieldTelefono.setEnabled(false);
			}
			
		});
		
	}
	
	
}
