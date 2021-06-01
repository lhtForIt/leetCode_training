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


import java.util.*;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("alone");
        trie.search("alone");
        trie.insert("achieve");
        trie.insert("ant");
        trie.insert("aasdfasdfasdf");
        trie.insert("alfghdfghfdhg");
        trie.insert("appcasd");
        trie.insert("appsdde");
        trie.insert("appzsa");
//        trie.insert("梁");
//        trie.insert("李");
//        trie.insert("梁皓添");
//        trie.insert("梁yue");
//        trie.insert("梁17");
//        trie.insert("梁*封");
        System.out.println(Arrays.toString(trie.searchAllPrefixString("app").toArray()));
//        System.out.println(Arrays.toString(trie.searchAllPrefixString("梁").toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

        /**
         * 数组实现，适用于知道每个节点的范围，这里是已知只有26个小写字母，但对常规情况不大试用。
         * 这里准确的说应该是TrieNode数组，但是为了一个数组新建一个类没多大必要，因此可以混用，
         * 缺点是这样逻辑会很不清晰，知道是怎么个意思就行
         */
//        private Trie[] next;
//        private boolean isEnd;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public Trie() {
//            next = new Trie[26];
//            isEnd = false;
//        }
//
//        /**
//         * Inserts a word into the trie.
//         */
//        public void insert(String word) {
//            if (word == null || word.length() == 0) return;
//            Trie curr = this;
//            for (char ch : word.toCharArray()) {
//                int u = ch - 'a';
//                //如果null则新new一个节点
//                if (curr.next[u] == null) curr.next[u] = new Trie();
//                //然后找到下一个节点
//                curr = curr.next[u];
//            }
//            //赋值完成将状态置成true
//            curr.isEnd = true;
//        }
//
//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//            Trie node = searchPrefix(word);
//            return node != null && node.isEnd;
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//            Trie node = searchPrefix(prefix);
//            return node != null;
//        }
//
//
//        private Trie searchPrefix(String word) {
//            Trie node = this;
//            for (char c : word.toCharArray()) {
//                node = node.next[c - 'a'];
//                if (node == null) return null;
//            }
//            return node;
//        }


        /**
         * 构造TreeNode节点的数组实现
         *
         */
