package lesson10;

public class Demo {
    public static void main(String[] args) {
        FurnitureOrder furnitureOrder = new FurnitureOrder();
        ElectronicsOrder electronicsOrder = new ElectronicsOrder();
        furnitureOrder.validateOrder();
        furnitureOrder.calculatePrice();
        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();
    }
}
