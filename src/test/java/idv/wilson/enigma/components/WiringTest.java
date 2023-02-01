package idv.wilson.enigma.components;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class WiringTest {

    @Test
    void wiringByString(){
        var wiringString = "SQHVZTLCUYNGRKXWBMAFIDPOJE";
        var wiringArray = wiringString.toCharArray();

        var wiring = new WiringBuilder().setWiring(wiringString).build();


        assertThat(wiring).hasSize(26);
        IntStream.range(0,26)
                .forEach(index->
                        assertThat(wiring[index]).isEqualTo(wiringArray[index]-'A')
                );
    }

    @Test
    void wiringReflector(){
        var wiring = new WiringBuilder().setPairList("IU AS DV GL FT OX EZ CH MR KN BQ PW").fillPair().build();

        var wiringArray = "SQHVZTLCUYNGRKXWBMAFIDPOJE".toCharArray();
        assertThat(wiring).hasSize(26);
        IntStream.range(0,26)
                .forEach(index->
                        assertThat(wiring[index]).isEqualTo(wiringArray[index]-'A')
                );
    }
}
