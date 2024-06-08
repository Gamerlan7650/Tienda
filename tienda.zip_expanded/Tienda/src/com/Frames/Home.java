package com.Frames;

import java.awt.EventQueue;
import com.clases.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;

public class Home extends JFrame {

	
	Aimpl alm=new Aimpl();
	Producto p;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action action = new SwingAction();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 354);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Home");
		menuBar.add(mnUsuario);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIENDA AMIGA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(157, 11, 150, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblAadirElementos = new JLabel("Añadir Elementos");
		lblAadirElementos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAadirElementos.setBounds(222, 45, 150, 44);
		contentPane.add(lblAadirElementos);
		
		JLabel lblAadirUsuarios = new JLabel("Añadir Usuarios");
		lblAadirUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAadirUsuarios.setBounds(222, 100, 150, 44);
		contentPane.add(lblAadirUsuarios);
		
		JLabel lblAadirCompra = new JLabel("Añadir Compra");
		lblAadirCompra.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAadirCompra.setBounds(222, 155, 150, 44);
		contentPane.add(lblAadirCompra);
		
		JButton btnNewButton_2 = new JButton("inventario");
		btnNewButton_2.setBounds(77, 60, 117, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Usuario");
		btnNewButton_3.setBounds(77, 115, 109, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Carrito");
		btnNewButton_4.setBounds(77, 170, 105, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrito i1=new Carrito();
				i1.setVisible(true);
			}
		
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario i1=new Usuario();
				i1.setVisible(true);
			}
		
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario i1=new Inventario();
				i1.setVisible(true);
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
