package bd.dbos;

/**
A classe Materia representa uma mat�ria de uma tabela de Mat�rias.
Tem como m�todos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Materia implements Cloneable
{
    private int    codMateria;
    private int    codMonitor;
    private String nome;
    
    /**
	Seta o c�digo da materia.
	@param codMateria codigo desejado para inclus�o
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodigo (int codMateria) throws Exception
    {
        if (codMateria < 0)
            throw new Exception ("Codigo da mat�ria � inv�lido");

        this.codMateria = codMateria;
    }
    
    /**
	Seta o c�digo do monitor.
	@param codMonitor codigo desejado para inclus�o
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodMonitor(int codMonitor) throws Exception
    {
    	if (codMonitor < 0)
    		throw new Exception("Codigo do monitor � inv�lido");
    	
    	this.codMonitor = codMonitor;
    }
    
    /**
	Seta o nome da mat�ria.
	@param nome nome desejado para inclus�o
	@throws Exception caso nome seja nulo ou vazio
	*/
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.trim().equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }
    
    /**
	Pega o c�digo da mat�ria
	@return codigo da mat�ria
	*/
    public int getCodigo ()
    {
        return this.codMateria;
    }
    
    /**
	Pega o c�digo do monitor
	@return codigo do monitor
	*/
    public int getCodMonitor ()
    {
        return this.codMonitor;
    }
    
    /**
	Pega o nome da mat�ri
	@return nome da mat�ria
	*/
    public String getNome ()
    {
        return this.nome;
    }
    
    /**
	Construtor da classe Materia.
	Seta os atributos da classe.
	@param codMateria c�digo da mat�ria
	@param codMonitor c�digo do monitor
	@param nome nome da mat�ria
	@throws Exception caso o par�metro seja nulo, vazio ou menor que zero
	*/
    public Materia (int codMateria, int codMonitor,  String nome) throws Exception
    {
        this.setCodigo (codMateria);
        this.setCodMonitor(codMonitor);
        this.setNome   (nome);
    }
    
    /**
	Transforma e retorna a inst�ncia em formato de String
	@return string com os valores da inst�ncia
	*/
    public String toString ()
    {
        String ret="";

        ret+="Codigo Mat�ria: "+this.codMateria+"\n";
        ret+="Codigo Monitor: "+this.codMonitor+"\n";
        ret+="Nome..: "+this.nome  +"\n";

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

        if (!(obj instanceof Materia))
            return false;

        Materia mat = (Materia)obj;

        if (this.codMateria!=mat.codMateria)
            return false;
        
        if (this.codMonitor!=mat.codMonitor)
            return false;

        if (this.nome.equals(mat.nome))
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

        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + new Integer(this.codMonitor).hashCode();
        ret = 7*ret + this.nome.hashCode();

        return ret;
    }

    /**
	Construtor de c�pia da classe.
	Seta os atributos da inst�ncia com os do passado como par�metro
	@param modelo inst�ncia a ser copiada
	*/
    public Materia (Materia modelo)
    {
        this.codMonitor = modelo.codMonitor; // nao clono, pq nao eh objeto
        this.codMateria = modelo.codMateria; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
    }
    
    /**
	Clona a inst�ncia.
	@return a inst�ncia clonada
	*/
    public Object clone ()
    {
        Materia ret=null;

        try
        {
            ret = new Materia (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}