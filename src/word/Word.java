package word;

import java.util.ArrayList;

public class Word {
    private String value;// значение слова
    private String translation;// список, содержащий возможные переводы слова

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public Word(String value, String translation) {
        this.value = value;
        this.translation = translation;
    }

    /**
     * Возвращает слов
     * @return value - слов
     */
    public String getValue() {
        return value;
    }

    /**
     * Задаёт слово
     * @param value слово
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Возвращает варианты перевода слова
     * @return translation - варианты перевода слова
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Задаёт варианты перевода слова
     * @param translation варианты перевода слова
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
