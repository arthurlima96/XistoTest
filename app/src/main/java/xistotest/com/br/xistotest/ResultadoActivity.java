package xistotest.com.br.xistotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by Arthur C. Lima on 15/04/2017.
 */

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultado);

        Intent quiz = getIntent();

        Bundle bundle = quiz.getExtras();

        double resultado = bundle.getInt("res");

        TextView res = (TextView)findViewById(R.id.txtResultado);

        res.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL);
        res.setText("A probabilidade de haver esquistossomose na sua região é de : "+resultado+"%");
    }
}
