package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		Object loginUser = (Object)ActionContext.getContext().getSession().get("loginUser");
		if(loginUser != null){
			return invocation.invoke();
		}
		
		return "error";
	}

}
