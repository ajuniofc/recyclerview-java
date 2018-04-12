package br.com.ajuniofc.recyclerviewjava.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.ajuniofc.recyclerviewjava.model.Task;


public class TaskDAO {

    private final static ArrayList<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return (List<Task>) tasks.clone();
    }

    public void insert(Task... tasks) {
        TaskDAO.tasks.addAll(Arrays.asList(tasks));
    }

    public void update(int position, Task task) {
        tasks.set(position, task);
    }

    public void remove(int position) {
        tasks.remove(position);
    }

    public void move(int beginPosition, int endPosition) {
        Collections.swap(tasks, beginPosition, endPosition);
    }

    public void removeAll() {
        tasks.clear();
    }
}
