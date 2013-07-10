package io.otly.core.gwt.shared.internal;

import java.util.Collection;
import java.util.Collections;
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
    /**
     * The singleton instance.
     */
    private final static DocumentModelFactoryRegistry INSTANCE = new DocumentModelFactoryRegistry();

    /**
     * The registry. It maps document models' type ids to document model factories.
     */
    private Map<String, DocumentModelFactory> typeIdToDocumentModelFactoryMap;

    /**
     * Constructor.
     */
    protected DocumentModelFactoryRegistry()
    {
        typeIdToDocumentModelFactoryMap = new HashMap<String, DocumentModelFactory>();
    }

    /**
     * Register a document model factory.
     *
     * @param typeId the document model type id.
     * @param factory the factory for the document model with the given type id.
     */
    public void registerDocumentModelFactory(String typeId, DocumentModelFactory factory)
    {
        typeIdToDocumentModelFactoryMap.put(typeId, factory);
    }

    /**
     * Get a document model factory.
     *
     * @param typeId the type id of the document model the factory should be able to create.
     */
    public DocumentModelFactory getFactory(String typeId)
    {
        return typeIdToDocumentModelFactoryMap.get(typeId);
    }

    /**
     * @return the registered document model factories.
     */
    public Collection<DocumentModelFactory> getRegisteredDocumentModelFactories()
    {
        return Collections.unmodifiableCollection(typeIdToDocumentModelFactoryMap.values());
    }

    /**
     * @return the shared instance.
     */
    public static DocumentModelFactoryRegistry getInstance()
    {
        return INSTANCE;
    }
}
