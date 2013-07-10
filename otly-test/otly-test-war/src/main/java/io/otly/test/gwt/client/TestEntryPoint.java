package io.otly.test.gwt.client;

import java.util.logging.Logger;

/**
 * Core test module.
 *
 * This module is used for building a web application containing all the elements of the OTLY framework for testing
 * purposes.
 *
 * @version $Id$
 */
public class TestEntryPoint implements com.google.gwt.core.client.EntryPoint
{
    /**
     * The logger.
     */
    protected Logger logger = Logger.getLogger(TestEntryPoint.class.getName());

    @Override public void onModuleLoad()
    {
        logger.info("OTLY test loaded");
    }
}
