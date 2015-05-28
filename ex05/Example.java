
@Developer(developer_name=@Name(first_name="john",last_name="doe"))
public class Example {
	@Test
	void test1() {
		throw new RuntimeException("test1 always fail");
	}

	@Test(enabled=false)
	void test2() {
		throw new RuntimeException("this should not be called");
	}
}

