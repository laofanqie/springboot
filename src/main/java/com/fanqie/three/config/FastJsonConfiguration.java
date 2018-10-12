package com.fanqie.three.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {
    /**
     * 修改自定义消息转换器
     *
     * @param converters 消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse);
        //创建消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        fastConverter.setFastJsonConfig(config);
        //处理中文乱码问题
        List<MediaType> fastMediaType = new ArrayList<>();
        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaType);
        fastConverter.setFastJsonConfig(config);
        //将fastJson添加到视图消息转换列表中
        converters.add(fastConverter);
    }
}
