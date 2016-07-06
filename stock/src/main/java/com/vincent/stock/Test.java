package com.vincent.stock;

import com.vincent.dao.Stock;
import com.vincent.db.MySQL;

import java.sql.ResultSet;
import java.util.List;

public class Test {

    Stock stock;

    public static List<Stock> getStockList(String stockId) throws Exception{
        String sql = "select * from sh601788 limit 10";
        ResultSet rs = MySQL.execQuery(sql);
        while (rs.next()){


        }
    }

    public static void main(String[] args) {




    }
}
