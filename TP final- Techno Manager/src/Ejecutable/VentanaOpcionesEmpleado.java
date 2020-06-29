package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

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
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class VentanaOpcionesEmpleado extends JFrame {

	private JPanel contentPane;
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
		
		JPanel panVerMisVentas = new JPanel();
		lpanGeneral.add(panVerMisVentas, "name_99930226415368");
		panVerMisVentas.setVisible(false);
		
		//----PANEL REGISTRAR VENTA----//
		JPanel panRegistrarVenta = new JPanel();
		lpanGeneral.add(panRegistrarVenta, "name_99930197253561");
		panRegistrarVenta.setVisible(false);		
		panRegistrarVenta.setLayout(null);
		
		JComboBox cbCliente = new JComboBox();
		ArrayList<Cliente> clientes = tiendaDeRopa.devolverClientes();
		for(Cliente elem : clientes) {
			cbCliente.addItem(elem.getNombre());
		}
		//JOptionPane.showMessageDialog(null, clientesCadena);
		cbCliente.setBounds(20, 4, 148, 20);
		panRegistrarVenta.add(cbCliente);
		Date fechaActual = new Date();
		
		JLabel lblFecha = new JLabel(fechaActual.toString());
		lblFecha.setBounds(275, 7, 154, 14);
		panRegistrarVenta.add(lblFecha);
		
		JButton btnFinalizarVenta = new JButton("Finalizar");
		btnFinalizarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizarVenta.setForeground(new Color(255, 255, 255));
		btnFinalizarVenta.setBackground(new Color(0, 0, 128));
		btnFinalizarVenta.setBounds(342, 263, 87, 25);
		panRegistrarVenta.add(btnFinalizarVenta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 32, 409, 97);
		panRegistrarVenta.add(scrollPane);
		
		JTable tablePrendas = new JTable();
		scrollPane.setViewportView(tablePrendas);
		tablePrendas.setModel(cargarJListConArrayList(tiendaDeRopa.devolverPrendas()));
		
		textCantidad = new JFormattedTextField();
		textCantidad.setBounds(232, 137, 30, 20);
		textCantidad.setValue(new Integer(1));
		panRegistrarVenta.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lbIndiqueCantidad = new JLabel("Indique Cantidad:");
		lbIndiqueCantidad.setBounds(139, 137, 98, 20);
		panRegistrarVenta.add(lbIndiqueCantidad);
		
		JButton btnAgregarAlCarro = new JButton("Agregar al Carro");
		btnAgregarAlCarro.setBounds(275, 136, 154, 23);
		panRegistrarVenta.add(btnAgregarAlCarro);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 173, 409, 79);
		panRegistrarVenta.add(scrollPane_1);
		
		JTable tableCarro = new JTable();
		scrollPane_1.setViewportView(tableCarro);
		DefaultTableModel modeloTableCarro = new DefaultTableModel(new Object[] {"Modelo","Marca","Talla","Cantidad"}, 0);
		tableCarro.setModel(modeloTableCarro);
		
		JButton btnEliminarDelCarro = new JButton("Eliminar del Carro");
		btnEliminarDelCarro.setBounds(178, 266, 154, 23);
		panRegistrarVenta.add(btnEliminarDelCarro);
		
		JLabel lblSubTotal = new JLabel("Sub-Total:");
		lblSubTotal.setBounds(30, 267, 70, 23);
		panRegistrarVenta.add(lblSubTotal);
		
		JLabel lblValorSubTotal = new JLabel("0");
		lblValorSubTotal.setBounds(103, 271, 46, 14);
		panRegistrarVenta.add(lblValorSubTotal);
		
		JLabel lblIndiqueTalla = new JLabel("Indique Talla:");
		lblIndiqueTalla.setBounds(20, 140, 80, 14);
		panRegistrarVenta.add(lblIndiqueTalla);
		
		textTalla = new JTextField();
		textTalla.setBounds(89, 137, 30, 20);
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
				if(filaSeleccionada == -1) {
					//throw new ExcepcionMensajeError("No selecciono una prenda");
					JOptionPane.showMessageDialog(null, "No solecciono una prenda");
				}
				else {
					prenda = tiendaDeRopa.buscarPrenda((String)tablePrendas.getValueAt(filaSeleccionada, 4));
					if(cant < 1) {
						//throw new ExcepcionMensajeError("Cantidad indicada no valida");
						JOptionPane.showMessageDialog(null, "Cantidad indicada no valida");
					}
					else if(!prenda.existeTalle(textTalla.getText())) {
						//throw new ExcepcionMensajeError("Talla indicada no valida");
						JOptionPane.showMessageDialog(null, "Talla indicada no valida");
					}
//					else if(prenda.getCantidadSegTalla(talle) < cant){
//						throw new ExcepcionMensajeError("Cantidad indicada no excede el stock disponible");
//						JOptionPane.showMessageDialog(null, "Cantidad indicada no excede el stock disponible");
//					}
					else {
						//JOptionPane.showMessageDialog(null, "Todo correcto");
						modeloTableCarro.addRow(new Object[] {prenda.getModelo(),prenda.getMarca(),textTalla.getText(),cant});
						tableCarro.setModel(modeloTableCarro);
					}
				}
			}
		});
		//--------//
		
		//----PANEL AGREGAR PRENDA----//
		JPanel panAgregarPrendas = new JPanel();
		lpanGeneral.add(panAgregarPrendas, "name_99930253616870");
		panAgregarPrendas.setVisible(false);
		
		panAgregarPrendas.setLayout(null);
		
		JLabel lblPrendaCaracteristicasGenerales = new JLabel("Caracteristicas Generales");
		lblPrendaCaracteristicasGenerales.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrendaCaracteristicasGenerales.setBounds(10, 11, 185, 20);
		panAgregarPrendas.add(lblPrendaCaracteristicasGenerales);
		
		JLabel lblPrendaMarca = new JLabel("Marca:");
		lblPrendaMarca.setBounds(10, 42, 46, 14);
		panAgregarPrendas.add(lblPrendaMarca);
		
