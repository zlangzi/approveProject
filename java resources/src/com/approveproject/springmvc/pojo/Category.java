package com.approveproject.springmvc.pojo;

public class Category {
    private Integer id;

    private String name;

    private String description;

    private Integer parent_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", parent_id=" + parent_id
				+ "]";
	}
    
    
}