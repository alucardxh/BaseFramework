package com.baseframework.utils;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class XStreamPlus<T> extends XStream {
	
	private static String PREFIX_CDATA = "<![CDATA[";
	private static String SUFFIX_CDATA = "]]>";
	private Class<T> clz;
	 /**
	  * xstream初始化方法实现传入的参数类型增加cdata标签
	  * @param cla 需要增加cdata标签的属性类型
	  * @return
	  */
	public XStreamPlus(final Class cla1) {
		super(new XppDriver() {  
            @Override  
            public HierarchicalStreamWriter createWriter(Writer out) {  
                return new PrettyPrintWriter(out) {  
                	boolean iscdata=false;
                    @Override
					public void startNode(String name, Class clazz) {
                    	super.startNode(name, clazz);
                    	if(clazz.getName().equals(cla1.getName())){
                    		iscdata=true;
                    	}else{
                    		iscdata=false;
                    	}
					}
					protected void writeText(QuickWriter writer, String text) {
                    	if(iscdata){
                    		writer.write(PREFIX_CDATA + text + SUFFIX_CDATA);  
                    	}else{
                    		writer.write(text);
                    	}
                    }  
                };  
            }  
        });
		super.ignoreUnknownElements();
	//	super.alias("xml", this.clz);
	}

	public XStreamPlus() {
		super();
		super.ignoreUnknownElements();
	//	super.alias("xml", a().getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T fromXML(String xml) {
		return (T) super.fromXML(xml);
	}
	
	
}
