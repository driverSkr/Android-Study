package com.example.testdemo06.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testdemo06.entity.BookInfo;

import java.util.List;

/*
* 系统根据该Dao生成一个BookDaoImpl类，实现具体操作
* */
@Dao
public interface BookDao {

    //...代表可变参数，即不限制参数个数
    @Insert
    void insert(BookInfo... book);

    @Delete
    void delete(BookInfo... book);

    //删除所有书籍信息
    @Query("delete from BookInfo")
    void deleteAll();

    @Update
    int update(BookInfo... book);

    //加载所有书籍信息
    @Query("select * from BookInfo")
    List<BookInfo> queryAll();

    //根据名字加载书籍
    @Query("select * from BookInfo where name = :name order by id desc limit 1")
    BookInfo queryByName(String name);

    //根据id加载书籍
    @Query("select * from BookInfo where id = :id order by id desc limit 1")
    BookInfo queryById(String id);
}
