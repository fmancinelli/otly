package io.otly.api.gwt.shared.util.binding;

import java.util.ArrayList;
import java.util.List;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This class implements a modifiable plain text document that can be bound to a document model for actually interacting
 * with it.
 *
 * @version $Id$
 */
@ExportPackage("otly")
@Export
public class PlainTextDocument implements Exportable
{
    /**
     * A change listener interface for notifying clients of changes in the document's content.
     */
    public static interface ContentChangeListener
    {
        /**
         * This method is called to notify a client that the document content has changed.
         *
         * @param content the current document content.
         */
        void onContentChange(String content);
    }

    /**
     * The current content.
     */
    protected StringBuffer content;

    /**
     * The list of listeners registered on this document.
     */
    protected List<ContentChangeListener> contentChangeListeners = new ArrayList<ContentChangeListener>();

    /**
     * Constructor.
     */
    public PlainTextDocument()
    {
        content = new StringBuffer("");
    }

    /**
     * Insert a character at a given position.
     *
     * @param c the character to insert.
     * @param position the 0-based position where to insert the character.
     */
    public void insert(char c, int position)
    {
        content.setCharAt(position, c);
        fireContentChange();
    }

    /**
     * Insert a string at a given position.
     *
     * @param s the string to insert.
     * @param position the 0-based position where to insert the string.
     */
    public void insert(String s, int position)
    {
        content.insert(position, s);
        fireContentChange();
    }

    /**
     * Remove a character from the given position.
     *
     * @param position the 0-based position to remove the character from.
     */
    public void remove(int position)
    {
        content.deleteCharAt(position);
        fireContentChange();
    }

    /**
     * Remove characters from the given range
     *
     * @param startPosition the 0-based start position of the range to remove characters from.
     * @param endPosition the 0-based end position of the range to remove characters from.
     */
    public void remove(int startPosition, int endPosition)
    {
        content.delete(startPosition, endPosition);
        fireContentChange();
    }

    /**
     * @return the content of the document.
     */
    public String getContent()
    {
        return content.toString();
    }

    /**
     * Set the content of the document.
     *
     * @param content the new document content.
     */
    public void setContent(String content)
    {
        this.content = new StringBuffer(content);
        fireContentChange();
    }

    /**
     * Add a content change listener for being notified when the document content changes.
     *
     * @param listener the listener to be added.
     */
    public void addContentChangeListener(ContentChangeListener listener)
    {
        contentChangeListeners.add(listener);
    }

    /**
     * Remove a content change listener.
     *
     * @param listener the listener to be removed.
     */
    public void removeContentChangeListener(ContentChangeListener listener)
    {
        contentChangeListeners.remove(listener);
    }

    /**
     * Notify registered listeners of a content change.
     */
    protected void fireContentChange()
    {
        for (ContentChangeListener listener : contentChangeListeners) {
            listener.onContentChange(content.toString());
        }
    }
}
