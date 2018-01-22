package uk.gov.moj.exercise.test.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uk.gov.moj.exercise.test.AnagramTest;

public class AnagramControllerTest extends AnagramTest{

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMVC;

	@Before
	public void setup() {
		mockMVC = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void should_Return_Anagrams_When_A_Word_Is_valid() throws Exception {
		String expectedData = "{\"dog\":[\"dog\",\"dgo\",\"odg\",\"ogd\",\"gdo\",\"god\"]}";
		mockMVC.perform(get("/dog"))
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.dog").isNotEmpty())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedData));
	}
}
