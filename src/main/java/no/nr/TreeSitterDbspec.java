package no.nr;

import org.treesitter.TSLanguage;
import org.treesitter.utils.NativeUtils;

/**
 * TSLanguage instance for the DbSpec language
 */
public class TreeSitterDbspec implements TSLanguage {
    static {
        NativeUtils.loadLib("lib/tree-sitter-ng-dbspec");
    }

    private native static long tree_sitter_dbspec();

    private final long ptr;

    /**
     * Create TSLanguage instance for the DbSpec language
     */
    public TreeSitterDbspec() {
        ptr = tree_sitter_dbspec();
    }

    @Override
    public long getPtr() {
        return ptr;
    }
}
