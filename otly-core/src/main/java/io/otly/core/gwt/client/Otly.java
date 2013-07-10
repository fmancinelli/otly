package io.otly.core.gwt.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import io.otly.api.gwt.shared.Document;
import io.otly.core.gwt.shared.internal.DocumentModelFactoryRegistry;
import io.otly.spi.gwt.shared.DocumentModelFactory;

/**
 * Core entry point in JavaScript land.
 *
 * Pure JavaScript client can instantiate an object of this class to have access to Core functionality.
 *
 * @version $Id$
 */
@ExportPackage("otly")
@Export
public class Otly implements Exportable
{
    public Otly()
    {
    }

    /**
     * Open a real-time document. It returns a {@link Document} object that can be bound to a target in order to
     * interact with it.
     *
     * @param type the real-time document type.
     * @return the real-time document.
     */
    public Document open(String type)
    {
        DocumentModelFactoryRegistry documentModelFactoryRegistry = DocumentModelFactoryRegistry.getInstance();
        DocumentModelFactory documentModelFactory = documentModelFactoryRegistry.getFactory(type);

        if (documentModelFactory != null) {
            return documentModelFactory.createDocumentModel();
        }

        return null;
    }
}
