/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.spi.ior.Writeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import timetablesystem.javaconnect;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class HomeController implements Initializable {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
ObservableList<String> A = FXCollections.observableArrayList("7:00AM","8:00AM","9:00AM","10:00AM","11:00AM","12:00PM","1:00PM","2:00PM","3:00PM");
ObservableList<String> B = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Thursday","Friday");
   
@FXML
    private ComboBox<String> time;
    @FXML
    private ComboBox<String> cday;
    @FXML
    private ComboBox<String> cvenue;
    @FXML
    private ComboBox<String> ccourse;
    @FXML
    private AnchorPane timeTableHolder;
   final ObservableList a =  FXCollections.observableArrayList();
   final ObservableList b =  FXCollections.observableArrayList();
   final ObservableList c =  FXCollections.observableArrayList();
   final ObservableList d =  FXCollections.observableArrayList();
    @FXML
    private JFXTextField Addlevel;
    @FXML
    private JFXTextField Addcourse;
    @FXML
    private JFXTextField Addvenue;
    @FXML
    private JFXTextField VenueCapacity;
    @FXML
    private JFXButton submitLevel;
    @FXML
    private JFXButton submitVenue;
    @FXML
    private JFXButton submitCourse;
    @FXML
    private JFXComboBox<?> LeveInCourse;
    
    @FXML
    private JFXTextField lecturer;
    @FXML
    private JFXComboBox<?> lecturercourse;
    @FXML
    private JFXButton submitVenue1;
    @FXML
    private StackPane stick;
    @FXML
    private ComboBox<String> levelTable;
    @FXML
    private ComboBox<String> leturerTable;
    @FXML
    private TextArea mon7;
    @FXML
    private TextArea tue7;
    @FXML
    private TextArea wed7;
    @FXML
    private TextArea thur7;
    @FXML
    private TextArea fr7i;
    @FXML
    private TextArea mon8;
    @FXML
    private TextArea tue8;
    @FXML
    private TextArea wed8;
    @FXML
    private TextArea thur8;
    @FXML
    private TextArea fri8;
    @FXML
    private TextArea mon9;
    @FXML
    private TextArea tue9;
    @FXML
    private TextArea wed9;
    @FXML
    private TextArea thur9;
    @FXML
    private TextArea fri9;
    @FXML
    private TextArea mon10;
    @FXML
    private TextArea tue10;
    @FXML
    private TextArea wed10;
    @FXML
    private TextArea thur10;
    @FXML
    private TextArea fri10;
    @FXML
    private TextArea mon11;
    @FXML
    private TextArea tue11;
    @FXML
    private TextArea wed11;
    @FXML
    private TextArea thur11;
    @FXML
    private TextArea fri11;
    @FXML
    private TextArea mon12;
    @FXML
    private TextArea tue12;
    @FXML
    private TextArea wed12;
    @FXML
    private TextArea thur12;
    @FXML
    private TextArea fri12;
    @FXML
    private TextArea mon1;
    @FXML
    private TextArea tue1;
    @FXML
    private TextArea wed1;
    @FXML
    private TextArea thur1;
    @FXML
    private TextArea fri1;
    @FXML
    private TextArea mon2;
    @FXML
    private TextArea tue2;
    @FXML
    private TextArea wed2;
    @FXML
    private TextArea thur2;
    @FXML
    private TextArea fri2;
    @FXML
    private TextArea fri3;
    @FXML
    private TextArea thur3;
    @FXML
    private TextArea wed3;
    @FXML
    private TextArea tue3;
    @FXML
    private TextArea mon3;
    private String tim ;
     private   String venue ;
    private    String cos ;
    private    String day ;
    private    String lec ;
     private   String lev ;
     private String date;
     private String timee;
    @FXML
    private Text datey;
    @FXML
    private Text empty;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = javaconnect.ConnecrDB();
        empty.setVisible(false);
        stick.setVisible(false);
        fetch();
        fetch1();
        fetch2();
        fetch3();
        timeAndDate();
        cvenue.setItems(b);
        LeveInCourse.setItems(c);
        leturerTable.setItems(d);
        lecturercourse.setItems(a);
        ccourse.setItems(a);
        levelTable.setItems(c);
     time.setItems(A);
     cday.setItems(B);
    }    
        public void fetch(){
         a.clear();
        String sql = "select NAME from COURSE";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                a.add(rs.getString("NAME"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }
        
          public void fetch1(){
         b.clear();
        String sql = "select NAME from VENUE";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                b.add(rs.getString("NAME"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }
             public void fetch2(){
         c.clear();
        String sql = "select NAME from LEVEL";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                c.add(rs.getString("NAME"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }
                    public void fetch3(){
         d.clear();
        String sql = "select NAME from LECTURER";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                d.add(rs.getString("NAME"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }

    @FXML
    private void Addcourse(ActionEvent event) {
          if(Addcourse.getText().isEmpty()){
            emptyMessage();
        }else{
        String sql = "INSERT INTO COURSE(NAME,LEVEL) VALUES (?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , Addcourse.getText());
            pstmt.setString(2 , (String) LeveInCourse.getSelectionModel().getSelectedItem());
            pstmt.execute();
             fetch();
             Addcourse.setText("");
        fetch1();
         msg();
        fetch2();
        fetch3();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
          }
    }

    @FXML
    private void submitLevel(ActionEvent event) {
          if(Addlevel.getText().isEmpty()){
            emptyMessage();
        }else{
          String sql = "INSERT INTO LEVEL(NAME) VALUES (?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , Addlevel.getText());
            pstmt.execute();
            Addlevel.setText("");
             fetch();
        fetch1();
        fetch2();
        fetch3();
         msg();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
          }
    }

    @FXML
    private void submitVenue(ActionEvent event) {
          if(Addvenue.getText().isEmpty() || VenueCapacity.getText().isEmpty()){
            emptyMessage();
        }else{
              String sql = "INSERT INTO VENUE(NAME,CAPACITY) VALUES (?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , Addvenue.getText());
            pstmt.setString(2 , VenueCapacity.getText());
            
            pstmt.execute();
            Addvenue.setText("");
            VenueCapacity.setText("");
             msg();
             fetch();
        fetch1();
        fetch2();
        fetch3();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    }
    }
    
    private void venuecos(String Venue, String Course){
              stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text("Room "+Venue+" Has been allocated to \n"+Course)); // Text in the dialog
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
}
    
 private void cos(String Course){
              stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text(Course+" has been allocated")); // Text in the dialog
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
}   
 
 
 private void Level(String Level){
              stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text(Level+" will be Busy")); // Text in the dialog
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
}
 
    
private void lec(String Lecturer){
              stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text(Lecturer+" will be Busy")); // Text in the dialog
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
}

private void check(TextArea baba){
        if(baba.getText().contains(venue)){   
                 venuecos(venue,cos);  
            }else if(baba.getText().contains(lec)){
          lec(lec);
            }else if(baba.getText().contains(lev)){
              Level(lev);  
            }else{
                if(baba.getText().isEmpty()){
                    baba.setText(lev+"\n"+venue+"\n"+lec+"\n"+cos);
                }else{
                baba.setText(baba.getText()+"\n\n______________________\n"+lev+"\n"+venue+"\n"+lec+"\n"+cos);
            } 
            }
}
    @FXML
    private void initiate(ActionEvent event) {
         tim = time.getSelectionModel().getSelectedItem();
         venue = cvenue.getSelectionModel().getSelectedItem();
         cos = ccourse.getSelectionModel().getSelectedItem();
         day = cday.getSelectionModel().getSelectedItem();
         lec = leturerTable.getSelectionModel().getSelectedItem();
         lev = levelTable.getSelectionModel().getSelectedItem();
        
        //MONDAY
        if(day == "Monday" && tim == "7:00AM"){
          check(mon7);
        }
        if(day == "Monday" && tim == "8:00AM"){
         check(mon8);
        
        }
        if(day == "Monday" && tim == "9:00AM"){
         check(mon9); 
        }
        if(day == "Monday" && tim == "10:00AM"){
            check(mon10);  
        }
        if(day == "Monday" && tim == "11:00AM"){
           check(mon11);   
        }
        if(day == "Monday" && tim == "12:00PM"){
             check(mon12); 
        }
        if(day == "Monday" && tim == "1:00PM"){
             check(mon1); 
        }
        if(day == "Monday" && tim == "2:00PM"){
             check(mon2); 
        }
        if(day == "Monday" && tim == "3:00PM"){
             check(mon3); 
        }
         //TUESDAY
        if(day == "Tuesday" && tim == "7:00AM"){
             check(tue7); 
        }
        if(day == "Tuesday" && tim == "8:00AM"){
           check(tue8);  
        }
        if(day == "Tuesday" && tim == "9:00AM"){
            check(tue9); 
        }
        if(day == "Tuesday" && tim == "10:00AM"){
            check(tue10); 
        }
        if(day == "Tuesday" && tim == "11:00AM"){
            check(tue11); 
        }
        if(day == "Tuesday" && tim == "12:00PM"){
            check(tue12); 
        }
        if(day == "Tuesday" && tim == "1:00PM"){
            check(tue1); 
        }
        if(day == "Tuesday" && tim == "2:00PM"){
            check(tue2); 
        }
        if(day == "Tuesday" && tim == "3:00PM"){
         check(tue3);    
        }
      //  WEDNESDAY
       if(day == "Wednesday" && tim == "7:00AM"){
            check(wed7); 
        }
        if(day == "Wednesday" && tim == "8:00AM"){
            check(wed8); 
        }
        if(day == "Wednesday" && tim == "9:00AM"){
            check(wed9); 
        }
        if(day == "Wednesday" && tim == "10:00AM"){
            check(wed10); 
        }
        if(day == "Wednesday" && tim == "11:00AM"){
            check(wed11); 
        }
        if(day == "Wednesday" && tim == "12:00PM"){
            check(wed12); 
        }
        if(day == "Wednesday" && tim == "1:00PM"){
            check(wed1); 
        }
        if(day == "Wednesday" && tim == "2:00PM"){
            check(wed2); 
        }
        if(day == "Wednesday" && tim == "3:00PM"){
            check(wed3); 
        }
        
        //THURSDAY
         if(day == "Thursday" && tim == "7:00AM"){
            check(thur7); 
        }
        if(day == "Thursday" && tim == "8:00AM"){
            check(thur8); 
        }
        if(day == "Thursday" && tim == "9:00AM"){
            check(thur9); 
        }
        if(day == "Thursday" && tim == "10:00AM"){
            check(thur10); 
        }
        if(day == "Thursday" && tim == "11:00AM"){
            check(thur11); 
        }
        if(day == "Thursday" && tim == "12:00PM"){
            check(thur12); 
        }
        if(day == "Thursday" && tim == "1:00PM"){
            check(thur1); 
        }
        if(day == "Thursday" && tim == "2:00PM"){
            check(thur2); 
        }
        if(day == "Thursday" && tim == "3:00PM"){
            check(thur3); 
        }
        
        //FRIDAY
         if(day == "Friday" && tim == "7:00AM"){
            check(fr7i); 
        }
        if(day == "Friday" && tim == "8:00AM"){
            check(fri8); 
        }
        if(day == "Friday" && tim == "9:00AM"){
                check(fri9); 
        }
        if(day == "Friday" && tim == "10:00AM"){
                check(fri10); 
        }
        if(day == "Friday" && tim == "11:00AM"){
                check(fri11); 
        }
        if(day == "Friday" && tim == "12:00PM"){
                check(fri12); 
        }
        if(day == "Friday" && tim == "1:00PM"){
                check(fri1); 
        }
        if(day == "Friday" && tim == "2:00PM"){
                check(fri2); 
        }
        if(day == "Friday" && tim == "3:00PM"){
                check(fri3); 
        }
        
    }
  public void timeAndDate(){
         Calendar  cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        date = (day +":" +(month+1)+ ":"+ year);
       
         int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
       
       if(hour == 0){
            hour = hour + 12;
        }
        timee = (hour +":" +minute);   
        
        datey.setText(date);
        
        
    }
    @FXML
    private void submitLecturer(ActionEvent event) {
        if(lecturer.getText().isEmpty()){
            emptyMessage();
        }else{
           String sql = "INSERT INTO LECTURER(NAME,LEVEL) VALUES (?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , lecturer.getText());
            pstmt.setString(2 , (String) lecturercourse.getSelectionModel().getSelectedItem());
            pstmt.execute();
             msg();
             lecturer.setText("");
             fetch();
        fetch1();
        fetch2();
        fetch3();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        }
    }

    @FXML
    private void emptyAll(ActionEvent event) {
        String sql = "DELETE FROM COURSE";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
         String sql2 = "DELETE FROM LECTURER";
        try{
            pstmt = conn.prepareStatement(sql2);
            pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
         String sql3 = "DELETE FROM LEVEL";
        try{
            pstmt = conn.prepareStatement(sql3);
            pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
         String sql4 = "DELETE FROM VENUE";
        try{
            pstmt = conn.prepareStatement(sql4);
            pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
         msg();
    }
    
    private void msg(){
         Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Success")
               .text("Operation Succesful")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
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
    private void hide(MouseEvent event) {
    empty.setVisible(false);   
    }

    @FXML
    private void show(MouseEvent event) {
        empty.setVisible(true);
    }
    
}
