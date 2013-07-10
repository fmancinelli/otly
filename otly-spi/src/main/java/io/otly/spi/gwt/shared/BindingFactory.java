package io.otly.spi.gwt.shared;

/**
 * This interface is used to create a binding between a DocumentModel and a generic target. The supported targets
 * depends on the loaded modules that define the binding mechanism.
 *
 * A binding is the bridge between a DocumentModel which has its own inner mechanism and representations, and an object
 * that is used to manipulate the content (which has its own mechanism and representations as well). The binding takes
 * care to reflect changes in the target object into the DocumentModel by generating the corresponding operations, and
 * to reflect changes in the DocumentModel (e.g., those received by a remote server) into the target object.
 *
 * The target object can be whatever object, e.g. an HTML text area, a WYSIWYG editor, or a simple string document that
 * provides methods for changing its content (e.g., see {@link io.otly.api.gwt.shared.util.binding.PlainTextDocument}.
 *
 * <b>Implementation note</b>: initially the createBinding method was supposed to return an object of the same type of
 * the target. This object was basically a wrapped version of the target object whose methods delegated calls to the
 * original target while doing all the synchronization on the DocumentModel.
 *
 * This solution was not really suitable because when used in a JavaScript environment, since GWT needs to know the
 * actual classes at compile time, the returned object would be treated as a generic Object with no methods exposed.
 * This would basically render the returned wrapper unusable.
 *
 * In particular, the original idea was to do something like this: boundObject = createBinding(simpleTextDocumentModel,
 * originalPlainTextDocument), but then boundObject would not expose any method which basically makes it useless.
 *
 * So in order to be bound, the target object must expose some notification mechanism that can be used by the binding to
 * understand what has been modified and when. This is usually not a problem for "advanced" targets such as HTML text
 * areas, WYSIWYG editors, etc. which in general support event listeners.
 *
 * This is also the reason why {@link io.otly.api.gwt.shared.util.binding.PlainTextDocument} has been augmented with a
 * notification mechanism.
 *
 * @version $Id$
 */
public interface BindingFactory
{
    Class getDocumentModelType();

    Class getTargetType();

    String getTargetVariant();

    /**
     * Bind a document model to a target.
     *
     * @param documentModel the document model.
     * @param target the target object.
     * @param <T> the target object's type (can be whatever).
     */
    <T> void createBinding(DocumentModel documentModel, T target);
}
