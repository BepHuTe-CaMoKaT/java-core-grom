package lesson10;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    public FurnitureOrder() {

    }


    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Львов") && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест")
            setDateConfirmed(new Date());
    }

    @Override
    public void calculatePrice() {
        double basePrice = getBasePrice();
        if (basePrice < 5000) {
            basePrice += basePrice * 0.05;
        } else basePrice += basePrice * 0.02;
        setTotalPrice(basePrice);
    }


}
