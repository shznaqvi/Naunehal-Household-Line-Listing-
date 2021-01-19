package edu.aku.hassannaqvi.naunehal_listing.models;

import java.util.HashMap;
import java.util.Map;


public class Districts {

    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String distId;
    private String district;
    private String province;

    /**
     * No args constructor for use in serialization
     */
    public Districts() {
    }

    /**
     * @param distId
     * @param province
     * @param district
     */
    public Districts(String distId, String district, String province) {
        super();
        this.distId = distId;
        this.district = district;
        this.province = province;
    }

    public String getDistId() {
        return distId;
    }

    public void setDistId(String distId) {
        this.distId = distId;
    }

    public Districts withDistId(String distId) {
        this.distId = distId;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Districts withDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Districts withProvince(String province) {
        this.province = province;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Districts withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


}
