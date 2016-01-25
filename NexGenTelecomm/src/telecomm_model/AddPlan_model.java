package telecomm_model;

public class AddPlan_model {

	private String plan_name; //plan name that need to be added
	private String plan_type; // plan type (corporate or regular)

// Setter Getter for atributes of tha class

	public String getPlanName(){
		return this.plan_name.trim();
	}

	public void setPlanName(String plan_name){
		this.plan_name=plan_name;
	}

	public String getPlanType(){
		return this.plan_type.trim();
	}

	public void setPlanType(String plan_type){
		this.plan_type=plan_type;
	}

}
