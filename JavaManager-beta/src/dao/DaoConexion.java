/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSqlite1;


/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class DaoConexion {
        public DaoConexion(){
            super();	
		ConexionSqlite1.establecerPropiedadesConexion("bdconfig", "jdbc.driver", "jdbc.url", "jdbc.nombrebd", "jdbc.usuario", "jdbc.password");

                
}
    
}
