package dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Artist  {
	private String nombre;
	private LocalDate fechaNacto;
	private Sexo sexo;

	public Artist(String nombre, LocalDate fechaNacto, Sexo sexo)  {
		this.nombre= normalizar(nombre);
		this.fechaNacto=fechaNacto;
		this.sexo=sexo;
	}
	public static Artist InstanceOfArtista(String nombre, LocalDate fechaNacto, Sexo sexo) {
		return new Artist(nombre, fechaNacto, sexo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacto, nombre, sexo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return Objects.equals(nombre, other.nombre)
				&& sexo == other.sexo;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaNacto(LocalDate fechaNacto) {
		this.fechaNacto = fechaNacto;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public int getEdad(){
		return 0;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String normalizar(String nombre) {
		String aux[]= nombre.trim().split(" ");
		String tmp= "";
		for (String string : aux) {
			if(string==null || string != "")
				tmp += string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase()+ " ";
		}
		return tmp.trim();
	}

}


