package com.chimeroom.integration;

import java.util.Date;
import java.util.ArrayList;

import com.chimeroom.models.BookedRooms;
import com.chimeroom.models.ConferenceRoom;
import com.chimeroom.models.Employee;
import com.chimeroom.models.Meeting;




public interface DatabaseDAO {
	 public ArrayList<ConferenceRoom> listConferenceRooms( );
	 public ArrayList<ConferenceRoom> getConferenceRoomDetails(int roomID );
	 public Employee getEmployeeDetails(int employeeID);
	 public ArrayList<Employee> listEmployees();
	 public ArrayList<Meeting> listMeetings();
	 public ArrayList<Meeting> getMeetingDetails(int MeetingID);
	 public boolean updateMeeting(int MeetingID, int roomID, Date startDate, Date endDate);
	 public Integer addMeeting(int employeeID, int roomID, String meetingDesc, Date date, Date date2,int meetingCapacity);
	 public String deleteMeeting(int MeetingID);
	 public ArrayList<Meeting> getUserMeetingDetails(int EmployeeID);
	 public ArrayList<Meeting> getRoomMeetingDetails();
	 
}
