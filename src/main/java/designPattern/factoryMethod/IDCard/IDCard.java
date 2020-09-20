package designPattern.factoryMethod.IDCard;

import designPattern.factoryMethod.framework.Product;

/**
 * @author fuzhennan
 */
public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        System.out.println("制作"+owner+"的ID卡。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡。");
    }

    public String getOwner(){
        return owner;
    }
}
