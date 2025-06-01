package controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.TodoItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TodoListController implements Initializable {


    @FXML
    private TableColumn colTask;

    @FXML
    private ListView listView;

    @FXML
    private TableView tblDoList;

    @FXML
    private TextField txtItem;


    TodoItem items;
    ObservableList<TodoItem> itemObservableList=FXCollections.observableArrayList();
    CheckBox box;
    String name;





    @FXML
    void btnAddOnAction(ActionEvent event) {
        colTask.setCellValueFactory(new PropertyValueFactory<>("name"));

        box=new CheckBox();
        name=txtItem.getText();
        items=new TodoItem(name,box);

        itemObservableList.add(items);
        listView.setItems(itemObservableList);

        listView.setCellFactory(param-> new ListCell<TodoItem>() {
            @Override
            protected void updateItem(TodoItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    setText(item.getName());
                   setGraphic(item.getBox());
                }
            }
        });
//        listView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
//            @Override
//            public ObservableValue<Boolean> call(String item) {
//                BooleanProperty obs=new SimpleBooleanProperty();
//                return  new SimpleBooleanProperty();
//            }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTask.setCellValueFactory(new PropertyValueFactory<>("task"));
    }



    ArrayList<TodoItem> todoItems;
    public  void callView(){
        todoItems=new ArrayList<>();
        ObservableList<TodoItem> list = listView.getItems();
        list.forEach(obj->{
            if(obj.getBox().isSelected()){
                todoItems.add(obj);
                
            }else {

            }
        });
        tblDoList.setItems(FXCollections.observableArrayList(todoItems));
    }

    public void listViewOnEdit(ListView.EditEvent editEvent) {

    }

    public void onEdit(ListView.EditEvent editEvent) {

    }

    public void listViewClick(MouseEvent mouseEvent) {

    }

    public void onMouseEntered(MouseEvent mouseEvent) {

    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        callView();
    }
}
