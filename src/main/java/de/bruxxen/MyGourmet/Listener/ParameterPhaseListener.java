package de.bruxxen.MyGourmet.Listener;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class ParameterPhaseListener implements PhaseListener {
	static Log log = LogFactory.getLog(ParameterPhaseListener.class);
	
	public ParameterPhaseListener() {
		BasicConfigurator.configure();
	}

	public void afterPhase(PhaseEvent event) {
		FacesContext fContext =FacesContext.getCurrentInstance();
		Map<String, String> map = fContext.getExternalContext().getRequestParameterMap();
		for (String key  : map.keySet()) {
			StringBuilder param = new StringBuilder();
			param.append("Parameter: ");
			param.append(key);
			param.append(" = ");
			param.append(map.get(key));
			log.debug(param.toString());
		}
	}

	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
	}

	public PhaseId getPhaseId() {
		return PhaseId.APPLY_REQUEST_VALUES;
	}

}
