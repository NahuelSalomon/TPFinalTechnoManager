package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;
import ClasesPrendasDeVestir.PrendaDeVestir;
import Excepciones.ErrorDeBusquedaExcepcion;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaOpcionesGerente extends JFrame {

	private JPanel contentPane;
	JPanel panelListarEmpleados;
	JPanel panelListarVentas;
	JPanel panelListarPrendas;
	JPanel panelListarClientes;
	JPanel panelBorrarUnEmpleado;
	JPanel panelBorrarUnaPrenda;
	JPanel panelBorrarUnCliente;
	JPanel panelBorrarUnaVenta;
	JPanel panelBuscarEmpleado;
	JPanel panelBuscarPrenda;
	JPanel panelModificarUnCliente;
	JPanel panelModificarUnaPrenda;
	JPanel panelAgregarUnCliente;
	JPanel panelBuscarUnaVenta;
	JPanel panelAgregarUnaPrenda;
	JPanel panelBuscarCliente;
	JTextArea textAreaListarClientes;
	JTextArea textAreaListarPrendas;
	JTextArea textAreaListarEmpleados;
	JTextArea textAreaVerVentas;
	JTextArea textAreaPrendaABorrar;
	JTextArea textAreaBorrarEmpleado;
	JTextArea textAreaClientesABorrar;
	JTextArea textAreaVentasABorrar;
	JTextArea textAreaEmpleadoBuscado;
	JTextArea textAreaPrendaBuscada;
	JTextArea textAreaClienteBuscado;
	
	private JTextField textFieldLegajoBorrarEmpleado;
	private JTextField textFieldCodigoPrendaABorrar;
	JButton btnCerrarSesion;
	JButton botonListarEmpleados;
	JButton botonBorrarEmpleado;
	JButton botonBorrarPrenda_1;
	JButton botonParaBorrarCliente;
	JButton botonParaBorrarVenta;
	JButton botonParaBuscarEmpleado;
	JButton botonParaBuscarUnaPrenda;
	JButton botonParaBuscarUnCliente;
	private JTextField textFieldDniClienteABorrar;
	private JTextField textFieldBorrarVenta;
	private JTextField textField;
	JTextField textFieldEmpleadoABuscar;
	private JTextField textFieldPrendaABuscar;
	private JTextField textFieldDniClienteABuscar;
	
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
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
		
		
		
		
		/*
		 * JButton
		 */
		JButton botonVentasTotales = new JButton("Ver ventas totales");
		botonVentasTotales.setForeground(Color.WHITE);
		botonVentasTotales.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonVentasTotales.setBackground(new Color(0, 0, 128));
		botonVentasTotales.setBounds(492, 475, 197, 23);
		contentPane.add(botonVentasTotales);
		
		JButton botonTicketPromedio = new JButton("Ticket promedio");
		botonTicketPromedio.setForeground(Color.WHITE);
		botonTicketPromedio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonTicketPromedio.setBackground(new Color(0, 0, 128));
		botonTicketPromedio.setBounds(492, 441, 197, 23);
		contentPane.add(botonTicketPromedio);
		
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
		
		JButton botonModificarPrendas = new JButton("Modificar prenda");
		botonModificarPrendas.setForeground(Color.WHITE);
		botonModificarPrendas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonModificarPrendas.setBackground(new Color(0, 0, 128));
		botonModificarPrendas.setBounds(255, 211, 197, 23);
		contentPane.add(botonModificarPrendas);
		
		
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
		
		JTextArea textAreaLegajosDeEmpleados = new JTextArea();
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
		
		JTextArea textAreaPrendaABuscar = new JTextArea();
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
		
		JTextArea textAreaClientesABuscar = new JTextArea();
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
		
		/*
		 * Panel para agregar una prenda
		 */
		panelAgregarUnaPrenda = new JPanel();
		panelAgregarUnaPrenda.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelAgregarUnaPrenda, "name_183728166038100");
		panelAgregarUnaPrenda.setLayout(null);
		
		/*
		 * Panel para agregar un cliente
		 */
		panelAgregarUnCliente = new JPanel();
		panelAgregarUnCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelAgregarUnCliente, "name_183910682629600");
		panelAgregarUnCliente.setLayout(null);
		
		/*
		 * Panel para modificar una prenda
		 */
		panelModificarUnaPrenda = new JPanel();
		panelModificarUnaPrenda.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelModificarUnaPrenda, "name_183995662503400");
		panelModificarUnaPrenda.setLayout(null);
		
		/*
		 * Panel para modificar un cliente
		 */
		panelModificarUnCliente = new JPanel();
		panelModificarUnCliente.setBackground(new Color(0, 0, 128));
		layeredPane.add(panelModificarUnCliente, "name_184126000696700");
		panelModificarUnCliente.setLayout(null);
		
		/*
		 * Acciones
		 */
		accionBotonCerrarSesion();
		accionBotonBorrarEmpleado(tiendaDeRopa);
		accionBotonBorrarPrenda(tiendaDeRopa);
		accionBotonParaBorrarCliente(tiendaDeRopa);
		accionBotonParaBorrarVenta(tiendaDeRopa);
		accionBotonParaBuscarEmpleado(tiendaDeRopa);
		accionBotonParaBuscarUnaPrenda(tiendaDeRopa);
		accionBotonParaBuscarUnCliente(tiendaDeRopa);
		
		accionBotonPaneles(tiendaDeRopa, botonListarEmpleados, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonListarPrendas, panelListarPrendas, panelListarClientes, panelListarEmpleados , panelListarVentas , panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonListarClientes, panelListarClientes, panelListarEmpleados, panelListarPrendas, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonRegistroVentas, panelListarVentas, panelListarClientes, panelListarPrendas, panelListarEmpleados,panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBorrarUnEmpleado, panelBorrarUnEmpleado, panelListarPrendas, panelListarClientes, panelListarEmpleados, panelListarVentas, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBorrarPrenda, panelBorrarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBorrarCliente, panelBorrarUnCliente, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBorrarUnaVenta, panelBorrarUnaVenta, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBuscarUnEmpleado, panelBuscarEmpleado, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBuscarPrenda, panelBuscarPrenda,panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBuscarCliente, panelBuscarCliente, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarUnaVenta, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonBuscarVenta, panelBuscarUnaVenta, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelAgregarUnaPrenda, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonAgregarPrenda, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelAgregarUnCliente, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonAgregarCliente, panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelModificarUnaPrenda, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, botonModificarPrendas, panelModificarUnaPrenda,panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelModificarUnCliente);
		accionBotonPaneles(tiendaDeRopa, BotonModificarCliente, panelModificarUnCliente, panelAgregarUnCliente, panelAgregarUnaPrenda, panelListarEmpleados, panelListarPrendas,panelListarClientes, panelListarVentas, panelBorrarUnEmpleado, panelBorrarUnaPrenda, panelBorrarUnCliente, panelBorrarUnaVenta,panelBuscarEmpleado, panelBuscarPrenda, panelBuscarCliente, panelBuscarUnaVenta, panelModificarUnaPrenda);
		
	
	}

	
	public void accionBotonCerrarSesion() {
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
	
	}
	
	public void accionBotonPaneles(TiendaDeRopa tiendaDeRopa, JButton boton, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10, JPanel p11, JPanel p12, JPanel p13, JPanel p14, JPanel p15, JPanel p16) {
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
				tiendaDeRopa.actualizarTiendaDeRopa();
				actualizarAreasDeTextoPaneles(tiendaDeRopa);
			}
		});
	}

	public void actualizarAreasDeTextoPaneles(TiendaDeRopa tiendaDeRopa) {
		textAreaListarClientes.setText(tiendaDeRopa.listarClientes());
		textAreaListarEmpleados.setText(tiendaDeRopa.listarEmpleados());
		textAreaListarPrendas.setText(tiendaDeRopa.listarPrenda());
		textAreaVerVentas.setText(tiendaDeRopa.listarVentas());
		
		textAreaEmpleadoBuscado.setText("");
		textFieldEmpleadoABuscar.setText("");
		
		textAreaPrendaBuscada.setText("");
		textFieldPrendaABuscar.setText("");
		
		textAreaClienteBuscado.setText("");
		textFieldDniClienteABuscar.setText("");
	}

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
	
	public void accionBotonParaBorrarVenta(TiendaDeRopa tiendaDeRopa) {
		botonParaBorrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
	} 
	
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

}

