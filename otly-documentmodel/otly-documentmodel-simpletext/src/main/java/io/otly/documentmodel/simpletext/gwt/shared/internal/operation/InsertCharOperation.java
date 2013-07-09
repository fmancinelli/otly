package io.otly.documentmodel.simpletext.gwt.shared.internal.operation;

import io.otly.spi.gwt.shared.Operation;

/**
 * InsertCharOperation.
 *
 * @version $Id$
 */
public class InsertCharOperation implements Operation
{
    int position;

    char character;

    /**
     * This is needed by GWT for exporting.
     */
    protected InsertCharOperation()
    {
    }

    public InsertCharOperation(int position, char character)
    {
        this.position = position;
        this.character = character;
    }

    public char getChar()
    {
        return character;
    }

    public int getPosition()
    {
        return position;
    }
}
