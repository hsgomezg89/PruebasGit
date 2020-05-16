package co.uniquindio.View;

import java.io.IOException;
import java.util.Observable;

import javax.swing.JOptionPane;

import co.uniquindio.Colegio.Colegio;
import co.uniquindio.Colegio.Estudiante;
import co.uniquindio.Colegio.Estudiante2;
import co.uniquindio.Colegio.NohayCupoEstudiante;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorPantallaListarEstudiantes {

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
  	private Button Boton_AcercaDe;
    

    @FXML
    private TableView<Estudiante2> Tabla_id;

    @FXML
    private TableColumn<Estudiante2,Estudiante2> Tabla_Identificacion;

    @FXML
    private TableColumn<?, ?> Tabla_Nombre;

    @FXML
    private TableColumn<?, ?> Tabla_Apellido;

    @FXML
    private TableColumn<?, ?> Tabla_correo;

    @FXML
    private Button Boton_ListarEstudiantes;
    
    String ruta_Pantalla_Estudiante = "/co/uniquindio/View/Interfaz_Estudiantef.fxml";
   	String ruta_imagen = "/co/uniquindio/Iconos/descarga.jpg";
   	String ruta_Pantalla_Lista_Estudiantes= "/co/uniquindio/View/Interfaz_ListaEstudiantes.fxml";
   	String ruta_Eliminar_estudiante ="/co/uniquindio/View/Interfaz_Eliminar_Estudiante.fxml";
	String ruta_modfificar_estuidante ="/co/uniquindio/View/Interfaz_Modificar_Estudiante.fxml";
	String ruta_AcercaDe ="/co/uniquindio/View/Interfaz_AcercaDe.fxml";

	public Stage stage;

	Colegio colegio;
	Estudiante estudiante;


    @FXML
    void On_evento_Menu(ActionEvent event) throws IOException {
    	
 		Parent root = null;
   	
		if (event.getSource() == BotonM_NuevoEs) {
   			

			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Estudiante));
				root = loader.load();
				ControladorRegistroEstudiante control =loader.getController();
				control.setColegio(colegio);
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
				ControladorRegistroEstudiante control =loader.getController();
				control.setColegio(colegio);
				control.setStage(stage);
				Scene scene =new Scene(root);
				stage.setScene(scene);
			} catch (NullPointerException e) {
				

				Alert alerta =new Alert(AlertType.ERROR);
				
				alerta.setTitle("");
			
				alerta.setContentText("Esta en la lista de Estudiantes");
				alerta.setHeaderText("INFORMACION");
			
				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
			}	
				
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

	 			
	  				
			
   		}else if (event.getSource() == BotonM_Cerrar_A) {
				
				Platform.exit();
			}

    }

    @FXML
    void on_click(MouseEvent event) throws NohayCupoEstudiante {
    	
    	if (event.getSource()==Boton_ListarEstudiantes) {
    		JOptionPane.showMessageDialog(null, "hola esto si entro");
    		llenarTabla();
    		
    	}else {
    		JOptionPane.showMessageDialog(null, "hola esto no funciona");
    	}

    }
    
	public void setStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setColegio(Colegio colegio) {
			this.colegio=colegio;
		
	}
	public void llenarTabla() throws NohayCupoEstudiante {
		//Estudiante estudiantes [] = colegio.recoggerArregloEstudiante();
		Colegio colegio = new Colegio("Institucion educativa C.A.S.D ", 2);
		
		Estudiante2 estudiante1=new Estudiante2("2", "juan", "montes", "el mismo");
		Estudiante estudiante2=new Estudiante("2", "juan", "montes", "el mismo");
		//colegio.adicionarEstudiante(estudiante1);
		
	     Tabla_id =new TableView<>();
	     
	     ObservableList<Estudiante2> tablaEstudiantes =FXCollections.observableArrayList(
	    		 
	    		 new Estudiante2("1", "carlos", "montes", "el mismo")
	    		);
	     
	     Tabla_id.setItems(tablaEstudiantes);
	     TableColumn<Estudiante2, String> columnaId = new TableColumn<>("Tabla_Identificacion");
	     columnaId.setCellValueFactory(new PropertyValueFactory<Estudiante2, String>("estudiante.getId()"));
	     columnaId.setMinWidth(Tabla_id.getMaxWidth()/4);
	     Tabla_id.getColumns().addAll(columnaId);
	     
	     
	     /*
	     for (int i = 0; i < Tabla_id.; i++) {
			
		}
		for (int i = 0; i < estudiantes.length; i++) {
			
			
			String nombre = estudiantes[i].getNombre();
			Tabla_Nombre.setCellValueFactory(nombre);
			
		}
		*/
		
	
}

}
