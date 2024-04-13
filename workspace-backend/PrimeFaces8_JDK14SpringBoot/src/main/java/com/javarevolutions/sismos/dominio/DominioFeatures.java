/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.sismos.dominio;

import java.io.Serializable;

/**
 *
 * @author JavaRevolutions
 */
public class DominioFeatures implements Serializable {
    private String type;
    private DominioProperties properties;
    private DominioGeometry geometry;
    private String id;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the properties
     */
    public DominioProperties getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(DominioProperties properties) {
        this.properties = properties;
    }

    /**
     * @return the geometry
     */
    public DominioGeometry getGeometry() {
        return geometry;
    }

    /**
     * @param geometry the geometry to set
     */
    public void setGeometry(DominioGeometry geometry) {
        this.geometry = geometry;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
