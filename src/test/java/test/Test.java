package test;

public class Test {

	@org.junit.Test
	public void test1(){
		String str=new String("sssss");
		setString(str);
		System.out.println(str);
	}
	public void  setString(String old){
		old.replace("s", "c");
	}
}
