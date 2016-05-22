package com.chimeroom.models;

import java.util.Date;

public class BookedRooms {
	
	int  roomID;
	Date startTime;
	Date endTime;
	int roomCapacity;
	
	public BookedRooms()
	{
		
	}

	@Override
	public String toString() {
		return "BookedRooms [roomID=" + roomID + ", startTime=" + startTime + ", endTime=" + endTime + ", roomCapacity="
				+ roomCapacity + "]";
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public BookedRooms(int roomID, Date startTime, Date endTime, int roomCapacity) {
		super();
		this.roomID = roomID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomCapacity = roomCapacity;
	}

	
	
	
	
	
}
