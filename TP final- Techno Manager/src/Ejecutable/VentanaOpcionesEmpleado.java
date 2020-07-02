package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Archivos.archivoEmpleados;
import ClaseVenta.Venta;
import ClasesPersona.Cliente;
import ClasesPersona.Empleado;
import ClasesPersona.Vendedor;
import ClasesPrendasDeVestir.Buzo;
import ClasesPrendasDeVestir.Calzado;
import ClasesPrendasDeVestir.Maya;
import ClasesPrendasDeVestir.Pantalon;
import ClasesPrendasDeVestir.PrendaDeVestir;
import ClasesPrendasDeVestir.PrendaSuperior;
import ClasesPrendasDeVestir.Remera;
import Excepciones.ErrorDeBusquedaExcepcion;
import Excepciones.LimiteExedidoDeGerenteExcepcion;
import Listas.ListaDeClientes;
import Listas.ListaDeEmpleados;
import Listas.ListaDePrendas;
import Listas.ListaDeVentas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JList;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class VentanaOpcionesEmpleado extends JFrame {
	
	private TiendaDeRopa tiendaDeRopa;
	private Empleado empleado;

	private JPanel contentPane;
	private JPanel panVendedor;
	private JTextField textVendedorNombre;
	private JTextField textVendedorApellido;
	private JTextField textVendedorLegajo;
	private JTextField textVendedorContrasenia;
	private JTextField textVendedorNumTel;
	private JFormattedTextField textCantidad;
	private JTextField textPrendaModelo;
	private JTextField textPrendaColor;
	private JTextField textPrendaTalla;
	private JFormattedTextField textPrendaStock;
	private JFormattedTextField textPrendaPrecio;
	private JTextField textPrendaCarac1;
	private JTextField textTalla;
	private JTable tablePrendaAjuste;
	private JTextField textAjusteTalla;
	private JTextField textAjusteStock;
	
	private JLabel lbMostrarNombre;
	private JLabel lbMostrarApellido;
	private JLabel lbMostrarGenero;
	private JLabel lbMostrarDni;
	private JLabel lbMostrarFechaNac;
	private JLabel lbMostrarEstadoCiv;
	private JLabel lbMostrarLegajo;
	private JLabel lbMostrarContrasenia;
	private JLabel lbMostrarNumTel;
	private JTextField textAjusteModelo;
	private JTextField textAjusteColor;
	private JTextField textAjusteCarac1;
	private JTextField textAjustePrecio;
	
	private JTable tablePrendas;
	private Cliente clienteSelected;
	private JTextArea taVerMisVentas;
	private JPanel panVerMisVentas_1;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public VentanaOpcionesEmpleado(Empleado emp, TiendaDeRopa tienda) throws FileNotFoundException, ClassNotFoundException, IOException {
			
		this.tiendaDeRopa = tienda;
		this.empleado = emp;
		
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
				dispose();
				VentanaDeEntrada ventanaDeEntrada = new VentanaDeEntrada(tiendaDeRopa);
				ventanaDeEntrada.setVisible(true);
			}
		});
		
		botonAtras.setForeground(new Color(255, 255, 255));
		botonAtras.setBackground(new Color(0, 0, 128));
		botonAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonAtras.setBounds(10, 11, 123, 23);
		botonAtras.setVisible(true);
		contentPane.add(botonAtras);
		
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
		botonAgregarPrendaDeVestir.setBounds(33, 199, 241, 23);
		contentPane.add(botonAgregarPrendaDeVestir);
		
		JButton botonModificarDatosPersonales = new JButton("Modificar datos personales\r\n");
		botonModificarDatosPersonales.setForeground(new Color(255, 255, 255));
		botonModificarDatosPersonales.setBackground(new Color(0, 0, 128));
		botonModificarDatosPersonales.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		botonModificarDatosPersonales.setBounds(33, 233, 241, 23);
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
		
		tablePrendas = new JTable();
		tablePrendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePrendas.setModel(cargarJTableConArrayList(tiendaDeRopa.devolverPrendas()));
		tablePrendas.getColumnModel().getColumn(3).setPreferredWidth(180);
		tablePrendas.setRowHeight(50);
		
		JPanel panRegistrarVenta = new JPanel();
		metodoPanelRegistrarVenta(panRegistrarVenta, tablePrendas);
		lpanGeneral.add(panRegistrarVenta, "name_99930197253561");
		panRegistrarVenta.setVisible(false);		
		panRegistrarVenta.setLayout(null);
		
		panVerMisVentas_1 = new JPanel();
		metodoPanelVerMisVentas(panVerMisVentas_1);
		lpanGeneral.add(panVerMisVentas_1, "name_99930226415368");
		panVerMisVentas_1.setVisible(false);
		panVerMisVentas_1.setLayout(null);
		
		JPanel panModificarDatosPer = new JPanel();
		metodoPanelModificarDatosPersonales(panModificarDatosPer, botonNombreEmpleado);
		lpanGeneral.add(panModificarDatosPer, "name_130561065365849");
		panModificarDatosPer.setLayout(null);
		panModificarDatosPer.setVisible(false);
		 
		JPanel panAgregarPrendas = new JPanel();
		metodoPanelAgregarPrenda(panAgregarPrendas, tablePrendas);
		lpanGeneral.add(panAgregarPrendas, "name_99930253616870");
		panAgregarPrendas.setVisible(false);
		
		JButton btnPrendaAjustarStock = new JButton("Ajustar Stock");
		btnPrendaAjustarStock.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrendaAjustarStock.setForeground(new Color(255, 255, 255));
		btnPrendaAjustarStock.setBackground(new Color(0, 0, 255));
		btnPrendaAjustarStock.setBounds(224, 266, 104, 23);
		panAgregarPrendas.add(btnPrendaAjustarStock);
		
		JPanel panPrendaAjusteStock = new JPanel();
		metodoPanelAjuste(panPrendaAjusteStock);
		lpanGeneral.add(panPrendaAjusteStock, "name_1185469176420466");
		panPrendaAjusteStock.setLayout(null);
		
		JButton btnPrendaAjusteAtras = new JButton("Atras");
		btnPrendaAjusteAtras.setBounds(10, 11, 68, 23);
		panPrendaAjusteStock.add(btnPrendaAjusteAtras);
		
		panVendedor = new JPanel();
		metodoPanelVendedor();
		lpanGeneral.add(panVendedor, "name_99930277307032");
		panVendedor.setVisible(true);
		panVendedor.setLayout(null);
				
		accionBotonPaneles(botonRegistrarVenta, panRegistrarVenta, panAgregarPrendas, panVendedor, panVerMisVentas_1, panModificarDatosPer, panPrendaAjusteStock);
		accionBotonPaneles(botonVerVentas, panVerMisVentas_1, panAgregarPrendas, panVendedor, panRegistrarVenta, panModificarDatosPer, panPrendaAjusteStock);
		accionBotonPaneles(botonModificarDatosPersonales, panModificarDatosPer, panAgregarPrendas, panVendedor, panVerMisVentas_1, panRegistrarVenta, panPrendaAjusteStock);
		accionBotonPaneles(botonAgregarPrendaDeVestir, panAgregarPrendas, panVerMisVentas_1, panVendedor, panRegistrarVenta, panModificarDatosPer, panPrendaAjusteStock);
		accionBotonPaneles(botonNombreEmpleado, panVendedor, panAgregarPrendas, panVerMisVentas_1, panRegistrarVenta, panModificarDatosPer, panPrendaAjusteStock);
		accionBotonPaneles(btnPrendaAjustarStock, panPrendaAjusteStock, panRegistrarVenta, panAgregarPrendas, panVendedor, panModificarDatosPer, panVerMisVentas_1);
		accionBotonPaneles(btnPrendaAjusteAtras, panAgregarPrendas, panVerMisVentas_1, panVendedor, panRegistrarVenta, panModificarDatosPer, panPrendaAjusteStock);
		
		
	}
	
	public void metodoPanelRegistrarVenta(JPanel panRegistrarVenta, JTable tablePrendas) {
		//----PANEL REGISTRAR VENTA----//
		
		JComboBox cbCliente = new JComboBox();
		ArrayList<Cliente> clientes = tiendaDeRopa.devolverClientes();
		
		for(Cliente elem : clientes) {
			cbCliente.addItem(elem.getNombre()+" "+elem.getApellido());
		}
		cbCliente.setBounds(10, 4, 200, 20);
		panRegistrarVenta.add(cbCliente);
		
		cbCliente.setSelectedIndex(0);
		clienteSelected = clientes.get(cbCliente.getSelectedIndex());
		
		cbCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(!clienteSelected.getDni().equals(clientes.get(cbCliente.getSelectedIndex()).getDni())) {
					clienteSelected = clientes.get(cbCliente.getSelectedIndex());
				}
			}
		});
		
		Date fechaActual = new Date();
		
		JLabel lblFecha = new JLabel(fechaActual.toString());
		lblFecha.setBounds(235, 7, 205, 14);
		panRegistrarVenta.add(lblFecha);
		
		JButton btnFinalizarVenta = new JButton("Finalizar");
		btnFinalizarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizarVenta.setForeground(new Color(255, 255, 255));
		btnFinalizarVenta.setBackground(new Color(0, 0, 128));
		btnFinalizarVenta.setBounds(335, 263, 105, 25);
		panRegistrarVenta.add(btnFinalizarVenta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 430, 97);
		panRegistrarVenta.add(scrollPane);
		
		scrollPane.setViewportView(tablePrendas);
		
		textCantidad = new JFormattedTextField();
		textCantidad.setBounds(252, 137, 30, 20);
		textCantidad.setValue(new Integer(1));
		panRegistrarVenta.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lbIndiqueCantidad = new JLabel("Indique Cantidad:");
		lbIndiqueCantidad.setBounds(139, 137, 98, 20);
		panRegistrarVenta.add(lbIndiqueCantidad);
		
		JButton btnAgregarAlCarro = new JButton("Agregar al Carro");
		btnAgregarAlCarro.setBounds(292, 136, 148, 23);
		panRegistrarVenta.add(btnAgregarAlCarro);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 173, 430, 79);
		panRegistrarVenta.add(scrollPane_1);
		
		JTable tableCarro = new JTable();
		scrollPane_1.setViewportView(tableCarro);
		tableCarro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modeloTableCarro = new DefaultTableModel(new Object[] {"Modelo","Marca","Talla","Cantidad","Codigo"}, 0);
		tableCarro.setModel(modeloTableCarro);
		
		JButton btnEliminarDelCarro = new JButton("Eliminar del Carro");
		btnEliminarDelCarro.setBounds(152, 266, 130, 23);
		panRegistrarVenta.add(btnEliminarDelCarro);
		
		JLabel lblSubTotal = new JLabel("Sub-Total:");
		lblSubTotal.setBounds(10, 266, 68, 23);
		panRegistrarVenta.add(lblSubTotal);
		
		JLabel lblPrendasSubTotal = new JLabel("0");
		lblPrendasSubTotal.setBounds(88, 270, 46, 14);
		panRegistrarVenta.add(lblPrendasSubTotal);
		
		JLabel lblIndiqueTalla = new JLabel("Indique Talla:");
		lblIndiqueTalla.setBounds(10, 140, 80, 14);
		panRegistrarVenta.add(lblIndiqueTalla);
		
		textTalla = new JTextField();
		textTalla.setBounds(103, 137, 30, 20);
		panRegistrarVenta.add(textTalla);
		textTalla.setColumns(10);
		
		JLabel lblPistaTalles = new JLabel("");
		lblPistaTalles.setBounds(54, 158, 46, 14);
		panRegistrarVenta.add(lblPistaTalles);
		
		btnAgregarAlCarro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSeleccionada = tablePrendas.getSelectedRow();
				PrendaDeVestir prenda = null;
				int cant = (Integer)textCantidad.getValue();
				boolean flag = false;
				
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No solecciono una prenda");
				}
				else {
					
					try {
						prenda = tiendaDeRopa.buscarPrenda((String)tablePrendas.getValueAt(filaSeleccionada, 4));
						if(cant < 1) {
							JOptionPane.showMessageDialog(null, "Cantidad indicada no valida");
						}
						else if(!prenda.existeTalle(textTalla.getText())) {
							JOptionPane.showMessageDialog(null, "Talla indicada no valida");
						}
						else if(prenda.getCantidadSegTalla(textTalla.getText()) < cant) {
							JOptionPane.showMessageDialog(null, "Cantidad indicada excede el stock disponible");
						}
						else {
							prenda.quitarCantidadATalle(textTalla.getText(), cant);
							tiendaDeRopa.modificarPrenda(prenda.getCodigo(), prenda);
							
							tablePrendas.setModel(cargarJTableConArrayList(tiendaDeRopa.devolverPrendas()));
							tablePrendas.getColumnModel().getColumn(3).setPreferredWidth(180);
							tablePrendas.setRowHeight(50);
							
							for(int i = 0; i < tableCarro.getRowCount(); i++) {
								if(tableCarro.getValueAt(i, 4).equals(prenda.getCodigo()) && tableCarro.getValueAt(i, 2).equals(textTalla.getText())) {
									int stock = (int) tableCarro.getValueAt(i, 3);
									tableCarro.setValueAt(stock + cant, i, 3);
									flag = true;
								}
							}
							if(!flag) {
								modeloTableCarro.addRow(new Object[] {prenda.getModelo(),prenda.getMarca(),textTalla.getText(),cant,prenda.getCodigo()});
								tableCarro.setModel(modeloTableCarro);
							}
							
							double subtotal = Double.parseDouble(lblPrendasSubTotal.getText());
							subtotal = subtotal + (prenda.getPrecio() * cant);
							lblPrendasSubTotal.setText(String.valueOf(subtotal));
						}
					}
					catch(ErrorDeBusquedaExcepcion e) {
						e.printStackTrace();
					}
				
				}
			}
		});
		
		btnEliminarDelCarro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSeleccionada = tableCarro.getSelectedRow();
				PrendaDeVestir prenda = null;
				
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No solecciono una prenda para quitar del carro");
				}
				else {
					
					try {
						prenda = tiendaDeRopa.buscarPrenda((String)tableCarro.getValueAt(filaSeleccionada, 4));
						String talle = (String) tableCarro.getValueAt(filaSeleccionada, 2);
						int cant = (int) tableCarro.getValueAt(filaSeleccionada, 3);
						
						prenda.agregarCantidadATalle(talle, cant);
						tiendaDeRopa.modificarPrenda(prenda.getCodigo(), prenda);
						
						double subtotal = Double.parseDouble(lblPrendasSubTotal.getText());
						double res = subtotal - (prenda.getPrecio() * cant);
						lblPrendasSubTotal.setText(String.valueOf(res));
								
						DefaultTableModel model = (DefaultTableModel) tableCarro.getModel();
						model.removeRow(filaSeleccionada);
						tableCarro.setModel(model);
						
						tablePrendas.setModel(cargarJTableConArrayList(tiendaDeRopa.devolverPrendas()));
						tablePrendas.getColumnModel().getColumn(3).setPreferredWidth(180);
						tablePrendas.setRowHeight(50);					
					}
					catch(ErrorDeBusquedaExcepcion e) {
						e.printStackTrace();
					}
				
				}
			}
		});
		
		btnFinalizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tableCarro.getRowCount() != 0) {
					if(JOptionPane.showConfirmDialog(null, "Finalizar la venta?") == JOptionPane.YES_OPTION) {
						Date fechaActual = new Date();
						lblFecha.setText(fechaActual.toString());
						
						HashMap<PrendaDeVestir, Integer> prendas = new HashMap<PrendaDeVestir, Integer>();
						for(int i = 0; i < tableCarro.getRowCount(); i++) {
							try {
								PrendaDeVestir pre = tiendaDeRopa.buscarPrenda((String) tableCarro.getValueAt(i, 4));
								int cant = (Integer)tableCarro.getValueAt(i, 3);
								
								if(!prendas.containsKey(pre)) {
									prendas.put(pre, cant);
								}	
								else {
									int cantAgregada = cant;
									int cantExistente = prendas.get(pre);
									prendas.put(pre, (cantAgregada + cantExistente));
								}
							} catch (ErrorDeBusquedaExcepcion e) {
								e.printStackTrace();
							}
						}
						
						Venta regVenta = null;
						regVenta = new Venta(clienteSelected, (Vendedor)empleado, lblFecha.getText(), prendas);
						tiendaDeRopa.agregarVenta(regVenta);
						
						DefaultTableModel model = (DefaultTableModel) tableCarro.getModel();
				        int a = tableCarro.getRowCount()-1;
				        for (int i = a; i >= 0; i--) {          
				        	model.removeRow(model.getRowCount()-1);
				        }
						tableCarro.setModel(model);
						
						tablePrendaAjuste.setModel(cargarJTablePrendaAjuste(tiendaDeRopa.devolverPrendas()));
						tablePrendaAjuste.getColumnModel().getColumn(3).setPreferredWidth(180);
						tablePrendaAjuste.setRowHeight(50);
						
						lblPrendasSubTotal.setText("0");
						
						cbCliente.setSelectedIndex(0);
						
						taVerMisVentas.setText(tiendaDeRopa.listarVentasDeUnVendedor(empleado.getLegajo()));
						
						JOptionPane.showMessageDialog(null, "Venta realizada con exito!");
					}
				}
				else JOptionPane.showMessageDialog(null, "El Carro esta vacio, no es posible realizar la venta");
				
				
			}
		});
		//--------//
	}
	
	public void metodoPanelVerMisVentas(JPanel panVerMisVentas) {
		JLabel lblVerMisVentasTitulo = new JLabel("Mis Ventas:");
		lblVerMisVentasTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVerMisVentasTitulo.setBounds(10, 11, 120, 23);
		panVerMisVentas.add(lblVerMisVentasTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 430, 244);
		panVerMisVentas_1.add(scrollPane);
		
		taVerMisVentas = new JTextArea();
		scrollPane.setViewportView(taVerMisVentas);
		taVerMisVentas.setEditable(false);
		taVerMisVentas.setText(tiendaDeRopa.listarVentasDeUnVendedor(empleado.getLegajo()));
				
	}
	
	public void metodoPanelAgregarPrenda (JPanel panAgregarPrendas, JTable tablePrendas) {
		//----PANEL AGREGAR PRENDA----//
		panAgregarPrendas.setLayout(null);
		
		JLabel lblPrendaCaracteristicasGenerales = new JLabel("Caracteristicas Generales");
		lblPrendaCaracteristicasGenerales.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrendaCaracteristicasGenerales.setBounds(10, 11, 185, 20);
		panAgregarPrendas.add(lblPrendaCaracteristicasGenerales);
		
		JLabel lblPrendaMarca = new JLabel("Marca:");
		lblPrendaMarca.setBounds(10, 42, 46, 14);
		panAgregarPrendas.add(lblPrendaMarca);
		
//		- 1. Zara - 2. Nike	- 3. Gucci - 4. Adidas - 5. Lacoste	- 6. Chanel	- 7. Levi’s
		
		JComboBox cbPrendaMarca = new JComboBox();
		cbPrendaMarca.setModel(new DefaultComboBoxModel(new String [] {"No definido","Zara","Nike","Gucci","Adidas","Lacoste","Chanel","Levi's"}));
		cbPrendaMarca.setBounds(109, 39, 86, 20);
		panAgregarPrendas.add(cbPrendaMarca);
		
		JLabel lblPrendasModelo = new JLabel("Modelo:");
		lblPrendasModelo.setBounds(10, 75, 46, 14);
		panAgregarPrendas.add(lblPrendasModelo);
		
		textPrendaModelo = new JTextField();
		textPrendaModelo.setBounds(109, 72, 86, 20);
		panAgregarPrendas.add(textPrendaModelo);
		textPrendaModelo.setColumns(10);
		
		JLabel lblPrendaTipoMaterial = new JLabel("Tipo de Material:");
		lblPrendaTipoMaterial.setBounds(10, 109, 104, 14);
		panAgregarPrendas.add(lblPrendaTipoMaterial);
		
		JComboBox cbPrendaTipoMaterial = new JComboBox();
		cbPrendaTipoMaterial.setModel(new DefaultComboBoxModel(new String [] {"No definido","Algodon","Terciopelo","Calico","Fieltro","Seda"}));
		cbPrendaTipoMaterial.setBounds(109, 106, 86, 20);
		panAgregarPrendas.add(cbPrendaTipoMaterial);
		
		JLabel lblPrendaColor = new JLabel("Color:");
		lblPrendaColor.setBounds(245, 42, 46, 14);
		panAgregarPrendas.add(lblPrendaColor);
		
		textPrendaColor = new JTextField();
		textPrendaColor.setBounds(338, 39, 86, 20);
		panAgregarPrendas.add(textPrendaColor);
		textPrendaColor.setColumns(10);
		
		JLabel lblPrendaTalla = new JLabel("Talla:");
		lblPrendaTalla.setBounds(245, 75, 46, 14);
		panAgregarPrendas.add(lblPrendaTalla);
		
		textPrendaTalla = new JTextField();
		textPrendaTalla.setBounds(286, 72, 29, 20);
		panAgregarPrendas.add(textPrendaTalla);
		textPrendaTalla.setColumns(10);
		
		JLabel lblPrendaStock = new JLabel("Stock:");
		lblPrendaStock.setBounds(338, 75, 46, 14);
		panAgregarPrendas.add(lblPrendaStock);
		
		textPrendaStock = new JFormattedTextField();
		textPrendaStock.setValue(new Integer(1));
		textPrendaStock.setBounds(383, 72, 29, 20);
		panAgregarPrendas.add(textPrendaStock);
		textPrendaStock.setColumns(10);
		
		JLabel lblPrendaPrecio = new JLabel("Precio:");
		lblPrendaPrecio.setBounds(245, 109, 46, 14);
		panAgregarPrendas.add(lblPrendaPrecio);
		
		textPrendaPrecio = new JFormattedTextField();
		textPrendaPrecio.setBounds(338, 106, 86, 20);
		panAgregarPrendas.add(textPrendaPrecio);
		textPrendaPrecio.setColumns(10);
		
		JLabel lblPrendaCaracteristicasEspeciales = new JLabel("Caracteristicas Especiales");
		lblPrendaCaracteristicasEspeciales.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrendaCaracteristicasEspeciales.setBounds(10, 146, 185, 20);
		panAgregarPrendas.add(lblPrendaCaracteristicasEspeciales);
		
		JLabel lblPrendaTipoPrenda = new JLabel("Tipos de Prenda:");
		lblPrendaTipoPrenda.setBounds(10, 177, 104, 14);
		panAgregarPrendas.add(lblPrendaTipoPrenda);
		
		JComboBox cbPrendaTipoPrenda = new JComboBox();
		cbPrendaTipoPrenda.setModel(new DefaultComboBoxModel(new String[] {"No definido","Calzado", "Buzo", "Remera", "Pantalon", "Maya"}));
		cbPrendaTipoPrenda.setBounds(109, 174, 86, 20);
		panAgregarPrendas.add(cbPrendaTipoPrenda);
		
		JLabel lblPrendaCarac1 = new JLabel("Caracteristica:");
		lblPrendaCarac1.setBounds(245, 177, 97, 14);
		panAgregarPrendas.add(lblPrendaCarac1);
		
			textPrendaCarac1 = new JTextField();
			textPrendaCarac1.setBounds(338, 174, 86, 20);
			panAgregarPrendas.add(textPrendaCarac1);
			textPrendaCarac1.setColumns(10);
			
			JComboBox cbPrendaCarac1 = new JComboBox();
			cbPrendaCarac1.setBounds(338, 174, 86, 20);
			panAgregarPrendas.add(cbPrendaCarac1);
			
		JLabel lblPrendaCarac2 = new JLabel("Caracteristica:");
		lblPrendaCarac2.setBounds(245, 208, 97, 14);
		panAgregarPrendas.add(lblPrendaCarac2);
		
		JComboBox cbPrendaCarac2 = new JComboBox();
		cbPrendaCarac2.setBounds(338, 205, 86, 20);
		panAgregarPrendas.add(cbPrendaCarac2);

		JButton btnPrendaGuardar = new JButton("Guardar");
		btnPrendaGuardar.setForeground(new Color(255, 255, 255));
		btnPrendaGuardar.setBackground(new Color(0, 0, 255));
		btnPrendaGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrendaGuardar.setBounds(338, 266, 102, 23);
		panAgregarPrendas.add(btnPrendaGuardar);
		
		JButton btnPrendaLimpiar = new JButton("Limpiar");
		btnPrendaLimpiar.setBounds(10, 266, 89, 23);
		panAgregarPrendas.add(btnPrendaLimpiar);
		
		lblPrendaCarac1.setVisible(false);
		textPrendaCarac1.setVisible(false);
		cbPrendaCarac1.setVisible(false);
		lblPrendaCarac2.setVisible(false);
		cbPrendaCarac2.setVisible(false);
				
		cbPrendaTipoPrenda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch(cbPrendaTipoPrenda.getSelectedIndex()) {
					case 1:
						lblPrendaCarac1.setVisible(true);
						lblPrendaCarac1.setText("Tipo de Suela:");
						textPrendaCarac1.setVisible(false);
						cbPrendaCarac1.setVisible(true);
						cbPrendaCarac1.setModel(new DefaultComboBoxModel(new String [] {"No definido","Poliuretano","Crepe","Suela","Cuero"}));
						lblPrendaCarac2.setVisible(false);
						cbPrendaCarac2.setVisible(false);
						break;
					case 2:
						lblPrendaCarac1.setVisible(true);
						lblPrendaCarac1.setText("Tiene Canguro:");
						textPrendaCarac1.setVisible(false);
						cbPrendaCarac1.setVisible(true);
						cbPrendaCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						lblPrendaCarac2.setVisible(true);
						lblPrendaCarac2.setText("Tipo de Manga:");
						cbPrendaCarac2.setVisible(true);
						cbPrendaCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						break;
					case 3:
						lblPrendaCarac1.setVisible(true);
						lblPrendaCarac1.setText("Estampado:");
						textPrendaCarac1.setVisible(true);
						cbPrendaCarac1.setVisible(false);
						lblPrendaCarac2.setVisible(true);
						lblPrendaCarac2.setText("Tipo de Manga:");
						cbPrendaCarac2.setVisible(true);
						cbPrendaCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						break;
					case 4:
						lblPrendaCarac1.setVisible(true);
						lblPrendaCarac1.setText("Es al Cuerpo:");
						textPrendaCarac1.setVisible(false);
						cbPrendaCarac1.setVisible(true);
						cbPrendaCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						lblPrendaCarac2.setVisible(false);
						cbPrendaCarac2.setVisible(false);
						break;
					case 5:
						lblPrendaCarac1.setVisible(true);
						lblPrendaCarac1.setText("Secado Rapido:");
						textPrendaCarac1.setVisible(false);
						cbPrendaCarac1.setVisible(true);
						cbPrendaCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						lblPrendaCarac2.setVisible(true);
						lblPrendaCarac2.setText("Dimensiones:");
						cbPrendaCarac2.setVisible(true);
						cbPrendaCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						break;
					default:
						lblPrendaCarac1.setVisible(false);
						textPrendaCarac1.setVisible(false);
						cbPrendaCarac1.setVisible(false);
						lblPrendaCarac2.setVisible(false);
						cbPrendaCarac2.setVisible(false);
						break;
				}
			}
		});
		
		btnPrendaLimpiar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				cbPrendaMarca.setSelectedIndex(0);
				textPrendaModelo.setText("");
				cbPrendaTipoMaterial.setSelectedIndex(0);
				textPrendaColor.setText("");
				textPrendaTalla.setText("");
				textPrendaStock.setValue(1);
				textPrendaPrecio.setValue(0);
				cbPrendaTipoPrenda.setSelectedIndex(0);
				textPrendaCarac1.setText("");
				cbPrendaCarac1.setSelectedIndex(-1);
				cbPrendaCarac2.setSelectedIndex(-1);
			}
		});
		
		btnPrendaGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cbPrendaMarca.getSelectedIndex() == 0 || textPrendaModelo.getText().isEmpty() || textPrendaColor.getText().isEmpty() ||
						cbPrendaTipoMaterial.getSelectedIndex() == 0 || textPrendaTalla.getText().isEmpty() || textPrendaStock.getText().isEmpty()
						|| textPrendaPrecio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Datos Insuficientes");
				}
				else {
					PrendaDeVestir prenda = null;
					switch(cbPrendaTipoPrenda.getSelectedIndex()) {
						case 1:
							prenda = new Calzado(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), cbPrendaCarac1.getSelectedIndex(), 
									Double.parseDouble(textPrendaPrecio.getText()));
							break;
						case 2:
							prenda = new Buzo(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()),
									convertirABoolean(cbPrendaCarac2.getSelectedIndex()), Double.parseDouble(textPrendaPrecio.getText()));	
							break;
						case 3:
							prenda = new Remera(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac2.getSelectedIndex()), textPrendaCarac1.getText(),
									Double.parseDouble(textPrendaPrecio.getText()));
							break;
						case 4:
							prenda = new Pantalon(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()), 
									Double.parseDouble(textPrendaPrecio.getText()));
							break;
						case 5:
							prenda = new Maya(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()),
									convertirABoolean(cbPrendaCarac2.getSelectedIndex()), Double.parseDouble(textPrendaPrecio.getText()));
							break;
					}
					prenda.agregarNuevoTalleConCantidad(textPrendaTalla.getText(), Integer.parseInt(textPrendaStock.getText()));
					tiendaDeRopa.agregarPrenda(prenda.getCodigo(), prenda);
					JOptionPane.showMessageDialog(null, "Prenda guardada con exito");
					
					cbPrendaMarca.setSelectedIndex(0);
					textPrendaModelo.setText("");
					cbPrendaTipoMaterial.setSelectedIndex(0);
					textPrendaColor.setText("");
					textPrendaTalla.setText("");
					textPrendaStock.setValue(1);
					textPrendaPrecio.setValue(0);
					cbPrendaTipoPrenda.setSelectedIndex(0);
					textPrendaCarac1.setText("");
					cbPrendaCarac1.setSelectedIndex(-1);
					cbPrendaCarac2.setSelectedIndex(-1);
					
					tablePrendas.setModel(cargarJTableConArrayList(tiendaDeRopa.devolverPrendas()));
					tablePrendas.getColumnModel().getColumn(3).setPreferredWidth(180);
					tablePrendas.setRowHeight(50);
					
					tablePrendaAjuste.setModel(cargarJTablePrendaAjuste(tiendaDeRopa.devolverPrendas()));
					tablePrendaAjuste.getColumnModel().getColumn(3).setPreferredWidth(180);
					tablePrendaAjuste.setRowHeight(50);
				}
			}
		});
		//--------//
	}
	
	public void metodoPanelAjuste(JPanel panPrendaAjusteStock) {
		//----PANEL AJUSTE STOCK----//
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 40, 430, 112);
		panPrendaAjusteStock.add(scrollPane_2);
		
		tablePrendaAjuste = new JTable();
		scrollPane_2.setViewportView(tablePrendaAjuste);
		tablePrendaAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePrendaAjuste.setModel(cargarJTablePrendaAjuste(tiendaDeRopa.devolverPrendas()));
		tablePrendaAjuste.getColumnModel().getColumn(3).setPreferredWidth(180);
		tablePrendaAjuste.setRowHeight(50);
		
		JLabel lblAjusteTalla = new JLabel("Talla:");
		lblAjusteTalla.setBounds(10, 275, 46, 14);
		panPrendaAjusteStock.add(lblAjusteTalla);
		
		textAjusteTalla = new JTextField();
		textAjusteTalla.setBounds(62, 272, 46, 20);
		panPrendaAjusteStock.add(textAjusteTalla);
		textAjusteTalla.setColumns(10);
		
		JLabel lblAjusteStock = new JLabel("Strock:");
		lblAjusteStock.setBounds(219, 275, 46, 14);
		panPrendaAjusteStock.add(lblAjusteStock);
		
		textAjusteStock = new JTextField();
		textAjusteStock.setBounds(275, 272, 46, 20);
		panPrendaAjusteStock.add(textAjusteStock);
		textAjusteStock.setColumns(10);
		
		JComboBox cbAjuste = new JComboBox();
		cbAjuste.setBounds(118, 272, 91, 20);
		cbAjuste.setModel(new DefaultComboBoxModel(new String [] {"Ingresar","Extraer"}));
		cbAjuste.setSelectedIndex(0);
		panPrendaAjusteStock.add(cbAjuste);
		
		JButton btnAjusteGuardar = new JButton("Guardar");
		btnAjusteGuardar.setForeground(new Color(255, 255, 255));
		btnAjusteGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjusteGuardar.setBackground(new Color(0, 0, 128));
		btnAjusteGuardar.setBounds(331, 271, 109, 23);
		panPrendaAjusteStock.add(btnAjusteGuardar);
		
		JLabel lblAjusteMarca = new JLabel("Marca:");
		lblAjusteMarca.setBounds(10, 158, 80, 14);
		panPrendaAjusteStock.add(lblAjusteMarca);
		
		JLabel lblAjusteModelo = new JLabel("Modelo:");
		lblAjusteModelo.setBounds(10, 183, 80, 14);
		panPrendaAjusteStock.add(lblAjusteModelo);
		
		JLabel lblAjusteTipoMaterial = new JLabel("Tipo de Material:");
		lblAjusteTipoMaterial.setBounds(10, 208, 80, 14);
		panPrendaAjusteStock.add(lblAjusteTipoMaterial);
		
		JLabel lblAjusteColor = new JLabel("Color:");
		lblAjusteColor.setBounds(10, 233, 80, 14);
		panPrendaAjusteStock.add(lblAjusteColor);
		
		JLabel lblAjusteTipoPrenda = new JLabel("Tipo de Prenda: ");
		lblAjusteTipoPrenda.setBounds(219, 158, 185, 14);
		panPrendaAjusteStock.add(lblAjusteTipoPrenda);
		
		JLabel lblAjusteCarac1 = new JLabel("Carac1");
		lblAjusteCarac1.setBounds(219, 183, 80, 14);
		panPrendaAjusteStock.add(lblAjusteCarac1);
		
		JLabel lblAjusteCarac2 = new JLabel("Carac2");
		lblAjusteCarac2.setBounds(219, 208, 80, 14);
		panPrendaAjusteStock.add(lblAjusteCarac2);
		
		JComboBox cbAjusteMarca = new JComboBox();
		cbAjusteMarca.setModel(new DefaultComboBoxModel(new String [] {"No definido","Zara","Nike","Gucci","Adidas","Lacoste","Chanel","Levi's"}));
		cbAjusteMarca.setBounds(118, 155, 80, 20);
		panPrendaAjusteStock.add(cbAjusteMarca);
		
		JComboBox cbAjusteTipoMaterial = new JComboBox();
		cbAjusteTipoMaterial.setModel(new DefaultComboBoxModel(new String [] {"No definido","Algodon","Terciopelo","Calico","Fieltro","Seda"}));
		cbAjusteTipoMaterial.setBounds(118, 205, 80, 20);
		panPrendaAjusteStock.add(cbAjusteTipoMaterial);
		
		textAjusteModelo = new JTextField();
		textAjusteModelo.setBounds(118, 180, 80, 20);
		panPrendaAjusteStock.add(textAjusteModelo);
		textAjusteModelo.setColumns(10);
		
		textAjusteColor = new JTextField();
		textAjusteColor.setBounds(118, 230, 80, 20);
		panPrendaAjusteStock.add(textAjusteColor);
		textAjusteColor.setColumns(10);

		textAjusteCarac1 = new JTextField();
		textAjusteCarac1.setBounds(309, 180, 86, 20);
		panPrendaAjusteStock.add(textAjusteCarac1);
		textAjusteCarac1.setColumns(10);
		
		JComboBox cbAjusteCarac1 = new JComboBox();
		cbAjusteCarac1.setBounds(309, 180, 86, 20);
		panPrendaAjusteStock.add(cbAjusteCarac1);
		
		JComboBox cbAjusteCarac2 = new JComboBox();
		cbAjusteCarac2.setBounds(309, 205, 86, 20);
		panPrendaAjusteStock.add(cbAjusteCarac2);
		
		JLabel lblAjustePrecio = new JLabel("Precio:");
		lblAjustePrecio.setBounds(219, 233, 46, 14);
		panPrendaAjusteStock.add(lblAjustePrecio);
		
		textAjustePrecio = new JTextField();
		textAjustePrecio.setBounds(309, 230, 86, 20);
		panPrendaAjusteStock.add(textAjustePrecio);
		textAjustePrecio.setColumns(10);
		
		tablePrendaAjuste.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        @Override
			public void valueChanged(ListSelectionEvent arg0) {
	        	
	        	if(tablePrendaAjuste.getSelectedRow() != -1) {
		        	PrendaDeVestir prendaCargada = null;
					String codigo = (String) tablePrendaAjuste.getValueAt(tablePrendaAjuste.getSelectedRow(), 4);
					try {
						prendaCargada = tiendaDeRopa.buscarPrenda(codigo);
					} catch (ErrorDeBusquedaExcepcion e) {
						e.printStackTrace();
					}
					cbAjusteMarca.setSelectedIndex(prendaCargada.getMarcaInt() > 7 ? 0 : prendaCargada.getMarcaInt());
					textAjusteModelo.setText(prendaCargada.getModelo());
					cbAjusteTipoMaterial.setSelectedIndex(prendaCargada.getTipoDeMaterialInt() > 5 ? 0 : prendaCargada.getTipoDeMaterialInt());
					textAjustePrecio.setText(String.valueOf(prendaCargada.getPrecio()));
					textAjusteColor.setText(prendaCargada.getColor());
					if(prendaCargada instanceof Calzado) {
						lblAjusteTipoPrenda.setText("Tipo de Prenda: Calzado");
						lblAjusteCarac1.setText("Tipo de Suela:");
						textAjusteCarac1.setVisible(false);
						cbAjusteCarac1.setVisible(true);
						cbAjusteCarac1.setModel(new DefaultComboBoxModel(new String [] {"No definido","Poliuretano","Crepe","Suela","Cuero"}));
						cbAjusteCarac1.setSelectedIndex(((Calzado) prendaCargada).getTipoDeSuelaInt());
						lblAjusteCarac2.setVisible(false);
						cbAjusteCarac2.setVisible(false);
					}
					if(prendaCargada instanceof Buzo) {
						lblAjusteTipoPrenda.setText("Tipo de Prenda: Buzo");
						lblAjusteCarac1.setText("Tiene Canguro:");
						textAjusteCarac1.setVisible(false);
						cbAjusteCarac1.setVisible(true);
						cbAjusteCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						cbAjusteCarac1.setSelectedIndex(((Buzo) prendaCargada).esTipoCanguro() ? 1 : 0);
						lblAjusteCarac2.setVisible(true);
						lblAjusteCarac2.setText("Tipo de Manga:");
						cbAjusteCarac2.setVisible(true);
						cbAjusteCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						cbAjusteCarac2.setSelectedIndex(((Buzo) prendaCargada).esMangaCorta() ? 1 : 0);
					}
					if(prendaCargada instanceof Remera) {
						lblAjusteTipoPrenda.setText("Tipo de Prenda: Remera");
						lblAjusteCarac1.setText("Estampado:");
						textAjusteCarac1.setVisible(true);
						cbAjusteCarac1.setVisible(false);
						textAjusteCarac1.setText(((Remera) prendaCargada).getTipoEstampado());
						lblAjusteCarac2.setVisible(true);
						lblAjusteCarac2.setText("Tipo de Manga:");
						cbAjusteCarac2.setVisible(true);
						cbAjusteCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						cbAjusteCarac2.setSelectedIndex(((Remera) prendaCargada).esMangaCorta() ? 1 : 0);
					}
					if(prendaCargada instanceof Pantalon) {
						lblAjusteTipoPrenda.setText("Tipo de Prenda: Pantalon");
						lblAjusteCarac1.setText("Es al Cuerpo:");
						textAjusteCarac1.setVisible(false);
						cbAjusteCarac1.setVisible(true);
						cbAjusteCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						cbAjusteCarac1.setSelectedIndex(((Pantalon) prendaCargada).isEsAlCuerpo() ? 1 : 0);
						lblAjusteCarac2.setVisible(false);
						cbAjusteCarac2.setVisible(false);
					}
					if(prendaCargada instanceof Maya) {
						lblAjusteTipoPrenda.setText("Tipo de Prenda: Maya");
						lblAjusteCarac1.setText("Secado Rapido:");
						textAjusteCarac1.setVisible(false);
						cbAjusteCarac1.setVisible(true);
						cbAjusteCarac1.setModel(new DefaultComboBoxModel(new String [] {"No","Si"}));
						cbAjusteCarac1.setSelectedIndex(((Maya) prendaCargada).isEsSecadoRapido() ? 1 : 0);
						lblAjusteCarac2.setVisible(true);
						lblAjusteCarac2.setText("Dimensiones:");
						cbAjusteCarac2.setVisible(true);
						cbAjusteCarac2.setModel(new DefaultComboBoxModel(new String [] {"Larga","Corta"}));
						cbAjusteCarac2.setSelectedIndex(((Maya) prendaCargada).isEsPorArribaRodillas() ? 1 : 0);
					}
	        	}	
			}
	    });
		
		btnAjusteGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tablePrendaAjuste.getSelectedRow() != -1) {
					PrendaDeVestir prendaCargada = null;
					boolean modificado = false;
					String codigo = (String) tablePrendaAjuste.getValueAt(tablePrendaAjuste.getSelectedRow(), 4);
					try {
						prendaCargada = tiendaDeRopa.buscarPrenda(codigo);
					} catch (ErrorDeBusquedaExcepcion ex) {
						ex.printStackTrace();
					}
					if(!textAjusteModelo.getText().isEmpty() && !textAjusteColor.getText().isEmpty() &&
							cbAjusteMarca.getSelectedIndex() != 0 && cbAjusteTipoMaterial.getSelectedIndex() != 0 &&
							!textAjustePrecio.getText().isEmpty()) {
						if(!textAjusteTalla.getText().isEmpty() && !textAjusteStock.getText().isEmpty()) {
							if(prendaCargada instanceof Calzado) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Calzado prendaMod = new Calzado();
									prendaMod = (Calzado)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setTipoDeSuela(cbAjusteCarac1.getSelectedIndex());
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									if(prendaMod.existeTalle(textAjusteTalla.getText())) {
										if(cbAjuste.getSelectedIndex() == 1) {
											prendaMod.quitarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
										}
										else prendaMod.agregarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									}
									else prendaMod.agregarNuevoTalleConCantidad(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Buzo) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Buzo prendaMod = new Buzo();
									prendaMod = (Buzo)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsTipoCanguro(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setEsMangaCorta(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									if(prendaMod.existeTalle(textAjusteTalla.getText())) {
										if(cbAjuste.getSelectedIndex() == 1) {
											prendaMod.quitarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
										}
										else prendaMod.agregarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									}
									else prendaMod.agregarNuevoTalleConCantidad(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Remera) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Remera prendaMod = new Remera();
									prendaMod = (Remera)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setTipoEstampado(textAjusteCarac1.getText());
									prendaMod.setEsMangaCorta(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									if(prendaMod.existeTalle(textAjusteTalla.getText())) {
										if(cbAjuste.getSelectedIndex() == 1) {
											prendaMod.quitarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
										}
										else prendaMod.agregarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									}
									else prendaMod.agregarNuevoTalleConCantidad(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
								
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Pantalon){
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Pantalon prendaMod = new Pantalon();
									prendaMod = (Pantalon)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsAlCuerpo(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									if(prendaMod.existeTalle(textAjusteTalla.getText())) {
										if(cbAjuste.getSelectedIndex() == 1) {
											prendaMod.quitarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
										}
										else prendaMod.agregarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									}
									else prendaMod.agregarNuevoTalleConCantidad(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
								
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Maya) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Maya prendaMod = new Maya();
									prendaMod = (Maya)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsSecadoRapido(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setEsPorArribaRodillas(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									if(prendaMod.existeTalle(textAjusteTalla.getText())) {
										if(cbAjuste.getSelectedIndex() == 1) {
											prendaMod.quitarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
										}
										else prendaMod.agregarCantidadATalle(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
									}
									else prendaMod.agregarNuevoTalleConCantidad(textAjusteTalla.getText(), Integer.parseInt(textAjusteStock.getText()));
								
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
						}
						else {
							if(prendaCargada instanceof Calzado) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Calzado prendaMod = new Calzado();
									prendaMod = (Calzado)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setTipoDeSuela(cbAjusteCarac1.getSelectedIndex());
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Buzo) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Buzo prendaMod = new Buzo();
									prendaMod = (Buzo)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsTipoCanguro(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setEsMangaCorta(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Remera) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Remera prendaMod = new Remera();
									prendaMod = (Remera)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setTipoEstampado(textAjusteCarac1.getText());
									prendaMod.setEsMangaCorta(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Pantalon){
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Pantalon prendaMod = new Pantalon();
									prendaMod = (Pantalon)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsAlCuerpo(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
							if(prendaCargada instanceof Maya) {
								if(JOptionPane.showConfirmDialog(null, "Confirmar Cambios?") == JOptionPane.YES_OPTION) {
									Maya prendaMod = new Maya();
									prendaMod = (Maya)prendaCargada;
									prendaMod.setMarca(cbAjusteMarca.getSelectedIndex());
									prendaMod.setModelo(textAjusteModelo.getText());
									prendaMod.setColor(textAjusteColor.getText());
									prendaMod.setTipoDeMaterial(cbAjusteTipoMaterial.getSelectedIndex());
									prendaMod.setEsSecadoRapido(convertirABoolean(cbAjusteCarac1.getSelectedIndex()));
									prendaMod.setEsPorArribaRodillas(convertirABoolean(cbAjusteCarac2.getSelectedIndex()));
									prendaMod.setPrecio(Double.parseDouble(textAjustePrecio.getText()));
									prendaMod.setCodigo(prendaCargada.getCodigo());
									
									tiendaDeRopa.modificarPrenda(prendaMod.getCodigo(), prendaMod);
									modificado = true;
								}
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No ha llenado todos los campos");
					}
					
					if(modificado) {
						tablePrendas.setModel(cargarJTableConArrayList(tiendaDeRopa.devolverPrendas()));
						tablePrendas.getColumnModel().getColumn(3).setPreferredWidth(180);
						tablePrendas.setRowHeight(50);
						
						tablePrendaAjuste.getSelectionModel().removeSelectionInterval(0, 4);
						tablePrendaAjuste.setModel(cargarJTablePrendaAjuste(tiendaDeRopa.devolverPrendas()));
						tablePrendaAjuste.getColumnModel().getColumn(3).setPreferredWidth(180);
						tablePrendaAjuste.setRowHeight(50);
					}
				}				
				else {
					JOptionPane.showMessageDialog(null, "Seleccione una Prenda de la Tabla");
				}
				
			}
		});
		//--------//
	}
	
	public void metodoPanelModificarDatosPersonales(JPanel panModificarDatosPer, JButton botonNombreEmpleado) {
		//----PANEL MODIFICAR DATOS PERSONALES----/
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
				boolean exito = false;
				if( !textVendedorNombre.getText().isEmpty() && !textVendedorApellido.getText().isEmpty()
						&& cbVendedorGenero.getSelectedIndex() != 0 && cbVendedorEstadoCiv.getSelectedIndex() != 0 
						&& !textVendedorNumTel.getText().isEmpty() && !textVendedorLegajo.getText().isEmpty()
						&& !textVendedorContrasenia.getText().isEmpty() ) {
					Empleado modificacion = new Vendedor(textVendedorNombre.getText(), textVendedorApellido.getText(),
							empleado.getDni(), cbVendedorGenero.getSelectedIndex(), empleado.getFechaNac(),
							cbVendedorEstadoCiv.getSelectedIndex(), textVendedorNumTel.getText(), textVendedorLegajo.getText(),
							textVendedorContrasenia.getText());
					if(empleado.getLegajo().equals(modificacion.getLegajo())) {
						if(JOptionPane.showConfirmDialog(null, "Confirmar cambios?") == JOptionPane.YES_OPTION) {
							tiendaDeRopa.modificarEmpleado(modificacion.getLegajo(), modificacion);
							JOptionPane.showMessageDialog(null, "Cambios guardados con exito");
							exito = true;
						}
					}
					else {
						try {
							tiendaDeRopa.buscarEmpleado(modificacion.getLegajo());
							JOptionPane.showMessageDialog(null, "El Legajo que ha indicado no esta disponible");
						} catch (ErrorDeBusquedaExcepcion e1) {
							try {
								if(JOptionPane.showConfirmDialog(null, "Confirmar cambios?") == JOptionPane.YES_OPTION) {
									tiendaDeRopa.agregarEmpleado(modificacion.getLegajo(), modificacion);
									tiendaDeRopa.bajaEmpleado(empleado.getLegajo());
									JOptionPane.showMessageDialog(null, "Cambios guardados con exito");
									tiendaDeRopa.modificarVendedorEnListaVentas(empleado.getLegajo(), modificacion.getLegajo());
									exito = true;
								}
							} catch (LimiteExedidoDeGerenteExcepcion e2) {
								e2.printStackTrace();
							}
						}
					}
					if(exito && modificacion instanceof Vendedor) {
											
						empleado.setNombre(modificacion.getNombre());
						empleado.setApellido(modificacion.getApellido());
						empleado.setGenero(modificacion.getGeneroInt());
						empleado.setEstadoCivil(modificacion.getEstadoCivilInt());
						((Vendedor) empleado).setTelefono(((Vendedor) modificacion).getTelefono());
						empleado.setLegajo(modificacion.getLegajo());
						empleado.setContraseña(modificacion.getContraseña());
						

						recargarDatosPersonales();
						botonNombreEmpleado.setText(empleado.getNombre()+" "+empleado.getApellido());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Complete todos los datos antes de guardar");
				}
			}
		});
		//--------//
	}
	
	public void metodoPanelVendedor () {
		//----PANEL VENDEDOR----/
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
		
		lbMostrarNombre = new JLabel();
		lbMostrarNombre.setBounds(90, 78, 75, 14);
		lbMostrarNombre.setText(empleado.getNombre());
		panVendedor.add(lbMostrarNombre);
		
		lbMostrarApellido = new JLabel();
		lbMostrarApellido.setBounds(90, 120, 75, 14);
		lbMostrarApellido.setText(empleado.getApellido());
		panVendedor.add(lbMostrarApellido);
		
		lbMostrarGenero = new JLabel();
		lbMostrarGenero.setBounds(90, 167, 75, 14);
		lbMostrarGenero.setText(empleado.getGenero());
		panVendedor.add(lbMostrarGenero);
			
		lbMostrarDni = new JLabel();
		lbMostrarDni.setBounds(90, 216, 75, 14);
		lbMostrarDni.setText(empleado.getDni());
		panVendedor.add(lbMostrarDni);
		
		lbMostrarFechaNac = new JLabel();
		lbMostrarFechaNac.setBounds(90, 262, 75, 14);
		lbMostrarFechaNac.setText(empleado.getFechaNac());
		panVendedor.add(lbMostrarFechaNac);
		
		lbMostrarEstadoCiv = new JLabel();
		lbMostrarEstadoCiv.setText(empleado.getEstadoCivil());
		lbMostrarEstadoCiv.setBounds(330, 78, 75, 14);
		panVendedor.add(lbMostrarEstadoCiv);
		
		lbMostrarLegajo = new JLabel();
		lbMostrarLegajo.setBounds(330, 120, 75, 14);
		lbMostrarLegajo.setText(empleado.getLegajo());
		panVendedor.add(lbMostrarLegajo);
		
		lbMostrarContrasenia = new JLabel();
		lbMostrarContrasenia.setBounds(330, 167, 75, 14);
		lbMostrarContrasenia.setText(empleado.getContraseña());
		panVendedor.add(lbMostrarContrasenia);
		
		lbMostrarNumTel = new JLabel();
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
	}
	
	public void recargarDatosPersonales() {
		
		lbMostrarNombre.setText(empleado.getNombre());
		
		lbMostrarApellido.setText(empleado.getApellido());
		
		lbMostrarGenero.setText(empleado.getGenero());
		
		lbMostrarDni.setText(empleado.getDni());
		
		lbMostrarFechaNac.setText(empleado.getFechaNac());
		
		lbMostrarEstadoCiv.setText(empleado.getEstadoCivil());
		
		lbMostrarLegajo.setText(empleado.getLegajo());
		
		lbMostrarContrasenia.setText(empleado.getContraseña());
		
		if(empleado instanceof Vendedor) {
			lbMostrarNumTel.setText(((Vendedor) empleado).getTelefono());
		}
	}
	
	public boolean convertirABoolean(int dato) {
		boolean rta = false;
		if(dato != 0) {
			rta = false;
		}
		return rta;
	}
	
	public void accionCargarTablaConBoton(JButton btn, JTable table, ArrayList carga) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(cargarJTableConArrayList(carga));
			}
		});
	}
	
	public DefaultTableModel cargarJTablePrendaAjuste(ArrayList<PrendaDeVestir> array) {
		DefaultTableModel modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		if(!array.isEmpty()) {
			modelo.addColumn("Modelo");
			modelo.addColumn("Marca");
			modelo.addColumn("Color");
			modelo.addColumn("Talla/Stock");
			modelo.addColumn("Codigo");
			
			for(PrendaDeVestir e : array){
				modelo.addRow(new String[] {e.getModelo(),e.getMarca(),e.getColor(),e.listarStock(),e.getCodigo()});
			}
			return modelo;
		}
		else modelo.addColumn("No Existen Elementos en esta tabla"); return modelo;
	}
	
	public DefaultTableModel cargarJTableConArrayList(ArrayList array) {
		DefaultTableModel modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		if(!array.isEmpty()) {
			Object aux = array.get(0);
			if(aux instanceof PrendaDeVestir) {
				modelo.addColumn("Modelo");
				modelo.addColumn("Marca");
				modelo.addColumn("Color");
				modelo.addColumn("Talla/Stock");
				modelo.addColumn("Codigo");
			}
			if(aux instanceof Cliente) {
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("DNI");
				modelo.addColumn("Genero");
				modelo.addColumn("Fecha de Nacimiento");
			}
			if(aux instanceof Empleado) {
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("Legajo");
				modelo.addColumn("Estado Civil");
			}
			if(aux instanceof Venta) {
				modelo.addColumn("Cliente");
				modelo.addColumn("Vendedor");
				modelo.addColumn("Fecha");
				modelo.addColumn("Monto");
			}
			for(Object elem : array){
				if(elem instanceof PrendaDeVestir) {
					PrendaDeVestir e = (PrendaDeVestir) elem;
			        modelo.addRow(new Object[] {e.getModelo(),e.getMarca(),e.getColor(), e.listarStock(),e.getCodigo()});
				} if(elem instanceof Cliente) {
					Cliente e = (Cliente) elem;
			        modelo.addRow(new Object[] {e.getNombre(),e.getApellido(),e.getDni(),e.getGenero(),e.getFechaNac()});
				} if(elem instanceof Empleado) {
					Empleado e = (Empleado) elem;
			        modelo.addRow(new Object[] {e.getNombre(),e.getApellido(),e.getLegajo(),e.getEstadoCivil()});
				} if(elem instanceof Venta) {
					Venta e = (Venta) elem;
			        modelo.addRow(new Object[] {e.getCliente().getNombre()+"-"+e.getCliente().getDni(),e.getVendedor().getNombre()+"-"+e.getVendedor().getLegajo(),
			        		e.getFecha(),e.getMonto()});
				}
			}
			return modelo;
		}
		else modelo.addColumn("No Existen Elementos en esta tabla"); return modelo;
	}
	
	public void accionBotonPaneles(JButton boton, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
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
