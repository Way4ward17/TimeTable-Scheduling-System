/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author way4ward
 */
public class TimeTableSystem extends Application {
 Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
        
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        onee();
        two();
        three();
        four();
        five();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
private void onee(){
    String sql = "CREATE TABLE IF NOT EXISTS `COURSE` (NAME VARCHAR(50) , LEVEL VARCHAR(100))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
}  
private void two(){
    String sql = "CREATE TABLE IF NOT EXISTS `VENUE` (NAME VARCHAR(50) , CAPACITY VARCHAR(100))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
} 
private void three(){
    String sql = "CREATE TABLE IF NOT EXISTS `LECTURER` (NAME VARCHAR(50) , LEVEL VARCHAR(100))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
} 
private void four(){
    String sql = "CREATE TABLE IF NOT EXISTS `LEVEL` (NAME VARCHAR(50))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
} 
private void five(){
    String sql = "CREATE TABLE IF NOT EXISTS `VENUE` (ID VARCHAR(50) , FULLNAME VARCHAR(100), PASSWORD VARCHAR(30))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
} 
}
