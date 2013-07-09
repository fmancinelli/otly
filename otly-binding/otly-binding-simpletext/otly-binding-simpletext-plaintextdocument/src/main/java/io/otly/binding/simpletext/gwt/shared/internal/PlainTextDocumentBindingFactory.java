package io.otly.binding.simpletext.gwt.shared.internal;

import java.util.logging.Logger;

import io.otly.api.gwt.shared.util.binding.PlainTextDocument;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;
import io.otly.spi.gwt.shared.DocumentModel;

/**
 * The factory for creating a binding between a SimpleTextDocumentModel and a PlainTextDocument.
 *
 * @version $Id$
 */
public class PlainTextDocumentBindingFactory implements BindingFactory
{
    protected Logger logger = Logger.getLogger(PlainTextDocumentBindingFactory.class.getName());

    @Override public <T> void createBinding(DocumentModel documentModel, T target)
    {
        if ((documentModel instanceof SimpleTextDocumentModel) && (target instanceof PlainTextDocument)) {
            new PlainTextDocumentBinding((SimpleTextDocumentModel) documentModel,
                    (PlainTextDocument) target);
        }
    }
}
