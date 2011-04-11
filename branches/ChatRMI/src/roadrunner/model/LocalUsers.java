package roadrunner.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import roadrunner.gui.ChatFrame;
import roadrunner.gui.ClientFrame;

public class LocalUsers extends Model {
	
	private final Map<User, ClientFrame> users;
	private final Map<User, Set<ChatFrame>> userChatFrames;
	
	public LocalUsers() {
		super();
		users = Collections.synchronizedMap(new HashMap<User, ClientFrame>());
		Set<ChatFrame> chatFrames = Collections.synchronizedSet(new HashSet<ChatFrame>());
		userChatFrames = Collections.synchronizedMap(new HashMap<User, Set<ChatFrame>>());
	}

	public Set<User> getUsers() {
		Set<User> set = new HashSet<User>();
		for (User user : users.keySet()) {
			set.add(user);
		}
		return set;
	}

	public void addUser(User user, ClientFrame clientFrame){
		users.put(user,clientFrame);
		Set<ChatFrame> chatFrames = Collections.synchronizedSet(new HashSet<ChatFrame>());
		userChatFrames.put(user, chatFrames);
		notifyListeners();
	}
	
	public void addUser(String username, ClientFrame frame){
		users.put(new User(username), frame);
		Set<ChatFrame> chatFrames = Collections.synchronizedSet(new HashSet<ChatFrame>());
		userChatFrames.put(new User(username), chatFrames);
		notifyListeners();
	}
	
	public void removeUser(String username){
		User u = new User(username);
		users.remove(u);
		for (ChatFrame chatFrame : userChatFrames.get(u)) {
			chatFrame.dispose();
		}
		userChatFrames.remove(u);
		notifyListeners();
	}

	public void setStatusForUser(String username, Status status) {
		for (User user : users.keySet()) {
			if(user.getUsername().equals(username)){
				user.setStatus(status);
				return;
			}
		}
	}
	
	public void addChatFrameForUser(String username, ChatFrame frame){
		userChatFrames.get(new User(username)).add(frame);
	}
	
	public ChatFrame getChatFrame(String localUsername, String remoteUsername){
		Set<ChatFrame> frames = userChatFrames.get(new User(localUsername));
		if(frames != null){
			if(frames.isEmpty()){
				//CREATE
				ChatFrame newFrame = ChatFrame.getFrame(remoteUsername);
				frames.add(newFrame);
				return newFrame;
			}else{
				//RETURN FORM SET
				for (ChatFrame chatFrame : frames) {
					if(chatFrame.getTitle().contains(remoteUsername)){
						return chatFrame;
					}
				}
				
				//CREATE
				ChatFrame newFrame = ChatFrame.getFrame(remoteUsername);
				frames.add(newFrame);
				return newFrame;
			}
		}
		
		return null;
	}

	public void removeFrame(ChatFrame frame) {
		Iterator<User> it = userChatFrames.keySet().iterator();
		while(it.hasNext()){
			User u = it.next();
			if(userChatFrames.get(u).remove(frame) == true){
				return;
			}
		}
	}

	
}
