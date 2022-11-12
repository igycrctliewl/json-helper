package com.mikebro.jsonhelper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {


	/**
	 * Method that can be used to serialize any Java value as a String.
	 *
	 * @param object
	 * @return String
	 */
	public static String objectToJson(Object object) {

		ObjectMapper mapper = new ObjectMapper();
		String body = null;

		try {
			body = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}



	/**
	 * Method that can be used to convert JSON string to object of give type.
	 *
	 * @param strJson
	 * @param type
	 * @return T
	 */
	public static <T> T jsonToObject(String strJson, Class<T> type) {

		ObjectMapper mapper = new ObjectMapper();
		T dto = null;
		try {
			dto = mapper.readValue(strJson, type);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
