package com.unisys.dojo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisys.dojo.payload.ResponseDetails;
import com.unisys.dojo.service.IdojoService;

@RunWith(SpringRunner.class)
@WebMvcTest(DOJOController.class)
public class DOJOControllerTest {
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private IdojoService service;
    
    @MockBean
    private Logger log;
    
   
    
    @Test
    public void saveResponse() throws Exception {
    	Mockito.doNothing().when(log).info(any(String.class).toString());
    	ResponseDetails responseDetails = new ResponseDetails();
		responseDetails.setQuestionId("1");
		responseDetails.setAnswer(new Boolean(true));
		Mockito.doNothing().when(service).submitResponse(Mockito.any(ResponseDetails.class));
		 mvc.perform(post("/submitResponse").content(asJsonString(responseDetails)).contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
    	
    }
    
    @Test
    public void index() throws Exception {
    	 mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("DOJO Services")));
    	
    }
    
    public String asJsonString(final Object details) {
        try {
            return new ObjectMapper().writeValueAsString(details);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
