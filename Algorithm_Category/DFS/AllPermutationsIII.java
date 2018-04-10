package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPermutationsIII {
    public static String[] words = {"我", "要","我要", "找", "嘉兴", "的", "麦当劳", "麦", "劳", "的麦", "当劳", "我要找嘉兴的麦当劳"};
    public static HashSet<String> dict = new  HashSet<String>();
    public static void main(String[] args) {
        for (int i=0; i<words.length; ++i){
            dict.add(words[i]);
        }

        System.out.println("\n第一题====> ");

        String input = "我要找嘉兴的麦当劳";

        ArrayList<ArrayList<String>> wordComboList = findWords(input);
        for (int i=0; i<wordComboList.size(); ++i) {
            System.out.println(wordComboList.get(i));
        }


        System.out.println("\n第二题====> ");

        input = "我要找嘉兴的人民麦当劳";
        wordComboList = findWordsNew(input);
        for (int i=0; i<wordComboList.size(); ++i) {
            System.out.println(wordComboList.get(i));
        }
        System.out.println("\n====> 运行结束");
    }

    public static ArrayList<ArrayList<String>> findWords(String input) {
        ArrayList<ArrayList<String>> wordComboList = new ArrayList<ArrayList<String>>();
        if (input == null) {
            return  wordComboList;
        }
        List<String> list = new ArrayList<>();
        //找到所有集合
        permutations(input, 0, list, wordComboList);

        //从字典里面找到满足条件的集合
        HashSet<String> dict =  new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            dict.add(words[i]);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < wordComboList.size(); i++) {
            ArrayList<String> temp = wordComboList.get(i);
            for (int j = 0; j < temp.size(); j++) {
                if (!dict.contains(temp.get(j))) {
                    break;
                }
                if (j == temp.size() - 1) {
                    result.add(temp);
                }
            }
        }
        return result;
    }

    //找到所有集合
    private static void permutations(String input, int index, List<String> list, ArrayList<ArrayList<String>> wordComboList) {
        if (index == input.length()) {
            wordComboList.add(new ArrayList<>(list));
            return;
        }
        for (int j = index; j < input.length(); j++) {
            list.add(input.substring(index, j + 1));
            permutations(input, j + 1, list, wordComboList);
            list.remove(input.substring(index, j + 1));
        }
    }




    public static ArrayList<ArrayList<String>> findWordsNew(String input) {
        ArrayList<ArrayList<String>> wordComboList = new ArrayList<ArrayList<String>>();
        if (input == null) {
            return  wordComboList;
        }
        List<String> list = new ArrayList<>();
        //找到所有集合
        permutations(input, 0, list, wordComboList);


        //从字典中找到所有不重复的字
        HashSet<String> AllWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                AllWords.add(words[i].substring(j, j + 1));
            }
        }

        //找到所有的新词
        List<String> newWords = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(i, i + 1);
            if (!AllWords.contains(s)) {
                int temp = i;
                while (i < input.length() && !AllWords.contains(input.substring(i, i + 1))) {
                    System.out.println();
                    i++;
                }
                newWords.add(input.substring(temp, i));
            }
        }

        //把新词加到字典，然后从字典里面找到满足条件的集合
        HashSet<String> dict =  new HashSet<>();
        for (int i = 0; i < newWords.size(); i++) {
            dict.add(newWords.get(i));
        }
        for (int i = 0; i < words.length; i++) {
            dict.add(words[i]);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < wordComboList.size(); i++) {
            ArrayList<String> temp = wordComboList.get(i);
            for (int j = 0; j < temp.size(); j++) {
                if (!dict.contains(temp.get(j))) {
                    break;
                }
                if (j == temp.size() - 1) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
