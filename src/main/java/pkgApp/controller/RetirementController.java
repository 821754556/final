package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField TEXTYearsToWork;
	
	@FXML
	private TextField TEXTWorkReturn;
	@FXML
	private TextField TEXTYearsToRetire;
	@FXML
	private TextField TEXTRetireReturn;
	@FXML
	private TextField TEXTRequiredIncome;
	@FXML
	private TextField TEXTSSI;
	@FXML
	private Label MONTHSaveLabel;
	@FXML
	private Label TOTALSaveLabel;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		TEXTRequiredIncome.clear();
		TEXTRetireReturn.clear();
		TEXTSSI.clear();
		TEXTWorkReturn.clear();
		TEXTYearsToRetire.clear();
		TEXTYearsToWork.clear();
		MONTHSaveLabel.setText("");
		TOTALSaveLabel.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		if (!validate()) {
			return;
		}
		Retirement retirement = new Retirement(Integer.parseInt(TEXTYearsToWork.getText()), Double.parseDouble(TEXTWorkReturn.getText())
				, Integer.parseInt(TEXTYearsToRetire.getText()), Double.parseDouble(TEXTRetireReturn.getText()), Double.parseDouble(TEXTRequiredIncome.getText())
				, Double.parseDouble(TEXTSSI.getText()));
		TOTALSaveLabel.setText("$ "+String.format("%.2f",retirement.TotalAmountSaved()));
		MONTHSaveLabel.setText("$ "+String.format("%.2f",retirement.AmountToSave()));
	}
	
	private boolean validate(){
		if (TEXTWorkReturn.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of work can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double workReturn = Double.parseDouble(TEXTWorkReturn.getText());
			if (workReturn<0||workReturn>0.2) {
				Alert _alert = new Alert(Alert.AlertType.INFORMATION);
				 _alert.setContentText("Annual Return of work must between 0 and 0.2!");
				 _alert.show();
				 return false;
			}
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of work must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (TEXTYearsToWork.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to work can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(TEXTYearsToWork.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to work must be a valid integer!");
			 _alert.show();
			 return false;
		}
		
		if (TEXTYearsToRetire.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(TEXTYearsToRetire.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire must be a valid integer!");
			 _alert.show();
			 return false;
		}
		
		if (TEXTRetireReturn.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double retireReturn = Double.parseDouble(TEXTRetireReturn.getText());
			if (retireReturn<0||retireReturn>0.03) {
				Alert _alert = new Alert(Alert.AlertType.INFORMATION);
				 _alert.setContentText("Annual Return of retire must between 0 and 0.03!");
				 _alert.show();
				 return false;
			}
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of retire must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (TEXTRequiredIncome.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Required Income can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(TEXTRequiredIncome.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Required Income must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (TEXTSSI.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(TEXTSSI.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		return true;
	}
	
}
