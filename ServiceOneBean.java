package example_jdk_dynamic_proxy;

public class ServiceOneBean implements ServiceOne {

//	@Override  //annot
	public String sayHello() {
		System.out.println("Executing method sayHello");
		return "Hello";
	}
	
}
