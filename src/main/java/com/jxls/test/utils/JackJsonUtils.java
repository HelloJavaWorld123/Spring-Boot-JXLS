package com.jxls.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created By User: RXK
 * Date: 2017/9/13
 * Time: 18:02
 * Version: V1.0
 * Description:使用JackJson对java对象以及java集合进行转换
 */
public class JackJsonUtils
{
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 将json对象转换为java对象
	 *
	 * @param json
	 */
	public static Object json2Object(String json, TypeReference<?> typeReference)
			throws IOException
	{
		return MAPPER.readValue(json, typeReference);
	}

	/**
	 * 将Json格式的数据 转换为 List集合
	 *
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> json2List(String json, Class<T> clazz)
			throws IOException
	{
		return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
	}

	/**
	 * 将Json格式的数据转换为Map格式的java对象
	 *
	 * @param json
	 * @param kClass
	 * @param vClass
	 * @param <K>
	 * @param <V>
	 * @return
	 * @throws IOException
	 */
	public static <K, V> Map<K, V> json2Map(String json, Class<K> kClass, Class<V> vClass)
			throws IOException
	{
		return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass));
	}

	/**
	 * 将Json格式的字符串转换为java对象
	 *
	 * @param json
	 * @param javaType
	 * @return
	 */
	public static Object fromJson(String json, JavaType javaType)
			throws IOException
	{
		return MAPPER.readValue(json, javaType);
	}

	/**
	 * 将java对象转换为字符串
	 *
	 * @param object
	 * @return : String 字符串
	 * @throws JsonProcessingException
	 */
	public String list2Json(Object object)
			throws JsonProcessingException
	{
		return MAPPER.writeValueAsString(object);
	}
}
