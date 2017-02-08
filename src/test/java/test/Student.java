package test;

public class Student {
	
	String name;
	String age;
	String src;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", src=" + src + "]";
	}
	
	
	
	

}
