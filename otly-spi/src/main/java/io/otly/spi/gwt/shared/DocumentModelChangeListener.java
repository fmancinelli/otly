package io.otly.spi.gwt.shared;

/**
 * Defines an object that listens for document model changes.
 *
 * @version $Id$
 */
public interface DocumentModelChangeListener
{
    /**
     * Invoked when an operation is applied to the document model.
     *
     * @param op the applied operation.
     */
    void onDocumentModelChange(Operation op);
}
