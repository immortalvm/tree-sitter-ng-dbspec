package no.nr;

import org.junit.jupiter.api.Test;
import org.treesitter.TSLanguage;
import org.treesitter.TSNode;
import org.treesitter.TSParser;
import org.treesitter.TSTree;

import static org.junit.jupiter.api.Assertions.*;

class TreeSitterDbspecTest {
    @Test
    void init() {
        TSParser parser = new TSParser();
        TSLanguage dbspec = new TreeSitterDbspec();
        parser.setLanguage(dbspec);
        TSTree tree = parser.parseString(null, """
                Parameters:
                	host - Hostname of database instance used for staging
                	port - Port of database instance

                # Name of the staging database
                Set db = "adventure"
                """);
        TSNode rootNode = tree.getRootNode();
        assertEquals(2, rootNode.getChildCount());

        assertEquals("parameters", rootNode.getChild(0).getType());
        assertEquals("set", rootNode.getChild(1).getType());
    }
}
