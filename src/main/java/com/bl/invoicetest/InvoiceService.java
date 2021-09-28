package com.bl.invoicetest;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    public boolean addUser(String userId,List<Ride> rides) {
        RidesRepository ridesRepository = RidesRepository.getInstance();
        return ridesRepository.addUser(userId, rides);
    }

    public List<Ride> getRides( String userId ) throws UserNotFoundException {
        RidesRepository ridesRepository = RidesRepository.getInstance();
        if( isUserExist(userId) ) {
            return ridesRepository.getRides(userId);
        }
        else
            throw new UserNotFoundException("User not exist");
    }

    public boolean isUserExist( String userId ) {
        RidesRepository ridesRepository = RidesRepository.getInstance();
         return ridesRepository.isUserExist(  userId );
    }

    public boolean addUsersRide(String userId, Ride ride) {
        RidesRepository ridesRepository = RidesRepository.getInstance();
         return ridesRepository.addUsersRide(userId, ride);
    }
}
