package io.otly.spi.gwt.shared;

import io.otly.api.gwt.shared.Document;

/**
 * This interface represents a document model, i.e., a model that is able to apply operations of a given type for
 * modifying its content. Document models are used by the synchronization algorithm to reflect the state of the document
 * to be synchronized.
 *
 * Providers can extend OTLY by implementing this interface and registering their implementations, in order to make
 * clients able to use it.
 *
 * @version $Id$
 */
public interface DocumentModel extends Document
{
    /**
     * Modify the content by applying an operation.
     *
     * @param op the operation to be applied.
     */
    void apply(Operation op);

    /**
     * Register a change listener that gets called whenever the document model is modified.
     *
     * @param documentModelChangeListener the change listener to add.
     */
    void addDocumentModelChangeListener(DocumentModelChangeListener documentModelChangeListener);

    /**
     * Remove a change listener.
     *
     * @param documentModelChangeListener the change listener to remove.
     */
    void removeDocumentModelChangeListener(DocumentModelChangeListener documentModelChangeListener);

    /**
     * Get the transformer for transforming operations associated to this model. The transformer is needed for
     * implementing the Operational Transformation algorithm.
     */
    Transformer getTransformer();
}
