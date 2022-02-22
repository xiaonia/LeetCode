package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * 212. Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class LeetCode_0212 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0212().findWords(
                        new char[][]{
                                {'o','a','a','n'},
                                {'e','t','a','e'},
                                {'i','h','k','r'},
                                {'i','f','l','v'}
                        },
                        new String[]{
                                "oath","pea","eat","rain"
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0212().findWords(
                        new char[][]{
                                {'a','b'}
                        },
                        new String[]{
                                "ba"
                        }
                )
        );

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (findWord(board, word)) {
                list.add(word);
            }
        }
        return list;
    }

    public boolean findWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(
            char[][] board, int column, int row,
            String word, int index
    ) {
        if (index >= word.length()) {
            return true;
        }

        if (column < 0 || column >= board.length) {
            return false;
        }

        if (row < 0 || row >= board[column].length) {
            return false;
        }

        if (board[column][row] == '0') {
            return false;
        }

        if (board[column][row] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }

            board[column][row] = '0';
            boolean isMatched = findWord(board, column, row - 1, word, index + 1)
                    || findWord(board, column, row + 1, word, index + 1)
                    || findWord(board, column - 1, row, word, index + 1)
                    || findWord(board, column + 1, row, word, index + 1);
            board[column][row] = word.charAt(index);
            return isMatched;
        }

        return false;
    }

}
