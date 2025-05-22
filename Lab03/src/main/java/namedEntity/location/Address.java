package namedEntity.location;

import namedEntity.*;

public class Address extends NamedEntity {

    City city;

    public Address(String name, int frequency){
        super(name, "Address", frequency);
        this.city = null;;

    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
	public String toString() {
		return "ObjectAddress [name=" + getName() + ", frequency=" + getFrequency() + ", city=" + city.getName() + "]";
	}
	public void prettyPrint(){
		System.out.println(this.getName() + " " + this.getFrequency() + " " + this.city.getName());
	}
}