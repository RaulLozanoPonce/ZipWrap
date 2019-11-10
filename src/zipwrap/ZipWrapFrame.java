package zipwrap;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

public class ZipWrapFrame extends javax.swing.JFrame {
    
    private JFileChooser fileChooser;
    private String inputPath;
    private String outputPath;
    private Worker1 worker;
    
    public ZipWrapFrame() {
        worker = new Worker1();
        initComponents();
        setApp();
        setFileFilter();
        setMnemonic();
        inputPath = "";
        outputPath = "";
        setPathLabels();
        setButtonState();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        inputPathButton = new javax.swing.JButton();
        inputPathLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        compressButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        outputPathButton = new javax.swing.JButton();
        outputPathLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        appMenu = new javax.swing.JMenu();
        resetMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        inputPathButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputPathButton.setText("Seleccionar Directorio");
        inputPathButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputPathButton.setPreferredSize(new java.awt.Dimension(150, 25));
        inputPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPathButtonActionPerformed(evt);
            }
        });

        inputPathLabel.setText(" ");
        inputPathLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inputPathLabel.setMaximumSize(new java.awt.Dimension(50, 25));
        inputPathLabel.setMinimumSize(new java.awt.Dimension(50, 25));
        inputPathLabel.setPreferredSize(new java.awt.Dimension(50, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inputPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(inputPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(inputPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        compressButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        compressButton.setText("Comprimir");
        compressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(compressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputPathButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        outputPathButton.setText("Seleccionar Destino");
        outputPathButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outputPathButton.setMaximumSize(new java.awt.Dimension(150, 25));
        outputPathButton.setMinimumSize(new java.awt.Dimension(150, 25));
        outputPathButton.setPreferredSize(new java.awt.Dimension(150, 25));
        outputPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputPathButtonActionPerformed(evt);
            }
        });

        outputPathLabel.setText(" ");
        outputPathLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(outputPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(outputPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(outputPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        appMenu.setText("Aplicación");

        resetMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        resetMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/reset.png"))); // NOI18N
        resetMenuItem.setText("Resetear");
        resetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMenuItemActionPerformed(evt);
            }
        });
        appMenu.add(resetMenuItem);
        appMenu.add(jSeparator2);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Exit.png"))); // NOI18N
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        appMenu.add(exitMenuItem);

        menuBar.add(appMenu);

        helpMenu.setText("Ayuda");

        infoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        infoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Help_App.png"))); // NOI18N
        infoMenuItem.setText("Ayuda");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(infoMenuItem);
        helpMenu.add(jSeparator1);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Info_App.png"))); // NOI18N
        aboutMenuItem.setText("Acerca De");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPathButtonActionPerformed
        setPath("input");
        setPathLabels();
        setButtonState();
    }//GEN-LAST:event_inputPathButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        worker.stopThread();
        setButtonState();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void outputPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputPathButtonActionPerformed
        setPath("output");
        setPathLabels();
        setButtonState();
    }//GEN-LAST:event_outputPathButtonActionPerformed

    private void compressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressButtonActionPerformed
        worker = new Worker1();
        worker.execute();
        setButtonState();
    }//GEN-LAST:event_compressButtonActionPerformed

    private void resetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMenuItemActionPerformed
        inputPath = "";
        outputPath = "";
        setPathLabels();
        setButtonState();
    }//GEN-LAST:event_resetMenuItemActionPerformed

    private void infoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuItemActionPerformed
        String url_open ="https://support.microsoft.com/es-es/help/14200/windows-compress-uncompress-zip-filesS";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "La página web no ha sido cargada.", 
                    "Página web no cargada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_infoMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Diseñado por:\n ➡ Raúl Lozano Ponce\n ➡ Pablo Perdomo Falcón", "Acerca De ZipWrap", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void setApp(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setMinimumSize(getPreferredSize());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photos/Logo.png")));
        setTitle("ZipWrap");
    }
    
    private void setFileFilter() {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
    
    private void setMnemonic() {
        appMenu.setMnemonic('A');
        helpMenu.setMnemonic('U');
        resetMenuItem.setMnemonic('R');
        exitMenuItem.setMnemonic('S');
        infoMenuItem.setMnemonic('I');
        aboutMenuItem.setMnemonic('A');
    }
    
    private boolean closeWindow(){
        return JOptionPane.showConfirmDialog(null,
                "¿Desea salir de ZipWrap?", "Salir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    private void setPathLabels(){
        inputPathLabel.setText(inputPath);
        outputPathLabel.setText(outputPath);
    }
    
    private void setButtonState(){
        resetMenuItem.setEnabled(!worker.running);
        inputPathButton.setEnabled(!worker.running);
        outputPathButton.setEnabled(!worker.running);
        if(!"".equals(inputPath) && !"".equals(outputPath) && isValidPath(inputPath, outputPath) && !worker.running){
            compressButton.setEnabled(true);
        }else{
            compressButton.setEnabled(false);
        }
        cancelButton.setEnabled(worker.running);
    }
    
    private void setPath(String whichPath){
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            if("input".equals(whichPath)){
                inputPath = fileChooser.getSelectedFile().getAbsolutePath();
            }else{
                outputPath = fileChooser.getSelectedFile().getAbsolutePath();
            }
            if(inputPath.equals(outputPath)){
                JOptionPane.showMessageDialog(null, 
                        "El directorio a comprimir no debe coincidir con el destino.",
                        "Directorios incompatibles", JOptionPane.ERROR_MESSAGE);
            }else if(!isValidPath(inputPath, outputPath)){
                JOptionPane.showMessageDialog(null, 
                        "El directorio destino no puede estar contenido en el directorio a comprimir.",
                        "Directorios incompatibles", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean isValidPath(String input, String output){
        String newInput = input + '\\';
        String newOutput = output + '\\';
        for (int i = 0; i < Math.min(newInput.length(), newOutput.length()); i++) {
            if(newInput.charAt(i) != newOutput.charAt(i)){
                return true;
            }
        }
        return newInput.length() > newOutput.length();
    }
    
    private boolean checkIfFileExists(String path){
        if(new File(path).exists()){
            return JOptionPane.showConfirmDialog(null, 
                    "Ya existe un archivo con el nombre especificado. ¿Desea sobreescribirlo?", 
                    "Nombre existente", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION;
        }else{
            return false;
        }
    }
    
    private List<File> getAllFiles(File folder){
        List<File> files = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if(file.isDirectory()){
                files.addAll(getAllFiles(file));
            }else{
                files.add(file);
            }
        }
        return files;
    }
    
    private long getFolderLength(List<File> files){
        long size = 0;
        for (File file : files) {
            size += file.length();
        }
        return size;
    }
    
    private String getRelativePath(String absolutePath, String rootPath){
        if(absolutePath.length() <= rootPath.length()){
            return "";
        }
        for (int i = 0; i < rootPath.length(); i++) {
            if(absolutePath.charAt(i) != rootPath.charAt(i)){
                return "";
            }
        }
        return absolutePath.substring(rootPath.length() + 1);
    }
    
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        new ZipWrapFrame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu appMenu;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton compressButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JButton inputPathButton;
    private javax.swing.JLabel inputPathLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton outputPathButton;
    private javax.swing.JLabel outputPathLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem resetMenuItem;
    // End of variables declaration//GEN-END:variables

    class Worker1 extends SwingWorker<Boolean, Integer> {
        
        private boolean running;
        private FileOutputStream dest;
        private String zipPath;
        
        @Override
        protected Boolean doInBackground() throws Exception {
            running = true;
            File inputFolder = new File(inputPath);
            zipPath = outputPath + File.separator + inputFolder.getName() + ".zip";
            if(!checkIfFileExists(zipPath)){
                setButtonState();
                List<File> files = getAllFiles(inputFolder);
                int size = (int) getFolderLength(files);
                float currentSize = 0;
                byte[] data = new byte[size];
                BufferedInputStream origin = null;
                dest = new FileOutputStream(zipPath);
                try {
                    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
                    for (File file : files) {
                        FileInputStream fi = new FileInputStream(file.getAbsolutePath());
                        origin = new BufferedInputStream(fi, size);
                        ZipEntry entry = new ZipEntry(getRelativePath(file.getAbsolutePath(), inputPath));
                        out.putNextEntry(entry);
                        int count;
                        while((count = origin.read(data, 0, size)) != -1){
                            out.write(data, 0, count);
                            currentSize += count;
                            publish((int) (100*currentSize/size));
                            if(!running) return false;
                        }
                        origin.close();
                    }
                    out.close();
                    JOptionPane.showMessageDialog(null, 
                            "La compresión de la carpeta ha sido completada con éxito.", 
                            "Compresión completada", JOptionPane.PLAIN_MESSAGE);
                    return true;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, 
                            "Se ha producido un error en la compresión de la carpeta.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            return false;
        }

        @Override
        protected void done() {
            running = false;
            setButtonState();
            progressBar.setValue(0);
        }

        @Override
        protected void process(List<Integer> chunks) {
            progressBar.setValue(chunks.get(0));
        }
        
        public void stopThread() {
            running = false;
            setButtonState();
            progressBar.setValue(0);
            try {
                dest.close();
                new File(zipPath).delete();
            } catch (IOException ex) {}
	}
    }
}
