
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
    "subsenses",
    "thesaurusLinks",
    "regions"
})
public class Sense {

    @JsonProperty("definitions")
    private List<String> definitions = null;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("examples")
    private List<Example_> examples = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("short_definitions")
    private List<String> shortDefinitions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("subsenses")
    private List<Subsense> subsenses = null;
    @JsonProperty("thesaurusLinks")
    private List<ThesaurusLink> thesaurusLinks = null;
    @JsonProperty("regions")
    private List<String> regions = null;
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
    public List<Example_> getExamples() {
        return examples;
    }

    @JsonProperty("examples")
    public void setExamples(List<Example_> examples) {
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

    @JsonProperty("subsenses")
    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    @JsonProperty("subsenses")
    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    @JsonProperty("thesaurusLinks")
    public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    @JsonProperty("thesaurusLinks")
    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    @JsonProperty("regions")
    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty("regions")
    public void setRegions(List<String> regions) {
        this.regions = regions;
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
        return new ToStringBuilder(this).append("definitions", definitions).append("domains", domains).append("examples", examples).append("id", id).append("shortDefinitions", shortDefinitions).append("registers", registers).append("subsenses", subsenses).append("thesaurusLinks", thesaurusLinks).append("regions", regions).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(shortDefinitions).append(id).append(additionalProperties).append(registers).append(domains).append(definitions).append(regions).append(thesaurusLinks).append(subsenses).append(examples).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sense) == false) {
            return false;
        }
        Sense rhs = ((Sense) other);
        return new EqualsBuilder().append(shortDefinitions, rhs.shortDefinitions).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(registers, rhs.registers).append(domains, rhs.domains).append(definitions, rhs.definitions).append(regions, rhs.regions).append(thesaurusLinks, rhs.thesaurusLinks).append(subsenses, rhs.subsenses).append(examples, rhs.examples).isEquals();
    }

}
