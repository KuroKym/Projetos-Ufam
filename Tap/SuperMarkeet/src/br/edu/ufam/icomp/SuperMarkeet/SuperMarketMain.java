package br.edu.ufam.icomp.SuperMarkeet;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class SuperMarketMain extends Application {
    @Override
    public void start(Stage primaryStage) {
  		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("layout/menu.fxml"));
			Scene scene = new Scene(root);
			Image icon = new Image(getClass().getResourceAsStream("layout/SuperMartIcon.jpeg"));
			primaryStage.getIcons().add(icon);

  			primaryStage.setTitle("Vendas");
        	primaryStage.setScene(scene);
        	primaryStage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
  		
    }
 
 public static void main(String[] args) {
		VendaDAO venda = new VendaDAO();
		ProdutoDAO produto = new ProdutoDAO();
		venda.resetarDAO();
		produto.resetarDAO();
        launch(args);
    }
}