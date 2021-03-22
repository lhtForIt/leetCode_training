//题号：208
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 560 👎 0

  
package leetcode.editor.cn;
public class ImplementTriePrefixTree{
      public static void main(String[] args) {
          Trie solution = new ImplementTriePrefixTree().new Trie();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private Trie[] son;
    private boolean isEnd;
    /** Initialize your data structure here. */
    public Trie() {
        son = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie p = this;
        for (char ch : word.toCharArray()) {
            int u = ch - 'a';
            if (p.son[u] == null) p.son[u] = new Trie();
            p = p.son[u];
        }
        p.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie p = this;
        for (char ch : word.toCharArray()) {
            int u = ch - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return p.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie p = this;
        for (char ch : prefix.toCharArray()) {
            int u = ch - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }