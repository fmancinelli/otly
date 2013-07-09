package io.otly.binding.simpletext.gwt.client.internal;

import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;

import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;
import io.otly.spi.gwt.shared.DocumentModel;

/**
 * The factory for creating a binding between a SimpleTextDocumentModel and a PlainTextDocument.
 *
 * @version $Id$
 */
public class HTMLTextAreaBindingFactory implements BindingFactory
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(HTMLTextAreaBindingFactory.class.getName());

    @Override public <T> void createBinding(DocumentModel documentModel, T target)
    {
        if ((documentModel instanceof SimpleTextDocumentModel) && (target instanceof JavaScriptObject)) {
            new HTMLTextAreaBinding((SimpleTextDocumentModel) documentModel, (HTMLTextArea) target);
        }
    }
}
