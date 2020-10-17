package Medium;

public class q208 {


    static class Trie {

        private boolean isEnd = false;
        private Trie[] next = new Trie[26];

        /** Initialize your data structure here. */
        public Trie() { }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.next[chars[i]-'a'] == null) {
                    root.next[chars[i-'a']] = new Trie();
                }
                root = root.next[chars[i]-'a'];
            }
            root.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.next[chars[i]-'a'] == null) {
                    return false;
                }
                root = root.next[chars[i]-'a'];
            }
            return root.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root = this;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.next[chars[i]-'a'] == null) {
                    return false;
                }
                root = root.next[chars[i]-'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"goodcode","good","happycode","go"};
        Trie root = new Trie();
        for (String s: strings) {
            root.insert(s);
        }

    }
}
