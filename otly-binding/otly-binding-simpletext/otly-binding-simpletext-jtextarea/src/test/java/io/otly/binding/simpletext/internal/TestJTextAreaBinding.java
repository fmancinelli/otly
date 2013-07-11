package io.otly.binding.simpletext.internal;

import javax.swing.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.otly.core.Core;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * JTextArea binding for SimpleTextDocument test.
 *
 * @version $Id$
 */
public class TestJTextAreaBinding
{
    @BeforeClass
    public static void init()
    {
        Core.init();
    }

    @Test
    public void testRegistration()
    {
        BindingFactory bindingFactory = DocumentModelBindingFactoryRegistry.getInstance()
                .getBindingFactory(SimpleTextDocumentModel.class, JTextArea.class);

        assertNotNull(bindingFactory);
        assertEquals(JTextAreaBindingFactory.class, bindingFactory.getClass());
    }
}
