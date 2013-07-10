package io.otly.test;

import org.junit.BeforeClass;
import org.junit.Test;

import io.otly.core.Core;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.core.gwt.shared.internal.DocumentModelFactoryRegistry;

import static org.junit.Assert.assertFalse;

/**
 * TestRegistryInitialization.
 *
 * @version $Id$
 */
public class TestRegistryInitialization
{
    @BeforeClass
    public static void init()
    {
        Core.init();
    }

    @Test
    public void testDocumentModelBindingRegistry()
    {
        DocumentModelBindingFactoryRegistry documentModelBindingFactoryRegistry =
                DocumentModelBindingFactoryRegistry.getInstance();

        assertFalse(documentModelBindingFactoryRegistry.getRegisteredBindingFactories().isEmpty());
    }

    @Test
    public void testDocumentModelRegistry()
    {
        DocumentModelFactoryRegistry documentModelFactoryRegistry = DocumentModelFactoryRegistry.getInstance();

        assertFalse(documentModelFactoryRegistry.getRegisteredDocumentModelFactories().isEmpty());
    }
}
