package io.otly.documentmodel.simpletext.gwt.shared.internal.operation;

import io.otly.spi.gwt.shared.Operation;

/**
 * DeleteCharOperation.
 *
 * @version $Id$
 */
public class DeleteCharOperation implements Operation
{
    int position;

    /**
     * This is needed by GWT for exporting.
     */
    protected DeleteCharOperation()
    {
    }

    public DeleteCharOperation(int position)
    {
        this.position = position;
    }

    public int getPosition()
    {
        return position;
    }
}
