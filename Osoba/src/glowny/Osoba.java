package glowny;

import java.time.LocalDate;
import java.time.Period;

public class Osoba {
	private String imie="";
	private String nazwisko="";
	private LocalDate dataUrodzenia=LocalDate.now();
	private String numerTelefonu="";
	
	public String opisOsoby()
	{
		LocalDate dataTeraz=LocalDate.now();
		Period wiekPeriod = Period.between(dataUrodzenia, dataTeraz);
		int wiek =wiekPeriod.getYears();
		return imie+","+nazwisko+","+wiek+","+numerTelefonu;
	}
	
	
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public LocalDate getDataUrodzenia() {
		return dataUrodzenia;
	}
	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	public String getNumerTelefonu() {
		return numerTelefonu;
	}
	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}
	
	
	public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia, String numerTelefonu) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dataUrodzenia = dataUrodzenia;
		this.numerTelefonu = numerTelefonu;
	}
	
	public Osoba() {
		imie = "";
		nazwisko = "";
		dataUrodzenia = null;
		numerTelefonu = "";
	}

	
}
