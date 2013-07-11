package io.otly.binding.simpletext.internal;

import javax.swing.*;

import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;
import io.otly.spi.gwt.shared.DocumentModel;

/**
 * JTextAreaBindingFactory.
 *
 * @version $Id$
 */
public class JTextAreaBindingFactory implements BindingFactory
{
    @Override public <T> void createBinding(DocumentModel documentModel, T target)
    {

    }

    @Override public Class getDocumentModelType()
    {
        return SimpleTextDocumentModel.class;
    }

    @Override public Class getTargetType()
    {
        return JTextArea.class;
    }

    @Override public String getTargetVariant()
    {
        return null;
    }
}
