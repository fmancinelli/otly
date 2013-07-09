package io.otly.binding.simpletext.gwt.client.internal;

import java.util.logging.Logger;

import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

import io.otly.api.gwt.shared.util.binding.PlainTextDocument;
import io.otly.binding.simpletext.gwt.shared.internal.PlainTextDocumentBindingFactory;
import io.otly.core.gwt.shared.internal.DocumentModelBindingFactoryRegistry;
import io.otly.documentmodel.simpletext.gwt.shared.internal.SimpleTextDocumentModel;

/**
 * PlainTextDocumentBinding module entry point.
 *
 * This module defines the binding between a SimpleTextDocumentModel and a PlainTextDocument.
 *
 * @version $Id$
 */
public class PlainTextDocumentBindingEntryPoint implements EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(PlainTextDocumentBindingEntryPoint.class.getName());

    @Override public void onModuleLoad()
    {
        //Export all exportable symbols (GWTExporter)
        ExporterUtil.exportAll();

        logger.fine("Registering binding: SimpleTextDocumentModel -> PlainTextDocument.");

        //Register the binding in the OTLY binding registry in order to make it available to clients.
        DocumentModelBindingFactoryRegistry documentModelBindingFactoryRegistry =
                DocumentModelBindingFactoryRegistry.getInstance();

        documentModelBindingFactoryRegistry.registerBinding(SimpleTextDocumentModel.class, PlainTextDocument.class,
                new PlainTextDocumentBindingFactory());

        logger.info("PlainTextDocument binding for SimpleTextDcumentModel module loaded.");
    }
}
