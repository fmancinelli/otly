package io.otly.binding.simpletext.gwt.client.internal;

import java.util.logging.Logger;

import org.timepedia.exporter.client.Export;

import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;

/**
 * This binding defines interactions between a SimpleTextDocumentModel and an HTMLTextArea.
 *
 * @version $Id$
 */
@Export
public class HTMLTextAreaBinding implements KeyUpEventListener
{
    /**
     * The bound document model.
     */
    private final SimpleTextDocumentModel simpleTextDocumentModel;

    /**
     * The bound plain text document.
     */
    private final HTMLTextArea htmlTextArea;

    /**
     * The logger.
     */
    private Logger logger = Logger.getLogger(HTMLTextAreaBinding.class.getName());

    /**
     * Constructor.
     *
     * @param simpleTextDocumentModel the bound document model.
     * @param htmlTextArea the bound html text area.
     */
    public HTMLTextAreaBinding(SimpleTextDocumentModel simpleTextDocumentModel,
            HTMLTextArea htmlTextArea)
    {
        this.simpleTextDocumentModel = simpleTextDocumentModel;
        this.htmlTextArea = htmlTextArea;

        htmlTextArea.addKeyUpEventListener(this);
    }

    @Override public void onKeyUp()
    {
        //TODO: Here is where the action should happen.
        logger.info("New content: " + htmlTextArea.getContent());
    }
}
