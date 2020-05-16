package co.uniquindio.View;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import co.uniquindio.Colegio.Colegio;
import co.uniquindio.Colegio.Estudiante;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorPantallaAcercaDe {



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
	private Pane Pantalla_Estudiante;

	@FXML
	private Label L_identificacion;

	@FXML
	private TextField Text_Id;

	@FXML
	private Label L_nombre;

	@FXML
	private TextField Text_nombre;

	@FXML
	private Label L_Email;

	@FXML
	private TextField Text_Email;

	@FXML
	private TextField Text_Apellido;

	@FXML
	private Label L_Apellido;

	@FXML
	private Label L_IdentificacionAS;

	@FXML
	private Label L_NombreAS;

	@FXML
	private Label L_ApellidoAs;

	@FXML
	private Label L_EmailAS;

	@FXML
	private Button boton_guardar;

	@FXML
	private TextField Text_ID_Buscar;

	@FXML
	private Button Boton_buscar;
	
    @FXML
    private TextArea Text_Area_Mostrar;
    
    @FXML
    private MenuItem Boton_AcercaDe;
	String ruta_Pantalla_Estudiante = "/co/uniquindio/View/Interfaz_Estudiantef.fxml";
	String ruta_imagen = "/co/uniquindio/Iconos/ICONO.jpg";
	String ruta_Pantalla_Lista_Estudiantes = "/co/uniquindio/View/Interfaz_ListaEstudiantes.fxml";
	String ruta_Eliminar_estudiante ="/co/uniquindio/View/Interfaz_Eliminar_Estudiante.fxml";
	String ruta_modfificar_estuidante ="/co/uniquindio/View/Interfaz_Modificar_Estudiante.fxml";
	String ruta_AcercaDe ="/co/uniquindio/View/Interfaz_AcercaDe.fxml";

	private Stage stage;
	Alert alerta;

	private Colegio colegio;

    @FXML
    void On_evento_Menu(ActionEvent event) throws IOException {

		Parent root = null;
		if (event.getSource() == BotonM_NuevoEs) {

			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Estudiante));
				root = loader.load();
				ControladorRegistroEstudiante control = loader.getController();
				control.setColegio(colegio);
				control.setStage(stage);
				Scene scene = new Scene(root);

				stage.setScene(scene);

			} catch (NullPointerException e) {
				// UIManager ui =new UIManager();
				 alerta = new Alert(AlertType.ERROR);

				// ui.put("Alert.background",new ColorUIResource(14,0,0));
				// ui.put("Panel.background",new ColorUIResource(14,0,0));
				// ui.put("JOptionPane.background",new ColorUIResource(14,0,0));

				alerta.setTitle("INFORMACION");
				alerta.setContentText("Esta en el registro de un nuevo estudiante");
				alerta.setHeaderText("");
				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();

			}

		} else if (event.getSource() == BotonM_ListaEstudiantes) {

			Parent root1 = null;
			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Lista_Estudiantes));
				root1 = loader.load();

				Scene scene = new Scene(root1);

				ControladorPantallaListarEstudiantes control = loader.getController();
				control.setColegio(colegio);

				control.setStage(stage);

				stage.setScene(scene);
				stage.show();

			} catch (IOException e) {

				e.printStackTrace();
			}

		} else if (event.getSource() == BotonM_Cerrar_A) {

			Platform.exit();

		} else if (event.getSource() == BotonM_Guardar_es) {
			
			 alerta = new Alert(AlertType.ERROR);


				alerta.setTitle("INFORMACION");
				alerta.setContentText("No puede guardar un estudiante nulo");
				alerta.setHeaderText("");
				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
			
		}else if (event.getSource()== BotonM_EliminarES) {
   			
   	   		 root = null;
   	   		
   				try {
   					FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Eliminar_estudiante));
   					root = loader.load();
   					ControladorEliminarEstudiante control =loader.getController();
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
 					control.setColegio(colegio);
   					control.setStage(stage);
 					Scene scene =new Scene(root);
 	 				stage.setScene(scene);
 				} catch (IOException e) {
 			
 					e.printStackTrace();
 				}

 			
 				
  				
   		}
		
		

	}

	public void setStage(Stage stage) {
		this.stage = stage;

	}

	public void setColegio(Colegio colegio) {
			 this.colegio=colegio;

		
	}


}
