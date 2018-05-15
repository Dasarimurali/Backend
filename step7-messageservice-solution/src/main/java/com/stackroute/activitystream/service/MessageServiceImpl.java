package com.stackroute.activitystream.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserTag;
import com.stackroute.activitystream.repository.MessageRepository;
import com.stackroute.activitystream.repository.UserTagRepository;

/*
* Service classes are used here to implement additional business logic/validation. 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn’t currently 
* provide any additional behavior over the @Component annotation, but it’s a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
public class MessageServiceImpl implements MessageService {

	@Autowired
	private UserTagRepository userTagRepo;
	@Autowired
	private MessageRepository messageRepo;

	/*
	 * * This method should be used to get all messages from a specific circle. Call
	 * the corresponding method of Respository interface. *
	 */ public List<Message> getMessagesFromCircle(String circleName, int pageNumber) {
		return messageRepo.getMessagesFromCircle(circleName);
	}

	/*
	 * * This method should be used to get all messages from a specific user to
	 * another * specific user. Call the corresponding method of Respository
	 * interface.
	 */ public List<Message> getMessagesFromUser(String username, String otherUsername, int pageNumber) {
		return messageRepo.getMessagesFromUser(username, otherUsername);
	}

	/*
	 * * This method should be used to send messages to a specific circle. Please
	 * validate * whether the circle exists and whether the sender is subscribed to
	 * the circle. Call the corresponding method of Respository interface.
	 */ public boolean sendMessageToCircle(String circleName,Message message) { 		
		 //UserCircle cir = userCircleRepo.getUsernameAndCircleName(message.getSenderName(),circleName); 
		 if(message.getCircleName()!=null) { 	
			 messageRepo.save(message); 	
			 return true; 	
			 }else { 	
				 return false; 	
				 } 	} 	
	 /* 	 * This method should be used to send messages to a specific user. Please validate 	 * whether the sender and receiver are valid users. Call the corresponding method of Respository interface. 	 */ 
	 public boolean sendMessageToUser(String username,Message message) { 
		 //User sender = userRepo.findOne(message.getSenderName()); 	
		 //User reciever = userRepo.findOne(username); 	
		 if(message.getSenderName()!=null && message.getReceiverId()!=null) { 	
			 messageRepo.save(message); 		
			 return true; 		
			 }else { 		
				 return false; 	
				 } 	} 		
	 /* 	 * This method should be used to list out all tags from all existing messages. Call the corresponding method of Respository interface. 	 */ 
	 public List<String> listTags() { 	
		 return messageRepo.listAllTags(); 		
		 } 	
	 /* 	 * This method should be used to list out all subscribed tags by a specific 
	  * 	 * user. Call the corresponding method of Respository interface. 	 */ 
	 public List<String> listMyTags(String username) { 	
		 return messageRepo.listMyTags(username); 	} 	
	 /* 	 * This method should be used to show all public messages(messages sent to circles) 
	  * 	 * containing a specific tag. Call the corresponding method of Respository interface. 	 */ 
	 public List<Message> showMessagesWithTag(String tag,int pageNumber) { 	
		 return messageRepo.showMessagesWithTag(tag,pageNumber); 	} 	
	 /* 	 * This method should be used to subscribe a user to a specific tag. Call the corresponding method of Respository interface. 	 */ 
	 public boolean subscribeUserToTag(String username, String tag) { 	
		 UserTag ut = userTagRepo.getUserTag(username,tag); 
		 if(ut==null) { 	
			 ut.setUserName(username); 	
			 ut.setTag(tag); 		
			 userTagRepo.save(ut); 
			 return true; 	
			 }else { 	
				 return false; 	
				 } 	} 	
	 /* 	 * This method should be used to unsubscribe a user from a specific tag.
	  *  Call the corresponding method of Respository interface. 	 */ 
	 public boolean unsubscribeUserToTag(String username, String tag) { 	
		 UserTag ut = userTagRepo.getUserTag(username,tag); 	
		 if(ut!=null) {						
			 userTagRepo.delete(ut); 	
			 return true; 	
			 }else { 
				 return false; 	
				 } 	}
	 
	 }
	
	
	
	
	
	
	
	
	
