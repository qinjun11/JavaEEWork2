package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.FileManage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entry.User;

public class UserAction extends ActionSupport {
	
	/**
	 * 
	 */

	private User user;
	private String massage ;
	private Map<String, Object> session;
	private String newpsw;
	private static final long serialVersionUID = 1L;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNewpsw() {
		return newpsw;
	}

	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}

	public String regist() throws Exception {
		session = ActionContext.getContext().getSession();
		FileManage fm = new FileManage();
		List<User> users =fm.getUser();
		boolean mark = true;
		if (user.getUsername().length() < 1||user.getUsername()==null) {

			this.addFieldError("name", "用户名不能为空！");
			mark = false;
		}
		if (user.getPassword().length() < 1||user.getPassword()==null) {
			this.addFieldError("psw", "密码不能为空！");
			mark = false;
		}
		if (!newpsw.equals(user.getPassword())) {

			this.addFieldError("npsw", "密码不一致！");
			mark = false;
		}
		for(User us:users){
        	   if(user.getUsername().trim().equalsIgnoreCase(us.getUsername().trim())){
        		   massage = "用户名已注册！";
        		   return "registUser";
        	   }
		}
		if(mark){
			massage = "注册成功";
			System.out.println(user.getUsername());
			session.clear();
			session.put("user", user);
			fm.setUser(user);
			return "registUser";
		}	
		return "error";
	}

	public String login() throws Exception {
		session = ActionContext.getContext().getSession();
		FileManage fm = new FileManage();
		List<User> users =fm.getUser();
		boolean mark = true;
		if (user.getUsername().length() < 1||user.getUsername()==null) {

			this.addFieldError("name", "用户名不能为空！");
			mark = false;
		}
		if (user.getPassword().length() < 1||user.getPassword()==null) {
			this.addFieldError("psw", "密码不能为空！");
			mark = false;
		}
		if(mark){
			/*
		if(user.getUsername().trim().equalsIgnoreCase("xc")&&
    			user.getPassword().trim().equalsIgnoreCase("123")){
			session.put("loginUser", user);
    		return "loginUser";
    	}*/for(User us:users){
		   if(user.getUsername().trim().equalsIgnoreCase(us.getUsername().trim())&&
		    			user.getPassword().trim().equalsIgnoreCase(us.getPassword().trim())){
		    		session.put("loginUser", user);
		    		return "loginUser";
		    	}
    	    }
		}
		return "error";
	}
}

