package br.edu.iff.pooa20181.trabalho012_2018_1.model;

public class Supervisor extends Funcionario {

    public Supervisor(int nHoras, int nfaltas, int nFilhos){
        super(nHoras,nfaltas,nFilhos);
        this.setSalarioBase(900);
    }

}
