/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package son.GUI;

import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import son.Main.WriteFile;

/**
 *
 * @author jampho
 */
public class MTE extends javax.swing.JFrame {

    String temp;
    String findStr;
    boolean findDown;
    boolean isNewFile;
    String filePath;
    String textoriginal;
    private UndoManager um;
    
    public MTE() {
        initComponents();
        um = new UndoManager();
        Document doc = this.text.getDocument();
        doc.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
    }
    public void setNotePad(){
        this.setTitle("My Text Editor");
        temp = text.getText();
        findDown = true;
        findStr = "";
        isNewFile = true;
        textoriginal = "";
        filePath = "";
    }

    public String getFindStr() {
        return findStr;
    }

    public void setFindStr(String findStr) {
        this.findStr = findStr;
    }

    public void setFindDown(boolean findDown) {
        this.findDown = findDown;
    }

    public JTextArea getText() {
        return text;
    }

    
    
   
    
    public void ReplaceAll(String content){
        String t = text.getText();
        t = t.replaceAll(findStr, content);
        text.setText(t);
    }
    
    public void ReplaceText(String content){
        if(text.getSelectedText() != null){
            text.replaceSelection(content);
        }
        String t = text.getText();
        int posStart = text.getCaretPosition();
        int pos = t.indexOf(findStr, posStart);
        if(pos == -1){
            posStart = 0;
            pos = t.indexOf(findStr, posStart);
            if(pos == -1){
                JOptionPane.showMessageDialog(this, "Not found!");
                return;
            }
        }
        text.select(pos, pos + findStr.length());
    }
    
