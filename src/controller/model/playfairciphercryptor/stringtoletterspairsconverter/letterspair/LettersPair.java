package controller.model.playfairciphercryptor.stringtoletterspairsconverter.letterspair;

public final class LettersPair 
{
    private final char firstLetter;
    private final char secondLetter;

    public LettersPair(final char firstLetterParameter, final char secondLetterParameter)
    {
        this.firstLetter = firstLetterParameter;
        this.secondLetter = secondLetterParameter;
    }

    public final char getFirstLetter()
    {
        return this.firstLetter;
    }

    public final char getSecondLetter()
    {
        return this.secondLetter;
    }
}
