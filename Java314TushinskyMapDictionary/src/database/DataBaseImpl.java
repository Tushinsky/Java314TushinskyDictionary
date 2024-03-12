package database;

public interface DataBaseImpl {
    default boolean addItem(String string) {
        return true;
    }

    default boolean addItem(int id, String string) {
        return true;
    }
}
