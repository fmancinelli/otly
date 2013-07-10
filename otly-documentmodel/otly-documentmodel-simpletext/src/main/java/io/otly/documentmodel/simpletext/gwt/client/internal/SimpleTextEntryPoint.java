package io.otly.documentmodel.simpletext.gwt.client.internal;

import java.util.logging.Logger;

import io.otly.core.gwt.shared.internal.DocumentModelFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModelFactory;
import io.otly.documentmodel.simpletext.gwt.shared.internal.Constants;

/**
 * SimpleTextDocumentModelEntryPoint.
 *
 * @version $Id$
 */
public class SimpleTextEntryPoint implements com.google.gwt.core.client.EntryPoint
{
    private Logger logger = Logger.getLogger(SimpleTextEntryPoint.class.getName());

    public void onModuleLoad()
    {
        logger.fine("Registering Simple Text document model factory.");
        DocumentModelFactoryRegistry documentModelFactoryRegistry = DocumentModelFactoryRegistry.getInstance();
        documentModelFactoryRegistry.registerDocumentModelFactory(Constants.SIMPLE_TEXT_DOCUMENT_MODEL_TYPE_ID,
                new SimpleTextDocumentModelFactory());

        logger.info("Simple Text document model module loaded.");
    }
}
