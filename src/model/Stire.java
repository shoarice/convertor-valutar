package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stire implements Cloneable{
	public static DateFormat df = new SimpleDateFormat("HH:mm:ss d MMM yyyy");
	
	private int autorId;
	private long stireId;
	private String sursa;
	private String dataModificat;
	private String dataCreat;
	private String autor;
	private String stire;
	private String titlu;
	
	public long getStireId() {
		return stireId;
	}
	public void setStireId(long stireId) {
		this.stireId = stireId;
	}
	public int getAutorId() {
		return autorId;
	}
	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
	public String getSursa() {
		return sursa;
	}
	public void setSursa(String sursa) {
		this.sursa = sursa;
	}
	public String getDataModificat() {
		return dataModificat;
	}
	public void setDataModificat(Date date) {
		this.dataModificat = df.format(date);
	}
	public void setDataModificat(String date) {
		this.dataModificat = date;
	}
	public String getDataCreat() {
		return dataCreat;
	}
	public void setDataCreat(Date date) {
		this.dataCreat = df.format(date);
	}
	public void setDataCreat(String date) {
		this.dataCreat = date;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getStire() {
		return stire;
	}
	public void setStire(String stire) {
		this.stire = stire;
	}
	
	
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	@Override
	public String toString() {
		return titlu + " - " + autor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + autorId;
		result = prime * result
				+ ((dataCreat == null) ? 0 : dataCreat.hashCode());
		result = prime * result
				+ ((dataModificat == null) ? 0 : dataModificat.hashCode());
		result = prime * result + ((stire == null) ? 0 : stire.hashCode());
		result = prime * result + (int) (stireId ^ (stireId >>> 32));
		result = prime * result + ((sursa == null) ? 0 : sursa.hashCode());
		result = prime * result + ((titlu == null) ? 0 : titlu.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stire other = (Stire) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (autorId != other.autorId)
			return false;
		if (dataCreat == null) {
			if (other.dataCreat != null)
				return false;
		} else if (!dataCreat.equals(other.dataCreat))
			return false;
		if (dataModificat == null) {
			if (other.dataModificat != null)
				return false;
		} else if (!dataModificat.equals(other.dataModificat))
			return false;
		if (stire == null) {
			if (other.stire != null)
				return false;
		} else if (!stire.equals(other.stire))
			return false;
		if (stireId != other.stireId)
			return false;
		if (sursa == null) {
			if (other.sursa != null)
				return false;
		} else if (!sursa.equals(other.sursa))
			return false;
		if (titlu == null) {
			if (other.titlu != null)
				return false;
		} else if (!titlu.equals(other.titlu))
			return false;
		return true;
	}
	
	@Override
	public Stire clone(){
		Stire s = new Stire();
		s.autor = autor;
		s.autorId = autorId;
		s.dataCreat = dataCreat.toString();
		s.dataModificat = dataModificat.toString();
		s.stire = stire.toString();
		s.stireId = stireId;
		s.sursa = sursa.toString();
		s.titlu = titlu.toString();
		return s;
		
	}
}
