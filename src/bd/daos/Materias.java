package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe Materias representa todos as mat�rias de uma Tabela no DB.
Tem como m�todos select's.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Materias
{
	 /**
	 M�todo que retorna uma mat�ria.
	 * @param codigo � o c�digo do monitor representante daquela mat�ria
	 * @return o objeto da classe Mat�ria do respectivo c�digo
	 * @throws Exception se a mat�ria n�o estiver cadastrado, ou problemas no DB
	 */
    public static Materia getMateria (int codigo) throws Exception
    {
        Materia materia = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS " +
                  "WHERE CODMONITOR = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            System.out.println(codigo);
            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            materia = new Materia (resultado.getInt   ("CODMATERIA"),
                               resultado.getInt("CODMONITOR"),
                               resultado.getString ("NOME"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar mat�ria");
        }

        return materia;
    }

    /**
	 M�todo que retorna todas as mat�rias
	 * @return o dicion�rio contento todas as mat�rias
	 * @throws Exception se houver problemas no DB
	 */
    public static MeuResultSet getMaterias () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar mat�rias");
        }

        return resultado;
    }
}