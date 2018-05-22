package Business;

import Acquaintance.ICaseNote;

/**
 *
 * @author Rasmus
 */
public class CaseNote implements ICaseNote {
    private String note;
    private int noteID;

    
    /**
     * for use when creating a new case, this dosent set the note id sice its given by the db
     * @param note
     * @param caseWorkerID 
     */
    CaseNote(String note){
        this.note = note;

    }

    /**
     * for use when retriving a alredy saved casenote.
     * @param note
     * @param caseWorkerID
     * @param noteID 
     */
CaseNote(String note, int noteID){
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