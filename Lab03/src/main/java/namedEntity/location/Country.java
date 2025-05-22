package namedEntity.location;

import namedEntity.*;

    

public class Country extends NamedEntity{

    int population;
    String officialLanguage;

    public Country(String name, int frequency){
        
        super(name, "Country", frequency);
        this.population = -1;
        this.officialLanguage = "";
        

    }
    
    public void setCountryPopulation(int population) {
        this.population = population;
    }

    public int getCountryPopulation() {
        return population;
    }

    public void setOfficialLanguage(String officialLanguage) {
        this.officialLanguage = officialLanguage;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }

    @Override
	public String toString() {
		return "ObjectCountry [name=" + getName() + ", frequency=" + getFrequency() + ", population=" + population + " , officialLanguje=" + officialLanguage +"]";
	}
	public void prettyPrint(){
		System.out.println(this.getName() + " " + this.getFrequency() + " " + this.getCountryPopulation() + " " + this.getOfficialLanguage());
	}
}
