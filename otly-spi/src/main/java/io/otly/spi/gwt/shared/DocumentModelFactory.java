package io.otly.spi.gwt.shared;

/**
 * A factory for document model objects.
 *
 * @version $Id$
 */
public interface DocumentModelFactory
{
    /**
     * @return the type id of the document models created by this factory.
     */
    String getDocumentModelTypeId();

    /**
     * @return the document model.
     */
    DocumentModel createDocumentModel();
}
