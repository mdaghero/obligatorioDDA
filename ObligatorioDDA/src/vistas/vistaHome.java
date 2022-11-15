/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author Marcelo
 */
public class vistaHome extends javax.swing.JFrame {

    /**
     * Creates new form iHome
     */
    public vistaHome() {
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

        bAppTrabajadores = new javax.swing.JButton();
        bSimulador = new javax.swing.JButton();
        bMonitoreo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(600, 350));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bAppTrabajadores.setText("Aplicación Trabajadores");
        bAppTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bAppTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAppTrabajadoresActionPerformed(evt);
            }
        });

        bSimulador.setText("Simulador Llamadas");
        bSimulador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimuladorActionPerformed(evt);
            }
        });

        bMonitoreo.setText("Aplicación Monitoreo");
        bMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMonitoreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bMonitoreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSimulador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAppTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(bAppTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSimulador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMonitoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAppTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAppTrabajadoresActionPerformed
        
        new vistaLogin(this,false, "Login").setVisible(true);
        
    }//GEN-LAST:event_bAppTrabajadoresActionPerformed

    private void bSimuladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimuladorActionPerformed
        
        new vistaSimulador(this, false, "Simulador de llamadas").setVisible(true);
    }//GEN-LAST:event_bSimuladorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void bMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMonitoreoActionPerformed
        new vistaMonitoreo(this, false).setVisible(true);
    }//GEN-LAST:event_bMonitoreoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAppTrabajadores;
    private javax.swing.JButton bMonitoreo;
    private javax.swing.JButton bSimulador;
    // End of variables declaration//GEN-END:variables
}
