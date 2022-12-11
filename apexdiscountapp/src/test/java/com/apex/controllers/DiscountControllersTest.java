package com.apex.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DiscountControllers.class)
class DiscountControllersTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHealthCheck() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/status").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("responseInformation").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseInformation").value("The Service is Up"));

	}

	// test to verify that spending 120 dollars will get you 90 points
	@Test
	void testTransactionInfoSpend120() throws Exception {
		String json = "{\"dollarSpent\": 120}";

		mvc.perform(
				MockMvcRequestBuilders.post("/calculatedpoints").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("responseInformation").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseInformation").value("Calculated Points :90"))
				.andDo(print());
	}

	// test to verify that spending 10 dollars will get you 0 points
	@Test
	void testTransactionInfoSpend10() throws Exception {
		String json = "{\"dollarSpent\": 10}";

		mvc.perform(
				MockMvcRequestBuilders.post("/calculatedpoints").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("responseInformation").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseInformation").value("Calculated Points :0"))
				.andDo(print());
	}

	// test to verify that spending 75 dollars will get you 25 points
	@Test
	void testTransactionInfoSpend75() throws Exception {
		String json = "{\"dollarSpent\": 75}";

		mvc.perform(
				MockMvcRequestBuilders.post("/calculatedpoints").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("responseInformation").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseInformation").value("Calculated Points :25"))
				.andDo(print());
	}

	// test to verify that spending 250 dollars will get you 350 points
	@Test
	void testTransactionInfoSpend250() throws Exception {
		String json = "{\"dollarSpent\": 250}";

		mvc.perform(
				MockMvcRequestBuilders.post("/calculatedpoints").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("responseInformation").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseInformation").value("Calculated Points :350"))
				.andDo(print());
	}

}
