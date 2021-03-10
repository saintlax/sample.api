package com.atbtechsoft.sample.utils;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {

	private List<T> myList = new ArrayList<>();

    public void addList(T o) {
        myList.add(o);
    }
    
    public List<T> getList(){
    	return myList;
    }
}
