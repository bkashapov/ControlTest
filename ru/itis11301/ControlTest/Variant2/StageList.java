package ru.itis11301.ControlTest.Variant2;

public class StageList implements NextPrevInterface{
    public Stage root;
    public Stage current = root;

    public void add(Stage stage) {
        if (root == null) {
            root = stage;
            current = root;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = stage;
            stage.prev = current;
            current = root;
        }
    }
    public Stage next() {
        if (current.next == null) {
            System.out.println("Дальше нет этапов");
            return null;
        }
        current = current.next;
        return current;
    }
    public Stage prev() {
        if (current.prev == null) {
            System.out.println("Перед этим этапом нет этапов");
            return null;
        }
        current = current.prev;
        return current;
    }
}
