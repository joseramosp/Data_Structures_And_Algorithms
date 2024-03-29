/*
Michael Penta
A process with a number of cycles it requres, a unique ID, and a name
A toString method is availabe 

*/
package ossimulation;

public class Process
{
   private static int NEXT_ID = 0;
   
   protected int cycles;
   protected int id;
   protected String name;
   
   public Process(String name, int time)
   {
      cycles = time;
      this.name = name;
      this.id = NEXT_ID++;
   }
   
   
   public void tick()
   {
      cycles--;
   }
   
   public void setCycles(int cycles)
   {
      this.cycles = cycles;
   }

   public int getCycles()
   {
      return cycles;
   }
   
  public void setName(String s)
   {
      name = s;
   }

   public String getName()
   {
      return name;
   }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return name+ " Process , Processes ID = " + id + "\tcycles remaining=" + cycles +'\n';
    }
    
}