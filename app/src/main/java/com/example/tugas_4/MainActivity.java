package com.example.tugas_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText name1, name2;
    private Button btnSimpan;
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<DataModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        btnSimpan = findViewById(R.id.btn_simpan);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName1 = name1.getText().toString();
                String inputName2 = name2.getText().toString();

                if (!inputName1.isEmpty() && !inputName2.isEmpty()) {
                    dataList.add(new DataModel(inputName1, inputName2));
                    adapter.notifyDataSetChanged();
                    name1.setText("");
                    name2.setText("");
                }
            }
        });
    }
}