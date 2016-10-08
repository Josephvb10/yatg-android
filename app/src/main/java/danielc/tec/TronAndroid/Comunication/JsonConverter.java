package danielc.tec.TronAndroid.Comunication;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	/**
	 * convert the json
	 * @param value
	 * @return
     */
	public static String objectToJson(Object value) {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter stringJson = new StringWriter();
		try {
			objectMapper.writeValue(stringJson, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringJson.toString();

	}

}
