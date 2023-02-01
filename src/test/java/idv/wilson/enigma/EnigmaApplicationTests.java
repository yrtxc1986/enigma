package idv.wilson.enigma;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
class EnigmaApplicationTests {

	@Test
	void functionTest(){
		var c = Character.valueOf((char)(3+ProgramConstants.ASCII_A));
		assertThat(c).isEqualTo('C');
	}

	@Test
	void stringToIndexHelper(){
		var a = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
		a.chars().forEachOrdered(
				c ->{
					var index = c-'A'+1;
					System.out.print(index + " ");
				}
		);
	}

}
