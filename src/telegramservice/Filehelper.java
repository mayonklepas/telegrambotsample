/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 *
 * @author minami
 */
public class Filehelper {

    File dbsetting = new File("dbsetting");

    public Filehelper() {
        if (!dbsetting.exists()) {
            try {
                dbsetting.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Filehelper.class.getName()).log(Level.SEVERE, null, ex);
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Kesalahan");
                al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
                VBox v = new VBox();
                v.setPadding(new Insets(5, 5, 5, 5));
                v.setSpacing(5);
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                TextArea terror = new TextArea(sw.toString());
                terror.setMaxWidth(400);
                terror.setMaxHeight(400);
                terror.setWrapText(true);
                v.getChildren().add(new Label("Detail error yang terbaca :"));
                v.getChildren().add(terror);
                al.getDialogPane().setContent(v);
                al.showAndWait();
            }
        }

    }

//database
    public String host() {
        String data = "";
        int line = 0;
        String dataline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(dbsetting));

            while ((data = br.readLine()) != null) {
                line++;
                if (line == 1) {
                    dataline = data;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();
        }

        return dataline;
    }

    public String port() {
        String data = "";
        int line = 0;
        String dataline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(dbsetting));

            while ((data = br.readLine()) != null) {
                line++;
                if (line == 2) {
                    dataline = data;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();
        }

        return dataline;
    }

    public String username() {
        String data = "";
        int line = 0;
        String dataline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(dbsetting));

            while ((data = br.readLine()) != null) {
                line++;
                if (line == 3) {
                    dataline = data;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();
        }

        return dataline;
    }

    public String password() {
        String data = "";
        int line = 0;
        String dataline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(dbsetting));

            while ((data = br.readLine()) != null) {
                line++;
                if (line == 4) {
                    dataline = data;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();
        }

        return dataline;
    }

    public String database() {
        String data = "";
        int line = 0;
        String dataline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(dbsetting));

            while ((data = br.readLine()) != null) {
                line++;
                if (line == 5) {
                    dataline = data;
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(Filehelper.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Kesalahan");
            al.setHeaderText("Terjadi Kesalahan Pada Aplikasi");
            VBox v = new VBox();
            v.setPadding(new Insets(5, 5, 5, 5));
            v.setSpacing(5);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            TextArea terror = new TextArea(sw.toString());
            terror.setMaxWidth(400);
            terror.setMaxHeight(400);
            terror.setWrapText(true);
            v.getChildren().add(new Label("Detail error yang terbaca :"));
            v.getChildren().add(terror);
            al.getDialogPane().setContent(v);
            al.showAndWait();
        }

        return dataline;
    }

   

}
