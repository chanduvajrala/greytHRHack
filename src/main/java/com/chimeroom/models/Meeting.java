package com.chimeroom.models;

import java.util.Date;

public class Meeting {

	private int meetingID;
	private int employeeID;
	private int roomID;
	private String meetingDesc;
	private Date meetingStartDate;
	private Date meetingEndDate;
	private int meetingCapacity;
	
	
	public Meeting()
	{
		
	}
	
	public Meeting( int employeeID, int roomID, String meetingDesc, Date meetingStartDate,
			Date meetingEndDate, int meetingCapacity) {
		super();
		this.employeeID = employeeID;
		this.roomID = roomID;
		this.meetingDesc = meetingDesc;
		this.meetingStartDate = meetingStartDate;
		this.meetingEndDate = meetingEndDate;
		this.meetingCapacity = meetingCapacity;
	}
	
	public Meeting(int roomID,Date meetingStartDate,Date meetingEndDate)
	{
		super();
		this.roomID = roomID;
		this.meetingStartDate = meetingStartDate;
		this.meetingEndDate = meetingEndDate;
		
	}
	
	
	public int getMeetingID() {
		return meetingID;
	}
	public void setMeetingID(int meetingID) {
		this.meetingID = meetingID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getMeetingDesc() {
		return meetingDesc;
	}
	public void setMeetingDesc(String meetingDesc) {
		this.meetingDesc = meetingDesc;
	}
	public Date getMeetingStartDate() {
		return meetingStartDate;
	}
	public void setMeetingStartDate(Date meetingStartDate) {
		this.meetingStartDate = meetingStartDate;
	}
	public Date getMeetingEndDate() {
		return meetingEndDate;
	}
	public void setMeetingEndDate(Date meetingEndDate) {
		this.meetingEndDate = meetingEndDate;
	}
	public int getMeetingCapacity() {
		return meetingCapacity;
	}
	public void setMeetingCapacity(int meetingCapacity) {
		this.meetingCapacity = meetingCapacity;
	}
	@Override
	public String toString() {
		return "Meeting [meetingID=" + meetingID + ", employeeID=" + employeeID + ", roomID=" + roomID
				+ ", meetingDesc=" + meetingDesc + ", meetingStartDate=" + meetingStartDate + ", meetingEndDate="
				+ meetingEndDate + ", meetingCapacity=" + meetingCapacity + "]";
	}
	
	
	
	
}
