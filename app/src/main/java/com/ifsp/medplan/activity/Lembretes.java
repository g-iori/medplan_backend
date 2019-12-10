package com.ifsp.medplan.activity;

public class Lembretes {
    private String nome_med;
    private String dosagem_med;
    private String horario_med;
    private String adm_med;
    private String getid;
    public int tipo_med;

    public Lembretes() {
    }

    public Lembretes(String nome_med, String dosagem_med, String horario_med, String adm_med) {
        this.nome_med = nome_med;
        this.dosagem_med = dosagem_med;
        this.horario_med = horario_med;
        this.adm_med = adm_med;
        //this.tipo_med = tipo_med;
    }


    public String getNome_med() {
        return nome_med;
    }

    public String getDosagem_med() {
        return dosagem_med;
    }

    public String getHorario_med() {
        return horario_med;
    }

    public String getAdm_med() {
        return adm_med;
    }
   /* public int getTipo_med() {
        return tipo_med;
    }*/

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public void setDosagem_med(String dosagem_med) {
        this.dosagem_med = dosagem_med;
    }

    public void setHorario_med(String horario_med) {
        this.horario_med = horario_med;
    }
}
