package io.otly.api.gwt.shared;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * A document exposes the API for interacting with real-time documents.
 *
 * @version $Id$
 */
@Export
public interface Document extends Exportable
{
    /**
     * Bind the document to a target object so that the target object can be used to change and reflect changes to the
     * underlying DocumentModel.
     *
     * @param target the target object.
     * @param variant the variant to be used. null for the "default" variant. This parameter is used when the target's
     * type is not enough for understanding the actual implementation of the target. This happens usually in JavaScript
     * land where everything is seen as a {@link com.google.gwt.core.client.JavaScriptObject} and additional information
     * is needed for understanding the actual implementation. This information is provided by the variant parameter.
     * @param <T> the target's type.
     */
    <T> void bind(T target, String variant);
}
