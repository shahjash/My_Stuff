package telecomm_model;

import java.util.ArrayList;

public class CorpTelecomm {

	private ArrayList<String> arry=new ArrayList<>(); // to store plan names

	public CorpTelecomm(ArrayList<String> arr){
//		System.out.println("Model Constructor reached");
		this.arry=arr;
	}

	public ArrayList<String> getCorpTelecomm(){
		return this.arry;
	}

	public void setCorpTelecomm(ArrayList<String> arr){
		this.arry=arr;
	}

}
