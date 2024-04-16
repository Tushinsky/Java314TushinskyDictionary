package dictionary;

import word.Word;

import java.util.List;

public interface DictionaryImpl {

    /**
     * Добавляет новое слово в словарь
     * @param word слово для добавления
     * @return true если добавление прошло удачно
     */
    boolean addWord(Word word);

    /**
     * Возвращает слово, соответствующее заданному шаблону, если оно присутствует в словаре
     * @param templateWord шаблон, по которому выбирается слово
     * @return слово, если оно есть, иначе возвращается null
     */
    Word getWord(String templateWord);

    /**
     * Изменяет слово в словаре
     * @param newWord новое значение слова
     * @return true если изменения прошли успешно, иначе возвращает false
     */
    boolean changeWord(Word newWord);

    /**
     * Удаляет слово из словаря
     * @param word слово для удаления
     * @return true если удаление прошло удачно, в противном случае возвращает false
     */
    boolean removeWord(String word);

    /**
     * Возвращает список всех слов из словаря
     * @return список всех слов из словаря
     */
    List<Word> getAllWords();

    /**
     * Возвращает список самых популярных (или не популярных) слов
     * @return список самых популярных (или не популярных) слов
     */
    List <String> getPopularityWords();
}
