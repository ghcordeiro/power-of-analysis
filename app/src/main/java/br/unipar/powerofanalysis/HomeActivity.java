package br.unipar.powerofanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    EditText editAtivo;
    EditText editLucroLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void btnMessageOnClick(View view) {
        editAtivo = findViewById(R.id.editAtivo);
        if (editAtivo.getText().length() == 0 && editAtivo.getText().length() < 4) {
            return;
        }

        editLucroLiquido = findViewById(R.id.editLucroLiquido);
        if (editLucroLiquido.getText().length() == 0) {
            return;
        }

        EditText editPatrimonioLiquido = findViewById(R.id.editPatrimonioLiquido);
        if (editPatrimonioLiquido.getText().length() == 0) {
            return;
        }
        double patrimonioLiquido = Double.parseDouble(String.valueOf(editPatrimonioLiquido.getText()));

        EditText editNumeroAcoes = findViewById(R.id.editNumeroAcoes);
        if (editNumeroAcoes.getText().length() == 0) {
            return;
        }
        long numeroAcoes = Long.parseLong(String.valueOf(editNumeroAcoes.getText()));

        EditText editPrecoAtual = findViewById(R.id.editPrecoAtual);
        if (editPrecoAtual.getText().length() == 0) {
            return;
        }
        double precoAtual = Double.parseDouble(String.valueOf(editPrecoAtual.getText()));

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putString("ativo", HomeActivity.this.editAtivo.getText().toString());
        b.putDouble("lucroLiquido", Double.parseDouble(HomeActivity.this.editLucroLiquido.getText().toString()));
        b.putDouble("patrimonioLiquido", patrimonioLiquido);
        b.putLong("numeroAcoes", numeroAcoes);
        b.putDouble("precoAtual", precoAtual);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}
