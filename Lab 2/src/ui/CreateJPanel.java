/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import model.VitalSignHistory;
import model.VitalSigns;

/**
 *
 * @author rohanjauhari
 */
public class CreateJPanel extends javax.swing.JPanel {
    VitalSignHistory vitalSignHistory;
    /**
     * Creates new form CreateJPanel
     */
    public CreateJPanel(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTemperature = new javax.swing.JLabel();
        labelBloodPressure = new javax.swing.JLabel();
        labelPulse = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();
        txtTemperature = new javax.swing.JTextField();
        txtBloodPressure = new javax.swing.JTextField();
        txtPulse = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(757, 518));

        labelTemperature.setText("Temperature:");

        labelBloodPressure.setText("Blood Pressure:");

        labelPulse.setText("Pulse:");

        labelDate.setText("Date:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Create Vital Signs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPulse)
                            .addComponent(labelDate)
                            .addComponent(labelBloodPressure)
                            .addComponent(labelTemperature))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBloodPressure)
                            .addComponent(txtTemperature)
                            .addComponent(txtPulse)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btnSave)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelTitle)
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTemperature)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBloodPressure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPulse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDate))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Double temperature = Double.parseDouble(txtTemperature.getText());
        Double bloodPressure = Double.parseDouble(txtBloodPressure.getText());
        int pulse = Integer.parseInt(txtPulse.getText());
        String date = txtDate.getText();
        
        VitalSigns newVs = vitalSignHistory.addNewVitals();
        newVs.setTemperature(temperature);
        newVs.setBloodPressure(bloodPressure);
        newVs.setPulse(pulse);
        newVs.setDate(date);
        
        //Show user a confirmation Dialog
        JOptionPane.showMessageDialog(this, "New Vital signs created.", "Success",JOptionPane.INFORMATION_MESSAGE);
        txtTemperature.setText("");
        txtBloodPressure.setText("");
        txtPulse.setText("");
        txtDate.setText ("");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel labelBloodPressure;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelPulse;
    private javax.swing.JLabel labelTemperature;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtPulse;
    private javax.swing.JTextField txtTemperature;
    // End of variables declaration//GEN-END:variables
}
