package src.practise.publicAndprivate;

/**
 * 修饰符        类内部        同一个包        子类        任何地方
 * private        yes
 * default(缺省)  yes           yes
 * protect        yes           yes             yes
 * public         yes           yes             yes         yes
 *
 *
 * 1）从大到小：public protected default private
 * 2)修饰类的修饰符：public default
 */
public class TestAnimal {
    public static void main(String[] args){
        Animal animal=new Animal();
        animal.setLegs(4);
        animal.setName("dog");
        System.out.println(animal.name);
        animal.eat();
        animal.name="blackAndwhite dog";
        animal.color="black";
        animal.fly=false;
        animal.info();
    }
}

