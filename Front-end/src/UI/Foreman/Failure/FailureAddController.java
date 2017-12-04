package UI.Foreman.Failure;

//import Model.Failure_Occured;
//import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;
import Connection.*;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class FailureAddController implements Initializable {


    List<String> listComboF = new ArrayList<>(asList("Ground relay tripped","Hot engine","Low oil pressure","Crankcase exhauster failure","Traction motor blower failure","No battery charge","Diesel engine overspeed"));
    List<String> listComboR = new ArrayList<>(asList("Main Line","Matale Line","Puttlam Line","Nothern Line","Coastal Line","Kelaniweli Line"));
    List<String> listComboE = new ArrayList<>(asList("M4","M5","M8","M9","M10"));
    List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Active","Running"));

    public ComboBox<String> combo_failureName;
    public ComboBox<String> combo_route;
    public ComboBox<String> combo_engineType;
    public ComboBox<String> combo_engineState;
    public Button btn_submit;
    public TextField txt_engineNo;
    public TextField txt_time;
    public TextField txt_place;
    public TextField txt_nearestYard;
    public TextArea txt_counteraction;
    public TextArea txt_driverNote;
    public TextArea txt_description;


    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;



        /*public FailureAddController() {
            conn= Connect.ConnectDB();
        }*/


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillCombo_failureName();
        this.fillCombo_route();
        this.fillCombo_engineType();
        this.fillCombo_engineState();
        this.setTime();

    }
//Set Combo box lists: Engine Class, Failure Name, Route, Engine State

    void fillCombo_failureName(){
        combo_failureName.setItems(FXCollections.observableArrayList(listComboF));
    }

    void fillCombo_route(){
        combo_route.setItems(FXCollections.observableArrayList(listComboR));
    }

    void fillCombo_engineType(){
        combo_engineType.setItems(FXCollections.observableArrayList(listComboE));
    }


    void fillCombo_engineState(){
        combo_engineState.setItems(FXCollections.observableArrayList(listComboS));
    }

    void setTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        txt_time.setText(dateFormat.format(date));
    }



    public void onSubmitButtonPress(ActionEvent actionEvent) throws Exception{
            /*try {
                int loco_ID = Integer.parseInt(txt_engineNo.getText());//class ekai engine No ekai anuwa ganna
                int failure_ID =3;//methana faillure type eken  ganna
                int trip_ID = 3;//date ekai locoId ekai anuwa ganna
                String place = txt_place.getText();
                String nearest_yard = txt_nearestYard.getText();
                Date occured_time =new SimpleDateFormat("HH:mm").parse(txt_time.getText());
                String loco_state = combo_engineState.getValue();
                String driver_note =txt_driverNote.getText();
                String description = txt_description.getText();
                //Failure_Occured failure_occured = new Failure_Occured(loco_ID, failure_ID, trip_ID, place, nearest_yard, occured_time, loco_state, driver_note, description);
                //failure_occured.add();
            }
            catch (Exception e) {
                e.printStackTrace();
            }*/
    }


}