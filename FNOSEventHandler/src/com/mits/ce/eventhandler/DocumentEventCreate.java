package com.mits.ce.eventhandler;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.engine.EventActionHandler;
import com.filenet.api.events.ObjectChangeEvent;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Properties;
import com.filenet.api.util.Id;

public class DocumentEventCreate implements EventActionHandler {

	public void onEvent(ObjectChangeEvent event, Id id) throws EngineRuntimeException {
		try {
			System.out.println("PrintPropsActionHandler Started***************");

			Document document = (Document) event.get_SourceObject();
			document.refresh();
			Properties properties = document.getProperties();

			String title = properties.getStringValue("DocumentTitle");

			title = title + "_MODIFIED";

			System.out.println("Document Title is @@@@@@@@@@@@" + title);

			properties.putValue("DocumentTitle", title);

			document.save(RefreshMode.REFRESH);
			System.out.println("PrintPropsActionHandler End***************");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
