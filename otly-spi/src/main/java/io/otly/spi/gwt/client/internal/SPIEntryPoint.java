package io.otly.spi.gwt.client.internal;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

/**
 * SPI module entry point.
 *
 * This module contain all the interfaces that are used to extend OTLY. Providers willing to define new DocumentModels
 * and bindings will provide implementations of these interfaces and register them using the registry in the Core
 * module.
 *
 * @version $Id$
 */
public class SPIEntryPoint implements EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(SPIEntryPoint.class.getName());

    @Override public void onModuleLoad()
    {
        logger.info("SPI module loaded.");
    }
}
