package sg.edu.rp.c346.id20008189.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd;
    Button btnClear;
    ListView lvTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=findViewById(R.id.btnAdd);
        btnClear=findViewById(R.id.btnClear);
        etTask=findViewById(R.id.etTask);
        lvTask=findViewById(R.id.lvTask);
        ArrayList<String> alTask = new ArrayList<String>( );
        ArrayAdapter<String> aaTask=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTask);
        lvTask.setAdapter(aaTask);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                alTask.add(task);
                aaTask.notifyDataSetChanged();
            }
        });
        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String task= alTask.get(position);
                Toast.makeText(MainActivity.this, task+" is selected", Toast.LENGTH_SHORT).show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTask.clear();
                aaTask.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Tasks has been cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}