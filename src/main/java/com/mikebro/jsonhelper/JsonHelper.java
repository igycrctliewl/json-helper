package com.mikebro.jsonhelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
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



	/**
	 * Method that can be used to convert JSON string to object of give type.
	 *
	 * @param strJson
	 * @param type
	 * @return T
	 */
	public static <T> T jsonToObject(String strJson, TypeReference<T> type) {

		ObjectMapper mapper = new ObjectMapper();
		T dto = null;
		try {
			dto = (T) mapper.readValue(strJson, type);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	}


	// file IO tools
	/**
	 * This is a generic file writer tool, specialized for writing a single
	 * string of JSON text to a file.
	 * @param json  Intended to be JSON text, but actually can be any String of text.
	 * @param filename  A filename to write the text to.  Can be qualified as much as needed.
	 */
	public static void writeJson( String json, String filename ) {
		File file = new File( filename );
		try( BufferedWriter wr = new BufferedWriter( new FileWriter( file ) ); ) {
			wr.write( json );
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}


	/**
	 * This is a generic file reader tool, specialized for reading a single
	 * string of JSON text from a file.
	 * @param filename  A filename to write the text to.  Can be qualified as much as needed.
	 * @return  Returns the text read from the file.  Expected to be JSON text, but actually
	 * can be any String of text.
	 */
	public static String readJson( String filename ) {
		File file = new File( filename );
		StringBuilder data = new StringBuilder();
		try( Scanner rd = new Scanner( file ); ) {
			while( rd.hasNext() ) {
				data.append( rd.next() );
			}
		} catch( IOException e ) {
			e.printStackTrace();
		}
		return data.toString();
	}

}
