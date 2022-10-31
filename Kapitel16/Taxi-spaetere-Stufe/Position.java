/**
 * Modellierung einer Position in einer Stadt.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */
public class Position
{
    private int x;
    private int y;

    /**
     * Modellierung einer Position in einer Stadt.
     * @param x  die x-Koordinate, muss größer gleich null sein.
     * @param y  die y-Koordinate, muss größer gleich null sein.
     * @throws IllegalArgumentException  bei negativen Koordinaten
     */
    public Position(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                        "Negative x-Koordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                        "Negative y-Koordinate: " + y);
        }
        this.x = x;
        this.y = y;
    }
    
    /**
     * Erzeuge die nächste Position, die auf dem Weg
     * zum Ziel besucht werden muss.
     * @param  ziel das Ziel
     * @return  eine Position in direkter Linie von
     *          dieser Position bis zum Ziel
     */
    public Position naechstePosition(Position ziel)
    {
        int zielX = ziel.gibX();
        int zielY = ziel.gibY();
        int deltaX = x < zielX ? 1 : x > zielX ? -1 : 0;
        int deltaY = y < zielY ? 1 : y > zielY ? -1 : 0;
        if(deltaX != 0 || deltaY != 0) {
            return new Position(x + deltaX, y + deltaY);
        }
        else {
            return ziel;
        }
    }

    /**
     * Berechne die Anzahl der Schritte, die von dieser
     * Position zum angegebenen Ziel zu machen sind.
     * @param ziel  das gewünschte Ziel
     * @return  die Anzahl der Schritte zum Ziel
     */
    public int schritteZu(Position ziel)
    {
        int xSchritte = Math.abs(ziel.gibX() - x);
        int ySchritte = Math.abs(ziel.gibY() - y);
        return Math.max(xSchritte, ySchritte);
    }
    
    /**
     * Vergleiche mit jener Position auf Datengleichheit.
     * @return true  wenn diese Position gleich zu jener
     *               ist, false sonst
     */
    public boolean equals(Object jener)
    {
        if(jener instanceof Position) {
            Position jenePosition = (Position) jener;
            return x == jenePosition.gibX() &&
                   y == jenePosition.gibY();
        }
        else {
            return false;
        }
    }
    
    /**
     * @return  eine Darstellung dieser Position
     */
    public String toString()
    {
        return "Position " + x + "," + y;
    }
    
    /**
     * Verwende die oberen 16 Bit für den y-Wert und die unteren für den x-Wert.
     * Mit Ausnahme von sehr großen Gittern sollte dies einen eindeutigen Hash-Code
     * für jedes (x, y)-Paar ergeben.
     * @return  einen Hash-Code für die Position
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
    
    /**
     * @return  die x-Koordinate
     */
    public int gibX()
    {
        return x;
    }

    /**
     * @return  die y-Koordinate
     */
    public int gibY()
    {
        return y;
    }
}
