package com.aripd.common.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class ARIPDStatusSerializer extends JsonSerializer<Boolean> {

	@Override
	public void serialize(Boolean value, JsonGenerator gen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {

		if (value)
			gen.writeString("Open");
		else
			gen.writeString("Closed");

	}

}
