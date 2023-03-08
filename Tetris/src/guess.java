import javax.swing.*;

public class guess {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 200) + 1; // randomly generated number
        int answer = 0; // user input

        int counter = 1;

        while (answer != number) {

            try {
                // makes dialogue boxes
                String feedback = JOptionPane.showInputDialog(null, "do you want to guess? no more than 200, no less than 1", "guess the number", 3);
        
                if (feedback == null) { // user clicked cancel
                    break; // exit the loop
                }
        
                answer = Integer.parseInt(feedback);
                String result = guesses(answer, number, counter);
        
                if (result.equals("exit")) { // user clicked cancel in the hint dialogue
                    break; // exit the loop
                }
        
                JOptionPane.showMessageDialog(null, result);
                counter++; // increments count value by 1, keeps track of user guesses
        
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "not a valid input", null, 3);
            }
        }
        
        }
    

    public static String guesses(int answer, int number, int counter) {
        if (answer > 200 || answer < 1) {
            return "told you this was illegal, did i not?";

        } else if (answer < number) {
            String hint = JOptionPane.showInputDialog(null, "would you like a hint? Yes or No.", "Hint", 3);

            if (hint == null) { // user clicked Cancel
                return "exit"; // indicate that the user wants to exit the program

            } else if (hint.equalsIgnoreCase("yes")) {
                return "your guess is too small";

            } else {
                return "ok lets continue";
            }

        } else if (answer > number) {
            String hint = JOptionPane.showInputDialog(null, "you're not great at this, want a hint?", "Hint", 3);

            if (hint == null) { // user clicked Cancel
                return "exit"; // indicate that the user wants to exit the program

            } else if (hint.equalsIgnoreCase("yes")) {
                return "your guess is too high";
                
            } else {
                return "ok lets continue";
            }
        }
        return "great job! that's correct";
    }
}
    