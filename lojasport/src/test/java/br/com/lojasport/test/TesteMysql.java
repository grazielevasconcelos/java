package br.com.lojasport.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.lojasport.gerenciador.daos.CampanhaDao;
import br.com.lojasport.gerenciador.models.Campanha;

public class TesteMysql {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2018, 1, 15);
		try {
			DateFormat.getDateInstance().parse("20/02/2018");
			Campanha campanha = new Campanha("Saldao"
					, LocalDate.now()
					, ld
					, LocalDateTime.now());
			
			new CampanhaDao().incluir(campanha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
