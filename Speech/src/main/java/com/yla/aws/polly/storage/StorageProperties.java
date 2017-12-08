package com.yla.aws.polly.storage;

import org.springframework.stereotype.Repository;

//import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties("storage")
@Repository
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}