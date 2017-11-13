package br.com.lojasport.gerenciador.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		LocalDate localDate = null;
		try {
			return localDate.parse(value, fmt);
		} catch (DateTimeParseException e) {
			//FacesMessage msg = new FacesMessage("URL Conversion error.", "Padrão de data válida: dd/MM/aaaa");
			//msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return "";
		}
		
		if(value instanceof LocalDate) {
			LocalDate localDate = (LocalDate)value;
			return localDate.format(fmt);			
		}else {
			throw new ConverterException();
		}
		
	}

}
