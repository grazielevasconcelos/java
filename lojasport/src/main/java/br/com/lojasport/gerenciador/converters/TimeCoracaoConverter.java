package br.com.lojasport.gerenciador.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.lojasport.gerenciador.beans.AdminCampanhaBean;
import br.com.lojasport.gerenciador.models.TimeCoracao;

@FacesConverter("timeCoracaoConverter")
public class TimeCoracaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			TimeCoracao timeCoracao = new TimeCoracao();
			timeCoracao.setIdTimeCoracao(Integer.valueOf(value));
			return timeCoracao;
		} catch (NumberFormatException e) {
			throw new ConverterException();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return "";
		}
		if(value instanceof TimeCoracao) {
			TimeCoracao timeCoracao = (TimeCoracao) value;
			return timeCoracao.getIdTimeCoracao().toString();		
		}else {
			throw new ConverterException();
		}
	}

}
