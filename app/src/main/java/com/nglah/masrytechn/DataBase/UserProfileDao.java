package com.nglah.masrytechn.DataBase;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nglah.masrytechn.model.UserModel;


@Dao
public interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserModel... user);

    @Update
    void update(UserModel... user);

    @Update
    void updateUserDate(UserModel userModel);

    @Query("select * from user where active = 1;")
    UserModel checkIfUserExist();

    @Query("DELETE FROM user;")
    void clear();
}
