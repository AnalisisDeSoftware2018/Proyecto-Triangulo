package interfaz;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Triangulo;

public class TrianguloInterfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfLadoUno;
	private JTextField txfLadoDos;
	private JTextField txfLadoTres;
	private JTextField txfResultado;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private Triangulo triangulo;
	private double ladoUno;
	private double ladoDos;
	private double ladoTres;
	private KeyListener calcularListener;

	public TrianguloInterfaz() {
		setTitle("Triángulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setComponentes();
		setListeners();
		setResizable(Boolean.FALSE);

	}

	private void setListeners() {
		setCalcularKeyListener();
		btnCalcular.addActionListener(e -> calcularTriangulo());
		txfLadoUno.addKeyListener(calcularListener);
		txfLadoDos.addKeyListener(calcularListener);
		txfLadoTres.addKeyListener(calcularListener);
		btnLimpiar.addActionListener(e -> clean());
	}

	private void clean() {
		txfLadoUno.setText("");
		txfLadoDos.setText("");
		txfLadoTres.setText("");
		txfResultado.setText("");
	}

	private void calcularTriangulo() {
		try {
			if (camposCompletos()) {
				ladoUno = Double.parseDouble(txfLadoUno.getText().replace(",", "."));
				ladoDos = Double.parseDouble(txfLadoDos.getText().replace(",", "."));
				ladoTres = Double.parseDouble(txfLadoTres.getText().replace(",", "."));
				if (ladoUno > 0 && ladoDos > 0 && ladoTres > 0) {
					triangulo = new Triangulo(ladoUno, ladoDos, ladoTres);
					txfResultado.setText(triangulo.tipo());
				} else {
					txfResultado.setText("Lados inválidos");
				}
			}
		} catch (NumberFormatException e) {
			txfResultado.setText("Lados inválidos");
		}
	}

	private boolean camposCompletos() {
		if (txfLadoUno.getText().isEmpty() || txfLadoDos.getText().isEmpty() || txfLadoTres.getText().isEmpty()) {
			// JOptionPane.showMessageDialog(null, "Completar los tres lados.");
			txfResultado.setText("Lados inválidos");
			return false;
		}
		return true;
	}

	private void setComponentes() {
		txfLadoUno = new JTextField();
		txfLadoUno.setBounds(37, 74, 114, 19);
		getContentPane().add(txfLadoUno);
		txfLadoUno.setColumns(10);

		txfLadoDos = new JTextField();
		txfLadoDos.setBounds(195, 74, 114, 19);
		getContentPane().add(txfLadoDos);
		txfLadoDos.setColumns(10);

		txfLadoTres = new JTextField();
		txfLadoTres.setBounds(368, 74, 114, 19);
		getContentPane().add(txfLadoTres);
		txfLadoTres.setColumns(10);

		JLabel lblNewLabel = new JLabel("Lado 1");
		lblNewLabel.setBounds(37, 45, 70, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Lado 2");
		lblNewLabel_1.setBounds(198, 45, 70, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Lado 3");
		lblNewLabel_2.setBounds(368, 45, 70, 15);
		getContentPane().add(lblNewLabel_2);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(37, 166, 117, 25);
		getContentPane().add(btnCalcular);

		txfResultado = new JTextField();
		txfResultado.setBounds(195, 166, 287, 22);
		getContentPane().add(txfResultado);
		txfResultado.setColumns(10);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(378, 200, 104, 19);
		contentPane.add(btnLimpiar);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrianguloInterfaz frame = new TrianguloInterfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setCalcularKeyListener() {
		calcularListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					calcularTriangulo();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}
}
