package com.softwareCompany.municipiosYProvincias.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.softwareCompany.municipiosYProvincias.controller.ControladorMunicipio;
import com.softwareCompany.municipiosYProvincias.controller.ControladorProvincia;
import com.softwareCompany.municipiosYProvincias.model.Municipio;
import com.softwareCompany.municipiosYProvincias.model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfBuscador;
	private JTextField jtfNombreMunicipio;
	JComboBox<Municipio> jcbMunicipio;
	JComboBox<Provincia> jcbProvinciaMunicipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		super("Gestion de municipios por provincias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jtfBuscador = new JTextField();
		GridBagConstraints gbc_jtfBuscador = new GridBagConstraints();
		gbc_jtfBuscador.weightx = 1.0;
		gbc_jtfBuscador.insets = new Insets(10, 10, 10, 10);
		gbc_jtfBuscador.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBuscador.gridx = 0;
		gbc_jtfBuscador.gridy = 0;
		contentPane.add(jtfBuscador, gbc_jtfBuscador);
		jtfBuscador.setColumns(10);
		
		JButton jbtFiltrar = new JButton("Filtrar");
		jbtFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		GridBagConstraints gbc_jbtFiltrar = new GridBagConstraints();
		gbc_jbtFiltrar.insets = new Insets(10, 10, 10, 10);
		gbc_jbtFiltrar.gridx = 1;
		gbc_jbtFiltrar.gridy = 0;
		contentPane.add(jbtFiltrar, gbc_jbtFiltrar);
		
		jcbMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(10, 10, 10, 10);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		contentPane.add(jcbMunicipio, gbc_jcbMunicipio);
		
		JButton jbtSelecionar = new JButton("Seleccionar");
		jbtSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionar();
			}
		});
		GridBagConstraints gbc_jbtSelecionar = new GridBagConstraints();
		gbc_jbtSelecionar.insets = new Insets(10, 10, 10, 10);
		gbc_jbtSelecionar.gridx = 1;
		gbc_jbtSelecionar.gridy = 1;
		contentPane.add(jbtSelecionar, gbc_jbtSelecionar);
		
		JLabel lblNewLabel = new JLabel("Municipio Selecionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Municipio:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombreMunicipio = new JTextField();
		GridBagConstraints gbc_jtfNombreMunicipio = new GridBagConstraints();
		gbc_jtfNombreMunicipio.insets = new Insets(10, 10, 10, 10);
		gbc_jtfNombreMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombreMunicipio.gridx = 1;
		gbc_jtfNombreMunicipio.gridy = 0;
		panel.add(jtfNombreMunicipio, gbc_jtfNombreMunicipio);
		jtfNombreMunicipio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia del Municipio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProvinciaMunicipio = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvinciaMunicipio = new GridBagConstraints();
		gbc_jcbProvinciaMunicipio.insets = new Insets(10, 10, 10, 10);
		gbc_jcbProvinciaMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvinciaMunicipio.gridx = 1;
		gbc_jcbProvinciaMunicipio.gridy = 1;
		panel.add(jcbProvinciaMunicipio, gbc_jcbProvinciaMunicipio);
		
		JButton jbtGuardar = new JButton("Guardar");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.insets = new Insets(10, 10, 10, 10);
		gbc_jbtGuardar.anchor = GridBagConstraints.EAST;
		gbc_jbtGuardar.gridx = 1;
		gbc_jbtGuardar.gridy = 2;
		panel.add(jbtGuardar, gbc_jbtGuardar);
	}
	
	/**
	 * 
	 */
	private void filtrar() {
		jcbMunicipio.removeAllItems();
		for (Municipio m : 	ControladorMunicipio.findByLikeDescripcion(jtfBuscador.getText())) {
			jcbMunicipio.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void seleccionar() {
		Municipio mu = (Municipio) jcbMunicipio.getSelectedItem();
		jtfNombreMunicipio.setText(mu.getNombre());

		jcbProvinciaMunicipio.removeAllItems();
		Provincia p = mu.getProvincia();
		for (Provincia m : 	ControladorProvincia.findById(p.getId())) {
			jcbProvinciaMunicipio.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void guardar() {
		Municipio m = (Municipio) jcbMunicipio.getSelectedItem();
		Provincia p = (Provincia) jcbProvinciaMunicipio.getSelectedItem();
		
		m.setProvincia(p);
		m.setNombre(jtfNombreMunicipio.getText());
		ControladorMunicipio.modificarEntidad(m);
	}

}
