package br.com.ajuniofc.recyclerviewjava.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.ajuniofc.recyclerviewjava.R;
import br.com.ajuniofc.recyclerviewjava.model.Task;
import br.com.ajuniofc.recyclerviewjava.ui.holder.TaskHolder;

public class TaskListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Task> tasks;

    public TaskListAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_item, viewGroup, false);
        TaskHolder holder = new TaskHolder(view);
        Task task = tasks.get(position);
        holder.bind(task);

        return view;
    }
}
