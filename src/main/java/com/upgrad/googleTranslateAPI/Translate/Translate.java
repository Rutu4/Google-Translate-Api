package com.upgrad.googleTranslateAPI.Translate;



import com.upgrad.googleTranslateAPI.GoogleAPIException;


    public interface Translate {



        Translate DEFAULT = new TranslateV2();



        String execute(String text, Language from, Language to) throws GoogleAPIException;


        String[] execute(String[] text, Language from, Language to) throws GoogleAPIException;


        String[] execute(String text, Language from, Language[] to) throws GoogleAPIException;


        String[] execute(String[] text, Language from[], Language[] to) throws GoogleAPIException;
    }

}

