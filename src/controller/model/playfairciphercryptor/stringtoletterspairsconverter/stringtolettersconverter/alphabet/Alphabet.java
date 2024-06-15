package controller.model.playfairciphercryptor.stringtoletterspairsconverter.stringtolettersconverter.alphabet;

import java.util.LinkedList;

public final class Alphabet 
{
    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private Alphabet()
    {

    }

    public static final int getLength()
    {
        return Alphabet.alphabet.length;
    }

    public static final char getLetterByIndex(final int indexParameter)
    {
        return Alphabet.alphabet[indexParameter];
    }

    public static final boolean contains(final char letterParameter) 
    {
        for (int i = 0; i < Alphabet.alphabet.length; i++)
        {
            if (letterParameter == Alphabet.alphabet[i])
            {
                return true;
            }
        }
        return false;
    }

    public static final LinkedList<Character> getAlphabet() 
    {
        final LinkedList<Character> alphabetList = new LinkedList<Character>();
        for (int letterIndex = 0; letterIndex < Alphabet.alphabet.length; letterIndex++)
        {
            alphabetList.add(Alphabet.alphabet[letterIndex]);
        }
        return alphabetList;
    }
}