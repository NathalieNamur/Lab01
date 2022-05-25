package it.polito.tdp.parole;

import java.util.List;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {

	Parole elenco; 
	
	@FXML
    private TextField txtParola;
	
	@FXML
	 private Button btnInserisci;
	
	@FXML
    private TextArea txtResult;
	
	@FXML
	private TextArea txtPerformance;
	
	@FXML
	private Button btnReset;
	
    @FXML
    private Button btnCancella;

    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	//1.ACQUISIZIONE E CONTROLLO DATI:
    	String parola = txtParola.getText();
    	
    	if(parola.equals("")) {
    		txtResult.setText("ERRORE: inserire una parola");
    		return;
    	}
    	
    	//2.ESECUZIONE DELL'OPERAZIONE (MODEL): 
    	double start = System.nanoTime();
    	elenco.addParola(parola);
    	double stop = System.nanoTime();
    	
    	//3.VISUALIZZAZIONE/AGGIORNAMENTO DEL RISULTATO:
    	txtResult.clear();
    	
    	List<String> paroleInserite = elenco.getElenco();
    	for(String p : paroleInserite)
    		txtResult.appendText(p.toString()+"\n");
    	
    	txtPerformance.clear();
    	txtPerformance.setText("Operazione inserimento parola: " + (stop-start)/1e9 + " sec");
    	
    	txtParola.clear();

    }
    
    
    @FXML
    void doRest(ActionEvent event) {
    	
    	elenco.reset();
    	
    	txtResult.clear();
    	txtPerformance.clear();

    }
    
    
    @FXML
    void doCancella(ActionEvent event) {
    
    	String parolaSelezionata = txtResult.getSelectedText();
    	
    	if(parolaSelezionata.equals("")) {
    		txtResult.setText("ERRORE: selezionare una parola");
    		txtPerformance.clear();
    		return;
    	}
    	
    	
    	double start = System.nanoTime();
    	elenco.removeParola(parolaSelezionata);
    	double stop = System.nanoTime();
    	
    	
    	txtResult.clear();
    	
    	List<String> paroleRestanti = elenco.getElenco();
    	for(String p : paroleRestanti)
    		txtResult.appendText(p.toString()+"\n");
    	
    	txtPerformance.clear();
    	txtPerformance.setText("Operazione cancellazione parola: " + (stop-start)/1e9 + " sec");
    	
    	txtParola.clear();

    }

   
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }

}
