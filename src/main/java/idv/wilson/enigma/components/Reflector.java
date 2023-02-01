package idv.wilson.enigma.components;

import java.util.Arrays;
import java.util.List;

public class Reflector {

    public static final Reflector UKW_A = new Reflector("QYHOGNECVPUZTFDJAXWMKISRBL");

    public static final Reflector Wiki = new Reflector(Arrays.asList("IU","AS","DV","GL","FT","OX","EZ","CH","MR","KN","BQ","PW"));

    int[] wire;

    private Reflector(String wireString){
        wire = new WiringBuilder().setWiring(wireString).build();
    }

    private Reflector(List<String> wirePair){
        var builder = new WiringBuilder();
        for(var pair : wirePair){
            var pairs = pair.toCharArray();
            builder.addPair(pairs[0],pairs[1]);
        }
        wire = builder.fillPair().build();
    }

    public int getCrypto(int index){
        return wire[index];
    }
}
