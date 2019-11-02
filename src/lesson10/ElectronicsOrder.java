package lesson10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    public ElectronicsOrder() {

    }

    @Override
    public void validateOrder() { // заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов. Минимальная цена заказа 100. Так же имя клиента который делает заказ может быть любым, а пол только женским
        if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Харьков" || getShipFromCity() == "Днепр")
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Харьков" || getShipToCity() == "Днепр")
                if (getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский") setDateConfirmed(new Date());

    }

    @Override
    public void calculatePrice() { // Цена может состоит из цены товара и цены за доставку. Так же могут быть скидки. Если доставка производится в любой город, кроме Киева и Одессы, то цена за доставку - 15% от суммы заказа. В других случаях 10%. Так же если цена больше 1000 то скидка на заказ 5% после оплаты комиссии за доставку
        double commission = getShipToCity() != null && (getShipToCity() == "Киев" || getShipToCity() == "Одесса") ? getBasePrice() * 0.10 : getBasePrice() * 0.15;
        double bonus = getBasePrice() > 1000 ? (getBasePrice() + commission) * 0.05 : 0;

        setTotalPrice(getBasePrice() + commission - bonus);
    }

}
