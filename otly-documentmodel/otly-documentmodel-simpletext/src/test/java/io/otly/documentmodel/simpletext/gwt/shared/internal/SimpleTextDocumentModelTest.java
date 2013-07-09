package io.otly.documentmodel.simpletext.gwt.shared.internal;

import org.junit.Test;

import io.otly.spi.gwt.shared.Operation;
import io.otly.spi.gwt.shared.OperationPair;
import io.otly.spi.gwt.shared.Transformer;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.DeleteCharOperation;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.InsertCharOperation;
import io.otly.documentmodel.simpletext.gwt.shared.internal.operation.NoOperation;

import static org.junit.Assert.assertEquals;

public class SimpleTextDocumentModelTest
{
    private final String INITIAL_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    @Test
    public void testOperations()
    {
        SimpleTextDocumentModel document = new SimpleTextDocumentModel("");
        document.apply(new InsertCharOperation(0, 'H'));
        document.apply(new InsertCharOperation(1, 'e'));
        document.apply(new InsertCharOperation(2, 'l'));
        document.apply(new InsertCharOperation(3, 'l'));
        document.apply(new InsertCharOperation(4, 'o'));
        document.apply(new InsertCharOperation(5, '!'));
        document.apply(new DeleteCharOperation(5));

        assertEquals("Hello", document.getContent());
    }

    @Test
    public void testNOPInsert()
    {
        for (int i = 0; i < INITIAL_CONTENT.length(); i++) {
            /* Start from a synchronized document */
            SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
            SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

            Operation left = new NoOperation();
            Operation right = new InsertCharOperation(i, 'x');

            Transformer transformer = new CharOperationTransformer();

            OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

            leftDocument.apply(left);
            leftDocument.apply(transformedOps.getRight());

            rightDocument.apply(right);
            rightDocument.apply(transformedOps.getLeft());

            assertEquals(leftDocument.getContent(), rightDocument.getContent());
        }
    }

    @Test
    public void testInsertNOP()
    {
        for (int i = 0; i < INITIAL_CONTENT.length(); i++) {
            /* Start from a synchronized document */
            SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
            SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

            Operation left = new InsertCharOperation(i, 'x');
            Operation right = new NoOperation();

            Transformer transformer = new CharOperationTransformer();

            OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

            leftDocument.apply(left);
            leftDocument.apply(transformedOps.getRight());

            rightDocument.apply(right);
            rightDocument.apply(transformedOps.getLeft());

            assertEquals(leftDocument.getContent(), rightDocument.getContent());
        }
    }

    @Test
    public void testNOPDelete()
    {
        for (int i = 0; i < INITIAL_CONTENT.length() - 1; i++) {
            /* Start from a synchronized document */
            SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
            SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

            Operation left = new NoOperation();
            Operation right = new DeleteCharOperation(i);

            Transformer transformer = new CharOperationTransformer();

            OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

            leftDocument.apply(left);
            leftDocument.apply(transformedOps.getRight());

            rightDocument.apply(right);
            rightDocument.apply(transformedOps.getLeft());

            assertEquals(leftDocument.getContent(), rightDocument.getContent());
        }
    }

    @Test
    public void testDeleteNOP()
    {
        for (int i = 0; i < INITIAL_CONTENT.length() - 1; i++) {
            /* Start from a synchronized document */
            SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
            SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

            Operation left = new DeleteCharOperation(i);
            Operation right = new NoOperation();

            Transformer transformer = new CharOperationTransformer();

            OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

            leftDocument.apply(left);
            leftDocument.apply(transformedOps.getRight());

            rightDocument.apply(right);
            rightDocument.apply(transformedOps.getLeft());

            assertEquals(leftDocument.getContent(), rightDocument.getContent());
        }
    }

