package io.otly.core.gwt.shared.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.otly.spi.gwt.shared.BindingFactory;

/**
 * This registry is used to dynamically register binding factories available in the framework. Usually it is called by
 * the module initialization code where the binding is defined.
 *
 * @version $Id$
 */
public class DocumentModelBindingFactoryRegistry
{
    /**
     * The singleton instance.
     */
    private static final DocumentModelBindingFactoryRegistry INSTANCE = new DocumentModelBindingFactoryRegistry();

    /**
     * The default variant id.
     */
    private static final String DEFAULT_VARIANT_ID = "default";

    /**
     * The registry. It maps ids to Binding factories. The id is generated based on the binding attributes (i.e., the
     * DocumentModel type, the target type and the variant)
     */
    private Map<String, BindingFactory> idToBindingFactoryMap;

    /**
     * Constructor
     */
    protected DocumentModelBindingFactoryRegistry()
    {
        idToBindingFactoryMap = new HashMap<String, BindingFactory>();
    }

    /**
     * Register a binding.
     *
     * @param documentModelClass the document model type.
     * @param targetClass the target type.
     * @param bindingFactory the binding factory.
     */
    public void registerBinding(Class<?> documentModelClass, Class<?> targetClass,
            BindingFactory bindingFactory)
    {
        idToBindingFactoryMap.put(getId(documentModelClass, targetClass, DEFAULT_VARIANT_ID), bindingFactory);
    }

    /**
     * Register a binding.
     *
     * @param documentModelClass the document model type.
     * @param targetClass the target type.
     * @param variant the variant. null for default variant.
     * @param bindingFactory the binding factory.
     */
    public void registerBinding(Class<?> documentModelClass, Class<?> targetClass, String variant,
            BindingFactory bindingFactory)
    {
        idToBindingFactoryMap
                .put(getId(documentModelClass, targetClass, variant != null ? variant : DEFAULT_VARIANT_ID),
                        bindingFactory);
    }

    /**
     * Get a binding factory.
     *
     * @param documentModelClass the document model type.
     * @param targetClass the target type.
     * @return the binding factory.
     */
    public BindingFactory getBindingFactory(Class<?> documentModelClass, Class<?> targetClass)
    {
        return getBindingFactory(documentModelClass, targetClass, DEFAULT_VARIANT_ID);
    }

    /**
     * Get a binding factory.
     *
     * @param documentModelClass the document model type.
     * @param targetClass the target type.
     * @param variant the variant.
     * @return the binding factory.
     */
    public BindingFactory getBindingFactory(Class<?> documentModelClass, Class<?> targetClass, String variant)
    {
        return idToBindingFactoryMap.get(getId(documentModelClass, targetClass, variant));
    }

    public Collection<BindingFactory> getRegisteredBindingFactories()
    {
        return Collections.unmodifiableCollection(idToBindingFactoryMap.values());
    }

    /**
     * Generate an id for describing a binding in the registry.
     *
     * @param documentModelClass the document model type.
     * @param targetClass the target type.
     * @param variant the variant.
     * @return an id corresponding to the binding description.
     */
    protected String getId(Class<?> documentModelClass, Class<?> targetClass, String variant)
    {
        return documentModelClass.getName() + "#" + targetClass.getName() + "#" + variant;
    }

    /**
     * @return the shared instance.
     */
    public static DocumentModelBindingFactoryRegistry getInstance()
    {
        return INSTANCE;
    }
}
