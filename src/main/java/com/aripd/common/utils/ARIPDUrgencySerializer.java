package com.aripd.common.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class ARIPDUrgencySerializer extends JsonSerializer<Integer> {

	@Override
	public void serialize(Integer value, JsonGenerator gen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {

		if (value == 1)
			gen.writeString("Low");
		else if (value == 2)
			gen.writeString("Medium");
		else if (value == 3)
			gen.writeString("High");

	}

}
