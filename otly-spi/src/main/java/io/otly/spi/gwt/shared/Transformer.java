package io.otly.spi.gwt.shared;

/**
 * Transformer.
 *
 * This is the interface for operational transformation. Implementations defines the ways to to fixup operations that
 * diverge from previously synchronized states.
 *
 * transform(left, right) = (left', right') | (left ∘ right') = (right ∘ left')
 *
 * <pre>
 *           *
 *          / \
 *    left /   \ right
 *        /     \
 *       *       *
 *        \     /
 *  right' \   / left'
 *          \ /
 *           *
 * </pre>
 *
 * @version $Id$
 */
public interface Transformer
{
    /**
     * This enum defines which operation has the priority in conflicting states. This is the case, for example, when two
     * operations insert a different character at the same location.
     */
    enum Priority
    {
        LEFT,
        RIGHT
    }

    /**
     * Transform a pair of operations.
     *
     * @param left 'left' operation (usually the local operation)
     * @param right 'right' operation (usually the operation coming from the remote side)
     * @param priority the operation that has the priority in case of conflict
     * @return the transformed operations (left', right') that satisfy the equation: transform(left, right) = (left',
     *         right') | (left ∘ right') = (right ∘ left')
     */
    OperationPair transform(Operation left, Operation right, Priority priority);
}
