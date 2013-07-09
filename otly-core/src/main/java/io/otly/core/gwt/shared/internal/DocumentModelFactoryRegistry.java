package io.otly.core.gwt.shared.internal;

import java.util.HashMap;
import java.util.Map;

import io.otly.spi.gwt.shared.DocumentModelFactory;

/**
 * DocumentModelFactoryRegistry.
 *
 * @version $Id$
 */
public class DocumentModelFactoryRegistry
{
    private final static DocumentModelFactoryRegistry INSTANCE = new DocumentModelFactoryRegistry();

    private Map<String, DocumentModelFactory> typeToDocumentModelFactoryMap;

    protected DocumentModelFactoryRegistry()
    {
        typeToDocumentModelFactoryMap = new HashMap<String, DocumentModelFactory>();
    }

    public void registerDocumentModelFactory(String type, DocumentModelFactory factory)
    {
        typeToDocumentModelFactoryMap.put(type, factory);
    }

    public DocumentModelFactory getFactory(String type)
    {
        return typeToDocumentModelFactoryMap.get(type);
    }

    public static DocumentModelFactoryRegistry getInstance()
    {
        return INSTANCE;
    }
}
