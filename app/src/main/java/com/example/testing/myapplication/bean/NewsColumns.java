package com.example.testing.myapplication.bean;

import java.util.List;

/**
 * author: baiiu
 * date: on 16/5/16 19:17
 * description:
 */
public class NewsColumns {
  public int code;
  public String msg;
  public NewsColumnsData data;

  public class NewsColumnsData {
    public List<Column> column;

    public class Column {
      public String id;
      public String name;

      @Override public String toString() {
        return id + " ," + name;
      }
    }
  }
}
