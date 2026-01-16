import java.util.ArrayList;

public class Position
{
    String name;
    String description;
    ArrayList<Option> options;
    
    public Position(String n, String d){
        name = n;
        description = d;
        options = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    
    public void addOption(Option o){
        options.add(o);
    }

    public ArrayList<Option> getOptions(){
        return options;
    }
    
}
