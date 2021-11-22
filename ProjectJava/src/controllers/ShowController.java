/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ShowController implements Initializable {

    @FXML
    private Button hbtn;
    @FXML
    private Label slno;
    @FXML
    private Label name;
    @FXML
    private Label con;
    @FXML
    private Label n1;
    @FXML
    private Label q1;
    @FXML
    private Label p1;
    @FXML
    private Label n2;
    @FXML
    private Label q2;
    @FXML
    private Label p2;
    @FXML
    private Label n3;
    @FXML
    private Label q3;
    @FXML
    private Label p3;
    @FXML
    private Label n4;
    @FXML
    private Label q4;
    @FXML
    private Label p4;
    @FXML
    private Label n5;
    @FXML
    private Label q5;
    @FXML
    private Label p5;
    @FXML
    private Label tot;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void homebutton(MouseEvent h)
    {
        if(h.getSource()==hbtn)
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
    
    SellMedController obj = new SellMedController();
    @Override
    public void initialize (URL url, ResourceBundle rb) {
         
    }  
    
    public void custinfo(String a, String b, String c)
    {
        slno.setText("Slip No. : "+a);
        name.setText("Name : "+b);
        con.setText("Contact No. : "+c);   
    }
    
    public void medinfo1(String a, String b, String c)
    {
       n1.setText(a);
       q1.setText(b);
       p1.setText(c);   
    }
    public void medinfo2(String a, String b, String c)
    {
       n2.setText(a);
       q2.setText(b);
       p2.setText(c);   
    }
    public void medinfo3(String a, String b, String c)
    {
       n3.setText(a);
       q3.setText(b);
       p3.setText(c);   
    }
    public void medinfo4(String a, String b, String c)
    {
       n4.setText(a);
       q4.setText(b);
       p4.setText(c);   
    }
    public void medinfo5(String a, String b, String c)
    {
       n5.setText(a);
       q5.setText(b);
       p5.setText(c);   
    }
    public void total(String a)
    {
       tot.setText(a);
    }
    
    
}
