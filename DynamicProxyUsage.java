package example_jdk_dynamic_proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class DynamicProxyUsage {
	
		
	public static void main(String[] args) {
		
			//Create the target instance
		ServiceOne serviceOne = new ServiceOneBean();
		
		ServiceOne serviceOne2 = new ServiceOneBean();
		
		//Create the target instance
		ServiceOne proxy = (ServiceOne)
				Proxy.newProxyInstance(ServiceOne.class.getClassLoader(), 
						               serviceOne.getClass().getInterfaces(),
						               new LogExecutionTimeProxy(serviceOne));
		
		//Invoke the target instance method through the proxy
		String result = proxy.sayHello();
		
		ServiceOne proxy1 = (ServiceOne)
				Proxy.newProxyInstance(ServiceOne.class.getClassLoader(), 
			               serviceOne.getClass().getInterfaces(),
			               new LogExecutionTimeProxy(serviceOne2));
		
		System.out.println("Result " + result);
		System.out.println(proxy);
		System.out.println(proxy1);

	}
    
}
