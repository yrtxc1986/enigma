package idv.wilson.enigma.components;

public class Rotor {


    public static final Rotor I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "R");
    public static final Rotor II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "F");

    public static final Rotor III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "W");

    public static final Rotor IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", "K");

    public static final Rotor V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", "A");


    private final int[] wiring;
    private final int notch;
    private int position;


    public Rotor(String wiringString, String notch) {
        this.wiring = new WiringBuilder().setWiring(wiringString).build();
        this.notch = notch.toUpperCase().toCharArray()[0] - 'A';
        this.position = 0;
    }

    public boolean moveNext() {
        position = position + 1;
        if (position == 26) {
            position = 0;
        }
        return position == notch;
    }

    private int calcInputPosition(int index){
        var position = index + this.position;
        if (position >= wiring.length) {
            position = position - wiring.length;
        }
        return position;
    }
    private int calcOutputPosition(int index){
        var position = index - this.position;
        if (position <0) {
            position = position + wiring.length;
        }
        return position;
    }
    public int getCryptoIndex(int index) {
        var position = calcInputPosition(index);
        position =  wiring[position];
        return calcOutputPosition(position);
    }

    public int getCryptoIndexReflector(int index) {
        var position = calcInputPosition(index);
        var checkPoint = -1;
        for (int i = 0; i< wiring.length;i++){
            if(wiring[i] == position){
                checkPoint = i;
                break;
            }
        }
        return calcOutputPosition(checkPoint);
    }



    public void setCurrentPost(int position) {
        this.position = position-1;
    }
}
