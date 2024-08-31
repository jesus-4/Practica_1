package dominio;

import exceptions.ExceptionArtista;
import interfaz.userArtista;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Artista implements userArtista {
	private String nombre;
	private Calendar fechaNacto;
	private Calendar fechaMuerte;
	private Sexo sexo;
	private int edadTemp;

	private Artista(String nombre, Calendar fechaNacto, Sexo sexo)  {
		edadTemp=getEdad(fechaNacto);
		this.nombre= normalizar(nombre);
		this.fechaNacto=fechaNacto;
		this.sexo=sexo;
	}

	@Override
	public Artista crearArtist(String nombre, Calendar fechaNacto, Sexo sexo) {
		return new Artista(nombre, fechaNacto, sexo);
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
		Artista other = (Artista) obj;
		return Objects.equals(nombre, other.nombre)
				&& sexo == other.sexo;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaNacto(Calendar fechaNacto) {
		this.fechaNacto = fechaNacto;
	}

	public Calendar getFechaMuerte() {
		return fechaMuerte;
	}


	public void setFechaMuerte(GregorianCalendar f) {
		this.fechaMuerte= f;
	}

	public String getFechaMuerteCorta() {
		if (fechaMuerte == null) {
			return "Still Alive!";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		return sdf.format(fechaMuerte.getTime());
	}
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getFechaCorta() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		return sdf.format(fechaNacto.getTime());
	}

	public int getEdad() {
		int tmp = GregorianCalendar.getInstance().get(Calendar.YEAR) - fechaNacto.get(Calendar.YEAR);
		if (GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR) < fechaNacto.get(Calendar.DAY_OF_YEAR)) {
			tmp-=1;
		}
		return tmp;
	}
	public int getEdad(Calendar f) {
		int tmp = GregorianCalendar.getInstance().get(Calendar.YEAR) - f.get(Calendar.YEAR);
		if (GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR) < f.get(Calendar.DAY_OF_YEAR)) {
			tmp-=1;
		}
		return tmp;
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

