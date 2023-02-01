package idv.wilson.enigma;

import idv.wilson.enigma.components.Rotor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class EnigmaV1Test {

    @Test
    void NoEncryptTest() {
        var enigma = new EnigmaV1( Arrays.asList(Rotor.IV, Rotor.II, Rotor.V), Arrays.asList(15, 23, 26));
//        var enigma = new EnigmaV1(Arrays.asList(Rotor.IV), Arrays.asList(1));

//        assertThat(enigma.crypto("ABCD")).isEqualTo("GFXJ");
//        assertThat(enigma.crypto("GFXJ")).isEqualTo("ABCD");
//        assertThat(enigma.crypto("HELLO ENIGMA")).isEqualTo("QDKGG AXESCY");
        assertThat(enigma.crypto("QDKGG AXESCY")).isEqualTo("HELLO ENIGMA");
//        assertThat(enigma.crypto("lsa zbw vcj rxn")).isEqualTo("HELLO WOLD");
//        assertThat(enigma.crypto("ABCDEFGHIJKLMNOPQRSTUVWXYZ")).isEqualTo("lsa zbw vcj rxn".toUpperCase());
//        assertThat(enigma.crypto("DIHAOYUCBZSVXWEQPTKRGLNMFJ")).isEqualTo("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
