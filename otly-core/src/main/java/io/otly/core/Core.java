package io.otly.core;

import java.util.ServiceLoader;

import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.core.gwt.shared.internal.DocumentModelFactoryRegistry;
import io.otly.spi.gwt.shared.BindingFactory;
import io.otly.spi.gwt.shared.DocumentModelFactory;

/**
 * This class is used to initialize the Core framework from Java-land.
 *
 * @version $Id$
 */
public class Core
{
    public static void init()
    {
        DocumentModelFactoryRegistry documentModelFactoryRegistry = DocumentModelFactoryRegistry.getInstance();

        ServiceLoader<DocumentModelFactory> documentModelFactoryLoader = ServiceLoader.load(DocumentModelFactory.class);
        for (DocumentModelFactory documentModelFactory : documentModelFactoryLoader) {
            documentModelFactoryRegistry
                    .registerDocumentModelFactory(documentModelFactory.getDocumentModelTypeId(), documentModelFactory);
        }

        DocumentModelBindingFactoryRegistry bindingFactoryRegistry = DocumentModelBindingFactoryRegistry.getInstance();

        ServiceLoader<BindingFactory> bindingFactoryLoader = ServiceLoader.load(BindingFactory.class);
        for (BindingFactory bindingFactory : bindingFactoryLoader) {
            bindingFactoryRegistry
                    .registerBinding(bindingFactory.getDocumentModelType(), bindingFactory.getTargetType(),
                            bindingFactory.getTargetVariant(), bindingFactory);
        }
    }
}
