/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.asia.noteapp;

import uas.asia.model.Note;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author budi
 */
public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean flag = true;
        int menuInput;

        while (flag) {
            menuInput = -1;

            System.out.println("======== Note App ========");
            System.out.print("1.Tampilkan Catatan\n2.Tambah Catatan\n3.Hapus Catatan\n4.Keluar");
            System.out.print("\nMasukkan pilihan anda (1/2/3/4) : ");

            try {
                menuInput = Integer.parseInt(scanner.nextLine());

                switch (menuInput) {
                    case 1 -> {
                        showNotes();
                        continue;
                    }
                    case 2 -> {
                        addNote();
                        continue;
                    }
                    case 3 -> {
                        deleteNote();
                        continue;
                    }
                    case 4 -> {
                        System.out.println("*** Terima Kasih! ***");
                        flag = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("\n*** Masukkan input yang benar! ***\n");
                scanner.nextLine();
            }
        }
    }

    private void addNote() {
        System.out.print("\nEnter note: ");
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("\nNote disimpan: " + note);
        System.out.println();
    }

    private void showNotes() {
        List<Note> notes = noteService.readNotes();
        System.out.println("\nNote tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (Note note : notes) {
                System.out.println("   (id=" + note.getId() + ") - " + note.getDesc());
            }
        }
        System.out.println();
    }

    private void deleteNote() {
        System.out.print("\nEnter note id : ");
        try {
            int noteId = scanner.nextInt();
            noteService.deleteNote(noteId);
        } catch (Exception e) {
            System.out.println("\n*** Masukkan input yang benar! ***\n");
        }
        scanner.nextLine();
        System.out.println();
    }
}
