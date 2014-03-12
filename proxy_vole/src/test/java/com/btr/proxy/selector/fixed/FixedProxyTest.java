package com.btr.proxy.selector.fixed;

import static org.junit.Assert.*;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;

import org.junit.Test;

import com.btr.proxy.TestUtil;


/*****************************************************************************
 *  
 * @author Bernd Rosstauscher (proxyvole@rosstauscher.de) Copyright 2009
 ****************************************************************************/

public class FixedProxyTest {

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy() {
		ProxySelector ps = new FixedProxySelector("http_proxy.unit-test.invalid", 8090);
		
		List<Proxy> result = ps.select(TestUtil.HTTP_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy2() {
		ProxySelector ps = new FixedProxySelector(TestUtil.HTTP_TEST_PROXY);
		
		List<Proxy> result = ps.select(TestUtil.HTTP_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy3() {
		ProxySelector ps = new FixedProxySelector(TestUtil.HTTP_TEST_PROXY);
		
		List<Proxy> result = ps.select(TestUtil.HTTPS_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}
	
	
}

