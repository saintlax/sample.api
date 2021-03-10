package com.atbtechsoft.sample.models;

import java.util.List;

public class QueryData {
	
	private List<String> data;
	private String type;
	private int page;
	private int population;
	private long count;
	private String return_only;
	private String sort_by;
	
	public String getReturn_only() {
		return return_only;
	}
	public void setReturn_only(String return_only) {
		this.return_only = return_only;
	}
	public String getSort_by() {
		return sort_by;
	}
	public void setSort_by(String sort_by) {
		this.sort_by = sort_by;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "QueryData [data=" + data + ", type=" + type + ", page=" + page + ", population=" + population
				+ ", count=" + count + ", return_only=" + return_only + ", sort_by=" + sort_by + "]";
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
