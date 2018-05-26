package br.edu.iff.pooa20181.trabalho012_2018_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.edu.iff.pooa20181.trabalho012_2018_1.controller.MainActivityController;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rbGrupo;
    private RadioButton rbGerente;
    private RadioButton rbSupervisor;
    private RadioButton rbServente;
    private TextView tHoras;
    private TextView tFaltas;
    private Spinner spFilhos;
    private Button bCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(this.getString(R.string.fantasy_app_name));

        this.rbGrupo = findViewById(R.id.rbGrupo);

        this.rbGerente = findViewById(R.id.rbGerente);

        this.rbSupervisor = findViewById(R.id.rbSupervisor);
        this.rbServente = findViewById(R.id.rbServente);

        this.tHoras = findViewById(R.id.tHoras);
        this.tFaltas = findViewById(R.id.tFaltas);

        this.spFilhos = findViewById(R.id.spFilhos);

        Integer[] int_numbers = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adpt =
        new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, int_numbers);

        this.spFilhos.setAdapter(adpt);

        this.bCalcular = findViewById(R.id.bCalcular);
        this.bCalcular.setOnClickListener(new MainActivityController(this));

    }

    public TextView gettHoras() {
        return tHoras;
    }

    public TextView gettFaltas() {
        return tFaltas;
    }

    public Spinner getSpFilhos() {
        return spFilhos;
    }

    public RadioGroup getRbGrupo() {
        return rbGrupo;
    }

}

