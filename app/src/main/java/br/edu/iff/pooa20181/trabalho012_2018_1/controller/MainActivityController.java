package br.edu.iff.pooa20181.trabalho012_2018_1.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.RadioButton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.edu.iff.pooa20181.trabalho012_2018_1.MainActivity;
import br.edu.iff.pooa20181.trabalho012_2018_1.R;
import br.edu.iff.pooa20181.trabalho012_2018_1.model.Empregado;
import br.edu.iff.pooa20181.trabalho012_2018_1.model.Gerente;
import br.edu.iff.pooa20181.trabalho012_2018_1.model.Servente;
import br.edu.iff.pooa20181.trabalho012_2018_1.model.Supervisor;

public class MainActivityController implements View.OnClickListener {

    private MainActivity activity;
    private Context ctx;

    public MainActivityController(MainActivity activity){
        this.activity = activity;
        this.ctx = this.activity.getBaseContext();
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this.activity);
        String title = "", message = "";

        int id = this.activity.getRbGrupo().getCheckedRadioButtonId();

        if(id == -1){

            title = this.ctx.getString(R.string.dial_title_err);
            message = this.ctx.getString(R.string.dial_message_cargo_err);

        }else{

            String tHoras = this.activity.gettHoras().getText().toString().trim();
            String tFaltas = this.activity.gettFaltas().getText().toString().trim();
            String tFilhos = this.activity.getSpFilhos().getSelectedItem().toString();

            if(tHoras.equals("") || tFaltas.equals("")){

                title = this.ctx.getString(R.string.dial_title_err);
                message = this.ctx.getString(R.string.dial_message_empty_err);

            }else{

                RadioButton radioButtonSelecionado = this.activity.findViewById(id);
                String cargo = (String) radioButtonSelecionado.getText();

                int nHoras = Integer.parseInt(tHoras);
                int nFaltas = Integer.parseInt(tFaltas);
                int nFilhos = Integer.parseInt(tFilhos);

                title = this.ctx.getString(R.string.dial_title_res);

                Empregado func = null;

                /*

                Class<?> c = null;
                try {
                    c = Class.forName("br.edu.iff.pooa20181.trabalho012_2018_1.model."+cargo);
                    Constructor<?> cons = c.getConstructor();
                    func = (Empregado) cons.newInstance(nHoras,nFaltas,nFilhos);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                */


                if(cargo.equals("Gerente")){
                    func = new Gerente(nHoras,nFaltas,nFilhos);
                }else if(cargo.equals("Supervisor")){
                    func = new Supervisor(nHoras,nFaltas,nFilhos);
                }else if(cargo.equals("Servente")){
                    func = new Servente(nHoras,nFaltas,nFilhos);
                }

                func.calcular();

                message =
                "Proventos\n"+func.getProventos()+"\n"+
                "Descontos\n"+func.getDescontos()+"\n"+
                "Salário Liquido\n"+func.getSalarioLiquido();
            }

        }

        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setNeutralButton("OK",null);
        dialog.show();
    }
}
