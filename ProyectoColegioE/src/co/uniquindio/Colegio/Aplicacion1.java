-package co.uniquindio.Colegio;

import co.uniquindio.View.ControladorPantallaInicio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.stage.Stage;

public class Aplicacion1 extends Application {

	String ruta_imagen = "/co/uniquindio/Iconos/ICONO.jpg";

	public static void main(String[] args) {
		

	
		launch(args);
		
			
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/co/uniquindio/View/Interfaz_Inicio.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		ControladorPantallaInicio control1 =loader.getController();
		primaryStage.setResizable(false);	
		control1.setStage(primaryStage);
		primaryStage.setTitle("Colegio C.A.S.D");
		Image icono_Casd =new Image(ruta_imagen, false);
		primaryStage.getIcons().add(icono_Casd);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
