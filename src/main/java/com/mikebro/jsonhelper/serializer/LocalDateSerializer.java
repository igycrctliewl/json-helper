package com.mikebro.jsonhelper.serializer;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	@Override
	public void serialize( LocalDate value, JsonGenerator gen, SerializerProvider provider )
			throws IOException {
		gen.writeString( value.toString() );
	}


}