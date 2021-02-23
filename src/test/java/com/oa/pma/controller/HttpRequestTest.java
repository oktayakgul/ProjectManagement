package com.oa.pma.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Testing the Web Layer
 *  https://spring.io/guides/gs/testing-web/
 * */


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/* for using @SpringBootTest, you need to set package of the test file as same as the main/java/ package structure. in this test it is .controller */
public class HttpRequestTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate; // to user everything with doing by web browser
	
	@Test
	public void homePageReturnsVersionNumberCoreectly_thenSuccess(){
		String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertEquals(renderedHtml.contains("0.0.1"), true);
		//(this.restTemplate.getForObject("https://www.trbinance.com/", String.class)).contains("BNB") /* hin hin hinn :D */
	}
}
