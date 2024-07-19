/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uas.asia.noteapp;

import uas.asia.model.Note;

import java.util.List;

/**
 *
 * @author budi
 */
public interface DataStorage {

    void writeData(String note);

//    List<String> readData();

    List<Note> readData();

    void deleteData(int note);
}
