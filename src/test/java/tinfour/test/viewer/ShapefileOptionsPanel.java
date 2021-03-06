/* --------------------------------------------------------------------
 * Copyright 2016 Gary W. Lucas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ---------------------------------------------------------------------
 */

/*
 * -----------------------------------------------------------------------
 *
 * Revision History:
 * Date     Name         Description
 * ------   ---------    -------------------------------------------------
 * 11/2018  G. Lucas     Created
 *
 * Notes:
 *
 * -----------------------------------------------------------------------
 */
package tinfour.test.viewer;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import tinfour.test.shapefile.DbfField;
import tinfour.test.shapefile.DbfFileReader;
import tinfour.test.shapefile.ShapefileReader;
import tinfour.test.shapefile.ShapefileType;

/**
 *
 */
@SuppressWarnings("PMD")  // due to non-compliant, automatically generated code
public class ShapefileOptionsPanel extends javax.swing.JPanel {

  private ActionListener okActionListener;
  /**
   * Creates new form DataViewerShapefileUI
   */
  public ShapefileOptionsPanel() {
    initComponents();
  }

  /**
   * Applies the Shapefile metadata to the UI.
   * @param reader a valid ShapefileReader
   */
  void applyShapefile(ShapefileReader reader){
    List<String>fList = new ArrayList<>();
    try(DbfFileReader dbfFile = reader.getDbfFileReader()){
       List<DbfField> list = dbfFile.getFields();
       for(DbfField field: list){
         if(field.isNumeric()){
           fList.add(field.getName());
         }
       }
    }catch(IOException ioex){
      fList.clear();
    }
    
    DefaultComboBoxModel<String> model;
    String []s;
    if(fList.size()>0){
      s = fList.toArray(new String[fList.size()]);
        metadataRadioButton.setEnabled(true);
    }else{
      s = new String[1];
      s[0]="Not applicable";
        metadataRadioButton.setEnabled(false);
        metadataComboBox.setEnabled(false);
    }
     model = new DefaultComboBoxModel<>(s);
     metadataComboBox.setModel(model);  
     
     ShapefileType sfType = reader.getShapefileType();
     String description;
     String name = reader.getFile().getName();
     if(sfType.is3D()){
       description = name+" has a 3D geometry";
     }else{
       description = name+" has a 2D geometry";
     }
     this.fileDescriptionLabel.setText(description);
    
  }
    private void hideDialog() {
    Component c = this;
    do {
      c = c.getParent();
    } while (!(c instanceof JDialog));
    JDialog jd = (JDialog) c;
    jd.setVisible(false);
  }
    
   void setOkActionListener(ActionListener listener){
    this.okActionListener = listener;
  }
  
   String getMetadataSelection(){
    if(this.metadataRadioButton.isSelected()){
       Object s = metadataComboBox.getSelectedItem();
       if(s instanceof String){
         return (String)s;
       }
    }
    return null;
  }
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    zCoordinateSourceButtonGroup = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    shapefileGeometryRadioButton = new javax.swing.JRadioButton();
    metadataRadioButton = new javax.swing.JRadioButton();
    metadataComboBox = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    fileDescriptionLabel = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    cancelButton = new javax.swing.JButton();
    okButton = new javax.swing.JButton();

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Shapefile z-coordinate options"));

    zCoordinateSourceButtonGroup.add(shapefileGeometryRadioButton);
    shapefileGeometryRadioButton.setSelected(true);
    shapefileGeometryRadioButton.setText("Use Shapefile Geometry");

    zCoordinateSourceButtonGroup.add(metadataRadioButton);
    metadataRadioButton.setText("Use Metadata Element (from DBF file)");
    metadataRadioButton.setToolTipText("Use Z coordinate from Shapefile (if available)");

    metadataComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    metadataComboBox.setToolTipText("Select element from metadata");
    metadataComboBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        metadataComboBoxActionPerformed(evt);
      }
    });

    jLabel2.setText("Metadata Fields:");

    jLabel3.setText("If a Shapefile includes 3D coordinates, it can be used to specify Z values.");

    jLabel4.setText("If the associated metadata includes numeric fields, they can be used for Z coordinates.");

    jLabel5.setText("If the geometry option is used for 2D Shapefiles, all Z values will be set to zero.");

    fileDescriptionLabel.setText("Filename is a 2D file.");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(metadataRadioButton)
          .addComponent(shapefileGeometryRadioButton))
        .addGap(0, 0, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(fileDescriptionLabel)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(21, 21, 21)
              .addComponent(jLabel2)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(metadataComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3)
            .addComponent(jLabel4)
            .addComponent(jLabel5))
          .addContainerGap(15, Short.MAX_VALUE)))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(shapefileGeometryRadioButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(metadataRadioButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
        .addComponent(fileDescriptionLabel)
        .addGap(72, 72, 72))
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addGap(63, 63, 63)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(metadataComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
          .addComponent(jLabel3)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(jLabel5)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(jLabel4)
          .addContainerGap()))
    );

    cancelButton.setText("Cancel");
    cancelButton.setToolTipText("Click to cancel selections");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    okButton.setText("OK");
    okButton.setToolTipText("Click to apply selections");
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(309, Short.MAX_VALUE)
        .addComponent(okButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cancelButton)
        .addContainerGap())
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton)
          .addComponent(okButton))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    hideDialog();
    if(okActionListener!=null){
      okActionListener.actionPerformed(evt);
    }
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
   hideDialog();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void metadataComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metadataComboBoxActionPerformed
     metadataRadioButton.setSelected(true);    
  }//GEN-LAST:event_metadataComboBoxActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel fileDescriptionLabel;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JComboBox<String> metadataComboBox;
  private javax.swing.JRadioButton metadataRadioButton;
  private javax.swing.JButton okButton;
  private javax.swing.JRadioButton shapefileGeometryRadioButton;
  private javax.swing.ButtonGroup zCoordinateSourceButtonGroup;
  // End of variables declaration//GEN-END:variables
}
