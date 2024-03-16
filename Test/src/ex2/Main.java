package ex2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	private final TableView<Person> table = new TableView<>();
	private final ObservableList<Person> data = FXCollections.observableArrayList(new Person("A", "B"));
	final HBox hb = new HBox();
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group());
		stage.setWidth(450);
		stage.setHeight(550);
		
		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(100);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		table.setItems(data);
		table.getColumns().addAll(firstNameCol, lastNameCol);
		final Button addButton = new Button("Add");
		addButton.setOnAction(e->{
			data.add(new Person("Z","X"));
		});
		hb.getChildren().addAll(addButton);
		hb.setSpacing(3);
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, hb);
		((Group)scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void Main(String []args) {
		launch(args);
	}
}
