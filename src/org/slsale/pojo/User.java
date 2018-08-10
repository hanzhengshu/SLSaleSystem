package org.slsale.pojo;

import java.util.Date;
//对应用户表
public class User extends Base{
	//登录账号
	private String loginCode;
	//登录密码
	private String password;
	//二级密码
	private String password2;
	//用户真实姓名
	private String userName;
	//性别
	private String sex;
	//生日
	private Date birthday;
	//证件类型 id 来源于数据字典表 data_dictionary 中typeCode =’CARD_TYPE’的 valueId
	private String cardType;
	//证件类型 name  来源于数据字典表 data_dictionary 中typeCode =’CARD_TYPE’的 valueName
	private String cardTypeName;
	//证件号码（必填）
	private String idCard;
	//收货国家
	private String country;
	//手机（必填）
	private String mobile;
	//电邮
	private String email;
	//收货住址
	private String userAddress;
	//邮政编码
	private String postCode;
	//创建时间
	private Date createTime;
	//推荐人id
	private Integer referId;
	//推荐人编码
	private String referCode;
	//所属角色id
	private Integer roleId;
	//所属角色名称
	private String roleName;
	//用户类型id	来源于数据字典表 data_dictionary 中typeCode =’USER_TYPE’的 valueId
	private String userType;
	//用户类型name		来源于数据字典表 data_dictionary 中typeCode =’USER_TYPE’的 valueName
	private String userTypeName;
	//是否启用
	private Integer isStart;
	//最新更新时间
	private Date lastUpdateTime;
	//最后登录时间
	private Date lastLoginTime;
	//开户行
	private String bankName;
	//开户人
	private String accountHolder;
	//开户卡号
	private String bankAccount;
	//身份证照片存放路径
	private String idCardPicPath;
	//银行卡照片存放路径
	private String bankPicPath;  
	
	
	public String getIdCardPicPath() {
		return idCardPicPath;
	}
	public void setIdCardPicPath(String idCardPicPath) {
		this.idCardPicPath = idCardPicPath;
	}
	public String getBankPicPath() {
		return bankPicPath;
	}
	public void setBankPicPath(String bankPicPath) {
		this.bankPicPath = bankPicPath;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardTypeName() {
		return cardTypeName;
	}
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getReferId() {
		return referId;
	}
	public void setReferId(Integer referId) {
		this.referId = referId;
	}
	public String getReferCode() {
		return referCode;
	}
	public void setReferCode(String referCode) {
		this.referCode = referCode;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public Integer getIsStart() {
		return isStart;
	}
	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	

}
