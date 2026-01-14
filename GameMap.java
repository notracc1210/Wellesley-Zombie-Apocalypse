import java.util.ArrayList;
public class GameMap
{
    // instance variables - replace the example below with your own
    private ArrayList<Position> positions;

    /**
     * Constructor for objects of class GameMap
     */
    public GameMap()
    {
        positions = new ArrayList<Position>();
    }

    public void addPosition(Position pos)
    {
        positions.add(pos);
    }

    public Position getPosition(int index)
    {
        return positions.get(index);
    }

    public int getSize()
    {
        return positions.size();
    }

    public ArrayList<Position> getPositions()
    {
        return positions;
    }
}