#include <jni.h>
void *tree_sitter_dbspec();
/*
 * Class:     org_treesitter_TreeSitterDbspec
 * Method:    tree_sitter_dbspec
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_no_nr_TreeSitterDbspec_tree_1sitter_1dbspec
  (JNIEnv *env, jclass clz){
   return (jlong) tree_sitter_dbspec();
}
