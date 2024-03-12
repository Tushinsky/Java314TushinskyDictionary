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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTranslation() {
        return translation;
    }

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
