
package SignUp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import timetablesystem.javaconnect;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class SignUpController implements Initializable {
Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
    @FXML
    private TextField id;
    @FXML
    private TextField fullname;
    @FXML
    private PasswordField password;
    @FXML
    private StackPane stick;
    @FXML
    private Text closeIcon;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = javaconnect.ConnecrDB();
        stick.setVisible(false);
        Random();
    }
      public void Random(){
          Random rd = new Random();
    id.setText("SFF"+rd.nextInt(889988+1));        
    } 
  @FXML
   private void signup(ActionEvent event){
       if(fullname.getText().isEmpty() || password.getText().isEmpty()){
            emptyMessage();
        }else{
       String sql = "INSERT INTO SIGNUP (ID , FULLNAME , PASSWORD) VALUES (?,?,?)";
    try{
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,id.getText());
      pstmt.setString(2,fullname.getText());
      pstmt.setString(3,password.getText());
      pstmt.execute();
      Random();
      stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Success")); // Header of the Dialog
  content.setBody(new Text("Account Created")); // Text in the dialog
  JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }   
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
       closeIcon.getScene().getWindow().hide();
    }
}
