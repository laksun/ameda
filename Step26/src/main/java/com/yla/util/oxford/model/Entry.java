
package com.yla.util.oxford.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "etymologies",
    "grammaticalFeatures",
    "homographNumber",
    "senses"
})
public class Entry {

    @JsonProperty("etymologies")
    private List<String> etymologies = null;
    @JsonProperty("grammaticalFeatures")
    private List<GrammaticalFeature> grammaticalFeatures = null;
    @JsonProperty("homographNumber")
    private String homographNumber;
    @JsonProperty("senses")
    private List<Sense> senses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("etymologies")
    public List<String> getEtymologies() {
        return etymologies;
    }

    @JsonProperty("etymologies")
    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    @JsonProperty("grammaticalFeatures")
    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    @JsonProperty("homographNumber")
    public String getHomographNumber() {
        return homographNumber;
    }

    @JsonProperty("homographNumber")
    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    @JsonProperty("senses")
    public List<Sense> getSenses() {
        return senses;
    }

    @JsonProperty("senses")
    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("etymologies", etymologies).append("grammaticalFeatures", grammaticalFeatures).append("homographNumber", homographNumber).append("senses", senses).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(grammaticalFeatures).append(etymologies).append(additionalProperties).append(senses).append(homographNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Entry) == false) {
            return false;
        }
        Entry rhs = ((Entry) other);
        return new EqualsBuilder().append(grammaticalFeatures, rhs.grammaticalFeatures).append(etymologies, rhs.etymologies).append(additionalProperties, rhs.additionalProperties).append(senses, rhs.senses).append(homographNumber, rhs.homographNumber).isEquals();
    }

}
