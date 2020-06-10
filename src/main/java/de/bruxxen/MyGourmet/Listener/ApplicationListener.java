package de.bruxxen.MyGourmet.Listener;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApplicationListener implements SystemEventListener{
	static Log log = LogFactory.getLog(ApplicationListener.class);

	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if (event instanceof PostConstructApplicationEvent) {
			log.debug("application started");
		}else if (event instanceof PreDestroyApplicationEvent){
			log.debug("application shutdown");
		}
	}

	public boolean isListenerForSource(Object source) {
		return source instanceof Application;
	}

}
