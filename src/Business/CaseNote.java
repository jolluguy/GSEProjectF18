/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseNote;

/**
 *
 * @author Rasmus
 */
public class CaseNote implements ICaseNote {
    private String note;
    private int noteID;
    private String author;
    
    /**
     * for use when creating a new case, this dosent set the note id sice its given by the db
     * @param note
     * @param caseWorkerID 
     */
    CaseNote(String note, String caseWorkerID){
        this.note = note;
        this.author = caseWorkerID;
    }

    /**
     * for use when retriving a alredy saved casenote.
     * @param note
     * @param caseWorkerID
     * @param noteID 
     */
CaseNote(String note, String caseWorkerID, int noteID){
        this.note = note;
        this.author = caseWorkerID;
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
