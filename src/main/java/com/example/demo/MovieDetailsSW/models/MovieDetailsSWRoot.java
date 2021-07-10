package com.example.demo.MovieDetailsSW.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table
public class MovieDetailsSWRoot {
	@Id	@Column @GeneratedValue(strategy=GenerationType.AUTO) int id;
	
	public int count;
    //public Object next;
    //public Object previous;
    
	@Column @ElementCollection(targetClass=MovieDetailsSWResult.class)
	@Cascade({CascadeType.ALL})
	@OneToMany()
    public List<MovieDetailsSWResult> results;
    
    public MovieDetailsSWRoot() {}
	public MovieDetailsSWRoot(int count, Object next, Object previous, List<MovieDetailsSWResult> results) {
		super();
		this.count = count;
		//this.next = next;
		//this.previous = previous;
		this.results = results;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//public Object getNext() {
	//	return next;
	//}
	//public void setNext(Object next) {
	//	this.next = next;
	//}
	//public Object getPrevious() {
	//	return previous;
	//}
	//public void setPrevious(Object previous) {
	//	this.previous = previous;
	//}
	public List<MovieDetailsSWResult> getResults() {
		return results;
	}
	public void setResults(List<MovieDetailsSWResult> results) {
		this.results = results;
	}
    
    
}
