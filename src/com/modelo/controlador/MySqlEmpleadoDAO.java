package com.modelo.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.modelo.entidad.Empleado;
import com.modelo.interfaces.EmpleadoDAO;
import com.modelo.utils.MySqlConexion;

public class MySqlEmpleadoDAO implements EmpleadoDAO{

	@Override
	public ArrayList<Empleado> listAll() {
		ArrayList<Empleado> data=new ArrayList<Empleado>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();			
			String sql="select e.cod_empleado, e.nom_empleado, e.ape_empleado, e.dni_empleado, e.num_hijos, e.sueldo,"+
			"d.nom_distrito from tb_empleado e join tb_distrito d on e.cod_distrito=d.cod_distrito";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Empleado bean=new Empleado();
				bean.setCodempleado(rs.getInt(1));
				bean.setNom_empleado(rs.getString(2));
				bean.setApe_empleado(rs.getString(3));
				bean.setDni_empleado(rs.getString(4));
				bean.setNum_hijos(rs.getInt(5));
				bean.setSueldo(rs.getDouble(6));
				//bean.setCoddistrito(rs.getInt(7));
				bean.setNomdistrito(rs.getString(7));
				//bean.setCoddistrito(rs.getInt(7));
				data.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	
	
	@Override
	public int save(Empleado bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();			
			String sql="insert into tb_empleado values(null,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			//pstm.setInt(0, bean.getCodempleado());
			pstm.setString(1, bean.getNom_empleado());
			pstm.setString(2, bean.getApe_empleado());
			pstm.setString(3,  bean.getDni_empleado());
			pstm.setInt(4,  bean.getNum_hijos());
			pstm.setDouble(5,  bean.getSueldo());
			pstm.setInt(6,  bean.getCoddistrito());
		
		  //pstm.setInt(6,  bean.getCoddistrito());
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int update(Empleado bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();			
			String sql=" update tb_empleado set nom_empleado=?, ape_empleado=?, dni_empleado=?,"+
								"num_hijos=?, sueldo=?, cod_distrito =? where cod_empleado=?";
			pstm=cn.prepareStatement(sql);
			
			pstm.setString(1, bean.getNom_empleado());
			pstm.setString(2,  bean.getApe_empleado());
			pstm.setString(3,  bean.getDni_empleado());
			pstm.setInt(4,  bean.getNum_hijos());
			pstm.setDouble(5, bean.getSueldo());
			pstm.setInt(6, bean.getCoddistrito());
		    pstm.setInt(7,  bean.getCodempleado());
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	
	
		  //pstm.setInt(6,  bean.getCoddistrito());
		
	

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int delete(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();			
			String sql="delete from tb_empleado where cod_empleado=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	
	
}
