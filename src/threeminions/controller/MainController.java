/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeminions.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RIZAL
 */
public class MainController implements Initializable {

    @FXML
    private Pane box;
    @FXML
    private AnchorPane parent;
    @FXML
    private Pane minionA;
    @FXML
    private Pane minionC1;
    @FXML
    private Pane minionC2;
    @FXML
    private Pane minionB2;
    @FXML
    private Pane minionB1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            eyeProperties();
            mouseListenerProperties();
        });
    } 
    //stage width & height
    private double parentWidth, parentHeight;
    //pref size box
    private final double boxPrefWidth =400, boxPrefHeight =330;
    
    //pref x,y minions from fxml
    private final double xDefMinionA =311, yDefMinionA =207;
    private final double xDefMinionB1 =211, yDefMinionB1 =65;
    private final double xDefMinionB2 =190, yDefMinionB2 =65;
    private final double xDefMinionC1 =94, yDefMinionC1 =202;
    private final double xDefMinionC2 =62, yDefMinionC2 =202;
    
    //actual x,y on stage
    private double actualXMinionA, actualYMinionA;
    private double actualXMinionB1, actualYMinionB1;
    private double actualXMinionB2, actualYMinionB2;
    private double actualXMinionC1, actualYMinionC1;
    private double actualXMinionC2, actualYMinionC2;
    
    //x,y on parent
    private double XMinionA, YMinionA;
    private double XMinionB1, YMinionB1;
    private double XMinionB2, YMinionB2;
    private double XMinionC1, YMinionC1;
    private double XMinionC2, YMinionC2;
    
    private void eyeProperties(){
        Stage stage = (Stage) parent.getScene().getWindow();
        parent.widthProperty().addListener((obs, oldVal, newVal) -> {
            parentWidth = stage.getWidth();
            
            XMinionA = widthListener(minionA, XMinionA, xDefMinionA);
            actualXMinionA = ((parentWidth - box.getWidth())/ 2)+XMinionA;
            XMinionB1 = widthListener(minionB1, XMinionB1, xDefMinionB1);
            actualXMinionB1 = ((parentWidth - box.getWidth())/ 2)+XMinionB1;
            XMinionB2 = widthListener(minionB2, XMinionB2, xDefMinionB2);
            actualXMinionB2 = ((parentWidth - box.getWidth())/ 2)+XMinionB2;
            XMinionC1 = widthListener(minionC1, XMinionC1, xDefMinionC1);
            actualXMinionC1 = ((parentWidth - box.getWidth())/ 2)+XMinionC1;
            XMinionC2 = widthListener(minionC2, XMinionC2, xDefMinionC2);
            actualXMinionC2 = ((parentWidth - box.getWidth())/ 2)+XMinionC2;
        });
        parent.heightProperty().addListener((obs, oldVal, newVal) -> {
            parentHeight = stage.getHeight();
            
            YMinionA = heightListener(minionA, YMinionA, yDefMinionA);
            actualYMinionA = ((parentHeight - box.getHeight())/ 2)+YMinionA;
            YMinionB1 = heightListener(minionB1, YMinionB1, yDefMinionB1);
            actualYMinionB1 = ((parentHeight - box.getHeight())/ 2)+YMinionB1;
            YMinionB2 = heightListener(minionB2, YMinionB2, yDefMinionB2);
            actualYMinionB2 = ((parentHeight - box.getHeight())/ 2)+YMinionB2;
            YMinionC1 = heightListener(minionC1, YMinionC1, yDefMinionC1);
            actualYMinionC1 = ((parentHeight - box.getHeight())/ 2)+YMinionC1;
            YMinionC2 = heightListener(minionC2, YMinionC2, yDefMinionC2);
            actualYMinionC2 = ((parentHeight - box.getHeight())/ 2)+YMinionC2;
        });
    }
    private double widthListener(Pane eye, double XMinion, 
            double defWidth){
        XMinion = box.getWidth() * defWidth / boxPrefWidth;
        eye.setLayoutX(XMinion);
        return XMinion;
    }
    private double heightListener(Pane eye, double YMinion, 
            double defHeight){
        YMinion = box.getHeight() * defHeight / boxPrefHeight;
        eye.setLayoutX(YMinion);
        return YMinion;
    }
    
    private void mouseListenerProperties(){
         parent.setOnMouseMoved((e) -> {
            //horz
            double pointX = e.getSceneX();
            mouseListener(true, minionA, pointX, actualXMinionA, XMinionA, 
                    parentWidth, box.getWidth(), 8);
            mouseListener(true, minionB1, pointX, actualXMinionB1, XMinionB1, 
                    parentWidth, box.getWidth(), 4);
            mouseListener(true, minionB2, pointX, actualXMinionB2, XMinionB2, 
                    parentWidth, box.getWidth(), 4);
            mouseListener(true, minionC1, pointX, actualXMinionC1, XMinionC1, 
                    parentWidth, box.getWidth(), 7);
            mouseListener(true, minionC2, pointX, actualXMinionC2, XMinionC2, 
                    parentWidth, box.getWidth(), 7);
            
            //vertical
            double pointY = e.getSceneY();
            mouseListener(false, minionA, pointY, actualYMinionA, YMinionA, 
                    parentHeight, box.getHeight(), 8);
            mouseListener(false, minionB1, pointY, actualYMinionB1, YMinionB1, 
                    parentHeight, box.getHeight(), 4);
            mouseListener(false, minionB2, pointY, actualYMinionB2, YMinionB2, 
                    parentHeight, box.getHeight(), 4);
            mouseListener(false, minionC1, pointY, actualYMinionC1, YMinionC1, 
                    parentHeight, box.getHeight(), 7);
            mouseListener(false, minionC2, pointY, actualYMinionC2, YMinionC2, 
                    parentHeight, box.getHeight(), 7);
         });
    }
    private void mouseListener(boolean isAxis, Pane eye, double mouse, double actual, double pos,
            double size, double boxSize, double tolerance){
        if (isAxis) {
            if (mouse > actual) {
                if (mouse >= actual + tolerance) {
                    eye.setLayoutX(pos + tolerance);
                }else{
                    eye.setLayoutX(mouse- ((size - boxSize)/ 2));
                }
            }else{
                if (mouse <= actual - tolerance) {
                    eye.setLayoutX(pos - tolerance);
                }else{
                    eye.setLayoutX(mouse- ((size - boxSize)/ 2));
                }
            }
        }else{
            if (mouse > actual) {
                if (mouse >= actual + tolerance) {
                    eye.setLayoutY(pos + tolerance);
                }else{
                    eye.setLayoutY(mouse- ((size - boxSize)/ 2));
                }
            }else{
                if (mouse <= actual - tolerance) {
                    eye.setLayoutY(pos - tolerance);
                }else{
                    eye.setLayoutY(mouse- ((size - boxSize)/ 2));
                }
            }
        }
    }
    
}
