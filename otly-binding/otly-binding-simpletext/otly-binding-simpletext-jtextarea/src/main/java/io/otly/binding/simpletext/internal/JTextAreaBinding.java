package io.otly.binding.simpletext.internal;

import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;

/**
 * JTextAreaBinding.
 *
 * @version $Id$
 */
public class JTextAreaBinding implements DocumentListener
{
    private final SimpleTextDocumentModel simpleTextDocumentModel;

    private final JTextArea jTextArea;

    /**
     * The logger.
     */
    private Logger logger = Logger.getLogger(JTextAreaBinding.class.getName());

    public JTextAreaBinding(SimpleTextDocumentModel simpleTextDocumentModel, JTextArea jTextArea)
    {
        this.simpleTextDocumentModel = simpleTextDocumentModel;
        this.jTextArea = jTextArea;

        jTextArea.getDocument().addDocumentListener(this);
    }

    @Override public void changedUpdate(DocumentEvent e)
    {
        //TODO: Here is where the action should happen.
        logger.info("New content: " + jTextArea.getText());
    }

    @Override public void insertUpdate(DocumentEvent e)
    {
        //TODO: Here is where the action should happen.
        logger.info("New content: " + jTextArea.getText());
    }

    @Override public void removeUpdate(DocumentEvent e)
    {
        //TODO: Here is where the action should happen.
        logger.info("New content: " + jTextArea.getText());
    }
}
