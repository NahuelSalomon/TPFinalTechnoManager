package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaOpcionesGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesGerente frame = new VentanaOpcionesGerente();
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
	public VentanaOpcionesGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 456);
		setUndecorated(true);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cerrar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(10, 14, 130, 23);
		contentPane.add(btnNewButton);
		
		JButton botonBuscarEmpleado = new JButton("Buscar empleado\r\n");
		botonBuscarEmpleado.setForeground(Color.WHITE);
		botonBuscarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarEmpleado.setBackground(new Color(0, 0, 128));
		botonBuscarEmpleado.setBounds(243, 325, 197, 23);
		contentPane.add(botonBuscarEmpleado);
		
		JButton botonModificarEmpleado = new JButton("Modificar empleado\r\n");
		botonModificarEmpleado.setForeground(Color.WHITE);
		botonModificarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonModificarEmpleado.setBackground(new Color(0, 0, 128));
		botonModificarEmpleado.setBounds(243, 291, 197, 23);
		contentPane.add(botonModificarEmpleado);
		
		JButton botonListarEmpleados = new JButton("Listar empleados\r\n");
		botonListarEmpleados.setForeground(Color.WHITE);
		botonListarEmpleados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonListarEmpleados.setBackground(new Color(0, 0, 128));
		botonListarEmpleados.setBounds(243, 257, 197, 23);
		contentPane.add(botonListarEmpleados);
		
		JButton botonBorrarEmpleado = new JButton("Borrar empleado\r\n");
		botonBorrarEmpleado.setForeground(Color.WHITE);
		botonBorrarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarEmpleado.setBackground(new Color(0, 0, 128));
		botonBorrarEmpleado.setBounds(243, 223, 197, 23);
		contentPane.add(botonBorrarEmpleado);
		
		JButton botonAgregarEmpleado = new JButton("Agregar empleado\r\n");
		botonAgregarEmpleado.setBackground(new Color(0, 0, 128));
		botonAgregarEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonAgregarEmpleado.setForeground(new Color(255, 255, 255));
		botonAgregarEmpleado.setBounds(243, 189, 197, 23);
		contentPane.add(botonAgregarEmpleado);
		
		JButton botonBuscarVenta = new JButton("Buscar una venta");
		botonBuscarVenta.setBackground(new Color(0, 0, 128));
		botonBuscarVenta.setForeground(new Color(255, 255, 255));
		botonBuscarVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBuscarVenta.setBounds(22, 255, 197, 23);
		contentPane.add(botonBuscarVenta);
		
		JButton botonBorrarUnaVenta = new JButton("Borrar una venta");
		botonBorrarUnaVenta.setBackground(new Color(0, 0, 128));
		botonBorrarUnaVenta.setForeground(new Color(255, 255, 255));
		botonBorrarUnaVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonBorrarUnaVenta.setBounds(22, 221, 197, 23);
		contentPane.add(botonBorrarUnaVenta);
		
		JButton botonRegistroVentas = new JButton("Ver ventas");
		botonRegistroVentas.setBackground(new Color(0, 0, 128));
		botonRegistroVentas.setForeground(Color.WHITE);
		botonRegistroVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonRegistroVentas.setBounds(22, 187, 197, 23);
		contentPane.add(botonRegistroVentas);
		
		JLabel lblOpcionesPrendas = new JLabel("Opciones prendas\r\n");
		lblOpcionesPrendas.setForeground(Color.WHITE);
		lblOpcionesPrendas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblOpcionesPrendas.setBounds(470, 156, 150, 20);
		contentPane.add(lblOpcionesPrendas);
		
		JLabel lblOpcionesEmpleados = new JLabel("Opciones empleados");
		lblOpcionesEmpleados.setForeground(Color.WHITE);
		lblOpcionesEmpleados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblOpcionesEmpleados.setBounds(244, 156, 150, 20);
		contentPane.add(lblOpcionesEmpleados);
		
		JLabel lblOpcionesVentas = new JLabel("Opciones ventas");
		lblOpcionesVentas.setForeground(Color.WHITE);
		lblOpcionesVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblOpcionesVentas.setBounds(22, 156, 117, 20);
		contentPane.add(lblOpcionesVentas);
		
		JLabel labelMercaderias = new JLabel("");
		labelMercaderias.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelMercaderias.setBounds(458, 140, 214, 216);
		contentPane.add(labelMercaderias);
		
		JLabel labelEmpleados = new JLabel("");
		labelEmpleados.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelEmpleados.setBounds(234, 140, 214, 216);
		contentPane.add(labelEmpleados);
		
		JLabel labelVentas = new JLabel("");
		labelVentas.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/imagePanel.jpg")));
		labelVentas.setBounds(10, 140, 214, 216);
		contentPane.add(labelVentas);
		
		JLabel labelOpciones = new JLabel("Menu de opciones");
		labelOpciones.setBackground(Color.BLACK);
		labelOpciones.setForeground(Color.WHITE);
		labelOpciones.setFont(new Font("Segoe UI", Font.BOLD, 32));
		labelOpciones.setBounds(74, 48, 301, 48);
		contentPane.add(labelOpciones);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBounds(0, -11, 683, 438);
		labelFondo.setIcon(new ImageIcon(VentanaOpcionesGerente.class.getResource("/Imagenes/WALLPAPERgEERENTE.jpg")));
		contentPane.add(labelFondo);
	}
}
