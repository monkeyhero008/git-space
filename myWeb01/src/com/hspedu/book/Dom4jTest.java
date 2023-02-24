package com.hspedu.book;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;
/**
 * @version 1.0
 * @作者-盛羿杰
 * @学习java
 */
public class Dom4jTest {
    @Test
    public void test1() throws Exception{
        //创建一个saxReader输入流 去读取xml配置文件 生成dom对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("d:/javaweb/myWeb01/xml/books.xml");
        System.out.println(document);
    }
    /**
     *读取books.xml文件生成book类
     */
    @Test
    public void test2() throws Exception{
        //读取xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("d:/javaweb/myWeb01/xml/books.xml");
        //通过文档对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //通过根元素 获取book标签对象
        //element() 和 elements() 都是通过标签名查找子元素
        List<Element> book = rootElement.elements("book");
        //遍历 处理每个book标签转换为book类
        for (Element element:book){
            //System.out.println(element.asXML());
            //asXML()把标签对象转化为标签字符串
            Element name = element.element("name");
            //System.out.println(name.asXML());
            String nameText = name.getText();
            //getText()可以获取标签中的文本内容
            String priceText = element.elementText("price");
            //直接获取指定标签名的文本内容
            String authorText = element.elementText("author");
            String snValue = element.attributeValue("sn");
            Book book1 = new Book(snValue, nameText, new BigDecimal(Integer.parseInt(priceText)), authorText);
            System.out.println(book1);
        }
    }
}