    @Test
    public void testInsertInsert()
    {
        for (int i = 0; i < INITIAL_CONTENT.length(); i++) {
            for (int j = INITIAL_CONTENT.length(); j >= 0; j--) {
                /* Start from a synchronized document */
                SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
                SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

                Operation left = new InsertCharOperation(i, 'x');
                Operation right = new InsertCharOperation(j, 'y');

                Transformer transformer = new CharOperationTransformer();

                OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

                leftDocument.apply(left);
                leftDocument.apply(transformedOps.getRight());

                rightDocument.apply(right);
                rightDocument.apply(transformedOps.getLeft());

                assertEquals(leftDocument.getContent(), rightDocument.getContent());
            }
        }
    }

    @Test
    public void testDeleteDelete()
    {
        for (int i = 0; i < INITIAL_CONTENT.length(); i++) {
            for (int j = INITIAL_CONTENT.length() - 1; j >= 0; j--) {
                /* Start from a synchronized document */
                SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
                SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

                Operation left = new DeleteCharOperation(i);
                Operation right = new DeleteCharOperation(j);

                Transformer transformer = new CharOperationTransformer();

                OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

                leftDocument.apply(left);
                leftDocument.apply(transformedOps.getRight());

                rightDocument.apply(right);
                rightDocument.apply(transformedOps.getLeft());

                assertEquals(leftDocument.getContent(), rightDocument.getContent());
            }
        }
    }

    @Test
    public void testInsertDelete()
    {
        for (int i = 0; i < INITIAL_CONTENT.length(); i++) {
            for (int j = INITIAL_CONTENT.length() - 1; j >= 0; j--) {
                /* Start from a synchronized document */
                SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
                SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

                Operation left = new InsertCharOperation(i, 'w');
                Operation right = new DeleteCharOperation(j);

                Transformer transformer = new CharOperationTransformer();

                OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

                leftDocument.apply(left);
                leftDocument.apply(transformedOps.getRight());

                rightDocument.apply(right);
                rightDocument.apply(transformedOps.getLeft());

                assertEquals(leftDocument.getContent(), rightDocument.getContent());
            }
        }
    }

    @Test
    public void testDeleteInsert()
    {
        for (int i = 0; i < INITIAL_CONTENT.length() - 1; i++) {
            for (int j = INITIAL_CONTENT.length(); j >= 0; j--) {
                /* Start from a synchronized document */
                SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);
                SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel(INITIAL_CONTENT);

                Operation left = new DeleteCharOperation(i);
                Operation right = new InsertCharOperation(j, 'w');

                Transformer transformer = new CharOperationTransformer();

                OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

                leftDocument.apply(left);
                leftDocument.apply(transformedOps.getRight());

                rightDocument.apply(right);
                rightDocument.apply(transformedOps.getLeft());

                assertEquals(leftDocument.getContent(), rightDocument.getContent());
            }
        }
    }

    @Test
    public void testInsertInsertRightPriority()
    {
        SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel("");
        SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel("");

        Operation left = new InsertCharOperation(0, 'A');
        Operation right = new InsertCharOperation(0, 'B');

        Transformer transformer = new CharOperationTransformer();

        OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.RIGHT);

        leftDocument.apply(left);
        leftDocument.apply(transformedOps.getRight());

        rightDocument.apply(right);
        rightDocument.apply(transformedOps.getLeft());

        assertEquals(leftDocument.getContent(), rightDocument.getContent());
        assertEquals("BA", leftDocument.getContent());
    }

    @Test
    public void testInsertInsertLeftPriority()
    {
        SimpleTextDocumentModel leftDocument = new SimpleTextDocumentModel("");
        SimpleTextDocumentModel rightDocument = new SimpleTextDocumentModel("");

        Operation left = new InsertCharOperation(0, 'A');
        Operation right = new InsertCharOperation(0, 'B');

        Transformer transformer = new CharOperationTransformer();

        OperationPair transformedOps = transformer.transform(left, right, Transformer.Priority.LEFT);

        leftDocument.apply(left);
        leftDocument.apply(transformedOps.getRight());

        rightDocument.apply(right);
        rightDocument.apply(transformedOps.getLeft());

        assertEquals(leftDocument.getContent(), rightDocument.getContent());
        assertEquals("AB", leftDocument.getContent());
    }
}
