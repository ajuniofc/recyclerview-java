package br.com.ajuniofc.recyclerviewjava.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Calendar;

import br.com.ajuniofc.recyclerviewjava.R;
import br.com.ajuniofc.recyclerviewjava.dao.TaskDAO;
import br.com.ajuniofc.recyclerviewjava.model.Task;
import br.com.ajuniofc.recyclerviewjava.ui.adapter.TaskListAdapter;

public class TaskListActivity extends AppCompatActivity {
    private ListView listView;
    private TaskDAO dao;
    private TaskListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        listView = findViewById(R.id.task_list_list);
        dao.insert(new Task("Tarefa 1", "Descricao da primeira tarefa", Calendar.getInstance()));
        adapter = new TaskListAdapter(this, dao.findAll());
        listView.setAdapter(adapter);
    }
}
