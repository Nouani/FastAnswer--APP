package bd.dbos;

/**
A classe Aluno representa um aluno de uma tabela Alunos.
Tem como m�todos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Monitor implements Cloneable
{
    private int codMonitor;
    private String RA;
    private String atividade;
    
    /**
	Seta o c�digo do monitor.
	@param codMonitor c�digo desejado para inclus�o
	@throws Exception caso c�digo seja menor que zero
	*/
    public void setCodigo(int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Codigo nao fornecido");

        this.codMonitor = codMonitor;
    }
    
    /**
	Seta o RA do monitor.
	@param RA RA desejado para inclus�o
	@throws Exception caso RA seja nulo ou vazio
	*/
    public void setRA (String RA) throws Exception
    {
    	RA.trim();
        if (RA==null || RA.equals(""))
            throw new Exception ("RA nao fornecido");

        this.RA = RA;
    }
    
    /**
	Seta a atividade do monitor.
	@param atividade atividade desejada para inclus�o
	@throws Exception caso atividade seja nula ou vazia
	*/
    public void setAtividade (String atividade) throws Exception
    {
        if (atividade==null || atividade.trim().equals(""))
            throw new Exception ("Atividade nao fornecida");

        this.atividade = atividade;
    }
    
    /**
	Pega o c�digo do monitor
	@return c�digo do aluno
	*/
    public int getCodigo()
    {
        return this.codMonitor;
    }
    
    /**
	Pega o RA do monitor
	@return RA do monitor
	*/
    public String getRA ()
    {
        return this.RA;
    }
    
    /**
	Pega a atividade do monitor
	@return atividade do monitor
	*/
    public String getAtividade ()
    {
        return this.atividade;
    }
    
    /**
	Construtor da classe Monitor.
	Seta os atributos da classe.
	@param codMonitor c�digo do monitor
	@param RA RA do monitor
	@param atividade atividade online ou offline
	@throws Exception caso o par�metro seja nulo ou vazio
	*/
    public Monitor (int codMonitor, String RA, String atividade) throws Exception
    {
        this.setCodigo(codMonitor);
        this.setRA(RA);
        this.setAtividade(atividade);
    }
    
    /**
	Transforma e retorna a inst�ncia em formato de String
	@return string com os valores da inst�ncia
	*/
    public String toString ()
    {
        String ret="";
        
        ret+="Codigo..: "+this.codMonitor  +"\n";
        ret+="RA..: "+this.RA  +"\n";
        ret+="Atividade..: "+this.atividade  +"\n";

        return ret;
    }

    /**
	Verifica se a inst�ncia � igual a outra.
	@param obj objeto a ser comparado com a inst�ncia
	@return true se os atributos forem iguais, false se n�o forem
	*/
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Monitor))
            return false;

        Monitor monit = (Monitor)obj;

        if (this.codMonitor != monit.codMonitor)
            return false;
        
        if (this.RA.equals(monit.RA))
            return false;
        
        if (this.atividade.equals(monit.atividade))
            return false;

        return true;
    }

    /**
	Calcula e devolve o c�digo hash da inst�ncia.
	@return o c�digo hash.
	*/
    public int hashCode ()
    {
        int ret=666;
        
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.atividade.hashCode();

        return ret;
    }

    /**
   	Construtor de c�pia da classe.
   	Seta os atributos da inst�ncia com os do passado como par�metro
   	@param modelo inst�ncia a ser copiada
   	*/
    public Monitor (Monitor modelo)
    {
        this.codMonitor   = modelo.codMonitor;   // nao clono, pq nao eh clonavel
        this.RA   = modelo.RA;   // nao clono, pq nao eh clonavel
        this.atividade = modelo.atividade;
    }

    /**
	Clona a inst�ncia.
	@return a inst�ncia clonada
	*/
    public Object clone ()
    {
        Monitor ret=null;

        try
        {
            ret = new Monitor (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}