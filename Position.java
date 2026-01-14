import java.util.ArrayList;

class Position
{
    String name;
    String description;
    ArrayList<Option> options;
    
    public Position(String n, String d){
        name = n;
        description = d;
        options = new ArrayList<>();
    }
    
    public void addOption(Option o){
        options.add(o);
    }
    
}
