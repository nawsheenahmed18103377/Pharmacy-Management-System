
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.ConnectionUtil;


public class SellMedController implements Initializable {

    @FXML
    private Button homi;
    @FXML
    private TableView<StockModel> table;
    @FXML
    private TableColumn<StockModel, String> colid;
    @FXML
    private TableColumn<StockModel, String> colname;
    @FXML
    private TableColumn<StockModel, String> colstock;
    @FXML
    private TableColumn<StockModel, String> colprice;
    @FXML
    private TextField slip;
    @FXML
    private TextField cname;
    @FXML
    private TextField con;
    @FXML
    private TextField m1;
    @FXML
    private TextField q1;
    @FXML
    private TextField p1;
    @FXML
    private TextField m2;
    @FXML
    private TextField q2;
    @FXML
    private TextField p2;
    @FXML
    private TextField m3;
    @FXML
    private TextField q3;
    @FXML
    private TextField p3;
    @FXML
    private TextField m4;
    @FXML
    private TextField q4;
    @FXML
    private TextField p4;
    @FXML
    private TextField m5;
    @FXML
    private TextField q5;
    @FXML
    private TextField p5;
    @FXML
    private Button done;

    
    
    
    @FXML
    private void homebutton(MouseEvent event) {
        
        if (event.getSource() == homi) {
           
           
                try {

                   
                    Node node = (Node) event.getSource();
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
    
    
    public String sl ;
    public String name;
    public String contact;
    public String med1;
    public String qu1;
    public String pr1;
    public String med2;
    public String qu2;
   public  String pr2;
    public  String med3 ;
   public  String qu3;
   public  String pr3 ;
    public String med4;
   public  String qu4 ;
    public String pr4 ; 
   public  String med5 ;
   public  String qu5 ;
   public  String pr5 ;

   
    public void set() {
       sl = slip.getText();
       name = cname.getText();
        contact  = con.getText();
        med1  = m1.getText();
        qu1 = q1.getText();
          pr1 = p1.getText();
         med2  = m2.getText();
          qu2 = q2.getText();
          pr2 = p2.getText();
          med3  = m3.getText();
          qu3 = q3.getText();
          pr3 = p3.getText();
           med4  = m4.getText();
          qu4 = q4.getText();
           pr4 = p4.getText();
          med5  = m5.getText();
           qu5 = q5.getText();
          pr5 = p5.getText();
          
          
    }


    
    @FXML
    private void done(MouseEvent event) {
        
        if (event.getSource() == done) {
           
           
                try {
                    
                    set();
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    
                    stage.close();
                   FXMLLoader obj = new FXMLLoader(getClass().getResource("/fxml/Show.fxml"));
                   Parent root = (Parent)obj.load();
                   
                   ShowController show = obj.getController();
                    int number = Integer.parseInt(pr1)+Integer.parseInt(pr2)+Integer.parseInt(pr3)+Integer.parseInt(pr4)+Integer.parseInt(pr5);
                   String total = Integer.toString(number);
                   
                   show.custinfo(sl,name,contact);
                   show.medinfo1(med1, qu1, pr1);
                   show.medinfo2(med2, qu2, pr2);
                   show.medinfo3(med3, qu3, pr3);
                   show.medinfo4(med4, qu4, pr4);
                   show.medinfo5(med5, qu5, pr5);
                   show.total(total);
                   
                   
                  
                    stage.setScene(new Scene(root));
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    
    
    
    ObservableList<StockModel> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
       
      colid.setCellValueFactory(new PropertyValueFactory<>("p_id"));
      colname.setCellValueFactory(new PropertyValueFactory<>("name"));
      colstock.setCellValueFactory(new PropertyValueFactory<>("qnty"));
      colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
      
      
      table.setItems(oblist);
       
    }   
    
}
