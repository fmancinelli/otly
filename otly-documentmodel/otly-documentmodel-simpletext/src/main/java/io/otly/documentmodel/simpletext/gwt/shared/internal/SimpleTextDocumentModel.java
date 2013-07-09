package io.otly.documentmodel.simpletext.gwt.shared.internal;

import java.util.ArrayList;
import java.util.List;

import org.timepedia.exporter.client.Export;

import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.DeleteCharOperation;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.InsertCharOperation;
import io.otly.spi.gwt.shared.BindingFactory;
import io.otly.spi.gwt.shared.DocumentModel;
import io.otly.spi.gwt.shared.DocumentModelChangeListener;
import io.otly.spi.gwt.shared.Operation;
import io.otly.spi.gwt.shared.Transformer;

/**
 * SimpleTextDocumentModel.
 *
 * @version $Id$
 */
public class SimpleTextDocumentModel implements DocumentModel
{
    /**
     * The content.
     */
    private String content;

    /**
     * The transformer.
     */
    private Transformer transformer;

    /**
     * The list of listeners to be notified of document model changes.
     */
    private List<DocumentModelChangeListener> documentModelChangeListeners;

    /**
     * This is needed by GWT for exporting.
     */
    protected SimpleTextDocumentModel()
    {
        transformer = new CharOperationTransformer();
        documentModelChangeListeners = new ArrayList<DocumentModelChangeListener>();
    }

    /**
     * Constructor.
     *
     * @param content the initial content.
     */
    public SimpleTextDocumentModel(String content)
    {
        this();

        this.content = content;
    }

    @Override public void apply(Operation op)
    {
        if (op instanceof InsertCharOperation) {
            applyInsert((InsertCharOperation) op);
        } else if (op instanceof DeleteCharOperation) {
            applyDelete((DeleteCharOperation) op);
        }

        notifyDocumentChangeListeners(op);
    }

    /**
     * Apply an insert operation.
     *
     * @param op the insert operation.
     */
    private void applyInsert(InsertCharOperation op)
    {
        if (op.getPosition() < 0 || op.getPosition() > content.length()) {
            throw new IllegalArgumentException("Invalid position");
        }

        StringBuffer sb = new StringBuffer(content);
        sb.insert(op.getPosition(), op.getChar());

        content = sb.toString();
    }

    /**
     * Apply a delete operation.
     *
     * @param op the delete operation.
     */
    private void applyDelete(DeleteCharOperation op)
    {
        if (op.getPosition() < 0 || op.getPosition() >= content.length()) {
            throw new IllegalArgumentException("Invalid position");
        }

        StringBuffer sb = new StringBuffer(content);
        sb.deleteCharAt(op.getPosition());

        content = sb.toString();
    }

    @Override public void addDocumentModelChangeListener(DocumentModelChangeListener documentModelChangeListener)
    {
        if (!documentModelChangeListeners.contains(documentModelChangeListener)) {
            documentModelChangeListeners.add(documentModelChangeListener);
        }
    }

    @Override public void removeDocumentModelChangeListener(DocumentModelChangeListener documentModelChangeListener)
    {
        documentModelChangeListeners.remove(documentModelChangeListener);
    }

    private void notifyDocumentChangeListeners(Operation op)
    {
        for (DocumentModelChangeListener documentModelChangeListener : documentModelChangeListeners) {
            documentModelChangeListener.onDocumentModelChange(op);
        }
    }

    @Override public Transformer getTransformer()
    {
        return transformer;
    }

    @Override public String toString()
    {
        return content;
    }

    @Export
    @Override public <T> void bind(T target, String variant)
    {
        DocumentModelBindingFactoryRegistry documentModelBindingFactoryRegistry =
                DocumentModelBindingFactoryRegistry.getInstance();
        BindingFactory bindingFactory = null;

        if (variant == null) {
            bindingFactory = documentModelBindingFactoryRegistry.getBindingFactory(this.getClass(), target.getClass());
        } else {
            bindingFactory =
                    documentModelBindingFactoryRegistry.getBindingFactory(this.getClass(), target.getClass(), variant);
        }

        if (bindingFactory != null) {
            bindingFactory.createBinding(this, target);
        }
    }

    /**
     * This is used for testing purposes.
     *
     * @return the document content.
     */
    protected String getContent()
    {
        return content;
    }
}
