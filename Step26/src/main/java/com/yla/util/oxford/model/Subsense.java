
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
    "definitions",
    "domains",
    "examples",
    "id",
    "short_definitions",
    "registers",
    "notes"
})
public class Subsense {

    @JsonProperty("definitions")
    private List<String> definitions = null;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("examples")
    private List<Example__> examples = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("short_definitions")
    private List<String> shortDefinitions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("notes")
    private List<Note> notes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("definitions")
    public List<String> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("examples")
    public List<Example__> getExamples() {
        return examples;
    }

    @JsonProperty("examples")
    public void setExamples(List<Example__> examples) {
        this.examples = examples;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("short_definitions")
    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    @JsonProperty("short_definitions")
    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    @JsonProperty("registers")
    public List<String> getRegisters() {
        return registers;
    }

    @JsonProperty("registers")
    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
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
        return new ToStringBuilder(this).append("definitions", definitions).append("domains", domains).append("examples", examples).append("id", id).append("shortDefinitions", shortDefinitions).append("registers", registers).append("notes", notes).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(shortDefinitions).append(id).append(additionalProperties).append(registers).append(domains).append(definitions).append(notes).append(examples).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subsense) == false) {
            return false;
        }
        Subsense rhs = ((Subsense) other);
        return new EqualsBuilder().append(shortDefinitions, rhs.shortDefinitions).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(registers, rhs.registers).append(domains, rhs.domains).append(definitions, rhs.definitions).append(notes, rhs.notes).append(examples, rhs.examples).isEquals();
    }

}
