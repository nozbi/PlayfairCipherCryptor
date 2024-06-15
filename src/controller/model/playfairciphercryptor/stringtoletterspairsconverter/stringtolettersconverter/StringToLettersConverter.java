package controller.model.playfairciphercryptor.stringtoletterspairsconverter.stringtolettersconverter;

import java.util.LinkedList;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.stringtolettersconverter.alphabet.Alphabet;

public final class StringToLettersConverter 
{
    public static final LinkedList<Character> convertStringToLetters(final String stringParameter)
    {
        final char[] allTextChars = stringParameter.toCharArray();
        final LinkedList<Character> letters = new LinkedList<Character>();
        for (int textCharIndex = 0; textCharIndex < allTextChars.length; textCharIndex++)
        {
            char textChar = Character.toUpperCase(allTextChars[textCharIndex]);
            if (textChar == 'J')
            {
                textChar = 'I';
            }
            if (Alphabet.contains(textChar) == true)
            {
                letters.add(textChar);
            }
        }
        return letters;
    }
}
