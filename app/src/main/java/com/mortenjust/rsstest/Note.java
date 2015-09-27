package com.mortenjust.rsstest;

import org.simpleframework.xml.Element;

/**
 * Created by mortenjust on 9/26/15.<note>
 <to>Tove</to>
 <from>Jani</from>
 <heading>Reminder</heading>
 <body>Don't forget me this weekend!</body>
 </note>
 */
public class Note {
    @Element(name = "to", required = false)
    private String to;
    @Element(name = "from", required = false)
    private String from;
    @Element(name = "heading", required = false)
    private String headingLocalName;
    @Element(name = "body", required = false)
    private String body;

    public String getTo(){
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getHeading() {
        return headingLocalName;
    }

    public String getBody() {
        return body;
    }
}