//		- 1. Zara
//		- 2. Nike
//		- 3. Gucci
//		- 4. Adidas
//		- 5. Lacoste
//		- 6. Chanel
//		- 7. Levi’s
		
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
		textPrendaPrecio.setValue(new Integer(0));
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
		
		JButton btnPrendaAjustarStock = new JButton("Ajustar Stock");
		btnPrendaAjustarStock.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrendaAjustarStock.setForeground(new Color(255, 255, 255));
		btnPrendaAjustarStock.setBackground(new Color(0, 0, 255));
		btnPrendaAjustarStock.setBounds(224, 266, 104, 23);
		panAgregarPrendas.add(btnPrendaAjustarStock);
		
		JButton btnPrendaBorrar = new JButton("Borrar");
		btnPrendaBorrar.setBounds(10, 266, 89, 23);
		panAgregarPrendas.add(btnPrendaBorrar);
		
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
		
		btnPrendaGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cbPrendaTipoPrenda.getSelectedIndex() == 0) {
					//throw new ExcepcionDatosInsuficientes();
					JOptionPane.showMessageDialog(null, "Datos Insuficientes");
				}
				else {
					PrendaDeVestir prenda = null;
					switch(cbPrendaTipoPrenda.getSelectedIndex()) {
						case 1:
							prenda = new Calzado(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), cbPrendaCarac1.getSelectedIndex());
							break;
						case 2:
							prenda = new Buzo(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()),
									convertirABoolean(cbPrendaCarac2.getSelectedIndex()));	
							break;
						case 3:
							prenda = new Remera(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac2.getSelectedIndex()), textPrendaCarac1.getText());
							break;
						case 4:
							prenda = new Pantalon(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()));
							break;
						case 5:
							prenda = new Maya(cbPrendaMarca.getSelectedIndex(), textPrendaModelo.getText(), textPrendaColor.getText(),
									cbPrendaTipoMaterial.getSelectedIndex(), convertirABoolean(cbPrendaCarac1.getSelectedIndex()),
									convertirABoolean(cbPrendaCarac2.getSelectedIndex()));
							break;
					}
					prenda.agregarNuevoTalleConCantidad(textPrendaTalla.getText(), Integer.parseInt(textPrendaStock.getText()));
					tiendaDeRopa.agregarPrenda(prenda.getCodigo(), prenda);
					tablePrendas.setModel(cargarJListConArrayList(tiendaDeRopa.devolverPrendas()));
				}
			}
		});
		//--------//
		
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
		//--------//
		
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
		
		accionBotonPaneles(botonRegistrarVenta, panRegistrarVenta, panAgregarPrendas, panVendedor, panVerMisVentas, panVerMisVentas);
		accionBotonPaneles(botonVerVentas, panVerMisVentas, panAgregarPrendas, panVendedor, panRegistrarVenta, panModificarDatosPer);
		accionBotonPaneles(botonModificarDatosPersonales, panModificarDatosPer, panAgregarPrendas, panVendedor, panRegistrarVenta, panRegistrarVenta);
		accionBotonPaneles(botonAgregarPrendaDeVestir, panAgregarPrendas, panVerMisVentas, panVendedor, panRegistrarVenta, panModificarDatosPer);
		accionBotonPaneles(botonNombreEmpleado, panVendedor, panAgregarPrendas, panVerMisVentas, panRegistrarVenta, panModificarDatosPer);
		
	}
	
	public boolean convertirABoolean(int dato) {
		boolean rta = false;
		if(dato != 0) {
			rta = false;
		}
		return rta;
	}
	
	public DefaultTableModel cargarJListConArrayList(ArrayList array) {
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
				modelo.addColumn("Tipo de Material");
				modelo.addColumn("Color");
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
			        modelo.addRow(new Object[] {e.getModelo(),e.getMarca(),e.getTipoDeMaterial(),e.getColor(),e.getCodigo()});
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
