package idv.wilson.enigma.components;

import idv.wilson.enigma.ProgramConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WiringBuilder {

    private Character[] wiring;

    public WiringBuilder() {
        resetWiring();
    }

    private void resetWiring() {
        wiring = new Character[26];
    }

    public WiringBuilder addPair(Character letterA, Character letterB) {
        wiring[charToIndex(letterA)] = letterB;
        wiring[charToIndex(letterB)] = letterA;
        return this;
    }

    public WiringBuilder setPairList(String pairList) {
        resetWiring();
        Collections.list(new StringTokenizer(pairList, " "))
                .forEach(e -> {
                    if (e instanceof String letterPair) {
                        var letterA = letterPair.toCharArray()[0];
                        var letterB = letterPair.toCharArray()[1];
                        addPair(letterA, letterB);
                    }
                });
        return this;
    }

    public WiringBuilder setWiring(String wiringString) {
        resetWiring();
        var letterList = wiringString.toUpperCase().toCharArray();
        for (int i = 0; i < 26; i++) {
            wiring[i] = letterList[i];
        }
        return this;
    }

    public WiringBuilder fillPair() {
        var missingLetterIndex = IntStream.range(0, wiring.length)
                .filter(index -> wiring[index] == null)
                .toArray();

        if (missingLetterIndex.length != 2) {
            throw new RuntimeException("fillPare only accept missing 2 wiring:" + wiring.toString());
        }
        addPair(indexToChar(missingLetterIndex[0]), indexToChar(missingLetterIndex[1]));
        return this;
    }

    private char indexToChar(int index) {
        return (char) (index + ProgramConstants.ASCII_A);
    }

    private int charToIndex(char letter) {
        return letter - ProgramConstants.ASCII_A;
    }

    public WiringBuilder fillItSelf() {
        IntStream.range(0, wiring.length)
                .forEach(index -> {
                    if (wiring[index] == null) {
                        wiring[index] = indexToChar(index);
                    }
                });
        return this;
    }

    private boolean isMissingWiring() {
        return Stream.of(wiring).anyMatch(item -> item == null);
    }


    public int[] build() {
        if (isMissingWiring()) {
            throw new RuntimeException("Wiring missing Please check:" + Arrays.toString(wiring));
        }
        return IntStream.range(0, wiring.length)
                .map(index -> wiring[index] - 'A')
                .toArray();
    }
}
