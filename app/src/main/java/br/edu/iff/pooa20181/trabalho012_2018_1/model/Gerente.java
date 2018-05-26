package br.edu.iff.pooa20181.trabalho012_2018_1.model;

public class Gerente extends Funcionario {

    public Gerente(int nHoras, int nfaltas, int nFilhos){
        super(nHoras,nfaltas,nFilhos);
        this.setSalarioBase(2000);
    }



}
