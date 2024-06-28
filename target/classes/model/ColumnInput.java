/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.swing.*;

/**
 *
 * @author devminnthu
 */

public class ColumnInput {

    private String columnName;
    private String dataType;
    private boolean isNullable;
    private boolean isPrimaryKey;

    private JTextField textField;
    private JComboBox<String> selectBox;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public ColumnInput(String columnName, String dataType, boolean isNullable, boolean isPrimaryKey) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.isNullable = isNullable;
        this.isPrimaryKey = isPrimaryKey;
    }

    public ColumnInput(JTextField textField, JComboBox<String> selectBox, JCheckBox checkBox1, JCheckBox checkBox2) {
        this.textField = textField;
        this.selectBox = selectBox;
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
    }

    // Getters for UI components
    public JTextField getTextField() {
        return textField;
    }

    public JComboBox<String> getSelectBox() {
        return selectBox;
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public JCheckBox getCheckBox2() {
        return checkBox2;
    }

    // Getters and setters for data fields
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public void setNullable(boolean isNullable) {
        this.isNullable = isNullable;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }
}
