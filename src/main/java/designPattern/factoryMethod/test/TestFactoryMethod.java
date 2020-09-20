package designPattern.factoryMethod.test;

import designPattern.factoryMethod.IDCard.IDCardFactory;
import designPattern.factoryMethod.framework.Factory;
import designPattern.factoryMethod.framework.Product;

/**
 * @author fuzhennan
 */
public class TestFactoryMethod {
    public static void main(String[] args){
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("张三");
        Product card2 = factory.create("李四");
        Product card3 = factory.create("王五");

        card1.use(); card2.use(); card3.use();
    }
}
