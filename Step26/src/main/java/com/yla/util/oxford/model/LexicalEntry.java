
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
    "entries",
    "language",
    "lexicalCategory",
    "pronunciations",
    "text"
})
public class LexicalEntry {

    @JsonProperty("entries")
    private List<Entry> entries = null;
    @JsonProperty("language")
    private String language;
    @JsonProperty("lexicalCategory")
    private String lexicalCategory;
    @JsonProperty("pronunciations")
    private List<Pronunciation> pronunciations = null;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entries")
    public List<Entry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("lexicalCategory")
    public String getLexicalCategory() {
        return lexicalCategory;
    }

    @JsonProperty("lexicalCategory")
    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    @JsonProperty("pronunciations")
    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
        return new ToStringBuilder(this).append("entries", entries).append("language", language).append("lexicalCategory", lexicalCategory).append("pronunciations", pronunciations).append("text", text).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pronunciations).append(text).append(additionalProperties).append(entries).append(language).append(lexicalCategory).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LexicalEntry) == false) {
            return false;
        }
        LexicalEntry rhs = ((LexicalEntry) other);
        return new EqualsBuilder().append(pronunciations, rhs.pronunciations).append(text, rhs.text).append(additionalProperties, rhs.additionalProperties).append(entries, rhs.entries).append(language, rhs.language).append(lexicalCategory, rhs.lexicalCategory).isEquals();
    }

}
