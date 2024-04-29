package com.afflorezc.util;

public class HtmlFormatting {

    public static String wrapInParragraph(String text){

        return "<p> " + text + " </p>";
    }

    public static  String asHtml(String text){

        return "<html> "+ text + " </html>";
    }

}
