/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Home.HomeController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import timetablesystem.javaconnect;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class LoginController implements Initializable {
Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private JFXButton lgbtn;
    @FXML
    private AnchorPane splashAnchorPane;
    @FXML
    private JFXButton lgbtn1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   conn = javaconnect.ConnecrDB();
        lgbtn.setOnAction(e-> login(e));
    } 
    /**
      public void released() {
           
         String sql = "SELECT * FROM SIGNUP WHERE USERNAME=?";
        try{
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username.getText());           
            rs = pstmt.executeQuery();
            if(rs.next()){
                 put.setText(rs.getString("USER_ID"));
               
                    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
}**/
      private void login(ActionEvent event) {
        //  released();
          if(username.getText().isEmpty() || password.getText().isEmpty()){
            emptyMessage();
        }else{
      String sqll = "SELECT * FROM SIGNUP WHERE ID=? AND Password=?";
       try{
           pstmt = conn.prepareStatement(sqll);
           pstmt.setString(1 , username.getText());
           pstmt.setString(2 , password.getText());
           rs = pstmt.executeQuery();
           if(rs.next()){ 
           Stage stage = new Stage();
                FXMLLoader Loader = new FXMLLoader();
                 Loader.setLocation(getClass().getResource("/Home/Home.fxml"));
                 Parent root = Loader.load();
            
        /**    
        JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
       decorator.setBorder(Border.EMPTY);
       **/
        Scene scene = new Scene(root);

 
              stage.setScene(scene);
              stage.setResizable(false);
              stage.centerOnScreen();
              stage.setTitle("HOME");
              stage.show(); 
               splashAnchorPane.getScene().getWindow().hide();
                    
           
           }else{
              Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("INVALID DETAILS");
            alert.showAndWait();
           }
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null , e);
       }
          }
}
      @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
    loadwindow("/SignUp/SignUp.fxml","SIGN UP");     
     
    } 
    
      void loadwindow(String loc ,  String title){
        try {  
            Parent root = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage();
            stage.setTitle(title);
              Scene scene = new Scene(root);
     stage.setScene(scene);
  
        stage.initStyle(StageStyle.UNDECORATED);
      stage.setScene(scene);
      stage.setResizable(false);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 private void emptyMessage(){
         Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Error")
               .text("You cant Submit and EmptyField")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(7))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
    }
    @FXML
    private void closeme(MouseEvent event) {
        System.exit(0);
    }
}