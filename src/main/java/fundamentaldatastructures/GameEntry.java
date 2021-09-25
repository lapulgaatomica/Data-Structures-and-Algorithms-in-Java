package fundamentaldatastructures;

public class GameEntry {
    private final String name;
    private final int score;

    public GameEntry(String n, int s){
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString(){
        return "(" + name + ", " + score + ")";
    }
}
