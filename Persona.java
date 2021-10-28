package modelo;

public abstract class Persona {
	protected int id;
	protected String apellido;
	protected String nombre;
	protected int dni;
	public Persona(int id, String apellido, String nombre, int dni) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + "apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	public boolean equals(Persona p) {
		return (apellido.equalsIgnoreCase(p.apellido)) && (nombre.equalsIgnoreCase(p.nombre)) && (dni == p.dni);
	}
	
}
