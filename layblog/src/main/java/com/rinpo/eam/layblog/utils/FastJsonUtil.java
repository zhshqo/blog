package com.rinpo.eam.layblog.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * json字符串与Object、List、Map的互转
 * json 存入 file，并且从file读出
 */

public class FastJsonUtil {

	static {
		TypeUtils.compatibleWithJavaBean = true;//解决bean转换为string时，首字母自动小写的问题
	}
	
	/**
	 * 将JSON字符串转化为JSONObject
	 * @param jsonString
	 * @return
	 */
	public static JSONObject jsonString2Obj(String jsonString){
		JSONObject jsonObj=JSON.parseObject(jsonString);
		return jsonObj;
	}
	
	/**
	 * json字符串转 List对象
	 * 
	 * @param str
	 *            json字符串
	 * @param clazz
	 *            转换的类型
	 * @return
	 */
	public static <T> List<T> JsonString2List(String str, Class<T> clazz) {
		return JSONArray.parseArray(str, clazz);
	}
	
	/**
	 * 对象转化为json字符串
	 * @param list
	 * @return
	 */
	public static <T> String obj2JsonStr(T t,boolean prettyFormat) {
		return JSON.toJSONString(t, prettyFormat);//true/false
	}

	/**
	 * <T>表示T是一个泛型，将对象以json的格式写入文件中
	 */
	public static <T> void writeJsonToFile(T t, String fileName) throws IOException {
		
		File file=new File(fileName);
		file.getParentFile().mkdirs();
		
		String jsonStr = JSONObject.toJSONString(t,
				SerializerFeature.PrettyFormat);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file)));
		bw.write(jsonStr);
		bw.close();
	}
	

	/**
	 * <T>表示T是一个泛型，从json文件中读出数据并转化成一个对象
	 */
	public static <T> T readJsonFromFile(Class<T> cls, File file)
			throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), cls);
	}
	
	/**
	 * json字符串转化为对象
	 * @param cls
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static <T> T jsonString2Obj(String str,Class<T> cls)
			throws IOException {
		return JSONObject.parseObject(str, cls);
	}

	/**
	 * <T>表示T是一个泛型，从json文件中读出数据并转化成一个对象
	 */
	public static <T> T readJsonFromFile(Class<T> cls, String filename)
			throws IOException {
		return readJsonFromFile(cls, new File(filename));
	}

	/**
	 * <T>表示T是一个泛型，从json文件中读出数据并转化成一个对象
	 */
	public static <T> T readJsonFromFile(TypeReference<T> typeReference,
			File file) throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), typeReference);
	}

	/**
	 * <T>表示T是一个泛型，从json文件中读出数据并转化成一个对象
	 */
	public static <T> T readJsonFromFile(TypeReference<T> typeReference,
			String filename) throws IOException {
		return readJsonFromFile(typeReference, new File(filename));
	}
	
	/**
	 * 将JSON字符串转化为Map
	 * @param jsonStr
	 * @return
	 * @throws IOException
	 */
	public static Map<String,String> json2Map(String jsonStr) throws IOException {
		//JSON -> Map 
	    Map<String,String> map = (Map<String,String>)JSON.parse(jsonStr); 
	    return map;
	}
	
	/**
	 * 格式化JSON字符串
	 * @param jsonStr
	 * @return
	 * @author   zsq
	 * @Date   
	 */
    public static String formatJson(String jsonStr) {
    	if (null == jsonStr || "".equals(jsonStr.trim())){
    		return null;
    	}
    	if(jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
    		StringBuilder sb = new StringBuilder();
            char last = '\0';
            char current = '\0';
            int indent = 0;
            for (int i = 0; i < jsonStr.length(); i++) {
                last = current;
                current = jsonStr.charAt(i);
                switch (current) {
                    case '{':
                    case '[':
                        sb.append(current);
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                        break;
                    case '}':
                    case ']':
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                        sb.append(current);
                        break;
                    case ',':
                        sb.append(current);
                        if (last != '\\') {
                            sb.append('\n');
                            addIndentBlank(sb, indent);
                        }
                        break;
                    default:
                        sb.append(current);
                }
            }

            return sb.toString();
    	}else{
    		return null;
    	}
        
    }

    /**
     * 添加space
     * @param sb
     * @param indent
     * @author   zsq
     * @Date   
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
	
	public static void main(String[] args){
//		SideMenu sm=new SideMenu();
//		sm.setHref("sdf");
//		String[] a={"sdfsf","sdffff"};
//		sm.setTags(a);
//		sm.setText("sdfsdf");
//		
//		SideMenu sm1=new SideMenu();
//		sm1.setHref("sdf");
//		String[] a1={"sdfsf","sddsfsffff"};
//		sm1.setTags(a1);
//		sm1.setText("sdfsdf");
//		List<SideMenu> list=new ArrayList<SideMenu>();
//		list.add(sm1);
//		sm.setNodes(list);
//		
//		String str=FastJsonUtil.toJsonString(sm);
//		try {
//			FastJsonUtil.writeJsonToFile(sm, "d://a.json");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(str);
		
		System.out.println("ddd");
		String content="{\"basicParams\":{\"domain\":\"http://10.16.16.15:7110/faDTST/\",\"userName\":\"eamadmin\",\"passWord\":\"eampassword\",\"apikey\":\"ddddd\"}}";
	}
	
}