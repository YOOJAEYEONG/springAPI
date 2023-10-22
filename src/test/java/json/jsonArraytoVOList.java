package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.dto.PO;
import org.junit.jupiter.api.Test;

import java.util.List;


public class jsonArraytoVOList {

    @Test
    public void convert() throws Exception {
        PO po = PO.builder().unknown_snake2("SDfsd").build();
        PO po2 = new PO();
        String json = "[{\"KEY_SNAKE1\":\"value_snake1\",\"KEY_SNAKE2\":\"value_snake2\"},{\"KEY_SNAKE1\":\"value_snake1\",\"KEY_SNAKE2\":\"value_snake2\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_SNAKE_CASE);
//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        List<PO> polist2 = objectMapper.readValue(json, new TypeReference<>() {
        });
        System.out.println(polist2.get(1));

    }
}
