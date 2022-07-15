/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import itextpdf.text.Anchor;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chapter;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Section;
//import com.itextpdf.text.pdf.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.*;
import java.io.*; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;



/**
 *
 * @author joseluis
 */
public class JTable2Pdf extends javax.swing.JFrame {
    // Table model variable (variable para el modelo de datos).
    private DefaultTableModel tableModelFiles;

    private String pathFilesImport;    
    private String fileExtension;
 
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,  Font.BOLD);
    private static final Font subCategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,  Font.BOLD);
    private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.fontfamily.TIMES_ROMAN, 12, Font.BOLD);
     


    /**
     * Creates new form JTable2Pdf
     */
    public JTable2Pdf() {
       initComponents();
        pathFilesImport = path;
        initJTable();
        // Load the files in the table (Cargamos los ficheros en la tabla).
        loadTableModelFiles(tableModelFiles,
                pathFilesImport, null,
                null, // extesionFile,
                pathFilesImport,
                System.out);
        setLocationCenter();
        setVisible(true);
        
    }
//  public static void main(String[] args) {
//    JTable2Pdf frame = new JTable2Pdf();
//    frame.pack();
//    frame.setVisible(true);
//    frame.print();
//  }
    
    
    
     private void initJTable() {
        jTextFieldRuta.setText(pathFilesImport);
        Object[] newObjectItems = initJTableFiles(jTableFicheros, jScrollPaneFicheros, tableModelFiles);
        tableModelFiles = (DefaultTableModel) newObjectItems[2];
        jTableFicheros = (JTable) newObjectItems[0];
        jScrollPaneFicheros = (JScrollPane) newObjectItems[1];
 
    }
 
    /**
     * We create a specific JTable with parameters passed to the method.
     * Creamos un JTable específico con los parámetros que se pasan en el método.
     * @param jTable <code>JTable</code> tabla del JFrame que volvemos a definir en esta clase.
     * @param jScrollPane <code>JScrollPane</code> pasamos de nuevo el JScrollPane para vincularlo de nuevo con el nuevo JTable.
     * @param tableModel <code>tableModel</code> modelo nuevo de tabla que definimos con los parámetros que pasamos.          
     * @return <code>Object[]</code> returns an array with the new values of jTable, jScrollPane and tableModel (devuelve una array con los nuevos valores
     * de jTable, jScrollPane y tableModel).
     */
    private Object[] initJTableFiles(JTable jTable, JScrollPane jScrollPane, DefaultTableModel tableModel) {
        Object[] object = null;
        // We define te (Definimos el modelo de la tabla).
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "NOMBRE", "EXTENSIÓN", "LEIBLE", "FECHA MODIFICACIÓN",
                    "TRASPASAR", "TAMAÑO", "NOMBRE COMPLETO"
                }
        ) {
            // Data types of the columns (Tipos de datos de las columnas).
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class,
                java.util.Date.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class,};
            // Editables columns (Columnas editables).
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, true, false, false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable = new JTable();
        jTable.setModel(tableModel);
        jScrollPane.setViewportView(jTable);
        // We define the width of the columns (Definimos el ancho de las columnas).
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(500);
        }
        // Columns auto sort (Ordenación automática de las columnas).
        jTable.setAutoCreateRowSorter(true);
        object = new Object[]{jTable, jScrollPane, tableModel};
        return object;
    }
 
    /**
     * Read the directory as directed by the parameters and load the table.
     * Leemos el directorio según las indicaciones de los parámetros y cargamos la tabla.
     * @param tableModel <code>tableModel</code> modelo nuevo de tabla que definimos con los parámetros que pasamos.     
     * @param filesPath <code>String</code> the path where we are going to read the files (La ruta de la que vamos a leer los ficheros).
     * @param filesDir <code>String</code> folder selected to read (carpeta seleccionada para leer).
     * @param extesionFile <code>String</code> filtering file extension (filtrado para extensión de archivos).
     * @param folder <code>String</code> path where we are going to read the files. Ruta donde vamos a leer los ficheros.
     * @param output <code>PrintStream</code> pass the PrintStream output (pasamos el PrintStream de salida). 
     * @return <code>boolean</code> we return true if the directory that we pass
     * for read exists. Devolvemos true si existe el directorio que se pasa para leer.
     */
    public boolean loadTableModelFiles(DefaultTableModel tableModel,
            String filesPath,  File filesDir,
            String extesionFile,
            String folder, PrintStream output) {
        boolean resultado;
        int row = 0;
        // Folder to read: folderFile (Fichero para leer).
        File folderFile = new File(folder);
        /*
            Then we read all the folder, the implementation 
            of filters extesionFile FilesDir and can be incorporated easily here.
            A continuación, leemos toda la carpeta, la implementación 
            de los filtros filesDir y extesionFile se puede incorporar aquí fácilmente.
         */
        if ((resultado = folderFile.exists())) {
            File[] files = folderFile.listFiles();
            for (File file : files) {
                boolean isFolder = file.isDirectory();
                if ((!isFolder)) {
                    output.println((isFolder ? "FOLDER: " : "  FILE: ") + file.getName());
                    double fileBytes = file.length();
                    double fileKiloBytes = (fileBytes / 1024);
                    double fileMegaBytes = (fileKiloBytes / 1024);
                    // Add rows to the TableModel (Añadimos filas al tableModel).
                    tableModel.insertRow(row++,
                            new Object[]{
                                file.getName(),                     // Name (Nombre)
                                getFileExtension(file.getName()),   // Extension (Extensión)                                
                                file.canRead(),                             // Readable (Leible)                 
                                new java.util.Date(file.lastModified()),    // Modify date (Fecha modificación)
                                false,                                      // Transfer (Traspasar)
                                fileKiloBytes + " KB",  // File Size (Tamaño del fichero)
                                file.getAbsolutePath()  // Absolute Path (Ruta del fichero completa)
                            });
                }
            }
        }
        return resultado;
    }
    /**
     * Returns the extension of a file that we pass as a parameter.
     * Devuelve la extensión de un archivo que se pasa como parámetro.
     * @param fileName <code>String</code> the file name (el nombre del fichero).
     * @return <code>String</code> the extension of the file name (la extensión del nombre del fichero).
     */
    public String getFileExtension(String fileName) {
        try {
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        } catch (Exception e) {
            fileExtension = "UNKNOW";
        }
        return fileExtension;
    }
    /**
     * Returns the path to load the files
     * Devuelve la ruta de la carga de ficheros.
     * @return <code>String</code> the path to load the files (la ruta the la carga de ficheros).
     */
    public String getPathFilesImport() {
        return pathFilesImport;
    }
    /**
     * Stores the path to load de files.
     * Almacena la ruta de la carga de ficheros.
     * @param pathFilesImport <code>String</code> the path to load the files (la ruta the la carga de ficheros).
     */
    public void setPathFilesImport(String pathFilesImport) {
        this.pathFilesImport = pathFilesImport;
    }
      
 
    /**
     * Explanation of the method by which we read the JTable we pass as
     * parameter, and where we copy its content in a PDF passed 
     * as a parameter.
     * Método con el que leemos cualquier JTable que pasamos como
     * parámetro, y donde copiamos su contenido en un PDF que se pasa 
     * como parámetro. 
     *
     * @param jTable <code>JTable</code> 
     *      the JTable we are going to extract to excel 
     *      El Jtable que vamos a extraer a excel.
     * @param pdfNewFile <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     * @param title <code>String</code> 
     *      title
     *      Título 
     */
    public void utilJTableToPdf(JTable jTable, File pdfNewFile, String title){    
        try {
            // We create the document and set the file name.        
            // Creamos el documento e indicamos el nombre del fichero.
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF (No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Código Xules");
            document.addCreator("Código Xules");
             
            // First page (Primera página)
            Anchor anchor = new Anchor("Table export to PDF (Exportamos la tabla a PDF)", categoryFont);
            anchor.setName("Table export to PDF (Exportamos la tabla a PDF)");
 
            // Second parameter is the number of the chapter (El segundo parámetro es el número del capítulo).
            Chapter catPart = new Chapter(new Paragraph(anchor), 1);
 
            Paragraph subPara = new Paragraph("Do it by Xules (Realizado por Xules)", subCategoryFont);
            Section subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("This is a simple example (Este es un ejemplo sencillo)"));
                         
            // Create the table (Creamos la tabla)
            PdfPTable table = new PdfPTable(jTable.getColumnCount()); 
              
            // Now we fill the rows of the PdfPTable (Ahora llenamos las filas de PdfPTable)
            PdfPCell columnHeader;
            // Fill table columns header 
            // Rellenamos las cabeceras de las columnas de la tabla.                
            for (int column = 0; column < jTable.getColumnCount(); column++) {                 
                columnHeader = new PdfPCell(new Phrase(jTable.getColumnName(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int row = 0; row < jTable.getRowCount(); row++) {                
                for (int column = 0; column < jTable.getColumnCount(); column++) { 
                    table.addCell(jTable.getValueAt(row, column).toString());
                }
            } 
            subCatPart.add(table);
             
            document.add(catPart);
             
            document.close();
            JOptionPane.showMessageDialog(this.jPanelFicheros, "Your PDF file has been generated!(¡Se ha generado tu hoja PDF!)",
                    "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
            JOptionPane.showMessageDialog(this.jPanelFicheros, "The file not exists (Se ha producido un error al generar un documento): " + documentException,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
                  
    }
    /**
     * Set the JFrame in the center of the screen. Colocamos nuestro JFrame en
     * el centro de la pantalla.
     */
    public void setLocationCenter() {
        setLocationMove(0, 0);
    }
 
    /**
     * Place the JFrame with the parameters by moving the component relative to
     * the center of the screen. Colocamos el JFrame con los parámetros
     * desplazando el componente respecto al centro de la pantalla.
     *
     * @param moveWidth int positive or negative offset width (desplazamiente de
     * width positivo o negativo).
     * @param moveHeight int Positive or negative offset height (desplazamiento
     * de height positivo o negativo).
     */
    public void setLocationMove(int moveWidth, int moveHeight) {
        // Obtenemos el tamaño de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtenemos el tamaño de nuestro frame.
        Dimension frameSize = this.getSize();
        frameSize.width = frameSize.width > screenSize.width ? screenSize.width : frameSize.width;
        frameSize.height = frameSize.height > screenSize.height ? screenSize.height : frameSize.height;
        // We define the location. Definimos la localización.
        setLocation((screenSize.width - frameSize.width) / 2 + moveWidth, (screenSize.height - frameSize.height) / 2 + moveHeight);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        jPanelFicheros = new javax.swing.JPanel();
        jLabelRuta = new javax.swing.JLabel();
        jTextFieldRuta = new javax.swing.JTextField();
        jScrollPaneFicheros = new javax.swing.JScrollPane();
        jTableFicheros = new javax.swing.JTable();
        jButtonViewPdf = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SELECCIÓN DE FICHEROS PARA PROCESAR");
 
        jPanelFicheros.setBorder(javax.swing.BorderFactory.createTitledBorder("Ficheros para procesar"));
 
        jLabelRuta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabelRuta.setText("Ruta seleccionada:");
 
        jTextFieldRuta.setEditable(false);
        jTextFieldRuta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jTextFieldRuta.setText("Se indicará la ruta utilizada");
        jTextFieldRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRutaActionPerformed(evt);
            }
        });
 
        jScrollPaneFicheros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPaneFicheros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
 
        jTableFicheros.setAutoCreateRowSorter(true);
        jTableFicheros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneFicheros.setViewportView(jTableFicheros);
 
        javax.swing.GroupLayout jPanelFicherosLayout = new javax.swing.GroupLayout(jPanelFicheros);
        jPanelFicheros.setLayout(jPanelFicherosLayout);
        jPanelFicherosLayout.setHorizontalGroup(
            jPanelFicherosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFicherosLayout.createSequentialGroup()
                .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanelFicherosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFicherosLayout.createSequentialGroup()
                    .addComponent(jScrollPaneFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
        );
        jPanelFicherosLayout.setVerticalGroup(
            jPanelFicherosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFicherosLayout.createSequentialGroup()
                .addGroup(jPanelFicherosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(341, 341, 341))
            .addGroup(jPanelFicherosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFicherosLayout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jScrollPaneFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
 
        jButtonViewPdf.setText("Generar PDF");
        jButtonViewPdf.setFocusable(false);
        jButtonViewPdf.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonViewPdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewPdfActionPerformed(evt);
            }
        });
 
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButtonViewPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(493, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonViewPdf))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
 
        pack();
    }// </editor-fold>                        
 
    private void jTextFieldRutaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              
    /**
     * Exit button.
     * Botón de salida.
     * @param evt button event (evento del botón).
     */
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        dispose();
    }                                            
    /**
     * PDF generation (Generación del PDF)
     * @param evt button event (evento del botón).
     */
    private void jButtonViewPdfActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // PDF generation (Generación del PDF)
        utilJTableToPdf(jTableFicheros, new File("pdfJTable.pdf"), getTitle() + " (Código Xules)");
    }                                              
 
     
    /**
     * Test our code.
     * Probamos nuestro código.
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameJTableFilesToPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameJTableFilesToPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameJTableFilesToPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameJTableFilesToPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameJTableFilesToPdf("/home/xules/codigoxules").setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonViewPdf;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JPanel jPanelFicheros;
    private javax.swing.JScrollPane jScrollPaneFicheros;
    private javax.swing.JTable jTableFicheros;
    private javax.swing.JTextField jTextFieldRuta;
    // End of variables declaration                   
}
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JTable2Pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTable2Pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTable2Pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTable2Pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTable2Pdf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
