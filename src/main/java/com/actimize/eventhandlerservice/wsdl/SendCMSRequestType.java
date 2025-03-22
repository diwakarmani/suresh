
package com.actimize.eventhandlerservice.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendCMSRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendCMSRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CMSData" type="{http://efe-7papps001.dev.mtb.com}CMSData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendCMSRequestType", propOrder = {
    "cmsData"
})
public class SendCMSRequestType {

    @XmlElement(name = "CMSData", required = true)
    protected CMSData cmsData;

    /**
     * Gets the value of the cmsData property.
     * 
     * @return
     *     possible object is
     *     {@link CMSData }
     *     
     */
    public CMSData getCMSData() {
        return cmsData;
    }

    /**
     * Sets the value of the cmsData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CMSData }
     *     
     */
    public void setCMSData(CMSData value) {
        this.cmsData = value;
    }

}
