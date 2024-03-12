import dictionary.Dictionary;
import word.Word;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создадим словарь!");
        Dictionary dictionary = new Dictionary();
        dictionary.setDictionaryName("Англо-русский словарь");
        System.out.println(dictionary.getDictionaryName());
        //создадим и добавим туда несколько слов
        Word word = new Word("dog");
        word.setTranslation("собака");
        dictionary.addWord(word);
        dictionary.addWord(new Word("cat", "кошка"));
        dictionary.addWord(new Word("bird", "птица"));
        dictionary.addWord(new Word("fish", "рыба"));
        dictionary.addWord(new Word("pencil", "карандаш"));
        dictionary.addWord(new Word("pen", "ручка"));
        dictionary.addWord(new Word("country", "страна,государство"));
        dictionary.addWord(new Word("capital", "столица"));
        // получим перевод нескольких слов
        System.out.println(dictionary.getWord("cat"));
        System.out.println(dictionary.getWord("bird"));
        System.out.println(dictionary.getWord("country"));
        System.out.println(dictionary.getWord("potato"));

        // изменим некоторое слово
        word.setValue("cat");
        word.setTranslation("котяра");
        dictionary.changeWord(word);
        System.out.println(dictionary.getWord("cat"));// выведем его
        // изменим ещё одно слово
        word = dictionary.getWord("country");
        word.setTranslation("держава");
        dictionary.changeWord(word);// выведем его
        System.out.println(dictionary.getWord("country"));

        System.out.println(dictionary.getWord("cat"));
        dictionary.addWord(new Word("pen", "ручка"));// добавим новое слово
        dictionary.addWord(new Word("potato", "картофель"));
        System.out.println(dictionary.getWord("cat"));
        System.out.println(dictionary.getWord("pen"));
        System.out.println(dictionary.getWord("fish"));
        System.out.println(dictionary.getWord("pencil"));
        System.out.println(dictionary.getWord("fish"));
        System.out.println(dictionary.getWord("potato"));
        // выведем список слов, за переводом которых обращаются чаще всего
        System.out.println(Arrays.toString(dictionary.getPopularityWords().toArray()));
    }
}