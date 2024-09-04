package com.example.to_dolistthegame;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.to_dolistthegame.models.ToDoItem;
import com.example.to_dolistthegame.models.TypeTask;

public class CreateToDoActivity extends AppCompatActivity {

    ToDoItem toDoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_to_do);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        createSpinner();

        findViewById(R.id.add_to_list_btn).setOnClickListener(view -> {
            //send task to API
        });
    }

    void createSpinner()
    {
        Spinner taskSpinner = findViewById(R.id.task_type_sp);
        ArrayAdapter<TypeTask> adapter =
                new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TypeTask.values());

        taskSpinner.setAdapter(adapter);

        taskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
//                toDoItem.setTypeTask(TypeTask.values()[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){}
        });
    }

}