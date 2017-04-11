
/**
 * Write a description of class CarLP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarLP extends Car
{
    private String licencePlate;
    public static final String DEFAULT_LP = "NONAME";
    
    public CarLP (int startD, double startT, String lp) {
        super(startD, startT);       
        setLicencePlate(lp);
        
    }
    
    private void setLicencePlate (String licenceP) {
        if ( licenceP == null || licenceP == "" ) 
             this.licencePlate = DEFAULT_LP;
        else this.licencePlate = licenceP;      
    }
    
    public String getLicencePlate() {
        return licencePlate;
    }
    
    public String toString() {
        String s = super.toString();
        //return s + ";" + getLicencePlate();
        return s;
    }
}
