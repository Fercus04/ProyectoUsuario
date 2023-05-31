package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConVentana{

	public static void main(String[] args) {
		new VentanaRegistro();

	}

}

class VentanaRegistro extends JFrame {

	private JTextField txtNombre;
	private JPasswordField txtContrasena;
	private JTextField txtEmail;
	private JTextField txtSitioWeb;
	public LocalDate FchDefault = LocalDate.now();
	public JTextField txtFechaNacimiento = new JTextField(FchDefault + "", 20);
	public String ErrorPass = "";
	public String ErrorMail = "";
	public String ErrorWeb = "";
	public String ErrorFecha = "";
	public JLabel lblError = new JLabel("");
	public Usuario[] usuarios = new Usuario[150];
	JButton btnRegistrar = new JButton("Registrar");

	public VentanaRegistro() {
		setTitle("Formulario de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridBagLayout());

		JLabel lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField(20);

		JLabel lblContrasena = new JLabel("Contraseña:");
		txtContrasena = new JPasswordField(20);

		JLabel lblEmail = new JLabel("Email:");
		txtEmail = new JTextField(20);

		JLabel lblSitioWeb = new JLabel("Sitio web:");
		txtSitioWeb = new JTextField(20);

		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		txtFechaNacimiento = new JTextField(20);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);

		panelPrincipal.add(lblNombre, gbc);
		gbc.gridx++;
		panelPrincipal.add(txtNombre, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		panelPrincipal.add(lblContrasena, gbc);
		gbc.gridx++;
		panelPrincipal.add(txtContrasena, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		panelPrincipal.add(lblEmail, gbc);
		gbc.gridx++;
		panelPrincipal.add(txtEmail, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		panelPrincipal.add(lblSitioWeb, gbc);
		gbc.gridx++;
		panelPrincipal.add(txtSitioWeb, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		panelPrincipal.add(lblFechaNacimiento, gbc);
		gbc.gridx++;
		panelPrincipal.add(txtFechaNacimiento, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(15, 5, 5, 5);
		panelPrincipal.add(btnRegistrar, gbc);

		btnRegistrar.addActionListener(new Comprobar());

		getContentPane().add(panelPrincipal);
		
		setVisible(true);
	}

	class Comprobar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String user = txtNombre.getText();
			String pass = new String(txtContrasena.getPassword());
			String mail = txtEmail.getText();
			String url = txtSitioWeb.getText();
			String fechaString = txtFechaNacimiento.getText();
			LocalDate fechaDate;
			try {
				fechaDate = LocalDate.parse(fechaString);
			} catch (DateTimeParseException ex) {
				ErrorFecha = "Error fecha con formato incorrecto";
				JOptionPane.showMessageDialog(btnRegistrar, "ERROR, fecha con formato invalido");
				txtFechaNacimiento.requestFocus();
				txtFechaNacimiento.setText(FchDefault + "");
				return;
			}
			
			lblError.setText("");
			if (!Validador.validarEmail(mail)) {
				txtEmail.setText("");
				txtEmail.requestFocus();
				ErrorMail = "Mail incorrecto";
				return;
			}
			if (!Validador.validarWeb(url)) {
				txtSitioWeb.setText("");
				txtSitioWeb.requestFocus();
				ErrorWeb = "Web invalida";
				return;
			}
			if (!Validador.validarNacemento(fechaDate)) {
				txtFechaNacimiento.setText("");
				txtFechaNacimiento.requestFocus();
				return;
			}
			
			if (!Validador.validarContrasinal(pass)) {
				txtContrasena.setText("");
				txtContrasena.requestFocus();
				lblError.setText("Min 8 caracteres, 1 numero y 1 caracter especial.");
				JOptionPane.showMessageDialog(btnRegistrar,"Contraseña incorrecta: Min 8 caracteres, 1 numero y 1 caracter especial.");
				ErrorPass = "Contraseña incorrecta";
				return;
			}
			
			int indice = 0;

			usuarios[indice++] = new Usuario(user, pass, mail, url, fechaString);
			JOptionPane.showMessageDialog(btnRegistrar, "Usuario creado correctamente y añadido");
			
			System.out.println("Nombre: " + user);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<pass.length();i++) {
				sb.append("*");
			}
			System.out.println("Contraseña: " + sb.toString());
			System.out.println("Email: " + mail);
			System.out.println("URL: " + url);
			System.out.println("Fecha de nacimiento : " + fechaString);
			
			
			
		}
	}
}
