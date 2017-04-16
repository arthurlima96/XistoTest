package xistotest.com.br.xistotest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prevalencia = (Button)findViewById(R.id.button);


        prevalencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(form);
            }
        });
    }
}
