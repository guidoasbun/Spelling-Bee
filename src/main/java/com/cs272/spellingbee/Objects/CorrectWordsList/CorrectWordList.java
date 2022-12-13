package com.cs272.spellingbee.Objects.CorrectWordsList;

import javafx.scene.control.ListView;

public class CorrectWordList {
    private final SinglyLinkedList<String> correctWordList;

    public CorrectWordList() {
        correctWordList = new SinglyLinkedList<>();
    }

    public void addWord(String word) {
        correctWordList.addLast(word);
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
}
