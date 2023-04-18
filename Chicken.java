package chickennuggets;

public class Chicken{
    public String chickenName;
    static int chickenCount;

    public Chicken(String name){
        chickenName = name;
        chickenCount += 1;
    }
}