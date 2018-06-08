
package com.yla.util.oxford.model;

import java.util.HashMap;
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
    "entry_id",
    "sense_id"
})
public class ThesaurusLink {

    @JsonProperty("entry_id")
    private String entryId;
    @JsonProperty("sense_id")
    private String senseId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entry_id")
    public String getEntryId() {
        return entryId;
    }

    @JsonProperty("entry_id")
    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    @JsonProperty("sense_id")
    public String getSenseId() {
        return senseId;
    }

    @JsonProperty("sense_id")
    public void setSenseId(String senseId) {
        this.senseId = senseId;
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
        return new ToStringBuilder(this).append("entryId", entryId).append("senseId", senseId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(senseId).append(additionalProperties).append(entryId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ThesaurusLink) == false) {
            return false;
        }
        ThesaurusLink rhs = ((ThesaurusLink) other);
        return new EqualsBuilder().append(senseId, rhs.senseId).append(additionalProperties, rhs.additionalProperties).append(entryId, rhs.entryId).isEquals();
    }

}
