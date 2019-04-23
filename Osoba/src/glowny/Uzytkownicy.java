package glowny;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Uzytkownicy {
	public static void main(String[] args) throws FileNotFoundException {
		
		File plik=new File("Osoby.txt");
		Scanner in = new Scanner(plik);
		ArrayList<Osoba> Osoby=new ArrayList<Osoba>();
		String imie="",nazwisko="",dataUrodzenia="",numerTelefonu="brak",linia="";
		StringTokenizer Tokenizer;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		
		while(in.hasNextLine())
		{
			linia=in.nextLine();
			if(linia.length()<2)
				break;
			Tokenizer = new StringTokenizer(linia,",");
			imie=Tokenizer.nextToken();
			nazwisko=Tokenizer.nextToken();
			dataUrodzenia=Tokenizer.nextToken();
			LocalDate data = LocalDate.parse(dataUrodzenia, formatter);
			if(Tokenizer.hasMoreElements())
			{
				numerTelefonu=Tokenizer.nextToken();
			}
			else
			{
				numerTelefonu="brak";
			}
			Osoby.add(new Osoba(imie,nazwisko,data,numerTelefonu));	
		}
		
		int indeksNajstarszejOsoby=-1;
		for(int i=0;i<Osoby.size();i++)
		{
			if(Osoby.get(i).getNumerTelefonu()!="brak")
			{
				indeksNajstarszejOsoby=i;
				break;
			}
		}
		//Je¿eli ¿aden u¿ytkownik nie ma numeru telefonu
		if(indeksNajstarszejOsoby==-1)
		{
			System.out.println(Osoby.size());
			System.exit(0);
		}
		for(int i=0;i<Osoby.size();i++)
		{
			if((Osoby.get(indeksNajstarszejOsoby).getDataUrodzenia().isAfter(Osoby.get(i).getDataUrodzenia())) && Osoby.get(i).getNumerTelefonu()!="brak")
			{
			indeksNajstarszejOsoby=i;
			}
		}
		System.out.println(Osoby.size()); 
		
		//Sprawdzenie czy nie ma wiêcej najstarszych osób z numerem telefonu 
		for(int i=0;i<Osoby.size();i++)
		{
			if(i==indeksNajstarszejOsoby)
			{
				continue;
			}
			else
			{
				if((Osoby.get(indeksNajstarszejOsoby).getDataUrodzenia().isEqual(Osoby.get(i).getDataUrodzenia())) && Osoby.get(i).getNumerTelefonu()!="brak")
				{
					System.out.println(Osoby.get(i).opisOsoby());
				}
			}
		}
		System.out.println(Osoby.get(indeksNajstarszejOsoby).opisOsoby()); 
		
		in.close();
	}
}
