package DataPersistence;

import Acquaintance.ICaseNote;

public class DataCaseNote implements ICaseNote {
    private String note;
    private int noteID;

    
    DataCaseNote(String note, int noteID) {
        this.note = note;
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
}