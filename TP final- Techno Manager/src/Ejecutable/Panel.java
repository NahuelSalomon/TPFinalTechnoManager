package Ejecutable;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClasesPersona.Cliente;
import ClasesPersona.ClienteMayorista;
import Listas.ListaDeClientes;
import OtrasListas.OtraListaClientes;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;
	private JTextField txtContenedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public Panel() throws FileNotFoundException, ClassNotFoundException, IOException {
		VentanaInicio();
	}
	
	
	public void VentanaInicio(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
				
		txtUsuario = new JTextField();
		txtUsuario.setBounds(144, 105, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(144, 175, 86, 20);
		contentPane.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		JLabel lblInicioSesion = new JLabel("New label");
		lblInicioSesion.setBounds(164, 136, 46, 14);
		contentPane.add(lblInicioSesion);
		lblInicioSesion.setVisible(false);
		
		txtContenedor = new JTextField();
		txtContenedor.setBounds(10, 105, 86, 90);
		contentPane.add(txtContenedor);
		txtContenedor.setColumns(10);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(10, 7, 109, 23);
		contentPane.add(rdbtnCliente);
		rdbtnCliente.setSelected(true);
		
		JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
		rdbtnVendedor.setBounds(10, 33, 109, 23);
		contentPane.add(rdbtnVendedor);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(10, 60, 109, 23);
		contentPane.add(rdbtnGerente);
		
		rdbtnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnVendedor.setSelected(false);
				rdbtnGerente.setSelected(false);
			}
		});
		rdbtnVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnCliente.setSelected(false);
				rdbtnGerente.setSelected(false);
			}
		});
		rdbtnGerente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnCliente.setSelected(false);
				rdbtnVendedor.setSelected(false);
			}
		});
		
		JTextPane txtOtroContenedor = new JTextPane();
		txtOtroContenedor.setBounds(257, 105, 117, 90);
		contentPane.add(txtOtroContenedor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(257, 6, 117, 77);
		contentPane.add(textArea);
		
		JButton btnInicSesion = new JButton("Ingresar");
		btnInicSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OtraListaClientes listaC = new OtraListaClientes();
				try {
					listaC.abrir();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtContenedor.setText(listaC.listarElementos());
				txtOtroContenedor.setText(listaC.listarElementos());
				textArea.setText(listaC.listarElementos());
				
				Cliente nuevoCliente = new ClienteMayorista(txtUsuario.getText(), txtContrasenia.getText(), "3435235235",2);
				if(listaC.comparaNomApe(nuevoCliente)) {
					System.out.println("sesion iniciada");
					contentPane.setVisible(false);
					MenuCliente();
				}
				else System.out.println("no inicio sesion");
			}
		});
		btnInicSesion.setBounds(144, 222, 89, 23);
		contentPane.add(btnInicSesion);
	}
	
	public void MenuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnBoton = new JButton("Boton");
		contentPane.add(btnBoton, BorderLayout.CENTER);
		
	}
	
}
