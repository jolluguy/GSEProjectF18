/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IInformationGathering;

/**
 *
 * @author Alexa
 */
public class InformationGathering implements IInformationGathering{
    
    private int infoGatheringID;
    private String infoGatheringDescription;

    InformationGathering(int infoGatheringID, String infoGatheringDescription) {
        this.infoGatheringID = infoGatheringID;
        this.infoGatheringDescription = infoGatheringDescription;
    }

    @Override
    public int getInfoGatheringID() {
        return infoGatheringID;
    }

    @Override
    public String getInfoGatheringDescription() {
        return infoGatheringDescription;
    }
    
    
    
}
