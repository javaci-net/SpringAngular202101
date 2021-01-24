package net.javaci.rest.common;

public class SalutationResponse 
{

    private String name;
    private String salutation;
    
    public SalutationResponse() {
        
    }
    
    public SalutationResponse(String name, String salutation) {
        super();
        this.name = name;
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return salutation + " " + name;
    }

    // Json donusumu icin Getterlar gerekli
    public String getName() {
        return name;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

}
