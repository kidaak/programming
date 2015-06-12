package model;

public class User {
	private String name;
	private String description;
	private String imageSrc;

	public User(String name, String description, String imageSrc) {
		this.name = name;
		this.description = description;
		this.imageSrc = imageSrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

}
