package no.nr;

import org.treesitter.TSLanguage;
import org.treesitter.utils.NativeUtils;

/**
 * TSLanguage instance for the DbSpec language
 */
public class TreeSitterDbspec extends TSLanguage {
    static {
        NativeUtils.loadLib("lib/tree-sitter-ng-dbspec");
    }

    private native static long tree_sitter_dbspec();

    /**
     * Create TSLanguage instance for the DbSpec language
     */
    public TreeSitterDbspec() {
        super(tree_sitter_dbspec());
    }

    private TreeSitterDbspec(long ptr) {
        super(ptr);
    }

    @Override
    public TSLanguage copy() {
        return new TreeSitterDbspec(copyPtr());
    }
}
