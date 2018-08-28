package de.claudioaltamura.springboot.test.json;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@JsonTest
@ContextConfiguration(classes=TestConfiguration.class)
public class JacksonTest {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		
		Car car = objectMapper.readValue(json, Car.class);
		
		assertThat(car.getType(), is("BMW"));
	}

}
