package com.techpixe.entity;

public class StudentDTO
{
	private Long id;
	private String name;
	private String branch;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public StudentDTO(Long id, String name, String branch)
	{
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
	}
	public StudentDTO()
	{
		super();
	}
	
	
	
	
	
}
