package namedEntity;

public class Other extends NamedEntity{
    private String coments;

    public Other(String name, int frequency, String coments){
        super(name, "OTHER", frequency);
        this.coments = coments;
    }
    public String getComents(){
        return coments;
    }

    public void  setComents (String comm){
        this.coments = comm;
    }

}