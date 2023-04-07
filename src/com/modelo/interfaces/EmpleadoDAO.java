package com.modelo.interfaces;

import java.util.ArrayList;

import com.modelo.entidad.Empleado;

public interface EmpleadoDAO {
	public ArrayList<Empleado> listAll();
	public int save(Empleado bean);
	public int update(Empleado bean);
	public int delete(int cod);
	
	
}
