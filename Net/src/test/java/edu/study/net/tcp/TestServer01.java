package edu.study.net.tcp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestServer01 {
	private TcpServerIO serverIO;

	@Before
	public void setUp() {
		serverIO = new TcpServerIO();
	}

	@Test
	public void test() throws IOException {
		assertEquals("String", serverIO.accept());
		assertEquals("String1", serverIO.accept());
		assertEquals("String2", serverIO.accept());
		assertEquals("String3", serverIO.accept());
		assertEquals("~!@#$%^&*()_+|}{:?><,./;'[]\'", serverIO.accept());
		assertEquals("1234567890", serverIO.accept());
	}

}
