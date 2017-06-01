package view;

import java.util.List;

import controller.BuyerController;
import model.Cart;
import model.Product;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class BuyerView extends javax.swing.JFrame implements IDoctorView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private LoginView loginView;
	private BuyerController doctorController;
	private int id;
	
	public BuyerView(LoginView login)
	{
		loginView = login;
		initComponents();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(255, 192, 203));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        errorDoctor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("List of products");

        errorDoctor.setText(" ");
        jList1 = new javax.swing.JList();
        jList1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
        jList1.setBackground(new Color(255, 240, 245));
        
                jList1.setModel(new javax.swing.AbstractListModel() {
                    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                    public int getSize() { return strings.length; }
                    public Object getElementAt(int i) { return strings[i]; }
                });
                jList1.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jList1MouseClicked(evt);
                    }
                });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(612)
        					.addComponent(errorDoctor)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel4))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(117)
        					.addComponent(jLabel1))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(106)
        					.addComponent(jList1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(321)
        					.addComponent(errorDoctor)
        					.addGap(45)
        					.addComponent(jLabel4)
        					.addGap(0, 9, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(47)
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(jList1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGap(15))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        
    
    private void jList1MouseClicked(java.awt.event.MouseEvent evt){
    	// TODO add your handling code here:
    	errorDoctor.setText("");
    	//doctorController.FindConsultation(jList1.getSelectedValue().toString());
    }
    private javax.swing.JLabel errorDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    @SuppressWarnings("rawtypes")
	private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration  
	
	@Override
	public void SetController(BuyerController controller, int id) {
		// TODO Auto-generated method stub
		doctorController = controller;
		this.id = id;
	}

	/*@Override
	public void SetCartsInGrid(List<Cart> consults) {
		// TODO Auto-generated method stub
		String[][] obj = new String[consults.size()][2];
    	for(int i=0;i<consults.size();i++){
    			obj[i][0]=""+consults.get(i).getId();
    			obj[i][1]=consults.get(i).getId_product();
    		
    	}
    	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                new String [] {
                		"Id", "Id Product"
                    }
            ));
	}*/

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	@Override
	public void SetProductsInList(List<Product> patients) {
		// TODO Auto-generated method stub
		String[] item = new String[patients.size()];
		for(int i=0;i<patients.size();i++){
			item[i]=patients.get(i).getName();
		}
    	jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return item.length; }
            public Object getElementAt(int i) { return item[i]; }
        });
	}

	//@Override
	//public void EditCart(String errorMsg) {
		// TODO Auto-generated method stub
	//	errorDoctor.setText(errorMsg);
	//}

	//@Override
	/*public void FindCarts(String errorMsg) {
		// TODO Auto-generated method stub
		errorDoctor.setText(errorMsg);
	}*/

	@Override
	public int GetSelectedProductFromList() {
		// TODO Auto-generated method stub
		if(jList1.getSelectedIndex() >= 0)
			return jList1.getSelectedIndex();
		else
			errorDoctor.setText("Select a product from list!");
		return -1;
	}

	/*@Override
	public Cart GetSelectedCartFromGrid() {
		// TODO Auto-generated method stub
		if (jTable1.getSelectedRowCount() > 0)
        {
        	int row = jTable1.getSelectedRow();
        	Cart consult = new Cart();
        	consult.setId(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
        	consult.setId_product(jTable1.getValueAt(row, 1).toString());
        	consult.setId_buyer(jTable1.getValueAt(row, 2).toString());
            return consult;
        }
        else
        	errorDoctor.setText("Select a row from table!");
		return null;
	}*/

	
}
