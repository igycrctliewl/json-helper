package com.mikebro.jsonhelper.serializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize( LocalDateTime value, JsonGenerator gen, SerializerProvider provider )
			throws IOException {
		Instant outInstant = value.atZone( ZoneId.systemDefault() ).toInstant();
		gen.writeString( outInstant.toString() );
	}


}