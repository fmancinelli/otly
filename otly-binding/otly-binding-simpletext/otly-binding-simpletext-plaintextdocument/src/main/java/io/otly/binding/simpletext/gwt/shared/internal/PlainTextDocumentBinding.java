package io.otly.binding.simpletext.gwt.shared.internal;

import java.util.logging.Logger;

import org.timepedia.exporter.client.Export;

import io.otly.api.gwt.shared.util.binding.PlainTextDocument;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;

/**
 * This binding defines interactions between a SimpleTextDocumentModel and a PlainTextDocument.
 *
 * @version $Id$
 */
@Export
public class PlainTextDocumentBinding implements PlainTextDocument.ContentChangeListener
{
    /**
     * The bound document model.
     */
    private final SimpleTextDocumentModel simpleTextDocumentModel;

    /**
     * The bound plain text document.
     */
    private final PlainTextDocument plainTextDocument;

    /**
     * The logger.
     */
    private Logger logger = Logger.getLogger(PlainTextDocumentBinding.class.getName());

    /**
     * Constructor.
     *
     * @param simpleTextDocumentModel the bound document model.
     * @param plainTextDocument the bound plain text document.
     */
    public PlainTextDocumentBinding(SimpleTextDocumentModel simpleTextDocumentModel,
            PlainTextDocument plainTextDocument)
    {
        this.simpleTextDocumentModel = simpleTextDocumentModel;
        this.plainTextDocument = plainTextDocument;

        plainTextDocument.addContentChangeListener(this);
    }

    @Override public void onContentChange(String content)
    {
        //TODO: Here is where the action should happen.
        logger.info("New content: " + content);
    }
}
