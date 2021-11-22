
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.ConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddmedController implements Initializable {

    @FXML
    private Button homebtn;
    @FXML
    private TextField pid;
    @FXML
    private TextField pname;
    @FXML
    private TextField psup;
    @FXML
    private TextField pq;
    @FXML
    private TextField pp;
    @FXML
    private Button addbtn;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void homebutton(MouseEvent event) {
        
        if (event.getSource() == homebtn) {
           
           
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
    
        
        PreparedStatement preparedStat;
        
        
    @FXML
   private void medaddbutton(MouseEvent event) throws SQLException {
    
    if (event.getSource() == addbtn) {
           
           
                try {
                    
                    String mid = pid.getText();
                    String mname = pname.getText();
                    String msup = psup.getText();
                    String mqty = pq.getText();
                    String mprice = pp.getText();
                    
                    String q = "INSERT INTO medicine(p_id,name,vendor,pro_date,exp_date,quantity,price) VALUES (?,?,?,'2019-12-01','2020-11-30',?,?)";
                   
                    try
                    {
                        preparedStat = ConnectionUtil.conDB().prepareStatement(q);
                        
                        preparedStat.setString(1,mid);
                        preparedStat.setString(2,mname);
                        preparedStat.setString(3,msup);
                        preparedStat.setString(4,mqty);
                        preparedStat.setString(5,mprice);
                        
                        
                        
                        
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e);
                    }
                    
                    finally
                    {
                        preparedStat.execute();
                        preparedStat.close();
                    }
                    
                    
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Addmed.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    
    
    
    
    }
    

