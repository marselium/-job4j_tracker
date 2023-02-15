package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder newStringBuilder = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i += 2) {
            newStringBuilder.append(evenElements.poll());
            evenElements.poll();
        }
        return newStringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder newStringBuilder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            newStringBuilder.append(descendingElements.pollLast());
        }
        return newStringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}