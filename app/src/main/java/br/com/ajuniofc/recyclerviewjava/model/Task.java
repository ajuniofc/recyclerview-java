package br.com.ajuniofc.recyclerviewjava.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task implements Serializable{

    private final String title;
    private final String description;
    private final Calendar date;

    public Task(String titulo, String descricao, Calendar date) {
        this.title = titulo;
        this.description = descricao;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDate() {
        return date;
    }

    public String getStringDate(){
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.format(this.date.getTime());
        }else {
            return null;
        }
    }
}