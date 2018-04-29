package example_jdk_dynamic_proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogExecutionTimeProxy implements InvocationHandler {
	
	//the target instance
	private Object invocationTarget;
	
	public LogExecutionTimeProxy(Object invocationTarget) {
		this.invocationTarget = invocationTarget;
	}
	
//	@Override  //annot
	public Object invoke(Object proxy, Method method, Object[] args)
	     throws Throwable {
		
		//start time
		long startTime = System.nanoTime();
		
		//Invoke the method on the target instance
		Object result = method.invoke(invocationTarget, args);
		
		//Print the execution time
		System.out.println("Execution method " + method.getName() + " in " + 
		    (System.nanoTime() - startTime) + " nanoseconds");
		
		//Return result to the caller
		return result;
		}

}
