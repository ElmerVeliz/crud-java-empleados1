package com.modelo.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.modelo.componente.JComboBoxBD;
import com.modelo.controlador.MySqlEmpleadoDAO;
import com.modelo.entidad.Empleado;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class frmEmpleado extends JFrame implements ActionListener, MouseListener {
	
	MySqlEmpleadoDAO dao=new MySqlEmpleadoDAO();	
	
	
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JComboBox cboDistrito;
	private JTable tblEmpleado;
	private JButton btnNuevo;
	private JButton btnNuevo1;
	private JTextField txtSueldo;
	private JTextField txtHijos;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmpleado frame = new frmEmpleado();
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
	public frmEmpleado() {
		setTitle("EMPLEADO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO DE EMPLEADO");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1039, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00D3DIGO");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 103, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setText("0");
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigo.setBounds(120, 100, 154, 30);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRES");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 150, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtNombres = new JTextField();
		txtNombres.setBackground(Color.WHITE);
		txtNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNombres.setColumns(10);
		txtNombres.setBounds(120, 143, 330, 30);
		contentPane.add(txtNombres);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("APELLIDOS");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 191, 89, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtApellidos = new JTextField();
		txtApellidos.setBackground(Color.WHITE);
		txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(120, 184, 330, 30);
		contentPane.add(txtApellidos);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI:");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 239, 94, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtDNI = new JTextField();
		txtDNI.setBackground(Color.WHITE);
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDNI.setColumns(10);
		txtDNI.setBounds(120, 234, 330, 26);
		contentPane.add(txtDNI);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setToolTipText("Registrar");
		btnRegistrar.setIcon(null);
		btnRegistrar.setBounds(119, 484, 94, 53);
		contentPane.add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(null);
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setBounds(326, 484, 94, 53);
		contentPane.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(null);
		btnActualizar.setToolTipText("Actualizar");
		btnActualizar.setBounds(222, 484, 94, 53);
		contentPane.add(btnActualizar);
		
		JLabel lblDistrito = new JLabel(" DISTRITO :");
		lblDistrito.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDistrito.setBounds(0, 396, 94, 14);
		contentPane.add(lblDistrito);
		
		cboDistrito = new JComboBoxBD("SELECT *FROM TB_DISTRITO");
		cboDistrito.setBounds(120, 388, 330, 33);
		contentPane.add(cboDistrito);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(471, 157, 578, 123);
		contentPane.add(scrollPane);
		
		tblEmpleado = new JTable();
		tblEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblEmpleado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblEmpleado.setCellSelectionEnabled(true);
		tblEmpleado.addMouseListener(this);
		tblEmpleado.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRES", "APELLIDOS", "DNI", "HIJOS", "SUELDO", "DISTRITO"
			}
		));
		tblEmpleado.getColumnModel().getColumn(0).setPreferredWidth(59);
		tblEmpleado.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblEmpleado.getColumnModel().getColumn(2).setPreferredWidth(121);
		tblEmpleado.getColumnModel().getColumn(3).setPreferredWidth(53);
		tblEmpleado.getColumnModel().getColumn(4).setPreferredWidth(85);
		tblEmpleado.getColumnModel().getColumn(5).setPreferredWidth(53);
		tblEmpleado.getColumnModel().getColumn(6).setPreferredWidth(153);
		tblEmpleado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblEmpleado);
		
		btnNuevo1 = new JButton("Nuevo");
		btnNuevo1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNuevo1.addActionListener(this);
		btnNuevo1.setBounds(20, 484, 89, 53);
		contentPane.add(btnNuevo1);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(120, 331, 330, 30);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		txtHijos = new JTextField();
		txtHijos.setBounds(120, 283, 330, 30);
		contentPane.add(txtHijos);
		txtHijos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("HIJOS :");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 291, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SUELDO :");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 339, 84, 14);
		contentPane.add(lblNewLabel_3);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(430, 484, 89, 53);
		contentPane.add(btnSalir);
	
		listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnNuevo1) {
			actionPerformedBtnNuevo1(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		Empleado bean=new Empleado();
		bean.setCodempleado(getCodigo());
		bean.setNom_empleado(getNombre());
		bean.setApe_empleado(getApellidos());
		bean.setDni_empleado(getDNI());
		bean.setNum_hijos(getNumHijos());
		bean.setSueldo(getSueldo());
		bean.setCoddistrito(getDistrito());
		int resu=dao.save(bean);
		if(resu>0){
			mensaje("Empleado registrado");
			listado();
		}
		else
			mensaje("Error en el registro del empleado");
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		Empleado bean=new Empleado();
		bean.setCodempleado(getCodigo());
		bean.setNom_empleado(getNombre());
		bean.setApe_empleado(getApellidos());
		bean.setDni_empleado(getDNI());
		bean.setNum_hijos(getNumHijos());
		bean.setSueldo(getSueldo());
		bean.setCoddistrito(getDistrito());
		int resu=dao.update(bean);
		if(resu>0){
			mensaje("Empleado actualizado");
			listado();
		}
		else
			mensaje("Error en la actualización del empleado");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int boton;
		boton=JOptionPane.showConfirmDialog(this,"Seguro de eliminar el empleado con ID : "+getCodigo(),"Sistema",
											JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(boton==0){
			int resu;
			resu=dao.delete(getCodigo());
			if(resu>0){
				mensaje("Empleado eliminado");
				listado();
			}
			else
				mensaje("Error en la eliminación");
		}
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	void listado(){
		DefaultTableModel model=(DefaultTableModel) tblEmpleado.getModel();
		model.setRowCount(0);
		ArrayList<Empleado> lista=dao.listAll();
		for(Empleado e:lista){
			Object row[]={e.getCodempleado(), e.getNom_empleado(), e.getApe_empleado(), e.getDni_empleado(), e.getNum_hijos(), e.getSueldo(), e.getNomdistrito()				
			};
			model.addRow(row);
		}
	}
	
	int getCodigo(){
		return Integer.parseInt(txtCodigo.getText());
	}
	String getNombre() {
		return txtNombres.getText();
		
	 }
	String getApellidos(){
		return txtApellidos.getText();
	}
	String getDNI(){
		return txtDNI.getText();
	}
	
	int getNumHijos() {
		return Integer.parseInt(txtHijos.getText());
	}
	
	double getSueldo() {
		return Double.parseDouble(txtSueldo.getText());
	}
	
	int getDistrito(){
		return cboDistrito.getSelectedIndex()+1;
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getSource() == tblEmpleado) {
			mouseReleasedTblEdificios(arg0);
		}
	}
	protected void mouseReleasedTblEdificios(MouseEvent arg0) {
		int posFila;
		String cod,nombre,apellido,DNI,hijos,sueldo;
		posFila=tblEmpleado.getSelectedRow();
		cod=tblEmpleado.getValueAt(posFila, 0).toString();
		nombre=tblEmpleado.getValueAt(posFila, 1).toString();
		apellido=tblEmpleado.getValueAt(posFila, 2).toString();
		DNI=tblEmpleado.getValueAt(posFila, 3).toString();
		hijos=tblEmpleado.getValueAt(posFila, 4).toString(); 
		sueldo= tblEmpleado.getValueAt(posFila, 5).toString();
		txtCodigo.setText(cod);
		txtNombres.setText(nombre);
		txtApellidos.setText(apellido);
		txtDNI.setText(DNI);
		txtHijos.setText(hijos);
		txtSueldo.setText(sueldo);
		
	}
	protected void actionPerformedBtnNuevo1(ActionEvent e) {
		txtCodigo.setText(" ");
		txtNombres.setText(" ");
		txtApellidos.setText(" ");
		txtDNI.setText(" ");
		txtHijos.setText(" ");
		txtSueldo.setText("");
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}








