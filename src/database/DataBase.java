package database;

import dictionary.DictionaryImpl;
import word.Word;

import java.util.*;

/**
 * Импровизированная база данных словаря
 */
public class DataBase implements DictionaryImpl {

    private final DBWord dbWord;
    private final DBDescription dbDescription;
    private final TreeMap<String, Integer> popularityMap = new TreeMap<>();// карта популярности слов
    public DataBase() {
        dbWord = new DBWord();
        dbDescription = new DBDescription();
    }

    @Override
    public boolean addWord(Word word) {
        boolean addValue = dbWord.addItem(word.getValue());// добавляем значение слова
        boolean addDescription = dbDescription.addItem(dbWord.getKeyValue(), word.getTranslation());// добавляем перевод слова
        return (addValue && addDescription);
    }

    @Override
    public Word getWord(String templateWord) {
        /*
         ищем соответствие шаблону в таблице слов, если находим, то ищем соответствие в таблице переводов
         */
        if (dbWord.findWord(templateWord)) {
            dbDescription.getWordDescription(dbWord.getKeyValue());
            Word word = new Word();
            word.setValue(templateWord);
            word.setTranslation(dbDescription.getWordDescription(dbWord.getKeyValue()));
            // увеличиваем счётчик обращений к данному слову
            if (popularityMap.containsKey(templateWord)) {
                // если ключ уже существует во множестве
                int index = popularityMap.get(templateWord);// получаем значение счётчика обращений
                index++;// увеличиваем
                popularityMap.put(templateWord, index);// заменяем значение
            } else {
                // Если ключ ещё не существует во множестве, т.е. обращений за данным словом ещё не было
                popularityMap.put(templateWord, 1);// добавляем начальное значение
            }
            System.out.println("popularity = " + popularityMap.size());
            return word;
        }

        return null;
    }

    @Override
    public boolean changeWord(Word newWord) {
        // получаем значение слова, перевод которого меняется
        String keyword = newWord.getValue();
        // ищем соответствие в таблице слов
        if (dbWord.findWord(keyword)) {
            return dbDescription.changeItem(dbWord.getKeyValue(), newWord.getTranslation());

        }
        return false;
    }

    @Override
    public boolean removeWord(String word) {
        int id = dbWord.removeItem(word);
        if(id != 0) {
            return dbDescription.removeItem(id);
        }
        return false;
    }

    @Override
    public List<Word> getAllWords() {

        return null;
    }

    @Override
    public List<String> getPopularityWords() {
        // самыми непопулярными являются те слова, за переводом которых не обращаются

        return getSortedPopularityWords();
    }

    /**
     * Возвращает отсортированный по популярности список слов
     * @return список слов, за переводом которых обращаются чаще всего
     */
    private List<String> getSortedPopularityWords() {
        List<String> wordList = new ArrayList<>();
        NavigableMap<String, Integer> map = popularityMap.descendingMap();
        System.out.println(map);
        // счётчик цикла
        while (map.size() > 0) {
            int value = 0;
            String keyValue = null;
            for(String str : map.keySet()) {
                if (map.get(str) > value) {
                    value = map.get(str);
                    keyValue = str;
                }
            }
            if (!wordList.contains(keyValue)) {
                // если в списке ещё нет данного слова, добавляем его
                wordList.add(keyValue);
            }
            map.remove(keyValue);
        }

        return wordList;
    }

    /**
     * Представляет собой таблицу слов
     */
    private static class DBWord implements DataBaseImpl {
        private int id;
        private int keyValue;
        private final TreeMap<String, Integer> wordMap;

        public DBWord() {
            // инициализация начальных значений
            id = 0;
            wordMap = new TreeMap<>();
        }

        @Override
        public boolean addItem(String string) {
            if (!wordMap.containsKey(string)) {
                id++;// увеличиваем счётчик
                keyValue = id;
                wordMap.put(string, id);
                return true;
            }
            return false;
        }

        public int getKeyValue() {
            return keyValue;
        }

        public boolean findWord(String template) {
            String key = getValue(template);
            if (key != null) {
                // если соответствие ключу найдено, получаем его код
                keyValue = wordMap.get(key);
                return true;
            }
            return false;
        }

        public int removeItem(String template) {
            String key = getValue(template);
            if (key != null) {
                // если соответствие ключу найдено, получаем его код
                keyValue = wordMap.remove(key);
                return keyValue;
            }
            return 0;
        }

        private String getValue(String template) {
            for(String key : wordMap.keySet()) {
                if (key.contains(template)) {
                    return key;
                }
            }
            return null;
        }
    }

    /**
     * Представляет собой таблицу переводов слов
     */
    private static class DBDescription implements DataBaseImpl {
        private final TreeMap<Integer, String> descriptionMap;

        public DBDescription() {
            // инициализация начальных значений
            descriptionMap = new TreeMap<>();
        }

        @Override
        public boolean addItem(int id, String string) {
            if (!descriptionMap.containsKey(id)) {
                descriptionMap.put(id, string);
                return true;
            }
            return false;
        }

        public boolean changeItem(int id, String string) {
            if (descriptionMap.containsKey(id)) {
                descriptionMap.put(id, string);
                return true;
            }
            return false;
        }
        public String getWordDescription(int id) {
            return descriptionMap.get(id);
        }

        public boolean removeItem(int id) {
            return descriptionMap.remove(id).isEmpty();
        }
    }


}
