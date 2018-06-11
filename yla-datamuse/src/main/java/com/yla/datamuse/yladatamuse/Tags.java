package com.yla.datamuse.yladatamuse;

public class Tags {
	//"tags":["syn","n"]

	private String tag;
	
	

	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Tags(String tag) {
		super();
		this.tag = tag;
	}



	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Tags [tag=" + tag + "]";
	}
	
	
}
