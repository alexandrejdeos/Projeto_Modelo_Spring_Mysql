package br.com.lds.web.listener;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * @author ajsantos
 * @date 31/05/2017
 * @info Classe responsável por remover os css do primefaces.
 */
public class RemoveResourcesListener implements SystemEventListener {
	private static final String HEAD = "head";

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		FacesContext context = FacesContext.getCurrentInstance();
		// Fetch included resources list size
		int count = context.getViewRoot().getComponentResources(context, HEAD).size() - 1;

		while (count >= 0) {
			// Fetch current resource from included resources list
			UIComponent resource = context.getViewRoot().getComponentResources(context, HEAD).get(count);
			// Fetch resource library and resource name
			String resourceLibrary = (String) resource.getAttributes().get("library");
			String resourceName = (String) resource.getAttributes().get("name");

			// Check if we should remove the current resource.
			// Here we may check for any library and name combination.
			// (JSF, Primefaces, Richfaces, etc)
			if ("primefaces".equals(resourceLibrary)
					&& ("diagram.css".equals(resourceName) || "components.css".equals(resourceName))) {
				// Remove resource from view
				context.getViewRoot().removeComponentResource(context, resource, HEAD);
			}
			count--;
		}
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof UIViewRoot);
	}
}
