class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            int i = 0;
            for(; i < word.length(); i++) {
                char ch = pattern.charAt(i);
                if(map.containsKey(ch)) {
                    char mc = map.get(ch);
                    if(mc != word.charAt(i)) break;
                } else {
                    if(set.contains(word.charAt(i))) break;
                    map.put(ch, word.charAt(i));
                    set.add(word.charAt(i));
                }
            }
            if(i == pattern.length()) result.add(word);
        }
        return result;
    }
}