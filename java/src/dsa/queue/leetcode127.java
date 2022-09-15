package dsa.queue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0|| !wordSet.contains(endWord)){return 0;}

        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        Set<String> endVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()){
            if (beginVisited.size() > endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited  = new HashSet<>();
            for (String word : beginVisited) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = chars[i];
                    for (char c = 'a'; c<='z' ;c++){
                        chars[i]=c;
                        String nextWord = new String(chars);
                        if (wordSet.contains(nextWord)){
                            if (endVisited.contains(nextWord)){
                                return step+1;
                            }
                            if (!visited.contains(nextWord)){
                                nextLevelVisited.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    chars[i]=origin;
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }
}
