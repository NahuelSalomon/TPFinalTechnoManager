package VentanasGraficas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import ClasesPersona.ClienteMinorista;
import ClasesPersona.Empleado;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.Buzo;
import ClasesPrendasDeVestir.Calzado;
import ClasesPrendasDeVestir.Maya;
import ClasesPrendasDeVestir.Pantalon;
import ClasesPrendasDeVestir.PrendaDeVestir;
import ClasesPrendasDeVestir.Remera;
import Excepciones.ErrorDeBusquedaExcepcion;
import TiendaDeRopa.TiendaDeRopa;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

/**
 * Esta es la clase para crear y manejar la clase de la ventana para las opciones clientes, dandole una interfaz visual amigable para el usuario
 * @author Nahuel
 *
 */
public class VentanaOpcionesGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panelListarEmpleados;
	private JPanel panelListarVentas;
	private JPanel panelListarPrendas;
	private JPanel panelListarClientes;
	private JPanel panelBorrarUnEmpleado;
	private JPanel panelBorrarUnaPrenda;
	private JPanel panelBorrarUnCliente;
	private JPanel panelBorrarUnaVenta;
	private JPanel panelBuscarEmpleado;
	private JPanel panelBuscarPrenda;
	private JPanel panelModificarUnCliente;
	private JPanel panelAAgregarStock;
	private JPanel panelAgregarUnCliente;
	private JPanel panelBuscarUnaVenta;
	private JPanel panelAgregarUnaPrenda;
	private JPanel panelBuscarCliente;
	private JPanel panelRemera;
	private JPanel panelBuzo;
	private JPanel panelCalzado;
	private JPanel panelPantalon;
	private JPanel panelMaya;
	private JPanel panelVentasVendedores;
	private JPanel panelVentasAClientes;
	private JPanel panelDatosVentasTotales;
	
	private JTextArea textAreaListarClientes;
	private JTextArea textAreaListarPrendas;
	private JTextArea textAreaListarEmpleados;
	private JTextArea textAreaVerVentas;
	private JTextArea textAreaPrendaABorrar;
	private JTextArea textAreaBorrarEmpleado;
	private JTextArea textAreaClientesABorrar;
	private JTextArea textAreaVentasABorrar;
	private JTextArea textAreaEmpleadoBuscado;
	private JTextArea textAreaPrendaBuscada;
	private JTextArea textAreaClienteBuscado;
	private JTextArea textAreaPrendaABuscar;
	private JTextArea textAreaPrendasAAgregarStock;
	private JTextArea textAreaDetalleDeAgregado;
	private JTextArea textAreaPosibleVentasAClientes;
	private JTextArea textAreaVentasACliente;
	private JTextArea textAreaVentasVendedores;
	private JTextArea textAreaPosiblesVentasVendedores;
	private JTextArea textAreaClientesModificables;
	private JTextArea textAreaLegajosDeEmpleados;
	private JTextArea textAreaClientesABuscar;

	private JButton btnCerrarSesion;
	private JButton botonListarEmpleados;
	private JButton botonBorrarEmpleado;
	private JButton botonBorrarPrenda_1;
	private JButton botonParaBorrarCliente;
	private JButton botonParaBorrarVenta;
	private JButton botonParaBuscarEmpleado;
	private JButton botonParaBuscarUnaPrenda;
	private JButton botonParaBuscarUnCliente;
	private JButton botonParaAgregarUnaPrenda;
	private JButton botonBuscarPrendaStock;
	private JButton botonParaAgregarStock;
	private JButton botonParaAgregarCliente;
	private JButton botonVerVentasAClientes;
	private JButton botonVerVentasVendedores;
	private JButton botonBuscarClienteAModificar;
	private JButton botonGuardarCambios;

	private JTextField textFieldDniClienteABorrar;
	private JTextField textFieldBorrarVenta;
	private JTextField textFieldEmpleadoABuscar;
	private JTextField textFieldPrendaABuscar;
	private JTextField textFieldDniClienteABuscar;
	private JTextField textFieldModelo;
	private JTextField textFieldColor;
	private JTextField textFieldPrecio;
	private JTextField textFieldTipoEstamRemera;
	private JTextField textFieldLegajoBorrarEmpleado;
	private JTextField textFieldCodigoPrendaABorrar;
	private JTextField textFieldPrendaABuscarStock;
	private JTextField textFieldTalle;
	private JTextField textFieldNombreCliente;
	private JTextField textFieldApellidoCliente;
	private JTextField textFieldDNICliente;
	private JTextField textFieldDomicilioCliente;
	private JTextField textFieldEmailCliente;
	private JTextField textFieldCUITCliente;
	private JTextField textFieldEmailAModificar;
	private JTextField textFieldCantidadDeVentas;
	private JTextField textFieldVentasTotales;
	private JTextField textFieldDNIDelClienteAVerVentas;
	private JTextField textFieldVentasPromedio;
	private JTextField textFieldCantidadPrendasVendidas;
	private JTextField textFieldNombreAModificar;
	private JTextField textFieldApellidoAModificar;
	private JTextField textFieldDomicilioAModificar;
	private JTextField textFieldLegajoABuscarVentas;
	private JTextField textFieldDNIClienteAModificar;
	
	private JComboBox comboBoxTipoDePrenda;
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxTipoDeMaterial;
	private JComboBox comboBoxTipoDeMangaRemera;
	private JComboBox comboBoxTipoDeMangaBuzo;
	private JComboBox comboBoxTipoDeBuzo;
	private JComboBox comboBoxTipoDeSuela;
	private JComboBox comboBoxPantalonEsAlCuerpo;
	private JComboBox comboBoxMayaEsSecadoRapido;
	private JComboBox comboBoxMayaArribaRodiyas;
	private JComboBox comboBoxCantidad;
	private JComboBox comboBoxCondicionFrenteAlIVACliente;
	private JComboBox comboBoxTipoDeCliente;
	private JComboBox comboBoxAñoCliente;
	private JComboBox comboBoxMesCliente;
	private JComboBox comboBoxDiaCliente;
	private JComboBox comboBoxCondicionFrenteAlIVAAModificar;
	private JComboBox comboBoxSexoClienteAModificar;
	private JComboBox comboBoxCriterioDeBusquedaVentas;
	
	private JRadioButton radioButtonPerzonalizadoCliente;
	private JRadioButton radioButtonHombreCliente;
	private JRadioButton radioButtonMujerCliente;

	private JLabel labelDniDelClienteAVerVentas;
	private JLabel labelMontoDeVentas;
	private JLabel labelCantidadDeVentas;
	private JLabel labelTicketPromedioDe;
	private JLabel labelSeleccioneElCriterio;
	private JLabel labelCantidadPrendasVendidas;
	private JLabel labelDomicilioAModificar;
	private JLabel labelEmailAModificar;
	private JLabel labelCondicionIVAAModificar;
	private JLabel labelApellidoAModificar;
	private JLabel labelSexoAModificar;
	private JLabel labelLegajoDelVendedor;
	private JLabel labelDni;
	private JLabel labelNombre;
	
	private JScrollPane scrollPaneVentasHechasPorVendedores;
	private JScrollPane scrollPanePosiblesVentasPorVendedores;
	private JScrollPane scrollPanePosiblesVentasAClientes;
	private JScrollPane scrollPaneVentasAClientes;
	private JScrollPane scrollPaneClientesModificables;
	
	private JLayeredPane layeredPaneCriterioDeBusquedaVentas;
	
	/**
	 * Constructor de la clase ventana gerente
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public VentanaOpcionesGerente(TiendaDeRopa tiendaDeRopa) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 520);
		setUndecorated(true);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 301, 450, 205);
		contentPane.add(layeredPane);
		layeredPane.setVisible(true);
		layeredPane.setLayout(new CardLayout(0, 0));
	
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCerrarSesion.setBackground(new Color(0, 0, 128));
		btnCerrarSesion.setBounds(10, 14, 130, 23);
		contentPane.add(btnCerrarSesion);
		
		botonListarEmpleados = new JButton("Listar empleados\r\n");
		botonListarEmpleados.setForeground(Color.WHITE);
		botonListarEmpleados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonListarEmpleados.setBackground(new Color(0, 0, 128));
		botonListarEmpleados.setBounds(19, 143, 197, 23);
		contentPane.add(botonListarEmpleados);
		
		JButton botonDatosDeVentasTotales = new JButton("Datos ventas totales");
		botonDatosDeVentasTotales.setForeground(Color.WHITE);
		botonDatosDeVentasTotales.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonDatosDeVentasTotales.setBackground(new Color(0, 0, 128));
		botonDatosDeVentasTotales.setBounds(492, 441, 197, 23);
		contentPane.add(botonDatosDeVentasTotales);
		
		JButton botonListarClientes = new JButton("Listar clientes\r\n\r\n");
		botonListarClientes.setForeground(Color.WHITE);
		botonListarClientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonListarClientes.setBackground(new Color(0, 0, 128));
		botonListarClientes.setBounds(489, 177, 197, 23);
		contentPane.add(botonListarClientes);
		
		JButton botonAgregarCliente = new JButton("Agregar cliente\r\n\r\n");
		botonAgregarCliente.setForeground(Color.WHITE);
		botonAgregarCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonAgregarCliente.setBackground(new Color(0, 0, 128));
		botonAgregarCliente.setBounds(489, 109, 197, 23);
		contentPane.add(botonAgregarCliente);
		
		JButton BotonModificarCliente = new JButton("Modificar cliente");
		BotonModificarCliente.setForeground(Color.WHITE);
		BotonModificarCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		BotonModificarCliente.setBackground(new Color(0, 0, 128));
		BotonModificarCliente.setBounds(489, 211, 197, 23);
		contentPane.add(BotonModificarCliente);
		
		JButton botonBorrarCliente = new JButton("Borrar cliente");
		botonBorrarCliente.setForeground(Color.WHITE);
		botonBorrarCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarCliente.setBackground(new Color(0, 0, 128));
		botonBorrarCliente.setBounds(489, 143, 197, 23);
		contentPane.add(botonBorrarCliente);
		
		JButton botonBuscarCliente = new JButton("Buscar cliente\r\n");
		botonBuscarCliente.setForeground(Color.WHITE);
		botonBuscarCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarCliente.setBackground(new Color(0, 0, 128));
		botonBuscarCliente.setBounds(489, 245, 197, 23);
		contentPane.add(botonBuscarCliente);
		
		JButton botonBorrarUnaVenta = new JButton("Borrar una venta");
		botonBorrarUnaVenta.setBackground(new Color(0, 0, 128));
		botonBorrarUnaVenta.setForeground(new Color(255, 255, 255));
		botonBorrarUnaVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarUnaVenta.setBounds(492, 373, 197, 23);
		contentPane.add(botonBorrarUnaVenta);
		
		JButton botonBuscarPrenda = new JButton("Buscar prenda\r\n");
		botonBuscarPrenda.setForeground(Color.WHITE);
		botonBuscarPrenda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarPrenda.setBackground(new Color(0, 0, 128));
		botonBuscarPrenda.setBounds(255, 245, 197, 23);
		contentPane.add(botonBuscarPrenda);
		
		JButton botonBuscarUnEmpleado = new JButton("Buscar empleado"); 
		botonBuscarUnEmpleado.setForeground(Color.WHITE);
		botonBuscarUnEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarUnEmpleado.setBackground(new Color(0, 0, 128));
		botonBuscarUnEmpleado.setBounds(19, 177, 197, 23);
		contentPane.add(botonBuscarUnEmpleado);
		
		JButton botonBorrarUnEmpleado = new JButton("Borrar empleado\r\n");
		botonBorrarUnEmpleado.setBackground(new Color(0, 0, 128));
		botonBorrarUnEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarUnEmpleado.setForeground(new Color(255, 255, 255));
		botonBorrarUnEmpleado.setBounds(19, 109, 197, 23);
		contentPane.add(botonBorrarUnEmpleado);
		
		JButton botonBuscarVenta = new JButton("Buscar una venta");
		botonBuscarVenta.setBackground(new Color(0, 0, 128));
		botonBuscarVenta.setForeground(new Color(255, 255, 255));
		botonBuscarVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarVenta.setBounds(492, 407, 197, 23);
		contentPane.add(botonBuscarVenta);
		
		JButton botonRegistroVentas = new JButton("Ver ventas");
		botonRegistroVentas.setBackground(new Color(0, 0, 128));
		botonRegistroVentas.setForeground(Color.WHITE);
		botonRegistroVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonRegistroVentas.setBounds(492, 339, 197, 23);
		contentPane.add(botonRegistroVentas);

		JButton botonListarPrendas = new JButton("Listar prendas\r\n\r\n");
		botonListarPrendas.setForeground(Color.WHITE);
		botonListarPrendas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonListarPrendas.setBackground(new Color(0, 0, 128));
		botonListarPrendas.setBounds(255, 177, 197, 23);
		contentPane.add(botonListarPrendas);
		
		JButton botonBorrarPrenda = new JButton("Borrar prenda");
		botonBorrarPrenda.setForeground(Color.WHITE);
		botonBorrarPrenda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarPrenda.setBackground(new Color(0, 0, 128));
		botonBorrarPrenda.setBounds(255, 143, 197, 23);
		contentPane.add(botonBorrarPrenda);
		
		JButton botonAgregarPrenda = new JButton("Agregar prenda\r\n\r\n");
		botonAgregarPrenda.setForeground(Color.WHITE);
		botonAgregarPrenda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonAgregarPrenda.setBackground(new Color(0, 0, 128));
		botonAgregarPrenda.setBounds(255, 109, 197, 23);
		contentPane.add(botonAgregarPrenda);
		
		JButton botonModificarStock = new JButton("Agregar Stock");
		botonModificarStock.setForeground(Color.WHITE);
		botonModificarStock.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonModificarStock.setBackground(new Color(0, 0, 128));
		botonModificarStock.setBounds(255, 211, 197, 23);
		contentPane.add(botonModificarStock);
		
		
		/*
		 * JLabel
		 */
		JLabel labelOpcionesClientes = new JLabel("Opciones clientes\r\n");
		labelOpcionesClientes.setForeground(Color.WHITE);
		labelOpcionesClientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelOpcionesClientes.setBounds(490, 76, 150, 20);
		contentPane.add(labelOpcionesClientes);
		
		JLabel labelFondoOpcionesCliente = new JLabel("");
		labelFondoOpcionesCliente.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelFondoOpcionesCliente.setForeground(Color.GRAY);
		labelFondoOpcionesCliente.setBackground(Color.GRAY);
		labelFondoOpcionesCliente.setBounds(480, 71, 214, 205);
		contentPane.add(labelFondoOpcionesCliente);
		
		JLabel labelOpcionesPrendas = new JLabel("Opciones prendas");
		labelOpcionesPrendas.setForeground(Color.WHITE);
		labelOpcionesPrendas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelOpcionesPrendas.setBounds(256, 76, 150, 20);
		contentPane.add(labelOpcionesPrendas);
		
		JLabel lblOpcionesEmpleados = new JLabel("Opciones empleados");
		lblOpcionesEmpleados.setForeground(Color.WHITE);
		lblOpcionesEmpleados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblOpcionesEmpleados.setBounds(20, 76, 150, 20);
		contentPane.add(lblOpcionesEmpleados);
		
		JLabel lblOpcionesVentas = new JLabel("Opciones ventas");
		lblOpcionesVentas.setForeground(Color.WHITE);
		lblOpcionesVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblOpcionesVentas.setBounds(492, 306, 117, 20);
		contentPane.add(lblOpcionesVentas);
		
		JLabel labelEmpleados = new JLabel("");
		labelEmpleados.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelEmpleados.setBounds(10, 71, 214, 205);
		contentPane.add(labelEmpleados);
		
		JLabel labelVentas = new JLabel("");
		labelVentas.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelVentas.setBounds(480, 301, 214, 205);
		contentPane.add(labelVentas);
		
		JLabel labelMenuDeOpciones = new JLabel("Menu de opciones");
		labelMenuDeOpciones.setBackground(Color.BLACK);
		labelMenuDeOpciones.setForeground(Color.WHITE);
		labelMenuDeOpciones.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelMenuDeOpciones.setBounds(411, 12, 301, 48);
		contentPane.add(labelMenuDeOpciones);
		
		JLabel labelFondoOpcionesPrendas = new JLabel("");
		labelFondoOpcionesPrendas.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelFondoOpcionesPrendas.setForeground(Color.GRAY);
		labelFondoOpcionesPrendas.setBackground(Color.GRAY);
		labelFondoOpcionesPrendas.setBounds(246, 71, 214, 205);
		contentPane.add(labelFondoOpcionesPrendas);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBounds(0, 0, 705, 520);
		labelFondo.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/FondoVentanaGerente2.jpg")));
		contentPane.add(labelFondo);
		
		
		
		
		/*
		 * Panel listar clientes
		 */
		panelListarClientes = new JPanel();
		panelListarClientes.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelListarClientes, "name_15380886406500");
		panelListarClientes.setVisible(false);
		panelListarClientes.setLayout(null);
		
		JScrollPane scrollPaneListarClientes = new JScrollPane();
		scrollPaneListarClientes.setBounds(0, 0, 450, 205);
		panelListarClientes.add(scrollPaneListarClientes);
		
		textAreaListarClientes = new JTextArea();
		scrollPaneListarClientes.setViewportView(textAreaListarClientes);
		textAreaListarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaListarClientes.setBackground(new Color(0, 0, 128));
		textAreaListarClientes.setForeground(new Color(255, 255, 255));
		textAreaListarClientes.setText(tiendaDeRopa.listarClientes());
		
		
		/*
		 * Panel listar prendas
		 */
		panelListarPrendas = new JPanel();
		panelListarPrendas.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelListarPrendas, "name_15321474268500");
		panelListarPrendas.setVisible(false);
		panelListarPrendas.setLayout(null);
		
		JScrollPane scrollPaneListarPrendas = new JScrollPane();
		scrollPaneListarPrendas.setBounds(0, 0, 450, 205);
		panelListarPrendas.add(scrollPaneListarPrendas);
		
		textAreaListarPrendas = new JTextArea();
		scrollPaneListarPrendas.setViewportView(textAreaListarPrendas);
		textAreaListarPrendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaListarPrendas.setForeground(new Color(255, 255, 255));
		textAreaListarPrendas.setBackground(new Color(0, 0, 128));
		textAreaListarPrendas.setText(tiendaDeRopa.listarPrenda());
		
		
		/*
		 * Panel listar empleados
		 */
		panelListarEmpleados = new JPanel();
		panelListarEmpleados.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelListarEmpleados, "name_12927935132700");
		panelListarEmpleados.setVisible(false);
		panelListarEmpleados.setLayout(null);
		
		JScrollPane scrollPaneListarEmpleados = new JScrollPane();
		scrollPaneListarEmpleados.setBounds(0, 0, 450, 205);
		panelListarEmpleados.add(scrollPaneListarEmpleados);
		
		textAreaListarEmpleados = new JTextArea();
		scrollPaneListarEmpleados.setViewportView(textAreaListarEmpleados);
		textAreaListarEmpleados.setForeground(new Color(255, 255, 255));
		textAreaListarEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaListarEmpleados.setEditable(false);
		textAreaListarEmpleados.setBackground(new Color(0, 0, 128));
		textAreaListarEmpleados.setText(tiendaDeRopa.listarEmpleados());
		
		
		/*
		 * Panel listar ventas
		 */
		panelListarVentas = new JPanel();
		layeredPane.add(panelListarVentas, "name_18334135784300");
		panelListarClientes.setVisible(false);
		panelListarVentas.setLayout(null);
		
		JScrollPane scrollPaneVerVentas = new JScrollPane();
		scrollPaneVerVentas.setBounds(0, 0, 450, 205);
		panelListarVentas.add(scrollPaneVerVentas);
		
		textAreaVerVentas = new JTextArea();
		scrollPaneVerVentas.setViewportView(textAreaVerVentas);
		textAreaVerVentas.setBackground(new Color(0, 0, 128));
		textAreaVerVentas.setForeground(new Color(255, 255, 255));
		textAreaVerVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaVerVentas.setText(tiendaDeRopa.listarVentas());
		
		
		/*
		 * Panel borrar un empleado
		 */
		panelBorrarUnEmpleado = new JPanel();
		panelBorrarUnEmpleado.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBorrarUnEmpleado, "name_19173504223300");
		panelBorrarUnEmpleado.setVisible(false);
		panelBorrarUnEmpleado.setLayout(null);
		
		JLabel labelLegajoBorrarEmpleado = new JLabel("Ingrese el legajo del empleado que desea borrar");
		labelLegajoBorrarEmpleado.setForeground(new Color(255, 255, 255));
		labelLegajoBorrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLegajoBorrarEmpleado.setBounds(10, 11, 400, 28);
		panelBorrarUnEmpleado.add(labelLegajoBorrarEmpleado);
		
		textFieldLegajoBorrarEmpleado = new JTextField();
		textFieldLegajoBorrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldLegajoBorrarEmpleado.setForeground(new Color(255, 255, 255));
		textFieldLegajoBorrarEmpleado.setBackground(new Color(0, 0, 139));
		textFieldLegajoBorrarEmpleado.setBounds(10, 44, 113, 26);
		panelBorrarUnEmpleado.add(textFieldLegajoBorrarEmpleado);
		textFieldLegajoBorrarEmpleado.setColumns(10);
		
		botonBorrarEmpleado = new JButton("Borrar empleado");
		botonBorrarEmpleado.setBackground(new Color(0, 0, 128));
		botonBorrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBorrarEmpleado.setForeground(new Color(255, 255, 255));
		botonBorrarEmpleado.setBounds(143, 44, 173, 28);
		panelBorrarUnEmpleado.add(botonBorrarEmpleado);
		
		JScrollPane scrollPaneAreaEmpleadosAAborrar = new JScrollPane();
		scrollPaneAreaEmpleadosAAborrar.setBounds(10, 81, 306, 113);
		panelBorrarUnEmpleado.add(scrollPaneAreaEmpleadosAAborrar);
		
		textAreaBorrarEmpleado = new JTextArea();
		textAreaBorrarEmpleado.setForeground(new Color(255, 255, 255));
		textAreaBorrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPaneAreaEmpleadosAAborrar.setViewportView(textAreaBorrarEmpleado);
		textAreaBorrarEmpleado.setBackground(new Color(0, 0, 139));
		textAreaBorrarEmpleado.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());
		
		/*
		 * Panel borrar una prenda
		 */
		panelBorrarUnaPrenda = new JPanel();
		panelBorrarUnaPrenda.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBorrarUnaPrenda, "name_79673793627300");
		panelBorrarUnaPrenda.setLayout(null);
		
		JLabel labelBorrarUnaPrenda = new JLabel("Ingrese el codigo de la prenda que desea borrar");
		labelBorrarUnaPrenda.setForeground(Color.WHITE);
		labelBorrarUnaPrenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelBorrarUnaPrenda.setBounds(10, 11, 400, 28);
		panelBorrarUnaPrenda.add(labelBorrarUnaPrenda);
		
		textFieldCodigoPrendaABorrar = new JTextField();
		textFieldCodigoPrendaABorrar.setForeground(Color.WHITE);
		textFieldCodigoPrendaABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCodigoPrendaABorrar.setColumns(10);
		textFieldCodigoPrendaABorrar.setBackground(new Color(0, 0, 139));
		textFieldCodigoPrendaABorrar.setBounds(10, 44, 113, 26);
		panelBorrarUnaPrenda.add(textFieldCodigoPrendaABorrar);
		
		botonBorrarPrenda_1 = new JButton("Borrar prenda");
		botonBorrarPrenda_1.setForeground(Color.WHITE);
		botonBorrarPrenda_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBorrarPrenda_1.setBackground(new Color(0, 0, 128));
		botonBorrarPrenda_1.setBounds(143, 44, 173, 28);
		panelBorrarUnaPrenda.add(botonBorrarPrenda_1);
		
		JScrollPane scrollPaneAreaPrendasABorrar = new JScrollPane();
		scrollPaneAreaPrendasABorrar.setBounds(10, 81, 304, 111);
		panelBorrarUnaPrenda.add(scrollPaneAreaPrendasABorrar);
		
		textAreaPrendaABorrar = new JTextArea();
		scrollPaneAreaPrendasABorrar.setViewportView(textAreaPrendaABorrar);
		textAreaPrendaABorrar.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		textAreaPrendaABorrar.setForeground(Color.WHITE);
		textAreaPrendaABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaPrendaABorrar.setBackground(new Color(0, 0, 139));
		
		/*
		 * Panel borrar cliente
		 */
		panelBorrarUnCliente = new JPanel();
		panelBorrarUnCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBorrarUnCliente, "name_82339381709400");
		panelBorrarUnCliente.setLayout(null);
		
		textFieldDniClienteABorrar = new JTextField();
		textFieldDniClienteABorrar.setForeground(Color.WHITE);
		textFieldDniClienteABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDniClienteABorrar.setColumns(10);
		textFieldDniClienteABorrar.setBackground(new Color(0, 0, 139));
		textFieldDniClienteABorrar.setBounds(10, 44, 113, 26);
		panelBorrarUnCliente.add(textFieldDniClienteABorrar);
		
		JLabel labelClienteABorrar = new JLabel("Ingrese el dni del cliente que desea borrar");
		labelClienteABorrar.setForeground(Color.WHITE);
		labelClienteABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelClienteABorrar.setBounds(10, 11, 400, 28);
		panelBorrarUnCliente.add(labelClienteABorrar);
		
		botonParaBorrarCliente = new JButton("Borrar cliente");
		botonParaBorrarCliente.setForeground(Color.WHITE);
		botonParaBorrarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaBorrarCliente.setBackground(new Color(0, 0, 128));
		botonParaBorrarCliente.setBounds(143, 44, 173, 28);
		panelBorrarUnCliente.add(botonParaBorrarCliente);
		
		JScrollPane scrollPaneClientesABorrar = new JScrollPane();
		scrollPaneClientesABorrar.setBounds(11, 82, 302, 109);
		panelBorrarUnCliente.add(scrollPaneClientesABorrar);
		
		textAreaClientesABorrar = new JTextArea();
		scrollPaneClientesABorrar.setViewportView(textAreaClientesABorrar);
		textAreaClientesABorrar.setText((tiendaDeRopa.devolverClientesConSuNombreApellidoYDni()));
		textAreaClientesABorrar.setForeground(Color.WHITE);
		textAreaClientesABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaClientesABorrar.setBackground(new Color(0, 0, 139));
		
		/*
		 * Panel borrar una venta
		 */
		panelBorrarUnaVenta = new JPanel();
		panelBorrarUnaVenta.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBorrarUnaVenta, "name_84771408600400");
		panelBorrarUnaVenta.setLayout(null);
		
		textFieldBorrarVenta = new JTextField();
		textFieldBorrarVenta.setForeground(Color.WHITE);
		textFieldBorrarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBorrarVenta.setColumns(10);
		textFieldBorrarVenta.setBackground(new Color(0, 0, 139));
		textFieldBorrarVenta.setBounds(10, 44, 113, 26);
		panelBorrarUnaVenta.add(textFieldBorrarVenta);
		
		JLabel labelVentaABorrar = new JLabel("Ingrese el ID de la venta que desea borrar");
		labelVentaABorrar.setForeground(Color.WHITE);
		labelVentaABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelVentaABorrar.setBounds(10, 11, 400, 28);
		panelBorrarUnaVenta.add(labelVentaABorrar);
		
		botonParaBorrarVenta = new JButton("Borrar venta");
		botonParaBorrarVenta.setForeground(Color.WHITE);
		botonParaBorrarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaBorrarVenta.setBackground(new Color(0, 0, 128));
		botonParaBorrarVenta.setBounds(143, 44, 173, 28);
		panelBorrarUnaVenta.add(botonParaBorrarVenta);
		
		JScrollPane scrollPaneVentaABorrar = new JScrollPane();
		scrollPaneVentaABorrar.setBounds(12, 83, 428, 107);
		panelBorrarUnaVenta.add(scrollPaneVentaABorrar);
		
		textAreaVentasABorrar = new JTextArea();
		scrollPaneVentaABorrar.setViewportView(textAreaVentasABorrar);
		textAreaVentasABorrar.setText(tiendaDeRopa.devolverVentasConIDClienteVendedorYFecha());
		textAreaVentasABorrar.setForeground(Color.WHITE);
		textAreaVentasABorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaVentasABorrar.setBackground(new Color(0, 0, 139));
		
		
		/*
		 * Panel para buscar empleado 
		 */
		
		panelBuscarEmpleado = new JPanel();
		panelBuscarEmpleado.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBuscarEmpleado, "name_133788842791400");
		panelBuscarEmpleado.setLayout(null);
		
		textFieldEmpleadoABuscar = new JTextField();
		textFieldEmpleadoABuscar.setForeground(Color.WHITE);
		textFieldEmpleadoABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmpleadoABuscar.setColumns(10);
		textFieldEmpleadoABuscar.setBackground(new Color(0, 0, 139));
		textFieldEmpleadoABuscar.setBounds(10, 30, 75, 26);
		panelBuscarEmpleado.add(textFieldEmpleadoABuscar);
		
		JLabel labelLegajoEmpleadoABuscar = new JLabel("Legajo del empleado a buscar");
		labelLegajoEmpleadoABuscar.setForeground(Color.WHITE);
		labelLegajoEmpleadoABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLegajoEmpleadoABuscar.setBounds(10, 0, 212, 28);
		panelBuscarEmpleado.add(labelLegajoEmpleadoABuscar);
		
		botonParaBuscarEmpleado = new JButton("Buscar empleado");
		botonParaBuscarEmpleado.setForeground(Color.WHITE);
		botonParaBuscarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaBuscarEmpleado.setBackground(new Color(0, 0, 128));
		botonParaBuscarEmpleado.setBounds(95, 28, 166, 28);
		panelBuscarEmpleado.add(botonParaBuscarEmpleado);
		
		JScrollPane scrollPaneEmpleadoBuscado = new JScrollPane();
		scrollPaneEmpleadoBuscado.setBounds(10, 67, 251, 127);
		panelBuscarEmpleado.add(scrollPaneEmpleadoBuscado);
		
		textAreaEmpleadoBuscado = new JTextArea();
		scrollPaneEmpleadoBuscado.setViewportView(textAreaEmpleadoBuscado);
		textAreaEmpleadoBuscado.setText((String) null);
		textAreaEmpleadoBuscado.setForeground(Color.WHITE);
		textAreaEmpleadoBuscado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaEmpleadoBuscado.setBackground(new Color(0, 0, 139));
		
		JScrollPane scrollPaneEmpleadoABuscar = new JScrollPane();
		scrollPaneEmpleadoABuscar.setBounds(271, 28, 169, 166);
		panelBuscarEmpleado.add(scrollPaneEmpleadoABuscar);
		
		textAreaLegajosDeEmpleados = new JTextArea();
		scrollPaneEmpleadoABuscar.setViewportView(textAreaLegajosDeEmpleados);
		textAreaLegajosDeEmpleados.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());
		textAreaLegajosDeEmpleados.setForeground(Color.WHITE);
		textAreaLegajosDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaLegajosDeEmpleados.setBackground(new Color(0, 0, 139));
		
		JLabel lblEmpleadosParaBuscar = new JLabel("Empleados");
		lblEmpleadosParaBuscar.setForeground(Color.WHITE);
		lblEmpleadosParaBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpleadosParaBuscar.setBounds(271, 0, 87, 28);
		panelBuscarEmpleado.add(lblEmpleadosParaBuscar);
		
		/*
		 * Panel para buscar una prenda 
		 */
		
		panelBuscarPrenda = new JPanel();
		panelBuscarPrenda.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBuscarPrenda, "name_177382188622900");
		panelBuscarPrenda.setLayout(null);
		
		textFieldPrendaABuscar = new JTextField();
		textFieldPrendaABuscar.setForeground(Color.WHITE);
		textFieldPrendaABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPrendaABuscar.setColumns(10);
		textFieldPrendaABuscar.setBackground(new Color(0, 0, 139));
		textFieldPrendaABuscar.setBounds(10, 30, 75, 26);
		panelBuscarPrenda.add(textFieldPrendaABuscar);
		
		JLabel labelCodigoPrendaABuscar = new JLabel("Codigo de prenda a buscar");
		labelCodigoPrendaABuscar.setForeground(Color.WHITE);
		labelCodigoPrendaABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCodigoPrendaABuscar.setBounds(10, 0, 212, 28);
		panelBuscarPrenda.add(labelCodigoPrendaABuscar);
		
		botonParaBuscarUnaPrenda = new JButton("Buscar prenda");
		botonParaBuscarUnaPrenda.setForeground(Color.WHITE);
		botonParaBuscarUnaPrenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaBuscarUnaPrenda.setBackground(new Color(0, 0, 128));
		botonParaBuscarUnaPrenda.setBounds(95, 28, 166, 28);
		panelBuscarPrenda.add(botonParaBuscarUnaPrenda);
		
		JScrollPane scrollPanePrendaABuscar = new JScrollPane();
		scrollPanePrendaABuscar.setBounds(272, 29, 167, 164);
		panelBuscarPrenda.add(scrollPanePrendaABuscar);
		
		textAreaPrendaABuscar = new JTextArea();
		scrollPanePrendaABuscar.setViewportView(textAreaPrendaABuscar);
		textAreaPrendaABuscar.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		
		textAreaPrendaABuscar.setForeground(Color.WHITE);
		textAreaPrendaABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaPrendaABuscar.setBackground(new Color(0, 0, 139));
		
		JLabel labelPrendasABuscar = new JLabel("Prendas");
		labelPrendasABuscar.setForeground(Color.WHITE);
		labelPrendasABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrendasABuscar.setBounds(271, 0, 87, 28);
		panelBuscarPrenda.add(labelPrendasABuscar);
		
		JScrollPane scrollPanePrendaBuscada = new JScrollPane();
		scrollPanePrendaBuscada.setBounds(11, 68, 249, 125);
		panelBuscarPrenda.add(scrollPanePrendaBuscada);
		
		textAreaPrendaBuscada = new JTextArea();
		textAreaPrendaBuscada.setEditable(false);
		scrollPanePrendaBuscada.setViewportView(textAreaPrendaBuscada);
		textAreaPrendaBuscada.setText((String) null);
		textAreaPrendaBuscada.setForeground(Color.WHITE);
		textAreaPrendaBuscada.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaPrendaBuscada.setBackground(new Color(0, 0, 139));
		
		/*
		 * Panel para buscar un cliente
		 */
		
		panelBuscarCliente = new JPanel();
		panelBuscarCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBuscarCliente, "name_181533766113100");
		panelBuscarCliente.setLayout(null);
		
		JLabel labelDniDelCliente = new JLabel("Dni del cliente a buscar");
		labelDniDelCliente.setForeground(Color.WHITE);
		labelDniDelCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDniDelCliente.setBounds(10, 0, 212, 28);
		panelBuscarCliente.add(labelDniDelCliente);
		
		textFieldDniClienteABuscar = new JTextField();
		textFieldDniClienteABuscar.setForeground(Color.WHITE);
		textFieldDniClienteABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDniClienteABuscar.setColumns(10);
		textFieldDniClienteABuscar.setBackground(new Color(0, 0, 139));
		textFieldDniClienteABuscar.setBounds(10, 30, 75, 26);
		panelBuscarCliente.add(textFieldDniClienteABuscar);
		
		botonParaBuscarUnCliente = new JButton("Buscar cliente");
		botonParaBuscarUnCliente.setForeground(Color.WHITE);
		botonParaBuscarUnCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaBuscarUnCliente.setBackground(new Color(0, 0, 128));
		botonParaBuscarUnCliente.setBounds(95, 28, 166, 28);
		panelBuscarCliente.add(botonParaBuscarUnCliente);
		
		JScrollPane scrollPaneClientesABuscar = new JScrollPane();
		scrollPaneClientesABuscar.setBounds(273, 30, 165, 162);
		panelBuscarCliente.add(scrollPaneClientesABuscar);
		
		textAreaClientesABuscar = new JTextArea();
		scrollPaneClientesABuscar.setViewportView(textAreaClientesABuscar);
		textAreaClientesABuscar.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
		textAreaClientesABuscar.setForeground(Color.WHITE);
		textAreaClientesABuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaClientesABuscar.setBackground(new Color(0, 0, 139));
		
		JLabel labelClientes = new JLabel("Clientes");
		labelClientes.setForeground(Color.WHITE);
		labelClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelClientes.setBounds(271, 0, 87, 28);
		panelBuscarCliente.add(labelClientes);
		
		JScrollPane scrollPaneClienteBuscado = new JScrollPane();
		scrollPaneClienteBuscado.setBounds(12, 69, 247, 123);
		panelBuscarCliente.add(scrollPaneClienteBuscado);
		
		textAreaClienteBuscado = new JTextArea();
		scrollPaneClienteBuscado.setViewportView(textAreaClienteBuscado);
		textAreaClienteBuscado.setText((String) null);
		textAreaClienteBuscado.setForeground(Color.WHITE);
		textAreaClienteBuscado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaClienteBuscado.setBackground(new Color(0, 0, 139));
		
		/*
		 * Panel para buscar una venta
		 */
		panelBuscarUnaVenta = new JPanel();
		panelBuscarUnaVenta.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelBuscarUnaVenta, "name_183679230531000");
		panelBuscarUnaVenta.setLayout(null);
		
		labelSeleccioneElCriterio = new JLabel("Criterio en base a");
		labelSeleccioneElCriterio.setForeground(Color.WHITE);
		labelSeleccioneElCriterio.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSeleccioneElCriterio.setBounds(10, 11, 132, 20);
		panelBuscarUnaVenta.add(labelSeleccioneElCriterio);
		
		comboBoxCriterioDeBusquedaVentas = new JComboBox();
		comboBoxCriterioDeBusquedaVentas.setModel(new DefaultComboBoxModel(new String[] {"Ventas hechas por un vendedor", "Ventas hechas a un cliente"}));
		comboBoxCriterioDeBusquedaVentas.setForeground(Color.WHITE);
		comboBoxCriterioDeBusquedaVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxCriterioDeBusquedaVentas.setBackground(new Color(0, 0, 128));
		comboBoxCriterioDeBusquedaVentas.setBounds(164, 7, 286, 28);
		panelBuscarUnaVenta.add(comboBoxCriterioDeBusquedaVentas);
		
		layeredPaneCriterioDeBusquedaVentas = new JLayeredPane();
		layeredPaneCriterioDeBusquedaVentas.setBounds(0, 37, 450, 168);
		panelBuscarUnaVenta.add(layeredPaneCriterioDeBusquedaVentas);
		layeredPaneCriterioDeBusquedaVentas.setLayout(new CardLayout(0, 0));
		
		panelVentasVendedores = new JPanel();
		panelVentasVendedores.setBackground(new Color(0, 0, 128));
		layeredPaneCriterioDeBusquedaVentas.add(panelVentasVendedores, "name_263892066728100");
		panelVentasVendedores.setLayout(null);
		
		scrollPaneVentasHechasPorVendedores = new JScrollPane();
		scrollPaneVentasHechasPorVendedores.setBounds(162, 30, 288, 135);
		panelVentasVendedores.add(scrollPaneVentasHechasPorVendedores);
		
		textAreaVentasVendedores = new JTextArea();
		textAreaVentasVendedores.setEditable(false);
		scrollPaneVentasHechasPorVendedores.setViewportView(textAreaVentasVendedores);
		textAreaVentasVendedores.setForeground(Color.WHITE);
		textAreaVentasVendedores.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaVentasVendedores.setBackground(new Color(0, 0, 128));
		
		botonVerVentasVendedores = new JButton("Ver ventas");
		botonVerVentasVendedores.setForeground(Color.WHITE);
		botonVerVentasVendedores.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonVerVentasVendedores.setBackground(new Color(0, 0, 128));
		botonVerVentasVendedores.setBounds(162, 0, 118, 28);
		panelVentasVendedores.add(botonVerVentasVendedores);
		
		textFieldLegajoABuscarVentas = new JTextField();
		textFieldLegajoABuscarVentas.setForeground(Color.WHITE);
		textFieldLegajoABuscarVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldLegajoABuscarVentas.setColumns(10);
		textFieldLegajoABuscarVentas.setBackground(new Color(0, 0, 139));
		textFieldLegajoABuscarVentas.setBounds(63, 2, 89, 26);
		panelVentasVendedores.add(textFieldLegajoABuscarVentas);
		
		labelLegajoDelVendedor = new JLabel("Legajo");
		labelLegajoDelVendedor.setToolTipText("");
		labelLegajoDelVendedor.setForeground(Color.WHITE);
		labelLegajoDelVendedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLegajoDelVendedor.setBounds(10, 0, 58, 28);
		panelVentasVendedores.add(labelLegajoDelVendedor);
		
		scrollPanePosiblesVentasPorVendedores = new JScrollPane();
		scrollPanePosiblesVentasPorVendedores.setBounds(0, 30, 152, 135);
		panelVentasVendedores.add(scrollPanePosiblesVentasPorVendedores);
		
		textAreaPosiblesVentasVendedores = new JTextArea();
		textAreaPosiblesVentasVendedores.setEditable(false);
		textAreaPosiblesVentasVendedores.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaPosiblesVentasVendedores.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());
		scrollPanePosiblesVentasPorVendedores.setViewportView(textAreaPosiblesVentasVendedores);
		textAreaPosiblesVentasVendedores.setForeground(Color.WHITE);
		textAreaPosiblesVentasVendedores.setBackground(new Color(0, 0, 128));
		
		panelVentasAClientes = new JPanel();
		panelVentasAClientes.setBackground(new Color(0, 0, 128));
		layeredPaneCriterioDeBusquedaVentas.add(panelVentasAClientes, "name_263896704273800");
		panelVentasAClientes.setLayout(null);
		
		labelDniDelClienteAVerVentas = new JLabel("DNI");
		labelDniDelClienteAVerVentas.setToolTipText("");
		labelDniDelClienteAVerVentas.setForeground(Color.WHITE);
		labelDniDelClienteAVerVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDniDelClienteAVerVentas.setBounds(10, 0, 98, 28);
		panelVentasAClientes.add(labelDniDelClienteAVerVentas);
		
		textFieldDNIDelClienteAVerVentas = new JTextField();
		textFieldDNIDelClienteAVerVentas.setForeground(Color.WHITE);
		textFieldDNIDelClienteAVerVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDNIDelClienteAVerVentas.setColumns(10);
		textFieldDNIDelClienteAVerVentas.setBackground(new Color(0, 0, 139));
		textFieldDNIDelClienteAVerVentas.setBounds(43, 2, 110, 26);
		panelVentasAClientes.add(textFieldDNIDelClienteAVerVentas);
		
		botonVerVentasAClientes = new JButton("Ver ventas");
		botonVerVentasAClientes.setForeground(Color.WHITE);
		botonVerVentasAClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonVerVentasAClientes.setBackground(new Color(0, 0, 128));
		botonVerVentasAClientes.setBounds(163, 0, 115, 28);
		panelVentasAClientes.add(botonVerVentasAClientes);
		
		scrollPanePosiblesVentasAClientes = new JScrollPane();
		scrollPanePosiblesVentasAClientes.setBounds(0, 32, 153, 136);
		panelVentasAClientes.add(scrollPanePosiblesVentasAClientes);
		
		textAreaPosibleVentasAClientes = new JTextArea();
		textAreaPosibleVentasAClientes.setEditable(false);
		textAreaPosibleVentasAClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPanePosiblesVentasAClientes.setViewportView(textAreaPosibleVentasAClientes);
		textAreaPosibleVentasAClientes.setForeground(new Color(255, 255, 255));
		textAreaPosibleVentasAClientes.setBackground(new Color(0, 0, 128));
		textAreaPosibleVentasAClientes.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
		
		scrollPaneVentasAClientes = new JScrollPane();
		scrollPaneVentasAClientes.setBounds(163, 32, 287, 136);
		panelVentasAClientes.add(scrollPaneVentasAClientes);
		
		textAreaVentasACliente = new JTextArea();
		textAreaVentasACliente.setEditable(false);
		scrollPaneVentasAClientes.setViewportView(textAreaVentasACliente);
		textAreaVentasACliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaVentasACliente.setForeground(Color.WHITE);
		textAreaVentasACliente.setBackground(new Color(0, 0, 128));
		
		
		/*
		 * Panel para agregar una prenda
		 */
		panelAgregarUnaPrenda = new JPanel();
		panelAgregarUnaPrenda.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelAgregarUnaPrenda, "name_183728166038100");
		panelAgregarUnaPrenda.setLayout(null);
		panelAgregarUnaPrenda.setPreferredSize(new Dimension(200,400));
		
		comboBoxTipoDePrenda = new JComboBox();
		comboBoxTipoDePrenda.setModel(new DefaultComboBoxModel(new String[] {"Remera", "Buzo", "Calzado", "Pantalon", "Maya"}));
		comboBoxTipoDePrenda.setBackground(new Color(0, 0, 128));
		comboBoxTipoDePrenda.setForeground(Color.WHITE);
		comboBoxTipoDePrenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDePrenda.setBounds(219, 11, 139, 20);
		panelAgregarUnaPrenda.add(comboBoxTipoDePrenda);
		
		JLabel labelTipoDePrendaAAgregar = new JLabel("Prenda que desea agregar");
		labelTipoDePrendaAAgregar.setForeground(Color.WHITE);
		labelTipoDePrendaAAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDePrendaAAgregar.setBounds(10, 11, 199, 20);
		panelAgregarUnaPrenda.add(labelTipoDePrendaAAgregar);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setForeground(new Color(255, 255, 255));
		comboBoxMarca.setModel(new DefaultComboBoxModel(new String[] {"Zara", "Nike", "Gucci", "Adidas", "Lacoste", "Chanel", "Levis", "No definido"}));
		comboBoxMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMarca.setBackground(new Color(0, 0, 128));
		comboBoxMarca.setBounds(10, 64, 118, 20);
		panelAgregarUnaPrenda.add(comboBoxMarca);
		
		JLabel labelMarca = new JLabel("Marca");
		labelMarca.setForeground(Color.WHITE);
		labelMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMarca.setBounds(10, 42, 70, 20);
		panelAgregarUnaPrenda.add(labelMarca);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldModelo.setForeground(new Color(255, 255, 255));
		textFieldModelo.setBackground(new Color(0, 0, 128));
		textFieldModelo.setBounds(138, 64, 105, 20);
		panelAgregarUnaPrenda.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel labelModelo = new JLabel("Modelo");
		labelModelo.setForeground(Color.WHITE);
		labelModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelModelo.setBounds(138, 42, 86, 20);
		panelAgregarUnaPrenda.add(labelModelo);
		
		JLabel labelColor = new JLabel("Color");
		labelColor.setForeground(Color.WHITE);
		labelColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelColor.setBounds(253, 42, 86, 20);
		panelAgregarUnaPrenda.add(labelColor);
		
		textFieldColor = new JTextField();
		textFieldColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldColor.setForeground(new Color(255, 255, 255));
		textFieldColor.setBackground(new Color(0, 0, 128));
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(253, 64, 105, 20);
		panelAgregarUnaPrenda.add(textFieldColor);
		
		JLabel labelTipoDeMaterial = new JLabel("Tipo de material");
		labelTipoDeMaterial.setForeground(Color.WHITE);
		labelTipoDeMaterial.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeMaterial.setBounds(10, 84, 118, 20);
		panelAgregarUnaPrenda.add(labelTipoDeMaterial);
		
		comboBoxTipoDeMaterial = new JComboBox();
		comboBoxTipoDeMaterial.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeMaterial.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeMaterial.setForeground(new Color(255, 255, 255));
		comboBoxTipoDeMaterial.setModel(new DefaultComboBoxModel(new String[] {"Algodon", "Terciopelo", "Calico", "Fieltro", "Seda", "No definido"}));
		comboBoxTipoDeMaterial.setBounds(10, 106, 118, 20);
		panelAgregarUnaPrenda.add(comboBoxTipoDeMaterial);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPrecio.setForeground(new Color(255, 255, 255));
		textFieldPrecio.setBackground(new Color(0, 0, 128));
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(138, 106, 105, 20);
		panelAgregarUnaPrenda.add(textFieldPrecio);
		
		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setForeground(Color.WHITE);
		labelPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrecio.setBounds(138, 84, 86, 20);
		panelAgregarUnaPrenda.add(labelPrecio);
		
		JLayeredPane layeredPaneTipoDePrenda = new JLayeredPane();
		layeredPaneTipoDePrenda.setBounds(10, 137, 233, 57);
		panelAgregarUnaPrenda.add(layeredPaneTipoDePrenda);
		layeredPaneTipoDePrenda.setLayout(new CardLayout(0, 0));
		
		botonParaAgregarUnaPrenda = new JButton("Agregar prenda");
		botonParaAgregarUnaPrenda.setBackground(new Color(0, 0, 128));
		botonParaAgregarUnaPrenda.setForeground(new Color(255, 255, 255));
		botonParaAgregarUnaPrenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaAgregarUnaPrenda.setBounds(289, 171, 151, 23);
		panelAgregarUnaPrenda.add(botonParaAgregarUnaPrenda);
		
		/*
		 * Panel remera de en panel agregar prenda
		 */
		panelRemera = new JPanel();
		panelRemera.setBackground(new Color(0, 0, 128));
		layeredPaneTipoDePrenda.add(panelRemera, "name_212269185765300");
		panelRemera.setLayout(null);
		
		JLabel labelTipoDeMangaRemera = new JLabel("Manga");
		labelTipoDeMangaRemera.setForeground(Color.WHITE);
		labelTipoDeMangaRemera.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeMangaRemera.setBounds(0, 0, 70, 20);
		panelRemera.add(labelTipoDeMangaRemera);
		
		comboBoxTipoDeMangaRemera = new JComboBox();
		comboBoxTipoDeMangaRemera.setModel(new DefaultComboBoxModel(new String[] {"Manga corta", "Manga larga"}));
		comboBoxTipoDeMangaRemera.setForeground(Color.WHITE);
		comboBoxTipoDeMangaRemera.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeMangaRemera.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeMangaRemera.setBounds(0, 22, 118, 20);
		panelRemera.add(comboBoxTipoDeMangaRemera);
		
		textFieldTipoEstamRemera = new JTextField();
		textFieldTipoEstamRemera.setForeground(Color.WHITE);
		textFieldTipoEstamRemera.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTipoEstamRemera.setColumns(10);
		textFieldTipoEstamRemera.setBackground(new Color(0, 0, 128));
		textFieldTipoEstamRemera.setBounds(128, 22, 105, 20);
		panelRemera.add(textFieldTipoEstamRemera);
		
		JLabel labelTipoDeEstampado = new JLabel("Estampado");
		labelTipoDeEstampado.setForeground(Color.WHITE);
		labelTipoDeEstampado.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeEstampado.setBounds(128, 0, 86, 20);
		panelRemera.add(labelTipoDeEstampado);
		
		/*
		 * Panel buzo de en panel agregar prenda
		 */
		
		panelBuzo = new JPanel();
		panelBuzo.setBackground(new Color(0, 0, 128));
		layeredPaneTipoDePrenda.add(panelBuzo, "name_212294018758400");
		panelBuzo.setLayout(null);
		
		JLabel labelTipoDeMangaBuzo = new JLabel("Manga");
		labelTipoDeMangaBuzo.setForeground(Color.WHITE);
		labelTipoDeMangaBuzo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeMangaBuzo.setBounds(0, 0, 70, 20);
		panelBuzo.add(labelTipoDeMangaBuzo);
		
		comboBoxTipoDeMangaBuzo = new JComboBox();
		comboBoxTipoDeMangaBuzo.setModel(new DefaultComboBoxModel(new String[] {"Manga corta", "Manga larga"}));
		comboBoxTipoDeMangaBuzo.setForeground(Color.WHITE);
		comboBoxTipoDeMangaBuzo.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeMangaBuzo.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeMangaBuzo.setBounds(0, 22, 118, 20);
		panelBuzo.add(comboBoxTipoDeMangaBuzo);
		
		
		comboBoxTipoDeBuzo = new JComboBox();
		comboBoxTipoDeBuzo.setModel(new DefaultComboBoxModel(new String[] {"Canguro", "No canguro"}));
		comboBoxTipoDeBuzo.setForeground(Color.WHITE);
		comboBoxTipoDeBuzo.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeBuzo.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeBuzo.setBounds(128, 22, 105, 20);
		panelBuzo.add(comboBoxTipoDeBuzo);
		
		JLabel LabelEsCanguro = new JLabel("Tipo de buzo");
		LabelEsCanguro.setForeground(Color.WHITE);
		LabelEsCanguro.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelEsCanguro.setBounds(128, 0, 105, 20);
		panelBuzo.add(LabelEsCanguro);
		
		/*
		 * Panel calzado en panel agregar prenda
		 */
		
		
		panelCalzado = new JPanel();
		panelCalzado.setBackground(new Color(0, 0, 128));
		layeredPaneTipoDePrenda.add(panelCalzado, "name_212297056694500");
		panelCalzado.setLayout(null);
		
		comboBoxTipoDeSuela = new JComboBox();
		comboBoxTipoDeSuela.setModel(new DefaultComboBoxModel(new String[] {"Poliuretano", "Crepe", "Cuero", "No definido"}));
		comboBoxTipoDeSuela.setForeground(Color.WHITE);
		comboBoxTipoDeSuela.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeSuela.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeSuela.setBounds(0, 22, 118, 20);
		panelCalzado.add(comboBoxTipoDeSuela);
		
		JLabel labelTipoDeSuela = new JLabel("Tipo de suela");
		labelTipoDeSuela.setForeground(Color.WHITE);
		labelTipoDeSuela.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeSuela.setBounds(0, 0, 118, 20);
		panelCalzado.add(labelTipoDeSuela);
		
		/*
		 * Panel pantalon en panel agregar prenda
		 */
		
		panelPantalon = new JPanel();
		panelPantalon.setBackground(new Color(0, 0, 128));
		layeredPaneTipoDePrenda.add(panelPantalon, "name_212299857264800");
		panelPantalon.setLayout(null);
		
		comboBoxPantalonEsAlCuerpo = new JComboBox();
		comboBoxPantalonEsAlCuerpo.setModel(new DefaultComboBoxModel(new String[] {"Al cuerpo", "Suelto"}));
		comboBoxPantalonEsAlCuerpo.setForeground(Color.WHITE);
		comboBoxPantalonEsAlCuerpo.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxPantalonEsAlCuerpo.setBackground(new Color(0, 0, 128));
		comboBoxPantalonEsAlCuerpo.setBounds(0, 22, 118, 20);
		panelPantalon.add(comboBoxPantalonEsAlCuerpo);
		
		JLabel labelPantalonEsAlCuerpo = new JLabel("Tipo de pantalon");
		labelPantalonEsAlCuerpo.setForeground(Color.WHITE);
		labelPantalonEsAlCuerpo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPantalonEsAlCuerpo.setBounds(0, 0, 118, 20);
		panelPantalon.add(labelPantalonEsAlCuerpo);
		
		/*
		 * Panel maya en panel agregar prenda
		 */
	
		panelMaya = new JPanel();
		panelMaya.setBackground(new Color(0, 0, 128));
		layeredPaneTipoDePrenda.add(panelMaya, "name_212303786923700");
		panelMaya.setLayout(null);
		
		JLabel labelTipoDeMaya = new JLabel("Tipo maya");
		labelTipoDeMaya.setBounds(0, 11, 75, 46);
		panelMaya.add(labelTipoDeMaya);
		labelTipoDeMaya.setForeground(Color.WHITE);
		labelTipoDeMaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBoxMayaEsSecadoRapido = new JComboBox();
		comboBoxMayaEsSecadoRapido.setModel(new DefaultComboBoxModel(new String[] {"Secado rapido", "No secado rapido"}));
		comboBoxMayaEsSecadoRapido.setForeground(Color.WHITE);
		comboBoxMayaEsSecadoRapido.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMayaEsSecadoRapido.setBackground(new Color(0, 0, 128));
		comboBoxMayaEsSecadoRapido.setBounds(85, 37, 148, 20);
		panelMaya.add(comboBoxMayaEsSecadoRapido);
		
		
		comboBoxMayaArribaRodiyas = new JComboBox();
		comboBoxMayaArribaRodiyas.setModel(new DefaultComboBoxModel(new String[] {"Arriba de rodillas", "Debajo de rodillas"}));
		comboBoxMayaArribaRodiyas.setForeground(Color.WHITE);
		comboBoxMayaArribaRodiyas.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMayaArribaRodiyas.setBackground(new Color(0, 0, 128));
		comboBoxMayaArribaRodiyas.setBounds(85, 9, 148, 20);
		panelMaya.add(comboBoxMayaArribaRodiyas);
		
		
		/*
		 * Panel para agregar un cliente
		 */
		panelAgregarUnCliente = new JPanel();
		panelAgregarUnCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelAgregarUnCliente, "name_183910682629600");
		panelAgregarUnCliente.setLayout(null);
		
		textFieldNombreCliente = new JTextField();
		textFieldNombreCliente.setForeground(Color.WHITE);
		textFieldNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNombreCliente.setColumns(10);
		textFieldNombreCliente.setBackground(new Color(0, 0, 128));
		textFieldNombreCliente.setBounds(10, 30, 122, 20);
		panelAgregarUnCliente.add(textFieldNombreCliente);
		
		JLabel labelNombreCliente = new JLabel("Nombre");
		labelNombreCliente.setForeground(Color.WHITE);
		labelNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNombreCliente.setBackground(new Color(0, 0, 128));
		labelNombreCliente.setBounds(10, 7, 70, 15);
		panelAgregarUnCliente.add(labelNombreCliente);
		
		JLabel labelApellidoCliente = new JLabel("Apellido\r\n");
		labelApellidoCliente.setForeground(Color.WHITE);
		labelApellidoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelApellidoCliente.setBounds(144, 7, 88, 23);
		panelAgregarUnCliente.add(labelApellidoCliente);
		
		textFieldApellidoCliente = new JTextField();
		textFieldApellidoCliente.setForeground(Color.WHITE);
		textFieldApellidoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldApellidoCliente.setColumns(10);
		textFieldApellidoCliente.setBackground(new Color(0, 0, 128));
		textFieldApellidoCliente.setBounds(137, 30, 122, 20);
		panelAgregarUnCliente.add(textFieldApellidoCliente);
		
		textFieldDNICliente = new JTextField();
		textFieldDNICliente.setForeground(Color.WHITE);
		textFieldDNICliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDNICliente.setColumns(10);
		textFieldDNICliente.setBackground(new Color(0, 0, 128));
		textFieldDNICliente.setBounds(10, 82, 122, 20);
		panelAgregarUnCliente.add(textFieldDNICliente);
		
		JLabel labelDNICliente = new JLabel("DNI");
		labelDNICliente.setForeground(Color.WHITE);
		labelDNICliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDNICliente.setBounds(10, 61, 46, 14);
		panelAgregarUnCliente.add(labelDNICliente);
		
		comboBoxDiaCliente = new JComboBox();
		comboBoxDiaCliente.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDiaCliente.setForeground(Color.WHITE);
		comboBoxDiaCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxDiaCliente.setBackground(new Color(0, 0, 128));
		comboBoxDiaCliente.setBounds(267, 30, 46, 20);
		panelAgregarUnCliente.add(comboBoxDiaCliente);
		
		JLabel labelFechaNacCliente = new JLabel("Fecha de nacimiento");
		labelFechaNacCliente.setForeground(Color.WHITE);
		labelFechaNacCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelFechaNacCliente.setBounds(272, 9, 140, 14);
		panelAgregarUnCliente.add(labelFechaNacCliente);
		
		comboBoxMesCliente = new JComboBox();
		comboBoxMesCliente.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMesCliente.setToolTipText("10");
		comboBoxMesCliente.setForeground(Color.WHITE);
		comboBoxMesCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMesCliente.setBackground(new Color(0, 0, 128));
		comboBoxMesCliente.setBounds(323, 30, 39, 20);
		panelAgregarUnCliente.add(comboBoxMesCliente);
		
		comboBoxAñoCliente = new JComboBox();
		comboBoxAñoCliente.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906"}));
		comboBoxAñoCliente.setToolTipText("2020");
		comboBoxAñoCliente.setForeground(Color.WHITE);
		comboBoxAñoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxAñoCliente.setBackground(new Color(0, 0, 128));
		comboBoxAñoCliente.setBounds(372, 30, 63, 20);
		panelAgregarUnCliente.add(comboBoxAñoCliente);
		
		JLabel labelSexoCliente = new JLabel("Sexo");
		labelSexoCliente.setForeground(Color.WHITE);
		labelSexoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSexoCliente.setBounds(144, 61, 46, 14);
		panelAgregarUnCliente.add(labelSexoCliente);
		
		radioButtonMujerCliente = new JRadioButton("Mujer");
		radioButtonMujerCliente.setForeground(Color.WHITE);
		radioButtonMujerCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonMujerCliente.setBackground(new Color(0, 0, 128));
		radioButtonMujerCliente.setBounds(235, 81, 80, 23);
		panelAgregarUnCliente.add(radioButtonMujerCliente);
		
		radioButtonHombreCliente = new JRadioButton("Hombre");
		radioButtonHombreCliente.setForeground(Color.WHITE);
		radioButtonHombreCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonHombreCliente.setBackground(new Color(0, 0, 128));
		radioButtonHombreCliente.setBounds(144, 81, 89, 23);
		panelAgregarUnCliente.add(radioButtonHombreCliente);
	
		radioButtonPerzonalizadoCliente = new JRadioButton("Personalizado");
		radioButtonPerzonalizadoCliente.setForeground(Color.WHITE);
		radioButtonPerzonalizadoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonPerzonalizadoCliente.setBackground(new Color(0, 0, 128));
		radioButtonPerzonalizadoCliente.setBounds(312, 81, 130, 23);
		panelAgregarUnCliente.add(radioButtonPerzonalizadoCliente);
		
		JLabel labellDomicilioCliente = new JLabel("Domicilio");
		labellDomicilioCliente.setForeground(Color.WHITE);
		labellDomicilioCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labellDomicilioCliente.setBounds(10, 113, 95, 14);
		panelAgregarUnCliente.add(labellDomicilioCliente);
		
		textFieldDomicilioCliente = new JTextField();
		textFieldDomicilioCliente.setForeground(Color.WHITE);
		textFieldDomicilioCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDomicilioCliente.setColumns(10);
		textFieldDomicilioCliente.setBackground(new Color(0, 0, 128));
		textFieldDomicilioCliente.setBounds(10, 134, 122, 20);
		panelAgregarUnCliente.add(textFieldDomicilioCliente);
		
		JLabel labelEmailCliente = new JLabel("Email");
		labelEmailCliente.setForeground(Color.WHITE);
		labelEmailCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEmailCliente.setBounds(139, 115, 46, 14);
		panelAgregarUnCliente.add(labelEmailCliente);
		
		textFieldEmailCliente = new JTextField();
		textFieldEmailCliente.setForeground(Color.WHITE);
		textFieldEmailCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmailCliente.setColumns(10);
		textFieldEmailCliente.setBackground(new Color(0, 0, 128));
		textFieldEmailCliente.setBounds(137, 134, 122, 20);
		panelAgregarUnCliente.add(textFieldEmailCliente);
		
		
	    comboBoxTipoDeCliente = new JComboBox();
		comboBoxTipoDeCliente.setModel(new DefaultComboBoxModel(new String[] {"Mayorista", "Minorista"}));
		comboBoxTipoDeCliente.setForeground(Color.WHITE);
		comboBoxTipoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTipoDeCliente.setBackground(new Color(0, 0, 128));
		comboBoxTipoDeCliente.setBounds(267, 134, 122, 20);
		panelAgregarUnCliente.add(comboBoxTipoDeCliente);
		
		JLabel labelTipoDeCliente = new JLabel("Tipo de cliente");
		labelTipoDeCliente.setForeground(Color.WHITE);
		labelTipoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTipoDeCliente.setBounds(267, 113, 140, 14);
		panelAgregarUnCliente.add(labelTipoDeCliente);
		
		textFieldCUITCliente = new JTextField();
		textFieldCUITCliente.setForeground(Color.WHITE);
		textFieldCUITCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCUITCliente.setColumns(10);
		textFieldCUITCliente.setBackground(new Color(0, 0, 128));
		textFieldCUITCliente.setBounds(164, 183, 95, 20);
		panelAgregarUnCliente.add(textFieldCUITCliente);
		
		JLabel labelCuitCliente = new JLabel("CUIT");
		labelCuitCliente.setForeground(Color.WHITE);
		labelCuitCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCuitCliente.setBounds(164, 165, 95, 14);
		panelAgregarUnCliente.add(labelCuitCliente);
		
		
		comboBoxCondicionFrenteAlIVACliente = new JComboBox();
		comboBoxCondicionFrenteAlIVACliente.setModel(new DefaultComboBoxModel(new String[] {"R. Inscripto", "Monotributista", "Exento", "No responsable", "C. Final"}));
		comboBoxCondicionFrenteAlIVACliente.setForeground(Color.WHITE);
		comboBoxCondicionFrenteAlIVACliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxCondicionFrenteAlIVACliente.setBackground(new Color(0, 0, 128));
		comboBoxCondicionFrenteAlIVACliente.setBounds(10, 183, 144, 20);
		panelAgregarUnCliente.add(comboBoxCondicionFrenteAlIVACliente);
		
		JLabel labelCondicionFrenteAlIVACliente = new JLabel("Condicion IVA");
		labelCondicionFrenteAlIVACliente.setForeground(Color.WHITE);
		labelCondicionFrenteAlIVACliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCondicionFrenteAlIVACliente.setBounds(10, 161, 104, 23);
		panelAgregarUnCliente.add(labelCondicionFrenteAlIVACliente);
		
		botonParaAgregarCliente = new JButton("Agregar cliente");
		botonParaAgregarCliente.setForeground(new Color(255, 255, 255));
		botonParaAgregarCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaAgregarCliente.setBackground(new Color(0, 0, 128));
		botonParaAgregarCliente.setBounds(299, 180, 151, 23);
		panelAgregarUnCliente.add(botonParaAgregarCliente);
		
		
		
		/*
		 * Panel para agregar stock
		 */
		panelAAgregarStock = new JPanel();
		panelAAgregarStock.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelAAgregarStock, "name_183995662503400");
		
		textFieldPrendaABuscarStock = new JTextField();
		textFieldPrendaABuscarStock.setBounds(169, 36, 75, 26);
		textFieldPrendaABuscarStock.setForeground(Color.WHITE);
		textFieldPrendaABuscarStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPrendaABuscarStock.setColumns(10);
		textFieldPrendaABuscarStock.setBackground(new Color(0, 0, 139));
		
		botonBuscarPrendaStock = new JButton("Buscar prenda");
		botonBuscarPrendaStock.setBounds(254, 34, 175, 28);
		botonBuscarPrendaStock.setForeground(Color.WHITE);
		botonBuscarPrendaStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBuscarPrendaStock.setBackground(new Color(0, 0, 128));
		
		JLabel labelCodigoDePrenda = new JLabel("Codigo de prenda para modificar stock");
		labelCodigoDePrenda.setBounds(169, 0, 281, 28);
		labelCodigoDePrenda.setForeground(Color.WHITE);
		labelCodigoDePrenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelAAgregarStock.setLayout(null);
		panelAAgregarStock.add(textFieldPrendaABuscarStock);
		panelAAgregarStock.add(botonBuscarPrendaStock);
		panelAAgregarStock.add(labelCodigoDePrenda);
		
		JScrollPane scrollPanePrendasAAgregarStock = new JScrollPane();
		scrollPanePrendasAAgregarStock.setBounds(10, 38, 149, 156);
		panelAAgregarStock.add(scrollPanePrendasAAgregarStock);
		
		
		textAreaPrendasAAgregarStock = new JTextArea();
		scrollPanePrendasAAgregarStock.setViewportView(textAreaPrendasAAgregarStock);
		textAreaPrendasAAgregarStock.setEditable(false);
		textAreaPrendasAAgregarStock.setBackground(new Color(0, 0, 128));
		textAreaPrendasAAgregarStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaPrendasAAgregarStock.setForeground(new Color(255, 255, 255));
		textAreaPrendasAAgregarStock.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		
		
		JLabel labelPrendasAAgregarStock = new JLabel("Prendas");
		labelPrendasAAgregarStock.setForeground(Color.WHITE);
		labelPrendasAAgregarStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrendasAAgregarStock.setBounds(10, 0, 94, 28);
		panelAAgregarStock.add(labelPrendasAAgregarStock);
		
		textFieldTalle = new JTextField();
		textFieldTalle.setEnabled(false);
		textFieldTalle.setForeground(Color.WHITE);
		textFieldTalle.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTalle.setColumns(10);
		textFieldTalle.setBackground(new Color(0, 0, 139));
		textFieldTalle.setBounds(169, 91, 75, 26);
		panelAAgregarStock.add(textFieldTalle);
		
		JLabel labelTalle = new JLabel("Talle");
		labelTalle.setForeground(Color.WHITE);
		labelTalle.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTalle.setBounds(169, 64, 94, 28);
		panelAAgregarStock.add(labelTalle);
		
		
		comboBoxCantidad = new JComboBox();
		comboBoxCantidad.setEnabled(false);
		comboBoxCantidad.setBackground(new Color(0, 0, 128));
		comboBoxCantidad.setForeground(new Color(255, 255, 255));
		comboBoxCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxCantidad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad.setEditable(true);
		comboBoxCantidad.setBounds(254, 91, 62, 26);
		panelAAgregarStock.add(comboBoxCantidad);
		
		JLabel labelCantidad = new JLabel("Cantidad");
		labelCantidad.setForeground(Color.WHITE);
		labelCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCantidad.setBounds(254, 64, 62, 28);
		panelAAgregarStock.add(labelCantidad);
		
		JScrollPane scrollPaneDetalleDeAgregado = new JScrollPane();
		scrollPaneDetalleDeAgregado.setBounds(169, 123, 260, 71);
		panelAAgregarStock.add(scrollPaneDetalleDeAgregado);
		
		
		textAreaDetalleDeAgregado =  new JTextArea();
		textAreaDetalleDeAgregado.setEditable(false);
		textAreaDetalleDeAgregado.setEnabled(false);
		scrollPaneDetalleDeAgregado.setViewportView(textAreaDetalleDeAgregado);
		textAreaDetalleDeAgregado.setForeground(Color.WHITE);
		textAreaDetalleDeAgregado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaDetalleDeAgregado.setBackground(new Color(0, 0, 128));
		
		
		botonParaAgregarStock = new JButton("Agregar");
		botonParaAgregarStock.setEnabled(false);
		botonParaAgregarStock.setForeground(Color.WHITE);
		botonParaAgregarStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonParaAgregarStock.setBackground(new Color(0, 0, 128));
		botonParaAgregarStock.setBounds(326, 89, 103, 28);
		panelAAgregarStock.add(botonParaAgregarStock);
		
		
		/*
		 * Panel para modificar un cliente
		 */
		panelModificarUnCliente = new JPanel();
		panelModificarUnCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelModificarUnCliente, "name_184126000696700");
		panelModificarUnCliente.setLayout(null);
		
		textFieldNombreAModificar = new JTextField();
		textFieldNombreAModificar.setEnabled(false);
		textFieldNombreAModificar.setForeground(Color.WHITE);
		textFieldNombreAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNombreAModificar.setColumns(10);
		textFieldNombreAModificar.setBackground(new Color(0, 0, 128));
		textFieldNombreAModificar.setBounds(10, 42, 122, 20);
		panelModificarUnCliente.add(textFieldNombreAModificar);
		
		textFieldApellidoAModificar = new JTextField();
		textFieldApellidoAModificar.setEnabled(false);
		textFieldApellidoAModificar.setForeground(Color.WHITE);
		textFieldApellidoAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldApellidoAModificar.setColumns(10);
		textFieldApellidoAModificar.setBackground(new Color(0, 0, 128));
		textFieldApellidoAModificar.setBounds(136, 42, 122, 20);
		panelModificarUnCliente.add(textFieldApellidoAModificar);
		
		labelApellidoAModificar = new JLabel("Apellido\r\n");
		labelApellidoAModificar.setForeground(Color.WHITE);
		labelApellidoAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelApellidoAModificar.setBounds(136, 19, 88, 23);
		panelModificarUnCliente.add(labelApellidoAModificar);
		
		labelSexoAModificar = new JLabel("Sexo");
		labelSexoAModificar.setForeground(Color.WHITE);
		labelSexoAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSexoAModificar.setBounds(10, 69, 46, 14);
		panelModificarUnCliente.add(labelSexoAModificar);
		
		textFieldDomicilioAModificar = new JTextField();
		textFieldDomicilioAModificar.setEnabled(false);
		textFieldDomicilioAModificar.setForeground(Color.WHITE);
		textFieldDomicilioAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDomicilioAModificar.setColumns(10);
		textFieldDomicilioAModificar.setBackground(new Color(0, 0, 128));
		textFieldDomicilioAModificar.setBounds(10, 140, 122, 20);
		panelModificarUnCliente.add(textFieldDomicilioAModificar);
		
		labelDomicilioAModificar = new JLabel("Domicilio");
		labelDomicilioAModificar.setForeground(Color.WHITE);
		labelDomicilioAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDomicilioAModificar.setBounds(10, 119, 95, 14);
		panelModificarUnCliente.add(labelDomicilioAModificar);
		
		textFieldEmailAModificar = new JTextField();
		textFieldEmailAModificar.setEnabled(false);
		textFieldEmailAModificar.setForeground(Color.WHITE);
		textFieldEmailAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmailAModificar.setColumns(10);
		textFieldEmailAModificar.setBackground(new Color(0, 0, 128));
		textFieldEmailAModificar.setBounds(136, 88, 122, 20);
		panelModificarUnCliente.add(textFieldEmailAModificar);
		
		labelEmailAModificar = new JLabel("Email");
		labelEmailAModificar.setForeground(Color.WHITE);
		labelEmailAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEmailAModificar.setBounds(138, 69, 46, 14);
		panelModificarUnCliente.add(labelEmailAModificar);
		
		comboBoxCondicionFrenteAlIVAAModificar = new JComboBox();
		comboBoxCondicionFrenteAlIVAAModificar.setModel(new DefaultComboBoxModel(new String[] {"No definido", "R. Inscripto", "Monotributista", "Exento", "No responsable", "C. Final"}));
		comboBoxCondicionFrenteAlIVAAModificar.setEnabled(false);
		comboBoxCondicionFrenteAlIVAAModificar.setForeground(Color.WHITE);
		comboBoxCondicionFrenteAlIVAAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxCondicionFrenteAlIVAAModificar.setBackground(new Color(0, 0, 128));
		comboBoxCondicionFrenteAlIVAAModificar.setBounds(136, 140, 144, 20);
		panelModificarUnCliente.add(comboBoxCondicionFrenteAlIVAAModificar);
		
		labelCondicionIVAAModificar = new JLabel("Condicion IVA");
		labelCondicionIVAAModificar.setForeground(Color.WHITE);
		labelCondicionIVAAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCondicionIVAAModificar.setBounds(136, 115, 104, 23);
		panelModificarUnCliente.add(labelCondicionIVAAModificar);
		
		scrollPaneClientesModificables = new JScrollPane();
		scrollPaneClientesModificables.setBounds(292, 68, 158, 137);
		panelModificarUnCliente.add(scrollPaneClientesModificables);
		
		textAreaClientesModificables = new JTextArea();
		scrollPaneClientesModificables.setViewportView(textAreaClientesModificables);
		textAreaClientesModificables.setForeground(new Color(255, 255, 255));
		textAreaClientesModificables.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaClientesModificables.setBackground(new Color(0, 0, 128));
		textAreaClientesModificables.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
		
		botonGuardarCambios = new JButton("Guardar cambios");
		botonGuardarCambios.setEnabled(false);
		botonGuardarCambios.setBackground(new Color(0, 0, 128));
		botonGuardarCambios.setForeground(new Color(255, 255, 255));
		botonGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonGuardarCambios.setBounds(66, 171, 158, 23);
		panelModificarUnCliente.add(botonGuardarCambios);
		
		textFieldDNIClienteAModificar = new JTextField();
		textFieldDNIClienteAModificar.setForeground(Color.WHITE);
		textFieldDNIClienteAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDNIClienteAModificar.setColumns(10);
		textFieldDNIClienteAModificar.setBackground(new Color(0, 0, 128));
		textFieldDNIClienteAModificar.setBounds(292, 22, 95, 20);
		panelModificarUnCliente.add(textFieldDNIClienteAModificar);
		
		labelDni = new JLabel("Dni cliente a modificar");
		labelDni.setForeground(Color.WHITE);
		labelDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDni.setBackground(new Color(0, 0, 128));
		labelDni.setBounds(292, 3, 158, 15);
		panelModificarUnCliente.add(labelDni);
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNombre.setBounds(10, 20, 88, 23);
		panelModificarUnCliente.add(labelNombre);
		
		botonBuscarClienteAModificar = new JButton("Buscar");
		botonBuscarClienteAModificar.setBackground(new Color(0, 0, 128));
		botonBuscarClienteAModificar.setForeground(new Color(255, 255, 255));
		botonBuscarClienteAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBuscarClienteAModificar.setBounds(292, 45, 95, 23);
		panelModificarUnCliente.add(botonBuscarClienteAModificar);
		
		comboBoxSexoClienteAModificar = new JComboBox();
		comboBoxSexoClienteAModificar.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer ", "Personalizado"}));
		comboBoxSexoClienteAModificar.setEnabled(false);
		comboBoxSexoClienteAModificar.setForeground(Color.WHITE);
		comboBoxSexoClienteAModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxSexoClienteAModificar.setBackground(new Color(0, 0, 128));
		comboBoxSexoClienteAModificar.setBounds(10, 88, 122, 20);
		panelModificarUnCliente.add(comboBoxSexoClienteAModificar);
		
		
		
		
		/*
		 * Panel datos de ventas totales
		 */
		panelDatosVentasTotales = new JPanel();
		panelDatosVentasTotales.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelDatosVentasTotales, "name_277216508303900");
		panelDatosVentasTotales.setLayout(null);
		
		labelMontoDeVentas = new JLabel("Monto de ventas totales");
		labelMontoDeVentas.setForeground(Color.WHITE);
		labelMontoDeVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMontoDeVentas.setBounds(10, 70, 167, 17);
		panelDatosVentasTotales.add(labelMontoDeVentas);
		
		labelCantidadDeVentas = new JLabel("Cantidad de ventas");
		labelCantidadDeVentas.setForeground(Color.WHITE);
		labelCantidadDeVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCantidadDeVentas.setBounds(10, 42, 133, 17);
		panelDatosVentasTotales.add(labelCantidadDeVentas);
		
		labelTicketPromedioDe = new JLabel("Ventas promedio");
		labelTicketPromedioDe.setForeground(Color.WHITE);
		labelTicketPromedioDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTicketPromedioDe.setBounds(10, 14, 118, 17);
		panelDatosVentasTotales.add(labelTicketPromedioDe);
		
		textFieldCantidadDeVentas = new JTextField();
		textFieldCantidadDeVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCantidadDeVentas.setBackground(new Color(0, 0, 128));
		textFieldCantidadDeVentas.setForeground(new Color(255, 255, 255));
		textFieldCantidadDeVentas.setEnabled(false);
		textFieldCantidadDeVentas.setEditable(false);
		Integer cantidadDeVentas = tiendaDeRopa.devolverCantidadDeVentas();
		textFieldCantidadDeVentas.setText(cantidadDeVentas.toString());
		textFieldCantidadDeVentas.setBounds(207, 39, 136, 23);
		panelDatosVentasTotales.add(textFieldCantidadDeVentas);
		textFieldCantidadDeVentas.setColumns(10);
		
		textFieldVentasTotales = new JTextField();
		textFieldVentasTotales.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldVentasTotales.setForeground(new Color(255, 255, 255));
		textFieldVentasTotales.setBackground(new Color(0, 0, 128));
		textFieldVentasTotales.setEnabled(false);
		textFieldVentasTotales.setEditable(false);
		textFieldVentasTotales.setColumns(10);
		Double ventasTotales = tiendaDeRopa.devolverVentasTotales();
		textFieldVentasTotales.setText(ventasTotales.toString());
		textFieldVentasTotales.setBounds(207, 67, 136, 23);
		panelDatosVentasTotales.add(textFieldVentasTotales);
		
		textFieldVentasPromedio = new JTextField();
		textFieldVentasPromedio.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldVentasPromedio.setBackground(new Color(0, 0, 128));
		textFieldVentasPromedio.setForeground(new Color(255, 255, 255));
		textFieldVentasPromedio.setEnabled(false);
		textFieldVentasPromedio.setEditable(false);
		textFieldVentasPromedio.setColumns(10);
		Double ventasPromedio = tiendaDeRopa.devolverVentasPromedio();
		System.out.println(ventasPromedio);
		textFieldVentasPromedio.setText(ventasPromedio.toString());
		textFieldVentasPromedio.setBounds(207, 11, 136, 23);
		panelDatosVentasTotales.add(textFieldVentasPromedio);
		
		labelCantidadPrendasVendidas = new JLabel("Cantidad prendas vendidas");
		labelCantidadPrendasVendidas.setForeground(Color.WHITE);
		labelCantidadPrendasVendidas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCantidadPrendasVendidas.setBounds(10, 98, 187, 17);
		panelDatosVentasTotales.add(labelCantidadPrendasVendidas);
		
		textFieldCantidadPrendasVendidas = new JTextField();
		textFieldCantidadPrendasVendidas.setForeground(Color.WHITE);
		textFieldCantidadPrendasVendidas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCantidadPrendasVendidas.setEnabled(false);
		textFieldCantidadPrendasVendidas.setEditable(false);
		textFieldCantidadPrendasVendidas.setColumns(10);
		textFieldCantidadPrendasVendidas.setBackground(new Color(0, 0, 128));
		Integer cantidadPrendasVendidas = tiendaDeRopa.cantidadDePrendasVendidas();
		textFieldCantidadPrendasVendidas.setText(cantidadPrendasVendidas.toString());
		textFieldCantidadPrendasVendidas.setBounds(207, 95, 136, 23);
		panelDatosVentasTotales.add(textFieldCantidadPrendasVendidas);
		
		
		
		/*
		 * Acciones
		 */
		accionBotonCerrarSesion(tiendaDeRopa);
		accionBotonBorrarEmpleado(tiendaDeRopa);
		accionBotonBorrarPrenda(tiendaDeRopa);
		accionBotonParaBorrarCliente(tiendaDeRopa);
		accionBotonParaBorrarVenta(tiendaDeRopa);
		accionBotonParaBuscarEmpleado(tiendaDeRopa);
		accionBotonParaBuscarUnaPrenda(tiendaDeRopa);
		accionBotonParaBuscarUnCliente(tiendaDeRopa);
		accionBotonParaAgregarUnaPrenda(tiendaDeRopa);
		accionCambiarDePanelesEnPrendas();
		accionBotonPrendaAAgregarStock(tiendaDeRopa);
		accionBotonParaAgregarStock(tiendaDeRopa);
		accionesRadioButton(radioButtonMujerCliente, radioButtonHombreCliente, radioButtonPerzonalizadoCliente);
		accionesRadioButton(radioButtonHombreCliente, radioButtonMujerCliente, radioButtonPerzonalizadoCliente);
		accionesRadioButton(radioButtonPerzonalizadoCliente, radioButtonHombreCliente, radioButtonMujerCliente);
		accionSobreCamposDeTextoClienteMayorista();
		accionBotonAgregarUnCliente(tiendaDeRopa);
		accionCriterioDeBusquedaVentas();
		accionVerVentasACliente(tiendaDeRopa);
		accionVerVentasVendedor(tiendaDeRopa);
		accionBotonBuscarClienteAModificar(tiendaDeRopa);
		accionBotonGuardarCambios(tiendaDeRopa);
		
		
		accionBotonPaneles(tiendaDeRopa, botonListarEmpleados, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonListarPrendas, panelListarPrendas, panelListarClientes, panelListarEmpleados , panelListarVentas , panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonListarClientes, panelListarClientes, panelListarEmpleados, panelListarPrendas, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonRegistroVentas, panelListarVentas, panelListarClientes, panelListarPrendas, panelListarEmpleados,panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBorrarUnEmpleado, panelBorrarUnEmpleado, panelListarPrendas, panelListarClientes, panelListarEmpleados, panelListarVentas, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBorrarPrenda, panelBorrarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBorrarCliente, panelBorrarUnCliente, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBorrarUnaVenta, panelBorrarUnaVenta, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBuscarUnEmpleado, panelBuscarEmpleado, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBuscarPrenda, panelBuscarPrenda,panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBuscarCliente, panelBuscarCliente, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonBuscarVenta, panelBuscarUnaVenta, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonAgregarPrenda, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonAgregarCliente, panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAAgregarStock, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonModificarStock, panelAAgregarStock,panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelModificarUnCliente, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, BotonModificarCliente, panelModificarUnCliente, panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAAgregarStock, panelDatosVentasTotales);
		accionBotonPaneles(tiendaDeRopa, botonDatosDeVentasTotales, panelDatosVentasTotales, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelAAgregarStock, panelModificarUnCliente);	
	
	}

	/**
	 * Metodo en el que se ejecuta la accion del boton cerrar sesion
	 * Con esta accion el programa vuelve hacia atras para ingresar devuelta al sistema
	 * @param tiendaDeRopa
	 */
	public void accionBotonCerrarSesion(TiendaDeRopa tiendaDeRopa) {
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VentanaDeEntrada ventanaDeEntrada = new VentanaDeEntrada(tiendaDeRopa);
				ventanaDeEntrada.setVisible(true);
			}
		});
	
	}
	
	/**
	 * Este metodo sirve para visibilizar un panel de los 17 del layeredPane, dejando los restantes 16 ocultos
	 * @param tiendaDeRopa con la que se va a trabajar
	 * @param boton el cual va a visibilizar el panel que se desea que quede visible
	 * @param p1 a quedar visible
	 * @param p2 a quedar oculto
	 * @param p3 a quedar oculto
	 * @param p4 a quedar oculto
	 * @param p5 a quedar oculto 
	 * @param p6 a quedar oculto
	 * @param p7 a quedar oculto
	 * @param p8 a quedar oculto
	 * @param p9 a quedar oculto
	 * @param p10 a quedar oculto
	 * @param p11 a quedar oculto
	 * @param p12 a quedar oculto
	 * @param p13 a quedar oculto
	 * @param p14 a quedar oculto
	 * @param p15 a quedar oculto
	 * @param p16 a quedar oculto
	 * @param p17 a quedar oculto
	 */
	public void accionBotonPaneles(TiendaDeRopa tiendaDeRopa, JButton boton, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10, JPanel p11, JPanel p12, JPanel p13, JPanel p14, JPanel p15, JPanel p16, JPanel p17) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
				p8.setVisible(false);
				p9.setVisible(false);
				p10.setVisible(false);
				p11.setVisible(false);
				p12.setVisible(false);
				p13.setVisible(false);
				p14.setVisible(false);
				p15.setVisible(false);
				p16.setVisible(false);
				p17.setVisible(false);
				tiendaDeRopa.actualizarTiendaDeRopa();
				actualizarComponentesPaneles(tiendaDeRopa);
			}
		});
	}
	
	/**
	 * Metodo para visibilizar un panel y dejar otros 4 ocultos
	 * @param p1 a quedar visible
	 * @param p2 a quedar oculto
	 * @param p3 a quedar oculto
	 * @param p4 a quedar oculto
	 * @param p5 a quedar oculto
	 */
	public void accionBotonPaneles(JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
	}
	
	/**
	 * Actualiza todos los componentes de manera que los datos no queden registrados pasando de una ventana a otra 
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void actualizarComponentesPaneles(TiendaDeRopa tiendaDeRopa) {
		textAreaListarClientes.setText(tiendaDeRopa.listarClientes());
		textAreaClientesABorrar.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
		textAreaClientesABuscar.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
		
		textAreaListarEmpleados.setText(tiendaDeRopa.listarEmpleados());
		textAreaListarPrendas.setText(tiendaDeRopa.listarPrenda());
		
		textAreaVerVentas.setText(tiendaDeRopa.listarVentas());
		textAreaEmpleadoBuscado.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());
		textAreaPrendaABorrar.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		textAreaPrendaABuscar.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		textAreaPrendasAAgregarStock.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
		textAreaLegajosDeEmpleados.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());

		
		Double promedio = tiendaDeRopa.devolverVentasPromedio();
		textFieldVentasPromedio.setText(promedio.toString());
		
		Integer cantidadDeVentas = tiendaDeRopa.devolverCantidadDeVentas();
		textFieldVentasTotales.setText(cantidadDeVentas.toString());
		
		Double ventasTotales = tiendaDeRopa.devolverVentasTotales();
		textFieldVentasTotales.setText(ventasTotales.toString());
		
		textAreaEmpleadoBuscado.setText("");
		textFieldEmpleadoABuscar.setText("");
		
		textAreaPrendaBuscada.setText("");
		textFieldPrendaABuscar.setText("");
		
		textAreaClienteBuscado.setText("");
		textFieldDniClienteABuscar.setText("");
		actualizarComponentesAgregarStock();
		actualizarCamposPanelesAgregarPrenda();
		limpiarComponentesAgregarCliente();
		limpiarComponentesBuscarVentas();
		limpiarComponentesClienteModificado();
	}

	/**
	 * Accion para dar de baja un empleado aprentando el boton especifico
	 * @param tiendaDeRopa con la que se va a trabajar 
	 */
	public void accionBotonBorrarEmpleado(TiendaDeRopa tiendaDeRopa) {
		botonBorrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String legajo = textFieldLegajoBorrarEmpleado.getText();
			if(tiendaDeRopa.existeEmpleado(legajo)) {
				tiendaDeRopa.bajaEmpleado(legajo);
				tiendaDeRopa.guardarTiendaDeRopa();
				textFieldLegajoBorrarEmpleado.setText("");
				textAreaBorrarEmpleado.setText(tiendaDeRopa.devolverNombreYApellidoEmpleadosConLegajo());
			}
			else {
				JOptionPane.showMessageDialog(null, "El legajo del empleado ingresado no existe");
			}
			
			}
		});
	}
	
	/**
	 * Accion para dar de baja una prenda apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonBorrarPrenda(TiendaDeRopa tiendaDeRopa) {
		botonBorrarPrenda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textFieldCodigoPrendaABorrar.getText();
				if(tiendaDeRopa.existePrenda(codigo)) {
					tiendaDeRopa.bajaPrenda(codigo);
					tiendaDeRopa.guardarTiendaDeRopa();
					textFieldCodigoPrendaABorrar.setText("");
					textAreaPrendaABorrar.setText(tiendaDeRopa.devolverPrendasConSuCodigo());
				}
				else {
					JOptionPane.showMessageDialog(null, "El codigo de la prenda que ingreso no existe");
				}
			}
		});
	}
	
	/**
	 * Accion para dar de baja un cliente apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaBorrarCliente(TiendaDeRopa tiendaDeRopa) {
		botonParaBorrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = textFieldDniClienteABorrar.getText();
				try {
						Cliente cliente = tiendaDeRopa.buscarClientePorDni(dni);
						if(cliente != null) {
							tiendaDeRopa.bajaCliente(cliente);
							tiendaDeRopa.guardarTiendaDeRopa();
							textFieldDniClienteABorrar.setText("");
							textAreaClientesABorrar.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
						}
					}
					catch(ErrorDeBusquedaExcepcion ex) {
						JOptionPane.showMessageDialog(null, "El cliente que ingreso no existe");
					}
			}
		});
	}
	
	/**
	 * Accion para dar de baja una venta apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaBorrarVenta(TiendaDeRopa tiendaDeRopa) {
		botonParaBorrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				int id = Integer.parseInt(textFieldBorrarVenta.getText());
				try {
					Venta venta = tiendaDeRopa.buscarVentaPorID(id);
					if(venta != null) {
						tiendaDeRopa.bajaVenta(venta);
						tiendaDeRopa.guardarTiendaDeRopa();
						textFieldBorrarVenta.setText("");
						textAreaVentasABorrar.setText(tiendaDeRopa.devolverVentasConIDClienteVendedorYFecha());
					}
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "Id ingresado no existente");
				}
			}		
			
			catch(Exception d) {
				JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros eneteros y sin espacios");
			}
		}
	});
	} 
	
	/**
	 * Accion para buscar un empleado apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaBuscarEmpleado(TiendaDeRopa tiendaDeRopa) {
		botonParaBuscarEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String legajo = textFieldEmpleadoABuscar.getText();
				
				try {
						Empleado empleado = tiendaDeRopa.buscarEmpleado(legajo);
						textAreaEmpleadoBuscado.setText(empleado.toString());
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "El empleado buscado no existe");
				}
			
			}
		});
	}
	
	/**
	 * Accion para buscar una prenda apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaBuscarUnaPrenda(TiendaDeRopa tiendaDeRopa) {
		botonParaBuscarUnaPrenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = textFieldPrendaABuscar.getText();
				
				try {
						PrendaDeVestir prenda = tiendaDeRopa.buscarPrenda(codigo);
						textAreaPrendaBuscada.setText(prenda.toString());
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "La prenda buscada no existe");
				}
			
			}
		});
	}

	/**
	 * Accion para buscar un cliente apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaBuscarUnCliente(TiendaDeRopa tiendaDeRopa) {
		botonParaBuscarUnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = textFieldDniClienteABuscar.getText();
				
				try {
					Cliente cliente = tiendaDeRopa.buscarClientePorDni(dni);
					if(cliente != null) {
						textAreaClienteBuscado.setText(cliente.toString());
					}
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "El cliente buscado no existe");
				}
				
			}
		});
	}
	
	/**
	 * Accion para cambiar de paneles cuando se quiere agregar una prenda. Cada prenda tiene atributos distintos
	 */
	public void accionCambiarDePanelesEnPrendas() {
		
		comboBoxTipoDePrenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = comboBoxTipoDePrenda.getSelectedIndex();
				switch(pos) {
				case 0:
					accionBotonPaneles(panelRemera, panelBuzo, panelMaya, panelCalzado, panelPantalon);
					break;
				case 1:
					accionBotonPaneles(panelBuzo, panelRemera, panelMaya, panelCalzado, panelPantalon);
					break;
				case 2:
					accionBotonPaneles(panelCalzado, panelRemera, panelBuzo, panelMaya,  panelPantalon);
					break;
				case 3:
					accionBotonPaneles(panelPantalon, panelRemera, panelBuzo, panelMaya, panelCalzado);
					break;
				case 4:
					accionBotonPaneles(panelMaya, panelRemera, panelBuzo,  panelCalzado, panelPantalon);
					break;
				}
				actualizarCamposPanelesAgregarPrenda();
			}
		});
		
	}
	
	/**
	 * Accion para agregar una prenda apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaAgregarUnaPrenda(TiendaDeRopa tiendaDeRopa) {
		
		botonParaAgregarUnaPrenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				if(comprobacionDeCamposVaciosAlAgregarPrenda()) {
					int marca = comboBoxMarca.getSelectedIndex()+1;
					String modelo = textFieldModelo.getText();
					String color = textFieldColor.getText();
					int tipoDeMaterial = comboBoxTipoDeMaterial.getSelectedIndex()+1;
					double precio = 0;
					
						try {
							precio = Double.parseDouble(textFieldPrecio.getText());
						}
						catch(Exception ex) {
							
						}
					
					int tipoDePrenda = comboBoxTipoDePrenda.getSelectedIndex();
					switch(tipoDePrenda) {
						case 0:
							String tipoEstampado = textFieldTipoEstamRemera.getText();
							if(!tipoEstampado.isEmpty()) {
								boolean esMangaCortaRemera = comprobacionBooleanoComboBox(comboBoxTipoDeMangaRemera);
								Remera remera = new Remera(marca, modelo, color, tipoDeMaterial, esMangaCortaRemera, tipoEstampado, precio);
								tiendaDeRopa.agregarPrenda(remera.getCodigo(), remera);	
							
							}
							else {
								JOptionPane.showMessageDialog(null, "Faltan campos que completar");
							}
							break;
						case 1:
							boolean esTipoCanguro = comprobacionBooleanoComboBox(comboBoxTipoDeBuzo);
							boolean esMangaCortaBuzo = comprobacionBooleanoComboBox(comboBoxTipoDeMangaBuzo);
							Buzo buzo = new Buzo(marca, modelo, color, tipoDeMaterial, esMangaCortaBuzo, esTipoCanguro, precio);
							tiendaDeRopa.agregarPrenda(buzo.getCodigo(), buzo);
							break;
						case 2:
							int tipoDeSuela = comboBoxTipoDeSuela.getSelectedIndex();
							Calzado calzado = new Calzado(marca, modelo, color, tipoDeMaterial, tipoDeSuela, precio);
							tiendaDeRopa.agregarPrenda(calzado.getCodigo(), calzado);
							break;
						case 3:
							boolean esAlCuerpo = comprobacionBooleanoComboBox(comboBoxPantalonEsAlCuerpo);
							Pantalon pantalon = new Pantalon(marca, modelo, color, tipoDeMaterial, esAlCuerpo, precio);
							tiendaDeRopa.agregarPrenda(pantalon.getCodigo(), pantalon);
							break;
						case 4:
							boolean esSecadoRapido = comprobacionBooleanoComboBox(comboBoxMayaEsSecadoRapido);
							boolean esPorArribaRodillas = comprobacionBooleanoComboBox(comboBoxMayaArribaRodiyas);
							Maya maya = new Maya(marca, modelo, color, tipoDeMaterial, esSecadoRapido, esPorArribaRodillas, precio);
							tiendaDeRopa.agregarPrenda(maya.getCodigo(), maya);
							break;
					}
				tiendaDeRopa.guardarTiendaDeRopa();
				actualizarCamposPanelesAgregarPrenda();
				JOptionPane.showMessageDialog(null, "Se ha agregado la prenda con exito");
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Faltan campos a completar");
				}
				
			}
		});
	
	}
	
	/**
	 * Metodo para comprobar un valor booleano a travez de un comboBox
	 * @param jComboBox a comprobar
	 * @return true o false segun el valor que se desee aplicar a la variable específica
	 */
	public boolean comprobacionBooleanoComboBox(JComboBox jComboBox) {
		boolean variable = false;
		int i = jComboBox.getSelectedIndex();
		if(i == 0) {
			variable = true;
		}
	return variable;
	}
	
	/**
	 * Comprueba que no haya campos vacios al agregar una prenda
	 * @return true si no hay campos vacios false si si los hay
	 */
	public boolean comprobacionDeCamposVaciosAlAgregarPrenda() {
		boolean estaTodoLleno = false;
		if(!textFieldModelo.getText().isEmpty()) {
			if(!textFieldColor.getText().isEmpty()) {
				if(!textFieldPrecio.getText().isEmpty()) {
					estaTodoLleno = true;
				}
			}
		}
		return estaTodoLleno;
	}

	/**
	 * Actualiza los campos de los paneles del panel agregar prenda
	 */
	public void actualizarCamposPanelesAgregarPrenda() {
		textFieldModelo.setText("");
		textFieldColor.setText("");
		textFieldPrecio.setText("");
		textFieldTipoEstamRemera.setText("");
	}
	
	public void accionBotonPrendaAAgregarStock(TiendaDeRopa tiendaDeRopa) {
		botonBuscarPrendaStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String codigo = textFieldPrendaABuscarStock.getText();
					PrendaDeVestir prendaDeVestir = tiendaDeRopa.buscarPrenda(codigo);
					
					comboBoxCantidad.setEnabled(true);
					textFieldTalle.setEnabled(true);
					botonParaAgregarStock.setEnabled(true);
					
					
					textAreaDetalleDeAgregado.setText(prendaDeVestir.getMarca()+" - "+prendaDeVestir.getModelo()+"\n"+prendaDeVestir.listarStockParaString());
				
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					actualizarComponentesAgregarStock();
					JOptionPane.showMessageDialog(null, "Prenda ingresada inexistente");
				}
			
			}
		});
	}
	
	/**
	 * Accion para agregar una stock a una prenda apretando el boton específico
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonParaAgregarStock(TiendaDeRopa tiendaDeRopa) {
		botonParaAgregarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String talle = textFieldTalle.getText();
				int cantidad = comboBoxCantidad.getSelectedIndex()+1;

				String codigo = textFieldPrendaABuscarStock.getText();
				if(!talle.isEmpty()) {
					try {
						PrendaDeVestir prendaDeVestir = tiendaDeRopa.buscarPrenda(codigo);
						tiendaDeRopa.agregarCantidadATalleEnPrenda(codigo, talle, cantidad);
						tiendaDeRopa.guardarTiendaDeRopa();
						textAreaDetalleDeAgregado.setText(prendaDeVestir.getMarca()+" - "+prendaDeVestir.getModelo()+"\n"+prendaDeVestir.listarStockParaString());
					}
					catch(ErrorDeBusquedaExcepcion e) {
						JOptionPane.showMessageDialog(null, "Error tipo de prenda modificada");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe ingresar un talle");
				}
			}
		});
	}
	
	/**
	 * Actualiza los componentes del panel para agregar Stock
	 */
	public void actualizarComponentesAgregarStock() {
		comboBoxCantidad.setEnabled(false);
		textFieldTalle.setEnabled(false);
		botonParaAgregarStock.setEnabled(false);
		comboBoxCantidad.setSelectedIndex(0);
		textFieldPrendaABuscarStock.setText("");
		textFieldTalle.setText("");
		textAreaDetalleDeAgregado.setText("");
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
	 * Este metodo se usa para realizar una accion cuando se preciona el boton agregar un cliente en el panel agregar cliente
	 * @param tiendaDeRopa con la que se va a trabajar 
	 */
	public void accionBotonAgregarUnCliente(TiendaDeRopa tiendaDeRopa) {
		botonParaAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tipoDeCliente = comboBoxTipoDeCliente.getSelectedIndex();
				
				String nombre = textFieldNombreCliente.getText();
				String apellido = textFieldApellidoCliente.getText();
				String dni = textFieldDNICliente.getText();
				int genero = devolverTipoDeGeneroRadioButton();
				String fechaNac = (String) comboBoxDiaCliente.getSelectedItem()+"/"+comboBoxMesCliente.getSelectedItem()+"/"+comboBoxAñoCliente.getSelectedItem();
				String domicilio = textFieldDomicilioCliente.getText();
				String email = textFieldEmailCliente.getText();
				
					
					if(genero != 0) {
							if(tipoDeCliente == 0) {
								if(comprobacionCamposVaciosAgregarCliente("Mayorista")) {
									
									String cuil = textFieldCUITCliente.getText();
									int condicionFrenteIVA = comboBoxCondicionFrenteAlIVACliente.getSelectedIndex()+1;
									
									Cliente mayorista = new ClienteMayorista(nombre, apellido, dni, genero, fechaNac, domicilio, email, cuil, condicionFrenteIVA);
									tiendaDeRopa.agregarCliente(mayorista);
									tiendaDeRopa.guardarTiendaDeRopa();
									limpiarComponentesAgregarCliente();
									JOptionPane.showMessageDialog(null, "El cliente se ha agregado correctamente");
								}
								else {
									JOptionPane.showMessageDialog(null, "Faltan compleatar campos");
								}
							}
							else {
								if(tipoDeCliente == 1) {
									if(comprobacionCamposVaciosAgregarCliente("Minorista")) {
										Cliente minorista = new ClienteMinorista(nombre, apellido, dni, genero, fechaNac, domicilio, email);
										tiendaDeRopa.agregarCliente(minorista);
										tiendaDeRopa.guardarTiendaDeRopa();
										limpiarComponentesAgregarCliente();
										JOptionPane.showMessageDialog(null, "El cliente se ha agregado correctamente");
									}
									else {
										JOptionPane.showMessageDialog(null, "Faltan compleatar campos");
									}
							}
						
							}
						}
					else {
						JOptionPane.showMessageDialog(null, "Faltan compleatar campos");
					}
			
				}
			});
		} 
	
	/**
	 * Comprueba que no haya campos vacíos en el panel para agregar un cliente  
	 * @param tipoDeCliente que se va a agregar, ya que difiere en una comprobacion de un campo mas si es mayorista o minorista
	 * @return true si no hay ningun campo vacio y false en caso contrario
	 */
	public boolean comprobacionCamposVaciosAgregarCliente(String tipoDeCliente) {
		boolean estaTodoLleno = false;

		if(!textFieldApellidoCliente.getText().isEmpty()) {
			if(!textFieldNombreCliente.getText().isEmpty()){
				if(!textFieldDNICliente.getText().isEmpty()){
					if(!textFieldDomicilioCliente.getText().isEmpty()){
						if(!textFieldEmailCliente.getText().isEmpty())	{
								estaTodoLleno = true;	
						}
					}
				}
			}
		}
		
		if(tipoDeCliente.equalsIgnoreCase("Mayorista")) {
			if(textFieldCUITCliente.getText().isEmpty()) { 
				estaTodoLleno = false;
			}
		}
		
		return estaTodoLleno;
	}
	
	/**
	 * Metodo para comprobar que genero se selecciono en base al grupo de los radioButton para elegir el genero.
	 * @return el genero en valor entero.
	 */
	public int devolverTipoDeGeneroRadioButton() {
		int genero = 0;
		
		if(radioButtonHombreCliente.isSelected()) {
			genero = 1;
		}
		else {
			if(radioButtonMujerCliente.isSelected()) {
				genero = 2;
			}
			else {
				if(radioButtonPerzonalizadoCliente.isSelected())
				genero = 3;
			}
		}
	return genero;
	}
	
	/**
	 * Se ejecuta una accion la cual consiste en poder acceder a determinados campos si se trata de un cliente mayorista,
	 * o a otros si es un cliente minorista
	 */
	public void accionSobreCamposDeTextoClienteMayorista() {
		 comboBoxTipoDeCliente.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		int tipoCliente = comboBoxTipoDeCliente.getSelectedIndex();
		    		
		    		if(tipoCliente == 0) {
		    			textFieldCUITCliente.setEnabled(true);
		    			comboBoxCondicionFrenteAlIVACliente.setEnabled(true);
		    			limpiarComponentesBuscarVentas();
		    		}
		    		else {
		    			if(tipoCliente == 1) {
		    				textFieldCUITCliente.setText("");
		    				comboBoxCondicionFrenteAlIVACliente.setSelectedIndex(0);
		    				textFieldCUITCliente.setEnabled(false);
			    			comboBoxCondicionFrenteAlIVACliente.setEnabled(false);
			    			limpiarComponentesBuscarVentas();
		    			}
		    		}
		    	}
		    });
	}
	
	/**
	 * Limpia los componentes del panel donde se va a agregar un cliente
	 */
	public void limpiarComponentesAgregarCliente() {
		textFieldApellidoCliente.setText("");
		textFieldNombreCliente.setText("");
		textFieldDNICliente.setText("");
		textFieldDomicilioCliente.setText("");
		textFieldEmailCliente.setText("");
		textFieldCUITCliente.setText("");
		comboBoxAñoCliente.setSelectedIndex(0);
		comboBoxDiaCliente.setSelectedIndex(0);
		comboBoxMesCliente.setSelectedIndex(0);
		comboBoxTipoDeCliente.setSelectedIndex(0);
		comboBoxCondicionFrenteAlIVACliente.setSelectedIndex(0);
	}
	
	/**
	 * Se ejecuta una accion donde se muestra un determinado panel para un criterio de búsqueda, u otro panel
	 * para otro criterio de busqueda, cuando se busca una venta
	 */
	public void accionCriterioDeBusquedaVentas() {
		comboBoxCriterioDeBusquedaVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int criterioDeBusqueda = comboBoxCriterioDeBusquedaVentas.getSelectedIndex();
			
				if(criterioDeBusqueda == 0) {
					panelVentasVendedores.setVisible(true);
					panelVentasAClientes.setVisible(false);
				}
				else {
					if(criterioDeBusqueda == 1) {
						panelVentasAClientes.setVisible(true);
						panelVentasVendedores.setVisible(false);
					}
				}
				limpiarComponentesBuscarVentas();
			}
		
		});
	}

	/**
	 * Este método ejecuta una accion la cual consiste en listar en una area de texto las ventas de un determinado vendedor
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionVerVentasVendedor(TiendaDeRopa tiendaDeRopa) {
		botonVerVentasVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String legajo = textFieldLegajoABuscarVentas.getText();
				 try {
				 	Empleado empleado = tiendaDeRopa.buscarEmpleado(legajo);
				 	if(empleado instanceof Vendedor) {
				 		textAreaVentasVendedores.setText(tiendaDeRopa.listarVentasDeUnVendedor(legajo));
				 	}
				 	else {
				 		JOptionPane.showMessageDialog(null, "Solo los vendedores poseen ventas");
				 	}
				 }
				 catch(ErrorDeBusquedaExcepcion ex) {
					 JOptionPane.showMessageDialog(null, "Legajo ingresado incorrecto ");
				 }
			}
		});
	}

	/**
	 * Este método ejecuta una accion la cual consiste en listar en una area de texto las ventas que se le realizo a un determinado cliente
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionVerVentasACliente(TiendaDeRopa tiendaDeRopa) {
		botonVerVentasAClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String dni = textFieldDNIDelClienteAVerVentas.getText();

				try {
					if(tiendaDeRopa.buscarClientePorDni(dni) != null) {
						
						textAreaVentasACliente.setText(tiendaDeRopa.listarVentasDeUnCliente(dni));
					}
				} 
				catch (ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "Cliente no existente");
				}
			}
		});
	}
	
	/**
	 * Este metodo limpia los componentes del panel donde se buscan las ventas
	 */
	public void limpiarComponentesBuscarVentas() {
		textFieldLegajoABuscarVentas.setText("");
		textFieldDNICliente.setText("");
		textAreaVentasVendedores.setText("");
		textAreaVentasACliente.setText("");
	}

	/**
	 * Ejecuta una accion que busca un cliente que se desea modificar, devuelve la informacion del cliente que puede ser modificable para poder modificarla 
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonBuscarClienteAModificar(TiendaDeRopa tiendaDeRopa) {
		botonBuscarClienteAModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = textFieldDNIClienteAModificar.getText();
				try {
					Cliente cliente = tiendaDeRopa.buscarClientePorDni(dni);
					
					textFieldDNIClienteAModificar.setEnabled(false);
					
					textFieldNombreAModificar.setEnabled(true);
					textFieldApellidoAModificar.setEnabled(true);
					textFieldEmailAModificar.setEnabled(true);
					textFieldDomicilioAModificar.setEnabled(true);
					comboBoxSexoClienteAModificar.setEnabled(true);
					
					textFieldNombreAModificar.setText(cliente.getNombre());
					textFieldApellidoAModificar.setText(cliente.getApellido());
					textFieldEmailAModificar.setText(cliente.getEmail());
					textFieldDomicilioAModificar.setText(cliente.getDomicilio());
					comboBoxSexoClienteAModificar.setSelectedIndex(cliente.getGeneroInt()-1);
					botonGuardarCambios.setEnabled(true);
					
					if(cliente instanceof ClienteMayorista) {
						comboBoxCondicionFrenteAlIVAAModificar.setEnabled(true);
						int condicionFrenteAlIVA = (((ClienteMayorista) cliente).getCondicionFrenteIVAInt());
						System.out.println(condicionFrenteAlIVA);
						if(condicionFrenteAlIVA < 6) {
							comboBoxCondicionFrenteAlIVAAModificar.setSelectedIndex(((ClienteMayorista) cliente).getCondicionFrenteIVAInt());
						}
						else {
							comboBoxCondicionFrenteAlIVAAModificar.setSelectedIndex(0);
						} 
					}
					else {
						if(cliente instanceof ClienteMinorista) {
							comboBoxCondicionFrenteAlIVAAModificar.setEnabled(false);
						}
					}
					
				}
				catch(ErrorDeBusquedaExcepcion ex) {
					JOptionPane.showMessageDialog(null, "El cliente no existe");
				}

			}
		});
	}

	/**
	 * Ejecuta una accion cuando se preciona el boton guardar cambios en el panel modificar cliente para guardar los datos que se hayan modificado
	 * @param tiendaDeRopa con la que se va a trabajar
	 */
	public void accionBotonGuardarCambios(TiendaDeRopa tiendaDeRopa) {
		botonGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobacionDeCamposVaciosModificarCliente())  {
					String dni = textFieldDNIClienteAModificar.getText();
					
					try {
						Cliente clienteModificado = tiendaDeRopa.buscarClientePorDni(dni);
						clienteModificado.setNombre(textFieldNombreAModificar.getText());
						clienteModificado.setApellido(textFieldApellidoAModificar.getText());
						clienteModificado.setDomicilio(textFieldDomicilioAModificar.getText());
						clienteModificado.setEmail(textFieldEmailAModificar.getText());
						clienteModificado.setGenero(comboBoxSexoClienteAModificar.getSelectedIndex()+1);
						
						if(clienteModificado instanceof ClienteMayorista) {
							((ClienteMayorista) clienteModificado).setCondicionFrenteIVA(comboBoxCondicionFrenteAlIVAAModificar.getSelectedIndex());
						}	
	
						tiendaDeRopa.modificarCliente(dni, clienteModificado);
						
						textAreaClientesModificables.setText(tiendaDeRopa.devolverClientesConSuNombreApellidoYDni());
						limpiarComponentesClienteModificado();					
						
						tiendaDeRopa.guardarTiendaDeRopa();
						JOptionPane.showMessageDialog(null, "El cliente se ha modificado con exito");
						
					} catch (ErrorDeBusquedaExcepcion ex) {
						JOptionPane.showMessageDialog(null, "El cliente no existe");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Faltan completar campos vacios");
				}
			}
		});
	}
	
	/**
	 * Hace una comprobacion de que no hayan campos vacios en el panel para modificar cliente 
	 * @return
	 */
	public boolean comprobacionDeCamposVaciosModificarCliente() {
		boolean estaTodoLleno = false;
		
		if(!textFieldNombreAModificar.getText().isEmpty()) {
			if(!textFieldApellidoAModificar.getText().isEmpty()) {
				if(!textFieldEmailAModificar.getText().isEmpty()) {
					if(!textFieldDomicilioAModificar.getText().isEmpty()) {
						estaTodoLleno = true;
					}
				}
			}
		}
		
		return estaTodoLleno;
	}
	
	/**
	 * Limpia los componentes del panel para modificar cliente 
	 */
	public void limpiarComponentesClienteModificado() {
		textFieldNombreAModificar.setText("");
		textFieldApellidoAModificar.setText("");
		textFieldEmailAModificar.setText("");
		textFieldDomicilioAModificar.setText("");
		textFieldDNIClienteAModificar.setText("");
		textFieldDNIClienteAModificar.setEnabled(true);
		botonGuardarCambios.setEnabled(false);
		textFieldNombreAModificar.setEnabled(false);
		textFieldApellidoAModificar.setEnabled(false);
		textFieldEmailAModificar.setEnabled(false);
		textFieldDomicilioAModificar.setEnabled(false);
		comboBoxSexoClienteAModificar.setEnabled(false);
		comboBoxCondicionFrenteAlIVAAModificar.setEnabled(false);
	}
	
}

