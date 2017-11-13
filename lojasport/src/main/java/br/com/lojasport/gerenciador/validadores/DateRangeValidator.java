package br.com.lojasport.gerenciador.validadores;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateRangeValidator")
public class DateRangeValidator implements Validator {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}
		
		UIInput dtInicial = (UIInput) component.getAttributes().get("dataInicialValidator");
		
		if(dtInicial == null) {
			return;
		}
		if(((LocalDate) value).isBefore((ChronoLocalDate) dtInicial.getValue())) {
			dtInicial.setValid(false);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Final de vigência deve ser igual ou superior a data inicial", null));
		}
	}

}
