package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	List<Persona> lstPersonas = new ArrayList <Persona>();
	List<Seguridad> lstSeguridad = new ArrayList <Seguridad>();
	public Sistema(List<Persona> lstPersonas, List<Seguridad> lstSeguridad) {
		super();
		this.lstPersonas = lstPersonas;
		this.lstSeguridad = lstSeguridad;
	}
	public Sistema() {}
	
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	public List<Seguridad> getLstSeguridad() {
		return lstSeguridad;
	}
	public void setLstSeguridad(List<Seguridad> lstSeguridad) {
		this.lstSeguridad = lstSeguridad;
	}

	public boolean agregarEmpleado(String apellido, String nombre, int dni, int nroLegajo) {
		Persona p = null;
		
		if(lstPersonas.isEmpty())
			p = new Empleado(1, apellido, nombre, dni, nroLegajo);
		else
			p = new Empleado(lstPersonas.get(lstPersonas.size()-1).getId()+1, apellido, nombre, dni, nroLegajo);
		
		return lstPersonas.add(p);
	}
	
	@Override
	public String toString() {
		return "Sistema [lstPersonas=" + lstPersonas + ", lstSeguridad=" + lstSeguridad + "]";
	}
	public boolean agregarVisita(String apellido, String nombre, int dni, String empresa) {
		Persona p = null;
		
		if(lstPersonas.isEmpty())
			p = new Visita(1, apellido, nombre, dni, empresa);
		else
			p = new Visita(lstPersonas.get(lstPersonas.size()-1).getId()+1, apellido, nombre, dni, empresa);
		
		return lstPersonas.add(p);
	}
	
	public Persona traerPersona(int id) {
		Persona p = null;
		int index = 0;
		
		while(index < lstPersonas.size() && p == null) {
			if(lstPersonas.get(index).getId() == id)
				p = lstPersonas.get(index);
			index++;
		}
		
		return p;
	}
	
	public List<Seguridad> traerSeguridad(LocalDate fecha, Persona persona){
		List<Seguridad> s = new ArrayList<Seguridad>();
		
		for(int i=0; i<lstSeguridad.size(); i++) {
			if(lstSeguridad.get(i).getFecha().isEqual(fecha) && lstSeguridad.get(i).getPersona().equals(persona))
				s.add(lstSeguridad.get(i));
		}
		
		return s;
	}
	
	public boolean agregarSeguridad(LocalDate fecha, LocalTime hora, boolean entrada, Persona persona)throws Exception {
		Seguridad s = null;
		
		List<Seguridad> segAux = traerSeguridad(fecha, persona);
		
		if(!segAux.isEmpty()) {
			if(segAux.get(segAux.size()-1).isEntrada() == entrada)
				throw new Exception("No puede registrar dos veces la salida o la entrada");
		}
		
		if(lstSeguridad.isEmpty())
			s = new Seguridad(1, fecha, hora, entrada, persona);
		else
			s = new Seguridad(lstSeguridad.get(lstSeguridad.size()-1).getId()+1, fecha, hora, entrada, persona);
		
		return lstSeguridad.add(s);
	}
	
	public List<Seguridad> traerVisitas(LocalDate fecha){
		List<Seguridad> s = new ArrayList <Seguridad>();
		
		for(int i=0; i<lstSeguridad.size(); i++) {
			if(lstSeguridad.get(i).getFecha().isEqual(fecha)) {
				if(lstSeguridad.get(i).getPersona() instanceof Visita)
					s.add(lstSeguridad.get(i));
			}
		}
		
		return s;
	}
}
