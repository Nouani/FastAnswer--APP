package bd.daos;

import java.sql.*;
import java.util.ArrayList;

import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe Alunos representa todos os alunos de uma Tabela no DB.
Tem como m�todos select's.
@author Nouani Gabriel Sanches Pedro Go Ikeda
*/
public class Alunos
{
	/**
	 M�todo que confere se o aluno est� cadastrado
	 * @param RA � o RA do aluno que ser� procurado
	 * @return se o aluno est� cadastrado
	 * @throws Exception se ocorrer algum erro na procura
	 */
    public static boolean cadastrado (String RA) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, RA);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

            /* // ou, se preferirmos,

            String sql;

            sql = "SELECT COUNT(*) AS QUANTOS " +
                  "FROM LIVROS " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            resultado.first();

            retorno = resultado.getInt("QUANTOS") != 0;

            */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar o aluno");
        }

        return retorno;
    }
    
    /**
	 M�todo que retorna um aluno.
	 * @param RA � o RA do aluno a ser retornado
	 * @return o objeto do aluno do respectivo RA
	 * @throws Exception se o aluno n�o estiver cadastrado, ou problemas no DB
	 */
    public static Aluno getAluno (String RA) throws Exception
    {
        Aluno aluno = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, RA);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            aluno = new Aluno (resultado.getString("RA"),
                               resultado.getString("NOME"),
                               resultado.getString("SENHA"),
                               resultado.getString("ATIVIDADE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar aluno");
        }

        return aluno;
    }
    
    /**
	 M�todo que retorna todos os alunos.
	 * @return o dicion�rio contento todos os alunos
	 * @throws Exception se houver problemas no DB
	 */
    public static MeuResultSet getAlunos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar alunos");
        }

        return resultado;
    }
    
    /**
	 M�todo que retorna todos os alunos com uma determinada atividade.
	 * @param atividade � a atividade (online ou offline) dos alunos
	 * @return o dicion�rio contendo todos alunos com uma mesma atividade
	 * @throws Exception se houver problemas no DB
	 */
    public static MeuResultSet getAlunosAtividade (String atividade) throws Exception
    {
        MeuResultSet resultado = null;
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS "+
            	  "WHERE ATIVIDADE = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, atividade);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar alunos com tal atividade");
        }
        return resultado;
    }
}