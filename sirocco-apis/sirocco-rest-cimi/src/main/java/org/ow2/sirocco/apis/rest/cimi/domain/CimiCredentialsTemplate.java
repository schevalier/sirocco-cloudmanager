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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.ow2.sirocco.apis.rest.cimi.validator.GroupWrite;
import org.ow2.sirocco.apis.rest.cimi.validator.constraints.NotEmptyIfNotNull;

/**
 * Class CredentialsTemplate.
 * <p>
 * </p>
 */
@XmlRootElement(name = "CredentialsTemplate")
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiCredentialsTemplate extends CimiCommonId {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    /** The initial superuser's user name. */
    private String userName;

    /** Initial superuser's password. */
    private String password;

    /** The digit of the public key for the initial superuser. */
    @NotEmptyIfNotNull(groups = {GroupWrite.class})
    private byte[] key;

    /**
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Return the value of field "key".
     * 
     * @return The value
     */
    @XmlElement
    public byte[] getKey() {
        return this.key;
    }

    /**
     * Set the value of field "key".
     * 
     * @param key The value
     */
    public void setKey(final byte[] key) {
        this.key = key;
    }
}
