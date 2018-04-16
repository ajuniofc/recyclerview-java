package br.com.ajuniofc.recyclerviewjava.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.Calendar;

import br.com.ajuniofc.recyclerviewjava.R;
import br.com.ajuniofc.recyclerviewjava.dao.TaskDAO;
import br.com.ajuniofc.recyclerviewjava.model.Task;
import br.com.ajuniofc.recyclerviewjava.util.CalendarUtil;

public class FormTaskActivity extends AppCompatActivity {
    private EditText edtTitle, edtDescription, edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_task);
        edtTitle = findViewById(R.id.form_task_title);
        edtDescription = findViewById(R.id.form_task_description);
        edtDate = findViewById(R.id.form_task_date);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_task_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.form_task_menu_save:
                if(isFormValid()){
                    String title = edtTitle.getText().toString();
                    String description = edtDescription.getText().toString();
                    Calendar calendar = CalendarUtil.parseToCalendar(edtDate.getText().toString());
                    Task task = new Task(title, description, calendar);
                    Intent intent = new Intent();
                    intent.putExtra(TaskListActivity.TASK_KEY, task);
                    setResult(RESULT_OK, intent);
                    finish();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isFormValid() {
        if (!isFieldValid(edtTitle, 1)){
            edtTitle.setError(getResources().getString(R.string.invalid_field));
            return false;
        }
        return true;
    }

    private boolean isFieldValid(EditText field, int min) {
        String stringField = field.getText().toString();
        if ((stringField != null || !stringField.isEmpty()) && stringField.length() >= min) {
            return true;
        }
        return false;
    }
}
