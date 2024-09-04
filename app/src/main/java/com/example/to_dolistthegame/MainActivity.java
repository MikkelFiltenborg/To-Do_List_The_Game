package com.example.to_dolistthegame;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.to_dolistthegame.models.ToDoItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private ArrayList<String> ToDoListStrings;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        requestQueue = Volley.newRequestQueue(this);

        getToDoItems();

//        ArrayAdapter<String>adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                ToDoListStrings);

//        newToDoList.setAdapter(adapter);

//        List<String> toDoList = new ArrayList<>();
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");
//        toDoList.add("");

//        List<String> selectedItems = toDoList.subList(0, 4);
//
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        findViewById(R.id.new_todo_btn).setOnClickListener(view ->
        {
            Intent intent = new Intent(getApplicationContext(), CreateToDoActivity.class);
            startActivity(intent);
        });
    }

    void getToDoItems()
    {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "http://192.168.0.151:8080/toDoItem",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Type listType = new TypeToken<List<ToDoItem>>() {}.getType();
                        List<ToDoItem> toDoItem = new Gson().fromJson(response, listType);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("****** VOLLEY ******", "onErrorResponse", error);
                    }
                });
        requestQueue.add(request);
    }

    void createToDoItem()
    {
        ToDoItem toDoItem = new ToDoItem();

        Map<String, String> params = new HashMap<String, String>();
        params.put("todo", new Gson().toJson(toDoItem));

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                "http://192.168.0.151:8080/toDoItem",
                new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
    }
}