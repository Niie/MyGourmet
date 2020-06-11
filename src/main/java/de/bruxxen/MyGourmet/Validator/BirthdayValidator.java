package de.bruxxen.MyGourmet.Validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.bruxxen.MyGourmet.Interfaces.Annotation.Birthday;

public class BirthdayValidator implements ConstraintValidator<Birthday, Date> {

	public boolean isValid(Date date, ConstraintValidatorContext context) {
		boolean dateCorrect = true;
		if(date != null) {
			context.disableDefaultConstraintViolation();
			if(date.after(new Date())) {
				context.buildConstraintViolationWithTemplate("Birthday is in the future").addConstraintViolation();
				dateCorrect = false;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, 1900);
				cal.set(Calendar.MONTH, 0);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				
				if(date.before(cal.getTime())) {
					context.buildConstraintViolationWithTemplate("Birthday is before Jan 1, 1900.").addConstraintViolation();
					dateCorrect = false;
				}
			}
		}
		return dateCorrect;
	}
}
