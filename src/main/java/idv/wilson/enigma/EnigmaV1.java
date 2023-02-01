package idv.wilson.enigma;

import idv.wilson.enigma.components.Ring;
import idv.wilson.enigma.components.Rotor;
import idv.wilson.enigma.components.WiringBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class EnigmaV1 {

    int[] plugBoard;
    int[] reflector;

   Ring ring;

    public EnigmaV1(List<Rotor> rotor, List<Integer> ringSetting){
        plugBoard = new WiringBuilder().setPairList("EJ OY IV AQ KW FX MT PS LU BD").fillItSelf().build();
//        plugBoard = new WiringBuilder().fillItSelf().build();

        reflector = new WiringBuilder().setPairList("IU AS DV GL FT OX EZ CH MR KN BQ PW").fillPair().build();
        ring = new Ring(rotor, ringSetting);
    }

    public String crypto(String input){
       return input.toUpperCase()
               .chars()
               .sequential()
               .mapToObj(this::process)
               .collect(Collectors.joining());
    }

    private String process(int input){
        if(input == ' '){
            return String.valueOf((char)input);
        }
        ring.next();
        int index = input-ProgramConstants.ASCII_A;
        index = plugBoard[index];
        index = ring.getCrypto(index);
        index = reflector[index];
        index =ring.getCryotoReference(index);
        index = plugBoard[index];
        var c = (char)(index+ProgramConstants.ASCII_A);
        return String.valueOf(c);
    }

}
