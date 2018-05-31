class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        wordSet.add(beginWord);
        
        // build links for grapth
        Map<String, Set<String>> linksMap = new HashMap();
        for (String word: wordSet) {
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != word.charAt(i)) {
                        String newWord;
                        if (i == 0) {
                            newWord = ch + word.substring(i + 1);
                        } else if (i == word.length() + 1) {
                            newWord = word.substring(0, i) + ch;
                        } else {
                            newWord = word.substring(0, i) + ch + word.substring(i + 1);
                        }
                        if (wordSet.contains(newWord)) {
                            Set<String> links = linksMap.get(word);
                            if (links == null) {
                                links = new HashSet<String>();
                                linksMap.put(word, links);
                            }
                            links.add(newWord);
                        }
                
                    }

                }
            }
        }
        
        // System.out.println("wordSet = " + wordSet);
        // System.out.println("linksMap = " + linksMap);
        // find shortest path by using BFS
        int count = 1;
        int levelAmount = 1;
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) return count;
            levelAmount--;
            Set<String> links = linksMap.get(word);
            if (links != null) {
                for(String link: links) {
                    if (!visited.contains(link)) {
                        visited.add(link);
                        queue.add(link);
                    }
                }
            }
            if (levelAmount == 0) {
                count++;
                levelAmount = queue.size();
            }
            // System.out.println("word = " + word + ", count = " + count + ", levelAmount = " + levelAmount);
            // System.out.println("visited = " + visited);
            // System.out.println("queue = " + queue);
        }
        
        return 0;
    }
}
