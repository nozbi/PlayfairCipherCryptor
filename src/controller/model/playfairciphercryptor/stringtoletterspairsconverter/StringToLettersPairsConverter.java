package controller.model.playfairciphercryptor.stringtoletterspairsconverter;

import java.util.LinkedList;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.letterspair.LettersPair;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.stringtolettersconverter.StringToLettersConverter;

public final class StringToLettersPairsConverter 
{
    public static final LinkedList<LettersPair> convertStringToLettersPairs(final String stringParameter)
    {
        final LinkedList<Character> lettersLeft = StringToLettersConverter.convertStringToLetters(stringParameter);
        final LinkedList<LettersPair> lettersPairs = new LinkedList<LettersPair>();
        while (lettersLeft.isEmpty() == false)
        {
            final char firstLetter = lettersLeft.pop();
            if (lettersLeft.peek() == null)
            {
                lettersPairs.add(new LettersPair(firstLetter, 'X'));
            }
            else
            {
                final char secondLetter = lettersLeft.peek();
                if (firstLetter == secondLetter)
                {
                    lettersPairs.add(new LettersPair(firstLetter, 'X'));
                }
                else
                {
                    lettersLeft.pop();
                    lettersPairs.add(new LettersPair(firstLetter, secondLetter));
                }
            }
        }
        return lettersPairs;
    }
}
