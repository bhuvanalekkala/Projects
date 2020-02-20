package com.mits.ce.eventhandler;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.CustomObject;
import com.filenet.api.core.Document;
import com.filenet.api.core.Folder;
import com.filenet.api.engine.EventActionHandler;
import com.filenet.api.events.ObjectChangeEvent;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Properties;
import com.filenet.api.util.Id;
public class FolderEventHandler implements EventActionHandler {
	public void onEvent(ObjectChangeEvent event, Id id)
			    throws EngineRuntimeException
			  {
			    try
			    {
			        System.out.println("FolderEventHandler Started***************");
                    Folder folder = (Folder)event.get_SourceObject();
			    	folder.refresh();
			        Properties properties = folder.getProperties();
                    String title = properties.getStringValue("bhu name");
			        title = title+"_MODIFIED";;
	                System.out.println("FolderEventHandler is @@@@@@@@@@@@"+title);
			        properties.putValue("bhu name", title);
			        folder.save(RefreshMode.REFRESH);
			        System.out.println("FolderEventHandler End***************");

			    } catch (Exception exception) {
			      exception.printStackTrace();
			    }
			  }
			}





