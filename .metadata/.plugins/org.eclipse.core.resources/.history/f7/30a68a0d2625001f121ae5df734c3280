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

public class Home extends JFrame {

	
	Aimpl alm=new Aimpl();
	Producto p;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tBusq;
	private final Action action = new SwingAction();
	private JTextArea tpBusq;

	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 354);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Home");
		menuBar.add(mnUsuario);
		
		JButton btnNewButton_2 = new JButton("inventario");
		mnUsuario.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Usuario");
		mnUsuario.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Carrito");
		mnUsuario.add(btnNewButton_4);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario i1=new Inventario();
				i1.setVisible(true);
			}
		
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario i1=new Usuario();
				i1.setVisible(true);
			}
		
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrito i1=new Carrito();
				i1.setVisible(true);
			}
		
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIENDA");
		lblNewLabel.setBounds(267, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		tBusq = new JTextField();
		tBusq.setBounds(24, 40, 132, 20);
		contentPane.add(tBusq);
		tBusq.setColumns(10);
		
		JButton btnNewButton = new JButton("B");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idS=tBusq.getText();//de momento sirve (ambas lineas, esta y abajo) pero necesito que busque en un loop para buscar todos las posibles coincidencias con el nombre ingresado
				String prod=(" | "+alm.consultarN(idS).getId_producto()+" | "+alm.consultarN(idS).getNombre()+" | "+alm.consultarN(idS).getPrecio()+" | "+alm.consultarN(idS).getStock()+" | "+"\n");
				tpBusq.setText(prod);
			}
		});
		btnNewButton.setBounds(166, 39, 48, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Carro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrito c1=new Carrito();
				c1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(277, 39, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(403, 40, 46, 20);
		contentPane.add(spinner);
		
		tpBusq = new JTextArea();
		tpBusq.setBounds(67, 91, 246, 143);
		contentPane.add(tpBusq);
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
