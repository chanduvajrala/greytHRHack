package com.chimeroom.integration;
import java.util.Date;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chimeroom.models.BookedRooms;
import com.chimeroom.models.ConferenceRoom;
import com.chimeroom.models.Employee;
import com.chimeroom.models.Meeting;


public class DatabaseDriver implements DatabaseDAO {

  private static SessionFactory factory; 
 
  @SuppressWarnings("deprecation")
public DatabaseDriver()
  {
	  try{
        factory = new Configuration().configure().buildSessionFactory();
     }catch (Throwable ex) { 
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex); 
     }
  }
  
//  public static void main(String[] args) {
//     try{
//        factory = new Configuration().configure().buildSessionFactory();
//     }catch (Throwable ex) { 
//        System.err.println("Failed to create sessionFactory object." + ex);
//        throw new ExceptionInInitializerError(ex); 
//     }
//     DatabaseDriver DD = new DatabaseDriver();
//     System.out.println(DD.getRoomMeetingDetails().toString());
//  }
  
  
  /*
   *#################################
   *# 		CONFERENCE ROOM			#
   *#################################
   */
  
  
  @Override
  public ArrayList<ConferenceRoom> listConferenceRooms( ){
     Session session = factory.openSession();
     Transaction tx = null;
     ArrayList<ConferenceRoom> rooms = null;
     try{
        tx = session.beginTransaction();
        Query query = session.createQuery("from ConferenceRoom");
        rooms =  (ArrayList<ConferenceRoom>) query.list();
        //System.out.println(rooms.toString());
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }    
     return rooms;
  }
  
  @Override
  public ArrayList<ConferenceRoom> getConferenceRoomDetails(int roomID ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<ConferenceRoom> room = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from ConferenceRoom C where C.roomID = "+roomID);
	        room =  (ArrayList<ConferenceRoom>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }
	     
	     return room;
	  }
  
  
  /*
   *#################################
   *# 		EMPLOYEES TABLE			#
   *#################################
   */
   
  
  
  @Override
  public ArrayList<Employee> listEmployees( ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<Employee> employees = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from Employee");
	        employees =  (ArrayList<Employee>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }	     
	     return employees;	     
	  }
  
  @Override
  public Employee getEmployeeDetails(int employeeID ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     Employee employee = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from Employee E where E.employeeID = "+employeeID);
	        employee =  (Employee) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }
	     
	     return employee;
	  }
  
  
  
  /*
   *#################################
   *# 		MEETINGS TABLE			#
   *#################################
   */
  
  @Override
  public ArrayList<Meeting> listMeetings( ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<Meeting> meetings = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from Meeting");
	        meetings =  (ArrayList<Meeting>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }
	     
	     return meetings;
	  }
  
  @Override
  public  ArrayList<Meeting> getMeetingDetails(int MeetingID ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<Meeting> meeting = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from Meeting M where M.MeetingID = "+MeetingID);
	        meeting =  ( ArrayList<Meeting>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }
	     
	     return meeting;
	  }
  
  
  @Override
  public  ArrayList<Meeting> getUserMeetingDetails(int EmployeeID ){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<Meeting> meetings = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("from Meeting M where M.EmployeeID = "+EmployeeID);
	        meetings =  ( ArrayList<Meeting>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	     }
	     
	     return meetings;
	  }
  
  
  @Override
  public  ArrayList<Meeting> getRoomMeetingDetails(){
	     Session session = factory.openSession();
	     Transaction tx = null;
	     ArrayList<Meeting> meetings = null;
	     try{
	        tx = session.beginTransaction();
	        Query query = session.createQuery("select room_ID, meetingStartDate, meetingEndDate from Meeting M");
	        meetings =  ( ArrayList<Meeting>) query.list(); 
	        tx.commit();
	     }catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     }finally {
	     }
	     
	     return meetings;
	  }
  
  
  
@Override
public boolean updateMeeting(int MeetingID ,int roomID , Date startDate, Date endDate ){
   Session session = factory.openSession();
   Transaction tx = null;
   boolean flag = false;
   try{
      tx = session.beginTransaction();
      Meeting meeting = 
                 (Meeting)session.get(Meeting.class, MeetingID); 
      
      meeting.setMeetingStartDate(startDate);
      meeting.setMeetingEndDate(endDate);
      meeting.setRoomID(roomID);
      
		 session.update(meeting); 
      tx.commit();
      flag = true;
   }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace(); 
   }finally {
      session.close(); 
   }
   return flag;
}
  
@Override
public Integer addMeeting(int employeeID, int roomID, String meetingDesc, Date meetingStartDate, Date meetingEndDate, int meetingCapacity){

Session session = factory.openSession();
Transaction tx = null;
Integer MeetingID = null;
try{
   tx = session.beginTransaction();
   Meeting meeting = new Meeting(employeeID, roomID, meetingDesc,meetingStartDate,meetingEndDate,meetingCapacity);
   MeetingID = (Integer) session.save(meeting); 
   tx.commit();
}catch (HibernateException e) {
   if (tx!=null) tx.rollback();
   e.printStackTrace(); 
}finally {
   session.close(); 
}
return MeetingID;
}
  
@Override
public String deleteMeeting(int MeetingID){
   Session session = factory.openSession();
   Transaction tx = null;
   try{
      tx = session.beginTransaction();
      Meeting meeting = 
                (Meeting)session.get(Meeting.class, MeetingID); 
      session.delete(meeting); 
      tx.commit();
   }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace(); 
   }finally {
      session.close(); 
   }
   
   return "Success";
}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  

  
  
}