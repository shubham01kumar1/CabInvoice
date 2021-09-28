package com.bl.invoicetest;

import java.util.*;

public class RidesRepository {

    private	static RidesRepository instance;                         //declaring class instance for making singleton class

    private HashMap< String, List<Ride> > repository = new HashMap< String, List<Ride> >();

    //make constructor private to stop making instance of class outside of this class.
    private RidesRepository(){ }

    //method to get synchronizes instance of this class
    public static synchronized RidesRepository getInstance() {
        if(instance == null) {
            instance = new RidesRepository();
        }
        return instance;
    }

    public List<Ride> getRides(String userId) throws UserNotFoundException {
        if ( isUserExist(userId) ){
            return repository.get(userId);
        }
        else
            throw new UserNotFoundException("User not exist");
    }

    public boolean isUserExist(String userID) {
        for (String key : repository.keySet()) {
          if( key.equals(userID) ) {
              return true;
          }
        }
        return false;
    }


    public boolean addUser(String userID, List<Ride> rides) {
        if( repository.containsKey(userID) == false ) {
            repository.put(userID, rides);
            return true;
        }
        else
            return false;
    }

    public boolean addUsersRide(String userId, Ride ride) {
        if( isUserExist(userId) == false ) {
            return false;
       }
        if( repository.get(userId) == null ) {
            List<Ride> rideList = Arrays.asList(ride);
            repository.put( userId, rideList);
            return true;
        }
        else {
            List<Ride> rides = new ArrayList<Ride>(repository.get(userId));
            boolean add = rides.add(ride);
            repository.put(userId, rides);
            return add;
        }
    }

}