//        private TrieNode root;
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public void insert(String word) {
//            if (word == null || word.length() == 0) return;
//            TrieNode ws = root;
//            for(int i = 0; i < word.length(); i++){
//                char c = word.charAt(i);
//                if(ws.children[c - 'a'] == null) ws.children[c - 'a'] = new TrieNode();
//                ws = ws.children[c - 'a'];
//            }
//            ws.isWord = true;
//        }
//
//        public boolean search(String word) {
//            TrieNode node = searchPrefix(word);
//            return node!=null||node.isWord;
//        }
//
//        public boolean startsWith(String prefix) {
//            TrieNode node = searchPrefix(prefix);
//            return node!=null;
//        }
//
//        public TrieNode searchPrefix(String word){
//            TrieNode node = root;
//            for(int i = 0; i < word.length(); i++){
//                char c = word.charAt(i);
//                if(node.children[c - 'a'] == null) return null;
//                node = node.children[c - 'a'];
//            }
//            return node;
//        }
//
//        public List<String> searchAllPrefixString(String word){
//            List<String> res = new ArrayList<>();
//            TrieNode ws = searchPrefix(word);
//            recureByArray(word, res, ws);
//            return res;
//        }
//
//        private void recureByArray(String word, List<String> res, TrieNode node) {
//
//            if (node.isWord) {
//                res.add(word);
//            }
//
//            for (char c='a'; c<='z'; c++) {
//                if (node.children[c - 'a'] != null) {
//                    recureByArray(word + c, res, node.children[c - 'a']);
//                }
//            }
//
//        }
//
//        class TrieNode {
//            public boolean isWord;
//            public TrieNode[] children = new TrieNode[26];
//        }


        /**
         * 链表实现
          */
//        private TrieNode root;
//        public Trie() {
//            root = new TrieNode(false, ' ', new ArrayList<>());
//        }
//
//        public void insert(String word) {
//            if (word == null || word.length() == 0) {
//                return;
//            }
//            TrieNode ws = root;
//            for (char c : word.toCharArray()) {
//                TrieNode next = null;
//                if (ws.children != null) {
//                    boolean isBreak = false;
//                    for (TrieNode cc : ws.children) {
//                        if (cc.val == c) {
//                            isBreak = true;
//                            next = cc;
//                            break;
//                        }
//                    }
//                    if (!isBreak) {
//                        next = new TrieNode(false, c, new ArrayList<>());
//                        ws.children.add(next);
//                    }
//                    ws = next;
//                }
//            }
//            ws.isWord = true;
//        }
//
//        public boolean search(String word) {
//            TrieNode ws = root;
//            for(int i = 0; i < word.length(); i++){
//                char c = word.charAt(i);
//                if (ws.children != null) {
//                    boolean isBreak = false;
//                    for (TrieNode cc : ws.children) {
//                        if (cc.val == c) {
//                            isBreak = true;
//                            ws = cc;
//                            break;
//                        }
//                    }
//                    if (!isBreak) {
//                        return false;
//                    }
//                }
//            }
//            return ws.isWord;
//        }
//
//
//        public List<String> searchAllPrefixString(String word) {
//            List<String> res = new ArrayList<>();
//            TrieNode ws = root;
//            for (char c : word.toCharArray()) {
//                if (ws.children != null) {
//                    boolean isBreak = false;
//                    for (TrieNode cc : ws.children) {
//                        if (cc.val == c) {
//                            isBreak = true;
//                            ws = cc;
//                            break;
//                        }
//                    }
//                    //没有满足前缀的数据，直接返回null
//                    if (!isBreak) {
//                        return null;
//                    }
//                }
//            }
//
//            recur(word, res, ws);
//
//            return res;
//        }
//        //递归
//        private void recur(String word, List<String> res, TrieNode node) {
//
//            if (node.isWord) {
//                res.add(word);
//            }
//
//            if (node.children != null) {
//                for (TrieNode child : node.children) {
//                    recur(word + child.val, res, child);
//                }
//            }
//
//        }
//
//        public boolean startsWith(String prefix) {
//            TrieNode ws = root;
//            for(int i = 0; i < prefix.length(); i++){
//                char c = prefix.charAt(i);
//                if (ws.children != null) {
//                    boolean isBreak = false;
//                    for (TrieNode cc : ws.children) {
//                        if (cc.val == c) {
//                            isBreak = true;
//                            ws = cc;
//                            break;
//                        }
//                    }
//                    if (!isBreak) {
//                        return false;
//                    }
//
//                }
//            }
//            return true;
//        }
//
//        class TrieNode {
//            public boolean isWord;
//            public char val;
//            public List<TrieNode> children = new ArrayList<>();
//            //这里可以
//
//            public TrieNode(boolean isWord, char val, List<TrieNode> children) {
//                this.isWord = isWord;
//                this.val = val;
//                this.children = children;
//            }
//        }



        /**
         * hashMap实现，对于任意长度节点都能cover，试用于一般场景
         */
        TrieNode head;
        /** Initialize your data structure here. */
        public Trie() {
            head = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word == null)
                return;
            TrieNode node = head;
            for(char ch : word.toCharArray()) {
                if(!node.charToNode.containsKey(ch)){
                    node.charToNode.put(ch, new TrieNode());
                }
                node = node.charToNode.get(ch);
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
//              if(word == null) return false;
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
//              if(prefix == null) return false;
            TrieNode node = searchPrefix(prefix);
            return node != null;

        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = head;
            for(char ch : prefix.toCharArray()) {
                if(!node.charToNode.containsKey(ch)) return null;
                node = node.charToNode.get(ch);
            }
            return node;
        }

        private List<String> searchAllPrefixString(String prefix){
            List<String> res = new ArrayList<>();
            TrieNode node = searchPrefix(prefix);
            recureByMap(prefix, res, node);
            return res;
        }

        private void recureByMap(String word, List<String> res, TrieNode node) {
            if (node.isEnd) {
                res.add(word);
            }

            if (node.charToNode != null && node.charToNode.size() > 0) {
                for (Map.Entry<Character, TrieNode> child : node.charToNode.entrySet()) {
                    recureByMap(word + child.getKey(), res, child.getValue());
                }
            }

        }


        class TrieNode{
            Map<Character, TrieNode> charToNode;
            boolean isEnd = false;
            public TrieNode(){
                charToNode = new HashMap();
            }
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