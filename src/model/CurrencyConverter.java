package model;

import java.util.ArrayList;

public class CurrencyConverter {

    public ArrayList<Currency> currencyList = new ArrayList<Currency>();

    public CurrencyConverter(){
        currencyList.add(new Currency("Yen", 124));
        currencyList.add(new Currency("US-Dollar", 1.19));
    }

    public String getNameOfCurrency(int index) {
        return currencyList.get(index).getName();
    }

    public double euroToCurrencies(double euro, Object name){
        double index = 1;
        for (Currency currency : currencyList){
            if(currency.getName().equals(name)){
                index = currency.getValue();
            }
        }
        return euro * index;
    }
}