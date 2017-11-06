package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioMenuItem;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.TextArea;
import parser.*;
import java.io.IOException;

public class Controller {
    String filepath;
    File file;
    int counter=0;

    @FXML
    Canvas canvas=new Canvas();
    @FXML
    private TextArea text;

    @FXML
    void Search(ActionEvent event) {
        Stage stage=new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file=fileChooser.showOpenDialog(stage);
        filepath=file.getPath();

    }
    @FXML
    void run()throws IOException {
            CodeParser code=new CodeParser("C:\\Users\\karol_000\\Documents\\test.txt");
            text.setText(code.finalList.getNode(counter).getKey()+"\n"+code.finalList.getNode(counter).getArg());


    }
    @FXML
    public void close(){
        text.setText("");
    }
    @FXML
    public void about(){
        String info="Eclipse Debuger: Herramienta visualiza diagrama de flujo del codigo, oprima file/Open... \n para abrir el archivo y luego selecciones Run/Run file";
        text.setText(info);
    }
    @FXML
    public void stepinto()throws IOException{
        counter+=1;
        run();
    }

}

