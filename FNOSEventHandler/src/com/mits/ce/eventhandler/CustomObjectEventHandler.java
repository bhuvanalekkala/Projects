package com.mits.ce.eventhandler;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.CustomObject;
import com.filenet.api.core.Document;
import com.filenet.api.engine.EventActionHandler;
import com.filenet.api.events.ObjectChangeEvent;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Properties;
import com.filenet.api.util.Id;
public class CustomObjectEventHandler implements EventActionHandler{
	   public void onEvent(ObjectChangeEvent event, Id id)
		    throws EngineRuntimeException
		  {
		    try
		    {
		        System.out.println("CustomObjectEventHandler Started***************");
		        CustomObject customobject = (CustomObject)event.get_SourceObject();
		    	customobject.refresh();
		        Properties properties = customobject.getProperties();
                int title = properties.getInteger32Value("age1");
		        title = title+100;
                System.out.println("customobject is @@@@@@@@@@@@"+title);
		        properties.putValue("age1", title);
		       customobject.save(RefreshMode.REFRESH);
		       System.out.println("CustomObjectEventHandler End***************");

		    } catch (Exception exception) {
		      exception.printStackTrace();
		    }
		  }
		}



