
public class Test {

	public static void main(String[] args) {
	A a1= new B();
a1.toFile();
	}

}

abstract class A {
	public abstract void toFile();
}

class B extends  A{
	@Override
	public void toFile(){
		System.out.println("B");
	}
}
class C extends A
{
	@Override
	public void toFile(){
		System.out.println("c");
	}
}
