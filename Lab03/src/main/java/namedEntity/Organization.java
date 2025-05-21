package namedEntity;


public class Organization extends NamedEntity {
    String canonicForm;
    int memberNumber;
    String type;

    public Organization(String name, int frequency) {
        super(name, "Organization", frequency);
        this.canonicForm = "";
        this.memberNumber = 0;
        this.type = "";
    }

    public String getCanonicForm() {
		return canonicForm;
	}

	public void setCanonicForm(String canonicForm) {
		this.canonicForm = canonicForm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

    @Override
	public String toString() {
		return "Organization [canonicForm=" + canonicForm + ", memberNumber=" + memberNumber + ", type=" + type +"]";
	}
    @Override
	public void prettyPrint(){
		System.out.println(this.getCanonicForm() + " " + this.getMemberNumber()+ " " + this.getType());
	}
}