/**Email.java
 * org.poi.test.apachepoi
 * 用于存储“用户-邮箱信息”的POJO
 * @author liar
 * 2019年8月14日 下午3:12:31
 * @version 1.0
 */
package org.poi.test.apachepoi;


public class Email {

	@Override
	public String toString() {
		return "Email [ID=" + ID + ", Name=" + Name + ", Type=" + Type + ", emailAddr=" + emailAddr + "]";
	}

	private int ID;
	
	private String Name;
	
	private String Type;
	
	private String emailAddr;
	
	public Email(){
		
	}

	public Email(int iD, String name, String type, String emailAddr) {
		super();
		ID = iD;
		Name = name;
		Type = type;
		this.emailAddr = emailAddr;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	
	
	
	
}
