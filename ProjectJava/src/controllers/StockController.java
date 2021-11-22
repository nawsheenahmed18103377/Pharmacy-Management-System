 
package controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.ConnectionUtil;


public class StockController implements Initializable {

    @FXML
    private Button home;
    
    @FXML
    private TableView<StockModel> stocktable;
    @FXML
    private TableColumn<StockModel, String> colp_id;
    @FXML
    private TableColumn<StockModel, String> colname;
    @FXML
    private TableColumn<StockModel, String> colvendor;
    @FXML
    private TableColumn<StockModel, String> colp_date;
    @FXML
    private TableColumn<StockModel, String> colex_date;
    @FXML
    private TableColumn<StockModel, String> colqty;
    @FXML
    private TableColumn<StockModel, String> colprice;

    
    @FXML
    public void homebutton(MouseEvent h)
    {
        if(h.getSource()==home)
        {
            try {

                   
                    Node node = (Node) h.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Homepage.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
        }
    }
    
    
    ObservableList<StockModel> oblist = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      Connection con = ConnectionUtil.conDB();
      
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from medicine");
            
            while(rs.next())
            {
                oblist.add(new StockModel(rs.getString("p_id"), rs.getString("name"), rs.getString("vendor"), rs.getString("pro_date"), rs.getString("exp_date"), rs.getString("quantity"), rs.getString("price")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      colp_id.setCellValueFactory(new PropertyValueFactory<>("p_id"));
      colname.setCellValueFactory(new PropertyValueFactory<>("name"));
      colvendor.setCellValueFactory(new PropertyValueFactory<>("vendor"));
      colp_date.setCellValueFactory(new PropertyValueFactory<>("p_date"));
      colex_date.setCellValueFactory(new PropertyValueFactory<>("e_date"));
      colqty.setCellValueFactory(new PropertyValueFactory<>("qnty"));
      colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
      
      
      stocktable.setItems(oblist);
    } 
    
    
    
    
    
}
