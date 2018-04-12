package br.com.ajuniofc.recyclerviewjava.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task {

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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.date.getTime());
    }
}