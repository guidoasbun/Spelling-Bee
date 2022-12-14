
// Programmer: Guido Asbun
package com.cs272.spellingbee.Objects.CorrectWordsList;

import javafx.scene.control.ListView;

public class CorrectWordList {
    private final SinglyLinkedList<String> correctWordList;

    public CorrectWordList() {
        correctWordList = new SinglyLinkedList<>();
    }

    public void addWord(String word) {
        correctWordList.addLast(word.toUpperCase());
    }

    public void getCorrectWordListView(ListView<String> correctWordsListView) {
        correctWordList.getCorrectWordListView(correctWordsListView);
    }

    public int getSize() {
        return correctWordList.getSize();
    }

    public void removeAll() {
        correctWordList.removeAll();
    }

    public Boolean checkIfWordIsAlreadyInList (String word) {
        return this.correctWordList.occurrences(word.toUpperCase()) > 0;
    }
}
