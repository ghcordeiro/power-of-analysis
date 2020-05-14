package br.unipar.powerofanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getParams();
    }

    @SuppressLint("SetTextI18n")
    public void getParams() {
        Bundle b = getIntent().getExtras();
        double lucroLiquido = 0;
        double patrimonioLiquido = 0;
        long numeroAcoes = 0;
        double precoAtual = 0;
        TextView ativo = findViewById(R.id.acaoResult);
        TextView txtlpa = findViewById(R.id.lpaResult);
        TextView txtpl = findViewById(R.id.plResult);
        TextView txtroe = findViewById(R.id.roeResult);
        TextView txtvpa = findViewById(R.id.vpaResult);
        TextView txtpv = findViewById(R.id.pvResult);

        Calculations calculations;
        if(b != null){
            ativo.setText(b.getString("ativo"));
            lucroLiquido = b.getDouble("lucroLiquido");
            patrimonioLiquido = b.getDouble("patrimonioLiquido");
            numeroAcoes = b.getLong("numeroAcoes");
            precoAtual = b.getDouble("precoAtual");


            calculations = new Calculations(b.getString("ativo"), lucroLiquido, patrimonioLiquido, numeroAcoes, precoAtual);

            txtlpa.setText(calculations.getLPA());
            txtpl.setText(calculations.getPL());
            txtroe.setText(calculations.getROE());
            txtvpa.setText(calculations.getVPA());
            txtpv.setText(calculations.getPV());
        }



    }
}
