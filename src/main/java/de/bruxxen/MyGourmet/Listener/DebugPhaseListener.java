package de.bruxxen.MyGourmet.Listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class DebugPhaseListener implements PhaseListener {
	static Log log = LogFactory.getLog(DebugPhaseListener.class);

	
	public DebugPhaseListener() {
		BasicConfigurator.configure();
	}
	
	public void afterPhase(PhaseEvent event) {
		log.debug("After phase: " + event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
		log.debug("Before phase: " + event.getPhaseId());	
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
