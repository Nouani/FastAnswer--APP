package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe MensagensAlunos representa todas as mensagens enviadas pelos alunos de uma Tabela no DB.
Tem como m�todos select's e update.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class MensagensAlunos
{
	/**
	 M�todo que confere se a mensagem est� cadastrada
	 * @param RA � o RA do aluno com mensagem a ser procurada
	 * @return se a mensagem est� cadastrada ou n�o
	 * @throws Exception se ocorrer algum erro na procura
	 */
    public static boolean cadastrado (String RA) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MENSAGENSALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, RA);

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
            throw new Exception ("Erro ao procurar a mensagem enviada do aluno");
        }

        return retorno;
    }
    
    /**
	 M�todo que altera as informa��es de uma mensagem enviada por um aluno
	 * @param mensagemAluno objeto da classe MensagemAluno que ser� alterado
	 * @throws Exception se o objeto for inv�lido ou se ocorrer erros na conex�o
	 */
    public static void alterar (MensagemAluno mensagemAluno) throws Exception
    {
        if (mensagemAluno==null)
            throw new Exception ("Mensagem do aluno n�o fornecida");

        if (!cadastrado (mensagemAluno.getRAEnvio()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE MensagensAlunos " +
            	  /*"SET RA=?, " +
                  "MensagemAluno=?, " +
                  "CodMonitor=?, " +
                  "EnvioAluno=?, " +*/
                  "SET Recebimento=? " +
                  "WHERE CodMensagemAluno = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            /*BDSQLServer.COMANDO.setString (1, mensagemAluno.getRAEnvio());
            BDSQLServer.COMANDO.setString (2, mensagemAluno.getMensagemAluno());
            BDSQLServer.COMANDO.setInt    (3, mensagemAluno.getCodMonitor());
            BDSQLServer.COMANDO.setString (4, mensagemAluno.getEnvioAluno());*/
            BDSQLServer.COMANDO.setString (1, mensagemAluno.getRecebimentoAluno());
            BDSQLServer.COMANDO.setInt    (2, mensagemAluno.getCodMensagemAluno());
            System.out.println(mensagemAluno);
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar mensagem do aluno");
        }
    }
    
    /**
	 M�todo que retorna todas as mensagens ordenados pelo campo OrdemMensagem.
	 * @return o dicion�rio contendo todas as mensagens ordenadas
	 * @throws Exception se ocorrer algum problema no DB
	 */
    public static MeuResultSet getMensagensAlunosOrdenadas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensAlunos "+
            	  "order by OrdemMensagem";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos alunos");
        }

        return resultado;
    }
    
    /**
	 M�todo que retorna todas as mensagens por um determinado RA e c�digo de monitor
	 ordenados pelo campo OrdemMensagem.
	 * @param RA � o RA do aluno com mensagens enviadas a serem procuradas
	 * @param codMonitor � o c�digo do monitor com mensagens recebidas a serem procuradas
	 * @return o dicion�rio contendo todas as mensagens de acordo com o RA e c�digo do monitor ordenadas
	 * @throws Exception se ocorrer algum problema no DB
	 */
    public static MeuResultSet getMensagensPeloRA (String RA, int codMonitor) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensAlunos "+
                  "WHERE RA = ? AND "+
                  "CodMonitor = ? "+
                  "order by OrdemMensagem";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, RA);
            BDSQLServer.COMANDO.setInt (2, codMonitor);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos alunos com tal recebimento");
        }

        return resultado;
    }
}