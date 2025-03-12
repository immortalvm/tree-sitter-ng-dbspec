package no.nr;

import org.junit.jupiter.api.Test;
import org.treesitter.*;

import static org.junit.jupiter.api.Assertions.*;

class TreeSitterDbspecTest {
    @Test
    void init() {
        TSParser parser = new TSParser();
        parser.setLanguage(new TreeSitterDbspec());
        String input = "Parameters:\n" +
                "	host - Hostname of database instance used for staging\n" +
                "	port - Port of database instance\n" +
                "\n" +
                "# æøå\n" +
                "\r\n" +
                "# Name of the staging database\n" +
                "Set db = \"adventure\"\n";
        TSTree tree = parser.parseString(null, input);
        TSNode rootNode = tree.getRootNode();
        assertEquals(2, rootNode.getChildCount());

        assertEquals("parameters", rootNode.getChild(0).getType());
        assertEquals("set", rootNode.getChild(1).getType());

        TSNode x = rootNode.getChild(1).getChildByFieldName("name");

        TSPoint sp = x.getStartPoint();
        TSPoint ep = x.getEndPoint();
        assertEquals(7, sp.getRow());
        assertEquals(7, ep.getRow());
        String[] inputLines = input.split("\n");
        assertEquals("db", inputLines[7].substring(sp.getColumn(), ep.getColumn()));
    }
}
