package io.otly.api.gwt.client.internal;

import java.util.logging.Logger;

import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

/**
 * API module entry point.
 *
 * This module contains all the public APIs for OTLY clients.
 *
 * @version $Id$
 */
public class APIEntryPoint implements EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(APIEntryPoint.class.getName());

    @Override public void onModuleLoad()
    {
        //Export all exportable symbols (GWTExporter)
        ExporterUtil.exportAll();

        logger.info("API module loaded.");
    }
}
