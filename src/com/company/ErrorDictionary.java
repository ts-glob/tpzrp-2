package com.company;

class DictionaryErrors {
    private static String[] dictionary;
    private static String defError;
    public DictionaryErrors() {
        defError = "Введён некорректный номер узла: ";
        dictionary = new String[10];
        dictionary[0] = "значение добавляемого узла превышает максимально допустимое.";
        dictionary[1] = "добавляемый узел не может иметь отрицательный индекс.";
        dictionary[2] = "уже существует.";
        dictionary[3] = "не существует.";
        dictionary[4] = "список пуст.";

    }

    public static String errorMessage(int errorId) {
        return (defError + dictionary[errorId]);
    }
    public static String errorMessage(int errorId, int nodeId) {
        return (defError + Integer.toString(nodeId) + " узел " + dictionary[errorId]);
    }

}
