package co.uniquindio.View;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorRegistroEstudiante {



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
  

	Colegio colegio = new Colegio("Institucion educativa C.A.S.D ", 2);
	Estudiante estudiante;
	Alert alerta;
	UIManager ui ;
	public Stage stage;



	@FXML
	void On_evento_Menu(ActionEvent event) throws IOException, NohayCupoEstudiante {

		Parent root = null;
		if (event.getSource() == BotonM_NuevoEs) {

			try {
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ruta_Pantalla_Estudiante));
				root = loader.load();
				ControladorRegistroEstudiante control = loader.getController();
			
				control.setStage(stage);
				Scene scene = new Scene(root);

				stage.setScene(scene);

			} catch (NullPointerException e) {
			
				alerta = new Alert(AlertType.ERROR);
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

			if (!Text_Id.getText().isEmpty() && !Text_nombre.getText().isEmpty() && !Text_Email.getText().isEmpty()) {

				Estudiante estudiante = new Estudiante(Text_Id.getText(), Text_nombre.getText(), Text_Apellido.getText(), Text_Email.getText());
				colegio.adicionarEstudiante(estudiante);

				UIManager.put("Panel.background",new ColorUIResource(14,0,0));
				JOptionPane.showMessageDialog(null,
						" El estudiante ha sido guardado correctamente con los siguientes datos : "
								+ estudiante.toString());
				Text_Id.setText("");
				Text_nombre.setText("");
				Text_Apellido.setText("");
				Text_Email.setText("");

				L_IdentificacionAS.setVisible(false);
				L_EmailAS.setVisible(false);
				L_NombreAS.setVisible(false);
				L_ApellidoAs.setVisible(false);
				// setIConoColegio();
			

			} else {
				
				alerta = new Alert(AlertType.ERROR);
				
				alerta.setTitle("ERROR");
				alerta.setContentText("Llene todos los campos");
				alerta.setHeaderText("");
				alerta.initStyle(StageStyle.UTILITY);
				alerta.showAndWait();
				
				L_IdentificacionAS.setVisible(true);
				L_EmailAS.setVisible(true);
				L_NombreAS.setVisible(true);
				L_ApellidoAs.setVisible(true);
				// setIConoColegio();
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

 			
 				
  				
   		}
		
		

	}

	@FXML
    void on_click(MouseEvent event) throws NohayCupoEstudiante {
    	
    	if (event.getSource() == boton_guardar) {
    	
    	  if (!Text_Id.getText().isEmpty() && !Text_nombre.getText().isEmpty() && !Text_Email.getText().isEmpty()) {
    		  
    		 if (VerificarIdentificacion(Text_Id.getText()) && VerificarNombre(Text_nombre.getText())&& VerificarApellido(Text_Apellido.getText())&&
    				 VerificarCorreo(Text_Email.getText())) {
    			 
    		

			 estudiante = new Estudiante(Text_Id.getText(), Text_nombre.getText(),Text_Apellido.getText(), Text_Email.getText());
			 try {
			
				 colegio.adicionarEstudiante(estudiante);
					JOptionPane.showMessageDialog(null,
							" El estudiante ha sido guardado correctamente con los siguientes datos : "
										+ estudiante.toString());
				 
			 }catch (NohayCupoEstudiante e) {
				  alerta = new Alert(AlertType.ERROR);

					alerta.setTitle("INFORMACIÓN");
					alerta.setContentText("Noy hay mas cupos");
					alerta.setHeaderText("");
					alerta.initStyle(StageStyle.UTILITY);
					alerta.showAndWait();
					
			}
		
			
			
			Text_Id.setText("");
			Text_nombre.setText("");
			Text_Apellido.setText("");
			Text_Email.setText("");

			L_IdentificacionAS.setVisible(false);
			L_EmailAS.setVisible(false);
			L_NombreAS.setVisible(false);
			L_ApellidoAs.setVisible(false);
			//setIConoColegio();
    		 }else {
    				JOptionPane.showMessageDialog(null, "Hay campos no validos");
    				L_IdentificacionAS.setVisible(true);
    				L_EmailAS.setVisible(true);
    				L_NombreAS.setVisible(true);
    				L_ApellidoAs.setVisible(true);
    				//setIConoColegio();
    		 }
		} else {
			JOptionPane.showMessageDialog(null, "LLene todos los campos");
			L_IdentificacionAS.setVisible(true);
			L_EmailAS.setVisible(true);
			L_NombreAS.setVisible(true);
			L_ApellidoAs.setVisible(true);
			//setIConoColegio();
		}
    	 
    	  
    	
    	}else if(event.getSource() == Boton_buscar) {
    		
    		
    		if (!Text_ID_Buscar.getText().isEmpty()) {
    			
    			try {
    			
				System.out.println("Estoy aca");

				String ID = Text_ID_Buscar.getText();

			    estudiante = colegio.buscarEstudiante(ID);
				System.out.println(estudiante.toString());
			    Text_Area_Mostrar.setText(estudiante.toString());
				// L_BuscarAS.setVisible(false);
				Text_ID_Buscar.setText("");
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
    	}

    }

	public boolean VerificarIdentificacion(String ID) {
		
		char arreglo []=ID.toCharArray();
		for (int i = 0; i < arreglo.length; i++) {
			try {
				Integer.parseInt(arreglo[i]+"");
			} catch (NumberFormatException e) {
				
				return false;
				
			}
			
		}
		
		
		return true;
	}
	
	

	public boolean VerificarNombre(String nombre) {
		
		char arreglo []=nombre.toCharArray();
		for (int i = 0; i < arreglo.length; i++) {
			try {
				Integer.parseInt(arreglo[i]+"");
				return false;
			} catch (NumberFormatException e) {
				
				
				
			}
			
		}
		
		
		return true;
	}

	

	public boolean VerificarApellido(String apellido) {
		
		char arreglo []=apellido.toCharArray();
		for (int i = 0; i < arreglo.length; i++) {
			try {
				Integer.parseInt(arreglo[i]+"");
				return false;
			} catch (NumberFormatException e) {
				
				
				
			}
			
		}
		
		
		return true;
	}

	public boolean VerificarCorreo(String correo) {


		// Patrón para validar el email
		Pattern patron = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
		Matcher mather = patron.matcher(correo);

		if (mather.find() == true) {
			
			return true;
			//System.out.println("El email ingresado es válido.");
		} else {
			return false;
			//System.out.println("El email ingresado es inválido.");
		}
		
	}
	
	
	
	public void setStage(Stage stage) {
		this.stage = stage;

	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
		
	}

	

}
