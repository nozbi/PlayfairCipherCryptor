package controller.model.playfairciphercryptor.keymatrix.location;

public final class Location 
{
    private final int x;
    private final int y;

    public Location(final int xParameter, final int yParameter)
    {
        this.x = xParameter;
        this.y = yParameter;
    }

    public final int getX()
    {
        return this.x;
    }

    public final int getY()
    {
        return this.y;
    }
}
