/**
 *
 * SIROCCO
 * Copyright (C) 2011 France Telecom
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * $Id$
 *
 */
package org.ow2.sirocco.apis.rest.cimi.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Class MachineTemplate.
 * <p>
 * </p>
 */
@XmlRootElement(name = "MachineTemplate")
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiMachineTemplate extends CimiCommonId {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    // ---------------------------------------- Fields

    /**
     * Field "machineConfig".
     * <p>
     * </p>
     */
    private CimiMachineConfiguration machineConfig;

    /**
     * Field "machineImage".
     * <p>
     * </p>
     */
    private CimiMachineImage machineImage;

    /**
     * Field "Credentials".
     * <p>
     * </p>
     */
    private CimiCredentials credentials;

    /**
     * Field "volumes".
     * <p>
     * </p>
     */
    private CimiVolumeMachine[] volumes;

    /**
     * Field "volumeTemplates".
     * <p>
     * </p>
     */
    private CimiVolumeMachineTemplate[] volumeTemplates;

    /**
     * Field "networkInterfaces".
     * <p>
     * </p>
     */
    private CimiNetworkInterface[] networkInterfaces;

    // ---------------------------------------- Constructors

    /**
     * Default constructor.
     */
    public CimiMachineTemplate() {
        super();
    }

    // ---------------------------------------- ???com-accesseurs???

    /**
     * Return the value of field "machineConfig".
     * 
     * @return The value
     */
    public CimiMachineConfiguration getMachineConfig() {
        return this.machineConfig;
    }

    /**
     * Set the value of field "machineConfig".
     * 
     * @param machineConfig The value
     */
    public void setMachineConfig(final CimiMachineConfiguration machineConfig) {
        this.machineConfig = machineConfig;
    }

    /**
     * Return the value of field "machineImage".
     * 
     * @return The value
     */
    public CimiMachineImage getMachineImage() {
        return this.machineImage;
    }

    /**
     * Set the value of field "machineImage".
     * 
     * @param machineImage The value
     */
    public void setMachineImage(final CimiMachineImage machineImage) {
        this.machineImage = machineImage;
    }

    /**
     * Return the value of field "Credentials".
     * 
     * @return The value
     */
    public CimiCredentials getCredentials() {
        return this.credentials;
    }

    /**
     * Set the value of field "Credentials".
     * 
     * @param CimiCredentials The value
     */
    public void setCredentials(final CimiCredentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Return the value of field "volumes".
     * 
     * @return The value
     */
    public CimiVolumeMachine[] getVolumes() {
        return this.volumes;
    }

    /**
     * Set the value of field "volumes".
     * 
     * @param volumes The value
     */
    public void setVolumes(final CimiVolumeMachine[] volumes) {
        this.volumes = volumes;
    }

    /**
     * Return the value of field "volumeTemplates".
     * 
     * @return The value
     */
    public CimiVolumeMachineTemplate[] getVolumeTemplates() {
        return this.volumeTemplates;
    }

    /**
     * Set the value of field "volumeTemplates".
     * 
     * @param volumeTemplates The value
     */
    public void setVolumeTemplates(final CimiVolumeMachineTemplate[] volumeTemplates) {
        this.volumeTemplates = volumeTemplates;
    }

    /**
     * Return the value of field "networkInterfaces".
     * 
     * @return The value
     */
    public CimiNetworkInterface[] getNetworkInterfaces() {
        return this.networkInterfaces;
    }

    /**
     * Set the value of field "networkInterfaces".
     * 
     * @param networkInterfaces The value
     */
    public void setNetworkInterfaces(final CimiNetworkInterface[] networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

}