    public void FindText(){
        String t = text.getText();
        int posStart = text.getCaretPosition();
        int pos;
        if(findDown){
            pos = t.indexOf(findStr, posStart);
            if(pos == -1){
                JOptionPane.showMessageDialog(this, "Not found!");
                text.setCaretPosition(posStart);
            }else{
                text.select(posStart, pos + findStr.length());
            }
        }else {
            if(text.getSelectedText() != null){
                posStart -= text.getSelectedText().length();
            }
            t = t.substring(0, posStart);
            pos = t.lastIndexOf(findStr);
            if(pos == -1){
                JOptionPane.showMessageDialog(this, "Not found!");
                text.setCaretPosition(posStart);
            }else {
               text.select(pos, pos + findStr.length());
            }
        }
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        mbMenuItem = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSave = new javax.swing.JMenuItem();
        miSaveAs = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        miSelectAll = new javax.swing.JMenuItem();
        miCut = new javax.swing.JMenuItem();
        miCoppy = new javax.swing.JMenuItem();
        miPaste = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miUndo = new javax.swing.JMenuItem();
        miRedo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miFind = new javax.swing.JMenuItem();
        miReplace = new javax.swing.JMenuItem();
        miFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        mnFile.setText("File");

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNew.setText("New");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        mnFile.add(miNew);

        miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miOpen.setText("Open");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        mnFile.add(miOpen);
        mnFile.add(jSeparator1);

        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSave.setText("Save");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        mnFile.add(miSave);

        miSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miSaveAs.setText("Save as");
        miSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveAsActionPerformed(evt);
            }
        });
        mnFile.add(miSaveAs);

        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mnFile.add(miExit);

        mbMenuItem.add(mnFile);

        mnEdit.setText("Edit");

        miSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        miSelectAll.setText("Select all");
        miSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSelectAllActionPerformed(evt);
            }
        });
        mnEdit.add(miSelectAll);

        miCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        miCut.setText("Cut");
        miCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCutActionPerformed(evt);
            }
        });
        mnEdit.add(miCut);

        miCoppy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        miCoppy.setText("Coppy");
        miCoppy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCoppyActionPerformed(evt);
            }
        });
        mnEdit.add(miCoppy);

        miPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        miPaste.setText("Paste");
        miPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPasteActionPerformed(evt);
            }
        });
        mnEdit.add(miPaste);
        mnEdit.add(jSeparator2);

        miUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        miUndo.setText("Undo ");
        miUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUndoActionPerformed(evt);
            }
        });
        mnEdit.add(miUndo);

        miRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        miRedo.setText("Redo");
        miRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRedoActionPerformed(evt);
            }
        });
        mnEdit.add(miRedo);
        mnEdit.add(jSeparator3);

        miFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        miFind.setText("Find");
        miFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFindActionPerformed(evt);
            }
        });
        mnEdit.add(miFind);

        miReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        miReplace.setText("Replace");
        miReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReplaceActionPerformed(evt);
            }
        });
        mnEdit.add(miReplace);

        miFont.setText("Font");
        miFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFontActionPerformed(evt);
            }
        });
        mnEdit.add(miFont);

        mbMenuItem.add(mnEdit);

        setJMenuBar(mbMenuItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewActionPerformed
        isNewFile = true;
        text.setText("");
    }//GEN-LAST:event_miNewActionPerformed

    private void miOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenActionPerformed
        JFileChooser open = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "trf", "text");
        open.setFileFilter(filter);
        int option = open.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            this.text.setText("");
            try {
                Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                while(scan.hasNext()){
                    this.text.append(scan.nextLine() + "\n");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Can't Open File", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miOpenActionPerformed

    private void miRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRedoActionPerformed
        if (um.canRedo()){
            try {
                um.redo();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_miRedoActionPerformed

    private void miSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveActionPerformed
        if(!textoriginal.equals(text.getText())){
            if(!isNewFile){
                try {
                    textoriginal = text.getText();
                    WriteFile wf = new WriteFile(filePath, textoriginal);
                    wf.Write();
                } catch (Exception e) {
                }
            }else{
                JFileChooser save = new JFileChooser();
                FileNameExtensionFilter ff = new FileNameExtensionFilter("Text File", "txt");
                save.setFileFilter(ff);
                int option = save.showSaveDialog(this);
                if(option == JFileChooser.APPROVE_OPTION){
                    try {
                        textoriginal = text.getText();
                        filePath = save.getSelectedFile().getPath()+".txt";
                        WriteFile wf = new WriteFile(filePath, textoriginal);
                        wf.Write();
                        isNewFile = true;
                        setTitle(save.getSelectedFile().getName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_miSaveActionPerformed

    private void miSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveAsActionPerformed
            JFileChooser save = new JFileChooser();
                FileNameExtensionFilter ff = new FileNameExtensionFilter("Text File", "txt");
                save.setFileFilter(ff);
                int option = save.showSaveDialog(this);
                if(option == JFileChooser.APPROVE_OPTION){
                    try {
                        textoriginal = text.getText();
                        filePath = save.getSelectedFile().getPath()+".txt";
                        WriteFile wf = new WriteFile(filePath, textoriginal);
                        wf.Write();
                        isNewFile = true;
                        setTitle(save.getSelectedFile().getName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
    }//GEN-LAST:event_miSaveAsActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSelectAllActionPerformed
        text.selectAll();
    }//GEN-LAST:event_miSelectAllActionPerformed

    private void miCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCutActionPerformed
        text.cut();
    }//GEN-LAST:event_miCutActionPerformed

    private void miCoppyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCoppyActionPerformed
        text.copy();
    }//GEN-LAST:event_miCoppyActionPerformed

    private void miPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPasteActionPerformed
        text.paste();
    }//GEN-LAST:event_miPasteActionPerformed

    private void miUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUndoActionPerformed
        if(um.canUndo()){
            try {
                um.undo();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_miUndoActionPerformed

    private void miFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFindActionPerformed
        FindDialog f = new FindDialog(this, true);
        f.setLocationRelativeTo(f);
        f.setVisible(true);
    }//GEN-LAST:event_miFindActionPerformed

    private void miReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReplaceActionPerformed
        ReplaceDialog r = new ReplaceDialog(this, true);
        r.setLocationRelativeTo(r);
        r.setVisible(true);
    }//GEN-LAST:event_miReplaceActionPerformed

    private void miFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFontActionPerformed
        FontDialog f = new FontDialog(this, true);
        f.setLocationRelativeTo(f);
        f.setVisible(true);
    }//GEN-LAST:event_miFontActionPerformed

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
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MTE m = new MTE();
                m.setLocationRelativeTo(m);
                m.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar mbMenuItem;
    private javax.swing.JMenuItem miCoppy;
    private javax.swing.JMenuItem miCut;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miFind;
    private javax.swing.JMenuItem miFont;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JMenuItem miOpen;
    private javax.swing.JMenuItem miPaste;
    private javax.swing.JMenuItem miRedo;
    private javax.swing.JMenuItem miReplace;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JMenuItem miSaveAs;
    private javax.swing.JMenuItem miSelectAll;
    private javax.swing.JMenuItem miUndo;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
