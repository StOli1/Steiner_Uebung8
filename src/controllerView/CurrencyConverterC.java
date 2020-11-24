package controllerView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.CurrencyConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ResourceBundle;

public class CurrencyConverterC implements Initializable {
  
  @FXML
  private TextField txtEuro;
  @FXML
  private TextField txtYen;

  @FXML
  private ChoiceBox currency_ChoiceBox;
  
  private CurrencyConverter currencyConverter;
  
  private static final  NumberFormat DEC2FORMAT;
  
  static {
    DEC2FORMAT = NumberFormat.getNumberInstance();
    DEC2FORMAT.setGroupingUsed(true);
    DEC2FORMAT.setMinimumFractionDigits(2);
    DEC2FORMAT.setMaximumFractionDigits(2);
  }
  

  @FXML
  public void btnConvertAction() {

    convert();
  }

  public CurrencyConverterC() {
    currencyConverter = new CurrencyConverter();
  }

  private void convert() {
    try
    {
      double euro = DEC2FORMAT.parse(txtEuro.getText()).doubleValue();
      Object currencies = currency_ChoiceBox.getValue();

      double currency = currencyConverter.euroToCurrencies(euro, currencies);
      txtYen.setText(DEC2FORMAT.format(currency));
    }
    catch (ParseException e)
    {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    currencyConverter = new CurrencyConverter();
    for (int i = 0; i < currencyConverter.currencyList.size(); i++) {
      currency_ChoiceBox.getItems().add(currencyConverter.getNameOfCurrency(i));
      System.out.println(currencyConverter.getNameOfCurrency(i));
    }
  }
}
