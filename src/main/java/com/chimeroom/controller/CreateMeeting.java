package com.chimeroom.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;

import com.chimeroom.integration.DatabaseDAO;
import com.chimeroom.integration.DatabaseDriver;
import com.chimeroom.models.ConferenceRoom;
import com.chimeroom.models.Meeting;

public class CreateMeeting {
	
	PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>();
	DatabaseDAO dao = new DatabaseDriver();
		
	public CreateMeeting()
	{
		
	}
	
	
	
	public String createMeeting(Meeting meeting)
	{
		queue.add(meeting);
		Date meetingstartDate = meeting.getMeetingStartDate();
		Date meetingendDate = meeting.getMeetingEndDate();
		int meetingroomID = meeting.getRoomID();
		int meetingcapacity = meeting.getMeetingCapacity();
		
		while(queue.size() > 0)
		{
			Meeting m = queue.remove();
			ArrayList<Meeting> list = dao.listMeetings();
			
			for (Iterator i = list.iterator(); i.hasNext(); ) 
			{
				Meeting meet = (Meeting) i.next();
				boolean flag = true;
				Date meetstartDate = meet.getMeetingStartDate();
				Date meetendDate = meet.getMeetingEndDate();
				int meetroomID = meet.getRoomID();
				
				if(meetroomID == meetingroomID)
				{
					int best  = 99;
					
					if( meetstartDate.before(meetingstartDate) && meetendDate.after(meetingendDate) )
					{
						flag = false;
					}
					else if( meetstartDate.after(meetingstartDate) && meetendDate.before(meetingendDate) )
					{
						flag = false;
					}
					else if(meetstartDate.before(meetingstartDate) && meetendDate.before(meetingendDate) )
					{
						flag = false;
					}
					else if(meetstartDate.after(meetingstartDate) && meetendDate.after(meetingendDate) )
					{
						flag = false;
					}
					else
					{
						if(flag = true)
						{
							
							ArrayList<ConferenceRoom> rooms = dao.getConferenceRoomDetails(meetroomID);
							
							for (Iterator k = rooms.iterator(); k.hasNext(); ) 
							{
								ConferenceRoom room = (ConferenceRoom) k.next();
								int roomcap = room.getRoomCapacity();
								
								if( roomcap > meetingcapacity )
								{
									best = room.getRoomID();
									
								}
							
							}							
						 dao.addMeeting(meeting.getEmployeeID(), best, meeting.getMeetingDesc(), 
								 meeting.getMeetingStartDate(), meeting.getMeetingEndDate() , meeting.getMeetingCapacity() );
												
						}
						
						
					}
							
				}
				else
				{
					 dao.addMeeting(meeting.getEmployeeID(), meet.getRoomID(), meeting.getMeetingDesc(), 
							 meeting.getMeetingStartDate(), meeting.getMeetingEndDate() , meeting.getMeetingCapacity() );
				}
				
				if(flag = true)
				{
					return "Success";			
				}	
			} 
	
		}
		
			return "false";
	}
	
}
