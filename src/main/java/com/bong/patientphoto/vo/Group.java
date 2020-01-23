package com.bong.patientphoto.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Group {
	private int id;
	private int groupType;  //1: 기관(병원 대표), 2: 주치의, 3. 기관 내 소모임.  4:기관 외 모임, 5: 홍보 단체
	private int parentGroupId; 
	private String parentGroupName;
	private String parentGroupIconUrl;
	private String groupName;
	private String groupText;
	private String groupIconUrl;
	private String groupDetailPhotoUrl1;
	private String groupDetailPhotoUrl2;
	private String groupDetailPhotoUrl3;
	private int adminUserId;
	private int presidentUserId;
	private int secret; //0:공개, 1:비공개그룹, 2:휴면그룹
	private Date createdTime;
	private int joinRequest;
	
	//Group_user
	private int groupId;
	private int userId;
	private int userLevel; //0: 승인대기, 1: 구독 (r), 2: 일반 (rw), 3: 관리자, 4: 대표자
	private Timestamp joinDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupType() {
		return groupType;
	}
	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}
	public int getParentGroupId() {
		return parentGroupId;
	}
	public void setParentGroupId(int parentGroupId) {
		this.parentGroupId = parentGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupIconUrl() {
		return groupIconUrl;
	}
	public void setGroupIconUrl(String groupIconUrl) {
		this.groupIconUrl = groupIconUrl;
	}
	public String getGroupDetailPhotoUrl1() {
		return groupDetailPhotoUrl1;
	}
	public void setGroupDetailPhotoUrl1(String groupDetailPhotoUrl1) {
		this.groupDetailPhotoUrl1 = groupDetailPhotoUrl1;
	}
	public String getGroupDetailPhotoUrl2() {
		return groupDetailPhotoUrl2;
	}
	public void setGroupDetailPhotoUrl2(String groupDetailPhotoUrl2) {
		this.groupDetailPhotoUrl2 = groupDetailPhotoUrl2;
	}
	public String getGroupDetailPhotoUrl3() {
		return groupDetailPhotoUrl3;
	}
	public void setGroupDetailPhotoUrl3(String groupDetailPhotoUrl3) {
		this.groupDetailPhotoUrl3 = groupDetailPhotoUrl3;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public int getPresidentUserId() {
		return presidentUserId;
	}
	public void setPresidentUserId(int presidentUserId) {
		this.presidentUserId = presidentUserId;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getGroupText() {
		return groupText;
	}
	public void setGroupText(String groupText) {
		this.groupText = groupText;
	}
	public int getJoinRequest() {
		return joinRequest;
	}
	public void setJoinRequest(int joinRequest) {
		this.joinRequest = joinRequest;
	}
	public String getParentGroupName() {
		return parentGroupName;
	}
	public void setParentGroupName(String parentGroupName) {
		this.parentGroupName = parentGroupName;
	}
	public String getParentGroupIconUrl() {
		return parentGroupIconUrl;
	}
	public void setParentGroupIconUrl(String parentGroupIconUrl) {
		this.parentGroupIconUrl = parentGroupIconUrl;
	}
	
	
}
