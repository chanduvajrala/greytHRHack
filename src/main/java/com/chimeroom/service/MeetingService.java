package com.chimeroom.service;


import java.util.ArrayList;
import java.util.PriorityQueue;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chimeroom.controller.CreateMeeting;
import com.chimeroom.integration.DatabaseDAO;
import com.chimeroom.integration.DatabaseDriver;
import com.chimeroom.models.ConferenceRoom;
import com.chimeroom.models.Employee;
import com.chimeroom.models.Meeting;


@RestController
public class MeetingService {

	DatabaseDAO dao = new DatabaseDriver();
	
	public MeetingService()
	{
		
	}
	
	
	
	@RequestMapping("/greet")
	public @ResponseBody String greeting()
	{
		return "Hello Awesome Person";
		
	}
	
	
	@RequestMapping(value="/get/employees",
					method= RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE )
	public String getEmployeeList()
	{
		
		ArrayList<Employee> employee = dao.listEmployees();
		return employee.toString();
	}
	
	
	
	@RequestMapping(value="/get/rooms",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public String getConferenceRoomList()
	{
		ArrayList<ConferenceRoom> rooms = dao.listConferenceRooms();	
		return rooms.toString();
	}
	
	
	
	
	@RequestMapping(value="/get/meetings",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public String getMeetingList()
	{

		ArrayList<Meeting> meetings = dao.listMeetings();
		return meetings.toString();
	}
	
	

	@RequestMapping(value="/save/meetings/",
			method= RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> createMeeting(@RequestBody Meeting meeting)
	{
		Meeting savedMeeting = (Meeting) meeting;
		CreateMeeting cm = new CreateMeeting();
		
		String status = cm.createMeeting(savedMeeting);
		
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/delete/meetings/{meeting_ID}")
	public ResponseEntity<String> deleteMeeting(@RequestBody int MeetingID)
	{

		String status = dao.deleteMeeting(MeetingID);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
	
	
	

	
}
