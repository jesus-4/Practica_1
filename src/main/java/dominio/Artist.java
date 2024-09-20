package dominio;

import exceptions.ExceptionArtist;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Artist  {
	private String nombre;
	private LocalDate fechaNacto;
	private Sexo sexo;

	private Artist(String nombre, LocalDate fechaNacto, Sexo sexo)  {
		this.nombre= normalizar(nombre);
		this.fechaNacto=fechaNacto;
		this.sexo=sexo;
	}
	public static Artist InstanceOfArtista(String nombre, LocalDate fechaNacto, Sexo sexo) throws ExceptionArtist {
		if (nombre.isEmpty()){
			throw new ExceptionArtist("No se ha encontrado el nombre");
		}if (fechaNacto == null){
			throw new ExceptionArtist("No se ha encontrado la fecha de nacimiento");
		}
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

	public String getFechaCorta() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
		return fechaNacto.format(formato);
	}

	public int getEdad(){
		return Period.between(this.fechaNacto, LocalDate.now()).getYears();
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		if (sexo == Sexo.Masculino) {
			return "El Artista: "+ nombre+ " ("+ getFechaCorta()+")";
		}
		return "La Artista: "+ nombre+ " ("+ getFechaCorta()+")";
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


