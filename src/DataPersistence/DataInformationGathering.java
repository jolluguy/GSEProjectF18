/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.IInformationGathering;

/**
 *
 * @author Alexa
 */
public class DataInformationGathering implements IInformationGathering{
    
    int getInfoGahteringID;
    String getInfoGatheringDescription;

    public DataInformationGathering(int getInfoGahteringID, String getInfoGatheringDescription) {
        this.getInfoGahteringID = getInfoGahteringID;
        this.getInfoGatheringDescription = getInfoGatheringDescription;
    }

    @Override
    public int getInfoGatheringID() {
        return getInfoGahteringID;
    }

    @Override
    public String getInfoGatheringDescription() {
        return getInfoGatheringDescription;
    }
    
    
    
}
