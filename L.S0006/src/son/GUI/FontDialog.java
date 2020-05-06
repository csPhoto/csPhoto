/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package son.GUI;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.DefaultListModel;

/**
 *
 * @author jampho
 */
public class FontDialog extends javax.swing.JDialog {

    /**
     * Creates new form FontDialog
     */
    public FontDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Font");
        AddListFont();
        AddListSize();
        setSampleText();
    }
    
    private void AddListFont() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontName[] = g.getAvailableFontFamilyNames();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < fontName.length; i++) {
            model.addElement(fontName[i]);
        }
        listFont.setModel(model);
    }

    private void AddListSize() {
        DefaultListModel model = new DefaultListModel();
        for (int i = 8; i < 49; i++) {
            model.addElement(i);
        }
        listSize.setModel(model);
    }
    
    private void setSampleText(){
        Font f = ((MTE) this.getParent()).getText().getFont();
        lbSample.setFont(f);
        tfFont.setText(f.getFontName());
        listFont.setSelectedValue(f.getFontName(), true);
        tfStyle.setText(listStyle.getSelectedValue().toString());
        listStyle.setSelectedIndex(f.getStyle());
        tfSize.setText(Integer.toString(f.getSize()));
        listSize.setSelectedValue(f.getSize(), true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbFont = new javax.swing.JLabel();
        lbStyle = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        tfFont = new javax.swing.JTextField();
        tfStyle = new javax.swing.JTextField();
        tfSize = new javax.swing.JTextField();
        pnlSample = new javax.swing.JPanel();
        lbSample = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        spFont = new javax.swing.JScrollPane();
        listFont = new javax.swing.JList<>();
        spStyle = new javax.swing.JScrollPane();
        listStyle = new javax.swing.JList<>();
        spSize = new javax.swing.JScrollPane();
        listSize = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbFont.setText("Font:");

        lbStyle.setText("Font Style:");

        lbSize.setText("Size:");

        tfStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStyleActionPerformed(evt);
            }
        });

        pnlSample.setBorder(javax.swing.BorderFactory.createTitledBorder("Sample"));

        lbSample.setText("AaBbCcDdXxYyZz");

        javax.swing.GroupLayout pnlSampleLayout = new javax.swing.GroupLayout(pnlSample);
        pnlSample.setLayout(pnlSampleLayout);
        pnlSampleLayout.setHorizontalGroup(
            pnlSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampleLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(lbSample)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        pnlSampleLayout.setVerticalGroup(
            pnlSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampleLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbSample)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        listFont.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFontValueChanged(evt);
            }
        });
        spFont.setViewportView(listFont);

        listStyle.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Normal", "Bold", "Italic", "Bold Italic" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listStyle.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listStyleValueChanged(evt);
            }
        });
        spStyle.setViewportView(listStyle);

        listSize.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSizeValueChanged(evt);
            }
        });
        spSize.setViewportView(listSize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfFont)
                            .addComponent(spFont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbFont)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfStyle)
                            .addComponent(lbStyle)
                            .addComponent(spStyle, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSize)
                                    .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(spSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFont)
                    .addComponent(lbStyle)
                    .addComponent(lbSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spFont, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(spStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(spSize))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStyleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStyleActionPerformed

    private void listFontValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFontValueChanged
        Font current = lbSample.getFont();
        String fontName = listFont.getSelectedValue().toString();
        int fontStyle = current.getStyle();
        int fontSize = current.getSize();
        tfFont.setText(fontName);
        Font f = new Font(fontName, fontStyle, fontSize);
        lbSample.setFont(f);
    }//GEN-LAST:event_listFontValueChanged

    private void listStyleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listStyleValueChanged
        Font curren = lbSample.getFont();
        String fontName = curren.getFontName();
        int fontStyle = curren.getStyle();
        int fontSize = curren.getSize();
        tfStyle.setText(listStyle.getSelectedValue().toString());
        Font f = new Font(fontName, fontStyle, fontSize);
        lbSample.setFont(f);
    }//GEN-LAST:event_listStyleValueChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ((MTE) this.getParent()).getText().setFont(lbSample.getFont());
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void listSizeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSizeValueChanged
        Font curren = lbSample.getFont();
        String fontName = curren.getFontName();
        int fontStyle = curren.getStyle();
        int fontSize = Integer.parseInt(listSize.getSelectedValue());
        tfSize.setText(listSize.getSelectedValue().toString());
        Font f = new Font(fontName, fontStyle, fontSize);
        lbSample.setFont(f);
    }//GEN-LAST:event_listSizeValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FontDialog dialog = new FontDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lbFont;
    private javax.swing.JLabel lbSample;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbStyle;
    private javax.swing.JList<String> listFont;
    private javax.swing.JList<String> listSize;
    private javax.swing.JList<String> listStyle;
    private javax.swing.JPanel pnlSample;
    private javax.swing.JScrollPane spFont;
    private javax.swing.JScrollPane spSize;
    private javax.swing.JScrollPane spStyle;
    private javax.swing.JTextField tfFont;
    private javax.swing.JTextField tfSize;
    private javax.swing.JTextField tfStyle;
    // End of variables declaration//GEN-END:variables


}