package br.com.ajuniofc.recyclerviewjava.ui.holder;

import android.view.View;
import android.widget.TextView;

import br.com.ajuniofc.recyclerviewjava.R;
import br.com.ajuniofc.recyclerviewjava.model.Task;

/**
 * Created by JHUNIIN on 12/04/2018.
 */

public class TaskHolder {
    private final TextView title;
    private final TextView description;
    private final TextView date;

    public TaskHolder(View view){
        this.title = view.findViewById(R.id.task_item_title);
        this.description = view.findViewById(R.id.task_item_description);
        this.date = view.findViewById(R.id.task_item_date);
    }

    public void bind(Task task){
        this.title.setText(task.getTitle());
        this.description.setText(task.getDescription());
        this.date.setText(task.getStringDate());
    }
}
