package br.com.ajuniofc.recyclerviewjava.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ajuniofc.recyclerviewjava.R;
import br.com.ajuniofc.recyclerviewjava.dao.TaskDAO;
import br.com.ajuniofc.recyclerviewjava.model.ListType;
import br.com.ajuniofc.recyclerviewjava.model.Task;
import br.com.ajuniofc.recyclerviewjava.ui.recyclerview.adapter.TaskListAdapter;

public class TaskListActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE = 123;
    public static final String TASK_KEY = "task";
    private RecyclerView recyclerView;
    private TaskDAO dao;
    private ImageButton addButton;
    private ListType listType;
    private TaskListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setupRecyclerView();
        setupAddButton();
    }

    private void setupAddButton() {
        addButton = findViewById(R.id.task_list_add_button);
        addButton.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.task_list);
        configRecyclerView();
    }

    private void configRecyclerView() {
        setAdapter();
        layoutManagerBy(ListType.LIST);
    }

    private void layoutManagerBy(ListType type) {
        switch (type){
            case LIST:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case GRID:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case NOTE:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }


    private void setAdapter() {
        List<Task> tasks = new TaskDAO().findAll();
        adapter = new TaskListAdapter(tasks);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.task_list_add_button:
                goToForm();
                break;
        }
    }

    private void goToForm() {
        startActivityForResult(new Intent(this, FormTaskActivity.class), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data.hasExtra(TASK_KEY)){
            Task task = (Task) data.getSerializableExtra(TASK_KEY);
            new TaskDAO().insert(task);
            adapter.add(task);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.task_list_menu_list:
                layoutManagerBy(ListType.LIST);
                break;
            case R.id.task_list_menu_grid:
                layoutManagerBy(ListType.GRID);
                break;
            case R.id.task_list_menu_note:
                layoutManagerBy(ListType.NOTE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
