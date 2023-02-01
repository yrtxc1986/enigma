package idv.wilson.enigma.components;

import java.util.ArrayList;
import java.util.List;

public class Ring {

    private final List<Rotor> rotors;
    private final List<Rotor> rotorsReference;

    public Ring(List<Rotor> rotors, List<Integer> setting) {
        this.rotors = rotors;
//        IntStream.range(0, setting.size())
//                .forEach(index -> {
//                    this.rotors.get(index).setCurrentPost(setting.get(index));
//                });
        for(int i = 0;i<rotors.size();i++){
            this.rotors.get(i).setCurrentPost(setting.get(i));
        }
        rotorsReference = new ArrayList<>(rotors.size());
        for(int i = rotors.size()-1;i >=0;i--){
            rotorsReference.add(this.rotors.get(i));
        }
    }

    public void next() {
        for (var rotor : rotors) {
            if (!rotor.moveNext()) {
                break;
            }
        }
    }

    public int getCrypto(int index) {
        var crypto = index;
        for (var rotor : rotors) {
            crypto = rotor.getCryptoIndex(crypto);
        }
        return crypto;
    }

    public int getCryotoReference(int index){
        var crypto = index;
        for (var rotor : rotorsReference) {
            crypto = rotor.getCryptoIndexReflector(crypto);
        }
        return crypto;
    }
}
