/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * 
 *
 */
public class MConserje {
    private ArrayList<MMemento> estados = new ArrayList();
    
    public void AddMemento(MMemento a)
    {
        estados.add(a);
    }
    
    public MMemento GetMemento(int index)
    {
        return estados.get(index);
    }

    public MConserje() {
    }

    public ArrayList<MMemento> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<MMemento> estados) {
        this.estados = estados;
    }
    
    
}
