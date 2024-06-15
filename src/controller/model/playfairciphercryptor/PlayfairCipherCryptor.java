package controller.model.playfairciphercryptor;

import java.math.BigInteger;
import java.util.LinkedList;
import controller.model.playfairciphercryptor.keymatrix.KeyMatrix;
import controller.model.playfairciphercryptor.keymatrix.location.Location;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.StringToLettersPairsConverter;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.letterspair.LettersPair;
import controller.model.playfairciphercryptor.stringtoletterspairsconverter.stringtolettersconverter.alphabet.Alphabet;

public final class PlayfairCipherCryptor 
{
    private PlayfairCipherCryptor()
    {

    }

    public static final String encrypt(final String stringParameter, final String keyParameter)
    {
        final KeyMatrix keyMatrix = new KeyMatrix(keyParameter, Alphabet.getAlphabet());
        final LinkedList<LettersPair> lettersPairs = StringToLettersPairsConverter.convertStringToLettersPairs(stringParameter);
        final StringBuilder stringBuilder = new StringBuilder();
        while (lettersPairs.isEmpty() == false)
        {
            final LettersPair lettersPair = lettersPairs.pop();
            final Location firstLetterLocation = keyMatrix.getLetterLocation(lettersPair.getFirstLetter());
            final Location secondLetterLocation = keyMatrix.getLetterLocation(lettersPair.getSecondLetter());
            int newFirstLetterLocationX = firstLetterLocation.getX();
            int newSecondLetterLocationX = secondLetterLocation.getX();
            int newFirstLetterLocationY = firstLetterLocation.getY();
            int newSecondLetterLocationY = secondLetterLocation.getY();
            if (firstLetterLocation.getY() == secondLetterLocation.getY())
            {
                newFirstLetterLocationX = firstLetterLocation.getX() + 1;
                newSecondLetterLocationX = secondLetterLocation.getX() + 1;
                if (newFirstLetterLocationX == keyMatrix.getSizeX())
                {
                    newFirstLetterLocationX = 0;
                }
                if (newSecondLetterLocationX == keyMatrix.getSizeX())
                {
                    newSecondLetterLocationX = 0;
                }
            }
            else if (firstLetterLocation.getX() == secondLetterLocation.getX())
            {
                newFirstLetterLocationY = firstLetterLocation.getY() + 1;
                newSecondLetterLocationY = secondLetterLocation.getY() + 1;
                if (newFirstLetterLocationY == keyMatrix.getSizeY())
                {
                    newFirstLetterLocationY = 0;
                }
                if (newSecondLetterLocationY == keyMatrix.getSizeY())
                {
                    newSecondLetterLocationY = 0;
                }
            }
            else
            {
                newFirstLetterLocationX = secondLetterLocation.getX();
                newSecondLetterLocationX = firstLetterLocation.getX();
            }
            final char newFirstLetter = keyMatrix.getLetterByLocation(new Location(newFirstLetterLocationX, newFirstLetterLocationY));
            final char newSecondLetter = keyMatrix.getLetterByLocation(new Location(newSecondLetterLocationX, newSecondLetterLocationY));
            stringBuilder.append(newFirstLetter);
            stringBuilder.append(newSecondLetter);
        }
        return stringBuilder.toString();
    }

    public static final String decrypt(final String stringParameter, final String keyParameter)
    {
        final KeyMatrix keyMatrix = new KeyMatrix(keyParameter, Alphabet.getAlphabet());
        final LinkedList<LettersPair> lettersPairs = StringToLettersPairsConverter.convertStringToLettersPairs(stringParameter);
        final StringBuilder stringBuilder = new StringBuilder();
        while (lettersPairs.isEmpty() == false)
        {
            final LettersPair lettersPair = lettersPairs.pop();
            final Location firstLetterLocation = keyMatrix.getLetterLocation(lettersPair.getFirstLetter());
            final Location secondLetterLocation = keyMatrix.getLetterLocation(lettersPair.getSecondLetter());
            int newFirstLetterLocationX = firstLetterLocation.getX();
            int newSecondLetterLocationX = secondLetterLocation.getX();
            int newFirstLetterLocationY = firstLetterLocation.getY();
            int newSecondLetterLocationY = secondLetterLocation.getY();
            if (firstLetterLocation.getY() == secondLetterLocation.getY())
            {
                newFirstLetterLocationX = firstLetterLocation.getX() - 1;
                newSecondLetterLocationX = secondLetterLocation.getX() - 1;
                if (newFirstLetterLocationX == -1)
                {
                    newFirstLetterLocationX = keyMatrix.getSizeX() - 1;
                }
                if (newSecondLetterLocationX == -1)
                {
                    newSecondLetterLocationX = keyMatrix.getSizeX() - 1;
                }
            }
            else if (firstLetterLocation.getX() == secondLetterLocation.getX())
            {
                newFirstLetterLocationY = firstLetterLocation.getY() - 1;
                newSecondLetterLocationY = secondLetterLocation.getY() - 1;
                if (newFirstLetterLocationY == -1)
                {
                    newFirstLetterLocationY = keyMatrix.getSizeY() - 1;
                }
                if (newSecondLetterLocationY == -1)
                {
                    newSecondLetterLocationY = keyMatrix.getSizeY() - 1;
                }
            }
            else
            {
                newFirstLetterLocationX = secondLetterLocation.getX();
                newSecondLetterLocationX = firstLetterLocation.getX();
            }
            final char newFirstLetter = keyMatrix.getLetterByLocation(new Location(newFirstLetterLocationX, newFirstLetterLocationY));
            final char newSecondLetter = keyMatrix.getLetterByLocation(new Location(newSecondLetterLocationX, newSecondLetterLocationY));
            stringBuilder.append(newFirstLetter);
            stringBuilder.append(newSecondLetter);
        }
        return stringBuilder.toString();
    }
    
    public static final LinkedList<String> getAllPossibleKeys(final int keyLengthParameter) 
    {
        final BigInteger alphabetLength = BigInteger.valueOf(Alphabet.getLength());
        final BigInteger numberOfKeys = alphabetLength.pow(keyLengthParameter);
        final LinkedList<String> keys = new LinkedList<String>();
        BigInteger keyIndex = BigInteger.valueOf(0);
        while (keyIndex.equals(numberOfKeys) == false)
        {
            final LinkedList<Integer> usedLettersIndexes = new LinkedList<Integer>();
            final StringBuilder stringBuilder = new StringBuilder();
            BigInteger currentLetterIndexSource = new BigInteger(keyIndex.toString());
            for (int letterPlaceIndex = 0; letterPlaceIndex < keyLengthParameter; letterPlaceIndex++) 
            {
                final int letterIndex = currentLetterIndexSource.remainder(alphabetLength).intValue();
                if (usedLettersIndexes.contains(letterIndex) == true)
                {
                    break;
                }
                else
                {
                    usedLettersIndexes.add(letterIndex);
                    stringBuilder.append(Alphabet.getLetterByIndex(letterIndex));
                    currentLetterIndexSource = currentLetterIndexSource.divide(alphabetLength);
                }
            }
            if (stringBuilder.length() == keyLengthParameter)
            {
                stringBuilder.reverse();
                keys.add(stringBuilder.toString());
            }
            keyIndex = keyIndex.add(BigInteger.ONE);
        }
        return keys;
    }
}
