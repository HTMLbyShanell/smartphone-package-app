package smartphonepackagefx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SmartphonePackageFx extends Application {

private MenuBar menuBar;
private Menu dataMenu, smartphoneMenu, extrasMenu;
private RadioMenuItem dataItem1, dataItem2, dataItem3, ModelItem1, ModelItem2, ModelItem3;
private CheckMenuItem extrasItem1, extrasItem2;
private double selectedDataCost, extrasCost1, extrasCost2;
private double selectedSmartphoneCost, total;
private double finalData, finalSmartphone, finalExtras;
private Label dataLabel, smartphoneLabel, extrasLabel, selectedDataCostLabel, selectedSmartphoneCostLabel,

selectedExtrasCostLabel1, selectedExtrasCostLabel2, totalCost, temp;

public static void main(String[] args) {

launch(args);

}

@Override
public void start(Stage primaryStage) {

final double WIDTH = 400.0, HEIGHT = 400.0;

dataLabel = new Label("Select a Data Plan from the menu");
smartphoneLabel = new Label("Select a Smartphone from the menu");
extrasLabel = new Label("Select Extras needed from the menu");

selectedDataCostLabel = new Label();
selectedSmartphoneCostLabel = new Label();
selectedExtrasCostLabel1 = new Label();
selectedExtrasCostLabel2 = new Label();
totalCost = new Label();
temp = new Label();
menuBar = new MenuBar();

buildDataMenu(primaryStage);
buildSmartphoneMenu();
buildExtrasMenu();

menuBar.getMenus().add(dataMenu);
menuBar.getMenus().add(smartphoneMenu);
menuBar.getMenus().add(extrasMenu);

BorderPane borderPane = new BorderPane();
borderPane.setTop(menuBar);

VBox vbox = new VBox(10, dataLabel, selectedDataCostLabel, smartphoneLabel, selectedSmartphoneCostLabel,
extrasLabel, selectedExtrasCostLabel1, selectedExtrasCostLabel2, totalCost, temp);

vbox.setAlignment(Pos.CENTER);
borderPane.setCenter(vbox);

Scene scene = new Scene(borderPane, WIDTH, HEIGHT);

primaryStage.setScene(scene);
primaryStage.show();

}

private void buildTotal() {

total = finalData + finalSmartphone + finalExtras;
totalCost.setText("Total cost is $" + (Double.toString(total)));

}

private void buildDataMenu(Stage primaryStage) {

dataMenu = new Menu("Data Plans");
dataItem1 = new RadioMenuItem("8GB / Month");
dataItem2 = new RadioMenuItem("16GB / Month");
dataItem3 = new RadioMenuItem("20GB / Month");
ToggleGroup dataToggleGroup = new ToggleGroup();
dataItem1.setToggleGroup(dataToggleGroup);
dataItem2.setToggleGroup(dataToggleGroup);
dataItem3.setToggleGroup(dataToggleGroup);

// finalData and temp.setText() needs to be done inside
// every toggle button click event
// otherwise it will always be 0 because
// only on clicking any toggle button, data is changing
// not outside any of those event methods
// Call buildTotal() from here only
// so that any new change will be reflected on the total field
// Do the same with other toggle buttons

dataItem1.setOnAction(event -> {

if (dataItem1.isSelected()) {

dataLabel.setText("Data Plan selected is 8GB / Month");
selectedDataCost = 45.00;
selectedDataCostLabel
.setText("Cost for the slected Data Plan is $" + Double.toString(selectedDataCost));

}

finalData = (selectedDataCost * 0.08) + selectedDataCost;

temp.setText(Double.toString(finalData));

buildTotal();

});

dataItem2.setOnAction(event -> {

if (dataItem2.isSelected()) {

dataLabel.setText("Data Plan selected is 16GB / Month");

selectedDataCost = 65.00;

selectedDataCostLabel

.setText("Cost for the slected Data Plan is $" + Double.toString(selectedDataCost));

}

finalData = (selectedDataCost * 0.08) + selectedDataCost;

temp.setText(Double.toString(finalData));

buildTotal();

});

dataItem3.setOnAction(event -> {

if (dataItem3.isSelected()) {

dataLabel.setText("Data Plan selected is 20GB / Month");

selectedDataCost = 99.00;

selectedDataCostLabel

.setText("Cost for the slected Data Plan is $" + Double.toString(selectedDataCost));

}

finalData = (selectedDataCost * 0.08) + selectedDataCost;

temp.setText(Double.toString(finalData));

});

dataMenu.getItems().addAll(dataItem1, dataItem2, dataItem3);

}

private void buildSmartphoneMenu() {

smartphoneMenu = new Menu("SmartPhones");
ModelItem1 = new RadioMenuItem("Model 100");
ModelItem2 = new RadioMenuItem("Model 110");
ModelItem3 = new RadioMenuItem("Model 200");
ToggleGroup smartPhoneToggleGroup = new ToggleGroup();
ModelItem1.setToggleGroup(smartPhoneToggleGroup);
ModelItem2.setToggleGroup(smartPhoneToggleGroup);
ModelItem3.setToggleGroup(smartPhoneToggleGroup);
ModelItem1.setOnAction(event -> {

if (ModelItem1.isSelected()) {

smartphoneLabel.setText("Smarphone selected is Model 100");
selectedSmartphoneCost = 299.95;
selectedSmartphoneCostLabel.setText("Cost for the selected Smartphone " + "Model 100 is $"
+ Double.toString(selectedSmartphoneCost));

}

finalSmartphone = (selectedSmartphoneCost * 0.08) + selectedSmartphoneCost;

buildTotal();

});

ModelItem2.setOnAction(event -> {

if (ModelItem2.isSelected()) {

smartphoneLabel.setText("Smarphone selected is Model 110");

selectedSmartphoneCost = 399.95;

selectedSmartphoneCostLabel.setText("Cost for the selected Smartphone " + "Model 110 is $"

+ Double.toString(selectedSmartphoneCost));

}

finalSmartphone = (selectedSmartphoneCost * 0.08) + selectedSmartphoneCost;

buildTotal();

});

ModelItem3.setOnAction(event -> {

if (ModelItem3.isSelected()) {

smartphoneLabel.setText("Smarphone selected is Model 200");

selectedSmartphoneCost = 499.95;

selectedSmartphoneCostLabel.setText("Cost for the selected Smarphone " + "Model 200 is $"

+ Double.toString(selectedSmartphoneCost));

}

finalSmartphone = (selectedSmartphoneCost * 0.08) + selectedSmartphoneCost;

buildTotal();

});

smartphoneMenu.getItems().addAll(ModelItem1, ModelItem2, ModelItem3);

}

private void buildExtrasMenu() {

extrasMenu = new Menu("Extras");

extrasItem1 = new CheckMenuItem("Phone Replacement Insurance");

extrasItem2 = new CheckMenuItem("WiFi Hotspot Capability");

extrasItem1.setOnAction(event -> {

extrasLabel.setText(null);

if (extrasItem1.isSelected()) {

extrasCost1 = 5.00;

selectedExtrasCostLabel1

.setText("Selected Phone Replacement Insurance " + "cost is $" + Double.toString(extrasCost1));

} else {

selectedExtrasCostLabel1.setText(null);

extrasCost1 = 0.00;

}

finalExtras = ((extrasCost1 * 0.08) + extrasCost1) + ((extrasCost2 * 0.08) + extrasCost2);

buildTotal();

});

extrasItem2.setOnAction(event -> {

extrasLabel.setText(null);

if (extrasItem2.isSelected()) {

extrasCost2 = 10.00;

selectedExtrasCostLabel2

.setText("Selected WiFi Hotspot Capability " + "cost is $" + Double.toString(extrasCost2));

} else {

selectedExtrasCostLabel2.setText(null);

extrasCost2 = 0.00;

}

finalExtras = ((extrasCost1 * 0.08) + extrasCost1) + ((extrasCost2 * 0.08) + extrasCost2);

buildTotal();

});

extrasMenu.getItems().addAll(extrasItem1, extrasItem2);

}

}