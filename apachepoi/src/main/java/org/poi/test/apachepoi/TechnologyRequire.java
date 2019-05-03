package org.poi.test.apachepoi;

import java.util.Date;

public class TechnologyRequire {
	
private int requireId;
	
	private int userId;
	
	private String requireName;
	
	private double investPrice;
	
	private String category1;
	
	private String category2;
	
	private String category3;
	
	private String industrySituation;  //以#号分隔
	
	private String province;
	
	private String city;
	
	private String county;
	
	private String area; //以#号分隔
	
	private Date deadline;
	
	private String keyword; //以#分隔
	
	private String content;
	
	private Date gmtCreate;
	
	private Date gmtModified;
	
	private String requireState;
	
	private int ontop;

	public TechnologyRequire() {
		// TODO Auto-generated constructor stub
	}

	public TechnologyRequire(int requireId, int userId, String requireName, double investPrice, String category1,
			String category2, String category3, String industrySituation, String province, String city, String county,
			String area, Date deadline, String keyword, String content, Date gmtCreate, Date gmtModified,
			String requireState, int ontop) {
		super();
		this.requireId = requireId;
		this.userId = userId;
		this.requireName = requireName;
		this.investPrice = investPrice;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.industrySituation = industrySituation;
		this.province = province;
		this.city = city;
		this.county = county;
		this.area = area;
		this.deadline = deadline;
		this.keyword = keyword;
		this.content = content;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.requireState = requireState;
		this.ontop = ontop;
	}

	public int getRequireId() {
		return requireId;
	}

	public void setRequireId(int requireId) {
		this.requireId = requireId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRequireName() {
		return requireName;
	}

	public void setRequireName(String requireName) {
		this.requireName = requireName;
	}

	public double getInvestPrice() {
		return investPrice;
	}

	public void setInvestPrice(double investPrice) {
		this.investPrice = investPrice;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getIndustrySituation() {
		return industrySituation;
	}

	public void setIndustrySituation(String industrySituation) {
		this.industrySituation = industrySituation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getRequireState() {
		return requireState;
	}

	public void setRequireState(String requireState) {
		this.requireState = requireState;
	}

	public int getOntop() {
		return ontop;
	}

	public void setOntop(int ontop) {
		this.ontop = ontop;
	}

	@Override
	public String toString() {
		return "TechnologyRequire [requireId=" + requireId + ", userId=" + userId + ", requireName=" + requireName
				+ ", investPrice=" + investPrice + ", category1=" + category1 + ", category2=" + category2
				+ ", category3=" + category3 + ", industrySituation=" + industrySituation + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", area=" + area + ", deadline=" + deadline + ", keyword="
				+ keyword + ", content=" + content + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", requireState=" + requireState + ", ontop=" + ontop + "]";
	}
	
	
	

}
