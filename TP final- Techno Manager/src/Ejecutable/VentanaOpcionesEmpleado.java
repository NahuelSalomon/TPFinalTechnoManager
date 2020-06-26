package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Archivos.archivoEmpleados;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JList;

public class VentanaOpcionesEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textVendedorNombre;
	private JTextField textVendedorApellido;
	private JTextField textVendedorLegajo;
	private JTextField textVendedorContrasenia;
	private JTextField textVendedorNumTel;
	private JTextField textCantidad;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public VentanaOpcionesEmpleado(String claveEmpleado, TiendaDeRopa tiendaDeRopa) throws FileNotFoundException, ClassNotFoundException, IOException {
		Empleado empleado = tiendaDeRopa.buscarEmpleado(claveEmpleado);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 800, 475));
		setLocationRelativeTo(null);
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonAtras = new JButton("Cerrar sesi\u00F3n");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tiendaDeRopa.guardarTiendaDeRopa();
				System.exit(0);
			}
		});
		
		botonAtras.setForeground(new Color(255, 255, 255));
		botonAtras.setBackground(new Color(0, 0, 128));
		botonAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonAtras.setBounds(10, 11, 123, 23);
		botonAtras.setVisible(true);
		
		JButton botonNombreEmpleado = new JButton(empleado.getNombre()+" "+empleado.getApellido());
		botonNombreEmpleado.setForeground(new Color(255, 255, 255));
		botonNombreEmpleado.setBackground(new Color(0, 0, 255));
		botonNombreEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonNombreEmpleado.setBounds(33, 433, 209, 17);
		contentPane.add(botonNombreEmpleado);
		
		JButton botonAgregarPrendaDeVestir = new JButton("Agregar prenda de vestir\r\n");
		botonAgregarPrendaDeVestir.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		botonAgregarPrendaDeVestir.setForeground(new Color(255, 255, 255));
		botonAgregarPrendaDeVestir.setBackground(new Color(0, 0, 128));
		botonAgregarPrendaDeVestir.setBounds(33, 233, 241, 23);
		contentPane.add(botonAgregarPrendaDeVestir);
		
		JButton botonModificarDatosPersonales = new JButton("Modificar datos personales\r\n");
		botonModificarDatosPersonales.setForeground(new Color(255, 255, 255));
		botonModificarDatosPersonales.setBackground(new Color(0, 0, 128));
		botonModificarDatosPersonales.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		botonModificarDatosPersonales.setBounds(33, 199, 241, 23);
		contentPane.add(botonModificarDatosPersonales);
		
		JButton botonVerVentas = new JButton("Ver mis ventas\r\n");
		botonVerVentas.setForeground(new Color(255, 255, 255));
		botonVerVentas.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		botonVerVentas.setBackground(new Color(0, 0, 128));
		botonVerVentas.setBounds(33, 165, 241, 23);
		contentPane.add(botonVerVentas);
		
		JButton botonRegistrarVenta = new JButton("Registrar venta\r\n");
		botonRegistrarVenta.setBackground(new Color(0, 0, 128));
		botonRegistrarVenta.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		botonRegistrarVenta.setForeground(new Color(255, 255, 255));
		botonRegistrarVenta.setBounds(33, 131, 241, 23);
		contentPane.add(botonRegistrarVenta);
		
		JLabel labelTextoEmpleado = new JLabel("Menu de opciones");
		labelTextoEmpleado.setForeground(new Color(245, 245, 245));
		labelTextoEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		labelTextoEmpleado.setBounds(33, 57, 324, 48);
		contentPane.add(labelTextoEmpleado);
		
		JLayeredPane lpanGeneral = new JLayeredPane();
		lpanGeneral.setBounds(304, 131, 450, 300);
		contentPane.add(lpanGeneral);
		lpanGeneral.setVisible(true);
		lpanGeneral.setLayout(new CardLayout(0, 0));
		
		JPanel panVerMisVentas = new JPanel();
		lpanGeneral.add(panVerMisVentas, "name_99930226415368");
		panVerMisVentas.setVisible(false);
		
		JPanel panAgregarPrendas = new JPanel();
		lpanGeneral.add(panAgregarPrendas, "name_99930253616870");
		panAgregarPrendas.setVisible(false);
		
		//----PANEL VENDEDOR----/
		JPanel panVendedor = new JPanel();
		lpanGeneral.add(panVendedor, "name_99930277307032");
		panVendedor.setVisible(true);
		panVendedor.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Mis Datos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(14, 5, 66, 17);
		panVendedor.add(lblTitulo);
		
		JLabel lblSubTitulo1 = new JLabel("Datos Personales");
		lblSubTitulo1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubTitulo1.setBounds(14, 52, 105, 15);
		panVendedor.add(lblSubTitulo1);
		
		JLabel lblSubTitulo2 = new JLabel("Datos Profecionales");
		lblSubTitulo2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubTitulo2.setBounds(237, 52, 121, 15);
		panVendedor.add(lblSubTitulo2);
		
		JLabel lbMostrarNombre = new JLabel();
		lbMostrarNombre.setBounds(90, 78, 75, 14);
		lbMostrarNombre.setText(empleado.getNombre());
		panVendedor.add(lbMostrarNombre);
		
		JLabel lbMostrarApellido = new JLabel();
		lbMostrarApellido.setBounds(90, 120, 75, 14);
		lbMostrarApellido.setText(empleado.getApellido());
		panVendedor.add(lbMostrarApellido);
		
		JLabel lbMostrarGenero = new JLabel();
		lbMostrarGenero.setBounds(90, 167, 75, 14);
		lbMostrarGenero.setText(empleado.getGenero());
		panVendedor.add(lbMostrarGenero);
				
		JLabel lbMostrarDni = new JLabel();
		lbMostrarDni.setBounds(90, 216, 75, 14);
		lbMostrarDni.setText(empleado.getDni());
		panVendedor.add(lbMostrarDni);
		
		JLabel lbMostrarFechaNac = new JLabel();
		lbMostrarFechaNac.setBounds(90, 262, 75, 14);
		lbMostrarFechaNac.setText(empleado.getFechaNac());
		panVendedor.add(lbMostrarFechaNac);
		
		JLabel lbMostrarEstadoCiv = new JLabel();
		lbMostrarEstadoCiv.setText(empleado.getEstadoCivil());
		lbMostrarEstadoCiv.setBounds(330, 78, 75, 14);
		panVendedor.add(lbMostrarEstadoCiv);
		
		JLabel lbMostrarLegajo = new JLabel();
		lbMostrarLegajo.setBounds(330, 120, 75, 14);
		lbMostrarLegajo.setText(empleado.getLegajo());
		panVendedor.add(lbMostrarLegajo);
		
		JLabel lbMostrarContrasenia = new JLabel();
		lbMostrarContrasenia.setBounds(330, 167, 75, 14);
		lbMostrarContrasenia.setText(empleado.getContraseña());
		panVendedor.add(lbMostrarContrasenia);
		
		JLabel lbMostrarNumTel = new JLabel();
		lbMostrarNumTel.setBounds(330, 216, 75, 14);
		if(empleado instanceof Vendedor) {
			lbMostrarNumTel.setText(((Vendedor) empleado).getTelefono());
		}
		panVendedor.add(lbMostrarNumTel);
		
		JLabel lbTNombre = new JLabel("Nombre:");
		lbTNombre.setBounds(14, 78, 61, 14);
		panVendedor.add(lbTNombre);
		
		JLabel lbTApellido = new JLabel("Apellido:");
		lbTApellido.setBounds(14, 120, 66, 14);
		panVendedor.add(lbTApellido);
		
		JLabel lbTGenero = new JLabel("Genero:");
		lbTGenero.setBounds(14, 167, 66, 14);
		panVendedor.add(lbTGenero);
		
		JLabel lbTEstadoCivil = new JLabel("Estado Civil:");
		lbTEstadoCivil.setBounds(237, 78, 83, 14);
		panVendedor.add(lbTEstadoCivil);
		
		JLabel lbTLegajo = new JLabel("Legajo:");
		lbTLegajo.setBounds(237, 120, 83, 14);
		panVendedor.add(lbTLegajo);
		
		JLabel lbTContrasenia = new JLabel("Contrasenia:");
		lbTContrasenia.setBounds(237, 167, 83, 14);
		panVendedor.add(lbTContrasenia);
		
		JLabel lbTTelefono = new JLabel("Telefono:");
		lbTTelefono.setBounds(237, 216, 83, 14);
		panVendedor.add(lbTTelefono);
		
		JLabel lbTDni = new JLabel("DNI:");
		lbTDni.setBounds(14, 216, 66, 14);
		panVendedor.add(lbTDni);
		
		JLabel lbTFechaNac = new JLabel("Fecha Nac:");
		lbTFechaNac.setBounds(14, 262, 66, 14);
		panVendedor.add(lbTFechaNac);
		//--------/
		
		//----PANEL REGISTRAR VENTA----/
		JPanel panRegistrarVenta = new JPanel();
		lpanGeneral.add(panRegistrarVenta, "name_99930197253561");
		panRegistrarVenta.setVisible(false);		
		panRegistrarVenta.setLayout(null);
		
		JComboBox cbCliente = new JComboBox();
		ArrayList<Cliente> clientes = tiendaDeRopa.devolverClientes();
		StringBuilder clientesCadena = new StringBuilder("{");
		for(Cliente elem : clientes) {
			clientesCadena.append(elem.getNombre()+",");
		}
		clientesCadena.deleteCharAt(clientesCadena.length()-1);
		//JOptionPane.showMessageDialog(null, clientesCadena);
		cbCliente.setModel(new DefaultComboBoxModel(new String[] {"clientes"}));
		cbCliente.setBounds(20, 4, 98, 20);
		panRegistrarVenta.add(cbCliente);
		Date fechaActual = new Date();
		JLabel lblFecha = new JLabel(fechaActual.toString());
		lblFecha.setBounds(149, 7, 154, 14);
		panRegistrarVenta.add(lblFecha);
		
		JButton btnFinalizarVenta = new JButton("Finalizar");
		btnFinalizarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizarVenta.setForeground(new Color(255, 255, 255));
		btnFinalizarVenta.setBackground(new Color(0, 0, 128));
		btnFinalizarVenta.setBounds(342, 4, 87, 25);
		panRegistrarVenta.add(btnFinalizarVenta);
		
		JList listPrendas = new JList();
		listPrendas.setBounds(20, 38, 409, 97);
		panRegistrarVenta.add(listPrendas);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(124, 146, 44, 20);
		panRegistrarVenta.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lbIndiqueCantidad = new JLabel("Indique Cantidad:");
		lbIndiqueCantidad.setBounds(20, 146, 98, 20);
		panRegistrarVenta.add(lbIndiqueCantidad);
		
		JButton btnAgregarAlCarro = new JButton("Agregar al Carro");
		btnAgregarAlCarro.setBounds(228, 145, 154, 23);
		panRegistrarVenta.add(btnAgregarAlCarro);
		
		JList listCarro = new JList();
		listCarro.setBounds(20, 177, 409, 79);
		panRegistrarVenta.add(listCarro);
		
		JButton btnEliminarDelCarro = new JButton("Eliminar del Carro");
		btnEliminarDelCarro.setBounds(228, 267, 154, 23);
		panRegistrarVenta.add(btnEliminarDelCarro);
		
		JLabel lbPrecioFinal = new JLabel("New label");
		lbPrecioFinal.setBounds(30, 267, 138, 23);
		panRegistrarVenta.add(lbPrecioFinal);
		//--------/
		
		//----PANEL MODIFICAR DATOS PERSONALES----/
		JPanel panModificarDatosPer = new JPanel();
		lpanGeneral.add(panModificarDatosPer, "name_130561065365849");
		panModificarDatosPer.setLayout(null);
		
		JLabel lblVendedorTitulo = new JLabel("Mis Datos");
		lblVendedorTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVendedorTitulo.setBounds(20, 11, 85, 25);
		panModificarDatosPer.add(lblVendedorTitulo);
		
		JLabel lblVendedorSubTitulo1 = new JLabel("Datos Personales");
		lblVendedorSubTitulo1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVendedorSubTitulo1.setBounds(20, 47, 125, 25);
		panModificarDatosPer.add(lblVendedorSubTitulo1);
		
		JLabel lblVendedorSubTitulo2 = new JLabel("Datos Profecionales");
		lblVendedorSubTitulo2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVendedorSubTitulo2.setBounds(233, 47, 128, 25);
		panModificarDatosPer.add(lblVendedorSubTitulo2);
		
		JButton btnVendedorGuardar = new JButton("Guardar");
		btnVendedorGuardar.setBackground(new Color(0, 0, 128));
		btnVendedorGuardar.setForeground(new Color(255, 255, 255));
		btnVendedorGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVendedorGuardar.setBounds(338, 13, 102, 23);
		panModificarDatosPer.add(btnVendedorGuardar);
		
		textVendedorNombre = new JTextField();
		textVendedorNombre.setBounds(20, 92, 125, 20);
		textVendedorNombre.setText(empleado.getNombre());
		panModificarDatosPer.add(textVendedorNombre);
		textVendedorNombre.setColumns(10);
		
		textVendedorApellido = new JTextField();
		textVendedorApellido.setBounds(20, 138, 125, 20);
		textVendedorApellido.setText(empleado.getApellido());
		panModificarDatosPer.add(textVendedorApellido);
		textVendedorApellido.setColumns(10);
		
		JComboBox cbVendedorGenero = new JComboBox();
		cbVendedorGenero.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Masculino", "Femenino", "Otros"}));
		cbVendedorGenero.setSelectedIndex(empleado.getGeneroInt());
		cbVendedorGenero.setBounds(20, 180, 125, 20);
		panModificarDatosPer.add(cbVendedorGenero);
		
		JComboBox cbVendedorEstadoCiv = new JComboBox();
		cbVendedorEstadoCiv.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Soltero/a", "Comprometido/a", "Noviazgo", "Relacion", "Casado/a", "Union Libre", "Separado/a", "Divorciado/a", "Viudo/a"}));
		cbVendedorEstadoCiv.setSelectedIndex(empleado.getEstadoCivilInt());
		cbVendedorEstadoCiv.setBounds(233, 92, 125, 20);
		panModificarDatosPer.add(cbVendedorEstadoCiv);
		
		textVendedorLegajo = new JTextField();
		textVendedorLegajo.setBounds(233, 138, 125, 20);
		textVendedorLegajo.setText(empleado.getLegajo());
		panModificarDatosPer.add(textVendedorLegajo);
		textVendedorLegajo.setColumns(10);
		
		textVendedorContrasenia = new JTextField();
		textVendedorContrasenia.setBounds(233, 180, 125, 20);
		textVendedorContrasenia.setText(empleado.getContraseña());
		panModificarDatosPer.add(textVendedorContrasenia);
		textVendedorContrasenia.setColumns(10);
		
		textVendedorNumTel = new JTextField();
		textVendedorNumTel.setBounds(233, 224, 125, 20);
		if(empleado instanceof Vendedor) {
			textVendedorNumTel.setText(((Vendedor) empleado).getTelefono());
		}
		panModificarDatosPer.add(textVendedorNumTel);
		textVendedorNumTel.setColumns(10);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setBounds(20, 78, 71, 14);
		panModificarDatosPer.add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido:");
		lbApellido.setBounds(20, 123, 71, 14);
		panModificarDatosPer.add(lbApellido);
		
		JLabel lbGenero = new JLabel("Genero:");
		lbGenero.setBounds(20, 165, 71, 14);
		panModificarDatosPer.add(lbGenero);
		
		JLabel lbEstadoCivil = new JLabel("Estado Civil:");
		lbEstadoCivil.setBounds(233, 78, 94, 14);
		panModificarDatosPer.add(lbEstadoCivil);
		
		JLabel lbLegajo = new JLabel("Legajo:");
		lbLegajo.setBounds(233, 123, 94, 14);
		panModificarDatosPer.add(lbLegajo);
		
		JLabel lbContrasenia = new JLabel("Contrasenia:");
		lbContrasenia.setBounds(233, 165, 94, 14);
		panModificarDatosPer.add(lbContrasenia);
		
		JLabel lbTelefono = new JLabel("Telefono:");
		lbTelefono.setBounds(233, 211, 71, 14);
		panModificarDatosPer.add(lbTelefono);
		
		panModificarDatosPer.setVisible(false);
		contentPane.add(botonAtras);
		
		JLabel jLabelFondo = new JLabel();
		jLabelFondo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jLabelFondo.setText("Atr\u00E1s");
		jLabelFondo.setForeground(new Color(255, 255, 255));
		jLabelFondo.setBackground(new Color(255, 255, 255));
		jLabelFondo.setBounds(0,0, 800, 475);
		jLabelFondo.setIcon(new ImageIcon(VentanaOpcionesEmpleado.class.getResource("/Imagenes/wallPaper blue.jpg")));
		contentPane.add(jLabelFondo);
		
		btnVendedorGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Empleado modificacion = new Vendedor(textVendedorNombre.getText(), textVendedorApellido.getText(),
						empleado.getDni(), cbVendedorGenero.getSelectedIndex(), empleado.getFechaNac(),
						cbVendedorEstadoCiv.getSelectedIndex(), textVendedorNumTel.getText(), textVendedorLegajo.getText(),
						textVendedorContrasenia.getText());
				if(empleado.getLegajo().equals(modificacion.getLegajo())) {
					tiendaDeRopa.modificarEmpleado(modificacion.getLegajo(), modificacion);
				}
				else {
					tiendaDeRopa.bajaEmpleado(empleado.getLegajo());
					tiendaDeRopa.agregarEmpleado(modificacion.getLegajo(), modificacion);
				}
				if(modificacion instanceof Vendedor) {
					empleado.setNombre(modificacion.getNombre());
					empleado.setApellido(modificacion.getApellido());
					empleado.setGenero(modificacion.getGeneroInt());
					empleado.setEstadoCivil(modificacion.getEstadoCivilInt());
					((Vendedor) empleado).setTelefono(((Vendedor) modificacion).getTelefono());
					empleado.setLegajo(modificacion.getLegajo());
					empleado.setContraseña(modificacion.getContraseña());
					
					botonNombreEmpleado.setText(empleado.getNombre()+" "+empleado.getApellido());
				}
			}
		});
		//--------/		
		
		accionBotonPaneles(botonRegistrarVenta, panRegistrarVenta, panAgregarPrendas, panVendedor, panVerMisVentas, panVerMisVentas);
		accionBotonPaneles(botonVerVentas, panVerMisVentas, panAgregarPrendas, panVendedor, panRegistrarVenta, panModificarDatosPer);
		accionBotonPaneles(botonModificarDatosPersonales, panModificarDatosPer, panAgregarPrendas, panVendedor, panRegistrarVenta, panRegistrarVenta);
		accionBotonPaneles(botonAgregarPrendaDeVestir, panAgregarPrendas, panVerMisVentas, panVendedor, panRegistrarVenta, panModificarDatosPer);
		accionBotonPaneles(botonNombreEmpleado, panVendedor, panAgregarPrendas, panVerMisVentas, panRegistrarVenta, panModificarDatosPer);
	}
	
	public void accionBotonPaneles(JButton boton, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
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
}
