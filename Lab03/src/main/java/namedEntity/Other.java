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

    @Override
    public String toString() {
        return "Other[name=" + name + ", frequency=" + frequency + " comments="+ coments +"]";
    }
    public void prettyPrint(){
        System.out.println(this.getName() + " " + this.getFrequency() + " " + this.getComents());
    }

}