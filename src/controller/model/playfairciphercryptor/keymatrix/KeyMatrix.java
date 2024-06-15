package controller.model.playfairciphercryptor.keymatrix;

import java.util.LinkedList;
import controller.model.playfairciphercryptor.keymatrix.location.Location;

public final class KeyMatrix 
{
    private final char[][] keyMatrix;

    public KeyMatrix(final String keyParameter, final LinkedList<Character> alphabetParameter)
    {
        final char[] keyChars = keyParameter.toCharArray();
        final int size = (int)Math.sqrt((double)alphabetParameter.size());
        this.keyMatrix = new char[size][size];
        int currentY = 0;
        int currentX = 0;
        for (int keyCharIndex = 0; keyCharIndex < keyChars.length; keyCharIndex++)
        {
            final Character keyChar = Character.toUpperCase(keyChars[keyCharIndex]);
            if (alphabetParameter.contains(keyChar) == true)
            {
                alphabetParameter.remove(keyChar);
                this.keyMatrix[currentY][currentX] = keyChar;
                currentX++;
                if (currentX == this.keyMatrix[0].length)
                {
                    currentX = 0;
                    currentY++;
                }
                if (currentY == this.keyMatrix.length)
                {
                    break;
                }
            } 
        }
        for (int x = currentX; x < this.keyMatrix[0].length; x++)
        {
            this.keyMatrix[currentY][x] = alphabetParameter.pop();
        }
        currentY++;
        for (int y = currentY; y < this.keyMatrix.length; y++)
        {
            for (int x = 0; x < this.keyMatrix[0].length; x++)
            {
                this.keyMatrix[y][x] = alphabetParameter.pop();
            }
        }
    }

    public final Location getLetterLocation(final char letterParameter)
    {
        Location location = null;
        for (int y = 0; y < this.keyMatrix.length; y++)
        {
            for (int x = 0; x < this.keyMatrix[0].length; x++)
            {
                if (this.keyMatrix[y][x] == letterParameter)
                {
                    location = new Location(x, y);
                    break; 
                }
            }
        }
        return location;
    }

    public final int getSizeX()
    {
        return this.keyMatrix[0].length;
    }

    public final int getSizeY()
    {
        return this.keyMatrix.length;
    }

    public final char getLetterByLocation(final Location locationParameter)
    {
        return this.keyMatrix[locationParameter.getY()][locationParameter.getX()];
    }
}
