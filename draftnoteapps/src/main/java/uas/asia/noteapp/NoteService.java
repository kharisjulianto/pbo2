package uas.asia.noteapp;

import uas.asia.model.Note;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class NoteService {
    private DataStorage storage;
    private List<Note> notes;

    public NoteService(DataStorage storage) {
        this.storage = storage;
        this.notes = readNotes();
    }

    public void createNote(String note) {
        storage.writeData(note);
//        notes.add(note);
    }

//    public List<String> readNotes() {
//        return storage.readData();
//    }

    public List<Note> readNotes() {
        return storage.readData();
    }


    public void deleteNote(int note) {
//        notes.remove(note);
        storage.deleteData(note);
    }

//    public int getNoteCount() {
//        return notes.size();
//    }

//    public String getNoteByIndex(int index) {
//        return notes.get(index);
//    }
}