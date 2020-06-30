package Ejecutable;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClasesPersona.Empleado;
import ClasesPersona.Vendedor;
import Excepciones.ErrorDeBusquedaExcepcion;
import Listas.ListaDeEmpleados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JRadioButton;

public class VentanaDeEntrada extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField campoTextoUsuario;
	private JPasswordField camposTextoContra;

	/**
	 * Launch the application.
	 */
	public static String tipoDeEmpleado = " ";
	
	/**
	 * Create the frame.
	 */
	public VentanaDeEntrada(TiendaDeRopa tiendaDeRopa) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setBounds(500, 500, 420, 500);
		JButton botonSalir = new JButton("Salir");
		
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			tiendaDeRopa.guardarTiendaDeRopa();
			System.exit(0);
			}
		});
				
		JRadioButton radioButtonGerente = new JRadioButton("gerente");
		radioButtonGerente.setForeground(Color.WHITE);
		radioButtonGerente.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonGerente.setBackground(new Color(0, 0, 128));
		radioButtonGerente.setBounds(301, 426, 93, 23);
		contentPane.add(radioButtonGerente);
		
		JRadioButton radioButtonVendedor = new JRadioButton("vendedor");
		radioButtonVendedor.setForeground(new Color(255, 255, 255));
		radioButtonVendedor.setBackground(new Color(0, 0, 128));
		radioButtonVendedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonVendedor.setBounds(194, 426, 93, 23);
		contentPane.add(radioButtonVendedor);
		
		radioButtonVendedor.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				radioButtonGerente.setSelected(false);
				tipoDeEmpleado = radioButtonVendedor.getText();
			}
		});
		
		radioButtonGerente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				radioButtonVendedor.setSelected(false);
				tipoDeEmpleado = radioButtonGerente.getText();
			}
		});
		
		JLabel jLabelTipoDeEmpleado = new JLabel("Tipo de empleado\r\n");
		jLabelTipoDeEmpleado.setForeground(Color.WHITE);
		jLabelTipoDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelTipoDeEmpleado.setBounds(59, 426, 131, 23);
		contentPane.add(jLabelTipoDeEmpleado);
		
		JButton botonAltaEmpleado = new JButton("Dar de alta empleado");
		
		
		
		
		botonAltaEmpleado.setBackground(new Color(0, 0, 128));
		botonAltaEmpleado.setForeground(new Color(255, 255, 255));
		botonAltaEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonAltaEmpleado.setBounds(10, 11, 185, 23);
		contentPane.add(botonAltaEmpleado);
		
		JButton botonIncioSesion = new JButton("Iniciar sesi\u00F3n");
		
		botonIncioSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			try {
				if(tiendaDeRopa.verificarEmpleado(campoTextoUsuario.getText(), camposTextoContra.getText(),tipoDeEmpleado))
					{
						dispose();
						if(tipoDeEmpleado.equals("vendedor")) {
							try {
								VentanaOpcionesEmpleado ventanaOpEmpleado = new VentanaOpcionesEmpleado(tiendaDeRopa.buscarEmpleado(campoTextoUsuario.getText()), tiendaDeRopa);
								ventanaOpEmpleado.setVisible(true);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						
						}
						else {
							if(tipoDeEmpleado.equals("gerente")) {
								VentanaOpcionesGerente ventanaOpcionesGerente = new VentanaOpcionesGerente(tiendaDeRopa);
								ventanaOpcionesGerente.setVisible(true);
							}
						}
					
					}	
				}		
				catch (ErrorDeBusquedaExcepcion e) {
					JOptionPane.showMessageDialog(null, "Datos ingresados incorrectos");
				}
			}			
		});
		
		
		botonAltaEmpleado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				VentanaAltaEmpleado ventanaAltaEmpleado = new VentanaAltaEmpleado(tiendaDeRopa);
				ventanaAltaEmpleado.setVisible(true);		
			}
		});
		
		
		botonIncioSesion.setBackground(new Color(0, 0, 128));
		botonIncioSesion.setForeground(Color.WHITE);
		botonIncioSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonIncioSesion.setBounds(156, 466, 131, 23);
		contentPane.add(botonIncioSesion);
		
		camposTextoContra = new JPasswordField();
		camposTextoContra.setFont(new Font("Tahoma", Font.BOLD, 14));
		camposTextoContra.setForeground(new Color(255, 255, 255));
		camposTextoContra.setBackground(new Color(0, 0, 128));
		camposTextoContra.setBounds(156, 394, 170, 20);
		contentPane.add(camposTextoContra);
		
		campoTextoUsuario = new JTextField();
		campoTextoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		campoTextoUsuario.setForeground(new Color(255, 255, 255));
		campoTextoUsuario.setBackground(new Color(0, 0, 128));
		campoTextoUsuario.setBounds(156, 360, 170, 20);
		contentPane.add(campoTextoUsuario);
		campoTextoUsuario.setColumns(10);
		
		JLabel jLabelLegajo = new JLabel("Legajo");
		jLabelLegajo.setForeground(new Color(255, 255, 255));
		jLabelLegajo.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelLegajo.setBounds(59, 357, 87, 23);
		contentPane.add(jLabelLegajo);
		
		JLabel jLabelContraseña = new JLabel("Contrase\u00F1a");
		jLabelContraseña.setForeground(new Color(255, 255, 255));
		jLabelContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabelContraseña.setBounds(59, 391, 87, 23);
		contentPane.add(jLabelContraseña);
		
		JLabel jLabelIcono = new JLabel("");
		jLabelIcono.setIcon(new ImageIcon(VentanaDeEntrada.class.getResource("/Imagenes/Fondito.png")));
		jLabelIcono.setBounds(69, 45, 256, 294);
		contentPane.add(jLabelIcono);
		
		
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonSalir.setBackground(new Color(0, 0, 128));
		botonSalir.setBounds(336, 11, 79, 23);
		contentPane.add(botonSalir);
		
		JLabel jLabelFondo = new JLabel("");
		jLabelFondo.setBackground(new Color(0, 0, 128));
		jLabelFondo.setForeground(new Color(255, 255, 255));
		jLabelFondo.setBounds(0, 0, 420, 500);
		jLabelFondo.setIcon(new ImageIcon(VentanaDeEntrada.class.getResource("/Imagenes/wallPaper blue.jpg")));
		contentPane.add(jLabelFondo);
	}
}
