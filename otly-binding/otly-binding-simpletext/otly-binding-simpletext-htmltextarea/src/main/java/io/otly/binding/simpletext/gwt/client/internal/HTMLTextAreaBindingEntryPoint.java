package io.otly.binding.simpletext.gwt.client.internal;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;

import io.otly.api.gwt.shared.util.binding.PlainTextDocument;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;

/**
 * HTMLTextAreaBinding module entry point.
 *
 * his module defines the binding between a SimpleTextDocumentModel and an HTML text area.
 *
 * @version $Id$
 */
public class HTMLTextAreaBindingEntryPoint implements EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(HTMLTextAreaBindingEntryPoint.class.getName());

    public void onModuleLoad()
    {

        logger.fine("Registering binding: SimpleTextDocumentModel -> HTMLTextArea.");

        //Register the binding in the OTLY binding registry in order to make it available to clients.
        DocumentModelBindingFactoryRegistry documentModelBindingFactoryRegistry =
                DocumentModelBindingFactoryRegistry.getInstance();

        documentModelBindingFactoryRegistry.registerBinding(SimpleTextDocumentModel.class, JavaScriptObject.class,
                Constants.HTML_TEXTAREA_VARIANT_ID,
                new HTMLTextAreaBindingFactory());

        logger.info("HTMLTextArea binding for SimpleTextDcumentModel module loaded.");
    }
}
