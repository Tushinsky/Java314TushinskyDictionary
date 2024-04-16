package dictionary;

import database.DataBase;
import word.Word;

import java.util.List;

public class Dictionary implements DictionaryImpl{
    private final DataBase dataBase;
    private String dictionaryName;
    public Dictionary() {
        dataBase = new DataBase();
    }

    public Dictionary(String dictionaryName) {
        this.dictionaryName = dictionaryName;
        dataBase = new DataBase();
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    @Override
    public boolean addWord(Word word) {
        return dataBase.addWord(word);
    }

    @Override
    public Word getWord(String templateWord) {
        return dataBase.getWord(templateWord);
    }

    @Override
    public boolean changeWord(Word newWord) {
        return dataBase.changeWord(newWord);
    }

    @Override
    public boolean removeWord(String word) {
        return dataBase.removeWord(word);
    }

    @Override
    public List<Word> getAllWords() {
        return dataBase.getAllWords();
    }

    @Override
    public List<String> getPopularityWords() {
        return dataBase.getPopularityWords();
    }
}
