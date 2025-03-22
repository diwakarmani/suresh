
package com.actimize.eventhandlerservice.wsdl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CMSData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMSData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CARD_MAINTAINCE_TYPES" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CMS_REQUEST_PARTY_ACCOUNT" type="{http://efe-7papps001.dev.mtb.com}CMSRequestPartyAccount" maxOccurs="10" minOccurs="10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMSData", propOrder = {
    "cardmaintaincetypes",
    "cmsrequestpartyaccount"
})
public class CMSData {

    @XmlElement(name = "CARD_MAINTAINCE_TYPES", required = true)
    protected String cardmaintaincetypes;
    @XmlElement(name = "CMS_REQUEST_PARTY_ACCOUNT", required = true)
    protected List<CMSRequestPartyAccount> cmsrequestpartyaccount;

    /**
     * Gets the value of the cardmaintaincetypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDMAINTAINCETYPES() {
        return cardmaintaincetypes;
    }

    /**
     * Sets the value of the cardmaintaincetypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDMAINTAINCETYPES(String value) {
        this.cardmaintaincetypes = value;
    }

    /**
     * Gets the value of the cmsrequestpartyaccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the cmsrequestpartyaccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMSREQUESTPARTYACCOUNT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMSRequestPartyAccount }
     * 
     * 
     */
    public List<CMSRequestPartyAccount> getCMSREQUESTPARTYACCOUNT() {
        if (cmsrequestpartyaccount == null) {
            cmsrequestpartyaccount = new ArrayList<CMSRequestPartyAccount>();
        }
        return this.cmsrequestpartyaccount;
    }

}
