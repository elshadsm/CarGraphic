package com.eclipssource.rap.draw.example;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;

public class BasicApplication implements ApplicationConfiguration {

  public void configure( Application application ) {
    Map<String, String> properties = new HashMap<String, String>();
    properties.put( WebClient.PAGE_TITLE, "Draw Example" );
    // application.addEntryPoint("/hello", BasicEntryPoint.class, properties);
    application.addEntryPoint( "/draw", DrawGC.class, properties );

  }

}
