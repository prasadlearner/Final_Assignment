package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String address;

	private Integer age;

	public Student() {
		System.out.println("Hibernate uses Zero argument constructor internally");
	}

	public Integer getSid() {
		return id;
	}

	public void setSid(Integer sid) {
		this.id = sid;
	}

	public String getSname() {
		return name;
	}

	public void setSname(String sname) {
		this.name = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + id + ", sname=" + name + ", saddress=" + address + ", sage=" + age + "]";
	}

	public String getSaddress() {
		return address;
	}

	public void setSaddress(String saddress) {
		this.address = saddress;
	}

	public Integer getSage() {
		return age;
	}

	public void setSage(Integer sage) {
		this.age = sage;
	}

}
