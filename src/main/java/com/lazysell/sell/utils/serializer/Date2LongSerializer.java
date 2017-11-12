package com.lazysell.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date2LongSerializer
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.utils.serializer
 * Created by Lazy on 2017/11/12 21:34
 * Version: 0.1
 * Info: @TODO:...
 */
public class Date2LongSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeNumber(value.getTime()/1000);
    }
}
