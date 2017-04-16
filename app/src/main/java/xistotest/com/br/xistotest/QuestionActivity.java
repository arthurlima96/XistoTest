package xistotest.com.br.xistotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import xistotest.com.br.model.Pergunta;

/**
 * Created by Arthur C. Lima on 14/04/2017.
 */

public class QuestionActivity extends AppCompatActivity {
    private TextView pergunta;
    private Button  btnProx;
    private RadioGroup btnRadio;
    private RadioButton btRadio;

    private Intent intent;
    private Bundle bundle;

    private Pergunta[] q;
    private int c=0;
    private double resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        q  = new Pergunta[4];

        q[0] = new Pergunta("Na sua região existe algum centro de tratamento de esgoto ?","SIM");
        q[1] = new Pergunta("No seu bairro existem regiões ou focos de alagamentos ?","SIM");
        q[2] = new Pergunta("Você já observou algum desses moluscos próximos às regiões alagadas ?","SIM");
        q[3] = new Pergunta("As atividades que são fontes de renda na sua área, em que você mora. Envolvem rios, açudes ou lagoas tais como pecuária, pesca e agricultura ?","SIM");

        pergunta = (TextView) findViewById(R.id.txtPergunta);
        btnProx = (Button)findViewById(R.id.btnProx);
        btnRadio = (RadioGroup) findViewById(R.id.btnRadio);

        pergunta.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL);
        pergunta.setText(q[c].getPegunta());

        btnRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                btRadio = (RadioButton) group.findViewById(id);
//                if(btRadio.getText().toString().equals(q[c].getGabarito())){
//                    Toast.makeText(QuestionActivity.this,"O nome é:",Toast.LENGTH_SHORT).show();
//                }
            }
        });

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    contabilizarRes();
                    proximaPergunta();
                }catch (Exception e){
                    Toast.makeText(QuestionActivity.this,"Selecione uma resposta !",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void contabilizarRes() {
        if((btRadio.getText().toString().equals(q[c].getGabarito()))){
            resultado ++;
        }
    }

    private void proximaPergunta() {
        btnRadio.clearCheck();
        if(c != q.length-1){
            c++;
            pergunta.setText(q[c].getPegunta());
        }else{
            btnProx.setText("Finalizar");

            intent = new Intent(QuestionActivity.this,ResultadoActivity.class);
            bundle = new Bundle();

            int res = (int) ((resultado/q.length) * 100);
            bundle.putInt("res",res);
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }
    }
}
