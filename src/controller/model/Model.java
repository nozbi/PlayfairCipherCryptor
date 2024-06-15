package controller.model;

import java.util.LinkedList;
import controller.model.playfairciphercryptor.PlayfairCipherCryptor;

public final class Model 
{
    public Model()
    {

    }

    public final String encrypt(final String stringParameter, final String keyParameter)
    {
        return PlayfairCipherCryptor.encrypt(stringParameter, keyParameter);
    }

    public final String decrypt(final String stringParameter, final String keyParameter)
    {
        return PlayfairCipherCryptor.decrypt(stringParameter, keyParameter);
    }

    public final String bruteForceAttack(final String stringParameter, final int keyLengthParameter)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        final LinkedList<String> keys = PlayfairCipherCryptor.getAllPossibleKeys(keyLengthParameter);
        while (keys.isEmpty() == false)
        {
            final String key = keys.pop();
            stringBuilder.append("Key: ");
            stringBuilder.append(key);
            stringBuilder.append("\n\n");
            stringBuilder.append(PlayfairCipherCryptor.decrypt(stringParameter, key));
            stringBuilder.append("\n\n\n\n");
        }
        return stringBuilder.toString();
    }
}
