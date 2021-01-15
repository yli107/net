package edu.study.net.tcp;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestTcpServer01 {
	private TcpServerIO serverIO;

	@Before
	public void setUp() {
		serverIO = new TcpServerIO();
	}

	@Test
	public void test() throws IOException {
		ArrayList<String> stringList = serverIO.acceptStrings();
		assertEquals("String", stringList.get(0));
		assertEquals("String1", stringList.get(1));
		assertEquals("String2", stringList.get(2));
		assertEquals("String3", stringList.get(3));
		assertEquals("~!@#$%^&*()_+|}{:?><,./;'[]\'", stringList.get(4));
		assertEquals("1234567890", stringList.get(5));
	}

}
