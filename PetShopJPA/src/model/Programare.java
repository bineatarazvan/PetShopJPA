package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the animal database table.
 * @Entity - ii spui ca mapezi tabela animal. se pune deasupra clasei
 * toate variabilele reprezinta coloanele tabelei animal
 * @Id - cheia primara a tabelei animal
 * @GeneratedValue - idAnimal va fi generat automat
 */

	@Entity
	@NamedQuery(name="Programare.fiindAll", query="SELECT a FROM Programare a")
public class Programare implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int idProgramare;
	private int idAnimalFK;
	private int idPersonalMedicalFK;
	private String dataProgramare;
	private String oraProgramare;
	private String date1;
	
	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//String string = format.format(calendar.getTime());
	//System.out.println(string);
	public int getIdProgramare() {
		return idProgramare;
	}


	public String getDate1() {
		return date1;
	}


	public void setDate1(String string) {
		this.date1 = string;
	}


	public void setIdProgramare(int idProgramare) {
		this.idProgramare = idProgramare;
	}


	public int getIdAnimalFK() {
		return idAnimalFK;
	}


	public void setIdAnimalFK(int idAnimalFK) {
		this.idAnimalFK = idAnimalFK;
	}


	public int getIdPersonalMedicalFK() {
		return idPersonalMedicalFK;
	}


	public void setIdPersonalMedicalFK(int idPersonalMedicalFK) {
		this.idPersonalMedicalFK = idPersonalMedicalFK;
	}


	public String getDataProgramare() {
		return dataProgramare;
	}


	public void setDataProgramare(String dataProgramare) {
		this.dataProgramare = dataProgramare;
	}


	public String getOraProgramare() {
		return oraProgramare;
	}


	public void setOraProgramare(String oraProgramare) {
		this.oraProgramare = oraProgramare;
	}


	public Programare() {		
	}

}
