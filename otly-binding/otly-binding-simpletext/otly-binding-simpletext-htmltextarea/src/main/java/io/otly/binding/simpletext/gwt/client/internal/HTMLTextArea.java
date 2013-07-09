package io.otly.binding.simpletext.gwt.client.internal;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * TextArea.
 *
 * @version $Id$
 */
public class HTMLTextArea extends JavaScriptObject
{
    protected HTMLTextArea()
    {
    }

    public native final void setContent(String content)
    /*-{
        this.value = content;
    }-*/;

    public native final String getContent()
    /*-{
        return this.value;
    }-*/;

    public native final void addKeyUpEventListener(KeyUpEventListener cb)
    /*-{
        this.addEventListener("keyup", function (e)
        {
            $entry(cb.@io.otly.binding.simpletext.gwt.client.internal.KeyUpEventListener::onKeyUp()());
        });
    }-*/;
}
