/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class EncryptedTextConverter {
    
    public final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public EncryptedTextConverter() {
        
    }
    
    public String encryption(String input, int shift, int num) {
        String encrypt_string = "";
        input = reverseCapitalizeAlphabetAfterSymbol(input);
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char current_Char = input.charAt(i);

            if (current_Char == '^') {
                encrypt_string += "^"; // Capitalized alphabet representation
            } else if (Character.isWhitespace(current_Char)) {
                encrypt_string += "$"; // Space character representation
            } else if (Character.isAlphabetic(current_Char)) {
                int position = alphabet.indexOf(current_Char);
                int adjusted_position = (position + num) % 26;
                int encrypt_position = (shift + adjusted_position) % 26;
                char encrypt_Char = alphabet.charAt(encrypt_position);
                encrypt_string += encrypt_Char;
            } else {
                encrypt_string += current_Char; // No transformation for non-alphabetic characters
            }
        }

        encrypt_string = invertTextInsideParentheses(encrypt_string);

        return encrypt_string;
    }

    public String decryption(String input, int shift, int num) {
        String decrypt_string = "";
        input = invertTextInsideParentheses(input);

        for (int i = 0; i < input.length(); i++) {
            char current_Char = input.charAt(i);
            if (current_Char == '$') {
                decrypt_string += " "; // Space character representation
            } else if (current_Char == '^') {
                decrypt_string += "^"; // Capitalized alphabet representation
            } else if (Character.isAlphabetic(current_Char)) {
                int position = alphabet.indexOf(current_Char);
                int adjusted_position = (position - num) % 26;

                if (adjusted_position < 0) {
                    adjusted_position = alphabet.length() + adjusted_position;
                }

                int decrypt_position = (adjusted_position - shift) % 26;

                if (decrypt_position < 0) {
                    decrypt_position = alphabet.length() + decrypt_position;
                }

                char decrypt_Char = alphabet.charAt(decrypt_position);
                decrypt_string += decrypt_Char;
            } else {
                decrypt_string += current_Char; // No transformation for non-alphabetic characters
            }
        }
        decrypt_string = capitalizeAlphabetAfterSymbol(decrypt_string); // Capitalize alphabet after decryption
        decrypt_string = invertTextInsideParentheses(decrypt_string);
        return decrypt_string;
    }


    
    private String capitalizeAlphabetAfterSymbol(String input) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < input.length(); i++) {
            char current_Char = input.charAt(i);

            if (capitalizeNext && Character.isAlphabetic(current_Char)) {
                result.append(Character.toUpperCase(current_Char));
                capitalizeNext = false;
            } else if (current_Char == '^') {
                capitalizeNext = true;
            } else {
                result.append(current_Char);
            }
        }
        return result.toString();
    }
    
    private String reverseCapitalizeAlphabetAfterSymbol(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current_Char = input.charAt(i);

            if (Character.isUpperCase(current_Char) && Character.isAlphabetic(current_Char)) {
                result.append("^").append(Character.toLowerCase(current_Char));
            } else {
                result.append(current_Char);
            }
        }

        return result.toString();
    }
   
    private String invertTextInsideParentheses(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder invertedText = new StringBuilder();
        boolean insideParentheses = false;

        for (int i = 0; i < input.length(); i++) {
            char current_Char = input.charAt(i);

            switch (current_Char) {
                case '(' -> {
                    if (insideParentheses) {
                        result.append(invertedText.reverse());
                        invertedText.setLength(0);
                    }   insideParentheses = true;
                }
                case ')' -> {
                    if (insideParentheses) {
                        result.append(invertedText.reverse());
                        invertedText.setLength(0);
                    }   insideParentheses = false;
                }
                default -> {
                    if (insideParentheses) {
                        invertedText.append(current_Char);
                    } else {
                        result.append(current_Char);
                    }
                }
            }
        }

        // Append any remaining inverted text if parentheses are not closed
        if (insideParentheses) {
            result.append(invertedText.reverse());
        }

        return result.toString();
    }

}
