package com.example.ccsm;

import java.util.List;

  class Currencies {
    private String base;
    private String quote;
    private String date;
    private double rates;
    private List<Currencies> list;

    Currencies() {
        
    }

    public String getBase() {
        return base;
    }

    public String getQuote() {
        return quote;
    }

    public double getRates() { return rates ; }

    public String getDate() { return date;
    }

    @Override
    public String toString() {
      return "Currencies{" +
              "base='" + base + '\'' +
              ", quote='" + quote + '\'' +
              ", date='" + date + '\'' +
              ", rates=" + rates +
              ", list=" + list +
              '}';
    }

    /*** public String getList() {

        String mDataset = null;
        for (Currencies currencies : list) {
            currencies.getBase();
            currencies.getQuote();
            currencies.getRates();

            mDataset = base + quote + rates;


        }
        return mDataset;


    }**/
    }
