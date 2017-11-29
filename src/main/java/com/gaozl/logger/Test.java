package com.gaozl.logger;

/**
 * @author gaozl Create by 2017/11/28
 */
public class Test {
    private final static Logger LOG = LoggerFactory.instance().getLogger();

    public static void main(String[] args) {

        LOG.warn("winter is coming, {0}", "gaozl");
        LOG.debug("%s said, 'valar morghulis'", "Jaqen H'ghar");
        LOG.info("%s answered: %s", "Arya", "Valar Dohaeris");
    }
}
