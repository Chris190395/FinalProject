package controller;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import model.Packet;
import model.Product;
import view.IDoctorView;

public class BuyerController {

	private IDoctorView doctorView;
    private int id_buyer, id_product;
    private ArrayList<Product> productsList;
    private Client client;

    public BuyerController(IDoctorView doctorView, int id)
    {
        id_buyer = id;
        id_product = 0;
        doctorView.SetController(this,id_buyer);
        client = new Client();
    }

    public void SetView(IDoctorView doctorView)
	{
		this.doctorView = doctorView;
		SetProducts();
	}

    @SuppressWarnings("unchecked")
	public void SetProducts()
    {
    	
        productsList = new ArrayList<Product>();
        Packet packet = new Packet("", "findAllProducts");
        try {
        	productsList = (ArrayList<Product>)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        doctorView.SetProductsInList(productsList);
    }
    
    


  
	/*public void EditCart(String recomandations)
    {
        Consultation consult = doctorView.GetSelectedConsultFromGrid();
        if (consult != null)
        {
        	consult.setRecomandation(recomandations);
        	Packet packet = new Packet(consult, "updateConsult");
            try {
            	client.connectWithServer(packet);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
            this.doctorView.EditConsult("Edit complete");
            List<Consultation> consultations = new ArrayList<Consultation>();
            String send = id_patient + "," + id_doctor;
            Packet packet2 = new Packet(send, "findConsult");
            try {
            	consultations = (ArrayList<Consultation>)client.connectWithServer(packet2);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
            doctorView.SetConsultationsInGrid(consultations);
        }
    }

*/
   /* @SuppressWarnings("unchecked")
	public void FindConsultation(String cnp)
    {
    	Patient patient = new Patient();
    	Packet packet = new Packet(cnp, "findPatient");
        try {
			patient = (Patient)client.connectWithServer(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
        List<Consultation> consultations = new ArrayList<Consultation>();
        
        if (patient.getCnp() != null)
        {
            id_patient = patient.getId();
            String send = id_patient + "," + id_doctor;
            Packet packet2 = new Packet(send, "findConsult");
            try {
            	consultations = (ArrayList<Consultation>)client.connectWithServer(packet2);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
            if (consultations.size() > 0)
            {
            	doctorView.SetConsultationsInGrid(consultations);
                doctorView.FindConsultations("Consultations found!");
            }
            else
            {
            	doctorView.SetConsultationsInGrid(consultations);
                doctorView.FindConsultations("No consulation found!");
            }

        }
        else
        {
        	doctorView.SetConsultationsInGrid(consultations);
            doctorView.FindConsultations("Patient not found!");
        }
    }*/
}
