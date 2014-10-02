package se.springworks.javautil.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import se.springworks.javautil.reflect.JavaTypeToken;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class JacksonParser implements IJsonParser {

	private ObjectMapper mapper;

	public JacksonParser() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	@Override
	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T fromJson(InputStream json, Class<T> type) {
		try {
			return mapper.readValue(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T fromJson(String json, Class<T> type) {
		try {
			return mapper.readValue(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T fromJson(InputStream json, JavaTypeToken<T> type) {
		try {
			return mapper.readValue(json, TypeFactory.defaultInstance().constructType(type.getType()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T fromJson(String json, JavaTypeToken<T> type) {
		try {
			return mapper.readValue(json, TypeFactory.defaultInstance().constructType(type.getType()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void toJson(File file, Object object) {
		try {
			mapper.writeValue(file, object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void toJson(OutputStream out, Object object) {
		try {
			mapper.writeValue(out, object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
