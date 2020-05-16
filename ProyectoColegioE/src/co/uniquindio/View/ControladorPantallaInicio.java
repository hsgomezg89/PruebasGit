package co.uniquindio.View;

import java.io.IOException;

import co.uniquindio.Colegio.Colegio;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class ControladorPantallaInicio {

	    

    @FXML
    private MenuBar Pantalla_Menu;

    @FXML
    private MenuItem BotonM_NuevoEs;

    @FXML
    private MenuItem BotonM_ListaEstudiantes;

    @FXML
    private MenuItem BotonM_Guardar_es;

    @FXML
    private MenuItem BotonM_Cerrar_A;

    @FXML
    private MenuItem BotonM_EliminarES;
    
    @FXML
    private MenuItem BotonMModificarEs;
    @FXML
    private MenuItem Boton_AcercaDe;
    
	
    String ruta_Pantalla_Estudiante = "/co/uniquindio/View/Interfaz_Estudiantef.fxml";
	String ruta_imagen = "/co/uniquindio/Iconos/descarga.jpg";
	String ruta_Pantalla_Lista_Estudiantes= "/co/uniquindio/View/Interfaz_ListaEstudiantes.fxml";
	String ruta_Eliminar_estudiante ="/co/uniquindio/View/Interfaz_Eliminar_Estudiante.fxml";
	String ruta_modfificar_estuidante ="/co/uniquindio/View/Interfaz_Modificar_Estudiante.fxml";
	String ruta_AcercaDe ="/co/uniquindio/View/Interfaz_AcercaDe.fxml";
    private Stage stage;
    private Parent root;

	private Colegio colegio;

   	@FXML
    void On_evento_Menu(ActionEvent event) {
   		
   		 root = null;
   		if (event.getSource() == BotonM_NuevoEs) {
   			

			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Estudiante));
				root = loader.load();
				ControladorRegistroEstudiante control =loader.getController();
				colegio =new Colegio("Colegio casd", 2);
				control.setStage(stage);
				Scene scene =new Scene(root);
				stage.setScene(scene);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
   		}else if (event.getSource() == BotonM_ListaEstudiantes) {
			
   			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Lista_Estudiantes));
				root = loader.load();
				ControladorPantallaListarEstudiantes control =loader.getController();
				control.setColegio(colegio);
				control.setStage(stage);
				Scene scene =new Scene(root);
				stage.setScene(scene);
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
		
		
			
   		}else if (event.getSource()== BotonM_EliminarES) {
   			
   	   		 root = null;
   	   		
   				try {
   					FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Eliminar_estudiante));
   					root = loader.load();
   					ControladorEliminarEstudiante control =loader.getController();
   					colegio =new Colegio("Colegio casd", 2);
   					control.setColegio(colegio);
   					control.setStage(stage);
   	   				Scene scene =new Scene(root);
   	   				stage.setScene(scene);
   	   				
   				} catch (IOException e) {
   			
   					e.printStackTrace();
   				}

   				
   		}else if (event.getSource()== BotonMModificarEs) {
   			
  	   		 root = null;
  	   		
  				try {
  					FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_modfificar_estuidante));
  					root = loader.load();
  					ControladorModificarEstudiante control =loader.getController();
  					control.setColegio(colegio);
   					control.setStage(stage);
   					Scene scene =new Scene(root);
   	  				stage.setScene(scene);
  				} catch (IOException e) {
  			
  					e.printStackTrace();
  				}

  			
  				
  				
  				
   		}else if (event.getSource()== Boton_AcercaDe) {
   			
 	   		 root = null;
 	   		
 				try {
 					FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_AcercaDe));
 					root = loader.load();
 					ControladorPantallaAcercaDe control =loader.getController();
 	 				Scene scene =new Scene(root);
                    stage.setScene(scene);
 	  		
 					control.setColegio(colegio);
 				} catch (IOException e) {
 			
 					e.printStackTrace();
 				}

 			
			
   		}else if (event.getSource() == BotonM_Cerrar_A) {
				
				Platform.exit();
			}
			

    }

  

    



   	public void setStage(Stage stage) {
		this.stage=stage;
		
	}
}
    