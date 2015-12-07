package service.serviceImplements;

import com.db4o.ObjectContainer;

/**
 * Created by Arsefan on 04.11.2015.
 */
public interface ServiceInterface {
     ObjectContainer openDB(String host, String port);
    // ObjectContainer db = null;
}
