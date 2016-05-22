package com.chimeroom.models;

public class ConferenceRoom implements Room{

	private int    roomID;
	private String roomName;
	private String roomType;
	private String roomLocation;
	private int    roomCapacity;
	private String   roomProjector;
	private String   roomWifi;
	private String   roomEthernet;
	private String   roomIntercom;
	private String   roomTeleconf;
	private String   roomVideoconf;
	private String   roomWhiteBoard;
	
	
	public ConferenceRoom()
	{
		
	}
	public ConferenceRoom(int roomID,String roomName, String roomType, String roomLocation, int roomCapacity, String roomProjector,
			String roomWifi, String roomEthernet, String roomIntercom, String roomTeleconf, String roomVideoconf,
			String roomWhiteBoard) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomLocation = roomLocation;
		this.roomCapacity = roomCapacity;
		this.roomProjector = roomProjector;
		this.roomWifi = roomWifi;
		this.roomEthernet = roomEthernet;
		this.roomIntercom = roomIntercom;
		this.roomTeleconf = roomTeleconf;
		this.roomVideoconf = roomVideoconf;
		this.roomWhiteBoard = roomWhiteBoard;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public String getRoomProjector() {
		return roomProjector;
	}

	public void setRoomProjector(String roomProjector) {
		this.roomProjector = roomProjector;
	}

	public String getRoomWifi() {
		return roomWifi;
	}

	public void setRoomWifi(String roomWifi) {
		this.roomWifi = roomWifi;
	}

	public String getRoomEthernet() {
		return roomEthernet;
	}

	public void setRoomEthernet(String roomEthernet) {
		this.roomEthernet = roomEthernet;
	}

	public String getRoomIntercom() {
		return roomIntercom;
	}

	public void setRoomIntercom(String roomIntercom) {
		this.roomIntercom = roomIntercom;
	}

	public String getRoomTeleconf() {
		return roomTeleconf;
	}

	public void setRoomTeleconf(String roomTeleconf) {
		this.roomTeleconf = roomTeleconf;
	}

	public String getRoomVideoconf() {
		return roomVideoconf;
	}

	public void setRoomVideoconf(String roomVideoconf) {
		this.roomVideoconf = roomVideoconf;
	}

	public String getRoomWhiteBoard() {
		return roomWhiteBoard;
	}

	public void setRoomWhiteBoard(String roomWhiteBoard) {
		this.roomWhiteBoard = roomWhiteBoard;
	}

		
	@Override
	public String toString() {
		return "ConferenceRoom [roomID=" + roomID + ", roomName=" + roomName + ", roomType=" + roomType
				+ ", roomLocation=" + roomLocation + ", roomCapacity=" + roomCapacity + ", roomProjector="
				+ roomProjector + ", roomWifi=" + roomWifi + ", roomEthernet=" + roomEthernet + ", roomIntercom="
				+ roomIntercom + ", roomTeleconf=" + roomTeleconf + ", roomVideoconf=" + roomVideoconf
				+ ", roomWhiteBoard=" + roomWhiteBoard + "]";
	}
	


	@Override
	public void getDetails() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void getAmenities() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAvailability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bookRoom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRoom() {
		// TODO Auto-generated method stub
		
	}

}
