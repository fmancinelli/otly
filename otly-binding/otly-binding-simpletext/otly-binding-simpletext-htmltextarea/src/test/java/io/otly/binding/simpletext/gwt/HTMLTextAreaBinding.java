package io.otly.binding.simpletext.gwt;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.junit.client.GWTTestCase;

import io.otly.binding.simpletext.gwt.client.internal.Constants;
import io.otly.binding.simpletext.gwt.client.internal.HTMLTextAreaBindingEntryPoint;
import io.otly.binding.simpletext.gwt.client.internal.HTMLTextAreaBindingFactory;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;
import io.otly.spi.gwt.shared.BindingFactory;

/**
 * HTMLTextAreaBinding.
 *
 * @version $Id$
 */
public class HTMLTextAreaBinding extends GWTTestCase
{
    protected HTMLTextAreaBindingEntryPoint htmlTextAreaBindingEntryPoint;

    //Static initialization block.
    {
        htmlTextAreaBindingEntryPoint = new HTMLTextAreaBindingEntryPoint();
        htmlTextAreaBindingEntryPoint.onModuleLoad();
    }

    @Override public String getModuleName()
    {
        return "io.otly.binding.simpletext.HTMLTextAreaBinding";
    }

    @Test
    public void testRegistration()
    {
        BindingFactory bindingFactory = DocumentModelBindingFactoryRegistry.getInstance()
                .getBindingFactory(SimpleTextDocumentModel.class, JavaScriptObject.class,
                        Constants.HTML_TEXTAREA_VARIANT_ID);

        assertNotNull(bindingFactory);
        assertEquals(HTMLTextAreaBindingFactory.class, bindingFactory.getClass());
    }
}
