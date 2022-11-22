package com.sakayta.komsai.Repository;

import com.sakayta.komsai.Entity.PassengerEntity;

public interface PassengerRepository {
	PassengerEntity findByUserName(String userN);
	PassengerEntity findById(int passId);
}
