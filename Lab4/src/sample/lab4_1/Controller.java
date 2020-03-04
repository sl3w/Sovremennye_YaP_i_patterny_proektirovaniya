package sample.lab4_1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.lab4_1.model.Char;
import sample.lab4_1.model.Point;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butAdd;

    @FXML
    private Button butDel;

    @FXML
    private TextField inpX;

    @FXML
    private TableView<Point> table1;

    @FXML
    private TableColumn<Point, String> colX;

    @FXML
    private TableColumn<Point, String> colY;

    private ObservableList<Point> pointList = FXCollections.observableArrayList();

    @FXML
    private LineChart<Double, Double> char1;

    @FXML
    void clickAdd(ActionEvent event) {
        if (!inpX.getText().trim().equals("")) {
            try {
                double doubX = Double.parseDouble(inpX.getText());
                if (doubX >= 0) {
                    Char.addPoint(doubX);

                    inpX.clear();
                    update();
                    refreshGraph();
                } else {
                    error("добавлении", "X должен быть больше 0");
                }
            } catch (Exception e) {
                error("добавлении", "Это не число");
            }
        }
    }

    @FXML
    void clickDel(ActionEvent event) {
        Point tt = (Point) table1.getSelectionModel().getSelectedItem();
        Char.removePoint(tt);
        table1.getItems().removeAll(tt);
        refreshGraph();
    }

    public void update() {
        table1.getItems().removeAll();
        pointList.clear();

        getGraphic();

        table1.setItems(pointList);
    }

    public void getGraphic() {
        ArrayList<Point> points = Char.getGraphic();
        for (int i = 0; i < points.size(); i++) {
            pointList.add(points.get(i));
        }
    }

    public void refreshGraph() {
        char1.getData().clear();
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < pointList.size(); i++) {
            series.getData().add(new XYChart.Data<String, Double>(Double.toString(pointList.get(i).getX()), pointList.get(i).getY()));
        }
        char1.getData().addAll(series);
    }

    @FXML
    void initialize() {
        update();
        table1.setEditable(true);
        colX.setCellFactory(TextFieldTableCell.<Point> forTableColumn());
        colX.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(Double.toString(cellData.getValue().getX())));
        colY.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(Double.toString(cellData.getValue().getY())));

        colX.setOnEditCommit((TableColumn.CellEditEvent<Point, String> event) -> {
            try {
                TablePosition<Point, String> pos = event.getTablePosition();

                String newValue = event.getNewValue();

                int row = pos.getRow();
                Point point = event.getTableView().getItems().get(row);
                Char.editPoint(point.getX(), Double.parseDouble(newValue));
                point.setX(Double.parseDouble(newValue));
                table1.refresh();
                refreshGraph();
            } catch (Exception e){
                error("изменении", "Это не число");
            }
        });
    }

    public void error(String msg, String msg2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Ошибка при " + msg + " точки");
        alert.setContentText(msg2);
        alert.show();
    }
}
