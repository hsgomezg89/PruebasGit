package co.uniquindio.View;



import java.io.IOException;

import javax.swing.JOptionPane;

import co.uniquindio.Colegio.Colegio;
import co.uniquindio.Colegio.Estudiante;
import co.uniquindio.Colegio.NohayCupoEstudiante;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorEliminarEstudiante {

    @FXML
    private MenuBar Pantalla_Menu;

    @FXML
    private MenuItem BotonM_NuevoEs;

    @FXML
    private MenuItem BotonM_ListaEstudiantes;

    @FXML
    private MenuItem BotonM_Cerrar_A;

    @FXML
    private MenuItem BotonM_EliminarES;

    @FXML
    private MenuItem BotonMModificarEs;

    @FXML
    private Pane Pantalla_Estudiante;

    @FXML
    private TextField Text_ID_Buscar;

    @FXML
    private Button Boton_buscar;

    @FXML
    private TextArea Text_Area_Mostrar;
    
    @FXML
    private Button Boton_Eliminar;
    
    @FXML
  	private MenuItem Boton_AcercaDe;

	private Stage stage;
	
	 String ruta_Pantalla_Estudiante = "/co/uniquindio/View/Interfaz_Estudiantef.fxml";
	 String ruta_imagen = "/co/uniquindio/Iconos/descarga.jpg";
	 String ruta_Pantalla_Lista_Estudiantes= "/co/uniquindio/View/Interfaz_ListaEstudiantes.fxml";
     String ruta_Eliminar_estudiante ="/co/uniquindio/View/Interfaz_Eliminar_Estudiante.fxml";
	 String ruta_modfificar_estuidante ="/co/uniquindio/View/Interfaz_Modificar_Estudiante.fxml";
	 String ruta_AcercaDe ="/co/uniquindio/View/Interfaz_AcercaDe.fxml";
	 Colegio colegio;
	 Estudiante estudiante ;

	private Alert alerta;
	
	
	
	//Estudiante estudiante = new Estudiante("1","fred", "espana","gadas@mail");
	//Estudiante estudiante1 = new Estudiante("2","fred", "espana","gadas@mail");
	//Estudiante estudiante2 = new Estudiante("3","fred", "espana","gadas@mail");
	
	


    @FXML
    void On_evento_Menu(ActionEvent event) throws NohayCupoEstudiante, IOException {
    	
    	

   		Parent root = null;
   		if (event.getSource() == BotonM_NuevoEs) {
   			
   			

			//FXMLLoader PantallaRegistroEstudiante = new FXMLLoader(getClass().getResource(ruta_Pantalla_Estudiante));
		
			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Estudiante));
				root = loader.load();
				ControladorRegistroEstudiante control =loader.getController();
				control.setColegio(colegio);
				control.setStage(stage);
				Scene scene =new Scene(root);
				stage.setScene(scene);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
   		}
		
	
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
				ControladorPantallaListarEstudiantes control =loader.getController();
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
    	
    	
	 if(event.getSource() == Boton_buscar) {

	
		if (!Text_ID_Buscar.getText().isEmpty()) {
			
			try {

			String ID = Text_ID_Buscar.getText();

		    estudiante = colegio.buscarEstudiante(ID);
			System.out.println(estudiante.toString());
		    Text_Area_Mostrar.setText(estudiante.toString());
			// L_BuscarAS.setVisible(false);
			//Text_ID_Buscar.setText("");
			}catch (NullPointerException e) {
				alerta = new Alert(AlertType.ERROR);

		     	alerta.setTitle("");

				alerta.setContentText("El estudiante que desea buscar no es valido");
				alerta.setHeaderText("INFORMACION");

				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
				
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un susario valido");
			// L_BuscarAS.setVisible(true);
		}
	
    	
    	
	 } 	else if (event.getSource()== Boton_Eliminar) {
    	
          if (!Text_ID_Buscar.getText().isEmpty()) {
			
			try {
				

			String ID = Text_ID_Buscar.getText();

		    //estudiante = colegio.buscarEstudiante(ID);
		    //if(!colegio.buscarEstudiante(ID).equals(null)){
			if(!colegio.eliminarEstudiante(ID)) {
		    	
				alerta = new Alert(AlertType.ERROR);
		     	alerta.setTitle("");
				alerta.setContentText("El estudiante ha sido eliminado correctamente");
				alerta.setHeaderText("INFORMACIÓN");
				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
				Text_Area_Mostrar.setText("");
				
		    	 
		    }
		  
		 

			}catch (NullPointerException e) {
				alerta = new Alert(AlertType.ERROR);

		     	alerta.setTitle("");
				alerta.setContentText("El estudiante que desea eliminar no es valido");
				alerta.setHeaderText("INFORMACION");

				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
				
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un susario valido");
			// L_BuscarAS.setVisible(true);
		}
	}

 
    }

	public void setStage(Stage stage) {
		this.stage = stage;
		
	}


	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	

}
