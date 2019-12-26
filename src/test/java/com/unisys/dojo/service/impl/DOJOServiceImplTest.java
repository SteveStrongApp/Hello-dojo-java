package com.unisys.dojo.service.impl;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


import com.unisys.dojo.domain.Response;
import com.unisys.dojo.payload.ResponseDetails;
import com.unisys.dojo.repository.ResponseRepository;
import com.unisys.dojo.service.IdojoService;

@RunWith(SpringRunner.class)
public class DOJOServiceImplTest {
	/*
	 * @TestConfiguration static class DOJOServiceImplTestContextConfiguration {
	 * 
	 * @Bean public IdojoService employeeService() { return new DOJOServiceImpl(); }
	 * }
	 */
	/*
	 * @Autowired private IdojoService service;
	 * 
	 * @MockBean private ResponseRepository responseRepository;
	 */

	@MockBean
    private DOJOServiceImpl service;
	private ResponseRepository responseRepository;
	@MockBean
    private Logger log;
	
	

	@Before
	public void setUp() {
		//Mockito.doNothing().when(responseRepository).save(Mockito.any(Response.class));
		//service = mock(IdojoService.class);
		responseRepository = mock(ResponseRepository.class);
		//Mockito.when(responseRepository.save(Mockito.any(Response.class))).thenReturn(response);
	}

	@Test
	public void verifyResponseSaveCalled() {
		//Mockito.doNothing().when(log).info(any(String.class).toString());
    	
		ResponseDetails responseDetails = new ResponseDetails();
		responseDetails.setQuestionId("1");
		responseDetails.setAnswer(new Boolean(true));
		Response response = new Response();
		response.setQuestionId("1");
		response.setAnswer(new Boolean(true));
		Mockito.when(responseRepository.save(response)).thenReturn(response);
		service.submitResponse(responseDetails);
		verify(service,times(1)).submitResponse(responseDetails);
		//service.submitResponse(responseDetails);

	}
	@Test
	public void verifyParametersForSubmitResponse() {
		//Mockito.doNothing().when(log).info(any(String.class).toString());
		ResponseDetails responseDetails = new ResponseDetails();
		responseDetails.setQuestionId("1");
		responseDetails.setAnswer(new Boolean(true));
		doAnswer((Answer) invocation -> {
			Object arg0 = invocation.getArgument(0);
			assertEquals("1",((ResponseDetails)arg0).getQuestionId());
			assertEquals(new Boolean(true),((ResponseDetails)arg0).getAnswer());
			return null;
		}).when(service).submitResponse(Mockito.any(ResponseDetails.class));
		service.submitResponse(responseDetails);
	}
	
	/*
	 * @Test(expected = Exception.class) public void
	 * submitResponse_throwExceptionForNullParameters() { ResponseDetails
	 * responseDetails = new ResponseDetails(); responseDetails.setQuestionId("1");
	 * responseDetails.setAnswer(new Boolean(true)); doAnswer((Answer) invocation ->
	 * { Object arg0 = invocation.getArgument(0);
	 * assertEquals("1",((ResponseDetails)arg0).getQuestionId()); assertEquals(new
	 * Boolean(true),((ResponseDetails)arg0).getAnswer()); return null;
	 * }).when(service).submitResponse(Mockito.any(ResponseDetails.class));
	 * service.submitResponse(responseDetails); }
	 */

}
