package com.bobeneba.design.creatorMode.AbstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName: ReadXML
 * @Description: 读取xml类
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

public class ReadXML {
    public static Object getObject(){
        DocumentBuilder documentBuilder = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc =documentBuilder.parse(new File("src/main/java/com/bobeneba/design/creatorMode/AbstractFactory/config1.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "com.bobeneba.design.creatorMode.AbstractFactory." + classNode.getNodeValue();
            //System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
