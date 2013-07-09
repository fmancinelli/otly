package io.otly.spi.gwt.shared;

/**
 * An utility class for packing two operations into a single object. This is used by the {@link
 * Transformer#transform(Operation, Operation, Transformer.Priority)}.
 *
 * The 'left', 'right' convention is taken from the usual way of representing local/remote operations in OT diagrams.
 *
 * 'Left' operations are usually associated to locally-generated operations, while 'right' operations are those received
 * by a remote server.
 *
 * @version $Id$
 */
public class OperationPair
{
    /**
     * Left operation.
     */
    private Operation left;

    /**
     * Right operation.
     */
    private Operation right;

    /**
     * Constructor.
     *
     * @param left the left operation.
     * @param right the right operation.
     */
    public OperationPair(Operation left, Operation right)
    {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the left operation.
     */
    public Operation getLeft()
    {
        return left;
    }

    /**
     * @return the right operation.
     */
    public Operation getRight()
    {
        return right;
    }
}
