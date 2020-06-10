package de.bruxxen.MyGourmet.Listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DebugPhaseListener implements PhaseListener {
	static Log log = LogFactory.getLog(DebugPhaseListener.class);

	public void afterPhase(PhaseEvent event) {
		log.debug("After phase: " + event.getPhaseId());
		System.out.println("After phase: " + event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
		log.debug("Before phase: " + event.getPhaseId());
		System.out.println("Before phase: " + event.getPhaseId());
		
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
