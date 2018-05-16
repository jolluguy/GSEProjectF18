package DataPersistence;

import Acquaintance.ICaseNote;

public class DataCaseNote implements ICaseNote {
    private String note;
    private int noteID;
    private String author;

    
    DataCaseNote(String note, String caseworkerID, int noteID) {
        this.note = note;
        this.author = caseworkerID;
        this.noteID = noteID;
    }
    
    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public int getNoteID() {
        return this.noteID;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
}