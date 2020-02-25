import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GalaxyTest {

    @Test
    public void test() {
        String input =
                "glob is romanNumerals.I\n" +
                "prok is romanNumerals.V\n" +
                "pish is romanNumerals.X\n" +
                "tegj is romanNumerals.L\n" +
                "glob glob Silver is 34 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "pish pish Iron is 3910 Credits\n" +
                "how much is pish tegj glob glob ?\n" +
                "how many Credits is glob prok Silver ?\n" +
                "how many Credits is glob prok Gold ?\n" +
                "how many Credits is glob prok Iron ?\n" +
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

        Galaxy galaxy = new Galaxy();

        String output = galaxy.processInput(input);

        assertEquals("pish tegj glob glob is 42\n" +
                "glob prok Silver is 68 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "glob prok Iron is 782 Credits\n" +
                "romanNumerals.I have no idea what you are talking about\n", output);
    }
}
