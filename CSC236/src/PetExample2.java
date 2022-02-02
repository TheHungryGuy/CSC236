public class PetExample2
{
   private String name,ownerName,species,breed;
   private double age,weight ;
  
   public void Pet()
   {
      
   }
   public void Pet(String name,String owner,String spe,String breed,double age,double wght)
   {
       this.name=name;
       this.ownerName=owner;
       this.species=spe;
       this.breed=breed;
       this.age=age;
       this.weight=wght;
   }
   
	public boolean isSpecies(String parm) {  //to return true or false if the species match
		return this.species.equals(parm);
	}
   
   @Override
   public String toString()
   {
       String str="";
       str+="Name: "+name;
       str+="\nOwner Name: "+ownerName;
       str+="\nSpecies: "+species;
       str+="\nBreed: "+breed;
       str+="\nAge: "+age;
       str+="\nWeight: "+weight+"\n";
       return str;
   }
}