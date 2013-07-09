package io.otly.core.gwt.client.internal;

import java.util.logging.Logger;

import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

/**
 * Core module entry point.
 *
 * @version $Id$
 */
public class CoreEntryPoint implements EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(CoreEntryPoint.class.getName());

    @Override public void onModuleLoad()
    {
        //Export all exportable symbols (GWTExporter)
        ExporterUtil.exportAll();

        logger.info("Core module loaded.");
    }
}
