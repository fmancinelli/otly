package io.otly.documentmodel.simpletext.gwt.shared.internal;

import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.InsertCharOperation;
import io.otly.spi.gwt.shared.Operation;
import io.otly.spi.gwt.shared.OperationPair;
import io.otly.spi.gwt.shared.Transformer;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.DeleteCharOperation;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.NoOperation;

/**
 * CharOperationTransformer.
 *
 * This class defines transformation for character based operations.
 *
 * @version $Id$
 */
public class CharOperationTransformer implements Transformer
{
    /**
     * This is needed by GWT for exporting.
     */
    public CharOperationTransformer()
    {
    }

    @Override public OperationPair transform(Operation left, Operation right, Priority priority)
    {
        if (left instanceof InsertCharOperation) {
            if (right instanceof InsertCharOperation) {
                return transformInsertInsert((InsertCharOperation) left, (InsertCharOperation) right, priority);
            } else if (right instanceof DeleteCharOperation) {
                return transformInsertDelete((InsertCharOperation) left, (DeleteCharOperation) right);
            } else {
                return new OperationPair(left, right);
            }
        } else if (left instanceof DeleteCharOperation) {
            if (right instanceof InsertCharOperation) {
                return transformDeleteInsert((DeleteCharOperation) left, (InsertCharOperation) right);
            } else if (right instanceof DeleteCharOperation) {
                return transformDeleteDelete((DeleteCharOperation) left, (DeleteCharOperation) right);
            } else {
                return new OperationPair(left, right);
            }
        } else {
            return new OperationPair(left, right);
        }
    }

    /**
     * Transform a delete/delete operation pair.
     *
     * @param left left operation.
     * @param right right operation.
     * @return the transformed operations.
     */
    private OperationPair transformDeleteDelete(DeleteCharOperation left, DeleteCharOperation right)
    {
        if (left.getPosition() == right.getPosition()) {
            return new OperationPair(new NoOperation(), new NoOperation());
        } else if (left.getPosition() < right.getPosition()) {
            return new OperationPair(left, new DeleteCharOperation(right.getPosition() - 1));
        } else {
            return new OperationPair(new DeleteCharOperation(left.getPosition() - 1), right);
        }
    }

    /**
     * Transform a delete/insert operation pair.
     *
     * @param left left operation.
     * @param right right operation.
     * @return the transformed operations.
     */
    private OperationPair transformDeleteInsert(DeleteCharOperation left, InsertCharOperation right)
    {
        if (left.getPosition() < right.getPosition()) {
            return new OperationPair(left, new InsertCharOperation(right.getPosition() - 1, right.getChar()));
        } else {
            return new OperationPair(new DeleteCharOperation(left.getPosition() + 1), right);
        }
    }

    /**
     * Transform an insert/insert operation pair.
     *
     * @param left left operation.
     * @param right right operation.
     * @return the transformed operations.
     */
    private OperationPair transformInsertInsert(InsertCharOperation left, InsertCharOperation right, Priority priority)
    {
        if (left.getPosition() == right.getPosition()) {
            if (Priority.LEFT.equals(priority)) {
                return new OperationPair(left, new InsertCharOperation(right.getPosition() + 1, right.getChar()));
            } else {
                return new OperationPair(new InsertCharOperation(left.getPosition() + 1, left.getChar()), right);
            }
        } else if (left.getPosition() < right.getPosition()) {
            return new OperationPair(left, new InsertCharOperation(right.getPosition() + 1, right.getChar()));
        } else {
            return new OperationPair(new InsertCharOperation(left.getPosition() + 1, left.getChar()), right);
        }
    }

    /**
     * Transform an insert/delete operation pair.
     *
     * @param left left operation.
     * @param right right operation.
     * @return the transformed operations.
     */
    private OperationPair transformInsertDelete(InsertCharOperation left, DeleteCharOperation right)
    {
        if (left.getPosition() <= right.getPosition()) {
            return new OperationPair(left, new DeleteCharOperation(right.getPosition() + 1));
        } else {
            return new OperationPair(new InsertCharOperation(left.getPosition() - 1, left.getChar()), right);
        }
    }
}
