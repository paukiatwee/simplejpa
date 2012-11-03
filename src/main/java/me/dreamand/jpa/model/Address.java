/**
 * 
 */
package me.dreamand.jpa.model;

import javax.persistence.Embeddable;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
@Embeddable
public class Address {
    
    protected String address1;
    protected String address2;
    protected String address3;
    protected String zip;
    protected String state;
    
    public Address() {
        
    }
    
    public Address(String address1, String address2, String address3, String zip, String state) {
        setAddress1(address1);
        setAddress2(address2);
        setAddress3(address3);
        setZip(zip);
        setState(state);
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the address3
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * @param address3 the address3 to set
     */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        if(address1 != null) {
            buffer.append(address1);
        }
        if(address2 != null) {
            buffer.append(address2);
        }
        if(address3 != null) {
            buffer.append(address3);
        }
        if(zip != null) {
            buffer.append(zip);
        }
        if(state != null) {
            buffer.append(state);
        }
        
        
        return buffer.toString();
    }
    
    
}
