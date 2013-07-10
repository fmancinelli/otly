package io.otly.documentmodel.simpletext.gwt.shared.internal;

import io.otly.spi.gwt.shared.DocumentModelFactory;
import io.otly.spi.gwt.shared.DocumentModel;

/**
 * SimpleTextDocumentModelFactory.
 *
 * @version $Id$
 */
public class SimpleTextDocumentModelFactory implements DocumentModelFactory
{
    @Override public String getDocumentModelTypeId()
    {
        return Constants.SIMPLE_TEXT_DOCUMENT_MODEL_TYPE_ID;
    }

    @Override public DocumentModel createDocumentModel()
    {
        return new SimpleTextDocumentModel();
    }
}
