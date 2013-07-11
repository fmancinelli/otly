package io.otly.binding.simpletext.internal;

import javax.swing.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.otly.api.gwt.shared.util.binding.PlainTextDocument;
import io.otly.binding.simpletext.gwt.shared.internal.PlainTextDocumentBindingFactory;
import io.otly.core.Core;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * PlainTextDocument binding for SimpleTextDocumentModel test.
 *
 * @version $Id$
 */
public class TestPlainTextDocumentBinding
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
                .getBindingFactory(SimpleTextDocumentModel.class, PlainTextDocument.class);

        assertNotNull(bindingFactory);
        assertEquals(PlainTextDocumentBindingFactory.class, bindingFactory.getClass());
    }
}
